package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Account;

public class AccountManager {

	public static AccountManager instance = new AccountManager();

	private ArrayList<Account> accs = null;

	private UserManager um = UserManager.instance;

	private AccountManager() {
		accs = new ArrayList<>();
	}

	public void createAcc(int log) {
		System.out.print("Create new Account \n1)YES or 2)NO : ");
		String input = BankManager.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(sel == 1) {
				int userAccSize = um.getUserAccSize(log);
				long userCode = um.getUser(log).getCode();
				
				if (userAccSize < Account.MAX) {
					Account newAcc = null;
					
					if (userAccSize > 0)
						newAcc = new Account(userCode, randomAccNum());
					else
						newAcc = new Account(true, userCode, randomAccNum());
					
					accs.add(newAcc);
					um.addAcc(log, newAcc);
				}
				else {
					System.out.println("The maximum range has been exceeded.");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private int randomAccNum() {
		Random rn = new Random();

		while (true) {
			int rNum = rn.nextInt(89999) + 10000;

			boolean check = false;
			for (Account acc : accs) {
				if (acc.getAccNum() == rNum)
					check = true;
			}

			if (!check)
				return rNum;
		}
	}

	public int getReqAccIndex(int log) {
		int idx = -1;
		for(int i=0; i<this.um.getUserAccSize(log); i++) {
			if(this.um.getAccount(log, i).getRep()) {
				idx = i;
			}
		}
		return idx;
	}
	
	public void withdrawal(int log) {
		System.out.print("amount money: ");
		String input = BankManager.sc.next();
		
		int idx = getReqAccIndex(log);
		
		try {
			int money = Integer.parseInt(input);
			int balance = this.um.getAccount(log, idx).getMoney();
			if(money <= balance) {
				balance -= money;
				this.um.getAccount(log, idx).setMoney(balance);
			}
			
		} catch (Exception e) {
			System.out.println("Withdrawal failed.");
		}
	}

	public void deposit(int log) {
		System.out.print("amount money: ");
		String input = BankManager.sc.next();
		
		int idx = getReqAccIndex(log);
		
		try {
			int money = Integer.parseInt(input);
			int balance = this.um.getAccount(log, idx).getMoney();
			balance += money;
			this.um.getAccount(log, idx).setMoney(balance);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void inquery(int log) {
		System.out.println(">>");
		for(Account acc : accs) {
			if(um.getUser(log).getCode() == acc.getUserCode()) {
				System.out.println(acc.getUserCode() + " : " + acc.getAccNum() + " : " + acc.getMoney() + "won");
			}
		}
		System.out.println("<<");
	}

	public void transfer(int log) {
		int repIdx = getReqAccIndex(log);
		int repNum = um.getAccount(log, repIdx).getAccNum();
		
		System.out.print("account number: ");
		String input = BankManager.sc.next();
		System.out.print("transfer money: ");
		String input2 = BankManager.sc.next();
		
		try {
			int num = Integer.parseInt(input);
			int money = Integer.parseInt(input2);
			
			int idx = -1;
			for(int i=0; i<this.accs.size(); i++) {
				if(this.accs.get(i).getAccNum() == num)
					idx = i;
			}
			
			if(num != repNum && idx != -1) {
				int balance = this.accs.get(idx).getMoney();
				balance += money;
				this.accs.get(idx).setMoney(balance);
				
				balance = um.getAccount(log, repIdx).getMoney();
				balance -= money;
				um.getAccount(log, repIdx).setMoney(balance);
			}
			else {
				System.out.println("Not aollowed.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public void closeAcc(int log) {
		int repIdx = getReqAccIndex(log);
		int repNum = um.getAccount(log, repIdx).getAccNum();
		
		System.out.print(um.getAccData(log));
		System.out.print("Select account to delete: ");
		String input = BankManager.sc.next();
		
		try {
			int delNum = Integer.parseInt(input);
			
			Account delAcc = null;
			for(Account acc : accs) {
				if(delNum == acc.getAccNum())
					delAcc = acc;
			}
			int money = delAcc.getMoney();
			
			if(um.getUserAccSize(log) > 1) {
				um.removeAcc(log, delAcc);
				this.accs.remove(delAcc);
				
				if(delNum == repNum)
					um.getAccount(log, 0).setRep(true);
				
				int balance = um.getAccount(log, getReqAccIndex(log)).getMoney();
				balance += money;
				um.getAccount(log, getReqAccIndex(log)).setMoney(balance);
			}
			else {
				System.out.println("You must have at least one account.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void changeRepAcc(int log) {
		System.out.print(um.getAccData(log));
		System.out.printf("select 1~%d : ", um.getUserAccSize(log));
		String input = BankManager.sc.next();
		
		try {
			int idx = Integer.parseInt(input) -1;
			
			if(idx >= 0 && idx < um.getUserAccSize(log)) {
				um.getAccount(log, getReqAccIndex(log)).setRep(false);
				um.getAccount(log, idx).setRep(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public int getAccsSize() {
		return this.accs.size();
	}

	public Account getAccount(int index) {
		return this.accs.get(index);
	}
	
	public void addAccount(Account e) {
		this.accs.add(e);
	}
	
	public void clearAccs() {
		this.accs.clear();
	}

}
