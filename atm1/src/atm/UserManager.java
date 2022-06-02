package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
//	Scanner in = new Scanner(System.in);
	public static ArrayList<User> user = new ArrayList<>();
	
	public static void createId() {
		boolean run = true;
		Scanner in = new Scanner(System.in);
		
		System.out.println("1.회원가입 2.회원탈퇴");
		int sel = in.nextInt();
		
		if(sel == 1) {
			
			System.out.println("이 름: ");
			String name = in.next();
			System.out.println("생성할 아이디: ");
			String id = in.next();
			System.out.println("생성할 비밀번호: ");
			String pw = in.next();
			
			if(user.size() == 0) {
				User temp = new User(user.size()+1,name,id,pw);
				user.add(temp);
				System.out.println("생성 완료.");

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
					System.out.println("생성 완료.");
				}
				else
					System.out.println("이미 존재하는 아이디입니다.");
			}
		}
		else if(sel == 2) {
			boolean runs = false;
			System.out.println("탈퇴할 아이디: ");
			String id = in.next();
			System.out.println("비밀번호: ");
			String pw = in.next();
			
			for(int i = 0; i < user.size(); i++) {
				if(user.get(i).getId().equals(id) && user.get(i).getPw().equals(pw)) {
					user.remove(i);
					runs = true;
				}
			}
			if(runs) {
				System.out.println("탈퇴 완료");
			}
			else
				System.out.println("아이디 및 비밀번호를 다시 확인하세요.");
		}
		else
			System.out.println("다시 선택하세요.");
	
	}
}