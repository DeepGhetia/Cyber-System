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


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Feedback extends Application {

    static Stage nu=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage=nu;
        Parent root = FXMLLoader.load(getClass().getResource("Feedback.fxml"));
        Scene scene = new Scene(root);
    nu.setTitle("Feedback");
        primaryStage.getIcons().add(new Image("file:resources/images/c.png"));
       nu.setScene(scene);
        nu.show();
         
    
        //stage.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
