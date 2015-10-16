package control;

import view.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class Controller {

	private Main mainApplication;
	
	public void newGame(ActionEvent event) {
		System.out.println("New Game button pressed");
		event.consume();
		mainApplication.startNewGame();
	}
	
	public void exitGame(ActionEvent event) {
		System.out.println("Exit button pressed");
		Platform.exit();
		System.exit(0);
	}

	public void initialize() {
		System.out.println("Controller initialized");
	}

	public void setMainApplication(Main main) {
		mainApplication = main;
	}
}
