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
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	
}
