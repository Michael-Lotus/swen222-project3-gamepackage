package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.actor.AbstractActor;

/**
 * Stores the map of all locations, and manages the movement of actors between them.
 * 
 * @author Michael 300273397
 */
public class World {

	private Location[][] worldMap;
	private List<AbstractActor> actors;

	public World(String mapFilename) {
		worldMap = WorldGenerator.parseMap(mapFilename);
		actors = new ArrayList<>();
	}

	public boolean moveActor(AbstractActor actor, Direction dir) {
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
		return worldMap[x][y];
	}
	
	public Location getAdjacent(Location loc, Direction dir) {
		return worldMap[ loc.getX() + dir.getX() ][ loc.getY() + dir.getY() ];
	}

	public List<Location> getAllAdjacent(Location loc) {
		ArrayList<Location> adjacentLocations = new ArrayList<Location>();
		int x = loc.getX();
		int y = loc.getY();
		for(Direction direction: Direction.values()){
			int newX = x + direction.getX();
			int newY = y + direction.getY();
			if(newX < 0 || newX >= worldMap.length
					|| newY < 0 || newY >= worldMap.length){
				// if a direction would go out of bounds, skip it
				continue;
			}
			adjacentLocations.add(worldMap[newX][newY]);
		}
		return adjacentLocations;
	}

	public Location[][] getWorldMap() {
		return worldMap;
	}


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

}
