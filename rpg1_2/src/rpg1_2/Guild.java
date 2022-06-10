package rpg1_2;

import java.util.ArrayList;


public class Guild {
	
	static ArrayList<Unit> guildList = new ArrayList<>();
	Unit[] partyList = new Unit[4];
	
	public void set() {
		Unit temp = new Unit("김지연", 1, 50, 50, 18, 20, true);
		guildList.add(temp);
		temp = new Unit("킬리언 머피", 1, 60, 60, 16, 33, true);
		guildList.add(temp);
		temp = new Unit("포스트 말론", 1, 40, 40, 22, 32, true);
		guildList.add(temp);
		temp = new Unit("제임스 할로우", 1, 45, 45, 35, 26, true);
		guildList.add(temp);
		temp = new Unit("히스 레저", 1, 32, 32, 45, 25, false);
		guildList.add(temp);
		temp = new Unit("폴 앤더슨", 1, 60, 60, 20, 20, false);
		guildList.add(temp);
		
		partyListSet();
	}
	
	//파티원
	public void partyListSet() {
		int index = 0;
		for(int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party == true) {
				partyList[index] = guildList.get(i);
				index++;
			}
		}
	}
	
	//메인메뉴
	public void mainMenu() {
		
		while(true) {
			System.out.println("[ Player Gold: " + Player.money+" ]");
			System.out.println("\t=== [Guild Menu] ===");
			System.out.println("1.길드원 목록 2.길드원 장비현황 3.길드원 추가 4.길드원 방출");
			System.out.println("5.파티원 목록 6.파티원 교체 0.뒤로가기");
			int sel = Game.in.nextInt();
			
			if(sel == 1) printGuildList();
			else if(sel == 2) printItemMember();
			else if(sel == 3) addMember();
			else if(sel == 4) deleteMember();
			else if(sel == 5) printParty();
			else if(sel == 6) changeMember();
			else if(sel == 0) break;
			else
				System.out.println("다시 선택하세요.");
		}
	}
	
	private void printParty() {
		int index = 0;
		System.out.println("=== [Party MemberList] ===");
		for(int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party == true) {
				System.out.printf("[%d] ",index+1);
				guildList.get(i).printState();
				System.out.println();
			}
		}
	}

	//길드원 출력
	private void printGuildList() {
		System.out.println("\t=== [Guild Member] ===");
		for(int i = 0; i < guildList.size(); i++) {
			System.out.printf("[%d] ",i+1);
			guildList.get(i).printState();
			System.out.println();
		}	
	}
	
	//길드원 아이템 착용 현황	
	private void printItemMember() {
		System.out.println("\t=== [Guild ItemSet] ===");
		for(int i = 0; i < guildList.size(); i++) {
			System.out.printf("[%d] ",i+1);
			guildList.get(i).itemState();
			System.out.println();
		}	
		
	}
	
	//길드원 추가
	private void addMember() {
		if(Player.money >= 5000) {
			String[] first = {"나타샤","마리","폴","소피","네드","핀","벤자민","데이비드","크리스토퍼"};
			String[] second = {"프랭클린","콜","노블","간달프","레골라스","블룸","듀리프","모나한"};
			String name = first[Game.ran.nextInt(first.length)] +" "+ second[Game.ran.nextInt(second.length)];
			int lv = Game.ran.nextInt(5)+1;
			int hp = Game.ran.nextInt(70)+20;
			int atk = Game.ran.nextInt(70)+20;
			int def = Game.ran.nextInt(70)+20;
			
			System.out.println(" [길드원 추가 완료] ");
			System.out.printf("[Name: %s] [Level: %d] [Hp: %d/%d]\n",name,lv,hp,hp);
			System.out.printf("[ATk: %d] [DEF: %d] [Party: %s]\n",atk,def,false);
				
			Unit temp = new Unit(name, lv, hp, hp, atk, def, false);
			guildList.add(temp);
			Player.money -= 5000;
		}
		else
			System.out.println("골드가 부족합니다.");
	}
	//길드원 삭제
	private void deleteMember() {
		printGuildList();
		
		System.out.println("방출할 길드원 번호: ");
		int sel = Game.in.nextInt()-1;
		
		if(sel >= 0 && sel < guildList.size()) {
			
			//방출한 멤버가 파티 일경우
			if(guildList.get(sel).party == true) {
				
				for(int i = 0; i < guildList.size(); i++) {
					if(guildList.get(i).party == false) {
						guildList.get(i).party = true;
						break;
					}
				}
				guildList.get(sel).party = false;
			}
			System.out.printf("[ '%s' 길드원을 방출합니다.] \n",guildList.get(sel).name);
			guildList.remove(sel);
		}
		else
			System.out.println("번호를 다시 확인하시오.");
		
	}

	//파티원 변경
	private void changeMember() {

		System.out.println("\t=== [Change Member] ===");
		
		for(int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party == true) {
				System.out.printf("[%d] ",i+1);
				guildList.get(i).printState();
				System.out.println();
			}
		}
		System.out.println("파티 탈퇴할 멤버 선택: ");
		int sel = Game.in.nextInt()-1;
		
		if(guildList.get(sel).party == true) {
			
			for(int i = 0; i < guildList.size(); i++) {
				if(guildList.get(i).party == false) {
					System.out.printf("[%d] ",i+1);
					guildList.get(i).printState();
					System.out.println();
				}
			}
			
			System.out.println("파티 가입할 멤버 선택: ");
			int sel2 = Game.in.nextInt()-1;
			
			if(guildList.get(sel2).party == false) {
				
				guildList.get(sel).party = false;
				guildList.get(sel2).party = true;
				
				partyListSet();
				System.out.println("파티 교체 완료");
			}
			else
				System.out.println("번호를 확인하세요.");
		}
		else
			System.out.println("번호를 다시 확인하시오.");
	}
	
	
}
