import java.util.ArrayList;
import java.util.Vector;

public class Player {
	ArrayList<Item> inventory = new ArrayList<Item>(4); //4: Inventargroesse
	Room location;
	Vector<Integer> position = location.position;
	
	void enterRoom(Room room) {
		room.passage.tryUnlock();
		location = room;
		position = room.position;
	}
	
	void put() {
		
	}
	
	void drop() {
		
	}
}