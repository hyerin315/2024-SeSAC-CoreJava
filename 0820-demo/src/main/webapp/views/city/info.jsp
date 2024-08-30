<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도시 검색</h3>
<form action="/city/detail" method="get">
<!-- name="" VO를 작성하지 않고 연결할 땐, Controller 파라미터 이름과 입력될 name 이릅을 맞춰주면 Controller 파라미터로 전달됨-->
id<input type="number" name="id"><br />
<input type="submit" value="검색">
</form>
</body>
</html>