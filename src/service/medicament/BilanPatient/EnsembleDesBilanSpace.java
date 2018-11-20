
package service.medicament.BilanPatient;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import service.medicament.BilanPatient.BilanRadiologique.PaginationBilanBR;

public class EnsembleDesBilanSpace extends Parent{
    
    //final    Node[]       Bilan         = {new BilanBiologique(),new BilanImmunologique(),new BilanFOGS(),new PaginationBilanBR()};
    final    String[]     BilanName     = {"Bilan Biologique" ,"Bilan Immunologique","FOGD","Bilan Radiologique "};
    final    Label[]      PartieName    = new Label[BilanName.length];
    public EnsembleDesBilanSpace(){
        final  VBox    vbox        = new VBox(5);
        for(int i = 0 ; i < BilanName.length ; i++){
            Label l = PartieName[i] = new Label(BilanName[i]);
            l.getStyleClass().add("setStyleParteBilan");
            //vbox.getChildren().addAll(l,Bilan[i]);
        }
        
        getChildren().add(vbox);
        
        
    }
    
}
