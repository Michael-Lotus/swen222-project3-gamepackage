package view;


import java.awt.Point;

import model.Level;
import model.actor.*;
import control.*;
import view.render.ActorPane;
import view.render.CellPane;
import view.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Main Application class for handling Stages (windows) and launching game.
 */
public class Main extends Application {

	private Stage welcomeScreen = new WelcomeStage(StageStyle.UTILITY);
	private Stage mainScreen = new MainStage();
	private final int cellSize = 64;
	private Level level;
	private CellPane cellPane;
	private ActorPane actorPane;


	@Override
	public void start(Stage primaryStage) throws Exception {

		// load welcome screen fxml document
		FXMLLoader loader;
		try { loader = new FXMLLoader(getClass().getResource("welcomescreen_layout.fxml")); } 
		catch (Exception e) { throw new Exception("ERROR LOADING 'welcomescreen_layout.fxml'", e); }
		Pane root = loader.load();

		// provide the controller with a reference to this instantiation of Main
		loader.<WelcomeController>getController().setMainApplication(this);

		welcomeScreen.setScene(new Scene(root));
		welcomeScreen.show();
	}


	public void startNewGame() throws Exception {
		try { setLevel(new Level("data/map.txt")); } 
		catch (Exception e) { throw new IllegalArgumentException ("ERROR LOADING LEVEL", e); }

		// load main screen fxml document
		FXMLLoader loader;
		try { loader = new FXMLLoader(getClass().getResource("mainscreen_layout.fxml")); } 
		catch (Exception e) { throw new Exception("ERROR LOADING 'mainscreen_layout.fxml'", e); }
		StackPane root = loader.load();

		// provide the controller with a reference to this instantiation of Main
		loader.<MainController>getController().setMainApplication(this);

		cellPane = (CellPane) root.getChildren().get(0);
		actorPane = (ActorPane) root.getChildren().get(1);
		mainScreen.setScene(new Scene(root));
		cellPane.loadLevel(level);
		actorPane.loadAllActors(level);
		actorPane.positionAllActors(cellSize);
		
		mainScreen.show();
		welcomeScreen.hide();
	}
	
	
	public Bounds getCellPaneBounds() {
		return cellPane.getLayoutBounds();
	}
	
	
	public int getCellSize() {
		return cellSize;
	}
	
	
	public Level getLevel() {
		return level;
	}
	

	public void setLevel(Level level) {
		this.level = level;
		level.addActor(new NonPlayerActor(), 1, 1);
	}


	public static void main(String[] args) {
		launch(args);
	}


	public void updateActors() {
		actorPane.positionAllActors(cellSize);
	}
}