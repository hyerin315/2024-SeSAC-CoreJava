package com.example.demo.article;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;

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


@Controller
@RequestMapping("/data")
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path = "C:\\download\\";
	
	
	@RequestMapping("/list")
	public void list(Model m) {
		m.addAttribute("list", service.getAll());
	}
	
	@GetMapping("/add")
	public void addFrom() {}
	
	@PostMapping("/add")
	public String add(ArticleDTO dto) {
		ArticleDTO aDto = service.saveArticle(dto);
		String fname = aDto.getNum() + dto.getF().getOriginalFilename();
		File newf = new File(path + fname);
		try {
			dto.getF().transferTo(newf);
			//aDto에 글번호가 있음
			aDto.setData(fname);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.saveArticle(aDto);
		return "redirect:/data/list";
	}
	
	@GetMapping("/detail")
	public void detail(int num, Model m) {
		m.addAttribute("dto", service.getArticle(num));
	}
	
	@GetMapping("/down")
	public ResponseEntity<byte[]> read_img(String fname, int num) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + fname);
		HttpHeaders header = new HttpHeaders(); // import org.springframework.http.HttpHeaders;
		try {
			//전송하는 데이터의 MIME Type(인터넷에서 전송되는 파일이나 데이터 형식/특성을 나타내는 표준형식) 설정
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			header.add(HttpHeaders.CONTENT_DISPOSITION,
					"attachment;filename=\"" +
			URLEncoder.encode(fname, "UTF-8") + "\"");
			result = new ResponseEntity<byte[]>(
					FileCopyUtils.copyToByteArray(f), header, 
					HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.editCount(num);
		return result;
	}
}
