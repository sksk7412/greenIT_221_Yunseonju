
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
	<%	
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

	
	%>
	  <h1>N A V E R</h1>
	   <form method = "post" action="./login">
	   
		<div ></div>
		<div ></div>
		<div ></div>
		<div ></div>
       	   
	   </form>
	 
	     <script></script>
</body>
</html>