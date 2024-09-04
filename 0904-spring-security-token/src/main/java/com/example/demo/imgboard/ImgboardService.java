package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgboardService {
	@Autowired
	private ImgboardDAO dao;
	
	public void save(ImgboardDTO dto) {
		dao.save(new Imgboard(dto.getNum(), dto.getWriter(), dto.getTitle(), dto.getImg()));
	}
	
	public ArrayList<ImgboardDTO> getAll(){
		List<Imgboard> l = dao.findAll();
		ArrayList<ImgboardDTO> list = new ArrayList<>();
		for(Imgboard entity : l) {
			list.add(new ImgboardDTO(entity.getNum(), entity.getWriter(), entity.getTitle(), entity.getImg(), null));
		}
		return list;
	}
	
}


