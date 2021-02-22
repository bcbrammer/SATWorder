import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Question {
	
	protected int[] seeds;
	protected ArrayList<Word> words = new ArrayList<Word>();
	protected Word actualWord;
	protected List<String> responses = new ArrayList<String>();
	protected String targetWord;
	protected String correctResponse;
	protected boolean correct;
	
	protected long timeTaken;
	
	public Question() {
		// empty constructor
	}
	
	public Question(int[] wordSeeds) {
		this.seeds = wordSeeds;
		actualWord = words.get(0);
		generateWords();
		populateResponses();
	}
	
	protected abstract void generateWords();
	
	protected void populateResponses() {
		targetWord = actualWord.getWord();
		correctResponse = actualWord.getDefinition();
		for (int i = 0; i < 4; i++) {
			responses.add(words.get(i).getDefinition());
		}
		Collections.shuffle(responses);
	}
	
	public String getResponse(int responseNumber) {
		return responses.get(responseNumber);
	}
	public List<String> getResponses() {
		return responses;
	}
	
	public String getCorrectResponse() {
		return correctResponse;
	}
	public String getTargetWord() {
		return targetWord;
	}
	
	public void setCorrect(boolean p) {
		this.correct = p;
	}
	public boolean isCorrect() {
		return correct;
	}
	
	protected void setSeed(int[] mySeeds) {
		this.seeds = mySeeds;
	}
	public int[] getSeed() {
		return seeds;
	}
	
	
	
	
}
