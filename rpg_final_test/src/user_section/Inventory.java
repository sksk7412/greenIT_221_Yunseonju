package user_section;

import java.util.ArrayList;
import main_section.Item;
import main_section.UserManager;


public class Inventory {

	public static ArrayList<Item> invenList = new ArrayList<>();
	
	public void menu() {
		
		while(true) {
		
			System.out.println(" === [인벤토리 메뉴] === ");
			System.out.printf("[Player Money: %d]\n",Player.money);
			System.out.println("[1.인벤토리 출력] [2.아이템 착용] [3.아이템 판매(세금50%)] [4.장비 강화] [0.뒤로가기]");
			int sel = Party.in.nextInt();
			
			if(sel == 1) printInvenList();
			else if(sel == 2) wearItem();
			else if(sel == 3) sellItem();
			else if(sel == 4) upgradeItem();
			else if(sel == 0) break;
			else
				System.err.println("다시 입력하세요.");
		}
	}
	
	//장비 강화
	private void upgradeItem() {
		printInvenList();
		
		System.out.println("강화할 장비 번호: ");
		int sel = Party.in.nextInt()-1;
		
		if(sel >= 0 && sel < invenList.size()) {
			Item temp = invenList.get(sel);
			
			if(temp.getLevel() <= 5) {
				int money = 0;
				int percent = 0;
				int check = -1;
				if(temp.getLevel() == 1) {percent = 80; System.out.println("비용은 [2000 골드]입니다."); money = 2000;}
				else if(temp.getLevel() == 2) {percent = 60; System.out.println("비용은 [5000 골드]입니다."); money = 5000;}
				else if(temp.getLevel() == 3) {percent = 30; System.out.println("비용은 [10000 골드]입니다."); money = 10000;}
				else if(temp.getLevel() == 4) {percent = 10; System.out.println("비용은 [30000 골드]입니다."); money = 30000;}
							
				System.out.printf("강화 성공확률 [ %d ]퍼센트\n",percent);
				System.out.println("XXX [주 의] 강화 실패시 무기가 사라집니다!!! XXX");
				System.out.println(" 강화 하시겠습니까? ");
				System.out.println("[1. YES] [2. NO]");
				int select = Party.in.nextInt();
				
				if((Player.money- money) >= 0) {
					if(select == 1) {
						if(temp.getLevel() == 1) {
							int num = Party.ran.nextInt(5);
							if(num != 0) {
								check = 1;
							}
						}
						else if(temp.getLevel() == 2) {
							int num = Party.ran.nextInt(5);
							if(num != 0 || num != 1) {
								check = 1;
							}
						}
						else if(temp.getLevel() == 3) {
							int num = Party.ran.nextInt(10);
							if(num == 0 || num == 5 || num == 7) {
								check = 1;
							}
						}
						else if(temp.getLevel() == 4) {
							int num = Party.ran.nextInt(10);
							if(num == 0) {
								check = 1;
							}
						}
						
						if(check == 1) {
							invenList.get(sel).setLevel(invenList.get(sel).getLevel() + 1 );
							invenList.get(sel).setPower(invenList.get(sel).getKind(),invenList.get(sel).getLevel());
							System.out.println("===============================");
							System.out.println("\t [강화 성공!!!] ");
							System.out.println("===============================");
						}
						else {
							invenList.remove(sel);
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
	//인벤토리 아이템 출력
	public void printInvenList() {
		for(int i = 0; i < invenList.size(); i ++) {
			System.out.printf("[%d] ",i+1);
			invenList.get(i).printItem();
		}
	}
	
	//아이템 착용
		public void wearItem() {
			if(invenList.size() > 0) {
				//전체 길드 멤버의 아이템 현황
				for(int i = 0; i < Party.partyList.size(); i++) {
					System.out.printf("[%d]",i+1);
					Party.partyList.get(i).itemState();
					System.out.println();
				}
				
				System.out.println("아이템 착용할 길드원 번호: ");
				int sel = Party.in.nextInt()-1;
				
				if(sel >= 0 && sel < Party.partyList.size()) {
					
					//해당 멤버의 아이템 착용 상태 및 인벤토리 출력
					Party.partyList.get(sel).itemState();
					System.out.print("\n\n");
					printInvenList();
									
					System.out.println("착용할 아이템 번호: ");
					int itemIndex = Party.in.nextInt()-1;
					
					if(itemIndex >= 0 && itemIndex < invenList.size()) {
						
						// 아이템 타입에 따라서 처리
						if(invenList.get(itemIndex).getKind() == 1) {
							
							//무기 착용 및 교체
							if(Party.partyList.get(sel).getWeapon() == null) {
								Party.partyList.get(sel).setWeapon(invenList.get(itemIndex));
								invenList.remove(itemIndex);
								System.out.println("무기를 착용합니다.");
							}
							else {
								System.out.printf("[ %s ] 장비에서 [ %s ] 장비로 교체 하시겠습니까? \n",Party.partyList.get(sel).getWeapon().getName(), invenList.get(itemIndex).getName());
								System.out.println("[1.YES] [2.NO]");
								int choose = Party.in.nextInt();
								
								if(choose == 1) {
									invenList.add(Party.partyList.get(sel).getWeapon());
									Party.partyList.get(sel).setWeapon(invenList.get(itemIndex));	
									invenList.remove(itemIndex);
									System.out.println("무기를 교체합니다.");
								}
								else if(choose == 2) {
									System.err.println("무기를 변경하지 않습니다.");
								}
								else 
									menu();
							 }
						 }
						//방어구 착용 및 교체
						else if(invenList.get(itemIndex).getKind() == 2) {
							
							//무기 착용 및 교체
							if(Party.partyList.get(sel).getArmor() == null) {
								Party.partyList.get(sel).setArmor(invenList.get(itemIndex));
								invenList.remove(itemIndex);
								System.out.println("방어구를 착용합니다.");
							}
							else {
								System.out.printf("[ %s ] 장비에서 [ %s ] 장비로 교체 하시겠습니까? \n",Party.partyList.get(sel).getArmor().getName(), invenList.get(itemIndex).getName());
								System.out.println("[1.YES] [2.NO]");
								int choose = Party.in.nextInt();
								
								if(choose == 1) {
									invenList.add(Party.partyList.get(sel).getArmor());
									Party.partyList.get(sel).setArmor(invenList.get(itemIndex));	
									invenList.remove(itemIndex);
									System.out.println("방어구를 교체합니다.");
								}
								else if(choose == 2) {
									System.err.println("방어구를 변경하지 않습니다.");
								}
								else 
									menu();
							 }
						}
						//악세사리 착용 및 교체
						else if(invenList.get(itemIndex).getKind() == 3){
							
							//무기 착용 및 교체
							if(Party.partyList.get(sel).getRing() == null) {
								Party.partyList.get(sel).setRing(invenList.get(itemIndex));
								invenList.remove(itemIndex);
								System.out.println("악세사리를 착용합니다.");
							}
							else {
								System.out.printf("[ %s ] 장비에서 [ %s ] 장비로 교체 하시겠습니까? \n",Party.partyList.get(sel).getRing().getName(), invenList.get(itemIndex).getName());
								System.out.println("[1.YES] [2.NO]");
								int choose = Party.in.nextInt();
								
								if(choose == 1) {
									invenList.add(Party.partyList.get(sel).getRing());
									Party.partyList.get(sel).setRing(invenList.get(itemIndex));	
									invenList.remove(itemIndex);
									System.out.println("악세사리를 교체합니다.");
								}
								else if(choose == 2) {
									System.err.println("악세사리를 변경하지 않습니다.");
								}
								else 
									menu();
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
	private void sellItem() {

		printInvenList();
		
		System.out.println("판매할 아이템 번호: ");
		int sellItem = Party.in.nextInt()-1;
		
		if(sellItem >= 0 && sellItem < invenList.size()) {
			Item item = invenList.get(sellItem);
			Player.money += invenList.get(sellItem).getPrice() * 0.5;
			System.out.printf("[%s] 아이템 판매 완료\n",invenList.get(sellItem).getName());
			UserManager.getInstance().getUser().setDeleItem(item);
			invenList.remove(sellItem);
		}
	}

}
