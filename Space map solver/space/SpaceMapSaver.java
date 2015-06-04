package space;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SpaceMapSaver{

	private SpaceMapSaver(){}

	public static void saveMap(String fileName, String[][] map){
		File file = new File(Space.getTestMapDir() + fileName);
		try{
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			for(String[] rows : map) {
				String line = "";
				for (String row : rows ) {
					line += row; 
				}
				writer.println(line);			
			}
			writer.close();
		} catch(FileNotFoundException | UnsupportedEncodingException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
