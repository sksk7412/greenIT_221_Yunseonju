package zombi1_2;

// #N-Name 브랜치로 전환 후, 작업 및 커밋 할 것 
// 모든 클래스 멤버는 접근제어자 추가해주세요 
import java.util.*;


public class _Main {

	public static void main(String[] args) {
		FileDate instance = new FileDate();
		Random r = new Random();
		Scanner s = new Scanner(System.in);
	
		
		Hero hero = new Hero(1,200,20,6);
		Zombi zombi = new Zombi(5, 100, 10);
		Boss boss = new Boss(9,300,20,100);
		
		int pos = 1;
		
		while(true) {
			System.out.println("현재위치: "+ pos);
			
			System.out.println("1.앞으로 가기 [8.저 장][9.로 드][0.종 료]");
			int sel = s.nextInt();
					
			if(sel == 1) {
				pos = pos + 1;
				hero.setPos(pos);
				
				if(pos == 5) {
					System.out.println(" 좀비를 마주했습니다.");
					
					while(true) {
						
						System.out.println("[1.강한 공격!] [2.포션 마시기]");
						int select = s.nextInt();
						
						if(select == 1) {
							
							zombi.attack(hero);
							System.out.println();
							hero.attack(zombi);
												
							if (hero.getHp() <= 0) {
								System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.” ");
								break;
							}
							
							if(zombi.getHp() <= 0) {
								System.out.println("좀비를 물리쳤습니다.");
								break;
							}
						}
						else if(select == 2) {							
							hero.recovery();
						}
						else
							System.out.println("다시 고르시오.");
					}
				}
				else if(pos == 9) {
					System.out.println(" XXX BOSS XXX");
					System.out.println(" [BOSS] 부패한 좀비를 마주했습니다.");
					
					while(true) {
						
						System.out.println("[1.강한 공격!] [2.포션 마시기]");
						int select = s.nextInt();
						
						if(select == 1) {
							
							hero.attack(boss);
							System.out.println("");
							boss.attack(hero);
												
							if (hero.getHp() <= 0) {
								System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.” ");
								break;
							}
							
							if(boss.getHp() == 0) {
								System.out.println("좀비를 물리쳤습니다.");
								break;
							}
						}
						else if(select == 2) {
							
							hero.recovery();
						}
						else
							System.out.println("다시 고르시오.");
					}
					
				}
				else if(pos == 10) {
					System.out.println("GAME CLEAR");
					break;
				}
				if (hero.getHp() <= 0) {
					break;
				}
				
			}
			//저장
			else if(sel == 8) {
				instance.save(hero);
			}
			//로드
			else if(sel == 9) {
				instance.load(hero);
				pos = hero.getPos();
			}
			else if(sel == 0) break;
			else
				System.out.println("다시 입력하세요.");;
		}
		
	}

}
