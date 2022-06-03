package atm;

import java.util.Scanner;

public class UserManager {
	
	static UserManager instance = new UserManager(); 
	
	User[] userList;
	int userCount;
	
	public void createId() {
		boolean run = true;
		Scanner in = new Scanner(System.in);
		
		System.out.println("1.회원가입 2.회원탈퇴");
		int sel = in.nextInt();
		
		if(sel == 1) {
			System.out.println("생성할 아이디: ");
			String id = in.next();
			System.out.println("생성할 비밀번호: ");
			String pw = in.next();
			
			// 유저가 한명도 없을경우
			if(userCount == 0) {
				userList =  new User[userCount + 1];
				userList[userCount] = new User(id,pw);		
				System.out.println("생성 완료.");
				userCount++;

			}
			//유저가 1명이상일 경우 
			else {
				//아이디 중복 검사
				for(int i = 0; i < userCount; i++) {
					if(userList[i].getId().equals(id)) {
						run = false;
					}
				}
				//아이디 중복이 참이면 if문을 돌아 아이디 생성
				if(run) {
					User temp[] = userList;
					userList = new User[userCount + 1];
					for(int i =0; i < userCount; i++) {
						userList[i] = temp[i];
					}
					
					userList[userCount] = new User(id,pw);
					System.out.println("생성 완료.");
					userCount++;
				}
				else
					System.out.println("이미 존재하는 아이디입니다.");
			}
		}
		else if(sel == 2) {
			int index = -1;
			System.out.println("탈퇴할 아이디: ");
			String id = in.next();
			System.out.println("비밀번호: ");
			String pw = in.next();
			
			for(int i = 0; i < userCount; i++) {
				if(userList[i].getId().equals(id) && userList[i].getPw().equals(pw)) {
					index = i;
				}
			}
			if(index != -1) {
				int j = 0;
				User temp[] = userList;
				userList = new User[userCount - 1];
				for(int i = 0; i < userCount; i++) {
					if(index != i) {
						userList[j] = temp[i];
						j++;
					}
				}		
				System.out.println("탈퇴 완료");
			}
			else
				System.out.println("아이디 및 비밀번호를 다시 확인하세요.");
		}
		else
			System.out.println("다시 선택하세요.");
	}
	//계좌 생성
	public void createAccount() {
		
	}
	//계좌 삭제
	public void deleteAcc() {
		
	}
	//입금
	public void income() {
		
	}
	//출금
	public void withdraw() {
		
	}
	//이체
	public void transfer() {
		
	}
	//계좌 조회
	public void lookupAcc() {
		
	}

}




