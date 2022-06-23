package main_section;

public class Unit {
	
	private String name;
	private String job;
	private int lv;
	private int hp;
	private int maxhp;
	private int power;
	private int def;
	private boolean alive;
	private Item weapon;
	private Item armor;
	private Item ring;
	
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
	
	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}
	
	//생사여부
	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
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
			if(ring == null) System.out.printf("[공격력: %d ]",this.power);
			else System.out.printf("[공격력: %d ]",this.power+ this.weapon.getPower());
			//방어력
			if(ring == null) System.out.printf("[방어력: %d ]\n",this.def);
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
