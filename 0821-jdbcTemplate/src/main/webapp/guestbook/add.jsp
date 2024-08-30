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
<form action="/guestbook/add" method="post">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer"></td></tr>
<tr><th>글 비밀번호</th><td><input type="password" name="pwd"></td></tr>
<tr><th>내용</th><td><input type="text" name="content"></td></tr>
<tr><th>작성</th><td><input type="submit" value="방명록 저장"></td></tr>
</table>
</form>
</body>
</html>