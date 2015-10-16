package view;

import control.Controller;
import view.ui.MainStage;
import view.ui.WelcomeStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Main Application class for handling Stages (windows) and launching game.
 */
public class Main extends Application {
	
	private Stage welcomeScreen = new WelcomeStage(StageStyle.UTILITY);
	private Stage mainScreen = new MainStage();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// load welcome screen fxml document
		FXMLLoader loader;
		try { loader = new FXMLLoader(getClass().getResource("welcomescreen_layout.fxml")); } 
		catch (Exception e) { throw new Exception("Error loading welcomescreen_layout.fxml", e); }
		Pane root = loader.load();
		
		// provide controller with a reference to this instantiation of Main
		loader.<Controller>getController().setMainApplication(this);
		
		welcomeScreen.setScene(new Scene(root));
		welcomeScreen.show();
	}
	
	public void startNewGame() {
		mainScreen.show();
	}
	
	public void exit() {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}