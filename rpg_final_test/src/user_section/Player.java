package user_section;

public class Player {
	
	public static int money;
	static Party party = new Party();
	static Inventory inven = new Inventory();
	
	public Player() {
		money = 300000;
		party.set();
	}
	
	public void partyList() {
		party.menu();
		
	}

	public void invenMenu() {
		// TODO Auto-generated method stub
		inven.menu();
	}

}
