<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>환영합니다.</h1>

	<%
	String log = (String)session.getAttribute("log");
	%>
	<h1> <%=log %>님 환영합니다.</h1> 
	<button onclick="location.href = '_00.logout.jsp'">로그아웃</button>
	
</body>
</html>