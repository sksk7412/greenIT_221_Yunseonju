package main_section;

public class Unit {
	
	public String name;
	private String job;
	private int lv;
	private int hp;
	private int maxhp;
	private int power;
	private int def;
	private int exp;
	private int maxexp;
	private String skill;
	private boolean alive;
	private Item weapon;
	private Item armor;
	private Item ring;
	
	//플레이어 유닛세팅
	public Unit(String name,String job ,int lv, int hp,int power,int def) {
		this.name = name;
		this.job = job;
		this.lv = lv;
		this.hp = hp;
		this.maxhp = hp;
		this.power = power;
		this.def = def;
		this.alive = true;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	//몬스터 유닛세팅
	public Unit(String name, int lv, int hp, int power, int def) {
		
		this.name = name;
		this.lv = lv;
		this.hp = hp;
		this.power = power;
		this.def = def;
		
	}
	
	//GET
	public String getSkill() {
		return skill;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaXhp() {
		return this.maxhp;
	}
	public int getPower() {
		return power;
	}
	public int getDef() {
		return this.def;
	}
	public Item getWeapon() {
		return weapon;
	}
	public Item getArmor() {
		return armor;
	}
	public Item getRing() {
		return ring;
	}
	//생사여부
	public boolean getAlive() {
		return alive;
	}
	
	// SET
	public void setLv(int lv) {
		this.lv = lv;
	}
	public void setHp(int hp){
		this.hp = hp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	public void setRing(Item ring) {
		this.ring = ring;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
//	//공격
//	void attack(Unit target) {
//		target.hp -= power;
//		System.out.println("[" + name + "] 이 " + "[" + target.name + "] 에게 " + power + "의 데미지를 입힙니다. ");
//		if (target.hp <= 0) {
//			System.out.println("[" + target.name + "] 을 쳐치했습니다.");
//			target.hp = 0;
//		}
//	}
	
	//상태 출력
	public void printState() {
		
		System.out.printf("[이름: %s] ",this.name);
		System.out.printf("[레벨: %d] ",this.lv);
		System.out.printf("[직업: %s] ",this.job);
	
		if(alive == true) {
			//체력
			if(ring == null) System.out.printf("[체력: %d / ",this.hp);
			else System.out.printf("[체력: %d / ",this.hp + this.ring.getPower());
			if(ring == null) System.out.printf("%d] ",this.maxhp);
			else System.out.printf("%d] ",this.maxhp + this.ring.getPower());
			
			//공격력
			if(weapon == null) System.out.printf("[공격력: %d ]",this.power);
			else System.out.printf("[공격력: %d ]",this.power+ this.weapon.getPower());
			//방어력
			if(armor == null) System.out.printf("[방어력: %d ]\n",this.def);
			else System.out.printf("[방어력: %d ]\n",this.def + this.armor.getPower());
		}
		else {
			if(ring == null)System.out.printf("[hp:%d",hp);
			else
				System.out.printf("[hp: %d",hp + ring.getPower());
			
			if(ring == null)System.out.printf(" / %d] ",maxhp);
			else
				System.out.printf("/ %d]",maxhp + ring.getPower());
			
			System.out.print(" [사망] \n");
		}
		System.out.println("");
	}
	
	//몬스터 상태현황
	public void monsterPrintState() {
		
		System.out.printf("[이름: %s] ",this.name);
		System.out.printf("[레벨: %d] ",this.lv);
	
		if(alive == true) {
			//체력
			if(ring == null) System.out.printf("[체력: %d / ",this.hp);
			else System.out.printf("[체력: %d / ",this.hp + this.ring.getPower());
			if(ring == null) System.out.printf("%d] ",this.maxhp);
			else System.out.printf("%d] ",this.maxhp + this.ring.getPower());
			//공격력
			if(weapon == null) System.out.printf("[공격력: %d ]",this.power);
			else System.out.printf("[공격력: %d ]",this.power+ this.weapon.getPower());
			//방어력
			if(armor == null) System.out.printf("[방어력: %d ]\n",this.def);
			else System.out.printf("[방어력: %d ]\n",this.def + this.armor.getPower());
		}
		else {	
			System.out.printf("[%d / %d] ",hp,maxhp);	
		}
		System.out.println("");
	}
	
	//아이템 현황
	public void itemState() {
		System.out.printf("[Name: %s]\t ",name);
		if(weapon != null) System.out.printf("[무기: %s + %d] ",weapon.getName(), weapon.getLevel());
		else
			System.out.printf("[무기: 없음] ");
			
		if(armor != null) System.out.printf("[방어구: %s + %d] ",armor.getName(), armor.getLevel());
		else
			System.out.print("[방어구: 없음] ");
			
		if(ring != null) System.out.printf("[악세사리: %s + %d] ",ring.getName(), ring.getLevel()); 
		else
			System.out.printf("[악세사리: 없음] ");
		System.out.println("");
	}
	
}
