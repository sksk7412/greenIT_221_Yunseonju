package monster;

import main_section.Unit;

public class Boss_ork extends Unit{
	
	private int lv = 5;
	private int hp = 300;
	private int power = 100;
	private int def = 10;
	
	public Boss_ork() {
		
		super("머쉬맘",5,50,15,5);
		int ranLv = Green_slime.ran.nextInt(lv)+1;
		int ranHp = Green_slime.ran.nextInt(hp)+300;
		int ranpower = Green_slime.ran.nextInt(power)+10;
		int randef = Green_slime.ran.nextInt(def)+5;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
	
}