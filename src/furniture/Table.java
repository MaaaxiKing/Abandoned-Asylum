package furniture;

import item.Item;

public class Table extends Furniture {

	public Table(String[] inspectionMessages, Item[] items) {
		super(inspectionMessages, items);
	}
	
	public Table(String[] inspectionMessages) {
		super(inspectionMessages);
	}
}