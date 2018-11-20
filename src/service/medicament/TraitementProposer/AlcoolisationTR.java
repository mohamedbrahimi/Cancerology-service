
package service.medicament.TraitementProposer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import service.medicament.BilanPatient.BilanBiologique;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;


public class AlcoolisationTR extends Parent{
       
    
              final DatePicker   DateB            = new DatePicker();             
              final ToggleGroup  Tgroup1          = new ToggleGroup();
              final DatePicker   date             = new DatePicker();
              final DatePicker   dateTRT          = new DatePicker();
              final TextArea     PreciseIncident  ;
    
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////  La Partie Consultation //////////////////////////////////////////////////
     private final Label TDateTrait        = new Label();
     private final Label TAlcoolisation    = new Label();
     private final Label TDateAlcool       = new Label();
     private final Label TDateDebAlcoolTrt = new Label();
     private final Label TAlcoolIncidents  = new Label();
     
     
                      /**********/
    final HBox         barOutil            = new HBox(2);

    final Button       EnregButton         = new Button();  
    final ImageView    EnregfImg           = new ImageView(new Image(getClass().getResourceAsStream("4.png")));
    final Button       SuppButton          = new Button();
    final ImageView    SuppImg             = new ImageView(new Image(getClass().getResourceAsStream("7_3.jpg")));
    
    final VBox         vbMod           = new VBox(5);
    final Label        IndModifS       = new Label();
    final Hyperlink    hperAnnul       = new Hyperlink("Ou Annuler l'opération ... ");
    final ImageView    IndImgS         = new ImageView(new Image(getClass().getResourceAsStream("9_2.jpg")));
    final ImageView    IndImgF         = new ImageView(new Image(getClass().getResourceAsStream("38.jpg")));

    /**********/

////////////////////////////////////////////////////////////////////////////////////////////////////////////
     final String DateInsBilan;
    public AlcoolisationTR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
        
        this.DateInsBilan = DateInsBilan;
        /////
                       /****************Partie Biologique  ************************/
        vbMod.setVisible(false);
    
    EnregfImg.setFitHeight(50);  EnregfImg.setPreserveRatio(true); EnregButton.setDisable(true);
    EnregButton.setGraphic(EnregfImg);
    SuppImg.setFitHeight(50);    SuppImg.setPreserveRatio(true);
    SuppButton.setGraphic(SuppImg);
    barOutil.getChildren().addAll(SuppButton,EnregButton);
    barOutil.getStyleClass().add("barOutil");
    
    IndImgS.setFitHeight(50); IndImgS.setPreserveRatio(true);
    IndImgF.setFitHeight(50); IndImgF.setPreserveRatio(true);
    
    vbMod.getChildren().addAll(IndModifS,hperAnnul);
        /***********************************************************/

        //   
        ImgSucc.setFitHeight(50);          ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);    ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        //
        /////
         DateB.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                     new Callback<DatePicker, DateCell>() {
                         @Override
                         public DateCell call(final DatePicker datePicker) {
                             return new DateCell() {
                        @Override
                       public void updateItem(LocalDate item, boolean empty) {
                           super.updateItem(item, empty);
                           if (item.isAfter(LocalDate.now())) {
                            setDisable(true);
                            getStyleClass().add("setStyleClassification");
                            }
                             };
                         };
                     }};
        DateB.setDayCellFactory(dayCellFactory);
        final Label DateBilan                     = new Label("Date de Traitement ");  
        
        final HBox  hbDate                        = new HBox(10);
        hbDate.getChildren().addAll(DateBilan,DateB); hbDate.setPadding(new Insets(30,20,30,20));
        final GridPane   grid     =   new GridPane();
        grid.setVgap(7);  grid.setHgap(5);
        final Label Alcoolisation     = new Label("Alcoolisation");
        Alcoolisation.getStyleClass().add("setsttyleTraitementPpartie");
        
              final RadioButton  OuiAlcool    = new RadioButton("Oui");   OuiAlcool.setUserData("Oui"); OuiAlcool.setSelected(true);
              final RadioButton  NonAlcool    = new RadioButton("Non");   NonAlcool.setUserData("Non");
              
              OuiAlcool.setToggleGroup(Tgroup1); NonAlcool.setToggleGroup(Tgroup1);
        grid.add(Alcoolisation, 0,0);   grid.add(OuiAlcool,1,0);  grid.add(NonAlcool,2,0);
        
        final  Label  DateA      = new Label("Date : ");
        date.setDayCellFactory(dayCellFactory);
        date.setPromptText("Date");date.setValue(LocalDate.now());
        grid.add(DateA, 0,1);      grid.add(date,1,1);
        
        final  Label  DateTrt    = new Label("Date Debut Trt :");
        dateTRT.setDayCellFactory(dayCellFactory);dateTRT.setValue(LocalDate.now());
        dateTRT.setPromptText("Date Debut trt");
        grid.add(DateTrt, 0,2);grid.add(dateTRT,1,2);
       
        PreciseIncident = this.champSaisierA();
        PreciseIncident.setPromptText("Incidents :(préciser)");
        PreciseIncident.setPrefSize(200,80);
        grid.add(PreciseIncident,0,3);
        ////
        final DropShadow shadow  = new DropShadow();
        shadow.setOffsetX(1);
        shadow.setOffsetY(0.5);
        shadow.setColor(Color.AQUA);
        final Button  Ajouter        = new Button("Ajouter");
        Ajouter.setEffect(null);
        Ajouter.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            Ajouter.setScaleX(1.1);
            Ajouter.setScaleY(1.1);
            Ajouter.setEffect(shadow);
            }
        });
        Ajouter.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            Ajouter.setScaleX(1);
            Ajouter.setScaleY(1);
            Ajouter.setEffect(null);   
            }
        });
        Ajouter.setOnAction((ActionEvent)->{
            try {
                int i = this.InsertionSGBD(NumDossier);
                   if(i == 1){
                    IndIns.setGraphic(ImgSucc); IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements\n Propose (Alcoolisation) \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Traitements de même type \n au niveau d'un dossier \n sur la même date ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(AlcoolisationTR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 5,5);
        grid.add(IndIns,3,1,4,4);
        ////
        Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle >ov , Toggle old_value , 
        Toggle new_value )->{
            if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
                grid.getChildren().removeAll(date,dateTRT,PreciseIncident,Ajouter,DateA,DateTrt,IndIns );
            }else {
                grid.getChildren().addAll(date,dateTRT,PreciseIncident,Ajouter,DateA,DateTrt,IndIns );
            }
        });
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////  La Partie De La Consultation    //////////////////////////////////////////////////////////////////////////
    final GridPane        gridC    = new GridPane();
    gridC.setVgap(10);
    gridC.setHgap(7);
    
      final Label ConsDateTrait            = new Label("Date alcoolisation                   :");
      final Label ConsAlcoolisation        = new Label("Alcoolisation                        :");
      final Label ConsDateAlcool           = new Label("Date                                 :");
      final Label ConsDateDebAlcoolTrt     = new Label("Date de début TRT                    :");
      final Label ConsAlcoolIncidents      = new Label("Incidents:(préciser)                 :");
      
      final Label AlcoolisationLabel       = new Label("Alcoolisation :");
      AlcoolisationLabel.getStyleClass().add("setStyleCirconsanceDic");
  gridC.add(AlcoolisationLabel, 0,0);
  gridC.add(ConsDateTrait , 0, 1);              gridC.add(TDateTrait,5,1);
  gridC.add(ConsAlcoolisation , 0, 2);                gridC.add(TAlcoolisation,5,2);
  gridC.add(ConsDateAlcool, 0, 3);                    gridC.add(TDateAlcool,5,3);
  gridC.add(ConsDateDebAlcoolTrt, 0, 4);              gridC.add(TDateDebAlcoolTrt,5,4);
  gridC.add(ConsAlcoolIncidents,0, 5,2,3);            gridC.add(TAlcoolIncidents,5,5,2,3);
  
  
               /**********************Partie Modification ***********************************************************/
        final ImageView ImgEnregSup   = new ImageView(new Image(getClass().getResourceAsStream("12_1.jpg")));
        ImgEnregSup.setFitHeight(40); ImgEnregSup.setPreserveRatio(true);
        
         SuppButton.setOnAction((ActionEvent)->{
         hperAnnul.setVisible(true);
         
     
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer la Suppression du document");
    IndModifS.setGraphic(ImgEnregSup);
    vbMod.setVisible(true);
    EnregButton.setDisable(false);
        
    });
    /****/
     hperAnnul.setOnAction((ActionEvent)->{
     vbMod.setVisible(false);
     EnregButton.setDisable(true);
   
        });
        
        EnregButton.setOnAction((ActionEvent)->{
        
        
        
            try {
                int j = this.DeleteSGBD(NumDossier);
                this.ConsultationE(NumDossier);
                 if(j == 0){
               IndModifS.setText("doncument n'est pas enregistré ");
               IndModifS.setGraphic(IndImgF); 
            }else {
               IndModifS.setText("Le Document est Supprimé ");
               IndModifS.setGraphic(IndImgS); 
               hperAnnul.setVisible(false);
               EnregButton.setDisable(true);
               this.ConsultationE(NumDossier);
               
            }
            } catch (SQLException ex) {
                Logger.getLogger(BilanBiologique.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
        });
                   
     
        
        /*****************************************************************************************************/

     grid.setPadding(new Insets(30,10,10,30));
     gridC.setPadding(new Insets(30,10,10,30));
     if(TypeCCP == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        grid.setTranslateY(50);
        pane.getChildren().addAll(hbDate,grid);
        getChildren().add(pane);
     } else {
        final StackPane   paneC     =  new StackPane();
        paneC.getStyleClass().add("setStylingRootCons");
        this.ConsultationE(NumDossier);
        gridC.setPrefWidth(900);
        gridC.add(barOutil,6,8,2,2);
        gridC.add(vbMod, 0,8,5,3);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
     }
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
    }
    

    public String getAlcoolisation() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDate() {
        return date.getValue();
    }

    public LocalDate getDateTRT() {
        return dateTRT.getValue();
    }

    public String getPreciseIncident() {
        return PreciseIncident.getText();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getAlcoolisation()+"\n"+this.getDate()+"\n"+this.getDateTRT()+"\n"+this.getPreciseIncident()+"\n");
    
       MiseAjour   bddInsert   =  new MiseAjour();
       int i = bddInsert.AddElement("Insert into Alcoolisation values (0,'"+this.getAlcoolisation()+"','"+this.getDate()+"','"+this.getDateTRT()+"','"+
               this.getPreciseIncident()+"','"+NumDossier+"','"+this.getDateB()+"')");
       
       return i ;
    }
    public TextArea champSaisierA(){
 TextArea textA = new TextArea(){
            public void replaceText(int start , int end , String text){
                if(!text.matches("[',]")){
                    super.replaceText(start, end, text);
                }
            }
           @Override
           public void replaceSelection(String text) {
               if (!text.matches("[a-z, A-Z]")) {
                    super.replaceSelection(text);
             }
            }
 };   
   return textA;  
}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////// La Partie Consultation  ////////////////////////////////////////////////////////////////////////////////////
     public void setTDateTrait(String a) {
        this.TDateTrait.setText(a);
    }

    public void setTAlcoolisation(String a) {
        TAlcoolisation.setText(a);
    }

    public void setTDateAlcool(String a) {
        TDateAlcool.setText(a);
    }

    public void setTDateDebAlcoolTrt(String a) {
        TDateDebAlcoolTrt.setText(a);
    }

    public void setTAlcoolIncidents(String a) {
        TAlcoolIncidents.setText(a);
    }
    
public void ConsultationE(String NumDossier) throws SQLException{
        
        AlcoolisationClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from Alcoolisation where NumDossier = '"+NumDossier+"'"
                                           +"and DateTrait = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new AlcoolisationClasse(res.getDate(7),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     );}
    try{
this.setTDateAlcool(Bilan.getTDateAlcool());
this.setTAlcoolIncidents(Bilan.getTAlcoolIncidents());
this.setTAlcoolisation(Bilan.getTAlcoolisation());
this.setTDateDebAlcoolTrt(Bilan.getTDateDebAlcoolTrt());
this.setTDateTrait(Bilan.getTDateTrait().toString());
    
}catch(Exception e){
this.setTDateAlcool("-------------");
this.setTAlcoolIncidents("-------------");
this.setTAlcoolisation("-------------");
this.setTDateDebAlcoolTrt("-------------");
this.setTDateTrait("-------------");
}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

             public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from Alcoolisation where NumDossier ='"+NumDossier+"' and dateTrait ='"+DateInsBilan+"'" );
            
            return j;
        } 
}
