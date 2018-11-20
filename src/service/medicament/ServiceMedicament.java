
package service.medicament;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.medicament.Paramétres.UserClasse;
import service.medicament.SGBD.Consultation;

public class ServiceMedicament extends Application {
    
       final TextField               NameUser        = new TextField();
       final PasswordField           PassUser        = new PasswordField();
       final Label                   WelcomLabel     = new Label("Bienvenue");
       final Text                    controlName     = new Text();
       final Text                    controlPass     = new Text();
       final Button                  connectButton   = new Button();
       final Hyperlink               connectHyper    = new Hyperlink("Appuyer si vous n'etes pas un utilisateur");
       
      
    @Override
    public void start(Stage primaryStage) {
       
        final  GridPane    grid     =  new GridPane();
        
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setAlignment(Pos.CENTER);
        
        //grid.setTranslateY(100);
        WelcomLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        final ImageView    imgLabel  =  new ImageView(new Image(getClass().getResourceAsStream("Images/18.jpg")));
        final ImageView    imgLabel1 =  new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        final ImageView    imgLabel3 =  new ImageView(new Image(getClass().getResourceAsStream("Images/6.jpg")));
        final ImageView    imgLabel4 =  new ImageView(new Image(getClass().getResourceAsStream("Images/11.jpg")));
        
        imgLabel1.setOpacity(0.195);
        imgLabel.setFitHeight(50);
        imgLabel.setPreserveRatio(true);
        imgLabel1.setRotate(20);
        imgLabel3.setFitWidth(50);
        imgLabel3.setPreserveRatio(true);
        imgLabel4.setOpacity(0.5);
        imgLabel4.setFitWidth(100);
        imgLabel4.setRotate(20);
        imgLabel4.setPreserveRatio(true);
         
       
        connectButton.setGraphic(imgLabel3);
        connectButton.setOnAction((ActionEvent) ->  { 
            UserClasse user = null;
            try {
                user = this.ExtUser();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceMedicament.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!NameUser.getText().isEmpty()) {
                if(NameUser.getText().equals(user.getUser())){
                controlName.setText(null);
                    if(!PassUser.getText().isEmpty()){
                        if(PassUser.getText().equals(user.getPass())){
                controlPass.setText(null); 
                GroupDesFonctions        classe = new GroupDesFonctions(1);
                            try {
                                classe.start(primaryStage);
                            } catch (SQLException ex) {
                                Logger.getLogger(ServiceMedicament.class.getName()).log(Level.SEVERE, null, ex);
                            }
               
                
                        }else controlPass.setText(" Votre mot de passe est incorrect !");
                    }else controlPass.setText("Veuillez Saisir votre mot de passe !");
                }else controlName.setText(" Votre nom d'utilisateur est incorrect ");
            }else controlName.setText("Veuillez saisir votre nom d'utilisateur ");
            
        });
        controlName.setFill(Color.MAROON);
        controlPass.setFill(Color.MAROON);
        
        final DropShadow   shadow    =  new DropShadow();
        shadow.setOffsetX(4);
        shadow.setColor(Color.GREY);
        imgLabel.setEffect(shadow);
        imgLabel4.setEffect(shadow);
        //imgLabel1.setEffect(shadow);
       // WelcomLabel.setGraphic(imgLabel);
        
        grid.add(imgLabel4,1,0,4,1);
        grid.add(imgLabel,0,1);
        grid.add(WelcomLabel,1,1);
        
        NameUser.setPromptText(" Nom d'utilisateur ");
        grid.add(NameUser,0,2);
        grid.add(controlName,1,2,5,1);
        
        PassUser.setPromptText(" Mot de passe  ");
        grid.add(PassUser,0,3);
        grid.add(controlPass,1,3,5,1);
        
        grid.add(connectButton,2,4);
        grid.add(connectHyper,0,4,5,1);
        grid.add(imgLabel1,0,6,4,1);
        
        connectHyper.setOnAction((ActionEvent)->{
            GroupDesFonctions        classe = new GroupDesFonctions(0);
            
                
                try {
                    classe.start(primaryStage);
                    //classe.labels[1].setDisable(true);
                    classe.labels[1].setTooltip(new Tooltip(("vous n’êtes pas un médecin inscrivez vous \n pour accéder à cet endroit   ")));
                    
                    classe.Fonctsb.ButtonExiste[3].setTooltip(new Tooltip(("vous n’êtes pas un médecin inscrivez vous \n pour accéder à cet endroit   ")));
                    //classe.Fonctsb.ButtonExiste[3].setDisable(true);
                
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceMedicament.class.getName()).log(Level.SEVERE, null, ex);
                
            };
        });
      ///////////////////////////////////////
        ////////////////////////////
        Translate   d    = new Translate(-100,0); 
        WelcomLabel.getTransforms().add(d);
          Timeline timeline = new Timeline();
          timeline.getKeyFrames().addAll(
          new KeyFrame(Duration.ZERO, new
          KeyValue(d.xProperty(), -100)), 
          new KeyFrame(new Duration(1800), new 
          KeyValue(d.xProperty(),  00))
           
          ); 
        ;
          timeline.setAutoReverse(true);
          timeline.setCycleCount(Timeline.INDEFINITE);
          timeline.play();
        //////////////////////////
          //////////////////////////////////////
        Group root = new Group();
        root.getChildren().add(grid);
        Scene scene = new Scene(root, 380, 550,Color.WHITE);
        
        primaryStage.setTitle("Login");
        primaryStage.getIcons().add(new Image("file:Images/8.jpg"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
    public UserClasse ExtUser() throws SQLException{
        UserClasse   User    = null;
        Consultation bddOwner   = new Consultation();
        ResultSet    res        = bddOwner.ExtElement("Select * from connect");
        while(res.next())
        User      = new UserClasse(res.getString(1),res.getString(2));
         bddOwner.CloseConnex();
     return User;
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
