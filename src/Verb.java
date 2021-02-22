import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Verb extends Word {
	
	private static int numberOfVerbs;
	private static boolean verbDataLoaded = false;
	private static ArrayList<List<String>> verbData = new ArrayList<List<String>>();
	
	public Verb(int seed) {
		this.id = Integer.parseInt(verbData.get(seed).get(0));
		this.word = verbData.get(seed).get(1);
		this.definition = verbData.get(seed).get(2);
	}
	
	public static int getNumberOfVerbs() {
		return numberOfVerbs;
	}
	public static boolean isVerbDataLoaded() {
		return verbDataLoaded;
	}
	public static ArrayList<List<String>> getVerbData() {
		return verbData;
	}
	
	public static void initializeVerbData() {
		if(!verbDataLoaded) {
			List<String> rawLines= new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("verbs.csv"));
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
				verbData.add(parseLineData(it));
			}
			numberOfVerbs = verbData.size();
		}
		System.out.println("initializeVerbData()");
	}
}