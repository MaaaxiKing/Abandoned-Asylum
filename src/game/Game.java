package game;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Vector;

import command.CommandFactory;
import command.Help;
import furniture.*;
import item.*;

public class Game {
	Key finalKey, uselessKey, closetKey = new Key();
	Room lobby = new Room(new Vector<Integer>(1, 1), new Passage(), new Furniture[] {new Table(new String[] {"On the rather broken table, a TV is positioned.\r\n"
			+ "White noise seems to be the most interesting channel."}, new Item[] {new TV()})}, new Item[] {uselessKey}, new String[] {"You are in the lobby of an abandoned asylum. It does look creepy, but classy.\r\n"
			+ "All in all, you can feel the roaring 20’s dancing around in your mind.\r\n"
			+ "Look, the folding door behind you is closed.\r\n"
			+ "After giving it a pull and then a push you realise that you might be locked in.\r\n"
			+ "You look about and see a KEY laying on the counter.\r\n"
			+ "Behind it, there is a TABLE.\r\n"
			+ "Next to the counter you can find a door leading to the HALLWAY.\r\n"
			+ "It swings wide open, you could just enter it.", "You’re back at the lobby, back at start.\r\n"
					+ "The Table wasn’t moved, the rest is pretty much the same too.\r\n"
					+ "On the floor there is %s!"}),
		hallway = new Room(new Vector<Integer>(1, 2), new Passage(), new String[] {"You enter a dark hallway, so dark you can only see a few meters wide.\r\n"
				+ "You can make out a weird chair sitting weirdly around in one weird corner.\r\n"
				+ "It has a weird aura, but nothing much more to it.\r\n"
				+ "Like Bed and Breakfast, Bonnie and Clyde, even weird chair had a perfect companion.\r\n"
				+ "A torn up bed on wheels.\r\n"
				+ "It almost seemed as if you could count the kilometers the bed was rolled about in the stab wounds in the mattress.\r\n"
				+ "To the left, you could visit INSANATORY, an insanely quiet place.\r\n"
				+ "To the right, the CELL of the uncontrolled.\r\n"
				+ "At the end of the hallway, quite a walk, ROOM666 is positioned.\r\n"
				+ "You know that, because you can read the doors title.\r\n"
				+ "Of course you can also go back to the LOBBY.", "What could possibly be behind tha… aah it’s the hallway again.\r\n"
						+ "Da same ol’ weird chair weirdly sittin’ in its weird corner still havin’ a weird aura.\r\n"
						+ "And mister slashed up bed.\r\n"
						+ "”Twenty Eight Stabwounds”, a calm and quiet voice screams from afar.\r\n"
						+ "The INSANATORY, CELL, ROOM666, and the LOBBY are still there. What a trait!"}),
		insanatorium = new Room(new Vector<Integer>(0, 2), new Passage(), new Furniture[] {new Sink(new String[] {"It’s just a fucking sink, what do you expect?\\n"})}, new Item[] {new Glass(), closetKey}, new String[] {"A room, looking like someone birthed six children who all lived their entire life in here.\r\n"
				+ "‘twas a perfect depiction of this place.\r\n"
				+ "Old and abandoned but also kinda dirty, though empty.\r\n"
				+ "A SINK is placed underneath a window.\r\n"
				+ "This asylum seems to be made ”for crazy people, by crazy people.”\r\n"
				+ "The reflection in it is just horrible, since there is some insane person looking right at you.\r\n"
				+ "Dead eyes, probably dead inside, just some crazy person.\r\n"
				+ "Then you realise it is you looking back at you.\r\n"
				+ "You take a step back, trippin’ over a GLASS with a KEY inside.\r\n"
				+ "Well, whilst trippin’ (over them) you slightly break the glass.\r\n"
				+ "It is now cracked up (like you) and the key’s out.", "No, even though you need rehab, this isn’t it.\r\n"
						+ "It is just the place with the SINK and the overreflective window.\r\n"
						+ "We don’t really want to see your true form again.\r\n"
						+ "On the floor, there is %s!"}),
		room666 = new Room(new Vector<Integer>(1, 3), new LockedDoor(new Lock(finalKey)), new Furniture[] {new Table(new String[] {"Oh yes, gimmie that table, it is so beautifully made, maybe hand crafted?\r\n"
				+ "On it, of course, is a TV. I mean you do prefer the books, but the TV is interactable.\r\n"
				+ "Try to pick it up. Yes it is heavy but also pretty as hell."}, new Item[] {new TV(), new Knife()})}, new String[] {"It looks like a hotel room, it smells like a hotel room.\r\n"
						+ "It is a roaring 20’s hotel room in an abandoned and godforsaken asylum.\r\n"
						+ "It is nice there. The lights are warm and bright, some books are lying around on a night tray ready to be red.\r\n"
						+ "A bed, a fireplace, also the first nice looking TABLE of this building, all is to be found in this satanic room.\r\n"
						+ "The walls are covered in a detailed wallpaper. Those patterns were in once, let’s hope they’ll be in again soon.\r\n"
						+ "There is a walkable CLOSET in one wall.\r\n"
						+ "Its doors were shut tightly, but there has to be a way in it.\r\n"
						+ "Somehow you have to get into the closet.", "Why did you even leave this room?\r\n"
								+ "The TABLE is the nicest of all and the closet seems to attract you somehow."}),
		closet =  new Room(new Vector<Integer>(1, 4), new Passage(), new Item[] {finalKey}, new String[] {"You now can open the doors of the nicest walk-in-closet you have ever seen.\r\n"
				+ "Carefully you take a step inside.\r\n"
				+ "It is hella dark inside, because you dork forgot to turn on the lights.\r\n"
				+ "Well actually, you aren't really capable of doing that. But it is still your fault.\r\n"
				+ "You don’t want to get back now. You're almost there\r\n"
				+ "Deep inside the closet. On the floor you can feel a KEY through your shoes.\r\n"
				+ "Nicely done, you stepped on it!", "”Guess who's back, back again” in the closet.\r\n"
						+ "Did you even try to use the KEY?"}),
		cell = new Room(new Vector<Integer>(2, 2), new Passage(), new Item[] {new Knife()}, new String[] {"Imagine wearing a straitjacket. Now bang your head against the walls. Do it!\r\n"
				+ "Does it hurt?\r\n"
				+ "Of course not, this cell is padded. Was padded.\r\n"
				+ "Now the pads are slashed open. Someone smeared ”Edna war hier!” over them.\r\n"
				+ "Right hand corner, a fan reveals his presence behind one of the slashed opened pads. Some toenails are lying around too. Harvey would be delighted, if you rampaged.\r\n"
				+ "There is a KNIFE on the padded floor.", "The padded cell, ahhhh, what a delightful room to be in.\r\n"
						+ "There is %s on the floor, but still, delightful."});
	Room[] rooms = new Room[] {lobby, hallway, cell, insanatorium, room666, closet};
	Player player = new Player();
	Scanner scanner = new Scanner(System.in);
	CommandFactory commandFactory = new CommandFactory();
	
	void play() {
		player.enter(lobby);
		try {
			new Help(player, "");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {
			inform(CommandFactory.invalidMessage);
		}
		readInput();
	}
	
	public static void inform(String information) {
		System.out.println(information);
	}
	
	private void readInput() {
		boolean readOK = false;
		do {
			try {
				commandFactory.createCommand(player, scanner.nextLine());
				readOK = true;
			} catch (Exception e) {
				inform(CommandFactory.invalidMessage);
			}
		} while (readOK == false);
	}
}