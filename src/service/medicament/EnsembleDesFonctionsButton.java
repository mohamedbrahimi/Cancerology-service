
package service.medicament;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
///////////////////////////////////////////
// import packges ;
import service.medicament.Patient.*;
import service.medicament.Statistiques.*;
import service.medicament.RendezVous.*;
import service.medicament.Paramétres.*;
///////////////////////////////////////////
public class EnsembleDesFonctionsButton extends Parent{
    
    final String[]        ButtonName      = { "Patient" , "Statistiques "  , "Rendez Vous" , "Paramétres " };
    final Label[]        ButtonExiste     = new Label[ButtonName.length];
    final DropShadow      shadow          = new DropShadow();
    final String[]        ImageFolder     = { "Images/28.jpg","Images/4.jpg","Images/15.jpg","Images/3.png"};  
    final ImageView[]     ImageCapter     = new ImageView[ButtonName.length];
    
    final String          styleButton     =  " -fx-font: 16 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           //+ " -fx-background-color: black;"
                                           + " -fx-text-fill: black;"
                                           + " -fx-border-radius: 5;"
                                           + " -fx-background-radius: 20;";
    ;
    Stage primaryStage = new Stage(); 
    int stat;
    public EnsembleDesFonctionsButton(int stat){
    
    this.stat = stat;    
    primaryStage.setOpacity(0.95);
    shadow.setColor(Color.AQUA);
    shadow.setOffsetX(3);
    shadow.setOffsetY(2);
    
        
    final HBox     vb                = new HBox();
        vb.setPadding(new Insets(10,10,10,10));
        vb.setSpacing(5);
    ///////////////////////////////////////////////////////
    
    for (int i = 0 ; i < ButtonName.length ; i ++) {
        //
        final Label be             =  ButtonExiste[i] = new Label(ButtonName[i]);
        
        be.setPrefHeight(30);
        be.setPrefWidth(200);
        be.setStyle(styleButton); 
        
        be.setOpacity(0.7);
        //
        
          final  Separator    sep      =  new Separator();
          sep.setOrientation(Orientation.VERTICAL);
            
        final ImageView icon        =  ImageCapter[i]  = new ImageView(new Image(getClass().getResourceAsStream(ImageFolder[i])));  
        icon.setFitHeight(30);
        icon.setFitWidth(30);
        icon.setPreserveRatio(true);
        icon.setOpacity(0.5);
        
        functionLabel(be , i);
        //
        be.setGraphic(icon);
      //////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////
        
        
        be.setOnMouseEntered(new EventHandler<MouseEvent>(){
   
            @Override
            public void handle(MouseEvent event) {
            
                be.setEffect(shadow);
                be.setScaleX(1.1);
                be.setScaleY(1.1);
                be.setOpacity(0.6);
            }
            
        });
   ///////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        be.setOnMouseExited(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
             
                be.setEffect(null);
                be.setScaleX(1);
                be.setScaleY(1);
                be.setOpacity(0.5);
            }
            
        });
    /////////////////////////////////////////////////////////////
        if(i != 1){
        vb.getChildren().add(be);
        if(i != 3){
        vb.getChildren().addAll(sep);    
        }
        }
        vb.setStyle("-fx-background-color : white ;"
                    + "");
        sep.setStyle("  -fx-background-color : black ;" +
                       "-fx-border-width: 2;");
    }
 
    //this.setTranslateY();
    this.setTranslateX(440);
    this.setTranslateY(5);
    
    getChildren().add(vb);
    
    
    }

    private void functionLabel(Label be, int i) {

     be.setOnMouseClicked(new EventHandler<MouseEvent>(){

         @Override
         public void handle(MouseEvent event) {
          if(i == 0) { 
              PatientSpace       ps  = new PatientSpace() ;    
              try {
                  ps.start( primaryStage);
              } catch (SQLException ex) {
                  Logger.getLogger(EnsembleDesFonctionsButton.class.getName()).log(Level.SEVERE, null, ex);
              }
           
             }; 
        //
        if(i == 1) {
            StatistiquesSpace  ss  = new StatistiquesSpace() ;
            try {
            ss.start( primaryStage);
            }
            catch (Exception ex) {
                Logger.getLogger(EnsembleDesFonctionsButton.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
        //
        if(i == 2) {
            RendezVousSpace  ps  = new RendezVousSpace(stat) ;
        try {
            ps.start( primaryStage);
            } 
        catch (Exception ex) {
                Logger.getLogger(EnsembleDesFonctionsButton.class.getName()).log(Level.SEVERE, null, ex);
            }

      }
        //
        if(i == 3) {
            ParamétresSpace  ps  = new ParamétresSpace() ;
        try {
            ps.start( primaryStage);
            }
        catch (Exception ex) {
                Logger.getLogger(EnsembleDesFonctionsButton.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
          
         }
         
         
     });
    }
    
}
