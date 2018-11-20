
package service.medicament.DossierPatient;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ActionSpace extends Parent{
    
    final String[]       NameCF             = {"NumDossier","Nom","Action","Timer"};
    final String[]       NameCol            = {"Numéro Dossier","Nom Paitent","Action ","Heure"};
    final TableColumn[]  ColTab             =  new TableColumn[NameCol.length];
    final ObservableList<ActionClasse> data = new ActionClasse("","","","").RemplissageTab();
    final TableView            table             = new TableView(); 
    
    final Label                Historique        = new Label("Historique Dossiers");

    public ActionSpace() throws SQLException{
        
       for(int i = 0 ; i < NameCF.length ; i++){
           final TableColumn c   = ColTab[i] = new TableColumn(NameCol[i]);
           c.setMaxWidth(400); c.setMinWidth(200);
           c.setCellValueFactory(new PropertyValueFactory<>(NameCF[i]));
           
           if(i == 3)c.setPrefWidth(300);
           table.getColumns().add(c);
           }
       
       table.setItems(data);
       table.setPrefHeight(300);
       table.setPrefWidth(850);
       table.setOpacity(0.7);
       table.setId("tabl");
       
       Historique.setTranslateX(10);
       Historique.setTranslateY(-50);
       Historique.setStyle("-fx-background-color : rgb(192,192,192);"
                         + "-fx-padding   : 10px 10px 10px 10px;");
       
       getChildren().addAll(Historique,table);
       
       this.setTranslateX(10);
       this.setTranslateY(200);
    }
}
