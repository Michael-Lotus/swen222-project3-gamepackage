package view.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Window to present options for beginning/loading the game.
 */
public class WelcomeStage extends Stage {

	private Scene scene;
	private GridPane grid;

	public WelcomeStage() {
		super();
		setTitle("Welcome Screen");
	}

	public WelcomeStage(StageStyle style) {
		super(style);
		setTitle("Welcome Screen");
	}

}
