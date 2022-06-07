package lv9_shop;

public class User {

	private String id;
	private String pw;
	private int money;

	public User(String id,String pw,int money) {
		this.id = id;
		this.pw = pw;
		this.money = money;
	}
	//get
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public int getMoney() {
		return money;
	}
	//set
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void print() {
		System.out.println("[" + id + "] " + "금액 : " + money);
	}
}
