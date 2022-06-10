package rpg1_2;

import java.util.ArrayList;

public class Inventory {

	static ArrayList<Item> inven = new ArrayList<>();
	
	//인벤토리 메인메뉴
	public void mainMenu() {
		
		while(true) {
			System.out.println("\t=== [Inventory Menu] ===");
			System.out.println("1.인벤토리 목록 2.아이템 착용 3.아이템 판매([세금 50%]) [4.장비 강화]");
			System.out.println("5.아이템 벗기 0.뒤로가기");
			System.out.printf("[ Player Gold: %d ]\n",Player.money);
			int sel = Game.in.nextInt();
			
			if(sel == 1) printInvenItem();
			else if(sel == 2) ItemWear();
			else if(sel == 3) itemSell();
			else if(sel == 4) upgradeItem();
			else if(sel == 5) takeOffItem();
			else if(sel == 0) break;
			else
				System.out.println("다시 선택하시오");
		}
	}
	
	private void upgradeItem() {
		printInvenItem();
		
		System.out.println("강화할 장비 번호: ");
		int sel = Game.in.nextInt()-1;
		
		if(sel >= 0 && sel < inven.size()) {
			Item temp = inven.get(sel);
			
			if(temp.level <= 5) {
				int money = 0;
				int percent = 0;
				int check = -1;
				if(temp.level == 1) {percent = 80; System.out.println("비용은 [2000 골드]입니다."); money = 2000;}
				else if(temp.level == 2) {percent = 60; System.out.println("비용은 [5000 골드]입니다."); money = 5000;}
				else if(temp.level == 3) {percent = 30; System.out.println("비용은 [10000 골드]입니다."); money = 10000;}
				else if(temp.level == 4) {percent = 10; System.out.println("비용은 [30000 골드]입니다."); money = 30000;}
							
				System.out.printf("강화 성공확률 [ %d ]퍼센트\n",percent);
				System.out.println(" 강화 하시겠습니까? ");
				System.out.println("[1. YES] [2. NO]");
				int select = Game.in.nextInt();
				
				if((Player.money- money) >= 0) {
					if(select == 1) {
						if(temp.level == 1) {
							int num = Game.ran.nextInt(5);
							if(num != 0) {
								check = 1;
							}
						}
						else if(temp.level == 2) {
							int num = Game.ran.nextInt(5);
							if(num != 0 || num != 1) {
								check = 1;
							}
						}
						else if(temp.level == 3) {
							int num = Game.ran.nextInt(10);
							if(num == 0 || num == 5 || num == 7) {
								check = 1;
							}
						}
						else if(temp.level == 4) {
							int num = Game.ran.nextInt(10);
							if(num == 0) {
								check = 1;
							}
						}
						
						if(check == 1) {
							inven.get(sel).level += 1;
							inven.get(sel).setPower(inven.get(sel).kind,inven.get(sel).level);
							System.out.println("===============================");
							System.out.println("\t [강화 성공!!!] ");
							System.out.println("===============================");
						}
						else {
							inven.remove(sel);
							System.out.println("[ 강화 실패 ]");
						}
						
						Player.money -= money;
					}
					else
						System.out.println("강화를 하지 않습니다.");
				}
				else
					System.out.println("골드가 부족합니다.");
			}
			else
				System.out.println("더이상 장비 강화가 불가합니다.");
		}
		else
			System.out.println("장비 번호를 다시 확인하시오.");
	}
	//아이템 목록 출력
	public void printInvenItem() {
		System.out.println("\t=== [Inventory List] ===");
		if(inven.size() > 0) {
			for(int i = 0; i < inven.size(); i++) {
				System.out.printf("[%d] ",i+1);
				inven.get(i).printItem();
				System.out.println();
			}
		}
		else
			System.out.println(" [비어있음] ");
	}
	
	//아이템 착용
	public void ItemWear() {
		if(inven.size() > 0) {
			//전체 길드 멤버의 아이템 현황
			for(int i = 0; i < Guild.guildList.size(); i++) {
				System.out.printf("[%d]",i+1);
				Guild.guildList.get(i).itemState();
				System.out.println();
			}
			
			System.out.println("아이템 착용할 길드원 번호: ");
			int sel = Game.in.nextInt()-1;
			
			if(sel >= 0 && sel < Guild.guildList.size()) {
				
				//해당 멤버의 아이템 착용 상태 및 인벤토리 출력
				Guild.guildList.get(sel).itemState();
				System.out.print("\n\n");
				printInvenItem();
								
				System.out.println("착용할 아이템 번호: ");
				int itemIndex = Game.in.nextInt()-1;
				
				if(itemIndex >= 0 && itemIndex < inven.size()) {
					
					// 아이템 타입에 따라서 처리
					if(inven.get(itemIndex).kind == 1) {
						
						//무기 착용 및 교체
						if(Guild.guildList.get(sel).weapon == null) {
							Guild.guildList.get(sel).weapon = inven.get(itemIndex);
							inven.remove(itemIndex);
							System.out.println("무기를 착용합니다.");
						}
						else {
							System.out.printf("[ %s ] 장비에서 [ %s ] 장비로 교체 하시겠습니까? \n",Guild.guildList.get(sel).weapon.name, inven.get(itemIndex).name);
							System.out.println("[1.YES] [2.NO]");
							int choose = Game.in.nextInt();
							
							if(choose == 1) {
								inven.add(Guild.guildList.get(sel).weapon);
								Guild.guildList.get(sel).weapon = inven.get(itemIndex);	
								inven.remove(itemIndex);
								System.out.println("무기를 교체합니다.");
							}
							else if(choose == 2) {
								System.out.println("무기를 변경하지 않습니다.");
							}
							else 
								mainMenu();
						}
					}
					//방어구 착용 및 교체
					else if(inven.get(itemIndex).kind == 2) {
						//무기 착용 및 교체
						if(Guild.guildList.get(sel).armor == null) {
							Guild.guildList.get(sel).armor = inven.get(itemIndex);
							inven.remove(itemIndex);
							System.out.println("방어구를 착용합니다.");
						}
						else {
							System.out.printf("[ %s ] 장비에서 [ %s ] 장비로 교체 하시겠습니까? \n",Guild.guildList.get(sel).armor.name, inven.get(itemIndex).name);
							System.out.println("[1.YES] [2.NO]");
							int choose = Game.in.nextInt();
							
							if(choose == 1) {
								inven.add(Guild.guildList.get(sel).armor);
								Guild.guildList.get(sel).armor = inven.get(itemIndex);	
								inven.remove(itemIndex);
								System.out.println("방어구를 교체합니다.");
							}
							else if(choose == 2) {
								System.out.println("방어구를 변경하지 않습니다.");
							}
							else 
								mainMenu();
						}
					}
					//악세사리 착용 및 교체
					else if(inven.get(itemIndex).kind == 3){
						//무기 착용 및 교체
						if(Guild.guildList.get(sel).ring == null) {
							Guild.guildList.get(sel).ring = inven.get(itemIndex);
							inven.remove(itemIndex);
							System.out.println("악세사리를 착용합니다.");
						}
						else {
							System.out.printf("[ %s ] 장비에서 [ %s ] 장비로 교체 하시겠습니까? \n",Guild.guildList.get(sel).ring.name, inven.get(itemIndex).name);
							System.out.println("[1.YES] [2.NO]");
							int choose = Game.in.nextInt();
							
							if(choose == 1) {
								inven.add(Guild.guildList.get(sel).ring);
								Guild.guildList.get(sel).ring = inven.get(itemIndex);	
								inven.remove(itemIndex);
								System.out.println("악세사리를 교체합니다.");
							}
							else if(choose == 2) {
								System.out.println("악세사리를 변경하지 않습니다.");
							}
							else 
								mainMenu();
						}
					}
				}
				else
					System.out.println("아이템 번호를 확인하시오.");
			}
			else
				System.out.println("길드원 번호를 확인하시오.");
		}
		else
			System.out.println(" [비어있음] ");
	}
	
	//아이템 판매
	public void itemSell() {
		if(inven.size() > 0) {
			int index = -1;
			//인벤토리 목록 출력
			printInvenItem();
			
			System.out.println("판매할 아이템 번호: [0.뒤로가기]");
			int sel = Game.in.nextInt()-1;
			
			if(sel >= 0 && sel < inven.size()) {
				for(int i = 0; i < Shop.itemList.size(); i++ ) {
					if(Shop.itemList.get(i).kind == inven.get(sel).kind && Shop.itemList.get(i).name.equals(inven.get(sel).name)) {						
						index = i;
					}
				}
				
				if(index != -1) {
					System.out.printf("[ %s ] 아이템 판매완료.\n", inven.get(sel).name);
					Player.money += inven.get(sel).price * 0.5;
					inven.remove(sel);
				}
			}
			else if(sel == -1) mainMenu();
			else
				System.out.println("인벤토리 번호를 다시 확인하시오.");
			
		}
		else
			System.out.println(" [비어있음] ");
	}
	
	//아이템 벗기
	public void takeOffItem() {
		
		System.out.println("\t=== [Guild ItemSet] ===");
		for(int i = 0; i < Guild.guildList.size(); i++) {
			System.out.printf("[%d] ",i+1);
			Guild.guildList.get(i).itemState();
			System.out.println();
		}
		
		System.out.println("아이템 탈의할 멤버 번호: ");
		int sel = Game.in.nextInt()-1;
		
		if(sel >= 0 && sel < Guild.guildList.size()) {
			
		}
		else
			System.out.println("번호를 확인하시오.");
	}
	

}
