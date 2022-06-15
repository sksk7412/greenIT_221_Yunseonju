package zombi1_2;

//보스인지 아닌지 구분해서 공격 

public class Hero extends Unit {
	
	int power;	//파워  
	int item;	//포션
//싱글톤 패턴
//		private static Myclass instance = new Myclass();
//		private Myclass() {}
//		public static Myclass getInstance() {
//			return instance;
//		}
	
	
	
	public Hero(int pos, int hp, int max, int item) {
		super(pos, hp, max);
		this.item = item;
	}

	public void attack(Unit enemy) {
		
		//적이 보스일 경우
		if(enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			power = r.nextInt(max) + 2;
			
			if(boss.getShield() > 0) {
				
				boss.setShield( boss.getShield() - power);
				System.out.printf("플레이어가 [%d] 데미지를 줬습니다.\n",power);
				System.out.printf("부패한좀비 남은 실드/체력 [%d / %d] \n",boss.getShield(),boss.getHp());
				
				if(boss.getShield() <= 0) boss.setShield(0);
			}
			else{
				enemy.setHp( enemy.getHp() - power);
				System.out.printf("플레이어가 [%d] 데미지를 줬습니다.\n",power);
				System.out.printf("부패한좀비 남은 실드/체력 [%d / %d] \n",boss.getShield(),boss.getHp());
			}
			if(enemy.getHp() <= 0 ) enemy.setHp(0);
			
		}
		//일단 좀비일 경우
		else {
			power = r.nextInt(max) + 2;
			
			enemy.setHp( enemy.getHp() - power);
			if(enemy.getHp() <= 0 ) enemy.setHp(0);
			
			System.out.printf("플레이어가 [%d] 데미지를 줬습니다.\n",power);
			System.out.printf("좀비 남은 체력 [%d] \n",enemy.getHp());
		}
	}

	public void recovery() {
		if(item > 0) {
			setHp(getHp() + 100);
			System.out.println(" 체력을 100 회복합니다. ");
			System.out.printf("[현재체력 %d ]\n",getHp());
			item -= 1;
		}
		else
			System.out.println("포션을 다 소모하셨습니다.");
		
	}


}