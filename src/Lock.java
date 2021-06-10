
public class Lock {
	Key requiredkey;
	boolean locked = true;
	
	Lock(Key requiredkey) {
		this.requiredkey = requiredkey;
	}
	
	boolean isUnlockable(Key key) {
		return key == requiredkey;
	}
}