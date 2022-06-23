package user_section;

import main_section.Unit;

public class Player extends Unit{
	
	public static int money;
	static Party parties = new Party();
	static Inventory inven = new Inventory();
	
	public Player(String name,String job ,int lv, int hp, int power, int def) {
		super(name,job ,lv, hp, power, def);
		// TODO Auto-generated constructor stub
	}
	
	public static void partyList() {
		parties.menu();
		
	}
	public static void invenMenu() {
		// TODO Auto-generated method stub
		inven.menu();
	}

}
