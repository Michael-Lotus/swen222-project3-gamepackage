package model;

import java.util.ArrayList;
import java.util.List;

import model.actor.Actor;

/**
 * Stores the map of all locations, and manages the movement of actors between them.
 * 
 * @author Michael 300273397
 */
public class Level {

	private Location[][] levelMap;
	private List<Actor> actors;

	
	public Level(String mapFilename) {
		levelMap = LevelGenerator.parseMap(mapFilename);
		actors = new ArrayList<>();
	}
	
	
	public void addActor(Actor actor, int x, int y) {
		
		if (levelMap[x][y].getActor() != null || levelMap[x][y].getTerrain() == Terrain.WALL) {
			throw new IllegalArgumentException("Cannot place Actor at Location ("+x+","+y+")");
		}
		
		actors.add(actor);
		actor.setLocation(levelMap[x][y]);
		levelMap[x][y].setActor(actor);
	}
	

	public boolean moveActor(Actor actor, Direction dir) {
		Location oldLoc = actor.getLocation();
		Location newLoc = getAdjacent(oldLoc, dir);
		if(newLoc.getActor() != null){
			return false;
		}
		oldLoc.removeActor();
		actor.setLocation(newLoc);
		newLoc.setActor(actor);
		return true;
	}
	

	public Location getLocation(int x, int y) {
		return levelMap[x][y];
	}
	

	public Location getAdjacent(Location loc, Direction dir) {
		return levelMap[ loc.getY() + dir.getX() ][ loc.getX() + dir.getY() ];
	}
	

	public List<Location> getAllAdjacent(Location loc) {

		// return new BoundedLocationGrid(this.locationGrid, loc.x - 1, loc.y - 1, 3, 3);

		ArrayList<Location> adjacentLocations = new ArrayList<>();
		int x = loc.getY();
		int y = loc.getX();
		for(Direction direction: Direction.values()){
			int newX = x + direction.getX();
			int newY = y + direction.getY();
			if(newX < 0 || newX >= levelMap.length
					|| newY < 0 || newY >= levelMap.length){
				// if a direction would go out of bounds, skip it
				continue;
			}
			adjacentLocations.add(levelMap[newX][newY]);
		}
		return adjacentLocations;
	}
	

	public Location[][] getLevelMap() {
		return levelMap;
	}


	/*
	 *  --- EXAMPLE ITERATOR ---
	 *  
	import java.util.Arrays;
	import java.util.Iterator;

	public class StringRow implements Iterable<String>{

		private String[] strings;

		@Override
		public Iterator<String> iterator() {
			return Arrays.asList(strings).iterator();
		}
	
	}
	
	StreamSupport.stream(iterable.spliterator(), false);
	stream.forEach(x -> renderLocation( x ));
	
	--- EXAMPLE LocationGrid IMPLIMENTATION ---

	interface LocationRow extends Iterable<Location> {
	}

	interface LocationGrid extends Iterable<LocationRow> {  
	}

	class ArrayLocationRow implements LocationRow {
		private Location[] locations;
		Iterator<Location> iterator() {
			// ...
		}
	}

	class ArrayLocationGrid implements LocationGrid {
		private LocationRow[] rows;
		Iterator<LocationRow> iterator() {
			// ...
		}
	}

	class BoundedLocationGrid implements LocationGrid {
		private ArrayLocationGrid delegate;
		private int offsetX;
		private int offsetY;
		private int width;
		private int height;
		// ...
	}
 	*/

	/*
	public static void main(String[] args) {
		Level w = new Level("data/map.txt");

		// print map
		for(Location[] row: w.getLevelMap()){
			String s = "";
			for(Location loc: row){
				s = s.concat(String.valueOf(loc.getTerrain().getSymbol()));
			}
			System.out.println(s);
		}

		// test adjacent to centre location
		System.out.println();
		System.out.println("Locations adjacent to (2,2):");
		List<Location> testAdjacent = w.getAllAdjacent(w.getLocation(2, 2));
		for(Location loc: testAdjacent){
			System.out.println(loc.toString());
		}
		// test adjacent to corner location
		System.out.println();
		System.out.println("Locations adjacent to (0,0):");
		testAdjacent = w.getAllAdjacent(w.getLocation(0, 0));
		for(Location loc: testAdjacent){
			System.out.println(loc.toString());
		}
	}
	*/

}
