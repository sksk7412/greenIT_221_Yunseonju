package main_section;

public class Item {
	static final int Weapon = 1;  //무기종류
	static final int Armor = 2;
	static final int Ring = 3;
	
	private int kind;       // 아이템 종류
	private String name;	// 아이템 이름
	private int power;		// 아이템 파워
	private int price;		// 아이템 가격
	private int level;		// 아이템 레벨
	
	public Item(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
		this.level = 1;
	}
	
	public void printItem() {

		if(level == 1)System.out.printf("[아이템 이름: %s] ",name);
		else
			System.out.printf("[아이템 이름: %s + %d] ",name,level);
		System.out.printf("[파워: %d] ",power);
		System.out.printf("[가격: %d G]\n",price);
	}
	
	
	//SET
	public void setLevel(int level) {
		this.level = level;
	}
	
	// GET
	public int getLevel() {
		return level;
	}
	
	public int getKind() {
		return kind;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getPrice() {
		return price;
	}

	public void setPower(int kind,int level) {
		
		if(kind == 1) {
			if(level == 2) {
				this.power += 20;
			}
			if(level == 3) {
				this.power += 35;	
			}
			if(level == 4) {
				this.power += 45;
			}
			if(level == 5) {
				this.power += 52;
			}
		}
		if(kind == 2) {
			if(level == 2) {
				this.power += 22;
			}
			if(level == 3) {
				this.power += 37;	
			}
			if(level == 4) {
				this.power += 42;
			}
			if(level == 5) {
				this.power += 58;
			}
		}
		if(kind == 3) {
			if(level == 2) {
				this.power += 30;
			}
			if(level == 3) {
				this.power += 45;	
			}
			if(level == 4) {
				this.power += 50;
			}
			if(level == 5) {
				this.power += 60;
			}
		}
	}
}
