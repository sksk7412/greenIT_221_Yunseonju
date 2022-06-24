package monster;

import java.util.ArrayList;
import java.util.Random;

import main_section.Item;

public class BossItem {

	public static ArrayList<Item> bossItem = new ArrayList<>();
	
	public static Item menu(int sel) {
		Random ran = new Random();

		if(sel == 1) {
			Item temp = new Item(1,"아지노스의 전투검",120,35000);
			bossItem.add(temp);
			temp = new Item(2,"말캉한 슬라임 방패",85,32000);
			bossItem.add(temp);
			temp = new Item(2,"매끈한 슬라임 신발",75,29000);
			bossItem.add(temp);
		}
		else if(sel == 2) {
			Item temp = new Item(1,"토라수스의 지팡이",250,65000);
			bossItem.add(temp);
			temp = new Item(1,"고대왕의 망치",222,55000);
			bossItem.add(temp);
			temp = new Item(3,"니스라무스의 펜던트",300,89000);
			bossItem.add(temp);
		}
		else if(sel == 3) {
			Item temp = new Item(1,"드레나이의 카타나",650,165000);
			bossItem.add(temp);
			temp = new Item(3,"상투스의 깨지지않는 인장",650,180000);
			bossItem.add(temp);
			temp = new Item(3,"영원한 보은",750,300000);
			bossItem.add(temp);
		}
		int itemIndex = ran.nextInt(bossItem.size());
		
		return bossItem.get(itemIndex);
	}
	
	
}
