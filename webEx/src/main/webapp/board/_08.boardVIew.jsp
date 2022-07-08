
<%@page import="exWeb.BoardDAO"%>
<%@page import="exWeb.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="css/board.css">
    <title>BOARD CONTENTS</title>
</head>
<body>
     	<%
     	
     	BoardDAO dao = BoardDAO.getInstance();
     	int code = -1;
     	
     	if(request.getParameter("code") != null) {
     		code = Integer.valueOf(request.getParameter("code"));
     	}
     	
     	String title = "";
     	String contents = "";
     	
     	if (code != -1) {
     		BoardDTO board = dao.getBoard(code);
     			
     		title = board.getTitle();
     		contents = board.getContents();		
  		
     	}
     	
    	%>
    	
    <h1>GREEN BOARD</h1>
    <div class="formContainer">
        <form method = "post" action="">
            <input type="text" id="title" name="title"
            value="<%=title%>" required><br>
            <textarea name="contents"
             required readonly><%=contents%></textarea><br>

            <input type="button" value="뒤로가기" onclick="location.href = '_05.board.jsp'">
            <input type="submit" value="수정하기">
        </form>

    </div>
</body>
</html>








