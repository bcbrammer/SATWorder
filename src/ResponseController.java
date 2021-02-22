import javafx.scene.Parent;

public class ResponseController implements SceneController {
	private final ResponsePane root;
	
	public ResponseController(Quiz quiz) {
		root = new ResponsePane(quiz);
	}
	
	@Override
	public Parent getContent() {
		return root;
	}
}
