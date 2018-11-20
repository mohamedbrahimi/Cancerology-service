
package service.medicament.RendezVous;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RendezVousSpace extends Application{

    int stat;
    public RendezVousSpace(int stat) {
    
    this.stat = stat;
    }

    
    
    public void start(Stage primaryStage) throws Exception {
        
        Group     root    =  new Group();
        
        Scene     scene   =  new Scene(root , 1300 , 580 ,Color.WHITE);
        final     ImageView     image     = new ImageView(new Image(getClass().getResourceAsStream("Images/1.jpg")));
        image.setFitWidth(200);
        image.setPreserveRatio(true);
        image.setTranslateX(10);
        image.setTranslateY(10);
        
        
        EtablissementRdvSpace               ERS      = new EtablissementRdvSpace();
        TraitementDesRendezVousSpace        TRDV     = new TraitementDesRendezVousSpace();
        
        
        root.getChildren().add(image);
        if(stat == 1)root.getChildren().add(ERS);
        root.getChildren().add(TRDV);
        primaryStage.setTitle("Gestion des Rendez_Vous");
        scene.getStylesheets().add(getClass().getResource("StylingCalender.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
