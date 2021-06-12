package furniture;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.Game;
import item.Item;

public abstract class Furniture {
	public Set<Item> items = new HashSet<Item>();
	List<String> inspectionMessages;
	public boolean isBeingInspected = false;
	
	Furniture(String[] inspectionMessages, Item[] items) {
		this.inspectionMessages = Arrays.asList(inspectionMessages);
		Collections.addAll(this.items, items);
	}
	
	Furniture(String[] inspectionMessages) {
		this.inspectionMessages = Arrays.asList(inspectionMessages);
	}
	
	void inspect() {
		isBeingInspected = true;
		Game.inform(inspectionMessages.get(0));
		if (inspectionMessages.size() == 2) {
			inspectionMessages.remove(0);
		}
	}
}