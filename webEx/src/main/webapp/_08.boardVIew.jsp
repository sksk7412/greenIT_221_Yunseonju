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
    <h1>GREEN BOARD</h1>
    <div class="formContainer">
        <form>
        
            <input type="text" id="title" name="title"
            value="<%=로딩된타이틀%>" required><br>
            <textarea name="contents"
             required readonly><%=로딩된콘텐츠%></textarea><br>
            <input type="button" value="뒤로가기">
            <input type="button" value="수정하기">
        </form>

    </div>
</body>
</html>