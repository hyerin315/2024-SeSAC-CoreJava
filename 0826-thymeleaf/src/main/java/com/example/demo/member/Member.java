package com.example.demo.member;

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
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String type;
}
