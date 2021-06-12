package command;

import java.lang.reflect.InvocationTargetException;

import game.Player;

public class Enter extends Command {
	String output = "";
	
	Enter(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		super(player, command);
	}
}