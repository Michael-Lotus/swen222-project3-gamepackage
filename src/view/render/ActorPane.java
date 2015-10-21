package view.render;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import model.Level;
import model.actor.Actor;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Pane for drawing and positioning Actors.
 */
public class ActorPane extends Pane {

	private List<ActorView> actorViews = new ArrayList<>();
	private double animationSpeed = 0.2;

	public void loadAllActors(Level level) {
		level.getActors().stream().forEach(actor -> loadActor(actor));
	}

	public void loadActor(Actor actor) {
		ActorView view = new ActorView(actor);
		getChildren().add(view);
		actorViews.add(view);
	}
	
	public void animateActor(Actor actor, int cellSize) {
		ActorView actorView = actorViews.stream()
				.filter(view -> view.getActor().equals(actor)).findFirst()
				.get();
		Timeline timeline = new Timeline();
		KeyValue startX = new KeyValue(actorView.xProperty(), actorView.getLayoutX());
		KeyValue startY = new KeyValue(actorView.yProperty(), actorView.getLayoutY());
		KeyValue endX = new KeyValue(actorView.xProperty(), actor.getCell().getX() * cellSize);
		KeyValue endY = new KeyValue(actorView.yProperty(), actor.getCell().getY() * cellSize);
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, startX, startY),
				new KeyFrame(new Duration(animationSpeed), endX, endY));
		timeline.play();
	}

	public void positionActor(Actor actor, int cellSize) {
		Point location = new Point((actor.getCell().x * cellSize), (actor.getCell().y * cellSize));
		actorViews.stream().filter(view -> view.getActor().equals(actor))
				.findFirst().ifPresent(actorView -> actorView.relocate(location.getX(), location.getY()));
	}

	public void positionAllActors(int cellSize) {
		actorViews.stream().forEach(
				view -> positionActor(view.getActor(), cellSize));
	}

	public void animateAllActors(int cellSize) {
		actorViews.stream().forEach(
				view -> animateActor(view.getActor(), cellSize));
	}

}
