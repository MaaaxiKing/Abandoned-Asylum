package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Inspect extends Command {
	String output = "";
	
	Inspect(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}