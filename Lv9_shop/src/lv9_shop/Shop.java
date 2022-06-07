package lv9_shop;

import java.util.Scanner;

public class Shop {
	static Scanner in = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void menu(){
		
		System.out.println("1.회원 가입 2.회원 탈퇴 3.로그인 0.종료(100.관리자)");
		int sel = in.nextInt();
		
		if(sel == 1) um.join();
		else if(sel == 2)
		else if(sel == 3)
		else if(sel == 0)
		else if(sel == 100)
		else
			System.out.println("다시 선택하시오.");
	}
}
