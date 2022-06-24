package monster;

import main_section.Unit;

public class Red_goblin extends Unit{
	
	private int lv = 20;
	private int hp = 2000;
	private int power = 85;
	private int def = 50;
	
	public Red_goblin() {
		
		super("빨간 고블린",5,70,25,7);
		
		int ranLv = Green_slime.ran.nextInt(lv)+5;
		int ranHp = Green_slime.ran.nextInt(hp)+550;
		int ranpower = Green_slime.ran.nextInt(power)+50;
		int randef = Green_slime.ran.nextInt(def)+20;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
}
