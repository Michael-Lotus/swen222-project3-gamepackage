package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.item.Chest;
import model.item.Door;
import model.item.Gold;
import model.item.Item;

/**
 * 
 * @author Michael 300273397
 */
public class LevelGenerator {


	public static Cell[][] parseMap(String filename) {
		Cell[][] map;
		// First read in the file and store as a List of rows
		List<String> rows = new ArrayList<>();
		try{		
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNextLine()){
				rows.add(sc.nextLine());
			}
			sc.close();
		}catch (Exception e){
			throw new RuntimeException("ERROR PARSING MAP", e);
		}
		// Now we can calculate map size and construct the array
		map = new Cell[rows.size()][rows.get(0).length()];

		// Then loop through the List, constructing Locations
		int x = 0;
		for(String row: rows){
			int y = 0;
			char[] rowChars = row.toCharArray();

			for(char c: rowChars){
				//System.out.println("Parsing: "+c+", x="+x+", y="+y);
				Terrain terrain = Terrain.forSymbol(c);
				map[x][y] = new Cell(x, y, terrain);
				Item item = forSymbol(c);
				if (item != null) { 
					map[x][y].addItem(item); 
					System.out.println(item.title()+" added at location "+x+", "+y); 
				}
				y++;
			}
			x++;
		}
		return map;
	}


	private static Item forSymbol(char c) {
		switch (c) {
		case '/': return new Door();
		case '$': return new Gold(10);
		case 'X': return new Chest();
		default: return null;
		}
	}

}
