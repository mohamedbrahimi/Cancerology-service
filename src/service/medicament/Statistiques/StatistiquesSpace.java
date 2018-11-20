
package service.medicament.Statistiques;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class StatistiquesSpace extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
         
        Group     root    =  new Group();
        Scene     scene   =  new Scene(root , 1300 , 580 ,Color.WHITE);
        scene.getStylesheets().add(getClass().getResource("StylingStat.css").toExternalForm());
        
        
        final StatistiqueInfoSpace    stat     = new StatistiqueInfoSpace();
        
        root.getChildren().add(stat);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion des Statistiques");
        
        primaryStage.show();
    }
    
}
