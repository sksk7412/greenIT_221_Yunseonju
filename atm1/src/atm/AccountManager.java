package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
	public static ArrayList<Account> account = new ArrayList<>();
	
	public static void createAccount() {
		boolean run = false;
		int index = -1;
		int usercode = -1;
		Scanner in = new Scanner(System.in);
		
		System.out.println("아이디: ");
		String id = in.next();
		System.out.println("비밀번호: ");
		String pw = in.next();
		
		for(int i = 0; i < UserManager.user.size(); i++) {
			if(UserManager.user.get(i).getId().equals(id) && UserManager.user.get(i).getPw().equals(pw)) {
				run = true;
				index = i;
				usercode = UserManager.user.get(i).getCode();
			}
		}
		
		if(run) {
			System.out.println("1.계좌 개설 2.계좌 삭제");
			int sel = in.nextInt();
			
			if(sel == 1) {
				if(UserManager.user.get(index).getAccCnt() < 3) {
					System.out.println("축하합니다!!");
					System.out.println("== 계좌 생성 완료==");
					
					Account temp = new Account(usercode, 1 + UserManager.user.get(index).getAccCnt() ,1000);
					account.add(temp);
					System.out.println("가입비 천원 입금해드렸습니다.");
					
					UserManager.user.get(index).setAccCnt( 1 + UserManager.user.get(index).getAccCnt());
	
				}
				else
					System.out.println("아이디 한개당 최대 계좌 개설은 3개까지 가능합니다.");
			}
			else if(sel == 2) {
				
				for(int i =0; i < UserManager.user.get(index).getAccCnt(); i++) {
					System.out.println("고객님의 계좌");
					System.out.println((i+1) +". "+"계좌번호: "+ account.get(index).getAccNum() +"  money: " +account.get(index).getMoney());
				}
				System.out.println("삭제할 계좌 번호 입력:");
				int num = in.nextInt();
				
				System.out.println(num);
			}
			else
				System.out.println("다시 선택하세요.");
		}
		else
			System.out.println("아이디나 비밀번호가 옳지 않습니다.");
	}
}
