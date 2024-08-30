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
	let pwd = prompt("방명록 비밀번호", "");
	/* 타입이 문자열일 경우 따옴표('') 필요 */
	if(pwd == '${gb.pwd}'){	
		/* Ajax를 사용하지 않을때 */
		let cont = prompt("수정할 방명록 내용", "");
		location.href = "/guestbook/edit?num=${gb.num}&content="+cont;
	}else{
		alert('글 비밀번호 불일치');
	}
}
const b = () => {
	let pwd = prompt("글 비밀번호", "");
	if(pwd == '${gb.pwd}'){
		location.href = "/guestbook/del?num=${gb.num}";
	}else{
		alert('글 비밀번호 불일치');
	}
}
</script>
</head>
<body>
<h3>상세 페이지</h3>
<table border="1">
<tr><th>글번호</th><td>${gb.num }</td></tr>
<tr><th>작성자</th><td>${gb.writer }</td></tr>
<tr><th>작성일</th><td>${gb.wdate }</td></tr>
<tr><th>내용</th><td>${gb.content }</td></tr>
<tr><th>수정</th>
	<td>
		<input type="button" value="수정" onclick="a()">
		<input type="button" value="삭제" onclick="b()">
	</td>
</tr>
</table>
</body>
</html>