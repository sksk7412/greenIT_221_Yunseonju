package main_section;

import java.util.ArrayList;

public class User {
	
	private int userCode;
	private String id;
	private String pw;
	private ArrayList<Unit> partyList;
	
	public User(String id, String pw, int code) {
		this.id = id;
		this.pw = pw;
		this.userCode = code;
		partyList = new ArrayList<>();
	}
	
	public int getCode() {
		return userCode;
	}

	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public ArrayList<Unit> getParty(){
		return partyList;
	}
}
