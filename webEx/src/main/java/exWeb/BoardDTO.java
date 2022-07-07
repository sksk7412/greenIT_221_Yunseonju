package exWeb;

import java.sql.Timestamp;
import java.util.Date;

public class BoardDTO {
	
	private int no,code;
	private String title, contents;
	private int viewCnt,likeCnt;
	private Timestamp createdAt,modifiedAt;
	
	public BoardDTO(int no, int code, String title, String contents, int viewCnt, int likeCnt ) {
		this.no = no;
		this.code = code;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;

	}
	
	public BoardDTO(int no, int code, String title, String contents, int viewCnt, int likeCnt, Timestamp createdAt, Timestamp modifiedAt ) {
		this.no = no;
		this.code = code;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;

	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	public int getNo() {
		return no;
	}

	public int getCode() {
		return code;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

}
