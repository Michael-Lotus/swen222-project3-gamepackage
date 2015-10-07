package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Michael 300273397
 */
public class MapParser {
	
	public static Location[][] parseMap(String filename) {
		Location[][] map;
		// First read in the file and store as a List of rows
		List<String> rows = new ArrayList<>();
		try{		
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNextLine()){
				rows.add(sc.nextLine());
			}
			sc.close();
		}catch (Exception e){
			throw new RuntimeException("Error parsing map", e);
		}
		// Now we can calculate map size and construct the array
		map = new Location[rows.size()][rows.get(0).length()];

		// Then loop through the List, constructing Locations
		int x = 0;
		for(String row: rows){
			int y = 0;
			char[] rowChars = row.toCharArray();
			for(char c: rowChars){
				Terrain t = Terrain.forSymbol(c);
				if ( t == null ){
					throw new IllegalArgumentException("Invalid map format");
				}
				map[x][y] = new Location(x, y, t);
				y++;
			}
			x++;
		}
		return map;
	}
}
