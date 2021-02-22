import java.util.Collections;

public class AdjQuestion extends Question {

	public AdjQuestion() {
		// empty constructor
	}
	
	public AdjQuestion(int[] adjSeeds) {
		this.seeds = adjSeeds;
		generateWords();
		actualWord = words.get(0);
		Collections.shuffle(words);
		populateResponses();
	}

	@Override
	protected void generateWords() {
		for(int i = 0; i < 4; i++) {
			words.add(new Adj(seeds[i]));
		}
	}
}
