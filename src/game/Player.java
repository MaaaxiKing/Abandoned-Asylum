package game;
import java.util.HashSet;
import java.util.Vector;

import command.CommandFactory;
import item.*;
import furniture.*;

public class Player {
	HashSet<Item> inventory = new HashSet<Item>(4); //4: Inventargroesse
	Room location;
	Vector<Integer> position = location.position;
	
	void drop(Item item) throws Exception {
		location.items.add(item);
		inventory.remove(item);
	}
	
	void enter(Room room) {
		if (room != location && (room.position.get(0) == position.get(0) || room.position.get(1) == position.get(1)) && room.passage.open) {
			location = room;
			position = room.position;
			room.entered();
			return;
		}
		Game.inform(CommandFactory.invalidMessage);
	}
	
	void inspect() {
		
	}
	
	void inventory() {
		
	}
	
	void put(Item item) {
		for (Furniture furniture: location.furniture) {
			(furniture).items.add(item);
			inventory.remove(item);
		}
	}
	
	void take(Item item) {
		inventory.add(item);
	}
	
	void use(Item item, Room room) {
		if (item instanceof Glass) {
			
		} else if (item instanceof Key) {
			if (location.passage instanceof LockedDoor) {
				((LockedDoor) location.passage).tryOpen((Key) item);
			}
		}
	}
}