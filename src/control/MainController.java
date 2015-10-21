package control;

import model.Cell;
import model.Direction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainController extends Controller{

	@FXML
	public void keyTyped(KeyEvent event) {
		System.out.println("Key typed");
		event.consume();
	}

	@FXML
	public void mouseClicked(MouseEvent event) {
		System.out.println( "Mouse clicked @ x=" + event.getSceneX() + ", y=" + event.getSceneY() );
		
		Cell playerCell = mainApplication.getLevel().getPlayer().getCell();
		int cellSize = mainApplication.getCellSize();
		
		double xDiff = playerCell.getX() * cellSize + cellSize/2 - event.getSceneX();
		double yDiff = playerCell.getY() * cellSize + cellSize/2 - event.getSceneY();
		System.out.println("xDiff = "+xDiff+",  yDiff = "+yDiff);
		System.out.println(Direction.towardsPoint(xDiff, -yDiff));
		
		mainApplication.getLevel().movePlayer(Direction.towardsPoint(xDiff, -yDiff));
		
		playerCell = mainApplication.getLevel().getPlayer().getCell();
		System.out.println("Player Location = ("+playerCell.x+", "+playerCell.y+")");
		
		mainApplication.updateActors();
		
		event.consume();
	}

	@FXML
	public void interactPressed(ActionEvent event) {
		mainApplication.getLevel().playerInteract();
	}
	
	
	public void initialize() {
		System.out.println("MainController initialized");
	}



}
