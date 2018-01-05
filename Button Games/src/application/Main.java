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
	static int score = 0;
	boolean scoring = true;
	long timeStep; 
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Button Games");
			Button button = new Button();
			Button button1 = new Button();
			
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
			
			timeStep = System.nanoTime() + 10000000000L;
			AnimationTimer timer =  new AnimationTimer()
			{
				public void handle(long now)
				{
					if(now>timeStep)
					{
						scoring = !scoring;
						button.setText("Don't Click");
						button.setDisable(true);
					}
					else
					{
						button.setText("Click Me!");
					}
					
				}
			};
			
			button1.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					timer.start();
					button1.setDisable(true);
				}
			});
			
			StackPane sp = new StackPane();
			HBox hbox = new HBox();
			sp.getChildren().add(button);
			sp.getChildren().add(button1);
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
