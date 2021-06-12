package command;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

import game.Game;
import game.Player;

abstract class Command {
	String output;
	
	Command(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		execute(player, command);
	}
	
	void execute(Player player, String command) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		inform(output);
		if (new StringTokenizer(command).hasMoreTokens()) {
			Class.forName("Player").getDeclaredMethod(command.substring(0, command.indexOf(" ")), Object.class).invoke(player, command.split(" ")[1]);
		} else {
			Class.forName("Player").getDeclaredMethod(command.substring(0, command.indexOf(" "))).invoke(player);
		}
	}
	
	void inform(String output) {
		Game.inform(output);
	}
}