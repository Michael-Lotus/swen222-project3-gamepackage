package control;

import java.io.IOException;

import model.actor.ActorProfession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SelectionController extends Controller {

	@FXML
	public void warriorPressed(ActionEvent event) {
		System.out.println("Warrior button pressed");
		mainApplication.createPlayerActor(ActorProfession.WARRIOR, 1, 1);
		event.consume();
		startGame();
	}

	@FXML
	public void roguePressed(ActionEvent event) {
		System.out.println("Rogue button pressed");
		mainApplication.createPlayerActor(ActorProfession.ROGUE, 1, 1);
		event.consume();
		startGame();
	}

	@FXML
	public void magePressed(ActionEvent event) {
		System.out.println("Mage button pressed");
		mainApplication.createPlayerActor(ActorProfession.MAGE, 1, 1);
		event.consume();
		startGame();
	}

	@FXML
	public void nonePressed(ActionEvent event) {
		System.out.println("None button pressed");
		mainApplication.createPlayerActor(null, 1, 1);
		event.consume();
		startGame();
	}

	private void startGame() {
		try {
			mainApplication.startMainScreen();
		} catch (IOException e) {
			throw new UnsupportedOperationException("ERROR STARTING GAME", e);
		}
	}

}
