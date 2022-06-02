package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
//	Scanner in = new Scanner(System.in);
	public static ArrayList<User> user = new ArrayList<>();
	
	public static void createId() {
		boolean run = true;
		Scanner in = new Scanner(System.in);
		System.out.println("이 름: ");
		String name = in.next();
		System.out.println("생성할 아이디: ");
		String id = in.next();
		System.out.println("생성할 비밀번호: ");
		String pw = in.next();
		
		if(user.size() == 0) {
			User temp = new User(user.size()+1,name,id,pw);
			user.add(temp);

		}
		else {
			for(int i = 0; i < user.size(); i++) {
				if(user.get(i).getId().equals(id)) {
					run = false;
				}
			}
			
			if(run) {
				User temp = new User(user.size()+1,name,id,pw);
				user.add(temp);
			}
			else
				System.out.println("이미 존재하는 아이디입니다.");
		}
	}
}
