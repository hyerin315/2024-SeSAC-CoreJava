package com.example.demo.imgboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.Users;

@RestController
@CrossOrigin(origins = "*")
public class ImgboardController {
	@Autowired
	private ImgboardService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	//글 추가
	@PostMapping("/board")
	public Map add(ImgboardDTO dto) {
		String fname = dto.getF().getOriginalFilename();
		File newf = new File(path + fname);
		boolean flag = false;
		try {
			dto.getF().transferTo(newf);
			dto.setImg(fname);
			Authentication a =
					SecurityContextHolder.getContext().getAuthentication();
			Users u = new Users(a.getName(), "", "");
			dto.setWriter(u);
			service.save(dto);
			flag = true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}
	
	@GetMapping("/board")
	public Map list() {
		Map map = new HashMap();
		map.put("list", service.getAll());
		return map;
	}
	
	@GetMapping("/read-img/{fname}")
	public ResponseEntity<byte[]> read_img(
			@PathVariable("fname") String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + fname);
		//응답 헤더 정보 저장 객체
		HttpHeaders header = new HttpHeaders();
		try {
			//전송하는 데이터의 MIME Type(인터넷에서 전송되는 파일이나 데이터 형식/특성을 나타내는 표준형식) 설정
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(
					 	FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
