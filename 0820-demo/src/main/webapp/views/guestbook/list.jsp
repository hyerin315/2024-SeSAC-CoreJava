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
<h3>방명록</h3>
<a href="/guestbook/edit">방명록 작성</a><br/>
<!-- c:if : else가 없음 -->
<!-- test : 비교할 조건 -->
<c:if test="${list.size() == 0}">
	작성된 글이 없습니다
</c:if>
<c:if test="${list.size() != 0}">
	<table border="1">
		<tr>
			<th>글번호</th><th>작성자</th>
			<c:forEach var="g" items="${list }">
				<tr><td>${g.num }</td><td>${g.writer }</td></tr>
			</c:forEach>
		</tr>
	</table>
</c:if>
</body>
</body>
</html>