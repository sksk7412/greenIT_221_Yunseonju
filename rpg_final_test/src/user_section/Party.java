package user_section;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import main_section.UserManager;
import main_section.Unit;

public class Party{

	public static Scanner in = new Scanner(System.in);
	public static Random ran = new Random();
	
	public static ArrayList<Player> partyList = new ArrayList<>();
	
//	static Unit[] partyList = new Unit[4];
	
	//파티 생성
	public Party() {
		partyList.add(new Player("킬리언 머피","전사",1, 1000, 35, 99));
		partyList.add(new Player("고죠 사토루","전사", 1, 1200, 40, 80));
		partyList.add(new Player("옷코츠 유타","마법사", 1, 500, 80, 25));
		partyList.add(new Player("김지연","힐러", 1, 650, 20, 35));
	}
	
	//메인 메뉴
	public void menu() {
		while(true) {
			System.out.println(" === [파티 메뉴]=== ");
			System.out.printf("[Money: %d ]\n",Player.money);
			System.out.println("[1.파티원 현황] [2.아이템 현황] [3.치료소 / 부활소]");
			System.out.println("[0.뒤로가기]");
			int sel = in.nextInt();
			
			if(sel == 1) printParty();
			else if(sel == 2) printItem();
			else if(sel == 3) remedy();
			else if(sel == 0) break;
		}
	}
	
	//파티원 상태출력
	private void printParty() {
		for(int i = 0; i < partyList.size(); i++) {
			System.out.printf("[%d] ",i+1);
			partyList.get(i).printState();
		}
		System.out.println();
	}
	
	//파티원 아이템 출력
	private void printItem() {
		for(int i = 0; i < partyList.size(); i++) {
			System.out.printf("[%d] ",i+1);
			partyList.get(i).itemState();
		}
		System.out.println();
	}
	
	//치료 / 부활소
	private void remedy() {
		
		while(true) {
			System.out.println("=== [ 치료소 / 부활소] ===");
			printParty();
			
			System.out.println("치료/ 부활 할 파티원 선택: (0.뒤로가기)");
			int selIdx = in.nextInt()-1;
			
			if(selIdx >=0 && selIdx < partyList.size()) {
				Player temp = partyList.get(selIdx);
				if(temp.getHp() < temp.getMaXhp() || temp.getAlive() == false) {
					
					System.out.printf("[Player Gold: %d]\n",Player.money);
					System.out.println("[치료 / 부활 비용: 10000 G]");
					System.out.println("치료하시겠습니까?");
					System.out.println("[1.예] [2.아니오]");
					int hell = in.nextInt();
					
					if(hell == 1) {
						if(Player.money >= 10000) {
							
							temp.setAlive(true);
							temp.setHp(temp.getMaXhp());
							Player.money -= 10000;
							System.out.println("[치료 / 부활 완료]");
						}
						else {
							System.out.println("골드가 부족합니다.");
							break;
						}
					}
					else break;
						
				}
				else
					System.err.println("해당 파티원은 치료가 필요없습니다.");
			}
			else if(selIdx == -1)break;
			else
				System.err.println("다시 선택하시오.");
		}
	}

}
