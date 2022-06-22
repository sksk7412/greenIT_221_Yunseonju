package main_section;

public class Item {
	static final int Weapon = 1;  //무기종류
	static final int Armor = 2;
	static final int Ring = 3;
	
	int kind;       // 아이템 종류
	String name;	// 아이템 이름
	int power;		// 아이템 파워
	int price;		// 아이템 가격
	int level;		// 아이템 레벨
	
	public Item(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
		this.level = 1;

	}
}
