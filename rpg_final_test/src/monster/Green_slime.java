package monster;

import java.util.Random;
import main_section.Unit;

public class Green_slime extends Unit{
	
	public static Random ran = new Random();
	private int lv = 5;
	private int hp = 1000;
	private int power = 100;
	private int def = 10;
	
	public Green_slime() {
		
		super("초록 슬라임",5,50,15,5);
		int ranLv = ran.nextInt(lv)+1;
		int ranHp = ran.nextInt(hp)+300;
		int ranpower = ran.nextInt(power)+10;
		int randef = ran.nextInt(def)+5;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
	
}
