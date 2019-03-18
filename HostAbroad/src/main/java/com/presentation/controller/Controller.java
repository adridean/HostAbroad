package com.presentation.controller;

import com.presentation.commands.CommandEnum.Commands;
import com.presentation.commands.Pair;

public abstract class Controller {
	private static Controller instance;
	
	public static synchronized Controller getInstance() {
		if(instance == null){
			instance = new ControllerImp();
		}
		return instance;
	}
	
	public abstract Pair<Integer, Object> action(Commands evento, Object transfer);

}
