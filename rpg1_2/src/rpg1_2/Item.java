package rpg1_2;

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
	
	public void setName(String name) {
		this.name = name;
	}
	public void printItem() {

		if(level == 1)System.out.printf("[아이템 이름: %s] ",name);
		else
			System.out.printf("[아이템 이름: %s + %d] ",name,level);
		System.out.printf("[파워: %d] ",power);
		System.out.printf("[가격: %d]\n",price);
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
