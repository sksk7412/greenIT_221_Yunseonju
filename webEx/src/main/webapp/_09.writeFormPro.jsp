
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@page import="exWeb.BoardDAO"%>
<%@page import="exWeb.BoardDTO"%>
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
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	Random ran = new Random();
	int check = -1;
	int size = BoardDAO.getInstance().getSize();
	int code = BoardDAO.getInstance().getCode();
	int viewCnt;
	int likeCnt;
	BoardDTO user = null;
	BoardDAO temp = BoardDAO.getInstance();
	
	
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	
	System.out.println("title:" + title);
	System.out.println("contents: " + contents);
	
	
	user = new BoardDTO(size,code,title,contents,0,0);	
 		
	check = temp.addWrite(user);
	
	if(check != -1){
		
		System.out.println("등록 성공");
		response.sendRedirect("_05.board.jsp");
	}
	else{
		System.out.println("등록 실패");
		response.sendRedirect("_06.boardWriteForm.jsp");
	}
	
	%>
</body>
</html>