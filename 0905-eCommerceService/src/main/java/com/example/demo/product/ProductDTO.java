package com.example.demo.product;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
	private int num;
	private String name;
	private int price;
	private int amount;
	private Member seller;
	private String img;
	private MultipartFile f; //파일 업로드 : 폼에서 전송한 이미지를 저장할 변수
}
