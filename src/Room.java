import java.util.ArrayList;
import java.util.Vector;

public class Room {
	boolean visitedYet = false;
	Vector<Integer> position;
	Furniture[] furniture;
	Item[] items;
	String[] observations;
	ArrayList<Passage> passages = new ArrayList<Passage>();
	
	Room(Vector<Integer> position, Furniture[] furniture, Item[] items, String[] observations, Passage... passages) {
		this.position = position;
		this.furniture = furniture;
		this.items= items;
		for (Passage passage: passages) { // foreach-Schleife: kürzere for-Schleife (fuer jede door in den passages hier fuege den passages oben diese passage hinzu)
			this.passages.add(passage);//this heisst, es greift auf das obere passages der zeile 4 zu.
		}
	}
}