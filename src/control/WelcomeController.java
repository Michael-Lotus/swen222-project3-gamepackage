package control;

import view.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeController {

	private Main mainApplication;
	
	@FXML
	public void newGame(ActionEvent event) {
		event.consume();
		System.out.println("New Game button pressed");
		try {
			mainApplication.startNewGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void exitGame(ActionEvent event) {
		System.out.println("Exit button pressed");
		Platform.exit();
		System.exit(0);
	}
	

	public void initialize() {
		System.out.println("WelcomeController initialized");
	}
	

	public void setMainApplication(Main main) {
		mainApplication = main;
	}
	
}
