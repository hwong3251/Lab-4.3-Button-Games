package application;

import javafx.animation.AnimationTimer;
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
	int score = 0;
	boolean scoring = false;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Button Games");
			Button button = new Button("Click Me");
			
			button.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					if(scoring)
					{
						score++;
					}
					
				}
			});
			
			long timeStep = System.nanoTime() + 1000000001;
			AnimationTimer timer =  new AnimationTimer()
			{
				public void handle(long now)
				{
					if(now>timeStep)
					{
						timeStep = now + 1000000001;
					}
				}
			};
			
			StackPane sp = new StackPane();
			HBox hbox = new HBox();
			sp.getChildren().add(button);
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
