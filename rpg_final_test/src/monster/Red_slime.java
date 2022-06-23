package monster;

import java.util.ArrayList;
import java.util.Random;

import main_section.Unit;

public class Red_slime extends Unit{
	
	public static Random ran = new Random();
	private int lv = 7;
	private int hp = 1500;
	private int power = 200;
	private int def = 15;
	
	public Red_slime() {
		
		super("빨간 슬라임",5,75,20,7);
		int ranLv = ran.nextInt(lv)+1;
		int ranHp = ran.nextInt(hp)+350;
		int ranpower = ran.nextInt(power)+14;
		int randef = ran.nextInt(def)+6;
		
		setLv(ranLv);
		setMaxhp(ranHp);
		setHp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}
	
}
