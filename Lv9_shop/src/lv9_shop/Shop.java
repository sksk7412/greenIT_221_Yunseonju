package lv9_shop;

import java.util.Scanner;

public class Shop {
	static Scanner in = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void menu(){
		
		while(true) {
			System.out.println("1.회원 가입 2.회원 탈퇴 3.로그인 0.종료(100.관리자)");
			int sel = in.nextInt();
			
			if(sel == 1) um.join();
			else if(sel == 2) um.delete();
			else if(sel == 3) {
				um.logIn();
				if(um.userLog != -1) shopmenu();
			}
			else if(sel == 0) break;
			else if(sel == 100) managermenu();
			else
				System.out.println("다시 선택하시오.");
		}
	}
	//로그인 후 메뉴
	public void shopmenu() {
		while(true) {
			System.out.printf("[메세지]  %s님 로그인.\n",um.userList.get(um.userLog).getId());
			System.out.println("1.쇼핑 2.장바구니 0.로그아웃");
			int sel = in.nextInt();
			
			if(sel == 1) shoppingmenu();
			else if(sel == 2) cartmenu();
			else if(sel == 0) {
				um.logOut();
				menu();
			}
			else
				System.out.println("다시 선택하세요.");
			
		}
	}
	//쇼핑 메뉴
	public void shoppingmenu() {
		//카테고리 출력
		im.printCategory();
		System.out.println("카테고리 메뉴 선택: ");
		int sel = in.nextInt()-1;
		
		//카테고리 아이템 출력
		if(sel >= 0 && sel < im.category.size()) {
			String temp = im.printItemList(sel);
			if(temp != null) {
				System.out.printf("[ %s ] 상품을(를) 선택하셨습니다.\n", temp);
				Cart cart = new Cart(um.userList.get(um.userLog).getId(),temp);
				
				im.cartList.add(cart);
				System.out.println("장바구니 목록에 저장.");
			}
			else
				System.out.println("메뉴를 다시 확인하세요.");		
		}
		else
			System.out.println("메뉴를 다시 확인하세요.");
	}
	//장바구니 메뉴
	public void cartmenu() {
		
		while(true) {
			
			//장바구니 메뉴 출력
			im.printCartList();
			
			System.out.println("1.구매 2.삭제 0.뒤로가기");
			int sel = in.nextInt();
			

			if(sel == 1) shoppingmenu();
			else if(sel == 2) cartmenu();
			else if(sel == 0) break;
		
			
		}
	}
	//관리자
	public void managermenu() {
		//TODO
		
	}
}
