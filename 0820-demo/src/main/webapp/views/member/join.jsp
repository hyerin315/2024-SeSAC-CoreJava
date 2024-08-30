<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입 폼</h3>
<!-- submit을 진해하면 post 방식으로 /member/join 에 값을 보냄 -->
<form action="/mem/join" method="post"> 
<!-- name은 VO의 변수명과 동일해야 자동연결됨 -->
id:<input type="text" name="id"><br/>
pwd:<input type="password" name="pwd"><br/>
name:<input type="text" name="name"><br/>
email:<input type="text" name="email"><br/>
<input type="submit" value="가입">
</form>
</body>
</html>