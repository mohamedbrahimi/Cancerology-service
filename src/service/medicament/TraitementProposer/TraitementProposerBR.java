
package service.medicament.TraitementProposer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.TextField;
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
import service.medicament.BilanPatient.BilanRadiologique.EchographieDopplerClasse;
import service.medicament.BilanPatient.BilanRadiologique.EchographiqueBR;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class TraitementProposerBR extends Parent{
    
                    final DatePicker        DateB           = new DatePicker();     
                    final ToggleGroup       Tgroup1         = new ToggleGroup();
                    final ToggleGroup       Tgroup2         = new ToggleGroup();
                    final ToggleGroup       Tgroup3         = new ToggleGroup();
                    final ToggleGroup       Tgroup4         = new ToggleGroup();
                    final ToggleGroup       Tgroup5         = new ToggleGroup();
                    final ToggleGroup       Tgroup6         = new ToggleGroup();
                    final TextArea          autreR          ;
                    final DatePicker        date            = new DatePicker();
                    final ToggleGroup       Tgroup7         = new ToggleGroup();
                    final TextField         autreHR         ;
                    final ToggleGroup       Tgroup8         = new ToggleGroup();
                    final ToggleGroup       Tgroup9         = new ToggleGroup();
                    final DatePicker        dateTH          = new DatePicker();
                    final ToggleGroup       Tgroup10        = new ToggleGroup();
                    final TextField         autreTHN        ;
                    final ToggleGroup       group12         = new ToggleGroup();
                    
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
    ///////////////////////////////////////////////////////////////////////////////////
       ///// la Partie Consultation  //////////////////////////////////////////////////////////////////////
    private final Label TDateTrait              = new Label() ;
    private final Label TChirurgie              = new Label() ;
    private final Label TResection              = new Label() ;
    private final Label TSegmetectomie          = new Label() ;
    private final Label THepatectomie           = new Label() ;
    private final Label TTumorectomie           = new Label() ;
    private final Label TAutresRes              = new Label() ;
    private final Label TDateRes                = new Label() ;
    private final Label THopital                = new Label() ;
    private final Label TPreciseAutresHopital   = new Label() ;
    private final Label TTransplantation        = new Label() ;
    private final Label TVieDonneur             = new Label() ;
    private final Label TDateTransplantation    = new Label() ;
    private final Label THopitalTransplantation = new Label() ;
    private final Label TAutreHopitalTransp     = new Label() ;
    
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

       ////////////////////////////////////////////////////////////////////////////////////////////////////
        final String DateInsBilan ;      
    public TraitementProposerBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
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
        final Label DateBilan                     = new Label("Date Chirurgie ");  
        final HBox  hbDate                        = new HBox(10);
        hbDate.getChildren().addAll(DateBilan,DateB); hbDate.setPadding(new Insets(30,20,30,20));
        
        final GridPane       grid                                  = new GridPane();
        grid.setVgap(5);   grid.setHgap(5);
        final Label          TraitementProposer                    = new Label("TRAITEMENT PROPOSE");
        TraitementProposer.getStyleClass().add("setyleLabelPatieName");
        grid.add(TraitementProposer,0,0);
              final Label         Abstention                          = new Label("Abstention");
              Abstention.getStyleClass().add("setstyleTraitementPabs");
                    final RadioButton       OuiTrait                     = new RadioButton("Oui"); OuiTrait.setUserData("Oui");
                    final RadioButton       NonTrait                     = new RadioButton("Non"); NonTrait.setUserData("Non");
                    
                    OuiTrait.setToggleGroup(Tgroup1);   NonTrait.setToggleGroup(Tgroup1);
      //grid.add(Abstention,0,1);  grid.add(OuiTrait,1,1);  grid.add(NonTrait,2,1);
              
              final Label         Chirurgie                         = new Label("Chirurgie");
              Chirurgie.getStyleClass().add("setsttyleTraitementPpartie");
                    final RadioButton       OuiCH                        = new RadioButton("Oui");OuiCH.setUserData("Oui");OuiCH.setSelected(true);
                    final RadioButton       NonCH                        = new RadioButton("Non");NonCH.setUserData("Non");
                    
                    OuiCH.setToggleGroup(Tgroup2);   NonCH.setToggleGroup(Tgroup2);
        grid.add(Chirurgie,0,2);  grid.add(OuiCH,1,2);  grid.add(NonCH,2,2);
        
           ///////////////
             final Label         Resection                           = new Label("Résection");
             Resection.getStyleClass().add("setsttyleTraitementPpartie");
                    final RadioButton       OuiR                         = new RadioButton("Oui");OuiR.setUserData("Oui");
                    final RadioButton       NonR                         = new RadioButton("Non");NonR.setUserData("Non");
                                                                                                  OuiR.setSelected(true);
                    OuiR.setToggleGroup(Tgroup3);   NonR.setToggleGroup(Tgroup3);
        grid.add(Resection,0,3);  grid.add(OuiR,1,3);  grid.add(NonR,2,3);
        
             final Label         SiOui                               = new Label("SiOui");
        grid.add(SiOui, 0,4);
             final Label         Segmetectomie                       = new Label("segmetectomie");
                    final RadioButton       OuiSeg                       = new RadioButton("Oui");  OuiSeg.setUserData("Oui");
                    final RadioButton       NonSeg                       = new RadioButton("Non");  NonSeg.setUserData("Non");
                                                                                                    OuiSeg.setSelected(true);
                    OuiSeg.setToggleGroup(Tgroup4);   NonSeg.setToggleGroup(Tgroup4);
        grid.add(Segmetectomie,0,5);  grid.add(OuiSeg,1,5);  grid.add(NonSeg,2,5);
        
             final Label         Hepatectomie                            = new Label("Hepatectomie  ");
                    final RadioButton       OuiHepat                     = new RadioButton("Oui"); OuiHepat.setUserData("Oui");
                    final RadioButton       NonHepat                     = new RadioButton("Non"); NonHepat.setUserData("Non");
                                                                                                   OuiHepat.setSelected(true);
                    OuiHepat.setToggleGroup(Tgroup5);   NonHepat.setToggleGroup(Tgroup5);
        grid.add(Hepatectomie,0,6);  grid.add(OuiHepat,1,6);  grid.add(NonHepat,2,6);
        
             final Label         Tumorectomie                           = new Label("Tumorectomie ");
                    final RadioButton       OuiTumor                     = new RadioButton("Oui");OuiTumor.setUserData("Oui");
                    final RadioButton       NonTumor                     = new RadioButton("Non");NonTumor.setUserData("Non");
                                                                                                  NonTumor.setSelected(true);
                    OuiTumor.setToggleGroup(Tgroup6);   NonTumor.setToggleGroup(Tgroup6);
        grid.add(Tumorectomie,0,7);  grid.add(OuiTumor,1,7);  grid.add(NonTumor,2,7);
        
             autreR = this.champSaisierA();
             autreR.setPrefSize(200,80);
        grid.add(autreR,0,8); autreR.setPromptText("Autre (précise)");
        //
             
        date.setDayCellFactory(dayCellFactory);
        date.setValue(LocalDate.now());
       final Label DateRes      = new Label("Date : ");
       grid.add(DateRes,0,9);  grid.add(date,1,9);
             final Label          hopitale                              = new Label("Hôpital");
                   final RadioButton         bologhine          = new RadioButton("bologhine"); bologhine.setUserData("bologhine");
                   final RadioButton         CPMC               = new RadioButton("CPMC");      CPMC.setUserData("CPMC");
                   final RadioButton         autre              = new RadioButton("autre");     autre.setUserData("autre");
                                                                                                CPMC.setSelected(true);
                  autreHR = this.champSaisier();
                  autreHR.setPromptText("Préciser");autreHR.setVisible(false);
                   bologhine.setToggleGroup(Tgroup7); CPMC.setToggleGroup(Tgroup7); autre.setToggleGroup(Tgroup7);
        grid.add(hopitale,0,10); grid.add(bologhine,1,10); grid.add(CPMC, 2,10); grid.add(autre,3,10);
        grid.add(autreHR,4,10);
        Tgroup7.selectedToggleProperty().addListener((ObservableValue<? extends Toggle >ov,Toggle old_value,
        Toggle new_value)->{
            if(Tgroup7.getSelectedToggle().getUserData().equals("autre")){
                autreHR.setVisible(true);
            }else autreHR.setVisible(false);
        });
        Tgroup3.selectedToggleProperty().addListener((ObservableValue <? extends Toggle>ov , Toggle old_value,
           Toggle new_Vlaue)->{
            if(Tgroup3.getSelectedToggle().getUserData().equals("Non")){
              OuiSeg.setDisable(true);    OuiTumor.setDisable(true);   autreR.setDisable(true);autreR.setText("");
              NonSeg.setDisable(true);    NonTumor.setDisable(true);   date.setDisable(true);
                                                                      bologhine.setDisable(true);
              OuiHepat.setDisable(true);                              CPMC.setDisable(true);
              NonHepat.setDisable(true);                              autre.setDisable(true);autreHR.setDisable(true);
            }else {
              OuiSeg.setDisable(false);    OuiTumor.setDisable(false);   autreR.setDisable(false);
              NonSeg.setDisable(false);    NonTumor.setDisable(false);   date.setDisable(false);
                                                                         bologhine.setDisable(false);
              OuiHepat.setDisable(false);                                CPMC.setDisable(false);
              NonHepat.setDisable(false);                                autre.setDisable(false);autreHR.setDisable(false);
            }
            
            
        });
        
        
        final Label    TransplantationHepatique                      = new Label("Transplantation hépatique ");
        TransplantationHepatique.getStyleClass().add("setsttyleTraitementPpartie");
              final RadioButton       OuiTH                             = new RadioButton("Oui");OuiTH.setUserData("Oui");
              final RadioButton       NonTH                             = new RadioButton("Non");NonTH.setUserData("Non");
                                                                                                 OuiTH.setSelected(true);
              //////////////////////////
              // // // // // // // // //
        grid.add(TransplantationHepatique,0,11);  grid.add(OuiTH,1,11);  grid.add(NonTH,2,11);
            OuiTH.setToggleGroup(group12); NonTH.setToggleGroup(group12);
              final Label   donneurV                               = new Label("donneur vivant");
                    final RadioButton   OuiDV                         = new RadioButton("Oui");OuiDV.setUserData("Oui");
                    final RadioButton   NonDV                         = new RadioButton("Non");NonDV.setUserData("Non");
                                                                                               OuiDV.setSelected(true);
                    OuiDV.setToggleGroup(Tgroup9); NonDV.setToggleGroup(Tgroup9);
        grid.add(donneurV,3,11);  grid.add(OuiDV,4,11); grid.add(NonDV,5,11);
         
              //
        dateTH.setDayCellFactory(dayCellFactory);
        dateTH.setValue(LocalDate.now());
        final Label   DateTransp    =  new Label("Date :");
        grid.add(DateTransp,0,12);         grid.add(dateTH,1,12);
        
              final Label          hopitaleTH                            = new Label("Hôpital");
                   final RadioButton         bologhineTH                  = new RadioButton("bologhine");bologhineTH.setUserData("bologhine");
                   final RadioButton         CPMCTH                       = new RadioButton("CPMC");     CPMCTH.setUserData("CPMC");
                   final RadioButton         autreTH                      = new RadioButton("autre");    autreTH.setUserData("autre");
                                                                                                         bologhineTH.setSelected(true);
                   autreTHN = this.champSaisier();
                   autreTHN.setPromptText("Préciser");autreTHN.setVisible(false);
                   bologhineTH.setToggleGroup(Tgroup10); CPMCTH.setToggleGroup(Tgroup10); autreTH.setToggleGroup(Tgroup10);
        grid.add(hopitaleTH,0,13); grid.add(bologhineTH,1,13); grid.add(CPMCTH, 2,13); grid.add(autreTH,3,13);
        grid.add(autreTHN,4,13);
        Tgroup10.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value,
        Toggle new_vlaue)->{
           if(Tgroup10.getSelectedToggle().getUserData().equals("autre")){
               autreTHN.setVisible(true);
           }else autreTHN.setVisible(false);
           });
        group12.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value ,
        Toggle new_value)->{
          if(group12.getSelectedToggle().getUserData().equals("Non")){
           //OuiDV  NonDV bologhineTH  CPMCTH autreTH dateTH
              OuiDV.setDisable(true); NonDV.setDisable(true); bologhineTH.setDisable(true); 
              CPMCTH.setDisable(true); autreTH.setDisable(true); dateTH.setDisable(true);autreTHN.setDisable(true);
          }else {
              OuiDV.setDisable(false); NonDV.setDisable(false); bologhineTH.setDisable(false); 
              CPMCTH.setDisable(false); autreTH.setDisable(false); dateTH.setDisable(false);autreTHN.setDisable(false);
              
          }  
        });
        
        ///
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
                    IndIns.setText(" L’insertion des Traitements\n Propose (Chirurgie) au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Traitements de même type \n au niveau d'un dossier \n sur la même date ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(EchographiqueBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 5,15);
        grid.add(IndIns,4,2,4,4);
        ///
        /////
        Tgroup2.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov ,Toggle old_value,
        Toggle new_value)-> {
            if(Tgroup2.getSelectedToggle().getUserData().equals("Non")){
                grid.getChildren().removeAll(Resection,OuiR,NonR,SiOui,Segmetectomie,OuiSeg,NonSeg,
                        Hepatectomie,OuiHepat,NonHepat,Tumorectomie,OuiTumor,NonTumor,autreR,date,hopitale,
                        bologhine,CPMC,autre,autreHR,TransplantationHepatique,OuiTH,NonTH,donneurV,OuiDV,NonDV,dateTH,
                        hopitaleTH,CPMCTH,bologhineTH,autreTH,autreTHN,Ajouter,DateRes,DateTransp ,IndIns);
            }else {
                grid.getChildren().addAll   (Resection,OuiR,NonR,SiOui,Segmetectomie,OuiSeg,NonSeg,
                        Hepatectomie,OuiHepat,NonHepat,Tumorectomie,OuiTumor,NonTumor,autreR,date,hopitale,
                        bologhine,CPMC,autre,autreHR,TransplantationHepatique,OuiTH,NonTH,donneurV,OuiDV,NonDV,dateTH,
                        hopitaleTH,CPMCTH,bologhineTH,autreTH,autreTHN,Ajouter,DateRes,DateTransp,IndIns);
            }
            
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////  La Partie De La Consultation    //////////////////////////////////////////////////////////////////////////
    final GridPane        gridC    = new GridPane();
    gridC.setVgap(10);
    gridC.setHgap(7);
    
     final Label ConsDateTrait                = new Label("Date du traitement                 :") ;
     final Label ConsChirurgie                = new Label("Chirurgie                          :") ;
     final Label ConsResection                = new Label("Résection                          :") ;
     final Label ConsSegmetectomie            = new Label("Segmetectomie                      :") ;
     final Label ConsHepatectomie             = new Label("Hepatectomie                       :") ;
     final Label ConsTumorectomie             = new Label("Tumorectomie                       :") ;
     final Label ConsAutresRes                = new Label("Autres                             :") ;
     final Label ConsDateRes                  = new Label("Date                               :") ;
     final Label ConsHopital                  = new Label("Hôpital                            :") ;
     final Label ConsPreciseAutresHopital     = new Label("Preciser Autre Hopital             :") ;
     final Label ConsTransplantation          = new Label("Transplantation hépatique          :") ;
     final Label ConsVieDonneur               = new Label("Donneur vivant                     :"); 
     final Label ConsDateTransplantation      = new Label("Date Transplantaion                :");
     final Label ConsHopitalTransplantation   = new Label("Hôpital                            :");
     final Label ConsAutreHopitalTransp       = new Label("Autres  Hopitale                   :");
    
     final Label ChirurgieLabel               = new Label("Chirurgie :");
     ChirurgieLabel.getStyleClass().add("setStyleCirconsanceDic");
  gridC.add(ChirurgieLabel, 0,0);
  gridC.add(ConsDateTrait , 0,1);                          gridC.add(TDateTrait,5,1);
  gridC.add(ConsChirurgie , 0,2);                          gridC.add(TChirurgie,5,2);
  gridC.add(ConsResection, 0,3);                           gridC.add(TResection,5,3);
  ConsResection.getStyleClass().add("styleLabel");
  gridC.add(ConsSegmetectomie,0, 4);                       gridC.add(TSegmetectomie,5,4);
  gridC.add(ConsHepatectomie,0,5);                         gridC.add(THepatectomie,5,5);
  gridC.add(ConsTumorectomie  ,0, 6);                      gridC.add(TTumorectomie , 5,6);
  gridC.add(ConsAutresRes , 0,7);                          gridC.add(TAutresRes , 5,7);
  gridC.add(ConsDateRes , 0,8);                            gridC.add(TDateRes , 5,8);
  gridC.add(ConsHopital , 0,9);                            gridC.add(THopital , 5,9);
  gridC.add(ConsPreciseAutresHopital , 0,10);              gridC.add(TPreciseAutresHopital ,5,10);  
  gridC.add(ConsTransplantation , 0,11);                   gridC.add(TTransplantation , 5,11);
  ConsTransplantation.getStyleClass().add("styleLabel");
  gridC.add(ConsVieDonneur , 0,12);                        gridC.add(TVieDonneur , 5,12);  
  gridC.add(ConsDateTransplantation , 0,13);               gridC.add(TDateTransplantation ,5, 13);
  gridC.add(ConsHopitalTransplantation ,0, 14);            gridC.add(THopitalTransplantation ,5, 14);  
  gridC.add(ConsAutreHopitalTransp , 0,15);                gridC.add(TAutreHopitalTransp , 5,15);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
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
        gridC.add(barOutil,6,18,2,2);
        gridC.add(vbMod, 0,18,5,2);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
     }
         ///////////////
         
         ///////////////
        
    }
    

    public String getChirurgie() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getResection() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getSegMetectomie() {
        if(getResection().equals("Oui"))
        return Tgroup4.getSelectedToggle().getUserData().toString();
        else 
        return "";
    }

    public String getHepatectomie() {
       if(getResection().equals("Oui"))
       return Tgroup5.getSelectedToggle().getUserData().toString(); 
       else 
       return "";
    }

    public String getTumorectomie() {
       if(getResection().equals("Oui"))
       return Tgroup6.getSelectedToggle().getUserData().toString(); 
       else 
       return "";
    }


    public String getAutreR() {
        if(getResection().equals("Oui"))
        return autreR.getText();
        else
        return "";
    }

    public String getDate() {
        if(getResection().equals("Oui"))
        return "'"+date.getValue()+"'";
        else
        return null;
        
    }

    public String getHopitalRes() {
        if(getResection().equals("Oui"))
       return Tgroup7.getSelectedToggle().getUserData().toString();
        else return "";   
    }
    

    public String getAutreHR() {
        if(getResection().equals("Oui"))
        return autreHR.getText();
        else 
        return "";
    }

    public String getTransplH() {
        return group12.getSelectedToggle().getUserData().toString();
    }

    public String getDonneurV() {
        if(getTransplH().equals("Oui"))
        return Tgroup9.getSelectedToggle().getUserData().toString();
        else
        return "";
    }

    public String getDateTH() {
        if(getTransplH().equals("Oui"))
        return "'"+dateTH.getValue()+"'";
        else return null;
    }

    public String getHopitalTH() {
        if(getTransplH().equals("Oui"))
        return Tgroup10.getSelectedToggle().getUserData().toString();
        else return "";
    }
    public String getAutreTHN() {
        if(getTransplH().equals("Oui"))
        return autreTHN.getText();
        else return "";
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    

    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getChirurgie()+"\n"+this.getResection()+"\n"+this.getSegMetectomie()+"\n"+this.getHepatectomie()+"\n"+
                this.getTumorectomie()+"\n"+this.getAutreR()+"\n"+this.getDate()+"\n"+this.getHopitalRes()+"\n"+this.getDateTH()+"\n"+
                this.getHopitalTH()+"\n");
        
        MiseAjour bddInsert  =  new MiseAjour();
        int  i =bddInsert.AddElement("Insert into Chirurgie values (0,'"+this.getChirurgie()+"','"+this.getResection()+"','"+this.getSegMetectomie()+"','"+this.getHepatectomie()+"','"+
                this.getTumorectomie()+"','"+this.getAutreR()+"',"+this.getDate()+",'"+this.getHopitalRes()+"','"+this.getAutreHR()+"','"+this.getTransplH()+"','"+this.getDonneurV()+"',"+this.getDateTH()+",'"+
                this.getHopitalTH()+"','"+this.getAutreTHN()+"','"+NumDossier+"','"+this.getDateB()+"')");
        
        return i;
        
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
          public TextField champSaisier(){
 TextField textA = new TextField(){
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
          /////////////////////////////////////////////////////////////////////////////////////////////////////////////
          //  Les Méthodes de Consultation     ////////////////////////////////////////////////////////////////////////
    public void setTDateTrait(String a) {
        TDateTrait.setText(a);
    }

    public void setTChirurgie(String a) {
        TChirurgie.setText(a);
    }

    public void setTResection(String a) {
        TResection.setText(a);
    }

    public void setTSegmetectomie(String a) {
        TSegmetectomie.setText(a);
    }

    public void setTHepatectomie(String a) {
        THepatectomie.setText(a);
    }

    public void setTTumorectomie(String a) {
        TTumorectomie.setText(a);
    }

    public void setTAutresRes(String a) {
        TAutresRes.setText(a);
    }

    public void setTDateRes(String a) {
        TDateRes.setText(a);
    }

    public void setTHopital(String a) {
        THopital.setText(a);
    }

    public void setTPreciseAutresHopital(String a) {
        TPreciseAutresHopital.setText(a);
    }

    public void setTTransplantation(String a) {
        TTransplantation.setText(a);
    }

    public void setTVieDonneur(String a) {
        TVieDonneur.setText(a);
    }

    public void setTDateTransplantation(String a) {
        TDateTransplantation.setText(a);
    }

    public void setTHopitalTransplantation(String a) {
        THopitalTransplantation.setText(a);
    }

    public void setTAutreHopitalTransp(String a) {
        TAutreHopitalTransp.setText(a);
    }

 public void ConsultationE(String NumDossier) throws SQLException{
        
        ChirurgieClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from chirurgie where NumDossier = '"+NumDossier+"'"
                                           +"and DateTrait = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new ChirurgieClasse(res.getDate(17),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12)
     ,res.getString(13),res.getString(14),res.getString(15)
     );
}
    try{
      this.setTDateTrait(Bilan.getTDateTrait().toString());
      this.setTChirurgie(Bilan.getTChirurgie());
      this.setTResection(Bilan.getTResection());
      this.setTSegmetectomie(Bilan.getTSegmetectomie());
      this.setTHepatectomie(Bilan.getTHepatectomie());
      this.setTTumorectomie(Bilan.getTTumorectomie());
      this.setTAutresRes(Bilan.getTAutresRes());
      this.setTDateRes(Bilan.getTDateRes());
      this.setTHopital(Bilan.getTHopital());
      this.setTPreciseAutresHopital(Bilan.getTPreciseAutresHopital());
      this.setTTransplantation(Bilan.getTTransplantation());
      this.setTVieDonneur(Bilan.getTVieDonneur());
      this.setTDateTransplantation(Bilan.getTDateTransplantation());
      this.setTHopitalTransplantation(Bilan.getTHopitalTransplantation());
      this.setTAutreHopitalTransp(Bilan.getTAutreHopitalTransp());
    }catch(Exception e){
      this.setTDateTrait("--------------");
      this.setTChirurgie("--------------");
      this.setTResection("--------------");
      this.setTSegmetectomie("--------------");
      this.setTHepatectomie("--------------");
      this.setTTumorectomie("--------------");
      this.setTAutresRes("--------------");
      this.setTDateRes("--------------");
      this.setTHopital("--------------");
      this.setTPreciseAutresHopital("--------------");
      this.setTTransplantation("--------------");
      this.setTVieDonneur("--------------");
      this.setTDateTransplantation("--------------");
      this.setTHopitalTransplantation("--------------");
      this.setTAutreHopitalTransp("--------------");
    }
         }

             public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from chirurgie where NumDossier ='"+NumDossier+"' and dateTrait ='"+DateInsBilan+"'" );
            
            return j;
        }    
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
}
