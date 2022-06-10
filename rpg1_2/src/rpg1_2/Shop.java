package rpg1_2;

import java.util.ArrayList;

public class Shop {

	ArrayList<Item> itemList = new ArrayList<>();	
	
	public Shop() {
		Item temp = new Item(1,"나무검",10,1000);
		itemList.add(temp);
		temp = new Item(1,"철검",20,3000);
		itemList.add(temp);
		temp = new Item(1,"레이피어",42,6000);
		itemList.add(temp);
		temp = new Item(2,"나무갑옷",10,1000);
		itemList.add(temp);
		temp = new Item(2,"철갑옷",20,3000);
		itemList.add(temp);
		temp = new Item(2,"아다만티움갑옷",68,62000);
		itemList.add(temp);
		temp = new Item(3,"소망의반지",30,43000);
		itemList.add(temp);
		temp = new Item(3,"희망의귀걸이",25,23000);
		itemList.add(temp);
		temp = new Item(3,"어둠의반지",41,60000);
		itemList.add(temp);
	}
	
	public void store() {
		
		while(true){
			System.out.println("[ 플레이어 Money: " + Player.money+" ]");
			System.out.println("=== [Store menu] ===");
			System.out.println("1.무기 상점 2.방어구 상점 3.악세사리 상점");
			System.out.println("0.뒤로가기");
			int sel = Game.in.nextInt();
			
			if(sel == 1) {
				System.out.println("\t=== [무기 상점] ===");
				printItem(Item.Weapon);
			}
			else if(sel == 2) {
				System.out.println("\t=== [방어구 상점] ===");
				printItem(Item.Armor);
			}
			else if(sel == 3){
				System.out.println("\t=== [악세사리 상점] ===");
				printItem(Item.Ring);
			}
			else if(sel == 0) break;
			else
				System.out.println("다시 선택하시오");
		}
	}
	public void printItem(int itemType) {
		
		int num = 0;
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).kind == itemType) {
				System.out.printf("[%d] ",num+1);
				itemList.get(i).printItem();
				System.out.println();
				num++;
			}
		}
		buyItem(itemType);
	}
	
	public void buyItem(int itemType) {
		int check = -1;
		int number = 0;
		System.out.println("원하는 아이템 번호: [0.뒤로가기]");
		int sel = Game.in.nextInt()-1;
		
		if(sel == -1) store();
		else {
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i).kind == itemType) {
					if(sel == number) {
						check = i;
					}
					number++;
				}
			}			
		}
		
		if(check != -1) {
			
			int money = Player.money - itemList.get(check).price;
			
			if(money >= 0) {
				Inventory.inven.add(itemList.get(check));
				Player.money -= itemList.get(check).price;
				System.out.println("물건 구매완료");
			}
			else
				System.out.println("골드가 부족합니다.");
		}
		else
			System.out.println("아이템 번호를 다시 확인하시오.");
	}
}



