package com.presentation.controller;

import com.presentation.commands.Command;
import com.presentation.commands.CommandEnum.Commands;


public abstract class FactoryCommand {
	
private static FactoryCommand instance;
	
	public static synchronized FactoryCommand getInstance() {
		
		if(instance == null)
			instance = new FactoryCommandImp();
		
		return instance;
	}
	
	public abstract Command parseCommand(Commands command);
}
