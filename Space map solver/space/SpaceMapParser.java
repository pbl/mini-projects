package space;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class SpaceMapParser{

	private SpaceMapParser(){}

	public static String[][] parseMap(String fileName) throws IOException{
		BufferedReader bufReader = new BufferedReader(new FileReader((fileName)));
		String line = bufReader.readLine();
		int n = line.length();
		String[][] map = new String[n][n];
		int row = 0;
		while(line != null){
			char[] spaceRow = line.toCharArray();
			for(int col=0; col<spaceRow.length; col++){
				map[row][col] = String.valueOf(spaceRow[col]);
			}
			row++;
			line = bufReader.readLine();
		}
		return map;
	}
}
