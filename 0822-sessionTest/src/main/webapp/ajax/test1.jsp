<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	const a = () => {
		//비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		//비동기 요청에 대한 응답이 오면 자동 호출될 핸들러 등록
		//받은 응답은 비동기 객체의 responseText 속성에 저장됨
		req.onload = () => {
	        let res = document.getElementById("res");
	        res.innerHTML = req.responseText;
    	}
		
		//전송할 파라미터 정의
	    let num = document.getElementById("num").value;
	    let name = document.getElementById("name").value;
	    let params = 'num=' + num + '&name=' + name;
		
		
		//open()로 요청 설정
		req.open('get', '/ajax/test1?'+params);
		
		//요청 전송
		req.send();
	}
	
	const b = () => {
		//비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		//비동기 요청에 대한 응답이 오면 자동 호출될 핸들러 등록
		//받은 응답은 비동기 객체의 responseText 속성에 저장됨
		req.onload = () => {
	        let res = document.getElementById("res");
	        res.innerHTML = req.responseText;
    	}
		
		//전송할 파라미터 정의
	    let num = document.getElementById("num").value;
	    let name = document.getElementById("name").value;
	    let params = 'num=' + num + '&name=' + name;
		
		
		//open()로 요청 설정
		req.open('post', '/ajax/test2?');
		req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		//요청 전송
		req.send(params);
	}
	
	const c = () => {
		//비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		//비동기 요청에 대한 응답이 오면 자동 호출될 핸들러 등록
		//받은 응답은 비동기 객체의 responseText 속성에 저장됨
		req.onload = () => {
	        let res = document.getElementById("res");
	        let obj = JSON.parse(req.responseText); //JSON.parse() : json을 파싱, {} -> 객체 , [] -> 배열
	        let num = obj.num;
	        let name = obj.name;
	        res.innerHTML = "num:" + num + "<br/>name:" + name;
    	}
		
		//전송할 파라미터 정의
	    let num = document.getElementById("num").value;
	    let name = document.getElementById("name").value;
	    let params = 'num=' + num + '&name=' + name;
		
		
		//open()로 요청 설정
		req.open('get', '/ajax/test3?' + params);
		
		//요청 전송
		req.send(params);
	}
</script>
</head>
<body>
<h3>ajax test</h3>
<div id="res"></div>
num:<input type="number" id="num"><br />
name:<input type="text" id="name"><br />
<input type="button" value="get/string" onclick="a()">
<input type="button" value="get/string" onclick="b()">
<input type="button" value="get/string" onclick="c()">
</body>
</html>