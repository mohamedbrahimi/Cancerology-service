/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.medicament.AnalyseSpace;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.medicament.DossierPatient.DossierSpace;
import service.medicament.GroupDesFonctions;
import service.medicament.ServiceMedicament;

/**
 *
 * @author BRAHIMI
 */
public class AnalyseSpace extends Application {
    
    final String[]      NameButton               = {"Accueil"};
    final String[]      ImgButtonNames           = {"Images/18.jpg"};
    final Button[]      FunctionButton           = new Button[NameButton.length];
    final HBox          hbButton                 = new HBox();
    Stage       stage = null;
    @Override
    
    
    
    public void start(Stage primaryStage) throws SQLException {
        stage = primaryStage ;
        Group root = new Group();
       
        for(int i = 0 ; i < NameButton.length ; i++){
            final Button b = FunctionButton[i]  = new Button(NameButton[i]);
            final ImageView img    = new ImageView(new Image(getClass().getResourceAsStream("Images/18.jpg")));
            img.setFitHeight(30); img.setPreserveRatio(true);
            b.setGraphic(img);
            hbButton.getChildren().add(b);
            function(b,i);
        }
        
        TraitementDesAnalyse      TraitDesA             = new TraitementDesAnalyse();
        
        root.getChildren().add(TraitDesA);
        root.getChildren().add(hbButton);
        Scene   scene       =  new Scene(root, 1300 , 600 , Color.WHITE);
        scene.getStylesheets().add(getClass().getResource("AnalyseStyling.css").toExternalForm());

        stage.setTitle("Analyse ");
        stage.setScene(scene);
        stage.show();
    }
    int stat;
    public AnalyseSpace(int stat) {
    this.stat = stat;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void function(Button b, int i) {
    b.setOnAction((ActionEvent)->{
        if(i == 0){
            GroupDesFonctions       ds      = new GroupDesFonctions(stat);
            try {
                ds.start(stage);
            } catch (SQLException ex) {
                Logger.getLogger(AnalyseSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    });
    }
    
}
