<%-- <%@ page import="exWeb.*" %> --%>
<%@page import="exWeb.UserDTO"%>
<%@page import="exWeb.UserDAO"%>
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
		UserDTO user = null;
		UserDAO temp = UserDAO.getInstance();
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String mobile = request.getParameter("mobile");
		
		user = new UserDTO(id,password,name,year,month,day,gender,email,country,mobile);	
	 	
		System.out.println(gender);
		
		int check = temp.addUser(user);
		
		System.out.println(check);

		//요청 받은 데이터에 대한 컨트롤 -> 자바를 통합
	
		//자바빈: 요청된 데이터에 대한 자료처리방식
		// VO(value object) : read-only 
		// DTO(data transfer object) : 요청된 데이터를 -> 트랜잭션 처리하기 위한 -> 임시 객체
		
		// DAO : 연동된 데이터(중앙)에 대한 요청 내용 실제 처리 해주는 객체
		// Singletone 패턴 적용
	//	UserDAO dao = UserDAO.getInstance();
	//	UserDTO user = null;
		
	//	request.setCharacterEncoding("UTF-8");
	//	response.setCharacterEncoding("UTF-8");
	//	
		
	//		String id = request.getParameter("id");
	//		String password = request.getParameter("password");
	//
			
	//		UserDTO user = new UserDTO(id,password);
			
	//		String url = "";
			
	//		if(dao.loginCheck(user)){
				
				//중복으로 인한 회원가입 불가
				//join페이지로 다시 이동
			//	url = "join.jsp";
		//		session.setAttribute("log", user.getId());
		//	}
		//	else{
				//회원 가입 성공
				//login.jsp 로 이동
		//		url = "_00.index.jsp";
		//	}
			
		//	response.sendRedirect(url);
			
			  // 1. 단순 리다이렉트
			   // response.sendRedirect(url);
			   
			  // 페이지 이동한 동안많은 데이터를 가져올 경우 2,3, 번을 사용
			  // 2 가져온 값을 한번 활용한다.
			  // 3 session 영역에서 계속해서 사용이 가능함 
			   // 2. 이전 페이지에서 가져온 request & response 객체를 그대로 가져온다	   
			   // request.setAttribute("log", user.getID());  //넘긴다.
			   // request.getRequestDispatcher(url).forward(request, response);
			   
			   //3. 톰캣 세션을 활용한 session에 로그 정보넣기
				// session.setAttribute("log", user.getId());			
		%>
		
</body>
</html>