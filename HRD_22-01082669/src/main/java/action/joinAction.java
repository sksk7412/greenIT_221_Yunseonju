package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import action.UserDAO;
import action.UserDTO;

public class joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		UserDTO user = null;
		UserDAO temp = UserDAO.getInstance();

		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String agency = request.getParameter("agency");
		String grade = request.getParameter("garde");
		String city = request.getParameter("city");
		
		System.out.println("name: "+name);
		System.out.println("grade: "+ grade);
		user = new UserDTO(name, mobile, agency, grade, city);	
		
		String url = "";
		
		
		if(!temp.addUser(user)){
			
			System.out.println("회원가입 실패!");
			url = "join.jsp";
		}
		else{
			System.out.println("회원가입 성공!");
			url = "login.jsp";
		}
		
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
