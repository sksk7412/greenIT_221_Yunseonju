<%@page import="java.sql.Timestamp"%>
<%@page import="exWeb.BoardDTO"%>
<%@page import="exWeb.BoardDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="exWeb.BoardDTO"%>
<%@page import="java.util.Map"%>
<%@page import="exWeb.BoardDAO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/board.css">
<title>BOARD LIST</title>
</head>
<body>

	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<table border="1">
			<thead>
				<th>no</th>
				<th>code</th>
				<th>title</th>
				<th>content</th>
				<th>viewCnt</th>
				<th>likeCnt</th>
				<th>createdAt</th>
				<th>modifiedAt</th>
			</thead>
			<tbody>
					<%
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
					BoardDAO bDao = BoardDAO.getInstance();
					Map<Integer, BoardDTO> temp = bDao.getMap();
					Object[] keySet = temp.keySet().toArray();
						//int no = 0;
						//int code = 0;
						int no = 0; 
						int code = 0; 
						String title = null;
						String content = null; 
						int viewCnt = 0;
						int likeCnt = 0;
						Timestamp createdAt = null;
						Timestamp modifiedAt = null;
						
						for(Object k : keySet) {
							no = temp.get(k).getNo();
							code = temp.get(k).getCode();
							title = temp.get(k).getTitle();
							content = temp.get(k).getContents();
							viewCnt = temp.get(k).getViewCnt();
							likeCnt = temp.get(k).getLikeCnt();
							createdAt = temp.get(k).getCreatedAt();
							modifiedAt = temp.get(k).getModifiedAt();
							System.out.println("no : "+no);
							System.out.println("code : "+code);
							System.out.println("title : "+title);
							System.out.println("content : "+content);
					%>
					<tr>
					<td><%=no%></td>
					<td><%=code%></td>
					<td><%=title%></td>
					<td><%=content%></td>
					<td><%=viewCnt%></td>
					<td><%=likeCnt%></td>
					<td><%=createdAt%></td>
					<td><%=modifiedAt%></td>
					<%
					}
					%>
				</tr>
			</tbody>
		</table>
		    <button onclick = "location.href ='_06.boardWriteForm.jsp'">작성하기</button>
	</div>
</body>
</html>