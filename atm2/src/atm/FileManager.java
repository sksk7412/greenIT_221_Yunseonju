package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

	static FileManager instance = new FileManager(); 
	
	String fileName = "AtmData.txt";
	
	public void load() {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		if(file.exists()) {
			
			
			
			
			
		}
	}
	public void save() {
		FileWriter fw = null;
		String info = "";
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
