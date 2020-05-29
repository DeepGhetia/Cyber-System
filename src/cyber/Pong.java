/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;

import java.io.InputStream;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Pong extends Application {
	
	private static final int width = 800;
	private static final int height = 600;
	private static final int PLAYER_HEIGHT = 100;
	private static final int PLAYER_WIDTH = 15;
	private static final double BALL_R = 15;
	private int ballYSpeed = 1;
	private int ballXSpeed = 1;
	private double playerOneYPos = height / 2;
	private double playerTwoYPos = height / 2;
	private double ballXPos = width / 2;
	private double ballYPos = height / 2;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private boolean gameStarted;
	private int playerOneXPos = 0;
	private double playerTwoXPos = width - PLAYER_WIDTH;
        
        
       
      
         
         static Stage nu= new Stage();

  public  Pong() {
       
    }

 

    

        @Override
	public void start(Stage stage) throws Exception {
            nu=stage;
            stage.setTitle("Pong");
           //  stage.initStyle(StageStyle.UTILITY);
		Canvas canvas = new Canvas(width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
               Button backButton = new Button("Go Back");
               backButton.setPrefHeight(40);
               backButton.setDefaultButton(true);
               backButton.setPrefWidth(100);
        
      GridPane.setHalignment(backButton, HPos.LEFT);
      GridPane.setMargin(backButton, new Insets(0, 0,0,0));
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            builtinapps ctc=new builtinapps();
                nu.close();
               
                    try {
                        ctc.start(builtinapps.nu);
                    } catch (Exception ex) {
                    }
                
            }
        });
        
       
        
        
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		canvas.setOnMouseMoved(e ->  playerOneYPos  = e.getY());
		canvas.setOnMouseClicked(e ->  gameStarted = true);
                StackPane root = new StackPane();
                
                root.getChildren().add(canvas);
                root.getChildren().add(backButton);
                  stage.getIcons().add(new Image("file:resources/images/icons8-ping-pong-96.png"));
		stage.setScene(new Scene(root));
		stage.show();
		tl.play();
	}

	private void run(GraphicsContext gc) {
		
                
                gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		if(gameStarted) {
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			if(ballXPos < width - width  / 4) {
				playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
			}  else {
				playerTwoYPos =  ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ?playerTwoYPos += 1: playerTwoYPos - 1;
			}
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
		} else {
			gc.setStroke(Color.YELLOW);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click to Start", width / 2, height / 2);
			ballXPos = width / 2;
			ballYPos = height / 2;
			ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
		}
		if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
		if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreP2++;
			gameStarted = false;
		}
		if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
			scoreP1++;
			gameStarted = false;
		}
		if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) || 
			((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;
		}
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
        public static void main(String[] args) {
            {
                Application.launch(args);
            }
    }

}
