package com.example.demo.board;

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


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 할당, auto_increment 설정
	private int num;
	
	@ManyToOne //Board:Member -> 다대일, 작성자 한 사람이 여러개의 글을 쓸 수 있으므로
	@JoinColumn(nullable=false) //null을 허용하지 않겠다 (join 컬럼 이름 지정하고 싶을 때 name=""로 작성)
	@OnDelete(action=OnDeleteAction.CASCADE) //fk 연결시 작성하는 on delete cascade 설정과 동일함
	private Member writer; //연관되는 entity 타입으로 지정 (연결되는 foreign key 타입), 자동으로 String text 타입으로 테이블 생성됨	
	private Date wdate;
	private String title;
	private String content;
	
	@PrePersist //insert 전 자동 호출
	public void makeDate() {
		wdate = new Date();
	}

}
