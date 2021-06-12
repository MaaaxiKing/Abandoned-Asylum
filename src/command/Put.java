package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Put extends Command {
	String output = "";
	
	Put(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}