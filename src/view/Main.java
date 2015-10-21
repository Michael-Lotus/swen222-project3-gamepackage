package view;

import java.io.IOException;

import model.Level;
import model.actor.*;
import view.ui.FxmlStage;
import view.ui.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main Application class for handling Stages (windows) and launching game.
 */
public class Main extends Application {

	private MainStage mainScreen;
	private FxmlStage selectionScreen;
	private FxmlStage welcomeScreen;
	private final int cellSize = 64;
	private Level level;

	@Override
	public void start(Stage primaryStage) throws IOException {
		welcomeScreen = new FxmlStage("WelcomeScreenLayout.fxml");
		welcomeScreen.loadLayout();
		welcomeScreen.getController().setMainApplication(this);
		welcomeScreen.show();
	}

	public void startSelectionScreen() throws IOException {
		welcomeScreen.hide();
		try {
			setLevel(new Level("data/map.txt"));
		} catch (Exception e) {
			throw new IOException("ERROR LOADING LEVEL", e);
		}

		selectionScreen = new FxmlStage("SelectionScreenLayout.fxml");
		selectionScreen.loadLayout();
		selectionScreen.getController().setMainApplication(this);

		selectionScreen.show();
	}

	public void startMainScreen() throws IOException {
		selectionScreen.hide();

		mainScreen = new MainStage();
		mainScreen.loadLayout();
		mainScreen.getController().setMainApplication(this);
		mainScreen.getCellPane().loadLevel(level);
		mainScreen.getActorPane().loadAllActors(level);
		mainScreen.getActorPane().positionAllActors(cellSize);

		mainScreen.show();
	}

	public int getCellSize() {
		return cellSize;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void createPlayerActor(ActorProfession profession, int x, int y) {
		if (profession != null) {
			level.addActor(new PlayerActor(profession), x, y);
		} else {
			level.addActor(new NonPlayerActor(), x, y);
		}
	}

	public void updateActors() {
		mainScreen.getActorPane().positionAllActors(cellSize);
	}

	public static void main(String[] args) {
		launch(args);
	}

}