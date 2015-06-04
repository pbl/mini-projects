package space;

import java.io.IOException;
import java.util.LinkedList;

public class RouteFinder{
	private static final int ROW_POS = 0;
	private static final int COL_POS = 1;

	//If no solution was found null is returned 
	public static String[][] findRoute(String[][] map){
		String[][] copyOfMap = copyMap(map);
		map = markIllegalSpace(map);
		// Space.printMap(map);
		LinkedList<LinkedList<Integer[]>> oldSolutionChains = new LinkedList<LinkedList<Integer[]>>();

		LinkedList<Integer[]> startChain = new LinkedList<Integer[]>();
		startChain.add(addSpace(0, 0));
		oldSolutionChains.add(startChain);
		while(!oldSolutionChains.isEmpty()){
 			LinkedList<LinkedList<Integer[]>> newSolutionChains = new LinkedList<LinkedList<Integer[]>>();
			
			for(LinkedList<Integer[]> chain : oldSolutionChains){
				Integer[] coordinates = chain.getLast();
				for(int row=getStart(coordinates[ROW_POS]); row<getEnd(coordinates[ROW_POS], map.length); row++){
					for(int col=getStart(coordinates[COL_POS]); col<getEnd(coordinates[COL_POS], map.length); col++){
						if(!map[row][col].equals(Space.ILLEGAL) && !map[row][col].equals(Space.START)){
							@SuppressWarnings("unchecked")
							LinkedList<Integer[]> newChain = (LinkedList<Integer[]>) chain.clone();
							newChain.add(addSpace(row, col));
							newSolutionChains.add(newChain);
							if(map[row][col].equals(Space.END)){
								map = markRoute(copyOfMap, newChain);
								return map;
							} else{
								map[row][col] = Space.ILLEGAL;
							}
						}
					}
				}
			}
			oldSolutionChains = newSolutionChains;	
		}
		return null;
	 }

	public static String[][] findRouteWithTree(String[][] map){
		String[][] copyOfMap = copyMap(map);
		map = markIllegalSpace(map);
		Integer[] startCoordinates = addSpace(0, 0);
		Tree<Integer[]> root = new Tree<Integer[]>(startCoordinates);
		System.out.println(root);
		// Pair test = new Pair();

		return null;
	}

	public static void printChain(LinkedList<Integer[]> chain){
		for(Integer[] coor : chain){
			System.out.println(coor[ROW_POS] + ", " + coor[COL_POS]);
		}
	}
	
	public static String[][] copyMap(String[][] map){
		String[][] copyOfMap = new String[map.length][];
		for(int i = 0; i < map.length; i++){
		  String[] aMatrix = map[i];
		  int   aLength = aMatrix.length;
		  copyOfMap[i] = new String[aLength];
		  System.arraycopy(aMatrix, 0, copyOfMap[i], 0, aLength);
		}
		return copyOfMap;
	}
	
	

	public static boolean routeExists(String[][] map){
		String[][] copyOfMap = copyMap(map);
		return findRoute(copyOfMap) != null;
	}
	
	private static String[][] markRoute(String[][] map, LinkedList<Integer[]> chain){
		for(Integer[] coordinates : chain){
			map[coordinates[ROW_POS]][coordinates[COL_POS]] = Space.ROUTE;
		}
		map[chain.getFirst()[ROW_POS]][chain.getFirst()[COL_POS]] = Space.START;
		map[chain.getLast()[ROW_POS]][chain.getLast()[COL_POS]] = Space.END;
		return map;
	}

	private static Integer[] addSpace(int row, int col){
		Integer[] coordinates = new Integer[2];
		coordinates[ROW_POS] = row;
		coordinates[COL_POS] = col;
		return coordinates;
	}

	private static String[][] markIllegalSpace(String[][] map){
		for(int row=0; row<map.length; row++) {
			for (int col=0; col<map[0].length; col++) {
				if(map[row][col].equals(Space.ASTERIOD)){
					map[row][col] = Space.ILLEGAL;
				} else if(map[row][col].equals(Space.GRAVITY)){
					//mark the space and all adjacent spaces as illegal
					for(int i=getStart(row); i<getEnd(row, map.length); i++){
						for(int k=getStart(col); k<getEnd(col, map.length); k++){
							map[i][k] = Space.ILLEGAL;
						}
					}
				}
			}
		}
		return map;
	}

	private static int getStart(int pos){
		if(pos-1 < 0){
			return pos;
		}
		return 	pos-1;
	}

	private static int getEnd(int pos, int mapLength){
		if(pos+2 > mapLength){
			return pos+1;
		}
		return pos+2;
	}

	public static void main(String[] args){
//		System.out.println(System.getProperty("user.dir")+"/bin/maps/map");
		System.out.println(System.getProperty("user.dir")+"/map");
// 		try{
// 			System.out.println(System.getProperty("user.dir")+"/map");
// 			String[][] map = SpaceMapParser.parseMap("./map");
// //			Space.printMap(map);
// 			// System.out.println(RouteFinder.routeExists(map));
// //			Space.printMap(RouteFinder.findRoute(map));

// 			// System.out.println(RouteFinder.findRouteWithTree(map));

// 		} catch(IOException e){
// 			e.printStackTrace();
// 		}

	}


}
