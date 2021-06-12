package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Take extends Command {
	String output = "";
	
	Take(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}