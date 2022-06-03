package controller;

import models.Bank;

public class Main {

	public static void main(String[] args) {
		Bank.instance.setBrand("Green");
		BankManager.instance.run();
		
	}

}
