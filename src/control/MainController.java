package control;

import model.Cell;
import model.Direction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainController extends Controller {

	@FXML
	public void keyTyped(KeyEvent event) {
		System.out.println("Key typed");
		event.consume();
	}

	@FXML
	public void mouseClicked(MouseEvent event) {
		event.consume();
		Cell playerCell = mainApplication.getLevel().getPlayer().getCell();
		int cellSize = mainApplication.getCellSize();
		double xDiff = playerCell.getX() * cellSize + cellSize / 2 - event.getSceneX();
		double yDiff = playerCell.getY() * cellSize + cellSize / 2 - event.getSceneY();

		mainApplication.getLevel().movePlayer(
				Direction.towardsPoint(xDiff, -yDiff));
		mainApplication.updateActors();
	}

	@FXML
	public void interactPressed(ActionEvent event) {
		event.consume();
		mainApplication.getLevel().playerInteract();
	}

	public void initialize() {

	}

}
