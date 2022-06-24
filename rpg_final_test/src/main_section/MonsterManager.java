package main_section;

import java.util.ArrayList;

public class MonsterManager {
	
	private static MonsterManager instance = new MonsterManager();
	private String[][] monsterName = {
			{"Green_slime","Red_slime","Special_slime","Boss_slime"},
			{"Green_goblin","Red_goblin","Special_goblin","Boss_goblin"},
			{"Green_ork","Red_ork","Special_ork","Boss_ork"}};
	
	private String path = "monster.";
	private static ArrayList<Unit> monsterList;
	
	public void setMonster(int sel) {
		int size = 4;
		monsterList = new ArrayList<>(); 
		
		for(int i = 0; i < size; i++) {
			int ranInt = Lobby.ran.nextInt(monsterName[sel].length-1);
			
			if(i == size-1){ranInt = 3;}
			
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
