package command;

import game.Player;

public class CommandFactory {
	public static String invalidMessage = "Oh, I did not know you could do this. Welp, here you can't. Try something else, fool!";
	
	public void createCommand(Player player, String command) throws Exception {
		Class.forName(/*"command."+*/command.substring(0, command.indexOf(" "))).getDeclaredConstructor().newInstance(player, command);
	}
		//return command
}