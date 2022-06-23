package main_section;

import java.util.ArrayList;

public class MonsterManager {
	
	private static MonsterManager instance = new MonsterManager();
	private String[][] monsterName = {
			{"Green_slime","Red_slime","Special_slime"},
			{"Green_goblin","Red_goblin","Special_goblin"},
			{"Green_ork","Red_ork","Special_ork"}};
	
	private String path = "monster.";
	private static ArrayList<Unit> monsterList;
	
	public void setMonster(int sel) {
		int size = 5;
		monsterList = new ArrayList<>(); 
		
		for(int i = 0; i < size-1; i++) {
			int ranInt = Lobby.ran.nextInt(monsterName[sel].length);
			
			try {	
				
				Class<?> clazz = Class.forName(path + monsterName[sel][ranInt]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();			
				Unit temp = (Unit) obj;
				monsterList.add(temp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public ArrayList<Unit> getMonList(){
		return monsterList;
		
	}
	
	public static MonsterManager getInstance() {
		return instance;
	}
	
}
