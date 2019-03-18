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
		Command com = null;
		try {
			  Class c = Class.forName("com.presentation.commands." + command);  // Dynamically load every command
			  Object o = c.newInstance(); // Dynamically instantiate it
			  com = (Command)o;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exeption in FactoryCommandImp parseCommand().");
			}
		
		return com;
	}

}
