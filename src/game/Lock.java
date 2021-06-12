package game;
import command.CommandFactory;
import item.Key;

public class Lock {
	Key requiredkey;
	boolean locked = true;
	
	Lock(Key requiredkey) {
		this.requiredkey = requiredkey;
	}
	
	void tryUnlock(Key key) {
		if (key == requiredkey) {
			unlock();
		} else {
			Game.inform(CommandFactory.invalidMessage);
		}
	}
	
	void unlock() {
		locked = false;
	}
}