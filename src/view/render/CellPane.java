package view.render;

import java.util.Arrays;

import model.Level;
import model.Cell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * The Pane to draw all Cells and their contents.
 */
public class CellPane extends GridPane {

	public void loadLevel(Level level) {
		for (Cell[] row : level.getLevelMap()) {
			Arrays.asList(row).stream().forEach(cell -> loadCell(cell));
		}

	}

	public void loadCell(Cell cell) {
		// add a terrain image to the grid at that Location's coordinates
		add(new TerrainView(cell), cell.y, cell.x);

		// then, if there are Items and/or Doors there, add those images over the top
		if (!cell.isEmpty()) {
			add(new ImageView("file:images/SHADOW.png"), cell.y, cell.x);
			cell.getItems().stream()
					.forEach(item -> add(new ItemView(item), cell.y, cell.x));
		}
		if (cell.getDoor() != null) {
			add(new ImageView("file:images/SHADOW.png"), cell.y, cell.x);
			add(new ItemView(cell.getDoor()), cell.y, cell.x);
		}
	}

}
