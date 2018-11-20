
package service.medicament.Patient;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.medicament.DossierPatient.FichePatientSpace;

public class PatientSpace extends Application {
     

     
    @Override
    public void start(Stage primaryStage ) throws SQLException{
        
        Group     root    =  new Group(); 
        
        Scene     scene   =  new Scene(root , 1300 , 600 , Color.DIMGRAY);
        
        
        InfoPatient   info         = new InfoPatient();
        root.getChildren().add(info);
        scene.getStylesheets().add(getClass().getResource("StylingPatient.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion des Patient");
        primaryStage.show();
    }
    
}
