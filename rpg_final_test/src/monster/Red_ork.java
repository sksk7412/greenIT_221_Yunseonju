package monster;

import main_section.Unit;

public class Red_ork extends Unit{
	
	private int lv = 60;
	private int hp = 1000;
	private int power = 350;
	private int def = 80;
	
	public Red_ork() {
		
		super("빨간 오크",30,450,250,5);
		
		int ranLv = Green_slime.ran.nextInt(lv)+17;
		int ranHp = Green_slime.ran.nextInt(hp)+550;
		int ranpower = Green_slime.ran.nextInt(power)+150;
		int randef = Green_slime.ran.nextInt(def)+40;
		
		setLv(ranLv);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
}