package space;

import java.util.Random;
//import java.io.PrintWriter;
//import java.io.FileNotFoundException;
import java.io.*;

//req
/*
 * ska skapa en bana som går att klara
 * ska gå att bestämma storleken på banan, nxm
 * ska spara alla banor i en mapp 
 */


public class MapGenerator{
	private static final int PERCENT_ASTERIOD = 30;
	private static final int PERCENT_GRAVITY = 10;

	private MapGenerator(){
	}

	public static String[][] makeMap(int n){
		String[][] map = new String[n][n];
		
		map = initMap(map);
		Random rand = new Random();
		for(int row=0; row<map.length; row++){
			for(int col=0; col<map[row].length; col++){
				boolean mapCanBeSolved = true;
//				System.out.println("For");
				while(mapCanBeSolved && !(row == 0 && col == 0) && !(row == map.length-1 && col == map[row].length-1)){
					mapCanBeSolved = false;
					int percent = rand.nextInt(100);
					if(percent < PERCENT_ASTERIOD){
						map[row][col] = Space.ASTERIOD;
					} else if(percent < PERCENT_ASTERIOD + PERCENT_GRAVITY){
						map[row][col] = Space.GRAVITY;
					}
					if(!RouteFinder.routeExists(map)){
						mapCanBeSolved = true;
						map[row][col] = Space.EMPTY;
					}
					
//					System.out.println("while");
				}
			}
		}
		return map;
	}
	
	private static String[][] initMap(String[][] map){
		for(int row=0; row<map.length; row++){
			for(int col=0; col<map[row].length; col++){
				map[row][col] = Space.EMPTY;
			}
		}
		map[0][0] = Space.START;
		map[map.length-1][map[map.length-1].length-1] = Space.END;
		return map;
	}

	public static void main(String[] args){
		for(int i=2; i<4; i++){
			String[][] map = MapGenerator.makeMap(i);
			Space.printMap(map);
			SpaceMapSaver.saveMap("map" + i, map);
		}

	}
}
