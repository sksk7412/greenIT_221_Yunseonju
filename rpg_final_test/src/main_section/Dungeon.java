package main_section;

import java.util.ArrayList;

import user_section.Party;
import user_section.Player;

public class Dungeon {
	
	
	private int sel = -1;
	private int move;
	public void menu() {
	//	MonsterManager.getInstance().setMonster();
//			들어오면 생성
//			나갈때 clear
		while(true) {
			System.out.println(" == [Dungeon Menu] ===");
			System.out.println("[1.슬라임 던전(추천 평균레벨: LV.1 ~ 5)] [2.고블린 던전(추천 평균레벨: LV.6 ~ 10)] [3.오크 던전(추천 평균레벨: LV.10 ~ 15)]");
			System.out.println(" 던전을 선택하시오: [0.나가기]");
			sel = Lobby.in.nextInt();
			
			if(sel > 0 && sel < 4 ) makeDungeon(sel);
			else if(sel == 0) break;
			else
				System.err.println("던전을 다시 선택하시오.");
		}
	}
	
	// 슬라임 던전 goblin ork
	public void makeDungeon(int sel) {
		MonsterManager.getInstance().setMonster(sel-1);
		
		move = 0;
		int map[] = new int [20];

		while(true) {
				
			System.out.println("이동한다.");
			//이동 print
			System.out.print("[ ");
			for(int i = 0; i < map.length; i++) {
				if(i == move) {
					System.out.print("옷");
				}
				else
					System.out.print(" ㅡ ");
				
			}
			System.out.print(" ]\n");
			
			//종료 조건 1. 끝까지 도착했을때
			if(move >= 19) {
				System.out.println("던전 클리어!!");
				System.out.println("&&& [보 상] &&&");
				if(sel == 1) { 
					Player.money += 5000;
					System.out.println("[+ 5000 GOLD]");
				}
				else if(sel == 2)	{
					Player.money += 15000;
					System.out.println("[+ 15000 GOLD]");
				}
				else if(sel == 3)	{
					Player.money += 32000;
					System.out.println("[+ 32000 GOLD]");
				}
				 break;
			}
			
			// 중간에 전멸할 경우
			int checkNum = 0;
			for(int i = 0; i < Party.partyList.size(); i++){
				if(Party.partyList.get(i).getHp() <= 0) {
					checkNum++;
				}
			}
			if(checkNum == 4) {
				System.out.println("=== [미션 실패] ===");
				System.out.println("파티원이 전부 사망하셨습니다.");
				break;
			}
				
				if(move == 5) {
					Unit temp = MonsterManager.getInstance().getMonList().get(0);
					System.out.printf("[%s] 가 등장했습니다.!! \n",temp.name);
					while(true) {
						int number = Lobby.ran.nextInt(Party.partyList.size());
						System.out.println();
						
						
						monsterAtk(Party.partyList.get(number) , temp);
						playerAtk(temp);					
						
						if( temp.getHp() == 0) {
							System.out.println("사냥 성공!!!");
							break;
						}
					}
				}
				else if(move == 10) {
					Unit temp = MonsterManager.getInstance().getMonList().get(1);
					System.out.printf("[%s] 가 등장했습니다. \n", temp.name);
					while(true) {
						
						int number = Lobby.ran.nextInt(Party.partyList.size());
						System.out.println();
					
						monsterAtk(Party.partyList.get(number) , temp);
						playerAtk(temp);			
						
						if(temp.getHp() == 0) {
							System.out.println("사냥 성공!!!");
							break;
						}
					}
				}
				else if (move == 15) {
					Unit temp = MonsterManager.getInstance().getMonList().get(2);
					System.out.printf("[%s] 가 등장했습니다. \n",temp.name);
					while(true) {
						int number = Lobby.ran.nextInt(Party.partyList.size());
						System.out.println();					
						
						monsterAtk(Party.partyList.get(number) , temp);
						playerAtk(temp);					
						
						if( temp.getHp() == 0) {
							System.out.println("사냥 성공!!!");
							break;
						}
					}
				}
			
//			//보스 몬스터
//			int index = Lobby.ran.nextInt(5);
//			if( index == 1 && move == 19 ) {
//				// 선주님바보
//				Unit temp = MonsterManager.getInstance().getMonList().get(4);
//				System.out.println("XXX [보스 몬스터 등장] XXX");
//				System.out.printf("[보스] %s 이(가) 나타났습니다.\n",temp.name);
//				
//			}
			
			move ++;
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	// 플레이어 공격
		public void playerAtk(Unit monster) {
					
			for(int i = 0; i < Party.partyList.size(); i++) {
				Unit temp = Party.partyList.get(i);
				int num = temp.getWeapon().getPower();
				if(temp.getHp() > 0) {
					
					//무기 스텟 ++
					int atk = 0;
					if(num == 0) {
						 atk = Lobby.ran.nextInt(temp.getPower()) + 1;
					}
					else
						 atk = Lobby.ran.nextInt(temp.getPower() + num) + 1;
					
					System.out.println("==========================================");
					System.out.printf("%s 이(가) %d 의 공격력으로 때립니다.\n",temp.name, atk);
					System.out.println("==========================================");
					monster.setHp((monster.getHp() + monster.getDef()) - atk);
					
					if(monster.getHp() <= 0) monster.setHp(0);
					
					monster.monsterPrintState();
					System.out.println();
				}
				else {
					System.out.println("==========================================");
					System.out.printf("%s 이(가) 사망했습니다.\n",temp.name);
					System.out.println("==========================================");
					temp.setAlive(false);
				}
			
			}
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// 몬스터 공격
		public void monsterAtk(Unit hero , Unit monster) {
			
			// 일반 몬스터일 경우
			if(move != 19) {
				int atk = Lobby.ran.nextInt(monster.getPower());
				if(monster.getHp() > 0) {
					System.out.println("==========================================");
					System.out.printf("%s 이(가) %d 의 공격력으로 때립니다.\n",monster.name, atk);
					System.out.printf("%s 이(가) 공격을 맞았습니다.\n",hero.name);
					System.out.println("==========================================");
					hero.setHp((hero.getHp() + hero.getDef() )- atk);
					
					if(hero.getHp() <= 0) hero.setHp(0);
					System.out.println();
				}
			}
//			// 보스 몬스터일 경우
//			else {
//				
//				int atkNum = Lobby.ran.nextInt(5);
//				if(monster.hp > 0) {
//					if(atkNum == 4) {
//						if(sel == 1) {
//							int atk =  3 * Lobby.ran.nextInt(monster.atk) + 2;
//							System.out.println("==========================================");
//							System.out.println("%s 이(가) [ 내려찍기 ] 스킬을 사용합니다.");
//							System.out.printf("%s 이(가) %d 의 공격력으로 때립니다.\n",monster.name, atk);
//							System.out.printf("%s 이(가) 공격을 맞았습니다.\n",hero.name);
//							System.out.println("==========================================");
//							hero.hp -= atk;
//							
//							if(hero.hp <= 0)hero.hp = 0;
//						}
//						else if(sel == 2) {}
//						else if(sel == 3) {}
//						
//					}
//					else {
//						int atk = Lobby.ran.nextInt(monster.atk) + 2;
//						System.out.println("=========================================="); s
//						System.out.printf("%s 이(가) %d 의 공격력으로 때립니다.\n",monster.name, atk);
//						System.out.printf("%s 이(가) 공격을 맞았습니다.\n",hero.name);
//						System.out.println("==========================================");
//						hero.hp -= atk;
//						
//						if(hero.hp <= 0)hero.hp = 0;
//					}
//				}
//				System.out.println();
//			}
			//플레이어 상태 출력
			System.out.printf("[Name: %s ] [%d / %d]\n",hero.name,hero.getHp(),hero.getMaXhp());
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
}
