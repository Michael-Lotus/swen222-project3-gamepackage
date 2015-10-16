package view.ui;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Main window. Provides menus and hosts the main Scene (onto which the world is drawn) 
 */
public class MainStage extends Stage {

	public MainStage() {
		super();
		setTitle("Main Screen");
	}

	public MainStage(StageStyle style) {
		super(style);
		setTitle("Main Screen");
	}
}
