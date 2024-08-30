<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	location.href = "/city/del?id=${city.id}";
}
</script>
</head>
<body>
<h3>상세페이지</h3>
<form action="/city/edit" method="post">
id:<input type="text" name="id" value="${city.id}" readonly><br/>
name:${city.name }<br />
countryCode:${city.countryCode }<br />
district:${city.district }<br />
population:<input type="number" name="population" value="${city.population }" ><br />
<input type="submit" value="수정">
<input type="button" value="삭제" onclick="a()"> <!-- click 이벤트를 실행하면 호출할 곳을 선언하는 핸들러 -->
</form>
</body>
</html>