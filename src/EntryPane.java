import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EntryPane extends Parent {
	public EntryPane() {
		Long startupTime = System.currentTimeMillis();
		GridPane nameEntry = new GridPane();
		nameEntry.setPrefSize(800, 600);
		nameEntry.setAlignment(Pos.CENTER);
		nameEntry.setHgap(10);
		nameEntry.setVgap(10);
		nameEntry.setPadding(new Insets(10, 10, 10, 10));
		Text welcome = new Text("Welcome");
		welcome.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		nameEntry.add(welcome, 0, 0);

		Label firstName = new Label("First Name: ");
		nameEntry.add(firstName, 0, 1);

		TextField tfFirstName = new TextField();
		nameEntry.add(tfFirstName, 1, 1);

		Label lastName = new Label("Last Name: ");
		nameEntry.add(lastName, 0, 2);

		TextField tfLastName = new TextField();
		nameEntry.add(tfLastName, 1, 2);
		
		Button btSubmit = new Button("Begin Quiz");
		btSubmit.setOnAction(ev -> {
			String userID = "";
			Random rd = new Random();
			userID += Integer.toString(rd.nextInt(8999) + 1000);
			userID += tfFirstName.getText().substring(0,1);
			userID += tfLastName.getText().substring(0,tfLastName.getText().length());
			System.out.println(userID);
			Quiz q = new Quiz(startupTime, userID);
			ResponseController rc = new ResponseController(q);
			btSubmit.getScene().setRoot(rc.getContent());
		});
		
		HBox hbBtSubmit = new HBox(10);
		hbBtSubmit.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtSubmit.getChildren().add(btSubmit);
		
		nameEntry.add(hbBtSubmit, 1, 4);
		getChildren().add(nameEntry);
	}
}
