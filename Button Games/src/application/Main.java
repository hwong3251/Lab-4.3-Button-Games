package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Button Games");
			StackPane sp = new StackPane();
			
			Label label = new Label("Click");
			Button button = new Button("Click Me");
			
			button.setOnAction(value ->
			{
				label.setText("Clicked!");
			});
			
			HBox h = new HBox(button, label);
			
			sp.getChildren().add(h);
			Scene scene = new Scene(sp, 400,400);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
