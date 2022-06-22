package user_section;

import java.util.ArrayList;
import main_section.Item;
public class Inventory {

	public static ArrayList<Item> invenList = new ArrayList<>();
	
	public void menu() {
		
		while(true) {
		
			System.out.println(" === [인벤토리 메뉴] === ");
			System.out.printf("[Player Money: %d]\n",Player.money);
			System.out.println("[1.인벤토리 출력][2.아이템 착용][3.아이템 판매(세금50%)][0.뒤로가기]");
			int sel = Party.in.nextInt();
			
			if(sel == 1) printInvenList();
			else if(sel == 2) wearItem();
			else if(sel == 3) sellItem();
			else if(sel == 0) break;
			else
				System.err.println("다시 입력하세요.");
		}
	}
	
	//인벤토리 아이템 출력
	public void printInvenList() {
		for(int i = 0; i < invenList.size(); i ++) {
			System.out.printf("[%d] ",i+1);
			invenList.get(i).printItem();
		}
	}
	
	private void wearItem() {
		// TODO Auto-generated method stub
		
	}
	private void sellItem() {

		printInvenList();
		
		System.out.println("판매할 아이템 번호: ");
		int sellItem = Party.in.nextInt()-1;
		
		if(sellItem >= 0 && sellItem < invenList.size()) {
			
			Player.money += invenList.get(sellItem).getPrice() * 0.5;
			System.out.printf("[%s] 아이템 판매 완료\n",invenList.get(sellItem).getName());
			invenList.remove(sellItem);
		}
	}

}
