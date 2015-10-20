package view.render;

import model.Level;
import model.Cell;
import model.Terrain;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * The Pane to draw all Nodes on for displaying the game world.
 */
public class MainPane extends GridPane {

	
	public void loadLevel(Level level) {
		// for each Location in the Level,
		for (Cell[] row : level.getLevelMap()) {
			for (Cell cell : row) { 	
				int cellX = (int) cell.getX();
				int cellY = (int) cell.getY();
				// add a terrain image to the grid at that Location's coordinates
				add(new TerrainView(cell), cellY, cellX);
				
				// then, if there are Items/Doors/Actors there, add those images over the top
				if( !cell.isEmpty() ){
					add(new ImageView("file:images/SHADOW.png"), cellY, cellX);
					cell.getItems().stream().forEach(item 
							-> add(new ItemView(item), cellY, cellX));
				}
				if( cell.getDoor() != null ) {
					ItemView doorImage = new ItemView(cell.getDoor());
					// check which way the door should be orientated
					if (row[ cellY - 1 ].getTerrain() == Terrain.FLOOR) {
						doorImage.setRotate(270);
					}
					add(doorImage, cellY, cellX);
				}

			}
		}
		level.getActors().stream().forEach(actor -> add(new ImageView("file:images/SHADOW.png"), (int)actor.getCell().getY(), (int)actor.getCell().getX()));
		level.getActors().stream().forEach(actor -> add(new ActorView(actor), (int)actor.getCell().getY(), (int)actor.getCell().getX()));
	}

}
