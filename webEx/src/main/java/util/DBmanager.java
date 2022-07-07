package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBmanager {

	// DBManager.getConnection();
	// 외부 클래스에서 디비 연동이 필요할때 사용가능 Connection을 얻어간다. 
	
	public static Connection getConnection(String database) { 
		 Connection conn = null;
		 String url = "jdbc:mysql://localhost:3306/";
		
		 String user = "root";
		 String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+database, user, password);
			System.out.println("DB 연동 성공");
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패");
			return null;
		}
	}
	
}
