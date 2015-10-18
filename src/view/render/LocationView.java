package view.render;

import java.io.File;
import java.util.Arrays;

import model.Location;
import model.Terrain;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles the rendering of Locations.
 */
public class LocationView extends ImageView {
	
	private final Location location;
	
	
	public LocationView(Location location) {
		this.location = location;
		System.out.println("LOADING: images/" + location.getTerrain() + ".png");
		try {
		     this.setImage(new Image("file:images/" + location.getTerrain() + ".png"));
		} catch (Exception e) {
			throw new IllegalArgumentException("ERROR LOADING TERRAIN IMAGE", e);
		}
	}
	

	public Location getLocation() {
		return location;
	}
	
}
