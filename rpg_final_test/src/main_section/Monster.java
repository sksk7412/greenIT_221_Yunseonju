package main_section;

import java.util.Random;
import java.util.Vector;

public class Monster{
	
	Vector<Unit> mon_list = new Vector<>();
	String path = "main_section."; // 패키지명 + .
	String mons[] = { "UnitWolf", "UnitBat", "UnitOrc" };
	Random ran = new Random();
	
	void monster_rand_set(int size) {
		for (int i = 0; i < size; i++) {
			int num = ran.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int pow = ran.nextInt(10) + 10;
				
				temp.init(hp, pow);
				mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
