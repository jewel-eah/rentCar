package controller;

import controller.action.*;

public class ActionFactory {

	
	// singleton pattern
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	// 넘어오는 command 에 따라 action 수행 
	
	public Action getAction(String command) {
		// 기본 액션 초기화 
		Action action = null;
		
		if(command.equals("join")) {
			action = new JoinAction();
		}	
		else if(command.equals("login")) {
			action = new LoginAction();
		}
		else if(command.equals("booking")) {
			action = new BookingAction();
		}
		return action;
	}
	
}
