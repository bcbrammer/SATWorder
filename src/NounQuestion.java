import java.util.Collections;

public class NounQuestion extends Question {

	public NounQuestion() {
		// 
	}
	
	public NounQuestion(int[] nounSeeds) {
		this.seeds = nounSeeds;
		generateWords();
		actualWord = words.get(0);
		Collections.shuffle(words);
		populateResponses();
	}

	@Override
	protected void generateWords() {
		for(int i = 0; i < 4; i++) {
			words.add(new Noun(seeds[i]));
		}
	}
}
