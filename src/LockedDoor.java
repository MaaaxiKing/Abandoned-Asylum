
public class LockedDoor extends Passage {
	Lock lock;
	
	LockedDoor(Lock lock) {
		this.lock = lock;
	}
	
	boolean isOpenable(Key key) {
		return lock.isUnlockable(key);
	}
}