package zombi1_2;

public class Zombi extends Unit{
	
	int power;
	
	public Zombi(int position, int hp, int max) {
		super(position, hp, max);
	}

	@Override
	void attack(Unit hero) {
		//좀비 랜덤 공격력
		power = r.nextInt(max)+1;
			
		hero.setHp( hero.getHp() - power);
		
		if(hero.getHp() <= 0) hero.setHp(0);
		
		int bloodsucking = power / 2;
		this.setHp( getHp() + bloodsucking);
		
		System.out.printf("좀비가 %d 의 데미지를 입혔습니다.\n", power);
		System.out.printf("좀비가 %d 의 HP를 회복합니다.\n", bloodsucking);
		System.out.printf("플레이어 남은 체력: [%d]\n",hero.getHp());
	}

}
