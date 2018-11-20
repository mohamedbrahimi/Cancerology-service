
package service.medicament.TraitementProposer;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import service.medicament.BilanPatient.BilanBiologique;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class TherapieCibles extends Parent{
    
                   final DatePicker         DateB              = new DatePicker();   
                   final ToggleGroup        Tgroup1            = new ToggleGroup();
                   final DatePicker         date               = new DatePicker(); 
                   final TextField          txtDrogue          ;
                   final TextField          txtPosologie       ;
                   final DatePicker         DateTRT            = new DatePicker(); 
                   final ToggleGroup        Tgroup2            = new ToggleGroup();
                   final ToggleGroup        Tgroup3            = new ToggleGroup();
                   final ToggleGroup        Tgroup4            = new ToggleGroup();
                   final ToggleGroup        Tgroup5            = new ToggleGroup();
                   final ToggleGroup        Tgroup6            = new ToggleGroup();
                   final ToggleGroup        Tgroup7            = new ToggleGroup();
                   final ToggleGroup        Tgroup8            = new ToggleGroup();
                   final ToggleGroup        Tgroup9            = new ToggleGroup();
                   final ToggleGroup        Tgroup10           = new ToggleGroup();
                   
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
       
       
       //////////////////////////////////////////////////////////////////////////////////////////////////////////
       ////  La Partie Consultation /////////////////////////////////////////////////////////////////////////////
     private final Label TDateTrait        = new Label() ;
     private final Label TTherapieCible    = new Label() ;
     private final Label TTCDate           = new Label() ;
     private final Label TTCDrogue         = new Label() ;
     private final Label TTCPosologie      = new Label() ;
     private final Label TTCDateDebTRT     = new Label() ;
     private final Label TTcSMP            = new Label() ;
     private final Label TTCDiarree        = new Label() ;
     private final Label TGlobuleBlanche   = new Label() ;
     private final Label TGraulocytes      = new Label() ;
     private final Label TLymphocytes      = new Label() ;
     private final Label TPlaquette        = new Label() ;
     private final Label THemoglobines     = new Label() ;
     private final Label THemorragies      = new Label() ;
     private final Label TTCCutanees       = new Label() ;
       
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
 
       //////////////////////////////////////////////////////////////////////////////////////////////////////////

    final String DateInsBilan;
    public TherapieCibles(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
     
        this.DateInsBilan = DateInsBilan ;
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
        
        final GridPane             grid               = new GridPane();grid.setVgap(5); grid.setHgap(5);
        final Label                TherapieCibles     = new Label("THERAPIES CIBLES ");TherapieCibles.getStyleClass().add("setsttyleTraitementPpartie");
              final RadioButton        OuiTHC             = new RadioButton("Oui");OuiTHC.setUserData("Oui"); OuiTHC.setSelected(true);
              final RadioButton        NonTHC             = new RadioButton("Non");NonTHC.setUserData("Non");
              
              OuiTHC.setToggleGroup(Tgroup1);   NonTHC.setToggleGroup(Tgroup1);
        grid.add(TherapieCibles,0,0);  grid.add(OuiTHC,1,0);  grid.add(NonTHC,2,0);
        
        final Label   DateTH     =  new Label("Date : ");//
        date.setDayCellFactory(dayCellFactory);  date.setValue(LocalDate.now());
        date.setPromptText("Date");
        grid.add(DateTH,0,1);grid.add(date,1,1,3,1);
        final Label                drogue             = new Label("Drogue :");    grid.add(drogue,0,2);      txtDrogue     = this.champSaisier(); txtDrogue.setPromptText("Drogue ");       grid.add(txtDrogue,1,2,3,1);
        final Label                Posologie          = new Label("Posologie :"); grid.add(Posologie , 0,3); txtPosologie  = this.champSaisier(); txtPosologie.setPromptText("Posologie "); grid.add(txtPosologie,1,3,3,1);
        
        final Label   DateTRTlAB      = new Label("Date De Debut De TRT ");
        grid.add(DateTRTlAB, 0,4);  grid.add(DateTRT,1,4,3,1);DateTRT.setValue(LocalDate.now());
        DateTRT.setDayCellFactory(dayCellFactory);
        
        final Label                Incident           = new Label("Incidents : Toxicité ");
        grid.add(Incident,0,5);
        
        final Label                SMP                = new Label("-SMP");          SMP.getStyleClass().add("setsttyleTraitementPpartie");
              final Label     GradSMP                    = new Label("Grade");
                   final RadioButton       Gsmp1               = new RadioButton("0");  Gsmp1.setUserData("0");
                   final RadioButton       Gsmp2               = new RadioButton("1");  Gsmp2.setUserData("1");
                   final RadioButton       Gsmp3               = new RadioButton("2");  Gsmp3.setUserData("2"); 
                   final RadioButton       Gsmp4               = new RadioButton("3");  Gsmp4.setUserData("3");
                   Gsmp1.setTooltip(new Tooltip("Grade"));                              Gsmp1.setSelected(true);
                    Gsmp1.setToggleGroup(Tgroup2); Gsmp2.setToggleGroup(Tgroup2); Gsmp3.setToggleGroup(Tgroup2); Gsmp4.setToggleGroup(Tgroup2);
        grid.add(SMP, 0,6); grid.add(Gsmp1, 1,6); grid.add(Gsmp2, 2,6); grid.add(Gsmp3, 3,6); grid.add(Gsmp4, 4,6);
              
        final Label                Diarrhee           = new Label("-Diarrhées");    Diarrhee.getStyleClass().add("setsttyleTraitementPpartie");
              final Label     GradDiar                    = new Label("Grade");
                   final RadioButton       Gdiar1               = new RadioButton("0"); Gdiar1.setUserData("0");
                   final RadioButton       Gdiar2               = new RadioButton("1"); Gdiar2.setUserData("1");
                   final RadioButton       Gdiar3               = new RadioButton("2"); Gdiar3.setUserData("2");
                   final RadioButton       Gdiar4               = new RadioButton("3"); Gdiar4.setUserData("3");
                   Gdiar1.setTooltip(new Tooltip("Grade"));                             Gdiar1.setSelected(true);
                   
                   Gdiar1.setToggleGroup(Tgroup3);  Gdiar2.setToggleGroup(Tgroup3);  Gdiar3.setToggleGroup(Tgroup3);
                   Gdiar4.setToggleGroup(Tgroup3);

        grid.add(Diarrhee, 0,7); grid.add(Gdiar1, 1,7); grid.add(Gdiar2, 2,7); grid.add(Gdiar3, 3,7); grid.add(Gdiar4, 4,7);
        
        final Label                hematologique      = new Label("Hématologiques"); hematologique.getStyleClass().add("setsttyleTraitementPpartie");
        grid.add(hematologique,0,9);
        
                
        ///
        final Label                GB                 = new Label("Globules blancs    "); 
              final Label     GradGB                    = new Label("Grade");
                   final RadioButton       Ggb1                = new RadioButton("0");    Ggb1.setUserData("0");
                   final RadioButton       Ggb2                = new RadioButton("1");    Ggb2.setUserData("1");
                   final RadioButton       Ggb3                = new RadioButton("2");    Ggb3.setUserData("2");
                   final RadioButton       Ggb4                = new RadioButton("3");    Ggb4.setUserData("3");
                   Ggb1.setTooltip(new Tooltip("Grade"));                                 Ggb1.setSelected(true);
                   Ggb1.setToggleGroup(Tgroup4); Ggb2.setToggleGroup(Tgroup4); Ggb3.setToggleGroup(Tgroup4);
                   Ggb4.setToggleGroup(Tgroup4);
        grid.add(GB, 0,10); grid.add(Ggb1, 1,10); grid.add(Ggb2, 2,10); grid.add(Ggb3, 3,10); grid.add(Ggb4, 4,10);
        
        final Label                Graulocytes           = new Label("Graulocytes ");    
              final Label     Ggraul                       = new Label("Grade");
                   final RadioButton       Ggraul1               = new RadioButton("0");    Ggraul1.setUserData("0");
                   final RadioButton       Ggraul2               = new RadioButton("1");    Ggraul2.setUserData("1");
                   final RadioButton       Ggraul3               = new RadioButton("2");    Ggraul3.setUserData("2");
                   final RadioButton       Ggraul4               = new RadioButton("3");    Ggraul4.setUserData("3");
                   Ggraul1.setTooltip(new Tooltip("Grade"));                                Ggraul1.setSelected(true);
                   
                   Ggraul1.setToggleGroup(Tgroup5);Ggraul2.setToggleGroup(Tgroup5); Ggraul3.setToggleGroup(Tgroup5);
                   Ggraul4.setToggleGroup(Tgroup5);
        grid.add(Graulocytes, 0,11); grid.add(Ggraul1, 1,11); grid.add(Ggraul2, 2,11); grid.add(Ggraul3,3, 11); grid.add(Ggraul4, 4,11);
        
        final Label                Lymphocytes          = new Label(" Lymphocytes");    
              final Label     GradL                        = new Label("Grade");
                   final RadioButton       GL1                   = new RadioButton("0"); GL1.setUserData("0");
                   final RadioButton       GL2                   = new RadioButton("1"); GL2.setUserData("1");
                   final RadioButton       GL3                   = new RadioButton("2"); GL3.setUserData("2");
                   final RadioButton       GL4                   = new RadioButton("3"); GL4.setUserData("3");
                   GL1.setTooltip(new Tooltip("Grade"));                                 GL1.setSelected(true);
                   
                   GL1.setToggleGroup(Tgroup6); GL2.setToggleGroup(Tgroup6); GL3.setToggleGroup(Tgroup6);
                   GL4.setToggleGroup(Tgroup6);
        grid.add(Lymphocytes, 0,12); grid.add(GL1, 1,12); grid.add(GL2, 2,12); grid.add(GL3, 3,12); grid.add(GL4, 4,12);
        
        final Label                Plaquete            = new Label(" Plaquettes ");    
              final Label     Gradp                    = new Label("Grade");
                   final RadioButton       Gp1               = new RadioButton("0");     Gp1.setUserData("0");
                   final RadioButton       Gp2               = new RadioButton("1");     Gp2.setUserData("1");
                   final RadioButton       Gp3               = new RadioButton("2");     Gp3.setUserData("2");
                   final RadioButton       Gp4               = new RadioButton("3");     Gp4.setUserData("3");
                   Gp1.setTooltip(new Tooltip("Grade"));                                 Gp1.setSelected(true);
                   
                   Gp1.setToggleGroup(Tgroup7); Gp2.setToggleGroup(Tgroup7); Gp3.setToggleGroup(Tgroup7);
                   Gp4.setToggleGroup(Tgroup7);
        grid.add(Plaquete, 0,13); grid.add(Gp1, 1,13); grid.add(Gp2, 2,13); grid.add(Gp3, 3,13); grid.add(Gp4, 4,13);
        
        final Label                Hemoglobines           = new Label("Hemoglobines");    
              final Label     Gradh                    = new Label("Grade");
                   final RadioButton       Gh1               = new RadioButton("0");    Gh1.setUserData("0");
                   final RadioButton       Gh2               = new RadioButton("1");    Gh2.setUserData("1");
                   final RadioButton       Gh3               = new RadioButton("2");    Gh3.setUserData("2");
                   final RadioButton       Gh4               = new RadioButton("3");    Gh4.setUserData("3");
                   Gh1.setTooltip(new Tooltip("Grade"));                                Gh1.setSelected(true);
                   
                   Gh1.setToggleGroup(Tgroup8); Gh2.setToggleGroup(Tgroup8); Gh3.setToggleGroup(Tgroup8);
                   Gh4.setToggleGroup(Tgroup8);
        grid.add(Hemoglobines, 0,14); grid.add(Gh1, 1,14); grid.add(Gh2, 2,14); grid.add(Gh3, 3,14); grid.add(Gh4, 4,14);
        
        final Label                Hemorragies           = new Label("Hemorragies");   
              final Label     Gradhem                    = new Label("Grade");
                   final RadioButton       Ghem1               = new RadioButton("0");  Ghem1.setUserData("0");
                   final RadioButton       Ghem2               = new RadioButton("1");  Ghem2.setUserData("1"); 
                   final RadioButton       Ghem3               = new RadioButton("2");  Ghem3.setUserData("2");
                   final RadioButton       Ghem4               = new RadioButton("3");  Ghem4.setUserData("3");
                   Ghem1.setTooltip(new Tooltip("Grade"));                              Ghem1.setSelected(true);
                   
                   Ghem1.setToggleGroup(Tgroup9); Ghem2.setToggleGroup(Tgroup9); Ghem3.setToggleGroup(Tgroup9);
                   Ghem4.setToggleGroup(Tgroup9);
        grid.add(Hemorragies, 0,15); grid.add(Ghem1, 1,15); grid.add(Ghem2, 2,15); grid.add(Ghem3, 3,15); grid.add(Ghem4, 4,15);
        
        final Label                Cutanee           = new Label("cutanées");    Cutanee.getStyleClass().add("setsttyleTraitementPpartie");
              final Label     Gradc                    = new Label("Grade");
                   final RadioButton       Gc1               = new RadioButton("0");  Gc1.setUserData("0");
                   final RadioButton       Gc2               = new RadioButton("1");  Gc2.setUserData("1");  
                   final RadioButton       Gc3               = new RadioButton("2");  Gc3.setUserData("2");
                   final RadioButton       Gc4               = new RadioButton("3");  Gc4.setUserData("3");
                    Gc1.setTooltip(new Tooltip("Grade"));                             Gc1.setSelected(true);
                   
                   Gc1.setToggleGroup(Tgroup10); Gc2.setToggleGroup(Tgroup10); Gc3.setToggleGroup(Tgroup10);
                   Gc4.setToggleGroup(Tgroup10);
        grid.add(Cutanee, 0,17); grid.add(Gc1, 1,17); grid.add(Gc2, 2,17); grid.add(Gc3, 3,17); grid.add(Gc4, 4,17);
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
                    IndIns.setText(" L’insertion des Traitements\n Propose (Therapies Cibles) \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Traitements de même type \n au niveau d'un dossier \n sur la même date ");
                   } 
            } catch (SQLException ex) {
                Logger.getLogger(TherapieCibles.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 8,19);
        grid.add(IndIns, 6,5,5,7);
        ///
        Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value,
        Toggle new_value)->{
            if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
            grid.getChildren().removeAll(date,drogue,Posologie,DateTRT,Incident,SMP,GradSMP,Gsmp1,Gsmp2,Gsmp3,Gsmp4,Diarrhee,
        GradDiar,Gdiar1,Gdiar2,Gdiar3,Gdiar4,hematologique,GB,GradGB,Ggb1,Ggb2,Ggb3,Ggb4,Graulocytes,Ggraul,
        Ggraul1,Ggraul2,Ggraul3,Ggraul4,Lymphocytes,GradL,GL1,GL2,GL3,GL4,Plaquete,Gradp,Gp1,Gp2,Gp3,Gp4,
        Hemoglobines,Gradh,Gh1,Gh2,Gh3,Gh4,Hemorragies,Gradhem,Ghem1,Ghem2,Ghem3,Ghem4,Cutanee,Gradc,Gc1,Gc2,
        Gc3,Gc4,Ajouter,DateTH,DateTRTlAB,txtDrogue,txtPosologie,IndIns);
            }else {
            grid.getChildren().addAll(date,drogue,Posologie,DateTRT,Incident,SMP,GradSMP,Gsmp1,Gsmp2,Gsmp3,Gsmp4,Diarrhee,
        GradDiar,Gdiar1,Gdiar2,Gdiar3,Gdiar4,hematologique,GB,GradGB,Ggb1,Ggb2,Ggb3,Ggb4,Graulocytes,Ggraul,
        Ggraul1,Ggraul2,Ggraul3,Ggraul4,Lymphocytes,GradL,GL1,GL2,GL3,GL4,Plaquete,Gradp,Gp1,Gp2,Gp3,Gp4,
        Hemoglobines,Gradh,Gh1,Gh2,Gh3,Gh4,Hemorragies,Gradhem,Ghem1,Ghem2,Ghem3,Ghem4,Cutanee,Gradc,Gc1,Gc2,
        Gc3,Gc4,Ajouter,DateTH,DateTRTlAB,txtDrogue,txtPosologie,IndIns);
            }
            
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        /// La Partie Consultation   //////////////////////////////////////////////////////////////////////////////
    final GridPane        gridC    = new GridPane();
    gridC.setVgap(10);
    gridC.setHgap(7);
    
      final Label ConsDateTrait            = new Label("Date thérapies ciles                 :") ;
      final Label ConsTherapieCible        = new Label("THERAPIES CIBLES                     :") ;
      final Label ConsTCDate               = new Label("Date                                 :") ;
      final Label ConsTCDrogue             = new Label("Droque                               :") ;
      final Label ConsTCPosologie          = new Label("Posologie                            :") ;
      final Label ConsTCDateDebTRT         = new Label("Date de début du TRT                 :") ;
      final Label ConsTcSMP                = new Label("SMP                                  :") ;
      final Label ConsTCDiarree            = new Label("Diarrhées                            :") ;
      final Label ConsGlobuleBlanche       = new Label("Globule blanche                      :") ;
      final Label ConsGraulocytes          = new Label("Graulocytes                          :") ;
      final Label ConsLymphocytes          = new Label("Lymphocytes                          :") ;
      final Label ConsPlaquette            = new Label("Plaquettes                           :") ;
      final Label ConsHemoglobines         = new Label("Hemoglobines                         :") ;
      final Label ConsHemorragies          = new Label("Hemorragies                          :") ;
      final Label ConsTCCutanees           = new Label("Cutanées                             :") ; 
        
  final Label TherapieLabel         = new Label("THERAPIES CIBLES  :");
  TherapieLabel.getStyleClass().add("setStyleCirconsanceDic");
  
  gridC.add(TherapieLabel,0,0);
  gridC.add(ConsDateTrait, 0,1) ;                           gridC.add(TDateTrait, 5,1);
  gridC.add(ConsTherapieCible , 0, 2);                      gridC.add(TTherapieCible,5,2);
  gridC.add(ConsTCDate , 0, 3);                             gridC.add(TTCDate,5,3);
  gridC.add(ConsTCDrogue, 0, 4);                            gridC.add(TTCDrogue,5,4);
  gridC.add(ConsTCPosologie, 0, 5);                         gridC.add(TTCPosologie,5,5);
  gridC.add(ConsTCDateDebTRT,0, 6);                         gridC.add(TTCDateDebTRT,5,6);
  gridC.add(ConsTcSMP  , 0, 7);                             gridC.add(TTcSMP , 5,7);
  gridC.add(ConsTCDiarree , 0,8 );                          gridC.add(TTCDiarree ,5, 8);
  gridC.add(ConsGlobuleBlanche , 0, 9);                     gridC.add(TGlobuleBlanche ,5, 9);
  gridC.add(ConsGraulocytes , 0, 10);                       gridC.add(TGraulocytes , 5,10);
  gridC.add(ConsLymphocytes , 0, 11);                       gridC.add(TLymphocytes ,5,11);
  gridC.add(ConsPlaquette , 0, 12);                         gridC.add(TPlaquette , 5,12);
  gridC.add(ConsHemoglobines , 0, 13);                      gridC.add(THemoglobines ,5, 13);
  gridC.add(ConsHemorragies , 0, 14);                       gridC.add(THemorragies ,  5,14);
  gridC.add(ConsTCCutanees , 0, 15);                        gridC.add(TTCCutanees ,  5,15);
    
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

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        gridC.add(barOutil, 6,18,2,2);
        gridC.add(vbMod,0,18,5,3);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
     }
    }
    

    public String getTherapieCible() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDate() {
        return date.getValue();
    }

    public String getTxtDrogue() {
        return txtDrogue.getText();
    }

    public String getTxtPosologie() {
        return txtPosologie.getText();
    }
    

    public LocalDate getDateTRT() {
        return DateTRT.getValue();
    }

    public String getSMP() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getDiarrhee() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getGlobuleBlanch() {
        return Tgroup4.getSelectedToggle().getUserData().toString();
    }

    public String getGraulocyte() {
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }

    public String getLymphocyt() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getHemoglbine() {
        return Tgroup8.getSelectedToggle().getUserData().toString();
    }

    public String getPlaquet() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }

    public String getHemorragie() {
        return Tgroup9.getSelectedToggle().getUserData().toString();
    }

    public String getCutanee() {
        return Tgroup10.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
     System.out.println(this.getTherapieCible()+"\n"+this.getDate()+"\n"+this.getDateTRT()+"\n"+this.getSMP()+"\n"+
             this.getDiarrhee()+"\n"+this.getGlobuleBlanch()+"\n"+this.getGraulocyte()+"\n"+this.getLymphocyt()+"\n"+
             this.getPlaquet()+"\n"+this.getHemoglbine()+"\n"+this.getHemorragie()+"\n"+this.getCutanee()+"\n"+""+""+""+"");
    
    MiseAjour   bddInsert    = new MiseAjour();
    int i = bddInsert.AddElement("Insert into TherapiesCibles values (0,'"+this.getTherapieCible()+"','"+this.getDate()+"','"+this.getTxtDrogue()+"','"+this.getTxtPosologie()+"','"+
            this.getDateTRT()+"','"+this.getSMP()+"','"+
            this.getDiarrhee()+"','"+this.getGlobuleBlanch()+"','"+this.getGraulocyte()+"','"+this.getLymphocyt()+"','"+
            this.getPlaquet()+"','"+this.getHemoglbine()+"','"+this.getHemorragie()+"','"+this.getCutanee()+"','"+NumDossier+"','"+this.getDateB()+"')");
    
    return i ;
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
     
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //// La Partie Consultation  //////////////////////////////////////////////////////////////////////////////////////
     
     public void setTDateTrait(String a) {
        TDateTrait.setText(a);
    }

    public void setTTherapieCible(String a ) {
        TTherapieCible.setText(a);
    }

    public void setTTCDate(String a) {
        TTCDate.setText(a);
    }

    public void setTTCDrogue(String a) {
        TTCDrogue.setText(a);
    }

    public void setTTCPosologie(String a) {
        TTCPosologie.setText(a);
    }

    public void setTTCDateDebTRT(String a) {
        TTCDateDebTRT.setText(a);
    }

    public void setTTcSMP(String a) {
        TTcSMP.setText(a);
    }

    public void setTTCDiarree(String a) {
        TTCDiarree.setText(a);
    }

    public void setTGlobuleBlanche(String a) {
        TGlobuleBlanche.setText(a);
    }

    public void setTGraulocytes(String a) {
        TGraulocytes.setText(a);
    }

    public void setTLymphocytes(String a) {
        TLymphocytes.setText(a);
    }

    public void setTPlaquette(String a) {
        TPlaquette.setText(a);
    }

    public void setTHemoglobines(String a) {
        THemoglobines.setText(a);
    }

    public void setTHemorragies(String a) {
        THemorragies.setText(a);
    }

    public void setTTCCutanees(String a) {
        TTCCutanees.setText(a);
    }
    
    
   public void ConsultationE(String NumDossier) throws SQLException{
        
        TherapieCiblesClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from TherapiesCibles where NumDossier = '"+NumDossier+"'"
                                           +"and DateTrait = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new TherapieCiblesClasse(res.getDate(17),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12)
     ,res.getString(13),res.getString(14),res.getString(15)
     );
} 
    try{
    this.setTDateTrait(Bilan.getTDateTrait().toString());
    this.setTTherapieCible(Bilan.getTTherapieCible());
    this.setTTCDate(Bilan.getTTCDate());
    this.setTGlobuleBlanche(Bilan.getTGlobuleBlanche());
    this.setTGraulocytes(Bilan.getTGraulocytes());
    this.setTHemoglobines(Bilan.getTHemoglobines());
    this.setTHemorragies(Bilan.getTHemorragies());
    this.setTLymphocytes(Bilan.getTLymphocytes());
    this.setTPlaquette(Bilan.getTPlaquette());
    this.setTTCCutanees(Bilan.getTTCCutanees());
    this.setTTCDateDebTRT(Bilan.getTTCDateDebTRT());
    this.setTTCDiarree(Bilan.getTTCDiarree());
    this.setTTCDrogue(Bilan.getTTCDrogue());
    this.setTTcSMP(Bilan.getTTcSMP());
    this.setTTCPosologie(Bilan.getTTCPosologie());
    }catch(Exception e){
         this.setTDateTrait("-------------");
    this.setTTherapieCible("-------------");
    this.setTTCDate("-------------");
    this.setTGlobuleBlanche("-------------");
    this.setTGraulocytes("-------------");
    this.setTHemoglobines("-------------");
    this.setTHemorragies("-------------");
    this.setTLymphocytes("-------------");
    this.setTPlaquette("-------------");
    this.setTTCCutanees("-------------");
    this.setTTCDateDebTRT("-------------");
    this.setTTCDiarree("-------------");
    this.setTTCDrogue("-------------");
    this.setTTcSMP("-------------");
    this.setTTCPosologie("-------------");   
    } 
}
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from TherapiesCibles where NumDossier ='"+NumDossier+"' and dateTrait ='"+DateInsBilan+"'" );
            
            return j;
        }   
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
}
