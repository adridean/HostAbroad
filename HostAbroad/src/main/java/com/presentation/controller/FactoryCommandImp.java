package com.presentation.controller;

import com.presentation.commands.Command;
import com.presentation.commands.CommandEnum.Commands;

/**
 * This class is created to dynamically load all of the available commands written 
 * in the CommandEnum.
 * 
 *<pre>
 * Before any modifications contact the author.
 *</pre> 
 *
 * @author Gasan Nazer
 */

public class FactoryCommandImp extends FactoryCommand {

	@Override
	public Command parseCommand(Commands command) {
		Command loadedCommand = null;
		try {
			  Class loadedClass = Class.forName("com.presentation.commands." + command);  // Dynamically load every command
			  Object loadedObject = loadedClass.newInstance(); // Dynamically instantiate it
			  loadedCommand = (Command)loadedObject;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exeption in FactoryCommandImp parseCommand().");
			}
		
		return loadedCommand;
	}

}
