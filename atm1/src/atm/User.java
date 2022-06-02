package atm;

public class User {
	private int code, accCnt;
	private String id,pw;
	private String name;

	public User(int code, String name, String id ,String pw) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}	
	public int getCode() {
		return this.code;
	}
	public int getAccCnt() {
		return this.accCnt;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}
}
