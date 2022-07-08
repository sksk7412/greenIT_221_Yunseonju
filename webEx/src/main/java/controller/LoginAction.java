package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exWeb.UserDAO;
import exWeb.UserDTO;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//doGet() 메소드: http request method - GET
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		UserDAO dao = UserDAO.getInstance();
		//	UserDTO user = null;
		
			String id = request.getParameter("id");
			String password = request.getParameter("password");
	
			
			UserDTO user = new UserDTO(id,password);
			
			String url = "";
			
			if(dao.loginCheck(user)){
				
				//중복으로 인한 회원가입 불가
				//join페이지로 다시 이동
				url = "join.jsp";
			//	session.setAttribute("log", user.getId());
			}
			else{
				//회원 가입 성공
				//login.jsp 로 이동
				url = "_00.index.jsp";     
			}
			
		response.sendRedirect(url);
			
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doPost() 메소드: http request method - post
	
		doGet(request, response);
	
	}

}
