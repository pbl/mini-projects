package space;

public final class Space{
	public static final String ILLEGAL = "X";
	public static final String ROUTE = "R";
	public static final String START = "S";
	public static final String EMPTY = ".";
	public static final String ASTERIOD = "A";
	public static final String GRAVITY = "G";
	public static final String END = "E";

	public static void printMap(String[][] map){
		for( String[] rows : map) {
			for (String space : rows ) {
				System.out.print(space);
			}
			System.out.println();
		}
	}
	
	public static String getTestMapDir(){
		return System.getProperty("user.dir")+"/src/maps/";
	}
}