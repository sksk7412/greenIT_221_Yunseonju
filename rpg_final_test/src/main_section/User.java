package main_section;

import java.util.ArrayList;

public class User {
	
	private int userCode;
	private String id;
	private String pw;
	private ArrayList<Unit> partyList;
	private ArrayList<Item> invenList;
	
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
	public ArrayList<Item> getItem(){
		return invenList;
	}
	
	public void setParty(Unit unit) {
		partyList.add(unit);
	}
	
	public void setAddItem(Item item) {
		invenList.add(item);
	}
	public void setDeleItem(Item item) {
		invenList.remove(item);
	}
}
