package atm;

public class User {
	String id;
	String pw;
	Account[] accList;
	int accCount;

	public User(String id ,String pw) {
		this.id = id;
		this.pw = pw;
	}	
	
	public User(String id, String pw, Account[] accList, int accCount) {
		this.id = id;
		this.pw = pw;
		this.accList = accList;
		this.accCount = accCount;
	}
	
	public Account[] getAccList() {
		return this.accList;
	}
	public int getAccCnt() {
		return this.accCount;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public void setAccCnt(int accCount) {
		this.accCount = accCount;
	}
}
