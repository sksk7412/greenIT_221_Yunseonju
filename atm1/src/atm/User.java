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
	public void infoPrint() {
		System.out.println("아이디\t비밀번호\t계좌정보");
		if(accCount == 0) {
			System.out.println( id +"\t"+ pw +"\t"+ "계좌를 개설하세요.");		
		}
		else {
			System.out.printf(id +"\t "+ pw +" ");
			System.out.println();
			for(int i =0; i < accCount; i++) {
				System.out.println("\t\t계좌번호: " +accList[i].number +"/ 금액: "+accList[i].money);
			}
		}
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
