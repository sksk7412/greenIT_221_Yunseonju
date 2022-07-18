<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>J O I N</h1>
		<form method="post" action="./Service">
			<input type="hidden" name="command" value="join">
				<input class="req" name="name"  id = "name" type ="text" placeholder="이름" required><br> 
				<input class="req" type="text" id="mobile" name="mobile" pattern="[0-1]{3}-[0-9]{4}-[0-9]{4}" placeholder="mobile" title="###-####-####" required><br> 
				
				
				<input type="radio" name="agency" id = "agency" value="lg">LG
				<input type="radio" name="agency" id = "agency" value="kt" checked="checked">KT
				<input type="radio" name="agency" id = "agency" value="sk">SK<br>
            	
            	<%
            
            	%>
            	
            	고객등급[A:VIP, B:입반, C="직원"] <input type="text" name ="grade" id = "grade" required><br>
            	
            	<select name = "city"><br>
                <option value="01" >서울</option>
                <option value="10" >인천</option>
                <option value="20" >성남</option>
                <option value="30">대전</option>
                <option value="40">광주</option>
                <option value="60" >부산</option>
            	</select><br>
            	
           <div class="buttons">
	            <input type="button" value="뒤로" onclick="location.href = '_00.index.jsp'">
	            <input type="submit" value="확인">
    	   </div>  	
            	
		</form>
	
</body>
</html>