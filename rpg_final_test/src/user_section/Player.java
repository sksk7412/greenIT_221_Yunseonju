package user_section;

import main_section.Skill;
import main_section.Unit;

public class Player extends Unit implements Skill{
	
	public static int money;
	static Party parties = new Party();
	static Inventory inven = new Inventory();
	
	public Player(String name,String job ,int lv, int hp, int power, int def) {
		super(name,job ,lv, hp, power, def);
	}
	
	public static void partyList() {
		parties.menu();
		
	}
	public static void invenMenu() {
		inven.menu();
	}

	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
