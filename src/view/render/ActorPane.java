package view.render;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.Level;
import model.actor.Actor;
import javafx.scene.layout.Pane;

/**
 * Pane for drawing and positioning Actors.
 */
public class ActorPane extends Pane {

	private List<ActorView> actorViews = new ArrayList<>();

	public void loadAllActors(Level level) {
		level.getActors().stream().forEach(actor -> loadActor(actor));
	}

	public void loadActor(Actor actor) {
		ActorView view = new ActorView(actor);
		getChildren().add(view);
		actorViews.add(view);
	}

	public void positionActor(Actor actor, int cellSize) {
		Point location = new Point((actor.getCell().x * cellSize), (actor.getCell().y * cellSize));
		actorViews.stream().filter(view -> view.getActor().equals(actor))
				.findFirst().ifPresent(actorView -> actorView.relocate(location.getX(), location.getY()));
	}

	public void positionAllActors(int cellSize) {
		actorViews.stream().forEach(view -> positionActor(view.getActor(), cellSize));
	}

}
