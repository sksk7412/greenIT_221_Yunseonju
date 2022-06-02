package atm;

import java.util.Scanner;

public class Bank {
	boolean run = true;
	Scanner in = new Scanner(System.in);
	public static Bank instance = new Bank();
	
	private Bank() {
		
	}
	public void show() {
		System.out.println("=== 메뉴 선택 ===");
		System.out.println("1. 회원 가입 / 탈퇴");
		System.out.println("2. 계좌 개설 / 삭제");

		System.out.println("=============");
		int sel = in.nextInt();
		
		if(sel == 1) UserManager.createId();
		else if(sel == 2) AccountManager.createAccount();
		else
			System.out.println("다시 선택하시오.");
	}
	public void run() {
		while(run) {
			show();
		}
	}
	public void setName(String string) {
		
	}
}
