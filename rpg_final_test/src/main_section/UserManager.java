package main_section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	//
	private static UserManager instance = new UserManager();

	private static Map<Integer, User> userMap;
	private static int userCodeNum;
	private int log;

	private UserManager() {
		userMap = new HashMap<>();
	}

	public User getUser() {
		return userMap.get(log);
	}

	//
	public void menu() {
		while (true) {

			System.out.println("[1.로그인] [2.회원가입] [3.회원 탈퇴] [0. 종료]");
			int sel = Lobby.in.nextInt();
			if (sel == 1)
				Login();
			else if (sel == 2)
				createId();
			else if (sel == 3)
				deleteId();
			else if (sel == 0)
				break;
			else
				System.err.println("다시 선택하시오.");
		}

	}

	private void Login() {
		Lobby lobby = new Lobby();
		boolean check = false;

		System.out.println("아이디 입력: ");
		String LogId = Lobby.in.next();
		System.out.println("비밀번호 입력: ");
		String LogPw = Lobby.in.next();

		for (Integer i : userMap.keySet()) {
			if (LogId.equals(userMap.get(i).getId()) && LogPw.equals(userMap.get(i).getPw())) {
				
				log = i;
				System.out.println("log: "+log);
				check = true;
				break;
			}
		}

		if (check) {
			System.out.println("[ 로그인 ]");
			lobby.menu();
		} else
			System.err.println("아이디 혹은 비밀번호가 옳지 않습니다.");
	}

	private void createId() {
		boolean check = true;

		System.out.println("가입할 아이디: ");
		String creId = Lobby.in.next();
		System.out.println("가입할 비밀번호: ");
		String crePw = Lobby.in.next();

		for (Integer i : userMap.keySet()) {
			if (userMap.get(i).getId().equals(creId))
				check = false;
		}


		if (check) {
			User user = new User(creId, crePw, userCodeNum);

			// 핵심
			userMap.put(userCodeNum++, user);
			
			System.out.println("회원 가입 완료.");
		} else
			System.err.println("중복된 아이디 입니다.");
	}

	private void deleteId() {
		boolean check = false;

		System.out.println("탈퇴할 아이디: ");
		String deleId = Lobby.in.next();
		System.out.println("탈퇴할 비밀번호: ");
		String delePw = Lobby.in.next();

		for (Integer i : userMap.keySet()) {
			if (userMap.get(i).getId().equals(deleId)  && userMap.get(i).getPw().equals(delePw))
				check = true;
		}

		if (check) {
			userMap.remove(log);
			System.out.println("회원 탈퇴 완료.");
		} else
			System.err.println("아이디 혹은 비밀번호가 옳지 않습니다.");

	}

	public static UserManager getInstance() {
		return instance;
	}

}
