package atm;

import java.util.Scanner;

public class Bank {
	boolean run = true;
	static Scanner in = new Scanner(System.in);
	public static int log = -1; // 로그인 확인 static 변수
	
	UserManager usermanager = UserManager.instance;
	FileManager fileManager = FileManager.instance;
	
	public void menu() {
		
		System.out.println("=== 메뉴 선택 ===");
		System.out.println("1. 회원 가입 / 탈퇴");
		System.out.println("2. 로그인");
		System.out.println("3. 종 료");
		int sel = in.nextInt();
		
		if(sel == 1) usermanager.createId();
		else if(sel == 2) logInCheck();
		else if(sel == 3) run = false;
		else
			System.out.println("다시 입력하세요.");
	}
	public void logIn() {
		while(true) {
			FileManager.instance.save();
			
			//고객 정보 출력
			usermanager.userList[log].infoPrint();
			
			System.out.println("[" + usermanager.userList[log].getId() + "님, 로그인]");		
			System.out.println("[1]계좌생성");
			System.out.println("[2]입금하기");
			System.out.println("[3]출금하기");
			System.out.println("[4]이체하기");
			System.out.println("[5]계좌조회");
			System.out.println("[6]계좌삭제");
			System.out.println("[0]로그아웃");
			
			System.out.print("메뉴를 선택하세요 : ");
			int choice = in.nextInt();
			
			if(choice == 1) { usermanager.createAccount();} 	// 계좌 생성
			else if(choice == 2) { usermanager.income(); }  	// 입금
			else if(choice == 3) { usermanager.withdraw(); } 	// 출금
			else if(choice == 4) { usermanager.transfer(); } 	// 이체
			else if(choice == 5) { usermanager.lookupAcc(); } 	// 조회
			else if(choice == 6) { usermanager.deleteAcc(); } 	// 계좌 삭제
			else if(choice == 0) { 
				log = -1;
				System.out.println("[메세지]로그아웃되었습니다.");
				break; 
			}
		}
	}
	//로그인을 위한 아아디 및 비밀번호 check
	public void logInCheck() {
		boolean check =  false;
		System.out.println("아이디: ");
		String id = in.next();
		System.out.println("비밀번호: ");
		String pw = in.next();
		
		for(int i =0; i < usermanager.userCount; i++){
			if(usermanager.userCount != 0 && usermanager.userList[i].getId().equals(id) && usermanager.userList[i].getPw().equals(pw)) {
				check = true;
				log = i;	 //사용의 용이를 위해 log값을 index로 저장한다.
			}
		}
		if(check) {
			logIn();
		}
		else
			System.out.println("사용자 정보를 다시 확인해주세요.");
	}
	public void run() {
		FileManager.instance.load();
		while(run) {
			menu();
		}
	}
}
