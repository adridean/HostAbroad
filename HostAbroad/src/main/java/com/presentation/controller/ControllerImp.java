package com.presentation.controller;

import com.presentation.commands.Command;
import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;

public class ControllerImp extends Controller {

	/** Right now this method returns a pair so that the UI will be able to take and use it**/
	@Override
	public Pair<Integer, Object> action(Commands evento, Object transfer){
		FactoryCommand fCommand = FactoryCommand.getInstance();
		Command command = fCommand.parseCommand(evento);	
		
		Pair<Integer, Object> result = command.execute(transfer);
		
		return result;
	}
}
