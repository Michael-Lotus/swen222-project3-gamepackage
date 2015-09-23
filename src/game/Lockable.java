package game;

/**
 * 
 * @author Michael 300273397
 */
public interface Lockable {

	public void lock(Key key);

	public boolean unlock(Key key);
	
	public boolean isLocked();

}
