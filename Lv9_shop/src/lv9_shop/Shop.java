package lv9_shop;

import java.util.Scanner;

public class Shop {
	static Scanner in = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();
	
	public void menu(){
		
		while(true) {
			System.out.println("1.회원 가입 2.회원 탈퇴 3.로그인 0.종료(100.관리자)");
			System.out.println("메뉴 선택: ");
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
			System.out.println("----------------------------------------------------------");
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
			System.out.println(" [장바구니 메뉴] ");
			//장바구니 메뉴 출력
			im.printCartList(um.userList.get(um.userLog));
			
			System.out.println("1.구매 2.삭제 0.뒤로가기");
			int sel = in.nextInt();
			

			if(sel == 1) buymenu();
			else if(sel == 2) im.deletemenu(um.userList.get(um.userLog));
			else if(sel == 0) shopmenu();
			
			else
				System.out.println("다시 선택하세요.");
		}
	}
	
	// 물건구매
	public void buymenu() {
	
		im.printCartList(um.userList.get(um.userLog));
		
		//유저의 현금
		int userCash = um.userList.get(um.userLog).getMoney();
		
		System.out.printf("%s 님의 현금: [%d]\n",um.userList.get(um.userLog).getId(), userCash);
		
		System.out.println("구매할 물건번호: ");
		int sel = in.nextInt()-1;
		
		// 로그 랑 번호
		int cash = im.buyitems(um.userList.get(um.userLog), sel);
		
		System.out.println("cash: "+ cash);
		
		if(cash != -1) {
			
			if(userCash - cash >= 0 ) {
				int result = userCash - cash;
				um.userList.get(um.userLog).setMoney(result);
				System.out.println("구매 완료.");
				System.out.printf("남은 현금: [%d]\n",um.userList.get(um.userLog).getMoney());
			}
			else
				System.out.println("현금이 부족합니다.");
		}
		
	}
	//관리자
	public void managermenu() {
		//TODO
		
		//카테고리 관리 - 추가 삭제 수정
		//상품 관리 - 추가 삭제 수정
		//유저 관리 - 추가 삭제 수정
		
	}
}
