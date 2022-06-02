package atm;

import java.util.Scanner;

public class Bank {
	boolean run = true;
	Scanner in = new Scanner(System.in);
	public static Bank instance = new Bank();

	public void print() {
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
	public void show() {
		for(int i =0; i < UserManager.user.size(); i++) {
			System.out.println(UserManager.user.get(i).getCode() +". "+UserManager.user.get(i).getName());
		}
	}
	public void run() {
		while(run) {
			show();
			print();
		}
	}
	public void setName(String string) {
		
	}
}
