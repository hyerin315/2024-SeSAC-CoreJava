package com.example.demo.updown;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

@Controller
@RequestMapping("/upload")
public class UpController {
	
	@GetMapping("/form")
	public void uploadForm() {
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile f, String title) { //MultipartFile : 파일 업로드 API, form 파라미터와 변수 이름을 맞춰줘야함 f
		String fname = f.getOriginalFilename(); //getOriginalFilename : 업로드 파일의 원본 파일명 반환
		File newf = new File("C:\\img\\" + fname); //File : file에 대한 여러가지를 설정하거나 정보를 리턴하는 메소드를 갖고 있는 class
		try {
			f.transferTo(newf); //업로드 파일을 newf에 복사 
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("fname:" + fname);
		System.out.println("title:" + title);
		return "redirect:/upload/list";
	}
	
	@GetMapping("/list")
	public void list(Model m) {
		//C:\\img\\ 폴더의 파일 목록을 읽어서 m에 담아 list.html 파일명 목록 출력
		File dir = new File("C:\\img\\");
		String[] files = dir.list(); //list 메소드로 파일 목록 읽기 가능
		m.addAttribute("files", files);
	}
	
	@GetMapping("/read-img")
	public ResponseEntity<byte[]> read_img(String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File("C:\\img\\" + fname);
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

}
