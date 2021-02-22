import javafx.scene.Parent;

public class StatsController implements SceneController {
	private StatsPane root;
	public StatsController(Quiz q) {
		this.root = new StatsPane(q);
	}
	@Override
	public Parent getContent() {
		return root;
	}
}
