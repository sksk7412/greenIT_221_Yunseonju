package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exWeb.BoardDAO;
import exWeb.BoardDTO;

/**
 * Servlet implementation class writesAction
 */
//@WebServlet("/writesAction")
public class writesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writesAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Random ran = new Random();
		int check = -1;
		int size = BoardDAO.getInstance().getSize();
		int code = BoardDAO.getInstance().getCode();
		int viewCnt;
		int likeCnt;
		BoardDTO user = null;
		BoardDAO temp = BoardDAO.getInstance();
		
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		System.out.println("title:" + title);
		System.out.println("contents: " + contents);
		
		
		user = new BoardDTO(size,code,title,contents,0,0);	
	 		
		check = temp.addWrite(user);
		
		String url ="";
		if(check != -1){
			
			System.out.println("등록 성공");
			url = "./board/_05.board.jsp";
		
		}
		else{
			System.out.println("등록 실패");
			url = "./board/_06.boardWriteForm.jsp";

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
