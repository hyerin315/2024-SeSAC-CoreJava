<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {
	if('${msg}' == '') { /* opener : 행위자 */
		opener.f.id.value = opener.document.f.id.value;
	}else{
		if(${flag}){
			let div = document.getElementById("div");
			let html = "<input type='button' value='아이디사용' onclick='b()'>";
			div.innerHTML = html;
		}
	}
}


const b = () => {
	opener.document.f.id.value = '${resultid }';
	close(); // 현재 팝업창 닫음
}
</script>
</head>
<body>
<h3>중복체크</h3>
${msg }
<form action="/member/idcheck" method="post" name="f">
id:<input type="text" name="id" value="${resultid }">
<input type="submit" value="중복체크">
</form>
<div id="div"></div>
</body>
</html>