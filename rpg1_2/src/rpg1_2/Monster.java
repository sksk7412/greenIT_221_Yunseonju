package rpg1_2;

public class Monster {
	String name;		//이름
	int lv;				//레벨
	int hp;				//체력
	int maxHp;			//최대체력
	int atk;			//공격력
	int def;			//방어력
	int power;
	int check;
	Item weapon;
	Item armor;

	
	public Monster(String name, int lv, int hp, int maxHp, int atk, int def, int check) {
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.maxHp = maxHp;
		this.atk = atk;
		this.def = def;
		this.check = check;
		this.weapon = null;
		this.armor = null;
	}
	
	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;

	}
	
	//몬스터 상태 현황
	public void printState() {
		
		System.out.printf("[Name: %s] ",name);
		System.out.printf("[Level: %d] ",lv);
		System.out.printf("[hp:%d",hp);
		System.out.printf(" / %d] ",maxHp);

	}

}


