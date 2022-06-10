package rpg1_2;

public class Unit {
	String name;		//이름
	int lv;				//레벨
	int hp;				//체력
	int maxhp;			//최대체력
	int atk;			//공격력
	int def;			//방어력
	boolean party;		//파티여부
	Item weapon;
	Item armor;
	Item ring;
	
	public Unit(String name, int lv, int hp, int maxhp, int atk, int def, boolean party) {
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.maxhp = maxhp;
		this.atk = atk;
		this.def = def;
		this.party = party;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}
	
	//플레이어 상태 현황
	public void printState() {
		
		System.out.printf("[Name: %s] ",name);
		System.out.printf("[Level: %d] ",lv);
		if(ring == null)System.out.printf("[hp:%d",hp);
		else
			System.out.printf("[hp: %d",hp + ring.power);
		
		if(ring == null)System.out.printf(" / %d] ",maxhp);
		else
			System.out.printf("/ %d]",maxhp + ring.power);
		
		if(weapon == null) 	System.out.printf("[ATk: %d] ",atk);
		else
			System.out.printf("[ATk: %d] ",atk + weapon.power);
	
		if(armor == null) 	System.out.printf("[DEF: %d] ",def);
		else
			System.out.printf("[DEF: %d] ",def + armor.power);
		System.out.printf("[Party: %s]\n",party);
	}
	
	//아이템 현황
	public void itemState() {
		System.out.printf("[Name: %s]\t ",name);
		if(weapon != null) System.out.printf("[무기: %s + %d] ",weapon.name, weapon.level);
		else
			System.out.printf("[무기: 없음] ");
		
		if(armor != null) System.out.printf("[방어구: %s + %d] ",armor.name, armor.level);
		else
			System.out.print("[방어구: 없음] ");
		
		if(ring != null) System.out.printf("[악세사리: %s + %d] ",ring.name, ring.level); 
		else
			System.out.printf("[악세사리: 없음] ");
	}
}
