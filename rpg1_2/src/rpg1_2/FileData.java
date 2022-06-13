package rpg1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileData {
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;
	
	private File file1 = new File("guildMember.txt");
	private File file2 = new File("inventory.txt");
	
	//파일 저장
	public void save() {
		FileWriter fw = null;
		String info = "";
		String info2 ="";
		info +=Player.money +"\n";  			 //플레이어 돈
		//길드멤버 파일저장
		for(int i = 0; i < Guild.guildList.size(); i++) {
			Unit temp = Guild.guildList.get(i);
			int check = -1;
			if(temp.party == true) check = 1;
			info += temp.name +"/";
			info += temp.lv +"/";
			info += temp.hp +"/";
			info += temp.maxHp +"/";
			info += temp.atk +"/";
			info += temp.def +"/";
			info += check;
			if(temp.weapon != null || temp.armor != null || temp.ring != null) info += "/";
			
			if(temp.weapon != null)info += temp.weapon.kind+","+temp.weapon.name+",";
			if(temp.armor != null)info += temp.armor.kind+","+temp.armor.name+",";
			if(temp.ring != null)info += temp.ring.kind+","+temp.ring.name+"\n";
			else info += "\n";
		}
		
		info = info.substring(0, info.length()-1);
		
		//인벤토리 파일저장
		if(Inventory.inven.size() > 0) {
			for(int i = 0; i < Inventory.inven.size(); i++) {
				Item temp1 = Inventory.inven.get(i);
				
				info2 += temp1.kind +"/";
				info2 += temp1.name +"/";
				info2 += temp1.power +"/";
				info2 += temp1.price +"\n";
			}
			
			info2 = info2.substring(0, info2.length()-1);
		}
		
		try {
			fw = new FileWriter(file1);
			fw.write(info);
			fw.close();
			fw = new FileWriter(file2);
			fw.write(info2);
			fw.close();
			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장실패");
		}
	}
	
	//파일 로드
	public void load() {
		guildMemberLoad();	//길드원정보 로드
		inventoryLoad();	//인벤토리 로드
	}
	
	//길드원 정보 로드
	public void guildMemberLoad() {
		if(file1.exists()) {
			
			//길드멤버 비우기
			Guild.guildList.clear();
			
			try {
				fr = new FileReader(file1);
				br = new BufferedReader(fr);
				
				String data = br.readLine();
				while(data != null) {
				
					String[] info = data.split("/");
					if(info.length <= 1) {
						Player.money = Integer.valueOf(info[0]);		
					}
					else {
						boolean check = false;
						if(info[6].equals("1")) check = true;
						
						Unit serve = new Unit(info[0], Integer.valueOf(info[1]), Integer.valueOf(info[2]),Integer.valueOf(info[3]),
								Integer.valueOf(info[4]), Integer.valueOf(info[5]),check);
						
						//무기나 장비를 착용한 경우
						if(info.length == 8) {
							String[] info1 = info[7].split(",");
							
							//장비를 1개만 착용한 경우
							if(info1.length == 2 ) {
								int index = -1;
								Item temp = null;
								for(int i = 0; i < Shop.itemList.size(); i++) {
									if(Shop.itemList.get(i).kind == Integer.valueOf(info1[0]) && Shop.itemList.get(i).name.equals(info1[1])) {
										temp = Shop.itemList.get(i);
										index = Shop.itemList.get(i).kind;
									}
								}
												
								if(index == 1) {
									serve.setItem(temp, null, null);
								}
								else if(index == 2) {
									serve.setItem(null, temp, null);
								}
								else
									serve.setItem(null, null, temp);
								
							}
							//장비를 2개만 착용한 경우
							else if(info1.length == 4){
								int index = -1;
								int index1 = -1;
								Item temp = null;
								Item temp1 = null;
								for(int i = 0; i < Shop.itemList.size(); i++) {
									if(Shop.itemList.get(i).kind == Integer.valueOf(info1[0]) && Shop.itemList.get(i).name.equals(info1[1])) {
										temp = Shop.itemList.get(i);
										index = Shop.itemList.get(i).kind;
									}
									if(Shop.itemList.get(i).kind == Integer.valueOf(info1[2]) && Shop.itemList.get(i).name.equals(info1[3])) {
										temp1 = Shop.itemList.get(i);
										index1 = Shop.itemList.get(i).kind;
									}
								}
												
								if(index == 1 && index1 == 2) {
									serve.setItem(temp, temp1, null);
								}
								else if(index == 1 && index1 == 3) {
									serve.setItem(temp, null, temp1);
								}
								else
									serve.setItem(null, temp, temp1);
						   }
							//장비를 전부 착용한 경우
							else if(info1.length == 6) {
								
								Item temp = null;
								Item temp1 = null;
								Item temp2 = null;
								for(int i = 0; i < Shop.itemList.size(); i++) {
									if(Shop.itemList.get(i).kind == Integer.valueOf(info1[0]) && Shop.itemList.get(i).name.equals(info1[1])) {
										temp = Shop.itemList.get(i);
									}
									if(Shop.itemList.get(i).kind == Integer.valueOf(info1[2]) && Shop.itemList.get(i).name.equals(info1[3])) {
										temp1 = Shop.itemList.get(i);
									}
									if(Shop.itemList.get(i).kind == Integer.valueOf(info1[4]) && Shop.itemList.get(i).name.equals(info1[5])) {
										temp2 = Shop.itemList.get(i);
									}
								}
								
								serve.setItem(temp, temp1, temp2);
							}
						}
					
						Guild.guildList.add(serve);
					}
					
					data = br.readLine();
				}
				
				fr.close();
				br.close();
				System.out.println("길드멤버 로드 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("길드멤버 로드 실패");
			}
		}
	}
	//인벤토리 로드
	public void inventoryLoad() {
		if(file2.exists()) {
			
			//인벤토리 비우기
			Inventory.inven.clear();
			
			try {
				fr = new FileReader(file2);
				br = new BufferedReader(fr);
				
				String data = br.readLine();
				while(data != null) {
				
					String[] temp = data.split("/");			
					Item serve = new Item(Integer.valueOf(temp[0]), temp[1] , Integer.valueOf(temp[2]), Integer.valueOf(temp[3]));		
					Inventory.inven.add(serve);
					
					data = br.readLine();
				}
				fr.close();
				br.close();
				System.out.println("인벤토리 로드 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("인벤토리 로드 실패");
			}
		}
	}

}