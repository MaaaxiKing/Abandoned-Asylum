package game;
import item.Key;

public class LockedDoor extends Passage {
	Lock lock;
	
	LockedDoor(Lock lock) {
		this.lock = lock;
	}
	
	void tryOpen(Key key) {
		lock.tryUnlock(key);
	}
}