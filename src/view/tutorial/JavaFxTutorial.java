package view.tutorial;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

public class JavaFxTutorial extends Application {
	/*
	// Hello World, JavaFX Style
	@Override
	public void start(Stage primaryStage) {
		Button button = new Button();
		button.setText("Say 'Hello World'");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		
		VBox root = new VBox();
		root.getChildren().add(button);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	*/
	
	
	
	// Creating a Form in JavaFX
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("The Matrix");
		final Text actiontarget = new Text();
		
		// GridPane with Gap and Padding properties
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);	// dynamically centres grid based on contents and window dimensions
		grid.setHgap(10);	// horizontal gap between grid cells
		grid.setVgap(10);	// vertical gap		"	"	"
		grid.setPadding(new Insets(25,25,25,25));	// gap around edges (top, right, bottom, left)
		grid.add(actiontarget, 1, 6);
		actiontarget.setId("actiontarget");
		
		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(JavaFxTutorial.class.getResource("matrix_login.css").toExternalForm());
		
		// Controls
		Text sceneTitle = new Text("Matrix Login..."); 
		sceneTitle.setId("welcome-text");
		//sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
		grid.add(sceneTitle, 0, 0, 2, 1); // col = 0, row = 0, col span = 2, row span = 1
		
		Label username = new Label("User Name:"); // simple text display object
		grid.add(username, 0, 2); // col = 0, row = 2
		
		TextField userTextField = new TextField(); // simple text field object
		grid.add(userTextField, 1, 2); // col = 1, row = 2
		
		Label password = new Label("Password:");
		grid.add(password, 0, 3); // col = 0, row = 3
		
		PasswordField passwordField = new PasswordField(); // text field that obscures text entered by user
		grid.add(passwordField, 1, 3); // col = 1, row = 3
		
		// Button
		Button button = new Button("Log in");
		HBox hbButton = new HBox(10); 	// HBox class arranges its content nodes horizontally in a single row
		hbButton.setAlignment(Pos.BOTTOM_RIGHT);
		hbButton.getChildren().add(button);
		grid.add(hbButton, 1, 4);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("ERROR: Blue pill required.");
			}
		});
		
		//grid.setGridLinesVisible(true);	// useful for debugging purposes
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}