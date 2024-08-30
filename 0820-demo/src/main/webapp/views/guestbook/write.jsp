<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 작성</h3>
<form action="/guestbook/write" method="post">
writer:<input type="text" name="writer"><br/>
pwd:<input type="text" name="pwd"><br/>
content:<input type="text" name="content">
<input type="submit" value="방명록 추가">
</form>
</body>
</html>