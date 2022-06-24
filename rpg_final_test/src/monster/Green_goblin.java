package monster;

import main_section.Unit;

public class Green_goblin extends Unit{
	
	private int lv = 10;
	private int hp = 1500;
	private int power = 45;
	private int def = 20;
	
	public Green_goblin() {
		
		super("초록 고블린",5,70,25,7);
		
		int ranLv = Green_slime.ran.nextInt(lv)+3;
		int ranHp = Green_slime.ran.nextInt(hp)+500;
		int ranpower = Green_slime.ran.nextInt(power)+30;
		int randef = Green_slime.ran.nextInt(def)+15;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
}
