import java.util.ArrayList;

abstract class Word {

	protected int id; // a 4-digit number from 1000 to 9999
	protected String word;
	protected String definition;
	
	// for later implementation
	protected double correctRate;
	protected double encounterRate;
	protected long avgResponseTime;
	
	public Word() {
		// empty constructor, class is abstract
	}
	
	public int getId() {
		return id;
	}
	public String getWord() {
		return word;
	}
	public String getDefinition() {
		return definition;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected void setWord(String word) {
		this.word = word;
	}
	protected void setDefinition(String def) {
		this.definition = def;
	}
	
	static ArrayList<String> parseLineData(String lineData) {
		// save the 3 arguments from a word's lineData into 3 separate strings
		ArrayList<String> tokens = new ArrayList<String>();
		int beginIndex = 0;
		boolean inQuotes = false;
		for (int i = 0; i < lineData.length(); i++) {
			if(lineData.charAt(i) == '\"') {
				inQuotes = !inQuotes;
			}
			else if (lineData.charAt(i) == ',' && !inQuotes) {
				tokens.add(lineData.substring(beginIndex, i));
				beginIndex = i + 1;
			}
		}
		tokens.add(lineData.substring(beginIndex));
		
		// removing quotes from definitions with commas
		if(tokens.get(2).charAt(0) == '"') {
			tokens.set(2, tokens.get(2).substring(1, tokens.get(2).length()-1));
		}
		return tokens;
	}
}
