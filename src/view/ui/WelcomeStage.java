package view.ui;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Window to present options for beginning/loading the game.
 */
public class WelcomeStage extends Stage {


	public WelcomeStage() {
		super();
		setTitle("Welcome Screen");
	}

	public WelcomeStage(StageStyle style) {
		super(style);
		setTitle("Welcome Screen");
	}

}
