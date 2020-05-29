/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber;



import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import static cyber.Feedback.nu;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author Adars
 */
public class FeedbackController implements Initializable {

    @FXML
    private JFXRadioButton visit_yes;
    @FXML
    private ToggleGroup visit_group;
    @FXML
    private JFXRadioButton visit_no;
    @FXML
    private JFXRadioButton unlikely;
    @FXML
    private ToggleGroup return_likelihood;
    @FXML
    private JFXRadioButton slightly_likely;
    @FXML
    private JFXRadioButton moderately_likely;
    @FXML
    private JFXRadioButton very_likely;
    @FXML
    private JFXRadioButton extremely_likely;
    @FXML
    private JFXTextArea feedback_field;
    
     String uname=User.name;
   // int phone2=MainController.phone2;
    String uphone=User.phone;
   // int phone1=Integer.parseInt(uphone);
  Double phone1=Double.valueOf(uphone);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    public void feedback_received(ActionEvent fr) throws IOException, SQLException, Exception{
  nu.setFullScreenExitHint("Please give your valuable feedback");


      String feedback=  feedback_field.getText();
       
         RadioButton selectedRadioButton_visit = (RadioButton) visit_group.getSelectedToggle();
    String visit_toggle=selectedRadioButton_visit.getText();
    RadioButton selectedRadioButton_return = (RadioButton) return_likelihood.getSelectedToggle();
    String return_toggle=selectedRadioButton_return.getText();
        System.out.println("Visit : "+visit_toggle);
            System.out.println("Return : "+return_toggle);
            
             try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                String statem="select user_id from users where user_phoneno=?";
                PreparedStatement xyz=abc.prepareStatement(statem);
               // xyz.setString(1, user_name);
               // int phoneno1=Integer.valueOf(phone_number);
                xyz.setDouble(1, phone1);
                ResultSet rs =xyz.executeQuery();
                                String user_id="";
                                while(rs.next())
                                {
                         user_id=rs.getString(1);
                                }
               
                 System.out.println(user_id);
                     System.out.println(uname);
         
               xyz.executeUpdate("insert into feedback (USER_ID,user_name,first_visit,likelihood_to_return,feedback_received) values('"+user_id+"','"+uname+"','"+visit_toggle+"','"+return_toggle+"','"+feedback+"')");
    }
           catch(ClassNotFoundException | SQLException ce)
                   {
                       System.out.println("Exception!!!!!!");
                   }
             nu.close();
 
           
               User ctc = new User();

                try {

                    ctc.start(User.nu);
                } catch (Exception ex) {
                                 
                }
               
    }

    
}
