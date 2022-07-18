package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBManager;

public class UserDAO {


	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	
	private String url="jdbc:oracle:thin:@//localhost:1521/xe";
	 String user = "c##system";
	private String password="1234";
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //
			conn=DriverManager.getConnection(url,user,password);
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		} 
	}
	
	public boolean addUser(UserDTO userDto){

		try {
			conn = DBManager.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println( userDto.getCustname());
		try {
			String sql = String.format("insert into member_tbl_02 values('%d','%s','%s','%s','%s',%s,%s)", userDto.getCustno(), userDto.getCustname(), userDto.getPhone(),userDto.getAddress(),userDto.getCreate(),userDto.getGrade(),userDto.getCity());
			pstmt = conn.prepareStatement(sql);
			
			pstmt.execute();
			System.out.println("회원 추가 성공");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert fail");
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	return false;
	}
	
}
