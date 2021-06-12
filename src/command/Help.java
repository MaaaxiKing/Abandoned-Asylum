package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Help extends Command {
	String output = "You can type:\r\n"
				+ "inventory 	- to get a look at the things you have\r\n"
				+ "inspect 	- to get a further description of an item.\r\n"
				+ "drop 		- to violently put an item on the floor.\r\n"
				+ "put 		- to place an item onto a table.\r\n"
				+ "enter 		- to enter a room\r\n"
				+ "You can interact with the things written in CAPS.\r\n"
				+ "To get back into a room, just type enter and the name of the last room you were in.";
	
	public Help(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}