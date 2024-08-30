package com.example.demo.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.MemberDTO;

@RestController
@CrossOrigin(origins= "*") //요청받을 ip주소
@RequestMapping("/boards")
public class BoardController {
    private BoardService service;

    // 글 작성
    @PostMapping("")
    public Map add(BoardDTO board) {
        Map map = new HashMap();
        boolean flag = true;
        try {
            service.saveBoard(board);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }

    // 번호 검색
    @GetMapping("/{num}")
    public Map get(@PathVariable("num") int num) {
        Map map = new HashMap();
        BoardDTO dto = service.getBoard(num);
        map.put("dto", dto);
        return map;
    }

    // 전체 검색
    @GetMapping("")
    public Map list() {
        Map map = new HashMap();
        ArrayList<BoardDTO> list = service.getAll();
        map.put("list", list);
        return map;
    }

    // 제목 검색
    @GetMapping("/title/{title}")
    public Map getByTitle(@PathVariable("title") String title) {
        Map map = new HashMap();
        ArrayList<BoardDTO> list = service.getByTitle(title);
        map.put("list", list);
        return map;
    }

    // 작성자 검색
    @GetMapping("/writer/{writer}")
    public Map getByWriter(@PathVariable("writer") String writer) {
        Map map = new HashMap();
        ArrayList<BoardDTO> list = service.getByWriter(writer);
        map.put("list", list);
        return map;
    }

    // 글 수정
    @PutMapping("")
    public Map edit(BoardDTO b) { //title, content 수정
        Map map = new HashMap();
        // 원 데이터를 수정할 글번호로 검색, 전체정보 받아옴
        BoardDTO old = service.getBoard(b.getNum());
        old.setTitle(b.getTitle());
        old.setContent(b.getContent());
        boolean flag = true;
        try {
            service.saveBoard(old);
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        map.put("flag", flag);
        return map;
    }

    // 글 삭제
    @DeleteMapping("/{num}")
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