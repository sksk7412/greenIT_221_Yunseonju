package user_section;

import java.util.ArrayList;
import java.util.Scanner;
import main_section.Unit;

public class Party{

	static Scanner in = new Scanner(System.in);
	
	static ArrayList<Player> party = new ArrayList<>();
	
	public Party() {
		party.add(new Player("킬리언 머피","전사",1, 1000, 35, 99));
		party.add(new Player("고죠 사토루","전사", 1, 1200, 40, 80));
		party.add(new Player("옷코츠 유타","마법사", 1, 500, 80, 25));
		party.add(new Player("김지연","힐러", 1, 650, 20, 35));
	}

	public void menu() {
		while(true) {
			System.out.println(" === [파티 메뉴]=== ");
			System.out.printf("[Money: %d ]\n",Player.money);
			System.out.println("[1.파티원 현황][2.아이템 현황][3.치료소 / 부활소]");
			System.out.println("[0.뒤로가기]");
			int sel = in.nextInt();
			
			if(sel == 1) printParty();
			else if(sel == 2) printItem();
			else if(sel == 3) remedy();
			else if(sel == 0) break;
		}
	}

	private void printParty() {
		for(int i = 0; i < party.size(); i++) {
			party.get(i).printState();
		}
	}
	
	private void printItem() {
		for(int i = 0; i < party.size(); i++) {
			party.get(i).itemState();
		}
		
	}

	private void remedy() {
		// TODO Auto-generated method stub
		
	}

}
