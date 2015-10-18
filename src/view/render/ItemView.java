package view.render;

import model.Location;
import model.item.Item;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles the rendering of Items.
 */
public class ItemView extends ImageView {
	
private final Item item;
	
	
	public ItemView(Item item) {
		this.item = item;
		System.out.println("LOADING: images/" + item.id() + ".png");
		try {
		     this.setImage(new Image("file:images/" + item.id() + ".png"));
		} catch (Exception e) {
			throw new IllegalArgumentException("ERROR LOADING ITEM IMAGE", e);
		}
	}
	

	public Item getLocation() {
		return item;
	}

}
