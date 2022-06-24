package monster;

import main_section.Lobby;
import main_section.Skill;
import main_section.Unit;
import user_section.Party;

public class Boss_goblin extends Unit implements Skill{
	
	public String skill = "포이즌 레인";
	private int lv = 25;
	private int hp = 1500;
	private int power = 250;
	private int def = 10;
	
	public Boss_goblin() {
		
		super("고블린 슬레이어",5,50,15,5);
		int ranLv = Green_slime.ran.nextInt(lv)+3;
		int ranHp = Green_slime.ran.nextInt(hp)+300;
		int ranpower = Green_slime.ran.nextInt(power)+150;
		int randef = Green_slime.ran.nextInt(def)+5;
		String skill ="죽음의 독침";
		
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
		System.out.printf("%s 이(가) 강력한 공격을 맞았습니다.",unit.name);
		System.out.println("==========================================");
		
		unit.setHp(unit.getHp()- atk);
	}
	
}