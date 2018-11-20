
package service.medicament.AnalyseSpace;

import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TraitementDesAnalyse extends Parent{
    
    final String[]  CaptionName             = {"Statistiques simples","ATCDS Personnels","ATCDS Familiales","Circonstances découvertes  "};
    final Label[]   CaptionTitle            = new Label[CaptionName.length];
    final VBox      vbCaption               = new VBox(30);
    /**/
    
    final String[][]  ButtonATCDSpName        ={ {"Age","Sexe","Condiotions SocioEchonomique","Situation Familiale","Wilaya","Causes de Déces"},{"Hepatopathies sous jacentes","hépatite chronique /cirrhose","Contage viral B et C","Autres ATCDS","Diabète"},
                                                  {"Hépatopathie virale dans la famille ","Néoplasie dans la famille "},{"hépatopathie sous jacente","Fortuite","Dépistage en cas de cirrohse connue","Signes généraux et fonctionnels","Signes d'hypertension portale","Signes physiques","Syndrome paranéoplasique"}};
    final Button[][]  ButtonFunct         = {new Button[ButtonATCDSpName[0].length] ,new Button[ButtonATCDSpName[1].length],
                                             new Button[ButtonATCDSpName[2].length],new Button[ButtonATCDSpName[3].length]};
    
    final HBox[]      hb                  = {new HBox(1),new HBox(1),new HBox(1),new HBox(1)};
    
    final VBox        vbCir               = new VBox(1);
    final HBox        hbCir1              = new HBox(1);
    final HBox        hbCir2              = new HBox(1);
    
    final HBox                     hbHeader                 = new HBox();
    final DescriptionAnalyseSpace   AnalDesc                = new DescriptionAnalyseSpace();
    final Node[][]                  DescGraph                ;
    
    final VBox                      ContentDesc             = new VBox(5);
    public TraitementDesAnalyse() throws SQLException{
      
       DescGraph     = AnalDesc.DescriptionStat();
       ContentDesc.setTranslateX(300);
       ContentDesc.setTranslateY(50);
       getChildren().add(ContentDesc);
       
       AnalyseClasse   anal    = new AnalyseClasse();
       AnalyseClasse   anal1  =  anal.AnalysHepathieSJacent();
       for(int i = 0 ; i < CaptionName.length ; i++){
           final Label l = CaptionTitle[i] = new Label(CaptionName[i]);
           l.setPrefSize(250, 50);
           vbCaption.getChildren().add(l);
           FunctionLabel(l,i);
           
           /**/
           for(int j = 0 ; j < ButtonATCDSpName[i].length ; j++){
           final Button b = ButtonFunct[i][j] = new Button(ButtonATCDSpName [i][j]);
           if(i != 3)
           hb[i].getChildren().add(b);
           else{
           if(j < 4) hbCir1.getChildren().add(b);
           else hbCir2.getChildren().add(b);
           }
           
           FunctionButton(b,i,j);
           
       }
          
       }
       /*ATCDSp*/
        vbCir.getChildren().addAll(hbCir1,hbCir2);
        hb[3].getChildren().add(vbCir);
        
        hbHeader.setTranslateX(280);     hbHeader.setTranslateY(10);
        vbCaption.setTranslateX(20);    vbCaption.setTranslateY(150);
        getChildren().addAll(vbCaption,hbHeader);
       
    }

    private void FunctionLabel(Label l, int i) {
       l.setOnMouseClicked(new EventHandler<MouseEvent>(){

           @Override
           public void handle(MouseEvent event) {
               generateChekedLabel(0);
               ContentDesc.getChildren().clear();
               l.setId("LabelCheked");
               hbHeader.getChildren().clear();
               hbHeader.getChildren().add(hb[i]);
          
           }

       
           
       });
     
    }

    private void FunctionButton(Button b, int i, int j) {
     
      b.setOnAction((ActionEvent)->{
          generateChekedLabel(1);
          b.setId("ButtonChecked");
          
          ContentDesc.getChildren().clear();
          ContentDesc.getChildren().add(DescGraph[i][j]);
      });
    
    }
        private void generateChekedLabel(int i) {
           if(i == 0)
           for(Label l : CaptionTitle) l.setId(null);
           for(Button tab[] : ButtonFunct){
               
               for(Button b : tab) b.setId(null);
                       }
           
           
           }
    
    
}
