package rpg1_2;

import java.util.Random;
import java.util.Scanner;

public class Game {
	static Scanner in = new Scanner(System.in);
	static Random ran = new Random();
	
	public void menu() {
		
		Player player = new Player();
		Shop shop = new Shop();
		FileData file = new FileData();
		
		while(true) {
			System.out.println("[ 플레이어 Money: " + Player.money+" ]");
			System.out.println("=== [Main menu] ===");
			System.out.println("[1.길드메뉴] [2.상점] [3.인벤토리]");
			System.out.println("[4.저 장] [5.로 드] [0.종 료]");
			int sel = in.nextInt();
			
			if(sel == 1) player.guildMenu();
			else if(sel == 2) shop.store();
			else if(sel == 3) player.invenMenu();
			else if(sel == 4) file.save();
			else if(sel == 5) file.load();
			else if(sel == 0) break;
			else
				System.out.println("다시 선택하세요.");
		}
	}
}
