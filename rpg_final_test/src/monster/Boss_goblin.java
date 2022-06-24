package monster;

import main_section.Unit;

public class Boss_goblin extends Unit{
	
	public String skill;
	private int lv = 25;
	private int hp = 1500;
	private int power = 250;
	private int def = 10;
	
	public Boss_goblin() {
		
		super("고블린 슬레이어",5,50,15,5);
		int ranLv = Green_slime.ran.nextInt(lv)+3;
		int ranHp = Green_slime.ran.nextInt(hp)+300;
		int ranpower = Green_slime.ran.nextInt(power)+150;
		int randef = Green_slime.ran.nextInt(def)+5;
		String skill ="죽음의 독침";
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
	
}