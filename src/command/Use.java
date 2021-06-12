package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Use extends Command {
	String output = "";
	
	Use(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}