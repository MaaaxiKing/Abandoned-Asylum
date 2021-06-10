import java.util.ArrayList;

public class Table extends Furniture {
	ArrayList<Item> items = new ArrayList<Item>();
	boolean inspectedYet = false;
	String[] inspections = new String[] {null, "You take a close look at the table, there is %s on it!"};
	
	Table(String firstInspection, Item... items) {
		inspections[0] = firstInspection;
		for (Item item: items) {
			this.items.add(item);
		}
	}
}