/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author BRAHIMI
 */
public class RadioFrequenceBR extends Parent{
    
    final       String         styleButton   =     " -fx-font: 16 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           + " -fx-background-color: black;"
                                           + " -fx-text-fill: white;"
                                           + " -fx-border-radius: 5;";
    final       String         styleLabel   =     " -fx-font: 16 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           + " -fx-background-color: gray;"
                                           + " -fx-text-fill: white;"
                                           + " -fx-border-radius: 5;";
    
    final DatePicker    DateB          = new DatePicker();      
    final ToggleGroup   Tgroup1        = new ToggleGroup();
    final ToggleGroup   Tgroup2        = new ToggleGroup(); 
    final DatePicker    dateRF         = new DatePicker(); 
    final DatePicker    dateTRT        = new DatePicker();
    final ToggleGroup   Tgroup3        = new ToggleGroup();
    final ToggleGroup   Tgroup4        = new ToggleGroup();
    final ToggleGroup   Tgroup5        = new ToggleGroup();
    final ToggleGroup   Tgroup6        = new ToggleGroup();
    final TextArea      autreIncident  ;
    final ToggleGroup   Tgroup7        = new ToggleGroup();
    
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
       
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////
       //// La Partie Consultation   ///////////////////////////////////////////////////////////////////////////////
       
           private final Label TDateDeTrait            = new Label();
    private final Label TRadioFrequence         = new Label();
    private final Label TRadioFreqPercutannee   = new Label();
    private final Label TDateRadioFreq          = new Label();
    private final Label TFreqDateDebTrt         = new Label();
    private final Label TFreqDoulHepat          = new Label();
    private final Label TFreqNausee             = new Label();
    private final Label TFreqVomissement        = new Label();
    private final Label TFreqFievre             = new Label();
    private final Label TFreqAutres             = new Label();
    private final Label TFreqNbrCure            = new Label();
    
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

       /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    final String DateInsBilan;
    public RadioFrequenceBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
        
       this.DateInsBilan   = DateInsBilan;
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
        
        final GridPane     grid               = new GridPane();             grid.setVgap(5);  grid.setHgap(5);
        final Label        RadioFrequence     = new Label("Radio Fréquence ");
        RadioFrequence.setStyle(styleButton);
              final RadioButton   OuiRF          = new RadioButton("Oui");OuiRF.setUserData("Oui");OuiRF.setSelected(true);
              final RadioButton   NonRF          = new RadioButton("Non");NonRF.setUserData("Non");
              
              OuiRF.setToggleGroup(Tgroup1);  NonRF.setToggleGroup(Tgroup1);
        grid.add(RadioFrequence, 0,0);   grid.add(OuiRF,1,0);  grid.add(NonRF,2,0);
        
        final RadioButton        Percutanee      = new RadioButton("Percutanée");    Percutanee.setUserData("Percutanée");
        final RadioButton        PerOp           = new RadioButton("Per op");        PerOp.setUserData("Per Op");
                                                                                     Percutanee.setSelected(true);
                                                                                             
        Percutanee.setToggleGroup(Tgroup2);  PerOp.setToggleGroup(Tgroup2);
        grid.add(Percutanee,0,1);   grid.add(PerOp,1,1);
        
        dateRF.setDayCellFactory(dayCellFactory);
        dateRF.setPromptText("Date");
        dateTRT.setPromptText("Date de début du TRT ");
        final Label     DateRF    =  new Label("Date De Radio Fréquence ");      
        grid.add(DateRF, 0,2);    grid.add(dateRF,1,2);
        dateRF.setPrefWidth(150);dateRF.setValue(LocalDate.now());
        dateTRT.setDayCellFactory(dayCellFactory);
        final Label     DateTRT   =  new Label("Date de début du TRT ");
        dateTRT.setValue(LocalDate.now()); dateTRT.setPrefWidth(150);
        grid.add(DateTRT, 0,3);     grid.add(dateTRT,1,3);   
        
        final Label              Incidents       = new Label("Incidents");
        Incidents.setStyle(styleLabel);
        grid.add(Incidents,0,4);
              final Label          DouleurHep    = new Label("- douleur hépatique ");
                    final RadioButton     OuiDH      = new RadioButton("Oui");      OuiDH.setUserData("Oui");
                    final RadioButton     NonDH      = new RadioButton("Non");      NonDH.setUserData("Non");
                                                                                    OuiDH.setSelected(true);
                                                                                            
                    OuiDH.setToggleGroup(Tgroup3); NonDH.setToggleGroup(Tgroup3);
        grid.add(DouleurHep,0,5);  grid.add(OuiDH,1,5);  grid.add(NonDH,2,5);
        
              final Label          Nausees      = new Label("- nausées ");
                    final RadioButton     OuiN       = new RadioButton("Oui");    OuiN.setUserData("Oui");
                    final RadioButton     NonN       = new RadioButton("Non");    NonN.setUserData("Non");
                                                                                  OuiN.setSelected(true);
                    OuiN.setToggleGroup(Tgroup4); NonN.setToggleGroup(Tgroup4);
        grid.add(Nausees,0,6);  grid.add(OuiN,1,6);  grid.add(NonN,2,6);
       
              final Label          Vomissement   = new Label("- vomissements ");
                    final RadioButton     OuiV       = new RadioButton("Oui");    OuiV.setUserData("Oui");
                    final RadioButton     NonV       = new RadioButton("Non");    NonV.setUserData("Non");
                                                                                  OuiV.setSelected(true);
                    OuiV.setToggleGroup(Tgroup5); NonV.setToggleGroup(Tgroup5);
        grid.add(Vomissement,0,7);  grid.add(OuiV,1,7);  grid.add(NonV,2,7);
              
              final Label          Fievre        = new Label("- fièvre ");
                    final RadioButton     OuiF       = new RadioButton("Oui");     OuiF.setUserData("Oui");
                    final RadioButton     NonF       = new RadioButton("Non");     NonF.setUserData("Non");
                                                                                   OuiF.setSelected(true);
                    OuiF.setToggleGroup(Tgroup6); NonF.setToggleGroup(Tgroup6);
        grid.add(Fievre,0,8);  grid.add(OuiF,1,8);  grid.add(NonF,2,8);
         
        autreIncident = champSaisierA();
                 autreIncident.setPromptText("Autre Incidents");
        grid.add(autreIncident,0,9); autreIncident.setPrefSize(200,80);
        
        final Label             NombreCure        = new Label(" Nombre de cure ");
              final RadioButton      Nombre1         = new RadioButton("1");    Nombre1.setUserData("1");
              final RadioButton      Nombre2         = new RadioButton("2");    Nombre2.setUserData("2");
              final RadioButton      Nombre3         = new RadioButton("3");    Nombre3.setUserData("3");
              final RadioButton      Nombre4         = new RadioButton(">3");   Nombre4.setUserData(">3");
                                                                                Nombre1.setSelected(true);
              Nombre1.setToggleGroup(Tgroup7); Nombre2.setToggleGroup(Tgroup7); Nombre3.setToggleGroup(Tgroup7);
              Nombre4.setToggleGroup(Tgroup7); 
        grid.add(NombreCure,0,10); grid.add(Nombre1,1,10); grid.add(Nombre2,2,10); grid.add(Nombre3,3,10);
                                   grid.add(Nombre4,4,10);
         
        
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
        Ajouter.setOnAction((ActionEvent)-> {
            try {
               int i = this.InsertionSGBD(NumDossier);
                   if(i == 1){
                    IndIns.setGraphic(ImgSucc); IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements\n Propose (Radio Fréquence) \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Traitements de même type \n au niveau d'un dossier \n sur la même date ");
                   }            
                 } catch (SQLException ex) {
                Logger.getLogger(RadioFrequenceBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 5,12); 
        grid.add(IndIns, 4,2,4,4);
        ////
        Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value, 
        Toggle new_value)->{
            if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
                grid.getChildren().removeAll(Percutanee,PerOp,dateRF,dateTRT,Incidents,DouleurHep,OuiDH,NonDH,
                        Nausees,OuiN,NonN,Vomissement,OuiV,NonV,Fievre,OuiF,NonF,autreIncident, NombreCure,Nombre1,
                        Nombre2,Nombre3,Nombre4,Ajouter,DateRF,DateTRT,IndIns);
            }else {
                grid.getChildren().addAll(Percutanee,PerOp,dateRF,dateTRT,Incidents,DouleurHep,OuiDH,NonDH,
                        Nausees,OuiN,NonN,Vomissement,OuiV,NonV,Fievre,OuiF,NonF,autreIncident, NombreCure,Nombre1,
                        Nombre2,Nombre3,Nombre4,Ajouter,DateRF,DateTRT,IndIns);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////// La Partie Consultation                                 ////////////////////////////////////////////////
    final GridPane        gridC    = new GridPane();
    gridC.setVgap(10);
    gridC.setHgap(7);
    
     final Label ConsDateDeTrait             = new Label("Date Traitement                      :");
     final Label ConsRadioFrequence          = new Label("Radiofréquence                       :");
     final Label ConsRadioFreqPercutannee    = new Label("Percutanée / per op                  :");
     final Label ConsDateRadioFreq           = new Label("Date                                 :");
     final Label ConsFreqDateDebTrt          = new Label("Date de début du TRT                 :");
     final Label ConsFreqDoulHepat           = new Label("Douleur hépatique                    :");
     final Label ConsFreqNausee              = new Label("Nausées                              :");
     final Label ConsFreqVomissement         = new Label("Vomissements                         :");
     final Label ConsFreqFievre              = new Label("Dièvre                               :");
     final Label ConsFreqAutres              = new Label("Autres                               :");
     final Label ConsFreqNbrCure             = new Label("Nombre de cure                       :");
    
     final Label RadioFLabel                 = new Label("Radio Fréquence :");
     RadioFLabel.getStyleClass().add("setStyleCirconsanceDic");
  
  gridC.add(RadioFLabel , 0,0);
  gridC.add(ConsDateDeTrait , 0,1);                         gridC.add(TDateDeTrait,5,1);
  gridC.add(ConsRadioFrequence ,0, 2);                      gridC.add(TRadioFrequence,5,2);
  gridC.add(ConsRadioFreqPercutannee, 0,3);                 gridC.add(TRadioFreqPercutannee,5,3);
  gridC.add(ConsDateRadioFreq,0, 4);                        gridC.add(TDateRadioFreq,5,4);
  gridC.add(ConsFreqDateDebTrt,0,5);                        gridC.add(TFreqDateDebTrt,5,5);
  gridC.add(ConsFreqDoulHepat  , 0,6);                      gridC.add(TFreqDoulHepat , 5,6);
  gridC.add(ConsFreqNausee , 0,7);                          gridC.add(TFreqNausee , 5,7);
  gridC.add(ConsFreqVomissement , 0,8);                     gridC.add(TFreqVomissement , 5,8);
  gridC.add(ConsFreqFievre , 0,9);                          gridC.add(TFreqFievre , 5,9);
  gridC.add(ConsFreqAutres , 0,10);                         gridC.add(TFreqAutres ,5,10);
  gridC.add(ConsFreqNbrCure , 0,11);                        gridC.add(TFreqNbrCure , 5,11);
        
  
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

                
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
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
        gridC.add(barOutil,6,14,2,2);
        gridC.add(vbMod,0,14,3,2);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
     }
 
    }
  
    public String getRadioFrequence() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public String getPer() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateRF() {
        return dateRF.getValue();
    }

    public LocalDate getDateTRT() {
        return dateTRT.getValue();
    }

    public String getDouleurH() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getNausees() {
        return Tgroup4.getSelectedToggle().getUserData().toString();
    }

    public String getVomissement() {
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }

    public String getFievre() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getAutreIncident() {
        return autreIncident.getText();
    }

    public String getNombreCur() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getRadioFrequence()+"\n"+this.getPer()+"\n"+this.getDateRF()+"\n"+this.getDateTRT()+"\n"+
                this.getDouleurH()+"\n"+this.getNausees()+"\n"+this.getVomissement()+"\n"+this.getFievre()+"\n"+
                this.getAutreIncident()+"\n"+this.getNombreCur()+"\n");
        
        MiseAjour   bddInsert    = new MiseAjour();
       int i =  bddInsert.AddElement("Insert into RadioFrequence values(0,'"+this.getRadioFrequence()+"','"+this.getPer()+"','"+this.getDateRF()+"','"+this.getDateTRT()+"','"+
                this.getDouleurH()+"','"+this.getNausees()+"','"+this.getVomissement()+"','"+this.getFievre()+"','"+
                this.getAutreIncident()+"','"+this.getNombreCur()+"','"+NumDossier+"','"+this.getDateB()+"')");
    
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
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////// La Partie Consultation   ////////////////////////////////////////////////////////////////////////////////
    
     public void setTDateDeTrait(String a) {
        TDateDeTrait.setText(a);
    }

    public void setTRadioFrequence(String a) {
        TRadioFrequence.setText(a);
    }

    public void setTRadioFreqPercutannee(String a) {
        TRadioFreqPercutannee.setText(a);
    }

    public void setTDateRadioFreq(String a) {
        TDateRadioFreq.setText(a);
    }

    public void setTFreqDateDebTrt(String a) {
        TFreqDateDebTrt.setText(a);
    }

    public void setTFreqDoulHepat(String a) {
        TFreqDoulHepat.setText(a);
    }

    public void setTFreqNausee(String a) {
        TFreqNausee.setText(a);
    }

    public void setTFreqVomissement(String a) {
        TFreqVomissement.setText(a);
    }

    public void setTFreqFievre(String a) {
        TFreqFievre.setText(a);
    }

    public void setTFreqAutres(String a) {
        TFreqAutres.setText(a);
    }

    public void setTFreqNbrCure(String a) {
        TFreqNbrCure.setText(a);
    }

 public void ConsultationE(String NumDossier) throws SQLException{
        
        RadioFrequenceClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from RadioFrequence where NumDossier = '"+NumDossier+"'"
                                           +"and DateTraitement = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new RadioFrequenceClasse(res.getDate(13),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11)
     
     );
     
}
    try{
    this.setTDateDeTrait(Bilan.getTDateDeTrait().toString());
    this.setTRadioFrequence(Bilan.getTRadioFrequence());
    this.setTRadioFreqPercutannee(Bilan.getTRadioFreqPercutannee());
    this.setTDateRadioFreq(Bilan.getTDateRadioFreq());
    this.setTFreqDateDebTrt(Bilan.getTFreqDateDebTrt());
    this.setTFreqDoulHepat(Bilan.getTFreqDoulHepat());
    this.setTFreqNausee(Bilan.getTFreqNausee());
    this.setTFreqFievre(Bilan.getTFreqFievre());
    this.setTFreqAutres(Bilan.getTFreqAutres());
    this.setTFreqNbrCure(Bilan.getTFreqNbrCure());
    this.setTFreqVomissement(Bilan.getTFreqVomissement());
    }catch(Exception e){
            this.setTDateDeTrait("-------------");
    this.setTRadioFrequence("-------------");
    this.setTRadioFreqPercutannee("-------------");
    this.setTDateRadioFreq("-------------");
    this.setTFreqDateDebTrt("-------------");
    this.setTFreqDoulHepat("-------------");
    this.setTFreqNausee("-------------");
    this.setTFreqFievre("-------------");
    this.setTFreqAutres("-------------");
    this.setTFreqNbrCure("-------------");
    this.setTFreqVomissement("-------------");
    }
}
 
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from RadioFrequence where NumDossier ='"+NumDossier+"' and dateTraitement ='"+DateInsBilan+"'" );
            
            return j;
        } 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
