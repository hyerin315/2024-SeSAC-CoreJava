package com.example.demo.member;

//VO : 생성자, getter/setter, toString
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	//Default 생성자 : 코드에서 사용하지 않아도 꼭 생성해줘야하는 생성자 (프레임워크가 사용함)
	public Member() {}
	
	public Member(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	//Setter/Getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//toString : 나중에 디버깅하기 쉬움
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
