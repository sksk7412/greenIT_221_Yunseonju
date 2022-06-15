package zombi1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class FileDate {
	
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;
	File file = new File("zombi1_2.txt");
	
	//파일 저장
		public void save(Hero hero) {
			FileWriter fw = null;
			String info = "";
			
			info += hero.getPos()+"/";
			info += hero.getHp() +"/";
			info += hero.getMax() +"/";
			info += hero.item;
				
			try {
				fw = new FileWriter(file);
				fw.write(info);
				fw.close();

				System.out.println("저장완료");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("저장실패");
			}
		}
		
		//파일 로드
		public void load(Hero hero) {
			if(file.exists()) {
							
				try {
					
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					String data = br.readLine();			
					String temp[] = data.split("/");
						
					hero.setPos(Integer.valueOf(temp[0]));
					hero.setHp(Integer.valueOf(temp[1]));
					hero.item = Integer.valueOf(temp[3]);
				
					fr.close();
					br.close();
					System.out.println(" 로드 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(" 로드 실패");
				}
			}
		}
		
		
	
}
