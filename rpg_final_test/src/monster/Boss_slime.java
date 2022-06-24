package monster;

import main_section.Unit;

public class Boss_slime extends Unit{
	
	private int lv = 10;
	private int hp = 1000;
	private int power = 150;
	private int def = 10;
	
	public Boss_slime() {
		
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