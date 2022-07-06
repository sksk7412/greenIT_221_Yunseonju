<%@page import="exWeb.UserDTO"%>
<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	

	<h1> 환영합니다.</h1>
	<% 
		UserDAO dao = UserDAO.getInstance();
		//	UserDTO user = null;
		
			String id = request.getParameter("id");
			String password = request.getParameter("password");
	
			
			UserDTO user = new UserDTO(id,password);
			
			String url = "";
			
		//	if(dao.loginCheck(user)){
				
				//중복으로 인한 회원가입 불가
				//join페이지로 다시 이동
		//		url = "join.jsp";
		//		session.setAttribute("log", user.getId());
		//	}
		//	else{
				//회원 가입 성공
				//login.jsp 로 이동
		//		url = "_00.index.jsp";
		//	}
			
			response.sendRedirect(url);
			%>
</body>
</html>