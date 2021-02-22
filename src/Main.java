import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;

public class Main extends Application {
	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// load up all the words and their definitions
		Noun.initializeNounData();
		Verb.initializeVerbData();
		Adj.initializeAdjData();
		// used for timing purposes
		// long postInitTime = System.currentTimeMillis();
		
		// load entry controller
		EntryController ec = new EntryController();
		Scene entryScene = new Scene(ec.getContent());
		
		primaryStage.setScene(entryScene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("SAT Worder");
		primaryStage.show();
	}
	
	public static void changeScene(Parent pane) {
		primaryStage.getScene().setRoot(pane);
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage stage) {
		primaryStage = stage;
	}
	
	public static void main(String[] args) {
			Application.launch(args);
	}
}



