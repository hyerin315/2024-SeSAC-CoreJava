<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입</h3>
${sessionScope.loginId }로그인 중<br/>

<!-- <a href="/member/join">회원가입</a><br/>
<a href="/member/login">로그인</a><br/> -->

<a href="/mem/join">회원가입</a><br/>
<a href="/member/login">로그인</a><br/>
==========================<br/>
<!-- el 표현식 - jsp에서 자바값을 출력하는 양식 -->
<!-- 1. 값이 있으면 출력되고 없으면 동작하지 않고 에러가 뜨지 않음  -->
<!-- 2. private 멤버에 대해 get을 쓰지 않고 가져올 수 있음 (el표현식이 자동으로 내부에서 getter를 호출함) -->     
<!-- ${member.id} / ${member.pwd} / ${member.name} / ${member.email}<br/> -->
<!-- ${m1.id} / ${m1.pwd} / ${m1.name} / ${m1.email}<br/> --!> <!-- @ModelAttribute 사용으로 클래스명이 아닌 m1으로 호출 -->
<a href="/city/info">도시검색</a>
<!-- 도시 추가 폼(city/add.jsp => 폼에 도시 정보 입력 후 submit => /city/add:post 요청 -->
<a href="/city/add">도시추가</a>
<a href="/city/list">도시목록</a><br/>
==========================<br/>
<a href="/guestbook/list">글목록</a>
</body>
</html>