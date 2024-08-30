package com.example.demo.article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	@Autowired
	private ArticleDAO dao;
	
	//추가 및 수정
	public ArticleDTO saveArticle(ArticleDTO dto) {
		Article entity = dao.save(new Article(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getTitle(), dto.getContent(), dto.getData(), dto.getCount()));
		return new ArticleDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getData(), entity.getCount(), null);
	}
	
	//글목록
	public ArrayList<ArticleDTO> getAll() {
		List<Article> all = dao.findAll();
		ArrayList<ArticleDTO> list = new ArrayList<ArticleDTO>();
		for(Article entity : all) {
			list.add(new ArticleDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getData(), entity.getCount(), null));
		}
		return list;
	}
	
	//번호로 검색
	public ArticleDTO getArticle(int num) {
		Article entity = dao.findById(num).orElse(null);
		if(entity != null) {
			return new ArticleDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getData(), entity.getCount(), null);
		}
		return null;
	}
	
	//제목으로 검색
	public ArrayList<ArticleDTO> getByTitle(String title){
		ArrayList<Article> all = dao.findByTitleLike("%" + title + "%");
		ArrayList<ArticleDTO> list = new ArrayList<ArticleDTO>();
		for(Article entity : all) {
			list.add(new ArticleDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getData(), entity.getCount(), null));
		}
		return list;
	}
	
	//확장자로 검색
	public ArrayList<ArticleDTO> getByData(String data){
		ArrayList<Article> all = dao.findByDataLike("%" + data);
		ArrayList<ArticleDTO> list = new ArrayList<ArticleDTO>();
		for(Article entity : all) {
			list.add(new ArticleDTO(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(), entity.getContent(), entity.getData(), entity.getCount(), null));
		}
		return list;
	}
	
	//삭제
	public void delArticle(int num) {
		dao.deleteById(num);
	}
	
	//cnt 1증가
		public void editCount(int num) {
			dao.updateCnt(num);
		}

}
