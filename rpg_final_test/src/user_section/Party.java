package user_section;

import java.util.ArrayList;
import java.util.Scanner;
import main_section.Unit;


public class Party{
	static Scanner in = new Scanner(System.in);
	
	ArrayList<Unit> party = new ArrayList<>();
	
	public void set() {
		Unit unit = new Unit("김지연",1,500,65,true);
		party.add(unit);
		unit = new Unit("킬리언 머피",1,450,80,true);
		party.add(unit);
		unit = new Unit("고죠 사토루",1,800,75,true);
		party.add(unit);
		unit = new Unit("옷코츠 유타",1,1000,55,true);
		party.add(unit);
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
		for(int i = 0; i < ) {
			
		}
	}
	
	private void printItem() {
		// TODO Auto-generated method stub
		
	}

	private void remedy() {
		// TODO Auto-generated method stub
		
	}




	
	
}
