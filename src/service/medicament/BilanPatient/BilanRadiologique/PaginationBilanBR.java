
package service.medicament.BilanPatient.BilanRadiologique;

import service.medicament.TraitementProposer.TraitementProposerBR;
import service.medicament.TraitementProposer.TherapieCibles;
import service.medicament.TraitementProposer.RadioFrequenceBR;
import service.medicament.TraitementProposer.TraitementAntiViralBR;
import service.medicament.TraitementProposer.ChimieomBolisationBR;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PaginationBilanBR extends Parent{
    
    /*/final Node[] pageContent  = {new EchographiqueBR(),new EchographieDopplerBR(),new TDMBR(),new IRMBR()
                                ,new AnapathBR(),new ClassificationChildPughBR() , new TraitementProposerBR()
                                ,new RadioFrequenceBR(),new ChimieomBolisationBR(),new TherapieCibles(),
                                 new TraitementAntiViralBR()} ;
    
   
    
   */
    
    
    
    public PaginationBilanBR(){
        
        // final Pagination Page         = new Pagination(11,0);
        //Page.setPrefSize(750,420);
        //Page.setPadding(new Insets(30,10,10,30));
        //Page.getChildrenUnmodifiable().addAll(new ScrollPane(new EchographiqueBR()));
       // Page.setPageFactory((Integer pageIndex) -> createPage(pageIndex));
        
        VBox  vbBilan                 = new VBox(2);
       
       
        getChildren().add(vbBilan);
        
        EnchainéeBilan(vbBilan);
        
    }
/*
    private  VBox createPage(Integer pageIndex) {
       
             VBox                  vb            = new VBox();//vb.setPadding(new Insets(30,10,10,30));
       ScrollPane            sc            = new ScrollPane(pageContent[pageIndex]);
    // sc.setPadding(new Insets(30,10,10,30));
       sc.setStyle("-fx-background-color: white;");
       vb.getChildren().add(sc);
        return vb;
    //To change body of generated methods, choose Tools | Templates.
    
    }
    */

    private void EnchainéeBilan(VBox vbBilan) {
 /*
          for(Node   N : pageContent){
              vbBilan.getChildren().add(N);
          }   
         */
    }
    
}
