package com.example.demo.article;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 할당, auto_increment 설정
	private int num;
	
	@ManyToOne 
	@JoinColumn(nullable=false) 
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private Member writer; 
	private Date wdate;
	private String title;
	private String content;
	private String data;
	private int count;
	
	@PrePersist //insert 전 자동 호출
	public void makeDate() {
		wdate = new Date();
	}
}
