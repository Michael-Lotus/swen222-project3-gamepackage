package view.render;

import model.actor.Actor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles the rendering of Locations.
 */
public class ActorView extends ImageView {

	private Actor actor;
	
	public ActorView(Actor actor) {
		super();
		this.actor = actor;
		//System.out.println("LOADING: images/" + actor.id() + ".png");
		try {
		     this.setImage(new Image("file:images/" + actor.id() + ".png"));
		} catch (Exception e) {
			throw new IllegalArgumentException("ERROR LOADING ITEM IMAGE", e);
		}
	}
	
	
	public Actor getActor() {
		return actor;
	}

}
