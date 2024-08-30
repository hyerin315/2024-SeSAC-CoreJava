package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//REST API : 상태정보를 유지하지 않음
//-> 그래서 session 등을 사용하지 않음, 암호화된 토큰 등을 사용함 (암호화된 토큰 안에 정보를 넣을 수 있음)

@RestController //일반컨드롤러 : 요청마다 view 페이지를 줌, Rest컨트롤러 : 요청마다 JSON 반환 (모든 요청에 대해 @Responsebody를 실행)
@CrossOrigin(origins= "*") //요청받을 ip주소
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemberService service;
	
	//추가
	@PostMapping("")
	public Map add(MemberDTO m) {
		Map map =  new HashMap();
		MemberDTO mDto = service.saveMember(m);
		map.put("dto", mDto);
		return map;
	}
	
	//pk(ID)로 검색
	//{id} : path variable
	@GetMapping("/{id}") // id:aaa = /members/aaa (기존에는 members?aaa로 받았으나, restapi는 url로 받을 수 있음)
	public Map get(@PathVariable("id") String id) { //pathVariable 안의 id 값을 꺼내는 과정
		Map map = new HashMap();
		MemberDTO mDto = service.getMember(id);
		map.put("dto", mDto);
		return map;
	}
	
	//수정
    @PutMapping("")
    public Map edit(MemberDTO m) {//수정할 사람의 id 및 새 pwd만 가져옴
        Map map = new HashMap();
        MemberDTO old = service.getMember(m.getId());
        //수정할 부분 (pwd)
        old.setPwd(m.getPwd());
        MemberDTO mDto = service.saveMember(old);
        map.put("dto", mDto);
        return map;
    }
	
	//삭제
	@DeleteMapping("/{id}")
	public Map delete(@PathVariable("id") String id) { //pathVariable 안의 id 값을 꺼내는 과정
		Map map = new HashMap();
		boolean flag = true;
		try { 
			service.delMember(id);
		} catch(Exception e) {
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}
	
	//로그인
	@GetMapping("/login")
	public Map login(String id, String pwd) {
		Map map = new HashMap();
		boolean flag  = false;
		MemberDTO mDto = service.getMember(id);	 
		if(mDto != null && mDto.getPwd().equals(pwd)) {
			flag = true;
			map.put("loginId", mDto.getId());
			map.put("type", mDto.getType());
		}
		map.put("flag", flag);
		return map;	
	}
}
