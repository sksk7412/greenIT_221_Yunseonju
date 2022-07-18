<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<form method="post" action="./joinAction">
		<input class="req" name="id"  type ="id" placeholder="NAME" title="이름을 입력하세요"  required><br> 
	
	<div class="buttons">
		<input type="button" value="회원가입" onclick="location.href='join.jsp'">
		<input type="submit" value="로그인">
	</div>	
	
	</form>
	
</body>
</html>