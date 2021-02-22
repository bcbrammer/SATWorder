import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Adj extends Word {
	
	private static int numberOfAdjs;
	private static boolean adjDataLoaded = false;
	private static ArrayList<List<String>> adjData = new ArrayList<List<String>>();
	
	public Adj(int seed) {
		this.id = Integer.parseInt(adjData.get(seed).get(0));
		this.word = adjData.get(seed).get(1);
		this.definition = adjData.get(seed).get(2);
	}
	
	public static int getNumberOfAdjs() {
		return numberOfAdjs;
	}
	public static boolean isAdjDataLoaded() {
		return adjDataLoaded;
	}
	public static ArrayList<List<String>> getAdjData() {
		return adjData;
	}
	
	public static void initializeAdjData() {
		if(!adjDataLoaded) {
			List<String> rawLines= new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("adjs.csv"));
				String line = br.readLine();
				while (line != null) {
					rawLines.add(line);
					line = br.readLine();
				}
				br.close();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
			for (String it : rawLines) {
				adjData.add(parseLineData(it));
			}
			numberOfAdjs = adjData.size();
		}
		System.out.println("initializeAdjData()");
	}
}