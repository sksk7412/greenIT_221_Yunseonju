package main_section;

public class Unit {
	
	String name;
	int lv;
	int hp;
	int maxhp;
	int power;
	int def;
	boolean alive;
	Item weapon;
	Item armor;
	Item ring;
	
	public Unit(String name, int lv, int hp,int power,boolean alive) {
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.maxhp = hp;
		this.power = power;
		this.alive = true;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	//아이템 세팅
	public void setItem(Item weapon, Item armor,Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
		
	}
	
	//상태 출력
	public void printState() {
		
		System.out.printf("[이름: %s] ",this.name);
		System.out.printf("[레벨: %d] ",this.lv);
		
		if(alive == true) {
			//체력
			if(ring == null) System.out.printf("[체력: %d / ",this.hp);
			else System.out.printf("[체력: %d / ",this.hp + this.ring.power);
			if(ring == null) System.out.printf("%d] ",this.maxhp);
			else System.out.printf("%d] ",this.maxhp + this.ring.power);
			//공격력
			if(ring == null) System.out.printf("[공격력: %d / ",this.power);
			else System.out.printf("[공격력: %d / ",this.power+ this.weapon.power);
			//방어력
			if(ring == null) System.out.printf("[방어력: %d / ",this.def);
			else System.out.printf("[방어력: %d / ",this.def + this.armor.power);
		}
		else {
			if(ring == null)System.out.printf("[hp:%d",hp);
			else
				System.out.printf("[hp: %d",hp + ring.power);
			
			if(ring == null)System.out.printf(" / %d] ",maxhp);
			else
				System.out.printf("/ %d]",maxhp + ring.power);
			System.out.print(" [사망] \n");
		}
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
