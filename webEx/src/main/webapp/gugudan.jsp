<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<style>
  table {
    width: 30%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style>
</head>
<body>
	<%-- 2~9단까지 출력 --%>
	<%-- 타이틀 h1 --%>
	<%-- 내용 p --%>

	<%
	int cnt = 0;
	
	for(int i = 0; i < 5 ; i++){
	//	String id =(String) request.getParameter("id"); // 이전 페이지로부터 받은 요청 확인
		int answer = Integer.parseInt(request.getParameter("answer" + (i+1)));
		int result = Integer.parseInt(request.getParameter("result" + (i+1)));
		
		//response.getWriter().println(answer);
		//response.getWriter().println(result);
		if(answer == result){
			cnt++;
		}
	%>	<table>
		 <tr> 
			<td><%= i+1 %></td>
			<td><%= answer %></td>
			<td><%= result %></td>
		</tr>	
		</table>
		
	<% 
	}

    %>
	
	<h1>총 점수는 : <%=(cnt *20) %></h1>
 
	
	<%--
	<%for(int i = 2; i < 10; i++){ %>
	
		<h1> <%=i%> 단 </h1><br>	
		<%for(int j = 1; j <10; j++){ %>
			<%=i %> * <%=j %> = <%=i * j %><br>
			
		<% //j 포문 마무리
		}
		%>
	<%  //i에 포문 마무리
	}
	%>
	
	<%-- 랜덤 구구단 퀴즈 --%>
	<%-- 문제 10개 form --%>
	<%-- gugudan.jsp 페이지 에서 --%>
	<%-- 정답자와 함께, 성적표 출력 --%>
	
	
	
</body>
</html>