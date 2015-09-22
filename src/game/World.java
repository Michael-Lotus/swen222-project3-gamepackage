package game;

import game.Location.Terrain;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Michael 300273397
 */
public class World {

	private Location[][] worldMap;
	private String mapFilename = "Map.txt";
	private ArrayList<Actor> players;

	public World() {
		parseMap(mapFilename);
		players = new ArrayList<Actor>();
	}
	
	public void Move(Actor actor, Direction direction) {
		// TODO
	}
	
	public Location getLocation(int x, int y) {
		return worldMap[x][y];
	}

	public ArrayList<Location> getAdjacent(Location loc) {
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

	private void parseMap(String filename) {
		// First read in the file and store as a List of rows
		ArrayList<String> rows = new ArrayList<String>();
		try{		
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNextLine()){
				rows.add(sc.nextLine());
			}
			sc.close();
		}catch (Exception e){
			System.out.println("Error parsing map.");
			System.out.println(e.toString());
		}
		// Now we can calculate map size and construct the array
		worldMap = new Location[rows.size()][rows.get(0).length()];

		// Then loop through the List, constructing Locations
		int x = 0;
		for(String row: rows){
			int y = 0;
			char[] rowChars = row.toCharArray();
			for(char c: rowChars){
				if ( !Terrain.terrainSymbols.containsKey(c) ){
					throw new IllegalArgumentException("Invalid map format");
				}
				worldMap[x][y] = new Location(x, y, c);
				y++;
			}
			x++;
		}
	}

	public static void main(String[] args) {
		World w = new World();
		
		// print map
		for(Location[] row: w.worldMap){
			String s = "";
			for(Location loc: row){
				s = s.concat(String.valueOf(loc.getTerrain().getSymbol()));
			}
			System.out.println(s);
		}
		
		// test adjacent to centre location
		System.out.println();
		System.out.println("Locations adjacent to (2,2):");
		ArrayList<Location> testAdjacent = w.getAdjacent(w.getLocation(2, 2));
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
