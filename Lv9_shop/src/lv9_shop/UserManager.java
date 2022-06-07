package lv9_shop;

import java.util.Random;
import java.util.Vector;

public class UserManager {
	Random ran = new Random();
	  Vector<User> userList = new Vector<>();
	 int userLog = -1;
	
	// 회원가입
	public void join() {
		boolean check = true;
		System.out.println("아이디: ");
		String id = Shop.in.next();
		System.out.println("비밀번호: ");
		String pw = Shop.in.next();
		
		for(int i =0; i < userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				check = false;
			}
		}
		
		if(check){
			User temp = new User(id,pw,ran.nextInt(10000)+3000);
			userList.add(temp);
			System.out.println("회원가입 완료.");
		}
		else
			System.out.println("이미 존재하는 ID입니다.");
		
	}
	//회원 탈퇴
	public void delete() {
		int check = -1;
		System.out.println("아이디: ");
		String id = Shop.in.next();
		System.out.println("비밀번호: ");
		String pw = Shop.in.next();
		
		for(int i =0; i < userList.size(); i++) {
			if(userList.get(i).getId().equals(id) && userList.get(i).getPw().equals(pw)) {
				check = i;
			}
		}
		
		if(check != -1) {
			userList.remove(check);
			System.out.println("회원탈퇴 완료.");
		}
		else
			System.out.println("회원 정보를 다시 확인해주세요.");
	}
	//로그인 확인
	public void logIn() {
		int check = -1;
		
		System.out.println("아이디: ");
		String id = Shop.in.next();
		System.out.println("비밀번호: ");
		String pw = Shop.in.next();
		
		for(int i =0; i < userList.size(); i++) {
			if(userList.get(i).getId().equals(id) && userList.get(i).getPw().equals(pw)) {
				check = i;
			}
		}
		
		if(check != -1) {
			userLog = check;
		}
		else
			System.out.println("회원 정보를 다시 확인해주세요.");
	}
	
	//유저출력
	public void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.print("[" + i + "] ");
			userList.get(i).print();
		}
	}
	
	//관리자 유저 삭제
	public void deleteUser() {
		int check = -1;
		System.out.println("삭제할 유저 ID: ");
		String deleid = Shop.in.next();
		
		for(int i = 0; i < userList.size(); i++ ) {
			if(userList.get(i).getId().equals(deleid)) {
				check = i;
			}
		}
		
		if(check != -1) {
			userList.remove(check);
		}
		else
			System.out.println("아이디를 다시 확인해주세요.");
	}
	//로그 아웃
	public void logOut() {
		
		userLog = -1;
		System.out.println("로그아웃 완료.");
	}
}





