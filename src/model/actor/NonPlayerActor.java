package model.actor;

public class NonPlayerActor extends AbstractActor {
	
	public enum Disposition {
		FRIENDLY, NEUTRAL, HOSTILE;
	}
	
	protected Disposition disposition;

	public NonPlayerActor(int inventorySize) {
		super(inventorySize);
		disposition = Disposition.NEUTRAL;
	}

	@Override
	public void pickUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub

	}

}
