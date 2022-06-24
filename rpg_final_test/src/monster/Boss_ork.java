package monster;

import main_section.Skill;
import main_section.Unit;

public class Boss_ork extends Unit implements Skill{
	
	public String skill = "휠 윈드";
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
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}

	@Override
	public void skill(Unit unit) {
		
		int atk =  5 * Green_slime.ran.nextInt(power) + 2;
		System.out.println("==========================================");
		System.out.printf("%s 이(가) [ %s ] 스킬을 사용합니다.\n",name,skill);
		System.out.printf("%s 이(가) %d 의 공격력으로 때립니다.\n",name, atk);
		System.out.printf("%s 이(가) [ %s ]을 맞았습니다.\n",unit.name,skill);
		System.out.println("==========================================");
		
		unit.setHp(unit.getHp()- atk);
	}
	
}