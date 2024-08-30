<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	location.href = "/guestbook/del?num=${guestbook.num}";
}
</script>
</head>
<body>
<h3>방명록 수정하기</h3>
<form action="/guestbook/edit" method="post">
num:${guestbook.num}<br/>
wdate:<br/>
writer:<input type="number" name="num" value="${guestbook.writer}" readonly><br/>
pwd:<input type="password" name="pwd" value="${guestbook.pwd}"><br/>
content:<input type="text" name="content" value="${guestbook.content}"><br/>
<input type="submit" value="저장">
<input type="button" value="삭제" onclick="a()">
</form>
</body>
</html>