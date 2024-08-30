package com.example.demo.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//vo
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity //보안 문제로 DAO에서만 사용하며, 다른 곳에서는 사용하지 않음
public class Member {
	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String type;
}
