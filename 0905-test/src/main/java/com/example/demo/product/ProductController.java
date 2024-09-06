package com.example.demo.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path; //path = c:\shopimg
	
	@GetMapping("/add")
	public void addForm() {}
	
	
	@PostMapping("/add")	
	public String add(ProductDTO dto) { //dto : name, price, amount, f, seller
		// 1) properties에 multipart 추가 안했을 때
//		service.saveProduct(dto);
//		return "redirect:/product/list";
		
		// 2) properties에 multipart 추가했을 때
//		String fname = dto.getF().getOriginalFilename(); //getOriginalFilename : 업로드 파일의 원본 파일명 반환
//		fname = newData.getNum() + fname;
//		File newf = new File(path + "\\" + fname); //File : file에 대한 여러가지를 설정하거나 정보를 리턴하는 메소드를 갖고 있는 class
//		try {
//			dto.getF().transferTo(newf); //업로드 파일을 newf에 복사
//			dto.setImg(fname);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		service.saveProduct(dto);
//		return "redirect:/product/list";
		
		// 3) properties에 multipart 추가 + 이미지명 중복되었을 경우, 덮어쓰지 않고 저장하기 위한 처리
		ProductDTO newData = service.saveProduct(dto); //num, name, price, amount가 들어옴
		//** 이미지명 중복될 경우, 덮어쓰지 않고 저장하기 위한 처리
		String fname = dto.getF().getOriginalFilename(); //getOriginalFilename : 업로드 파일의 원본 파일명 반환
		fname = newData.getNum() + fname;
		File newf = new File(path + "\\" + fname); //File : file에 대한 여러가지를 설정하거나 정보를 리턴하는 메소드를 갖고 있는 class
		try {
			dto.getF().transferTo(newf); //업로드 파일을 newf에 복사
			newData.setImg(fname);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.saveProduct(newData);
		return "redirect:/product/list";
	}
	
	
	@RequestMapping("/list")
	public void list(Model m, HttpSession session) {
		String type = (String) session.getAttribute("type");
		String loginId = (String) session.getAttribute("loginId");
		ArrayList<ProductDTO> list = null;
		if(type.equals("판매자")) {
			list = service.getBySeller(loginId);
		} else {
			list = service.getAll();
		}
		m.addAttribute("list", service.getAll());
	}
	
	@GetMapping("/read-img")
	public ResponseEntity<byte[]> read_img(String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + "\\" + fname);
		//응답 헤더 정보 저장 객체
		HttpHeaders header = new HttpHeaders();
		try {
			//전송하는 데이터의 MIME Type(인터넷에서 전송되는 파일이나 데이터 형식/특성을 나타내는 표준형식) 설정
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(
					 	FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping("/detail")
	public void detail(int num, Model m) {
		m.addAttribute("prod", service.getProduct(num));
	}
	
	@PostMapping("/edit-img")
	public String editImg(MultipartFile f, int num) {
		//이미지 변경할 상품을 검색해서 전체 정보를 불러옴
		ProductDTO product = service.getProduct(num);
		
		//삭제할 원본 이미지 경로를 변수에 저장
		String delFileName = path + product.getImg();
		System.out.println("delFileName:" + delFileName);
		
		//삭제할 파일의 파일 객체를 생성
		File delFile = new File(delFileName);
		
		//delete() : 파일 삭제 메서드
		delFile.delete();
		
		//새로 불러온 파일의 원파일명 저장
		String fname = f.getOriginalFilename();
		
		//중복을 막기위해 원본파일명 앞에 상품번호를 붙임
		fname = product.getNum() + fname;
		
		//서버에 복사할 새 파일 생성
		File newf = new File(path +  fname);
		try {
			//올라온 파일ㅇ의 내용을 생성한 새파일에 복사
			f.transferTo(newf); //업로드 파일을 newf에 복사
			
			//변경된 이미지 경로를 수정하여 객체에 저장
			product.setImg(fname);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} 
		//save()로 db에서 수정
		service.saveProduct(product);
		
		return "redirect:/product/detail?num=" + num;
	}
	
	@PostMapping("/edit")
	public String edit(ProductDTO dto) {
		ProductDTO pDto = service.getProduct(dto.getNum());
		pDto.setName(dto.getName());
		pDto.setPrice(dto.getPrice());
		pDto.setAmount(dto.getAmount());
		service.saveProduct(pDto);
		return "redirect:/product/list";
	}
}
