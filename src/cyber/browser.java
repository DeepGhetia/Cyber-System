/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;

import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
public class browser extends Application {
   static Stage nu=new Stage();
 
   public  browser() {
       
    }
  
   @Override
   public void start(final Stage stage) {
       nu=stage;
       stage.setTitle("Cyber Cafe Browser");
    
       TextField addressBar = new TextField();
       addressBar.setText("https://google.com");
       Button goButton = new Button("Go!");
       Button goBackButton = new Button("Go Back");
      
       Label stateLabel = new Label();
 
       stateLabel.setTextFill(Color.BLACK);
       ProgressBar progressBar = new ProgressBar();
 
       final WebView browser = new WebView();
       final WebEngine webEngine = browser.getEngine();
 
       // A Worker load the page
       Worker<Void> worker = webEngine.getLoadWorker();
 
        // Listening to the status of worker
       worker.stateProperty().addListener(new ChangeListener<State>() {
 
           @Override
           public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
               stateLabel.setText("Loading state: " + newValue.toString());
               if (newValue == Worker.State.SUCCEEDED) {
                   stage.setTitle(webEngine.getLocation());
                   stateLabel.setText("Done.");
               }
           }
       });
 
       // Bind the progress property of ProgressBar
       // with progress property of Worker
       progressBar.progressProperty().bind(worker.progressProperty());
       addressBar.setOnKeyPressed((KeyEvent e) -> {
           if(e.getCode()==e.getCode().ENTER){
           String url = addressBar.getText();
               // Load the page.
               webEngine.load(url);
           }
       });
 
       goButton.setOnAction(new EventHandler<ActionEvent>() {
 
           @Override
           public void handle(ActionEvent event) {
               String url = addressBar.getText();
               // Load the page.
               webEngine.load(url);
           }
       });
     goBackButton.setOnAction(new EventHandler<ActionEvent>() {
 
          @Override
       public void handle(ActionEvent event) {
               stage.close();
             builtinapps ctc = new builtinapps();
             
                try {
                    // Then call its start() method in the following way:

                    ctc.start(builtinapps.nu);
                } catch (Exception ex) {
               
              }
          }
      });
       
 
       VBox root = new VBox();
      root.getChildren().addAll(addressBar, goButton,goBackButton, stateLabel, progressBar, browser);
 
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.setWidth(850);
       stage.setHeight(550);
         //stage.initStyle(StageStyle.UTILITY);
       stage.show();
    stage.getIcons().add(new Image("file:resources/images/icons8-java-96.png"));
   }
 
   public static void main(String[] args) {
       launch(args);
   }
 
}