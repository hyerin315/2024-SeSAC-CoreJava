package com.example.demo.guestbook;



import java.sql.Date;


public class Guestbook {
	private int num;
	private String writer;
	private String pwd;
	private String wdate;
	private String content;


	public Guestbook() {
		
	}
	
	public Guestbook(int num, String writer, String pwd, String wdate, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.pwd = pwd;
		this.wdate = wdate;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Guestbook [num=" + num + ", writer=" + writer + ", pwd=" + pwd + ", wdate=" + wdate + ", content="
				+ content + "]";
	}
	
	
	

}
