import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Key finalKey, uselessKey, closetKey = new Key();
	Passage lobby_hallway, hallway_insanatorium, hallway_cell, hallway_room666 = new Passage();
	LockedDoor room666_closet = new LockedDoor(new Lock(finalKey));
	Passage[] passages = new Passage[] {lobby_hallway, hallway_insanatorium, hallway_cell, hallway_room666, room666_closet};
	Room lobby = new Room(new Vector<Integer>(1, 1), new Furniture[] {new Table("", new TV(), new Glass())}, new Item[] {uselessKey}, new String[] {"You are in the lobby of an abandoned asylum. It does look creepy, but classy.\\n\r\n"
			+ "All in all, you can feel the roaring 20’s dancing around in your mind.\\n\r\n"
			+ "Look, the folding door behind you is closed.\\n\r\n"
			+ "After giving it a pull and then a push you realise that you might be locked in.\\n\r\n"
			+ "You look about and see a KEY laying on the counter.\\n\r\n"
			+ "Behind it, there is a TABLE.\\n\r\n"
			+ "Next to the counter you can find a door leading to the HALLWAY.\\n \r\n"
			+ "It swings wide open, you could just enter it.\\n", "You’re back at the lobby, back at start.\\n\r\n"
					+ "The Table wasn’t moved, the rest is pretty much the same too.\\n\r\n"
					+ "On the floor there is %s!"}, lobby_hallway),
		hallway = new Room(new Vector<Integer>(1, 2), null, null, new String[] {}, hallway_insanatorium, hallway_cell, hallway_room666),
		insanatorium = new Room(new Vector<Integer>(0, 2), new Furniture[] {new Sink()}, new Item[] {new Glass(), closetKey}, new String[] {}),
		room666 = new Room(new Vector<Integer>(1, 3), new Furniture[] {new Table("", new TV(), new Knife())}, null, new String[] {"", ""}, room666_closet),
		closet =  new Room(new Vector<Integer>(1, 4), null, new Item[] {finalKey}, new String[] {}),
		cell = new Room(new Vector<Integer>(2, 2), null, new Item[] {new Knife()}, new String[] {});
	Room[] rooms = new Room[] {lobby, hallway, cell, insanatorium, room666, closet};
	Player player = new Player();
	Command help = new Command("You can type:\\n\r\n"
			+ "inventory     - to get a look at the things you have\\n\r\n"
			+ "inspect     - to get a further description of an item.\\n\r\n"
			+ "drop         - to violently put an item on the floor.\\n\r\n"
			+ "put         - to place an item onto a table \r\n"
			+ "enter         - to enter a room.\\n\r\n"
			+ "You can interact with the things written in CAPS.\\n\r\n"
			+ ""),
			inventory = new Command(player.inventory.toString()),
			inspect = new Command(),
			drop = new Command(),
			put = new Command(),
			enter = new Command(),
			use = new Command();
	
	void play() {
		player.location = lobby;
		lobby.visitedYet = true;
		welcome();
		inform(help);
	}
	
	private void welcome() {
		System.out.println();
	}
	
	private void inform(String information) {
		System.out.println(information);
	}
	
	private void readAction() {
		String action = scanner.nextLine().toLowerCase();
		Object d = getClass().getDeclaredField(action).get(this);
		System.out.println(d.output);
		if (action == "help") {
			System.out.println();
		} else if (action == "inventory") {
			
		} else if (action.contains("inspect")) {
			if (action.contains("lobby"))
		} else if (action.contains("drop")) {
			
		} else if (action == "put") {
			
		} else if (action.contains("enter")) {
			if (action.substring(action.lastIndexOf(' ') + 1) == "lobby") {// get room by string
				player.enterRoom(lobby);
			}
		} else {
			System.out.println("Oh, I did not know you can do this. Welp, here you can't. Try again fool!");
		}
	}
}