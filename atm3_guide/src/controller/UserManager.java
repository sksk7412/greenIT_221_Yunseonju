package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Account;
import models.User;

public class UserManager {

	public static UserManager instance = new UserManager();

	private ArrayList<User> users = null;

	private UserManager() {
		this.users = new ArrayList<>();
//		init();
	}

	private void init() {
		users.add(new User(1111, "qwer", "1111", "홍길동"));
		users.add(new User(2222, "abcd", "2222", "홍둘리"));
		users.add(new User(3333, "apple", "3333", "도우너"));
	}

	public int checkLog(String id, String pw) {
		int log = 0;
		for (User user : users) {
			if (user.getId().equals(id) && user.getPw().equals(pw))
				return log;
			else
				log++;
		}
		return -1;
	}

	public void joinUser() {
		System.out.print("id: ");
		String id = BankManager.sc.next();
		System.out.print("pw: ");
		String pw = BankManager.sc.next();

		int check = checkLog(id, pw);
		if (check == -1) {
			System.out.print("name: ");
			String name = BankManager.sc.next();
			this.users.add(new User(randomCode(), id, pw, name));
		} else {
			System.out.println("Duplicate ID");
		}
	}

	private long randomCode() {
		Random rn = new Random();

		while (true) {
			long rCode = rn.nextInt(8999) + 1000;

			boolean check = false;
			for (User user : users) {
				if (user.getCode() == rCode)
					check = true;
			}

			if (!check) {
				return rCode;
			}
		}
	}

	public User getUser(int log) {
		return this.users.get(log);
	}

	public int getUserSize() {
		return this.users.size();
	}

	public int getUserAccSize(int log) {
		return users.get(log).getAccsSize();

	}

	public String getAllData() {
		String str = "";
		for (int i = 0; i < this.users.size(); i++) {
			str += this.users.get(i).getCode() + "/";
			str += this.users.get(i).getId() + "/";
			str += this.users.get(i).getPw() + "/";
			str += this.users.get(i).getName() + "\n";
			str += getAccData(i);
		}
		return str;
	}

	public void withdrawalUser() {
		System.out.print("id: ");
		String id = BankManager.sc.next();
		System.out.print("pw: ");
		String pw = BankManager.sc.next();

		int check = checkLog(id, pw);
		if (check != -1) {
			this.users.remove(check);
			System.out.println("Done");
		} else {
			System.out.println("Dose not exist");
		}
	}

	public void addAcc(int log, Account newAcc) {
		this.users.get(log).addAcc(newAcc);
	}

	public void removeAcc(int log, Account e) {
		this.users.get(log).getAccs().remove(e);
	}

	public Account getAccount(int log, int index) {
		return this.users.get(log).getAccount(index);
	}

	public String getAccData(int log) {
		String str = "";
		for (int i = 0; i < this.users.get(log).getAccsSize(); i++) {
			str += "⌞ " + (i + 1) + ") ";
			str += this.users.get(log).getAccount(i).getAccNum() + " : ";
			str += this.users.get(log).getAccount(i).getMoney() + "won";
			if (this.users.get(log).getAccount(i).getRep())
				str += " (V)";
			str += "\n";
		}
		return str;
	}
	
	public void addUser(User e) {
		this.users.add(e);
	}
	
	public void clearUsers() {
		this.users.clear();
	}
}
