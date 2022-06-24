package monster;

import main_section.Unit;

public class Special_ork extends Unit{
	
	private int lv = 60;
	private int hp = 3000;
	private int power = 350;
	private int def = 80;
	
	public Special_ork() {
		
		super("오크 마스터",30,450,250,5);
		
		int ranLv = Green_slime.ran.nextInt(lv)+20;
		int ranHp = Green_slime.ran.nextInt(hp)+900;
		int ranpower = Green_slime.ran.nextInt(power)+180;
		int randef = Green_slime.ran.nextInt(def)+55;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
}