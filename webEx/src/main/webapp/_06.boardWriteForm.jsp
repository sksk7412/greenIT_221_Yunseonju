<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="exWeb.BoardDTO"%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/board.css">
    <title>BOARD WRITE</title>
</head>
<body>
    <h1>GREEN BOARD</h1>
    <div class="formContainer">
        <form method = "post" action="_09.writeFormPro.jsp">
            <input type="text" id="title" name="title" placeholder="title" required><br>
            <textarea name="contents" placeholder="contents text" required></textarea><br>
            
            <input type="button" value="뒤로가기" onclick="location.href = '_05.board.jsp'">
            <input type="submit" value="글쓰기">
        </form>

    </div>
</body>
</html>