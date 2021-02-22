import java.util.Collections;

public class VerbQuestion extends Question {

	public VerbQuestion() {
		// empty constructor
	}
	
	public VerbQuestion(int[] verbSeeds) {
		this.seeds = verbSeeds;
		generateWords();
		actualWord = words.get(0);
		Collections.shuffle(words);
		populateResponses();
	}

	@Override
	protected void generateWords() {
		for(int i = 0; i < 4; i++) {
			words.add(new Verb(seeds[i]));
		}
	}
}
