package view.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import control.Controller;
import view.render.ActorPane;
import view.render.CellPane;

public class MainStage extends FxmlStage {

	private CellPane cellPane;
	private ActorPane actorPane;

	public MainStage() {
		this("MainScreenLayout.fxml");
	}

	public MainStage(String fxmlFilename) {
		super(fxmlFilename);
	}

	@Override
	public void loadLayout() throws IOException {
		FXMLLoader loader;

		try {
			loader = new FXMLLoader(getClass().getResource(fxmlFilename));
		} catch (Exception e) {
			throw new IOException("ERROR LOADING " + fxmlFilename, e);
		}

		StackPane root = loader.load();

		try {
			controller = loader.<Controller> getController();
		} catch (Exception e) {
			throw new IOException("ERROR LOADING CONTROLLER", e);
		}

		setScene(new Scene(root));
		cellPane = (CellPane) root.getChildren().get(0);
		actorPane = (ActorPane) root.getChildren().get(1);
	}

	public CellPane getCellPane() {
		return cellPane;
	}

	public ActorPane getActorPane() {
		return actorPane;
	}

}
