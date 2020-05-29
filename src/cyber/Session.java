/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;

/**
 *
 * @author hp
 */




import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class Session extends Application {
 double bill1;
    
    static Stage nu=new Stage();

String text2;
String user2;
String email2;

 


  

    Session(String text1, double bill, String user1, String email1) {
      bill1=bill;
      text2=text1;
      user2=user1;
      email2=email1;
      
      
    }


   
     
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        nu=primaryStage;
    
        primaryStage.setTitle("Session");
       
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
    
        // Create a scene with registration form grid pane as the root node
      
       //  gridPane.add(imageview1,0,4,5,1);
        //  gridPane.add(imageview2,0,3,5,1);
       Scene scene = new Scene(gridPane, 850, 550);
        scene.getStylesheets().add("/CSS/user.css");
        

           
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:resources/images/c.png"));
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints
        

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    
    }

    
       private void addUIControls(GridPane gridPane) throws FileNotFoundException {
      
        Label headerLabel = new Label("                      Checkout Bill");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        gridPane.add(headerLabel, 1,0,2,1);
        headerLabel.setStyle("-fx-text-fill: white");
        GridPane.setHalignment(headerLabel, HPos.CENTER);
       // GridPane.setMargin(headerLabel, new Insets(20, 0,70,70));
     // Add Name Label
        Label nameLabel = new Label("User Name : ");
        gridPane.add(nameLabel, 0,1);
        
        headerLabel.setTextFill(Color.WHITE);
        nameLabel.setTextFill(Color.WHITE);
        
        
        Label name2Label = new Label(user2+"          Email :  "+email2);
        gridPane.add(name2Label, 1,1);
        name2Label.setTextFill(Color.WHITE);
        
        
      
        
       Label timeLabel = new Label("Time spent  : ");
        gridPane.add(timeLabel, 0,2);
        timeLabel.setTextFill(Color.WHITE);
        String line;
        line=""+text2;
        
       
        
        Label runningLabel = new Label(line);
        gridPane.add(runningLabel, 1,2);
        Label billLabel = new Label("Bill Amount : ");
        gridPane.add(billLabel, 0,3);
        Label amountLabel = new Label("Rs. "+bill1);
        gridPane.add(amountLabel, 1,3);
        Label messageLabel = new Label("Thank You, Visit Again");
        gridPane.add(messageLabel, 1,4);
        runningLabel.setTextFill(Color.WHITE);
        billLabel.setTextFill(Color.WHITE);
        amountLabel.setTextFill(Color.WHITE);
        messageLabel.setTextFill(Color.WHITE);
      
        Button exitButton = new Button("Exit");
        exitButton.setPrefHeight(40);
        exitButton.setDefaultButton(true);
        exitButton.setPrefWidth(130);
        gridPane.add(exitButton, 0, 6, 5, 1);
        GridPane.setHalignment(exitButton, HPos.CENTER);
        GridPane.setMargin(exitButton, new Insets(20,-500,70,0));
         
        Button pongb = new Button("Feedback");
        pongb.setPrefHeight(40);
        pongb.setDefaultButton(true);
        pongb.setPrefWidth(130);
        gridPane.add(pongb, 0, 6, 5, 1);
        GridPane.setHalignment(pongb, HPos.CENTER);
        GridPane.setMargin(pongb, new Insets(20, 600,70,0));
        
   
         exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nu.close();
            User ctc = new User();

                try {

                    ctc.start(User.nu);
                } catch (Exception ex) {
                                 
                }
                
            }       
        });
         
          pongb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nu.close();
          Feedback ctc = new Feedback();

                try {

                    ctc.start(Feedback.nu);
                } catch (Exception ex) {
                                 
                }
                
            }
           
     
         
        });
         
       
    }
   
    public static void main(String[] args) {
        launch(args);
    }

  
    
}
