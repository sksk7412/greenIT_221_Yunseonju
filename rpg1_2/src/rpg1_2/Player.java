package rpg1_2;

public class Player {
	
	static int money; 					//플레이어 골드
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	
	public Player() {
		money = 300000;
		guild.set();
	}
	public void guildMenu() {
		
		guild.mainMenu();
	}

	public void invenMenu() {
		inven.mainMenu();
	}

}

