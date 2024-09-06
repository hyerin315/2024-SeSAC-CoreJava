package com.example.demo.imgboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			Users u = new Users(a.getName(), "", "", "", "");
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
	
	//전체검색
	@GetMapping("/board")
	public Map list() {
		Map map = new HashMap();
		map.put("list", service.getAll());
		return map;
	}
	
	//번호 검색
	@GetMapping("/board/{num}")
    public Map getNum(@PathVariable("num") int num) {
        Map map = new HashMap();
        ImgboardDTO dto = service.getBoard(num);
        map.put("dto", dto);
        return map;
    }
	
	//타이틀로 검색
	@GetMapping("/board/title/{title}")
	public Map getTitle(@PathVariable("title") String title) {
		Map map = new HashMap();
		ArrayList<ImgboardDTO> dto = service.getByTitle(title);
		map.put("dto", dto);
		return map;
	}
	
	//작성자로 검색
	@GetMapping("/board/writer/{writer}")
	public Map getWriter(@PathVariable("writer") String writer) {
		Map map = new HashMap();
		ArrayList<ImgboardDTO> dto = service.getByWriter(writer);
		map.put("dto", dto);
		return map;
	}
	
	//가격대로 검색
	@GetMapping("/board/price")
    public Map<String, Object> getByPriceRange(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice) {
        Map<String, Object> map = new HashMap<>();
        List<Imgboard> list = service.getByPriceRange(minPrice, maxPrice);
        map.put("list", list);
        return map;
    }
	
	
	//이미지 불러오기
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
	
    // 글 수정
    @PutMapping("/board")
    public Map edit(ImgboardDTO b) { //title, content 수정
        Map map = new HashMap();
        // 원 데이터를 수정할 글번호로 검색, 전체정보 받아옴
        ImgboardDTO old = service.getBoard(b.getNum());
        old.setTitle(b.getTitle());
        old.setContent(b.getContent());
        boolean flag = true;
        try {
            service.save(old);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }

    // 글 삭제
    @DeleteMapping("/board/{num}")
    public Map delete(@PathVariable("num") int num) {
        Map map = new HashMap();
        boolean flag = true;
        try {
            service.delBoard(num);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }
}
