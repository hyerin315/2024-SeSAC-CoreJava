<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인 폼</h3>
<!-- submit을 진해하면 post 방식으로 /member/join 에 값을 보냄 -->
<form action="/member/login" method="post"> 
id:<input type="text" name="id"><br/>
pwd:<input type="password" name="pwd"><br/>
<input type="submit" value="로그인">
</body>
</html>