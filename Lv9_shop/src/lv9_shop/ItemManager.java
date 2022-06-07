package lv9_shop;

import java.util.Vector;


public class ItemManager {
	
	Vector<String> category = new Vector<>(); // 카테고리 정보
	Vector<Item> itemList = new Vector<>(); // 아이템 정보
	Vector<Cart> cartList = new Vector<>(); // 장바구니 정보
	
	public ItemManager(){
		set();
	}
	//초기 세팅
	public void set() {
		category.add("정육/계란");
		category.add("수산/건어물");
		category.add("과일");
		category.add("우유/유제품");
		
		Item temp = new Item("소고기", "정육/계란" ,9000);
		itemList.add(temp);
		temp = new Item("고등어", "수산/건어물" ,7000);
		itemList.add(temp);
		temp = new Item("갈치", "수산/건어물" ,6000);
		itemList.add(temp);
		temp = new Item("블루베리", "과일" ,3000);
		itemList.add(temp);
		temp = new Item("자두", "과일" ,3400);
		itemList.add(temp);
		temp = new Item("그린아카데미우유", "우유/유제품" ,2800);
		itemList.add(temp);
	}
	
	//카테고리 출력
	public void printCategory() {
		for(int i =0; i < category.size(); i++) {
			System.out.printf("[%d]. %s\n",i+1,category.get(i));
		}
	}
	//상품 전체 출력
	public void printAllItem() {
		for(int i = 0; i < itemList.size(); i++){
			System.out.printf("%d. %s [%d(won)]",i+1, itemList.get(i).getItemName(), itemList.get(i).getPrice());
		}
	}
	//상품 출력
	public String printItemList(int sel) {
		String temp = category.get(sel);
		int num = 0;
		int numSecond = 0;
		for(int i = 0; i < itemList.size(); i++ ) {
			if(itemList.get(i).getCategory().equals(temp)) {
				System.out.printf("%d. %s [%s(won)]\n",++num,itemList.get(i).getItemName(),itemList.get(i).getPrice());	
			}
		}	
		
		String selectItem = null;
		System.out.println("구매할 상품 선택: ");
		int select = Shop.in.nextInt()-1;
		
		if(select >= 0 && select < num) {
			for(int i = 0; i < itemList.size(); i++ ) {
				if(itemList.get(i).getCategory().equals(temp)) {
					
					if(numSecond == select) {
						selectItem = itemList.get(i).getItemName();
					}
					numSecond++;
				}
			}
			
			return selectItem;
		}
		else
			System.out.println("상품를 다시 선택하세요.");
		
		return null;
	}
	//장바구니 출력
	public void printCartList(User e) {
		
		for(int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getUserId().equals(e.getId())) {
				System.out.printf("%d. %s", i+1, cartList.get(i).getItemName());
			}
			for(int j = 0; j < itemList.size(); j++) {
				if(itemList.get(j).getItemName().equals(cartList.get(i).getItemName())) {
					System.out.printf("[%d(won)]\n",itemList.get(j).getPrice());	
				}
			}
		}	
	}

	//장바구니 목록 삭제
	public void deletemenu(User e) {
		boolean check = false;
		//상품이 있는지 체크
		for(int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getUserId().equals(e.getId())){
				check = true;
			}
		}
		if(check) {
			printCartList(e);
			
			System.out.println("삭제할 상품 선택: ");
			int sel = Shop.in.nextInt()-1;
			
			int num = 0;
			int deleteItem = -1;
			for(int i = 0; i < cartList.size(); i++) {
				if(cartList.get(i).getUserId().equals(e.getId())) {	
					if(sel == num) {
						deleteItem = i;
					}
					num++;
				}
			}
			if(deleteItem != -1) {
				cartList.remove(deleteItem);
				System.out.println(" 삭제 완료 ");
			}
			else
				System.out.println("다시 선택하세요.");
			
		}
		else
			System.out.println("상품을 먼저 장바구니에 넣어주세요.");
	}
	
	//물건구매
	public int buyitems(User e , int sel) {
		boolean check = false;
		//상품이 있는지 체크
		for(int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getUserId().equals(e.getId())){
				check = true;
			}
		}
		
		int cash = -1;  // 리턴할 물건 가격
		int num = 0;   // 체크용 변수
		int deleteItem = -1;  //삭제할 장바구니 인덱스
		if(check) {
			
			for(int i = 0; i < cartList.size(); i++) {
				if(cartList.get(i).getUserId().equals(e.getId())) {	
					
					if(sel == num) {
						deleteItem = i;
					}
					num++;
				}
			}
			
			if(deleteItem != -1) {
				
				//장바구니 물건 가격 찾기.
				for(int i = 0; i < itemList.size(); i++) {
					if(itemList.get(i).getItemName().equals(cartList.get(deleteItem).getItemName())) {
						cash = itemList.get(i).getPrice();
					}
				}
				
				cartList.remove(deleteItem); //장바구니 물건 remove
				return cash;
			}
			else
				System.out.println("다시 선택하세요.");
			
		}
		else
			System.out.println("상품을 먼저 장바구니에 넣어주세요.");
		
		return -1;
		
	} 
	
	//카테고리 추가
	public void addCategory() {
		System.out.println("[카테고리추가] 카테고리 이름을 입력하세요. ");
		String name = Shop.in.next();
		category.add(name);
	}
	//카테고리 삭제
	public void deleteCategory() {
		boolean check = false;
		System.out.println("[카테고리삭제] 카테고리 이름을 입력하세요: ");
		String name = Shop.in.next();
		
		for(int i = 0; i < category.size(); i++) {
			if(category.get(i).equals(name)) {
				check = true;
			}
		}
		
		if(check) {
			category.remove(name);
		}
		else
			System.out.println("카테고리를 다시 한 번 확인해주세요.");
	}
	//아이템 추가
	public void addItem() {
		System.out.println("[아이템추가] 아이템이름을 입력하세요: ");
		String name =  Shop.in.next();
		System.out.println("[아이템추가] 가격을 입력하세요: ");
		int price =  Shop.in.nextInt();
		printCategory();
		System.out.println("[아이템추가] 카테고리를 입력하세요: ");
		int sel =  Shop.in.nextInt();
		Item temp = new Item(name,category.get(sel),price);
		itemList.add(temp);
		
	}
	//아이템 삭제
	public void deleteItem() {
		int check = -1;
		System.out.println("[아이템삭제] 아이템 이름을 입력하세요: ");
		String name = Shop.in.next();
		
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getItemName().equals(name)) {
				check = i;
			}
		}
		
		if(check != -1) {
			itemList.remove(check);
			System.out.println("삭제 완료.");
		}
		else
			System.out.println("아이템 이름을 다시 확인해주세요.");
		
	}
}
