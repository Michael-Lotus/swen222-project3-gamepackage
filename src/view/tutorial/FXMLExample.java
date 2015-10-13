package view.tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class FXMLExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("fxml_example.fxml"));
		
		Scene scene = new Scene(root, 400, 300);
		
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
