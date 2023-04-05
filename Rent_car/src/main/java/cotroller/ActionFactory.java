package cotroller;

import cotroller.action.Action;
import cotroller.action.JoinAction;

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
		return action;
	}
	
}
