package view.render;

import model.Level;
import model.Location;
import model.item.Item;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 * The Pane to draw all Nodes on for displaying the game world.
 */
public class MainPane extends GridPane {
	
	private Level level;
	

	public MainPane(Level level) {
		super();
		this.level = level;
	}
	
	
	public void loadLocations() {
		for (Location[] row : level.getLevelMap()) {
			for (Location location : row) { 	// for each location in the level,
				
				add(new LocationView(location), location.getY(), location.getX());
				
				if( !location.isEmpty() ){
					for(Item item : location.getItems()){
						add(new ItemView(item), location.getY(), location.getX());
					}
				}
				if( location.getDoor() != null ) {
					add(new ItemView(location.getDoor()), location.getY(), location.getX());
				}
				
			}
		}
		
	}

}
