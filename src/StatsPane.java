import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatsPane extends Parent {
	private VBox vb;
	private Quiz resultQuiz;
	
	public StatsPane(Quiz quiz) {
		this.vb = new VBox();
		this.resultQuiz = quiz;
		vb.setPrefSize(800,600);
		vb.setAlignment(Pos.CENTER);
		Label scoreLabel = new Label(Integer.toString(resultQuiz.getScore()) + " / 15");
		scoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
		scoreLabel.setTextFill(Color.RED);
		vb.getChildren().add(scoreLabel);
		
		Label toStudy = new Label("Words to Study: ");
		toStudy.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		vb.getChildren().add(toStudy);
		String mistakes = "";
		for(Question q: resultQuiz.getQuestions()) {
			if(!q.isCorrect()) {
				mistakes += q.getTargetWord() + "\n";
			}
		}
		Text t = new Text(mistakes);
		t.setFont(Font.font("Arial",12));
		vb.getChildren().add(t);
		
		Button btAgain = new Button("AGAIN?");
		btAgain.setOnAction( e-> {
			EntryController ec = new EntryController();
			btAgain.getScene().setRoot(ec.getContent());
		});
		getChildren().add(vb);
	}
}
