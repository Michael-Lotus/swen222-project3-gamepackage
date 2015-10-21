package view.ui;

import java.io.IOException;

import control.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Stage that handles it's own loading of an fxml document.
 */
public class FxmlStage extends Stage {

	protected final String fxmlFilename;
	protected Controller controller;

	public FxmlStage(String fxmlFilename) {
		super();
		this.fxmlFilename = fxmlFilename;
	}

	public void loadLayout() throws IOException {
		FXMLLoader loader;

		try {
			loader = new FXMLLoader(getClass().getResource(fxmlFilename));
		} catch (Exception e) {
			throw new IOException("ERROR LOADING " + fxmlFilename, e);
		}

		Parent root = loader.load();

		try {
			controller = loader.<Controller> getController();
		} catch (Exception e) {
			throw new IOException("ERROR LOADING CONTROLLER", e);
		}

		setScene(new Scene(root));
	}

	public Controller getController() {
		return controller;
	}

}
