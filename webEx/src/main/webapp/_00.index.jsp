<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="css/form.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>

	  <h1>N A V E R</h1>
	   <form method = "post" action="./LoginAction">
	   
		   <input class="req" name = "id" type="text" placeholder="id" title="아이디를 입력하세요" required >
		   <input class="req" name = "password" type="text" placeholder="password" title="비밀번호를 입력하세요" required >
	   		
	   	 <div class="buttons">
  
            <input type="button" onclick="location.href='form_agree.jsp'" value="회원가입">
            <!-- <input type="button"  onclick="check(form)" value="로그인" > -->
            <input type="submit" value="로그인" >
        </div>
       	   
	   </form>
	 
	     <script src="validation.js"></script>
</body>
</html>