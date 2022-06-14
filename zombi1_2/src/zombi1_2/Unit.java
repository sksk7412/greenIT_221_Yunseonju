package zombi1_2;

import java.util.Random;

abstract public class Unit {
	private int hp;			// 체력  
	private int position;	// 위치
	int max;				// 랜덤 공격력
	
	Random r;
	
	public Unit(int position, int hp, int max) {
		this.position = position;
		this.hp = hp;
		this.max = max;
		r = new Random();
	}
	public void setPos(int pos) {
		this.position = pos;
	}
	public int getPos() {
		return position;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMax() {
		return max;
	}
//	public void move() {
//		if(pos <=10) pos++;
//		System.out.println("오른쪽으로 이동. 현재 위치: "+ pos);
//	}
	abstract void attack(Unit unit);
}
