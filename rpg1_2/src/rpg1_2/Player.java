package rpg1_2;

public class Player {
	
	static int money;
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	
	public Player() {
		money = 100000;
		guild.set();
	}
	public void guildMenu() {
		
		guild.mainMenu();
	}

	public void invenMenu() {
		// TODO Auto-generated method stub
		inven.mainMenu();
	}

}

