import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.*;

public class ResponsePane extends Parent {
		private Quiz currentQuiz;
		private Question currentQuestion;
		private int currentQuestionNumber;
		
		private List<Button> btResponses = new ArrayList<Button>();
		private Label targetWordDisplay;
		
		private BorderPane mainPane;
		private GridPane responseGrid;
		
		public ResponsePane(Quiz currentQuiz) {
			this.currentQuiz = currentQuiz;
			this.currentQuestion = currentQuiz.getQuestion(0);
			this.currentQuestionNumber = 0;
			
			this.mainPane = new BorderPane();
			this.mainPane.setPrefSize(800,600);
			
			createTargetWordDisplay();
			updateTargetWordDisplay();
			HBox hb = new HBox(10);
			hb.setAlignment(Pos.CENTER);
			hb.getChildren().add(targetWordDisplay);
			mainPane.setTop(hb);
			createResponseGrid();
			createResponseButtons();
			updateResponseButtons();
			mainPane.setCenter(responseGrid);
			getChildren().add(mainPane);
		}
		
		private void createTargetWordDisplay() {
			targetWordDisplay = new Label();
			targetWordDisplay.setText(currentQuestion.getTargetWord().toUpperCase());
			targetWordDisplay.setFont(Font.font("Arial", FontWeight.BOLD, 36));
			targetWordDisplay.setAlignment(Pos.CENTER);
		}
		
		private void updateResponsePane() {
			updateTargetWordDisplay();
			updateResponseButtons();
		}
		private void updateTargetWordDisplay() {
			targetWordDisplay.setText(currentQuestion.getTargetWord());
		}
		
		private void updateResponseButtons() {
			for(int i = 0; i < 4; i++) {
				btResponses.get(i).setText(currentQuestion.getResponse(i));
			}
		}
		private void nextQuestion() {
			if(currentQuestionNumber >= 14) {
				currentQuiz.setComplete(true);
				StatsController stats = new StatsController(currentQuiz);
				mainPane.getScene().setRoot(stats.getContent());
			}
			if(!currentQuiz.isComplete()) {
				currentQuestionNumber++;
				currentQuestion = currentQuiz.getQuestion(currentQuestionNumber);
				updateResponsePane();
			}
		}
		
		private void createResponseGrid() {
			responseGrid = new GridPane();
			responseGrid.setMinSize(640, 480);
			responseGrid.setAlignment(Pos.CENTER);
			responseGrid.setPadding(new Insets(10));
			int numberOfColumns = 2;
			int numberOfRows = 2;
			for (int row = 0; row < numberOfRows; row++) {
				RowConstraints rc = new RowConstraints();
				rc.setFillHeight(true);
				rc.setVgrow(Priority.ALWAYS);
				responseGrid.getRowConstraints().add(rc);
			}
			for (int col = 0; col < numberOfColumns; col++) {
				ColumnConstraints cc = new ColumnConstraints();
				cc.setFillWidth(true);
				cc.setHgrow(Priority.ALWAYS);
				responseGrid.getColumnConstraints().add(cc);
			}
		}
		
		public void createResponseButtons() {
			for(int i = 0; i < 4; i++) {
				Button btResponse = new Button();
				btResponse.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				btResponse.setPrefSize(300, 220);
				btResponse.setMinSize(300, 220);
				Font buttonFont = Font.font("Arial", 18);
				btResponse.setFont(buttonFont);
				btResponse.setWrapText(true);
				btResponse.setTextAlignment(TextAlignment.CENTER);
				
				btResponse.setOnAction(ev -> {
					if(btResponse.getText().equals(currentQuestion.getCorrectResponse())) {
						System.out.println("correct");
						currentQuiz.getQuestion(currentQuestionNumber).setCorrect(true);
					}
					else {
						System.out.println("wrong");
						currentQuiz.getQuestion(currentQuestionNumber).setCorrect(false);
					}
					nextQuestion();
				});
				btResponses.add(btResponse);
			}
			int i = 0;
			for (int col = 0; col < 2; col++) {
				for (int row = 0; row < 2; row++) {
					responseGrid.add(btResponses.get(i), col, row);
					i++;
				}
			}
		}
		
		protected void setCurrentQuiz(Quiz currentQuiz) {
			this.currentQuiz = currentQuiz;
		}
		protected void setCurrentQuestion(Question question) {
			currentQuestion = question;
		}
	}