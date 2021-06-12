package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Drop extends Command {
	String output = "%s dropped.";
	
	Drop(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}