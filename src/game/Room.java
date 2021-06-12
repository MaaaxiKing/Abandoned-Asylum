package game;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import furniture.Furniture;
import item.Item;

public class Room {
	Vector<Integer> position = new Vector<Integer>(2);
	Passage passage;
	Furniture[] furniture;
	Set<Item> items;
	List<String> observationMessages;
	
	Room(Vector<Integer> position, Passage passage, Furniture[] furniture, Item[] items, String[] observationMessages) {
		this.position = position;
		this.furniture = furniture;
		Collections.addAll(this.items, items);
		this.observationMessages = Arrays.asList(observationMessages);
		this.passage = passage;
	}
	
	Room(Vector<Integer> position, Passage passage, Furniture[] furniture, String[] observationMessages) {
		this.position = position;
		this.furniture = furniture;
		this.observationMessages = Arrays.asList(observationMessages);
		this.passage = passage;
	}
	
	Room(Vector<Integer> position, Passage passage, Item[] items, String[] observationMessages) {
		this.position = position;
		Collections.addAll(this.items, items);
		this.observationMessages = Arrays.asList(observationMessages);
		this.passage = passage;
	}
	
	Room(Vector<Integer> position, Passage passage, String[] observationMessages) {
		this.position = position;
		this.observationMessages = Arrays.asList(observationMessages);
		this.passage = passage;
	}
	
	void entered() {
		Game.inform(String.format(observationMessages.get(0), items.toString()));
		if (observationMessages.size() == 2) {
			observationMessages.remove(0);
		}
	}
}