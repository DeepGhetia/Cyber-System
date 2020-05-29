package cyber;

/**
 *
 * @author hp
 */
import java.io.PrintStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import static javafx.beans.binding.Bindings.and;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;



public class Timer extends Application{
    static Stage nu=new Stage();
Scene scene;
VBox vBox;
HBox hBox;
        String user1;
        String phoneno;
        String email1;
Button sButton,eButton,builtinappButton;
Text text;
Timeline timeline;
          Date date = new Date();
int hours=0, mins = 0, secs = 0, millis = 0;
boolean sos = true;
    long tic2,brow2,time2,pong2;
  
        public Timer(String user,String phone,String email)
        {
            user1=user;
            phoneno=phone;
            email1=email;
        }
 
        public Timer()
        {
           
        }
public static void main(String[] args) {
launch(args);
}

  

void change(Text text) {
if(millis == 1000) {
secs++;
millis = 0;
}
if(secs == 60) {
mins++;
secs = 0;
}
      if(mins==60){
          hours++;
           mins=0;
                }
text.setText((((hours/10) == 0) ? "0" : "") + hours + ":" +(((mins/10) == 0) ? "0" : "") + mins + ":"
+ (((secs/10) == 0) ? "0" : "") + secs + ":"
+ (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
    }

@Override
public void start(Stage primaryStage) {
                nu=primaryStage;
           text = new Text("00:00:00:000");
               text.setFont(Font.font("Verdana",20));
               text.setFill(Color.WHITE);
timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent event) {
            change(text);
}
}));
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.setAutoReverse(false);
sButton = new Button("Start Session");
                 sButton.setPrefHeight(50);
                 sButton.setPrefWidth(200);
                 
                eButton = new Button("Stop Session");
                eButton.setPrefHeight(50);
                eButton.setPrefWidth(200);
               eButton.setVisible(false);
               
               
                sButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setFullScreen(false);
                primaryStage.setAlwaysOnTop(false);
primaryStage.setResizable(true);
             primaryStage.setResizable(true);
          
            //  primaryStage.initStyle(StageStyle.UTILITY);
                if(sos) {
            timeline.play();
                 eButton.setVisible(true);
                 builtinappButton.setVisible(true);
         
                }
            }
        });
               
               

                 eButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               double bill=0;
                 String text1=text.getText();
                if(sos) {
            timeline.pause();
       
                        try {
                            
                            
               String str=text.getText();
               String numberOnly= str.replaceAll("[^0-9]", "");
               int a= Integer.valueOf(numberOnly);
               System.out.println(a);   
               
               if(a<3000000)
               {
                   bill=10;
               }
               if(a>3000000&&a<10000000)
               {
                   bill=20;
               }
               if(a>10000000&&a<20000000)
               {
                   bill=30;
               }
               if(a>20000000)
               {
                   bill=40;
               }
               System.out.println("The bill is Rs. "+bill);
               
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                String statem="select user_id from users where user_name=? and user_phoneno=?";
                PreparedStatement xyz=abc.prepareStatement(statem);
                xyz.setString(1, user1);
              //  int phoneno1=Integer.valueOf(phoneno);
              Double phoneno1=Double.valueOf(phoneno);
                xyz.setDouble(2, phoneno1);
                ResultSet rs =xyz.executeQuery();
                                String user_id="";
                                while(rs.next())
                                {
                         user_id=rs.getString(1);
                                }
               
                 System.out.println(user_id);
                System.out.println(text.getText());
              
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"+" "+text1);
                String s = formatter.format(date);
                 System.out.println(s);
               System.out.println(text1);
         
               xyz.executeUpdate("insert into sessions (USER_ID,START_TIME,STOP_TIME,USAGE_TIME) values('"+user_id+"','00:00:00:000','"+text1+"','"+text1+"')");
                xyz.executeUpdate("insert into charges (USER_ID,USAGE_TIME,BILL_AMOUNT) values('"+user_id+"','"+text1+"','"+bill+"')");
                   
            } catch (ClassNotFoundException ex) {
           
            } catch (SQLException ex) {
           
            }
                   
                        nu.close();
            
         
            Session ctc1 = new Session(text1,bill,user1,email1);
                try {

                    ctc1.start(Session.nu);
                } catch (Exception ex) {
                                 
                }    
            }
            }
        });
                 
                 
                 primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
                     double bill=0;
                 String text1=text.getText();
                if(sos) {
            timeline.pause();
       
                        try {
                            
                            
               String str=text.getText();
               String numberOnly= str.replaceAll("[^0-9]", "");
               int a= Integer.valueOf(numberOnly);
               System.out.println(a);   
               
               if(a<3000000)
               {
                   bill=10;
               }
               if(a>3000000&&a<10000000)
               {
                   bill=20;
               }
               if(a>10000000&&a<20000000)
               {
                   bill=30;
               }
               if(a>20000000)
               {
                   bill=40;
               }
               System.out.println("The bill is Rs. "+bill);
               
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                String statem="select user_id from users where user_name=? and user_phoneno=?";
                PreparedStatement xyz=abc.prepareStatement(statem);
                xyz.setString(1, user1);
                int phoneno1=Integer.valueOf(phoneno);
                xyz.setInt(2, phoneno1);
                ResultSet rs =xyz.executeQuery();
                                String user_id="";
                                while(rs.next())
                                {
                         user_id=rs.getString(1);
                                }
               
                 System.out.println(user_id);
                System.out.println(text.getText());
              
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy"+" "+text1);
                String s = formatter.format(date);
                 System.out.println(s);
               System.out.println(text1);
         
               xyz.executeUpdate("insert into sessions (USER_ID,START_TIME,STOP_TIME,USAGE_TIME) values('"+user_id+"','00:00:00:000','"+text1+"','"+text1+"')");
                xyz.executeUpdate("insert into charges (USER_ID,USAGE_TIME,BILL_AMOUNT) values('"+user_id+"','"+text1+"','"+bill+"')");
                   
            } catch (ClassNotFoundException ex) {
           
            } catch (SQLException ex) {
           
            }
                   
                        nu.close();
            
         
            Session ctc1 = new Session(text1,bill,user1,email1);
                try {

                    ctc1.start(Session.nu);
                } catch (Exception ex) {
                                 
                }    
            }
              System.out.println("Stage is closing");
          }
       });      
               
                builtinappButton = new Button("Built in Apps");
                builtinappButton.setPrefHeight(50);
                builtinappButton.setPrefWidth(200);
                  builtinappButton.setVisible(false);
                builtinappButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
            builtinapps ctc = new builtinapps();

                try {

                    ctc.start(builtinapps.nu);
                } catch (Exception ex) {
                                 
                }
               
            }
           
     
         
        });
                hBox = new HBox(90);
hBox.setAlignment(Pos.CENTER);
hBox.getChildren().addAll(sButton);
                 hBox.getChildren().addAll(eButton);
                hBox.getChildren().addAll(builtinappButton);
                vBox = new VBox(100);
vBox.setAlignment(Pos.CENTER);
vBox.getChildren().addAll(text, hBox);
scene = new Scene(vBox, 800, 500);
                scene.getStylesheets().add("/CSS/user.css");
               scene.addEventHandler(KeyEvent.KEY_PRESSED, new  EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.isAltDown())
                       event.consume();
            }
              
          });       

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

primaryStage.setScene(scene);
 primaryStage.setTitle("Timer");

 primaryStage.setFullScreenExitHint("press start to start the session");
//primaryStage.setFullScreen(true);
      primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
 primaryStage.setAlwaysOnTop(true);
  primaryStage.setFullScreen(true);
        primaryStage.setOnCloseRequest(e -> e.consume());  
            
  primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
primaryStage.getIcons().add(new Image("file:resources/images/c.png"));
primaryStage.show();
}


}