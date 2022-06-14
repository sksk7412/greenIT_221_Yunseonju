package zombi1_2;

public class Boss extends Unit{
	
	int shield;
	public Boss(int position, int hp, int max,int shield) {
		super(position, hp, max);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	void attack(Unit hero) {
		
		int a = r.nextInt(5);
		
		if(a == 0) {
			System.out.println("부패한 좀비가 스킬을 사용합니다.");
			System.out.println("두개골 던지기!!!");
			
			int power = 4 * (r.nextInt(max) + 6);
			
			hero.setHp( hero.getHp() - power);
			if(hero.getHp() <= 0) hero.setHp(0);
			
			System.out.printf("부패한 좀비가 [%d]의 데미지를 줬습니다.\n",power);
			System.out.printf("플레이어 남은 체력 [%d] \n",hero.getHp());
		}
		else {
			System.out.println("부패한 좀비 휘두르기 공격!");
			
			int power = r.nextInt(getMax())+10;
			
			hero.setHp( hero.getHp() - power);
			if(hero.getHp() <= 0) hero.setHp(0);
			
			System.out.printf("보스몬스터가 [%d]의 데미지를 줬습니다.\n",power);
			System.out.printf("플레이어 남은 체력 [%d] \n",hero.getHp());
		}
	}

}
