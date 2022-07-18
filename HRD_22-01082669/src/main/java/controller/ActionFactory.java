package controller;


import action.joinAction;


public class ActionFactory {
	public ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action =null;
		
		if (command.equals("join")) action = new joinAction();

		
		return action;
	}
}