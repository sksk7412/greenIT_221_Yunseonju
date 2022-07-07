<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/form.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 로고.</h1>

	<%
	String log = (String) session.getAttribute("log");
	%>
	<h2> <%=log %>님 환영합니다.</h2> 
	<button onclick="location.href = '_05.board.jsp'">게시판 이동</button>
	<button onclick="location.href = '_00.logout.jsp'">로그아웃</button>
	
</body>
</html>