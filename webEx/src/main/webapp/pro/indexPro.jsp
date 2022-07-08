
<%--@page import="jdk.internal.misc.FileSystemOption"--%>
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

	
	<%
	// 가입 체크한다.
	
	// .. //indexPro.jsp?id=***
	
	//System.out.println(request.getParameter("id"));
	//String id =(String) request.getParameter("id"); // 이전 페이지로부터 받은 요청 확인
//	response.getWriter().println(id);				// 응답
	
		String id = request.getParameter("id");
		System.out.print(id);
		String password = request.getParameter("password");
		System.out.print(password);
		
		UserDTO us = new UserDTO(id,password);
		UserDAO userdao = UserDAO.getInstance();
		
		
		// String log = UserDAO.getInstance().getLog();
		
		if(userdao.loginUser(id, password)){
			
			
			session.setAttribute("log", id);
		
			response.sendRedirect("_04.main.jsp");
		}
		else{	
			response.sendRedirect("_00.index.jsp");
		}
		  // 1. 단순 리다이렉트
		   // response.sendRedirect(url);
		   
		  // 페이지 이동한 동안많은 데이터를 가져올 경우 2,3, 번을 사용
		  // 2 가져온 값을 한번 활용한다.
		  // 3 session 영역에서 계속해서 사용이 가능함 
		   // 2. 이전 페이지에서 가져온 request & response 객체를 그대로 가져온다	   
		   // request.setAttribute("log", user.getID());  //넘긴다.
		   // request.getRequestDispatcher(url).forward(request, response);
		   
		   //3. 톰캣 세션을 활용한 session에 로그 정보넣기
			// session.setAttribute("log", user.getId());	
	%>
	
	
</body>
</html>