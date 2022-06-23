package monster;

import main_section.Unit;

public class Green_ork extends Unit{
	
	private int lv = 45;
	private int hp = 2000;
	private int power = 250;
	private int def = 65;
	
	public Green_ork() {
		
		super("그린 오크",30,450,250,5);
		
		int ranLv = Green_slime.ran.nextInt(lv)+15;
		int ranHp = Green_slime.ran.nextInt(hp)+800;
		int ranpower = Green_slime.ran.nextInt(power)+100;
		int randef = Green_slime.ran.nextInt(def)+30;
		
		setLv(ranLv);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
}
