/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;


public class builtinapps extends Application {

    
    static Stage nu=new Stage();

  

   public builtinapps() {
      
    }

 
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        nu=primaryStage;
    
        primaryStage.setTitle("Built in application");
       
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
    
  
       Scene scene = new Scene(gridPane, 800, 500);
        scene.getStylesheets().add("/CSS/user.css");
        

             primaryStage.resizableProperty().setValue(Boolean.FALSE);
primaryStage.getIcons().add(new Image("file:resources/images/c.png"));
        primaryStage.setScene(scene);
 
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
      
        Label headerLabel = new Label("Applications");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        gridPane.add(headerLabel, 0,0,2,1);
        headerLabel.setStyle("-fx-text-fill: white");
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,180,270));
     
      Image image=new Image(new FileInputStream("C:\\Users\\hp\\Documents\\NetBeansProjects\\cyber\\src\\images\\icons8-java-96.png"));
        ImageView imageview=new ImageView(image);
        imageview.setFitHeight(-200);
        imageview.setFitWidth(-200);
        imageview.setPreserveRatio(true);
        gridPane.add(imageview,0,3,1,2);
       
        
        Button pButton = new Button("Pong ");
        pButton.setPrefHeight(40);
        pButton.setDefaultButton(true);
        pButton.setPrefWidth(120);
        gridPane.add(pButton, 0, 6, 5, 1);
        GridPane.setHalignment(pButton, HPos.CENTER);
        GridPane.setMargin(pButton, new Insets(20, 0,60,0));
        
  /*      Image image1=new Image(new FileInputStream("C:\\Users\\hp\\Documents\\NetBeansProjects\\cyber\\src\\images\\icons8-ping-pong-96.png"));
        ImageView imageview1=new ImageView(image1);
        imageview1.setFitHeight(-500);
        imageview1.setFitWidth(50);
        imageview1.setPreserveRatio(true);
        gridPane.add(imageview1,0,3,2,2);
    */    
        Button tictacButton = new Button("TicTacToe");
        tictacButton.setPrefHeight(40);
        tictacButton.setDefaultButton(true);
        tictacButton.setPrefWidth(120);
        gridPane.add(tictacButton, 0, 6, 5, 1);
        GridPane.setHalignment(tictacButton, HPos.CENTER);
        GridPane.setMargin(tictacButton, new Insets(20,-600,70,0));
        
        
 
        
   /*     Image image2=new Image(new FileInputStream("C:\\Users\\hp\\Documents\\NetBeansProjects\\cyber\\src\\images\\tic-tac-toe (1).png"));
        ImageView imageview2=new ImageView(image2);
        imageview2.setFitHeight(-500);
        imageview2.setFitWidth(60);
        imageview2.setPreserveRatio(true);
        gridPane.add(imageview2,0,3,2,2);
     */   
        Button pb = new Button("Browser");
        pb.setPrefHeight(40);
        pb.setDefaultButton(true);
        pb.setPrefWidth(120);
        gridPane.add(pb, 0, 6, 5, 1);
        GridPane.setHalignment(pb, HPos.CENTER);
        GridPane.setMargin(pb, new Insets(20, 600,70,0));
        
        pButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
    
            Pong ctc1 = new Pong();
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc1.start(Pong.nu);
                } catch (Exception ex) {
               
              }
                
            }
        });
        
  


        pb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
               browser ctc = new browser();
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc.start(browser.nu);
                } catch (Exception ex) {
               
              }
            }
        });
        
 
        
        
         tictacButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        
              tictactoe ctc = new tictactoe();
             
            nu.close();
                try {
                    // Then call its start() method in the following way:

                    ctc.start(tictactoe.nu);
                } catch (Exception ex) {
               
              }
            }
        });
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

  
    
}