package com.example.demo.guestbook;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok으로 생성자 생성
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity // Jpa Entity : 테이블로 정의해라
public class GuestBook {
	
	@Id //pk 정의 : 이 Id가 Primary Key임을 정의함
	@GeneratedValue(strategy = GenerationType.IDENTITY) //num에 값을 자동할당 (자동넘버링)
	private int num;
	private String writer;
	private Date wdate;
	private String pwd;
	private String content;
//	private String path;
	
	// DTO를 분리해서 만들때 사용
//	@Transient
//	private MyltipartFile f;
	
	@PrePersist //insert 전 자동호출
	public void makeDate() {
		wdate = new Date();
	}
}
