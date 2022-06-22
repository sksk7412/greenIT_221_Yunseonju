package main_section;

import java.util.Random;
import java.util.Scanner;

import user_section.Player;
import user_section.FileData;


public class Lobby{
	
	static Scanner in = new Scanner(System.in);
	static Random ran = new Random();
	
	public void menu() {
		
		Player player = new Player();
		Shop shop = new Shop();
		Dungeon dungeon = new Dungeon();
		FileData file = new FileData();
	
		//로드는 자동으로
		while(true) {
			System.out.println("[ Player Gold: " + Player.money+" ]");
			System.out.println("=== [Main menu] ===");
			System.out.println("[1.파티메뉴] [2.상점] [3.인벤토리] [4.던전 입장]");
			System.out.println("[8.저 장] [0.뒤로 가기]");
			int sel = in.nextInt();
		//	선주바보
			
			if(sel == 1) player.partyList();
			else if(sel == 2) shop.store();
			else if(sel == 3) player.invenMenu();
			else if(sel == 4) dungeon.menu();
			else if(sel == 8) file.save();
			else if(sel == 0) break;
			else
				System.out.println("다시 선택하세요.");
		}
	}
}









