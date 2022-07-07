package exWeb;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import util.DBmanager;

public class BoardDAO {
	
	private BoardDAO() {
//		list = new ArrayList<UserDTO>();
	}
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
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
	Random ran = new Random();
	
	// DB에서 값을 받는다.
	public Map getMap() {
		Map<Integer, BoardDTO> boardData = new HashMap<>();

		conn = DBmanager.getConnection("firstjsp");
		String sql = "select * from board";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int no, code, viewCnt, likeCnt;
			String title, content;
			Timestamp createdAt;
			Timestamp modifiedAt;

			
			while (rs.next()) {
				no = rs.getInt(1);
				code = rs.getInt(2);
				title = rs.getString(3);
				content = rs.getString(4);
				viewCnt = rs.getInt(5);
				likeCnt = rs.getInt(6);
				createdAt = rs.getTimestamp(7);
				modifiedAt = rs.getTimestamp(8);
								
				BoardDTO bd = new BoardDTO(no, code, title, content, viewCnt, likeCnt, createdAt, modifiedAt);
				
				boardData.put(no, bd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardData;
	}
	
	// DB에 값 넣기
	public int addWrite(BoardDTO BoardDto) {
		
		conn = DBmanager.getConnection(database);
		System.out.println("conn: "+conn);	
		String SQL = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?)";
 	
		try {
			
			System.out.println("code: "+BoardDto.getCode());
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, BoardDto.getNo());
			pstmt.setInt(2, BoardDto.getCode());
			pstmt.setString(3, BoardDto.getTitle());
			pstmt.setString(4, BoardDto.getContents());
			pstmt.setInt(5, BoardDto.getViewCnt());
			pstmt.setInt(6, BoardDto.getLikeCnt());
			Timestamp createAt = new Timestamp(System.currentTimeMillis());
			//pstmt.setString(4, createAt.toString());
			pstmt.setTimestamp(7, createAt);
			pstmt.setTimestamp(8, null);
		
			
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//code 값
	public int getCode() {
			int code = ran.nextInt(8999)+1000;
			conn = DBmanager.getConnection("firstjsp");
			String sql = "select * from board where code = ? ";
			
			try {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, code);
					
					rs = pstmt.executeQuery();
					while(true) {
						 code = ran.nextInt(8999)+1000;
						
						if(!rs.next()) {
							return code;
						}
					
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			return -1;
		
	}
	
	//게시글 크기 측정
	public int getSize() {
		conn = DBmanager.getConnection("firstJsp");
		String sql = "select count(*) from board";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();
			int size = rs.getInt(1);

			return size+1;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return -1;
	}
}
