package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exWeb.UserDAO;
import exWeb.UserDTO;


/**
 * Servlet implementation class LoginAction
 */
//@WebServlet("/LoginAction")
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
		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		System.out.print(id);
		String password = request.getParameter("password");
		System.out.print(password);
		
		UserDTO us = new UserDTO(id,password);
		UserDAO userdao = UserDAO.getInstance();
		
		
		// String log = UserDAO.getInstance().getLog();
		String url = "";
		if(userdao.loginUser(id, password)){
			
			session.setAttribute("log", id);
			
			url = "./board/_04.main.jsp";
			
		}
		else{	
			url = "_00.index.jsp";
		
		}
			
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
