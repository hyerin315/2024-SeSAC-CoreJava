package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.users.Users;

@Service
public class ImgboardService {
	@Autowired
	private ImgboardDAO dao;
	
	public void save(ImgboardDTO dto) {
		dao.save(new Imgboard(dto.getNum(), dto.getWriter(), dto.getTitle(), dto.getImg(), dto.getPrice(), dto.getAmount(), dto.getContent()));
	}
	
	// 전체 검색
	public ArrayList<ImgboardDTO> getAll(){
		List<Imgboard> all = dao.findAll();
		ArrayList<ImgboardDTO> list = new ArrayList<>();
		for(Imgboard entity : all) {
			list.add(new ImgboardDTO(entity.getNum(), entity.getWriter(), entity.getTitle(), entity.getImg(), entity.getPrice(), entity.getAmount(), entity.getContent(), null));
		}
		return list;
	}
	
	// 상품 번호로 검색
	public ImgboardDTO getBoard(int num) {
		Imgboard entity = dao.findById(num).orElse(null); // b : entity
		if(entity != null) {
			return new ImgboardDTO(entity.getNum(), entity.getWriter(), entity.getTitle(), entity.getImg(), entity.getPrice(), entity.getAmount(), entity.getContent(), null);
		}
		return null;
	}
	
	// 타이틀로 검색
		public ArrayList<ImgboardDTO> getByTitle(String title) {
			List<Imgboard> all = dao.findByTitleLike("%"+title+"%");
			ArrayList<ImgboardDTO> list = new ArrayList<>();
			for(Imgboard entity : all) {
				list.add(new ImgboardDTO(entity.getNum(), entity.getWriter(), entity.getTitle(), entity.getImg(), entity.getPrice(), entity.getAmount(), entity.getContent(), null));
			}
			return list;		
		}
		
	// 작성자로 검색
	public ArrayList<ImgboardDTO> getByWriter(String writer) {
		List<Imgboard> all = dao.findByWriter(new Users(writer, "", "", "", ""));
		ArrayList<ImgboardDTO> list = new ArrayList<>();
		for(Imgboard entity : all) {
			list.add(new ImgboardDTO(entity.getNum(), entity.getWriter(), entity.getTitle(), entity.getImg(), entity.getPrice(), entity.getAmount(), entity.getContent(), null));
		}
		return list;
	}
	
	// 가격대로 검색
	public List<Imgboard> getByPriceRange(double minPrice, double maxPrice) {
		return dao.findByPriceBetween(minPrice, maxPrice);
	}
	
	
	public void delBoard(int num) {
		dao.deleteById(num);
	}
	
}


