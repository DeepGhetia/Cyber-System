/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;



import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.Timeline;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class User extends Application {
    

    static Stage nu=new Stage();
    public static String name;
      public static String phone;
      boolean num=true;
    @Override
    public void start(Stage primaryStage) throws Exception {
        nu=primaryStage;
        primaryStage.setTitle("User Login");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
    
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        scene.getStylesheets().add("/CSS/user.css");
         primaryStage.setScene(scene);
        //  primaryStage.setFullScreen(true);
        
                  primaryStage.setFullScreenExitHint("please fill the deatils");
    //  primaryStage.initStyle(StageStyle.UNDECORATED);
    //   primaryStage.setResizable(false);
      primaryStage.setFullScreen(true);
      //  primaryStage.setAlwaysOnTop(true);
     //  primaryStage.setMaximized(true);
       primaryStage.setOnCloseRequest(e -> e.consume());  
   
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
       primaryStage.getIcons().add(new Image("file:resources/images/c.png"));
         primaryStage.show();
        // scene.setOnKeyPressed((KeyEvent ke) -> {
          //    if (ke.getCode() != KeyCode.ESCAPE) {
          //        ke.consume();
          //        primaryStage.show();
            //  }
            
      //});
     

scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
 public void handle(final KeyEvent keyEvent) {
   if (keyEvent.getCode() == KeyCode.WINDOWS) {
   
    keyEvent.consume();
   }
 }
});
scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
 public void handle(final KeyEvent keyEvent) {
   if (keyEvent.getCode() == KeyCode.ESCAPE) {
   
    keyEvent.consume();
   }
 }
});
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

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("User Login");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        gridPane.add(headerLabel, 0,0,2,1);
        headerLabel.setStyle("-fx-text-fill: white");
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("User Name :");
        gridPane.add(nameLabel, 0,1);
        nameLabel.setStyle("-fx-text-fill: white");

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add phone label
        Label phoneLabel = new Label("Phone No :");
        gridPane.add(phoneLabel, 0, 2);
        phoneLabel.setStyle("-fx-text-fill: white");

        // Add phone Text Field
        TextField phoneField = new TextField();
        phoneField.setPrefHeight(40);
        gridPane.add(phoneField, 1, 2);
        
         // Add phone label
        Label EmailLabel = new Label("Email :");
        gridPane.add(EmailLabel, 0, 3);
        EmailLabel.setStyle("-fx-text-fill: white");

        // Add phone Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 3);

      

        // Add Submit Button
        Button submitButton = new Button("Login");
        submitButton.setFont(Font.font("Arial",12));
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(120);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        
                      
     
        submitButton.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event)  {
        //       String regex = "[7-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
            //   int regex1=Integer.parseInt(regex);
                  String  email1=emailField.getText().toLowerCase();
               String s=phoneField.getText();
          
                     String name1=nameField.getText();
                if(nameField.getText().isEmpty() || phoneField.getText().isEmpty() || emailField.getText().isEmpty() ) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please Fill The Blank Details");
                    return;
                    
                }
               else if(!((name1).matches("[a-zA-Z]+"))){
            showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Invalid Name Format");
              return;
              
          }
      else if(!(isValidd(s))){
   showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Invalid Phone no");
    return;
  }
           
                else if(!(isValid(email1))){
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Invalid Email");
                return;
           }
               
          
              else  
                 showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText());
                 try {
                 name= nameField.getText();
                 phone = phoneField.getText();
                String email = emailField.getText();
                System.out.println(name);
                 System.out.println(phone);
                  System.out.println(email);
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                Statement xyz=abc.createStatement();
                xyz.executeUpdate("insert into users (USER_NAME,USER_PHONENO,USER_EMAIL) values('"+name+"','"+phone+"','"+email+"')");
            } catch (ClassNotFoundException ex) {
                
            } catch (SQLException ex) {
                
            }
              
                
                 
                nu.close();        
                        
                                Timer t = new Timer(nameField.getText(),phoneField.getText(),emailField.getText());
                                try {
                                    t.start(Timer.nu);
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
     public static boolean isValid(String iemail) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (iemail == null) 
            return false; 
        return pat.matcher(iemail).matches(); 
    } 
    public static boolean isValidd(String s) 
   {   
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
       Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
   
        Matcher m = p.matcher(s); 
       return (m.find() && m.group().equals(s)); 
  }

    public static void main(String[] args) {
        launch(args);
    }
}

