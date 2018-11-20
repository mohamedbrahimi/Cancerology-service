
package service.medicament.Paramétres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public class ParamétresSpace extends Application{

     
     final Label   UserT       = new Label("Nom d'utilsateur courant  ");
     final TextField           textUserT   = new TextField();  
     final Label   UserIndT    = new Label();
     
     final Label   UserN       = new Label("Nouveau nom d'utilisateur  ");
     final TextField           textUserN   = new TextField();
     final Label   UserIndN    = new Label();
     
     final Label   PassT       = new Label("Mot de passe courant  ");
     final PasswordField       PassUserT   = new PasswordField(); 
     final Label   PassIndT    = new Label();
     
     final Label   PassN       = new Label("Nouveau mot de passe        ");
     final PasswordField       PassUserN   = new PasswordField();
     final Label   PassIndN    = new Label();
     
     final Button  Valider     = new Button("Valider");  
     
     final Label   IndMod      = new Label();
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane    grid          = new GridPane();
        grid.setVgap(7);
        grid.setHgap(5);
        
        
        final Label    Caption    = new Label("Paramètres de Compte");  Caption.setId("lab");
        grid.add(Caption,0,0,3,1);
        grid.add(UserT,0,1);       grid.add(textUserT, 1,1);  grid.add(UserIndT, 2,1);   UserIndT.setId("labInd");
        grid.add(UserN,0,2);       grid.add(textUserN, 1,2);  grid.add(UserIndN, 2,2);   UserIndN.setId("labInd");
        grid.add(PassT,0,3);       grid.add(PassUserT, 1,3);  grid.add(PassIndT, 2,3);   PassIndT.setId("labInd");
        grid.add(PassN,0,4);       grid.add(PassUserN, 1,4);  grid.add(PassIndN, 2,4);   PassIndN.setId("labInd");
        
        grid.add(Valider, 0,8); Valider.setTranslateY(50);
        grid.add(IndMod, 1,8,4,1);
        Valider.setOnAction((ActionEvent)->{
            try {
                if(VerifChamp()){
                    IndMod.setText("les paramètres sont modifiés   ");
                    UserClasse     user    = new UserClasse(this.getTextUserN(),this.getPassUserN());
                    this.setUser(user);
                }else  IndMod.setText("erreur ...");
            } catch (SQLException ex) {
                Logger.getLogger(ParamétresSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.setTranslateX(80);
        grid.setTranslateY(80);
        Group     root    =  new Group();
        root.getChildren().add(grid);
        Scene     scene   =  new Scene(root , 700 , 500 , Color.WHITE);
       
        scene.getStylesheets().add(getClass().getResource("Styling.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paramètres de Compte");
        primaryStage.show();
    }
    
    public boolean VerifChamp() throws SQLException{
            UserClasse   User  = this.ExtUser();
            boolean     verif  = true;
            if(textUserT.getText().trim().equals("")){UserIndT.setText("Champ vide !!");verif  = verif && false;} 
            else {
                if(!textUserT.getText().trim().equals(User.getUser())){
                 UserIndT.setText("Utilisateur n'existe pas");verif  =verif && false;   
                }else
                { UserIndT.setText("");verif  = verif && true;}
            }
            if(textUserN.getText().trim().equals("")){
                UserIndN.setText("Champ vide !!");verif  =verif && false;
            } else{ if(textUserN.getText().trim().length() <=3){
                UserIndN.setText("Nom trés court");verif  =verif && false;
            }else{
                UserIndN.setText("");verif  =verif && true; 
            }
            }
            if(PassUserT.getText().trim().equals("")){
                PassIndT.setText("Champ vide !!");verif  =verif && false;
            } else{ if(!PassUserT.getText().trim().equals(User.getPass())){
                PassIndT.setText("Mot de passe incorrect");verif  =verif && false;
            }else{
                PassIndT.setText("");verif  = verif && true;
            }
            }
            if(PassUserN.getText().trim().equals("")){
                PassIndN.setText("Champ vide !!");verif  =verif && false;
            } else{ if(PassUserN.getText().trim().length() <=3){
                
                PassIndN.setText("Mot de passe trés court");verif  =verif && false;
            }else{
            PassIndN.setText("");verif  =verif && true;}
            }
            
            return verif;
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
    
    public void  setUser(UserClasse user) throws SQLException{
        MiseAjour  bddOwner     = new MiseAjour();
        bddOwner.AddElement("Update Connect set User ='"+user.getUser()+"',PassWord ='"+user.getPass()+"'");
    }

    public String getTextUserN() {
        return textUserN.getText();
    }

    public String getPassUserN() {
        return PassUserN.getText();
    }
    
}
