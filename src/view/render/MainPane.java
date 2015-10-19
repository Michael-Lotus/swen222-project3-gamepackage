package view.render;

import model.Level;
import model.Location;
import model.Terrain;
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
		// for each Location in the Level,
		for (Location[] row : level.getLevelMap()) {
			for (Location location : row) { 	
				//System.out.println("Drawing Location: "+location.getY()+", "+location.getX());
				// add a terrain image to the grid at that Location's coordinates
				add(new TerrainView(location), location.getY(), location.getX());
				
				// then, if there are Items/Doors/Actors there, add those images over the top
				if( !location.isEmpty() ){
					location.getItems().stream().forEach(item 
							-> add(new ItemView(item), location.getY(), location.getX()));
				}
				if( location.getDoor() != null ) {
					ItemView doorImage = new ItemView(location.getDoor());
					// check which way the door should be orientated
					if (row[ location.getY() - 1 ].getTerrain() == Terrain.FLOOR) {
						doorImage.setRotate(270);
					}
					add(doorImage, location.getY(), location.getX());
				}
				if( location.getActor() != null ) {
					add(new ActorView(location.getActor()), location.getY(), location.getX());
				}

			}
		}
		 
	}


}
