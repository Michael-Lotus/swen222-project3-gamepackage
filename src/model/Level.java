package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.actor.Actor;

/**
 * Stores the map of all locations, and manages the movement of actors between them.
 * 
 * @author Michael 300273397
 */
public class Level {

	private Cell[][] levelMap;
	private List<Actor> actors; // player should always be index 0 
	// (unsure if this is bad style, but it is convenient and concise.. =/ )

	public Level(String mapFilename) {
		levelMap = LevelGenerator.parseMap(mapFilename);
		actors = new ArrayList<>();
	}

	public void addActor(Actor actor, int x, int y) {
		Cell cell = levelMap[x][y];
		// first check that coordinates are a valid location
		if (isOccupied(cell) || cell.getTerrain() == Terrain.WALL) {
			throw new IllegalArgumentException(
					"Cannot place Actor at Location (" + x + "," + y + ")");
		}
		actors.add(actor);
		actor.setCell(cell);
	}

	public Actor getActor(int index) {
		return actors.get(index);
	}

	public List<Actor> getActors() {
		return Collections.unmodifiableList(actors);
	}

	public Actor getPlayer() {
		return getActor(0);
	}

	public void playerInteract() {
		actors.get(0).interact();
	}

	private boolean isOccupied(Cell cell) {
		return actors.stream().anyMatch(actor -> actor.getCell() == cell);
	}

	public boolean moveActor(Actor actor, Direction dir) {
		if (dir == null) {
			return false;
		}
		return moveActorTo(actor, getAdjacent(actor.getCell(), dir));
	}

	public boolean movePlayer(Direction dir) {
		return moveActor(actors.get(0), dir);
	}

	public boolean moveActorTo(Actor actor, Cell newLoc) {
		if (isOccupied(newLoc)) {
			return false;
		}
		actor.setCell(newLoc);
		return true;
	}

	public Cell getCell(int x, int y) {
		return levelMap[x][y];
	}

	public Cell getAdjacent(Cell cell, Direction dir) {
		int newX = cell.x + dir.getX();
		int newY = cell.y + dir.getY();
		if (newX < 0 || newX >= levelMap.length || newY < 0
				|| newY >= levelMap.length) {
			// new cell is out of bounds
			return null;
		}
		return levelMap[newX][newY];
	}

	public List<Cell> getAllAdjacent(Cell cell) {
		ArrayList<Cell> adjacentLocations = new ArrayList<>();
		for (Direction direction : Direction.values()) {
			Cell adjacent = getAdjacent(cell, direction);
			if (adjacent != null) {
				adjacentLocations.add(adjacent);
			}
		}
		return adjacentLocations;
	}

	public Cell[][] getLevelMap() {
		return levelMap;
	}

}
