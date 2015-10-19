package view.render;

import java.util.Random;

import model.Location;
import model.Terrain;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles the rendering of Terrain.
 */
public class TerrainView extends ImageView {

	int rand = new Random().nextInt(2) + 1; // random integer between 1 and 3 (inclusive)
	
	public TerrainView(Location location) {
		
		String filename;
		if ( location.getTerrain() == Terrain.FLOOR ) {
			filename = location.getTerrain() + "_" + rand + ".png";
		} else {
			filename = location.getTerrain() + ".png";
		}
		
		//System.out.println("LOADING: images/"+filename);
		try {
		     this.setImage(new Image("file:images/"+filename));
		} catch (Exception e) {
			throw new IllegalArgumentException("ERROR LOADING TERRAIN IMAGE", e);
		}
		
	}
	

}
