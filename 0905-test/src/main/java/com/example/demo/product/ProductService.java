package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;


@Service
public class ProductService {
	@Autowired
	private ProductDAO dao;
	
	// 상품 등록 및 수정
	public ProductDTO saveProduct(ProductDTO dto) {
		Product entity = dao.save(new Product(dto.getNum(), dto.getName(), dto.getPrice(), dto.getAmount(), dto.getSeller(), dto.getImg()));
		return new ProductDTO(entity.getNum(), entity.getName(), entity.getPrice(), entity.getAmount(), entity.getSeller(), entity.getImg(), null); //DTO에는 multipart가 있으므로 null 추가
	}
	
	// 상품 번호로 검색
	public ProductDTO getProduct(int num) {
		Product p = dao.findById(num).orElse(null); //p : entity
		if(p != null) {
			return new ProductDTO(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller(), p.getImg(), null);
		}
		return null;
	}
	
	// 전체 검색
	public ArrayList<ProductDTO> getAll() {
		List<Product> all = dao.findAll();
		ArrayList<ProductDTO> list = new ArrayList<>();
		for(Product p : all) {
			list.add(new ProductDTO(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller(), p.getImg(), null));
		}
		return list;
	}
	
	// 삭제
	public void delProduct(int num) {
		dao.deleteById(num);
	}
	
	
	// 판매자로 검색
	public ArrayList<ProductDTO> getBySeller(String seller) {
		List<Product> all = dao.findBySeller(new Member(seller, "", "", "", ""));
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Product p : all) {
			list.add(new ProductDTO(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller(), p.getImg(), null));
		}
		return list;
	}
	
	// 가격대로 검색
	public ArrayList<ProductDTO> getByPrice(int p1, int p2) {
		List<Product> all = dao.findByPriceBetween(p1, p2);
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Product p : all) {
			list.add(new ProductDTO(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller(), p.getImg(), null));
		}
		return list;
	}
	
	
	// 상품명으로 검색
	public ArrayList<ProductDTO> getByName(String name) {
		List<Product> all = dao.findByNameLike("%"+name+"%");
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		for(Product p : all) {
			list.add(new ProductDTO(p.getNum(), p.getName(), p.getPrice(), p.getAmount(), p.getSeller(), p.getImg(), null));
		}
		return list;
	}
}
