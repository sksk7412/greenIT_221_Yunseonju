package exWeb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import util.DBmanager;


public class UserDAO {
	// �̱���
	ArrayList<UserDTO> list = null;
	//데이터 베이스 연동 후 , 유저 관리
	
	private UserDAO() {
		list = new ArrayList<UserDTO>();
	}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private String log;
	private String url = "jdbc:mysql://localhost:3306/";
	private String database = "firstjsp";
	private String user = "root";
	private String password = "root";
	
//	public Connection getConnection() {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("DB 연동 성공~");
//			return conn;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("DB 연동 실패");
//			return null;
//		}
//	}
	
	public int addUser(UserDTO userDto) {
		
		conn = DBmanager.getConnection(database);
		
		System.out.println("conn: "+conn);
		
		String SQL = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?)";
		Date date = new Date(userDto.getYear()-1900, userDto.getMonth(), userDto.getDay());
		
		Timestamp birthdate = new Timestamp(date.getTime());
		
		try {
			
			System.out.println(userDto.getName());
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setTimestamp(4, birthdate);
			pstmt.setInt(5, userDto.getGender() == "woman" ? 1 : 0 );
			pstmt.setString(6, userDto.getEmail());
			pstmt.setString(7, userDto.getCountry());
			pstmt.setString(8, userDto.getMobile());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 로그인 (맞나?)
	public boolean loginUser(String id, String pw) {
		
		conn = DBmanager.getConnection(database);
		
		//String str = "select name from users where id = '"+ id +"' and password = '"+ pw +"'";
	//	select name from users where id = "" and password = "";
//		String str = "select * from firstjsp.users where id = ? and password = ? ";
		String str = "select * from users where id = ? and password = ?";

		try {

			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			System.out.println("id: " + id);
			System.out.println("password: " + pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			
				log = rs.getString(1);
				pstmt.close();
				rs.close();
				return true;
			}
			else {
				pstmt.close();
				rs.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getLog() {
		return log;
	}
	
	public boolean logOut() {
		if(log == null)
			return false;
		else {
			log = null;
			return true;
		}
	}	
	
	
//	//회원 추가
//	public int addUser(UserDTO userDto) {
//		// 중복 아이디 확인 후 LIST에 추가
//		if(checkDupl(userDto.getId())) {
//			this.list.add(userDto);
//			return this.list.size()-1;
//		}
//		
//		return -1;
//	}
//	
	public boolean loginCheck(UserDTO userDto) {
		for(UserDTO user: this.list) {
			if(user.getId().equals(userDto.getId())) {
				return true;
			}
		}
		return false;
	}
//	
//	public boolean checkDupl(String id) {
//		
//		for(UserDTO user: this.list) {
//			if(user.getId().equals(id))
//				return false;
//		}
//		return true;
//	}
}
