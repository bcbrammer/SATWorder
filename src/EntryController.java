import javafx.scene.Parent;

public class EntryController implements SceneController {
	private EntryPane root;
	
	public EntryController() {
		this.root = new EntryPane();
	}
	
	@Override
	public Parent getContent() {
		return root;
	}
}
