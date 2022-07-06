<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
	<form method="get" action="gugudan.jsp" >
	<%
	Random r = new Random();
	int num[] = new int [5];
    %>
	
	
		<table>
		<tr>
			<td>번호</td>
			<td>문제</td>
			<td>정답</td>
		</tr>
		
		<% for(int i = 0; i < 5; i++){
			
		   int  first = r.nextInt(8)+2;
		   int  second = r.nextInt(9)+1;
		   num[i] = first * second;
		 %>
		 
		 <tr> 
			<td><%= i+1 %></td>
			<td><%= first %> * <%= second %></td>
			<td> <input type="text" name="answer<%=i+1 %>"><br></td>
			
			<input type="hidden" name="result<%=i+1 %>" value = <%=num[i] %>>	
		</tr>	
		<%
		}
		%>
		</table>
		<input type="submit">
	</form>
</body>
</html>






