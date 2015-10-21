package control;

import view.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeController extends Controller {

	@FXML
	public void newGame(ActionEvent event) {
		event.consume();
		try {
			mainApplication.startSelectionScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void exitGame(ActionEvent event) {
		event.consume();
		Platform.exit();
		System.exit(0);
	}

	public void initialize() {

	}

	@Override
	public void setMainApplication(Main main) {
		mainApplication = main;
	}

}
