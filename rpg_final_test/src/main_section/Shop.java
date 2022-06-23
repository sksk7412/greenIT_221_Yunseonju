package main_section;

import java.util.ArrayList;
import user_section.Player;
import user_section.Inventory;

public class Shop{
//	Inventory inventory = new Inventory();
	ArrayList<Item> itemList = new ArrayList<>();

	public void shopSet() {
		
		itemList.add(new Item(1, "나무검", 10, 1000));
		itemList.add(new Item(1, "데몬 엑스", 35, 10000));
		itemList.add(new Item(1, "알리샤의 스태프", 55, 32000));
		itemList.add(new Item(1, "샤프니스 섀도우", 85, 66000));
		
		itemList.add(new Item(2, "낡은 흰티", 16, 3000));
		itemList.add(new Item(2, "핑크빈 모자", 35, 36500));
		itemList.add(new Item(2, "하이네스 워리어헬름", 58, 68000));
		itemList.add(new Item(2, "앱솔 판금갑옷", 79, 88000));
		
		itemList.add(new Item(3, "낡은 목걸이", 15, 7000));
		itemList.add(new Item(3, "보석 반지", 50, 1200));
		itemList.add(new Item(3, "하프 이어링", 80, 66000));
		itemList.add(new Item(3, "아쿠아리움 반지", 100, 99000));
	}
	// 메뉴 출력
	public void store() {
		
		while(true) {
			System.out.println();
			System.out.printf("\t=== [상 점] === [ Money: %d ]\n",Player.money);
			System.out.println("[1.무기 상점][2.방어구 상정][3.악세사리 상점] [0.뒤로가기]");
			System.out.println("선택: ");
			int sel = Lobby.in.nextInt();
			
			if(sel > 0 && sel < 4) itemPrint(sel);
			else if(sel == 0) break;
			else
				System.err.println("다시 입력하세요.");
		}
	}

	//상점 출력
	private void itemPrint(int sel) {
		int index = -1;
		int count = 0;
		System.out.println("==============================");
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getKind() == sel) {
				System.out.printf("[%d] ",i+1);
				itemList.get(i).printItem();
			}
		}
		System.out.println("==============================");
		count = 0;
		System.out.println("원하는 물품을 고르시오: [0.뒤로가기]");
		int choose = Lobby.in.nextInt();
		
		if(choose == 0) store();
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getKind() == sel) {
				count++;
				if(choose == count) {
					index = i;
				}
				
			}
		}
		//물건 구매
		if(index != -1) {
			if(Player.money >= itemList.get(index).getPrice()) {
				Item temp = new Item(itemList.get(index).getKind(), itemList.get(index).getName(), itemList.get(index).getPower(), itemList.get(index).getPrice());
				Inventory.invenList.add(temp);		
				Player.money -= temp.getPrice();
				UserManager.getInstance().getUser().setAddItem(temp);
				System.out.printf("[ %s ] 구매완료.\n",temp.getName());
			}
			else
				System.err.println(" 골드가 부족합니다.");
		}
		else
			System.err.println("번호를 다시 선택하시오.");
	}

}
