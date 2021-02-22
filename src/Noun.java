import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Noun extends Word {
	
	private static int numberOfNouns;
	private static boolean nounDataLoaded = false;
	private static ArrayList<List<String>> nounData = new ArrayList<List<String>>();
	
	public Noun(int seed) {
		this.id = Integer.parseInt(nounData.get(seed).get(0));
		this.word = nounData.get(seed).get(1);
		this.definition = nounData.get(seed).get(2);;
	}
	
	public static int getNumberOfNouns() {
		return numberOfNouns;
	}
	
	public static boolean isNounDataLoaded() {
		return nounDataLoaded;
	}
	public static ArrayList<List<String>> getNounData() {
		return nounData;
	}
	
	public static void initializeNounData() {
		if(!nounDataLoaded) {
			List<String> rawLines= new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(new FileReader("nouns.csv"));
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
				nounData.add(parseLineData(it));
			}
			numberOfNouns = nounData.size();
		}
		System.out.println("initializeNounData()");
	}
}