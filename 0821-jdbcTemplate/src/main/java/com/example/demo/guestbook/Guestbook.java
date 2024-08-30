package com.example.demo.guestbook;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//lombok : 생성자, getter/setter를 자동으로 만들어주는 툴
//lombok 사용방법 1)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//lombok 사용방법 2) Data는 Equal 등도 설정하므로 불필요하다 생각될 경우 사용방법 1 활용
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Guestbook {
	//	vo 이름은 table 이름과 동일하게
	private int num;
	private String writer;
	private String pwd;
	private Date wdate;
	private String content;

	
//lombok을 사용하지 않을때
//	public Guestbook() {
//		
//	}
//	
//	public Guestbook(int num, String writer, String pwd, String wdate, String content) {
//		super();
//		this.num = num;
//		this.writer = writer;
//		this.pwd = pwd;
//		this.wdate = wdate;
//		this.content = content;
//	}
//
//	public int getNum() {
//		return num;
//	}
//
//	public void setNum(int num) {
//		this.num = num;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getWdate() {
//		return wdate;
//	}
//
//	public void setWdate(String wdate) {
//		this.wdate = wdate;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	@Override
//	public String toString() {
//		return "Guestbook [num=" + num + ", writer=" + writer + ", pwd=" + pwd + ", wdate=" + wdate + ", content="
//				+ content + "]";
//	}
	
	
	

}
