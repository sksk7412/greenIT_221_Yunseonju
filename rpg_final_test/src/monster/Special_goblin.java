package monster;

import main_section.Unit;

public class Special_goblin extends Unit{
	
	private int lv = 30;
	private int hp = 2800;
	private int power = 100;
	private int def = 60;
	
	public Special_goblin() {
		
		super("홉 고블린",15,200,25,7);
		
		int ranLv = Green_slime.ran.nextInt(lv)+8;
		int ranHp = Green_slime.ran.nextInt(hp)+500;
		int ranpower = Green_slime.ran.nextInt(power)+80;
		int randef = Green_slime.ran.nextInt(def)+30;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
}