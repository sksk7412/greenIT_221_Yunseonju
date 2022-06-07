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
	//상품 출력
	public String printItemList(int sel) {
		String temp = category.get(sel);
		int num = 0;
		int numSecond = 0;
		for(int i = 0; i < itemList.size(); i++ ) {
			if(itemList.get(i).getCategory().equals(temp)) {
				System.out.printf("%d. %s\n",++num,itemList.get(i).getItemName());	
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
	public void printCartList() {
		
	}
	//카테고리 추가
	void addCategory() {
		System.out.println("[카테고리추가] 카테고리 이름을 입력하세요. ");
		String name = Shop.in.next();
		category.add(name);
	}
}
