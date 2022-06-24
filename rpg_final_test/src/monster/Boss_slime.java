package monster;

import main_section.Lobby;
import main_section.Skill;
import main_section.Unit;

public class Boss_slime extends Unit implements Skill{
	
	public String skill = "내려찍기";
	private int lv = 10;
	private int hp = 1000;
	private int power = 150;
	private int def = 10;
	
	public Boss_slime() {
		
		super("머쉬맘",5,50,15,5);
		int ranLv = Green_slime.ran.nextInt(lv)+1;
		int ranHp = Green_slime.ran.nextInt(hp)+300;
		int ranpower = Green_slime.ran.nextInt(power)+60;
		int randef = Green_slime.ran.nextInt(def)+5;
		
		setLv(ranLv);
		setHp(ranHp);
		setMaxhp(ranHp);
		setPower(ranpower);
		setDef(randef);
	}

	@Override
	public void skill(Unit unit) {
		
		int atk =  3 * Green_slime.ran.nextInt(power) + 2;
		System.out.println("==========================================");
		System.out.printf("%s 이(가) [ %s ] 스킬을 사용합니다.\n",name,skill);
		System.out.printf("%s 이(가) %d 의 공격력으로 때립니다.\n",name, atk);
		System.out.printf("%s 이(가) [ %s ]을 맞았습니다.\n",unit.name,skill);
		System.out.println("==========================================");
		
		unit.setHp(unit.getHp()- atk);
	}	
	
}