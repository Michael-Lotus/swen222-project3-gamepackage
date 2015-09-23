package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 
 * @author Michael 300273397
 */
public class World {

	private Location[][] worldMap;
	private List<Actor> players;

	public World(String mapFilename) {
		worldMap = MapParser.parseMap(mapFilename);
		players = new ArrayList<>();
	}

	public void Move(Actor actor, Direction direction) {
		// TODO
	}

	public Location getLocation(int x, int y) {
		return worldMap[x][y];
	}

	public List<Location> getAdjacent(Location loc) {
		ArrayList<Location> adjacentLocations = new ArrayList<Location>();
		int x = loc.getX();
		int y = loc.getY();
		// calculate adjacent coordinates
		int[][] coordinates = {	
				{x-1, y-1},	{x, y-1}, {x+1, y-1},
				{x-1,  y },   		  {x+1,  y },
				{x-1, y+1},	{x, y+1}, {x+1, y+1} 
		};
		for(int[] coord: coordinates){
			int i = coord[0]; 
			int j = coord[1];
			// if any coordinate is out-of-bounds, skip it
			if ( i < 0 || i >= worldMap.length || j < 0 || j >= worldMap[0].length ){
				continue;
			}
			adjacentLocations.add(worldMap[i][j]);
		}
		return adjacentLocations;
	}

	public Location[][] getWorldMap() {
		return worldMap;
	}


	/*
	// Not sure where to put this ...
	
	public interface LocationRow extends Iterable<Location> {
	}

	public interface LocationGrid extends Iterable<LocationRow> {  
	}

	public class ArrayLocationRow implements LocationRow {
		private Location[] locations;
		public Iterator<Location> iterator() {
			// ... or how to implement this method 
		}
	}

	public class ArrayLocationGrid implements LocationGrid {
		private LocationRow[] rows;
		public Iterator<LocationRow> iterator() {
			// ...
		}
	}

	public class BoundedLocationGrid implements LocationGrid {
		private ArrayLocationGrid delegate;
		private int offsetX;
		private int offsetY;
		private int width;
		private int height;
		// ...
		@Override
		public Iterator<LocationRow> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	 */

	public static void main(String[] args) {
		World w = new World("Map.txt");

		// print map
		for(Location[] row: w.getWorldMap()){
			String s = "";
			for(Location loc: row){
				s = s.concat(String.valueOf(loc.getTerrain().getSymbol()));
			}
			System.out.println(s);
		}

		// test adjacent to centre location
		System.out.println();
		System.out.println("Locations adjacent to (2,2):");
		List<Location> testAdjacent = w.getAdjacent(w.getLocation(2, 2));
		for(Location loc: testAdjacent){
			System.out.println(loc.toString());
		}
		// test adjacent to corner location
		System.out.println();
		System.out.println("Locations adjacent to (0,0):");
		testAdjacent = w.getAdjacent(w.getLocation(0, 0));
		for(Location loc: testAdjacent){
			System.out.println(loc.toString());
		}
	}

}
