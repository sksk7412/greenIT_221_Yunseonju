package monster;

import java.util.ArrayList;
import java.util.Random;

import main_section.Unit;

public class Special_slime extends Unit{
	
	public static Random ran = new Random();
	private int lv = 10;
	private int hp = 200;
	private int power = 55;
	private int def = 20;
	
	public Special_slime() {
		
		super("타락한 슬라임",7,150,35,15);
		int ranLv = ran.nextInt(lv)+3;
		int ranHp = ran.nextInt(hp)+35;
		int ranpower = ran.nextInt(power)+17;
		int randef = ran.nextInt(def)+6;
		
		setLv(ranLv);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
	
}