package user_section;

import java.util.ArrayList;
import main_section.Item;
public class Inventory {

	public static ArrayList<Item> invenList = new ArrayList<>();
	
	public void menu() {
		
		while(true) {
		
			System.out.println(" === [인벤토리 메뉴] === ");
			System.out.println("[1.인벤토리 출력][2. ][3. ]");
		}
	}
	
	//인벤토리 아이템 출력
	public void printInvenList() {
		for(int i = 0; i < invenList.size(); i ++) {
			invenList.get(i).printItem();
		}
	}
}
