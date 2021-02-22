/* 
--module-path "D:\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.control.*;


public class MyJavaFX extends Application {
	@Override // Override the start method in the APplication class
	public void start(Stage primaryStage) {
		// create a scene and place a button in the scene
		StackPane pane = new StackPane();
		Button btOK = new Button("Wrong Answer");
		btOK.setStyle("-fx-border-color: red;");
		btOK.setRotate(20);
		btOK.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC,20));
		pane.getChildren().add(btOK);
		
		pane.setRotate(10);
		pane.setStyle("-fx-border-color: black; -fx-background-color: lightgray;");
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("wrong answer demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
*/