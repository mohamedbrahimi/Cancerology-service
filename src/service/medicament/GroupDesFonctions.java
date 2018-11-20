
package service.medicament;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.medicament.AnalyseSpace.AnalyseSpace;
import service.medicament.DossierPatient.DossierSpace;
import service.medicament.RendezVous.*;
import service.medicament.BilanPatient.*;
import service.medicament.DossierPatient.ActionSpace;
public class GroupDesFonctions extends Parent{
     
    final String[]     NamesLabel      = {"Statistiques ","Dossier","Bilan","Two"}  ;
    final String[]     folderIcon      = {"Images/29.jpg","Images/6_1.jpg","Images/8.jpg","Images/2.jpg"}  ;
    final Label[]      labels          = new Label[NamesLabel.length]; 
    final ImageView[]  captionsLabel   = new ImageView[NamesLabel.length];   
   final String       styleButton     =     " -fx-font: 16 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           //+ " -fx-background-color: black;"
                                           + " -fx-text-fill: black;"
                                           + " -fx-border-radius: 5;"
                                           + " -fx-background-radius: 20;";

   int stat;
   EnsembleDesFonctionsButton                        Fonctsb     ;
    public GroupDesFonctions(int stat) {
    this.stat = stat;
    
    Fonctsb     =  new EnsembleDesFonctionsButton(stat);
    }
  
   
   
    public void start(Stage primaryStage) throws SQLException {
        
        
        
        
         final DropShadow          shadow     =  new DropShadow();
        shadow.setOffsetX(1);
        shadow.setOffsetY(0.5);
        shadow.setColor(Color.AQUA);
        
        final HBox                hb         =  new HBox();
        hb.setPadding(new Insets(10,10,10,10));
        hb.setSpacing(5);
        
        
        
        
        for(int i = 0 ; i < NamesLabel.length ; i ++){
            
            final  Label        labeli   =  labels[i]  =  new Label(NamesLabel[i]);
            final  Separator    sep      =  new Separator();
            sep.setOrientation(Orientation.VERTICAL);
              sep.setStyle("  -fx-background-color : black ;" +
                              "-fx-border-width: 2;");
            labeli.setPrefWidth(200);
            labeli.setPrefHeight(30);
            
            final ImageView     icon     =  new ImageView(new Image(getClass().getResourceAsStream(folderIcon[i])));
            icon.setFitHeight(30);
            icon.setPreserveRatio(true);
            icon.setOpacity(0.5);
            
            labeli.setGraphic(icon);
            labeli.setStyle(styleButton);
            
            
            
            
            labeli.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                
                labeli.setEffect(shadow);
                labeli.setScaleX(1.1);
                labeli.setScaleY(1.1);
                icon.setOpacity(0.9);
                }
            
        });
            
            labeli.setOnMouseExited(new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {

                labeli.setEffect(null);
                labeli.setScaleX(1);
                labeli.setScaleY(1);
                icon.setOpacity(0.5);
                }
                
            });
            if(i == 0){
             labeli.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                   
                    AnalyseSpace         ds     = new AnalyseSpace(stat);
                    try {
                        ds.start(primaryStage);
                    } catch (SQLException ex) {
                        Logger.getLogger(GroupDesFonctions.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            });   
            }
            if(i == 1){
            labeli.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                   
                    DossierSpace         ds     = new DossierSpace();
                    ds.start(primaryStage);
                    
                }
                
            });
            }
             if(i == 2){
                 labeli.setVisible(false);
            labeli.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                   
                    //BilanSpace         bs     = new BilanSpace();
                    //bs.start(primaryStage); 
                    
                }
                
            });
            }
            
            if(i < 2)
            
            hb.getChildren().addAll(labeli,sep);

        }
        
        StackPane            pane       =  new StackPane();
        pane.setStyle("-fx-background-color : white ;"
                    + "");
        pane.setOpacity(0.8);
        pane.getChildren().add(hb);
        
        pane.setTranslateX(5);
        pane.setTranslateY(5);
   
        
        if(stat == 0){
        
            labels[1].setDisable(true);
            Fonctsb.ButtonExiste[3].setDisable(true);
            
        }

        
        
        Group      root     = new Group();
        Scene      scene    = new Scene(root, 1300 , 600 , Color.WHITE);
        
        final Button   Deconnect        = new Button("Déconnexion");
        Deconnect.setOnAction((ActionEvent)->{
          ServiceMedicament    service   = new ServiceMedicament();
          service.start(primaryStage);
        });
        Deconnect.setTranslateX(1160);
        Deconnect.setTranslateY(2);
        
        scene.getStylesheets().add(getClass().getResource("StylingDesktop.css").toExternalForm());
        root.getStyleClass().add("group");
        StylingInterface1                                 Styling1    =  new StylingInterface1();
       
        CalenderDesktopR                                  CalenderR   =  new CalenderDesktopR();    
        ActionSpace                                       AC          =  new ActionSpace();
       
        root.getChildren().add(Styling1);
        root.getChildren().add(Fonctsb);
        root.getChildren().add(pane);
        root.getChildren().add(CalenderR);
        root.getChildren().add(Deconnect);
        root.getChildren().add(AC);
        
        primaryStage.setX(50);
        //primaryStage.setOpacity(1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fenètre  Principale");
        
       
        primaryStage.show();
       
        
        
    }
}
