package monster;

import main_section.Unit;

public class Boss_ork extends Unit{
	
	public String skill;
	private int lv = 30;
	private int hp = 2000;
	private int power = 450;
	private int def = 10;
	
	public Boss_ork() {
		
		super("오크 족장",5,50,15,5);
		int ranLv = Green_slime.ran.nextInt(lv)+1;
		int ranHp = Green_slime.ran.nextInt(hp)+500;
		int ranpower = Green_slime.ran.nextInt(power)+100;
		int randef = Green_slime.ran.nextInt(def)+5;
		String skill ="액스 스매쉬";
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
	
}