package atm;

import java.util.Scanner;

public class UserManager {
	
	static UserManager instance = new UserManager(); 
	
	User[] userList;
	int userCount;
	static int accNumber = 1000;
	
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
		//아이디 탈퇴
		else if(sel == 2) {
			int index = -1;
			System.out.println("탈퇴할 아이디: ");
			String id = in.next();
			System.out.println("비밀번호: ");
			String pw = in.next();
			
			//아이디 true / false 확인절차
			for(int i = 0; i < userCount; i++) {
				if(userList[i].getId().equals(id) && userList[i].getPw().equals(pw)) {
					index = i;
				}
			}
			if(index != -1) {
				//아이디 삭제 과정.
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
		//temp에 로그인 회원 정보를 가져온다.
		User temp = userList[Bank.log];	
		
		System.out.println("=== 계좌는 아이디 1개당 최대 3개까지 개설이 가능합니다. ===");
		if(temp.accCount > 2) {
			System.out.println("생성할 수 있는 계좌를 초과하였습니다.");
		}
		else {																									 
			if(temp.accCount == 0) {
				temp.accList = new Account[temp.accCount + 1];
			}
			else {
				Account[] temp1 = temp.accList;
				temp.accList = new Account[temp.accCount + 1];
				for(int i =0; i < temp.accCount; i++) {
					temp.accList[i] = temp1[i];
				}
			}
			//배열 생성 후 값 넣는 작업
			temp.accList[temp.accCount] = new Account();
			
			temp.accList[temp.accCount].number = String.valueOf(accNumber+1); 
			temp.accList[temp.accCount].money = 1000;
			System.out.println("축하합니다!! 계좌 개설 완료~");
			System.out.println();
			accNumber++;
			temp.accCount++;
		}
	}
	//계좌 삭제
	public void deleteAcc() {
		User temp = userList[Bank.log];
		if(temp.accCount > 0) {
			int accNumberIndex = -1;
			//회원 정보 출력
			userList[Bank.log].infoPrint();
			
			System.out.println("삭제할 계좌번호: ");
			int number = Bank.in.nextInt();
			for(int i = 0; i< temp.accCount; i++ ) {
				if(temp.accList[i].number.equals(String.valueOf(number))) {
					accNumberIndex = i;
				}
			}
			if(accNumberIndex != -1) {
				if(temp.accCount == 1) {
					temp.accList = null;
				}
				else {
					int j = 0;
					Account[] temp1 = temp.accList;
					temp.accList = new Account[temp.accCount - 1];
					for(int i = 0; i < temp1.length; i++) {
						if(accNumberIndex != i) {
							temp.accList[j] = temp1[i];
							j++;
						}
					}
				}
				System.out.println("계좌 삭제완료");
				System.out.println();
				accNumber--;
				temp.accCount--;
			}
			else
				System.out.println("계좌번호를 다시 확인해주세요.");
			
		}
		else
			System.out.println("계좌를 개설하세요.");
	}
	//입금
	public void income() {
		User temp = userList[Bank.log];
		if(temp.accCount > 0) {
			
			int check = -1;
			userList[Bank.log].infoPrint();
			
			System.out.println("입금할 계좌번호: ");
			int accNumberIndex = Bank.in.nextInt();
			
			for(int i =0; i < temp.accCount; i++) {
				if(temp.accList[i].number.equals(String.valueOf(accNumberIndex))) {
					check = i;
				}
			}
			if(check != -1) {
				System.out.println("입금할 금액: ");
				int cash = Bank.in.nextInt();
				
				if(cash > 0) {
					temp.accList[check].money += cash;
				}
				else
					System.out.println("가격을 다시 확인하세요.");
			}
			else
				System.out.println("계좌정보를 다시 확인해주세요.");
		}
		else
			System.out.println("계좌를 개설하세요.");
	}
	//출금
	public void withdraw() {
		User temp = userList[Bank.log];
		if(temp.accCount > 0) {
			int check = -1;
			userList[Bank.log].infoPrint();
			
			System.out.println("출금할 계좌번호: ");
			int accNumberIndex = Bank.in.nextInt();
			
			for(int i =0; i < temp.accCount; i++) {
				if(temp.accList[i].number.equals(String.valueOf(accNumberIndex))) {
					check = i;
				}
			}
			if(check != -1){
				System.out.println("출금할 금액: ");
				int cash = Bank.in.nextInt();
				
				if(cash <= temp.accList[check].money) {
					temp.accList[check].money -= cash;
					System.out.println("출금 완료");
				}
				else
					System.out.println("금액이 너무 큽니다.");
			}
			else
				System.out.println("계좌정보를 다시 확인해주세요.");
		}
		else
			System.out.println("계좌를 개설하세요.");
	}
	//이체
	public void transfer() {
		int accIndex = -1;
		User temp = userList[Bank.log];
		if(temp.accCount > 0) {
			
			for(int i = 0; i < userCount; i++) {
				userList[i].infoPrint();
			}
			System.out.println("이체할 계좌번호: ");
			int accNum = Bank.in.nextInt();
			
			for(int i =0; i < userCount; i++) {
				for(int j =0; j < temp.accCount; j++) {
					if(userList[i].accList[j].number.equals(String.valueOf(accNum))) {
						accIndex = j;
					}
				}
			}
			
			if(accIndex != -1) {
				int checkSendIndex1 = -1;
				int checkSendIndex2 = -1;
				for(int i = 0; i < userCount; i++) {
					userList[i].infoPrint();
				}
				System.out.println("입금할 계좌번호: ");
				int sendAccIndex = Bank.in.nextInt();
				System.out.println("이체금액: ");
				int cash = Bank.in.nextInt();
				
				for(int i =0; i < userCount; i++) {
					for(int j =0; j < temp.accCount; j++) {
						if(userList[i].accList[j].number.equals(String.valueOf(accNum))) {
							checkSendIndex1 = i;
							checkSendIndex2 = j;
						}
					}
				}
				
				if(checkSendIndex2 != -1) {
					
					if(temp.accList[accIndex].money >= cash) {
						
						temp.accList[accIndex].money -= cash;
						userList[checkSendIndex1].accList[checkSendIndex2].money +=cash;
						
						System.out.println("이체 완료");
					}
					else
						System.out.println("이체할 잔액이 부족합니다.");
				}
				else
					System.out.println("계좌번호를 다시 확인해주세요.");
			}
			else
				System.out.println("계좌번호를 다시 확인해주세요.");
		}
		else
			System.out.println("계좌를 개설하세요.");
	}
	//계좌 조회
	public void lookupAcc() {
		User temp = userList[Bank.log];
		if(temp.accCount > 0) {
			userList[Bank.log].infoPrint();
		}
		else
			System.out.println("계좌를 개설하세요.");
	}

}




