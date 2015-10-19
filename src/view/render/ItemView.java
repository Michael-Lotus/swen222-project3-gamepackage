package view.render;

import model.item.Item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles the rendering of Items.
 */
public class ItemView extends ImageView {
	
	private Item item;
	
	public ItemView(Item item) {
		this.item = item;
		//System.out.println("LOADING: images/" + item.id() + ".png");
		try {
		     this.setImage(new Image("file:images/" + item.id() + ".png"));
		} catch (Exception e) {
			throw new IllegalArgumentException("ERROR LOADING ITEM IMAGE", e);
		}
	}
	
	
	public Item getItem() {
		return item;
	}
	
}
