<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 태그 라이브러리 지시자 : 태그에 대한 정의가 있는 정의문의 위치 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도시 추가</h3>
<form action="/city/add" method="post">
name:<input type="text" name="name"><br />
<!-- countryCode<input type="text" name="countryCode"><br /> -->
countryCode:<select name="countryCode">
<!-- items="반복할 속성" -->
<c:forEach var="code" items="${list}">
	<option>${code}</option>
</c:forEach>
</select><br />
district:<input type="text" name="district"><br />
population:<input type="number" name="population"><br />
<input type="submit" value="추가">
</form>
</body>
</html>