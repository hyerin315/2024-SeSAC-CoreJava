<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인 폼</h3>
<form action="/test/login" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>Login</th><td><input type="submit" name="로그인"></td></tr>
</table>
</form>
</body>
</html>