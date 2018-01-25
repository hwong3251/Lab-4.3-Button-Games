package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Hoi Lam Wong
//Leon You 
//Period 6-7 
//Mr. Levin CSA

public class Main extends Application {
	static int score = 0;
	boolean scoring = true;
	long timeStep; 
	int t = 0;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Button Games");
			Button button = new Button("CLICK");
				button.setTranslateX(60);
				button.setDisable(true);
			Button button1 = new Button("START");
				button1.setTranslateX(-60);
			Label lb = new Label("Score: ");
				lb.setTranslateY(-50);
			Text txt = new Text("The goal of the game is to click the button \n"
						+ "as many times as possible in 10 seconds.");
				txt.setTranslateY(-100);
			Label lb1 = new Label("Time: ");
				lb1.setTranslateY(-35);
			
//button interactions--------------------------------------------------------------------------------------//
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
			
			button1.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent event)
				{
					button1.setDisable(true);
					new AnimationTimer()
					{
						long timeStep = System.nanoTime()+10000000000L;
						long timestop = System.currentTimeMillis() + 10000L;
						public void handle(long now)
						{
							long t = System.currentTimeMillis();
							if(now > timeStep)
							{
								button.setDisable(true);
								lb1.setText("Time: 0" );
							}
							else
							{
								t = 1+((timestop - t)/1000);
								button.setDisable(false);
								lb.setText("Score: " + Integer.toString(score));
								lb1.setText("Time: " + Long.toString(t));
							}
						}
					}.start();
				}
			});
			
//LayOut------------------------------------------------------------------------------------------------//
			StackPane sp = new StackPane();

			sp.getChildren().add(button);
			sp.getChildren().add(button1);
			sp.getChildren().add(txt);
			sp.getChildren().add(lb);
			sp.getChildren().add(lb1);
			Scene scene = new Scene(sp, 250,250);
			
			primaryStage.setScene(scene);
			primaryStage.show();
//CSV--------------------------------------------------------------------------------------------------//
			PrintWriter pw = null;
			try 
			{
				pw = new PrintWriter(new File("results.csv"));
			}
			catch(FileNotFoundException e)
			{
				System.err.println(e);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Name,High Score\n");
			pw.write(sb.toString());
			pw.close();		
//--------------------------------------------------------------------------------------------------------//
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		launch(args);
	}
}
