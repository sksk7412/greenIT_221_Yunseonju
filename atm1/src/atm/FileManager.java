package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	static FileManager instance = new FileManager(); 
	
	String fileName = "AtmData.txt";
	
	public void load() {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		if(file.exists()) {
				
				UserManager.instance.userList = null;
				
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					String strCnt = br.readLine();
					int count = Integer.parseInt(strCnt);
					
					//값 reset
					UserManager.instance.userList = new User[count];
					UserManager.instance.userCount = 0;
					
					while(true) {
						String line = br.readLine();
						//로드한 line이 null일 경우 탈출
						if(line == null) break;
						
						String[] info = line.split("/");
						int size = info.length;
						
						
						User user = null;
						//계좌가 없을경우
						if(size == 3) {
							user = new User(info[0], info[1], null, 0);
						}
						//계좌가 있을경우
						else {
							int j = 2;
							String id = info[0];
							String password = info[1];
							int accCount = (size - 2) / 2;
						
							Account[] accList = new Account[accCount];
							for(int i = 0; i < accCount; i++) {
								accList[i] = new Account();
								accList[i].number = info[j];
								accList[i].money = Integer.parseInt(info[j+1]);
								j = j + 2;
							}
							user = new User(id, password, accList, accCount);
						}
						//고객 리스트에 추가
						UserManager.instance.userList[UserManager.instance.userCount] = user;
						//고객 카운터++
						UserManager.instance.userCount = UserManager.instance.userCount + 1; 
					}
					
					System.out.println("로드 성공.");
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("로드 실패");
				}
		}
	}
	public void save() {
		FileWriter fw = null;
		String info = "";
		
		info += UserManager.instance.userCount;
		info += "\n";
		
		for(int i = 0; i < UserManager.instance.userCount; i++) {
			
			//계좌가 하나도 없을경우 id 랑 pw만 저장
			if(UserManager.instance.userList[i].accCount == 0) {
				info += UserManager.instance.userList[i].id + "/";
				info += UserManager.instance.userList[i].pw + "\n";
			}
			//계좌까지 저장
			else {
				info += UserManager.instance.userList[i].id +"/";
				info += UserManager.instance.userList[i].pw +"/";
				
				for(int j = 0; j < UserManager.instance.userList[i].accCount; j++) {
					info +=  UserManager.instance.userList[i].accList[j].number+"/";
					info +=	UserManager.instance.userList[i].accList[j].money+"/";	
				}
				info +="\n";
			}
			
		}
		//마지막 \n 삭제
		info = info.substring(0, info.length()-1);
		
		try {
			fw = new FileWriter(fileName);
			
			fw.write(info);
			fw.close();
			System.out.println("저장 성공");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("저장 실패");
		}
		
	}

}
