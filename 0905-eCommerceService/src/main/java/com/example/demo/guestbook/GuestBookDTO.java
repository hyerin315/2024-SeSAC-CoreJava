package com.example.demo.guestbook;

import java.util.Date;


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
public class GuestBookDTO {
	private int num;
	private String writer;
	private Date wdate;
	private String pwd;
	private String content;

}
