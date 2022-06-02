package atm;

public class Main {

	public static void main(String[] args) {
		//atm
		// 회원 한명당 계좌는 3개
		
		// 1. 회원가입/탈퇴
		// User
		// UserManager
		// 2. 계좌개설/해지
		// Account
		// AccountManager
		
		// 3. atm 운영
		// bank run?
		
//		Bank.instance.setName("Green");
		Bank.instance.run();
	}

}
