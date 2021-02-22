import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Quiz {
	protected int seed;
	protected String ownerID;
	protected ArrayList<Question> questions = new ArrayList<Question>();
	protected boolean complete;
	protected int score;
	protected double grade;
	
	protected Random rng = new Random();
	
	// to be implemented
	protected long timeLimit;
	protected long timeTaken;
	protected Date dateTaken;

	public Quiz(long systemSeed, String ownerID) {
		// generate unique quiz seed
		double ownerIDdigits = Double.parseDouble(ownerID.substring(0,4));
		
		// for example:
		// String oID = "1234bbrammer";
		// double oIDd = 1234 (which is then squared)
		// long sysSeed = 1608355582294L;
		// gives int seed = 1056254
		
		this.seed = (int)(systemSeed/Math.pow(ownerIDdigits, 2));
		this.ownerID = ownerID;
		System.out.println("quiz seed = " + seed);
		this.rng = new Random(seed);
		
		generateQuestions();
		Collections.shuffle(questions);
		this.timeLimit = 0L; // 15 minutes
		this.complete = false;
		this.score = 0;
	}
	
	private void generateQuestions() {
		// generate 5 noun questions
		for(int i = 0; i < 5; i++) {
			questions.add(new NounQuestion(generateWordSeeds(Noun.getNumberOfNouns())));
		}
		// generate 5 verb questions
		for(int i = 0; i < 5; i++) {
			questions.add(new VerbQuestion(generateWordSeeds(Verb.getNumberOfVerbs())));
		}
		// generate 5 adj questions
		for(int i = 0; i < 5; i++) {
			questions.add(new AdjQuestion(generateWordSeeds(Adj.getNumberOfAdjs())));
		}
		Collections.shuffle(questions);
	}
	
	protected int[] generateWordSeeds(int numberOfWords) {
		int[] seeds = new int[4];
		for (int i = 0; i < 4; i++) {
			seeds[i] = rng.nextInt(numberOfWords);
		}
		return seeds;
	}
	public Question getQuestion(int questionNumber) {
		try {
			return questions.get(questionNumber);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean status) {
		this.complete = status;
	}
	
	public int getScore() {
		return score;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public void calcScore() {
		this.score = 0;
		for(Question q : questions) {
			if (q.isCorrect()) {
				this.score += 1;
			}
			this.grade = score / questions.size();
		}
	}
}
