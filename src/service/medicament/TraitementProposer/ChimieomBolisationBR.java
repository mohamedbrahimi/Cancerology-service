
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
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class ChimieomBolisationBR extends Parent{
    final       String         styleLabel   =     " -fx-font: 16 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           + " -fx-background-color: gray;"
                                           + " -fx-text-fill: white;"
                                           + " -fx-border-radius: 5;";
    
              final DatePicker    DateB            = new DatePicker();      
              final ToggleGroup   Tgroup1          = new ToggleGroup();
              final DatePicker    dateCh           = new DatePicker();
              final TextField     txtDrogue        ;
              final TextField     txtPosologie     ;
              final DatePicker    DateDebutTRT     = new DatePicker(); 
              final ToggleGroup   Tgroup3          = new ToggleGroup();
              final ToggleGroup   Tgroup4          = new ToggleGroup();
              final ToggleGroup   Tgroup5          = new ToggleGroup();
              final ToggleGroup   Tgroup6          = new ToggleGroup();
              final TextArea      autreIncident    ;
              final ToggleGroup   Tgroup7          = new ToggleGroup();
              final ToggleGroup   Tgroup8          = new ToggleGroup();
              final ToggleGroup   Tgroup9          = new ToggleGroup();
              final ToggleGroup   Tgroup10         = new ToggleGroup();
              final ToggleGroup   Tgroup11         = new ToggleGroup();
              final ToggleGroup   Tgroup12         = new ToggleGroup();
              final ToggleGroup   Tgroup13         = new ToggleGroup();
              final ToggleGroup   Tgroup14         = new ToggleGroup();
              final ToggleGroup   Tgroup15         = new ToggleGroup();
              final ToggleGroup   Tgroup16         = new ToggleGroup();
              final ToggleGroup   Tgroup17         = new ToggleGroup();
              final ToggleGroup   Tgroup18         = new ToggleGroup();
              final ToggleGroup   Tgroup19         = new ToggleGroup();
              final ToggleGroup   Tgroup20         = new ToggleGroup();
              final ToggleGroup   Tgroup23         = new ToggleGroup();
              final ToggleGroup   Tgroup21         = new ToggleGroup();
              final ToggleGroup   Tgroup22         = new ToggleGroup();
              final TextArea      Autre            ; 
              final ToggleGroup   Tgroup24         = new ToggleGroup();
              
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
       

       
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       ///  La Partie Consultation   //////////////////////////////////////////////////////////////////////////////////
       
     private final Label TDateDeTrait                 = new Label() ;
     private final Label TChimioembolisation          = new Label();
     private final Label TDateChimio                  = new Label() ;
     private final Label TChimioDroque                = new Label() ;
     private final Label TChimioPosologie             = new Label() ;
     private final Label TChimioDateDebTrt            = new Label() ;
     private final Label TChimioDouleurHepa           = new Label() ;
     private final Label TChimioNausee                = new Label() ;
     private final Label TChimioVomiss                = new Label() ;
     private final Label TChimioFievre                = new Label() ;
     private final Label TPreciseAutreChimio          = new Label();
     private final Label TSyndromePostEmbo            = new Label() ;
     private final Label TDouleurHepatique            = new Label() ;
     private final Label TSPENausee                   = new Label();
     private final Label TSPEVoumissement             = new Label();
     private final Label TSPEfievre                   = new Label();
     private final Label TEffetSecondAntimiotique     = new Label();
     private final Label TESAAlopecie                 = new Label();
     private final Label TESATroubleHematologique     = new Label();
     private final Label TESATHAnemie                 = new Label();
     private final Label TESATHLeucopenie             = new Label();
     private final Label TESATHThrombopenie           = new Label();
     private final Label TReactAllergRelInkectProdContraste  = new Label();
     private final Label TRisqueAtteinteRenale        = new Label();
     private final Label TComplicationGrave           = new Label();
     private final Label TCGCholangite                = new Label();
     private final Label TGCholesistite               = new Label();
     private final Label TCGAbces                     = new Label();
     private final Label TCGAutres                    = new Label();
     private final Label TChimioEmboNbrCure           = new Label();
     
     
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

       ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    final String DateInsBilan;
    public ChimieomBolisationBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
        this.DateInsBilan  = DateInsBilan;
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
        
    final GridPane            grid                   = new GridPane();    grid.setVgap(5); grid.setHgap(5);
    
    final Label               ChimieomBolisation     = new Label("CHIMIOEMBOLISATION : ");
    ChimieomBolisation.getStyleClass().add("styleButton");
    
          final RadioButton      OuiCH                  = new RadioButton("Oui");OuiCH.setUserData("Oui"); OuiCH.setSelected(true);
          final RadioButton      NonCH                  = new RadioButton("Non");NonCH.setUserData("Non");
         
          OuiCH.setToggleGroup(Tgroup1);  NonCH.setToggleGroup(Tgroup1);
    grid.add(ChimieomBolisation,0,0); grid.add(OuiCH, 1,0); grid.add(NonCH,2,0);
    
 
    final  Label  DateCHLab    =  new Label("Date : ");
    dateCh.setDayCellFactory(dayCellFactory);dateCh.setPrefWidth(150);
    dateCh.setValue(LocalDate.now());
    grid.add(DateCHLab, 0,1);   grid.add(dateCh,1,1);
    final Label               Drogue                 = new Label("Drogue :");//
    txtDrogue      = this.champSaisier(); txtDrogue.setPromptText("Drogue");
    grid.add(Drogue,0,2); grid.add(txtDrogue, 1,2);
    final Label               Posologie              = new Label("Posologie");
    txtPosologie   = this.champSaisier();  txtPosologie.setPromptText("Posologie");
    grid.add(Posologie,0,3);  grid.add(txtPosologie,1,3);
    
    DateDebutTRT.setDayCellFactory(dayCellFactory);DateDebutTRT.setValue(LocalDate.now());
    DateDebutTRT.setPrefWidth(150);
    final Label   DateTRT     =  new Label("Date de début du TRT ");
    grid.add(DateTRT, 0,4);    grid.add(DateDebutTRT,1,4);
    
    //////
    final Label              Incidents       = new Label("Incidents");
        Incidents.setStyle(styleLabel);
        grid.add(Incidents,0,5);
              final Label          DouleurHep    = new Label("- douleur hépatique ");
                    final RadioButton     OuiDH      = new RadioButton("Oui");    OuiDH.setUserData("Oui");
                    final RadioButton     NonDH      = new RadioButton("Non");    NonDH.setUserData("Non");
                                                                                  OuiDH.setSelected(true);
                    OuiDH.setToggleGroup(Tgroup3); NonDH.setToggleGroup(Tgroup3);
        grid.add(DouleurHep,0,6);  grid.add(OuiDH,1,6);  grid.add(NonDH,2,6);
        
              final Label          Nausees      = new Label("- nausées ");
                    final RadioButton     OuiN       = new RadioButton("Oui");  OuiN.setUserData("Oui");
                    final RadioButton     NonN       = new RadioButton("Non");  NonN.setUserData("Non");
                                                                                OuiN.setSelected(true);
                    OuiN.setToggleGroup(Tgroup4); NonN.setToggleGroup(Tgroup4);
        grid.add(Nausees,0,7);  grid.add(OuiN,1,7);  grid.add(NonN,2,7);
        
              final Label          Vomissement   = new Label("- vomissements ");
                    final RadioButton     OuiV       = new RadioButton("Oui");   OuiV.setUserData("Oui");
                    final RadioButton     NonV       = new RadioButton("Non");   NonV.setUserData("Non");
                                                                                 OuiV.setSelected(true);
                    OuiV.setToggleGroup(Tgroup5); NonV.setToggleGroup(Tgroup5);
        grid.add(Vomissement,0,8);  grid.add(OuiV,1,8);  grid.add(NonV,2,8);
              
              final Label          Fievre        = new Label("- fièvre ");
                    final RadioButton     OuiF       = new RadioButton("Oui");  OuiF.setUserData("Oui");
                    final RadioButton     NonF       = new RadioButton("Non");  NonF.setUserData("Non");
                                                                                OuiF.setSelected(true);
                    OuiF.setToggleGroup(Tgroup6); NonF.setToggleGroup(Tgroup6);
        grid.add(Fievre,0,9);  grid.add(OuiF,1,9);  grid.add(NonF,2,9);
        
              
              autreIncident = champSaisierA();
              autreIncident.setPromptText("Autre Incidents");
        grid.add(autreIncident,0,10); autreIncident.setPrefSize(200,80);
    /////
        
        final Label    SyndromPostEmbolisation         = new Label("Le syndrome post embolisation : ");
              final RadioButton   OuiSyndrom              = new RadioButton("Oui");    OuiSyndrom.setUserData("Oui");
              final RadioButton   NonSyndrom              = new RadioButton("Non");    NonSyndrom.setUserData("Non");
                                                                                       OuiSyndrom.setSelected(true);
              OuiSyndrom.setToggleGroup(Tgroup7); NonSyndrom.setToggleGroup(Tgroup7);
        grid.add(SyndromPostEmbolisation, 0,11); grid.add(OuiSyndrom,1,11); grid.add(NonSyndrom,2,11);
        
        ///
              final Label          DouleurHepS   = new Label("- douleur hépatique ");
                    final RadioButton     OuiDHS     = new RadioButton("Oui");    OuiDHS.setUserData("Oui");
                    final RadioButton     NonDHS      = new RadioButton("Non");   NonDHS.setUserData("Non");
                                                                                  OuiDHS.setSelected(true);
                    OuiDHS.setToggleGroup(Tgroup8); NonDHS.setToggleGroup(Tgroup8);
        grid.add(DouleurHepS,0,12);  grid.add(OuiDHS,1,12);  grid.add(NonDHS,2,12);
        
              final Label          NauseesS      = new Label("- nausées ");
                    final RadioButton     OuiNS       = new RadioButton("Oui");    OuiNS.setUserData("Oui");
                    final RadioButton     NonNS       = new RadioButton("Non");    NonNS.setUserData("Non");
                                                                                   OuiNS.setSelected(true);
                                                                                           
                    OuiNS.setToggleGroup(Tgroup9); NonNS.setToggleGroup(Tgroup9);
        grid.add(NauseesS,0,13);  grid.add(OuiNS,1,13);  grid.add(NonNS,2,13);
        
              final Label          VomissementS   = new Label("- vomissements ");
                    final RadioButton     OuiVS       = new RadioButton("Oui");     OuiVS.setUserData("Oui");
                    final RadioButton     NonVS       = new RadioButton("Non");     NonVS.setUserData("Non");
                                                                                    OuiVS.setSelected(true);
                    OuiVS.setToggleGroup(Tgroup10); NonVS.setToggleGroup(Tgroup10);
        grid.add(VomissementS,0,14);  grid.add(OuiVS,1,14);  grid.add(NonVS,2,14);
              
              final Label          FievreS        = new Label("- fièvre ");
                    final RadioButton     OuiFS       = new RadioButton("Oui");         OuiFS.setUserData("Oui");
                    final RadioButton     NonFS       = new RadioButton("Non");         NonFS.setUserData("Non");
                                                                                        OuiFS.setSelected(true);
                    OuiFS.setToggleGroup(Tgroup11); NonFS.setToggleGroup(Tgroup11);
        grid.add(FievreS,0,15);  grid.add(OuiFS,1,15);  grid.add(NonFS,2,15);
        //
    /////
        final Label            EffetSecondairAntim          = new Label("Effets secondaires des antimitotiques : ");
              final RadioButton    OuiEffet                    = new RadioButton("Oui");  OuiEffet.setUserData("Oui");
              final RadioButton    NonEffet                    = new RadioButton("Non");  NonEffet.setUserData("Non");
                                                                                          OuiEffet.setSelected(true);
              OuiEffet.setToggleGroup(Tgroup12);    NonEffet.setToggleGroup(Tgroup12);
        grid.add(EffetSecondairAntim,0,17); grid.add(OuiEffet, 1,17); grid.add(NonEffet,2,17);
        
        
        final Label            alopecie                     = new Label("alopécie");
              final RadioButton    OuiAlop                     = new RadioButton("Oui");  OuiAlop.setUserData("Oui");
              final RadioButton    NonAlop                     = new RadioButton("Non");  NonAlop.setUserData("Non");
                                                                                          OuiAlop.setSelected(true);
              OuiAlop.setToggleGroup(Tgroup13);     NonAlop.setToggleGroup(Tgroup13);
        grid.add(alopecie,0,18);     grid.add(OuiAlop,1,18); grid.add(NonAlop,2,18);
        
        final Label            TroubleHem                   = new Label("Troubles hématologiques");
              final RadioButton    OuiTH                       = new RadioButton("Oui");   OuiTH.setUserData("Oui");
              final RadioButton    NonTH                       = new RadioButton("Non");   NonTH.setUserData("Non");
                                                                                           OuiTH.setSelected(true);
              OuiTH.setToggleGroup(Tgroup14);     NonTH.setToggleGroup(Tgroup14);
        grid.add(TroubleHem,0,19);     grid.add(OuiTH,1,19); grid.add(NonTH,2,19);
        
        
        final Label            Anemie                     = new Label("-anémie");
              final RadioButton    OuiAnemie                     = new RadioButton("Oui");  OuiAnemie.setUserData("Oui");
              final RadioButton    NonAnemie                     = new RadioButton("Non");  NonAnemie.setUserData("Non");
                                                                                            OuiAnemie.setSelected(true);
              OuiAnemie.setToggleGroup(Tgroup15);     NonAnemie.setToggleGroup(Tgroup15);
        grid.add(Anemie,0,20);     grid.add(OuiAnemie,1,20); grid.add(NonAnemie,2,20);
        
        final Label            Leucopenie                     = new Label("-leucopénie");
              final RadioButton    OuiLoc                     = new RadioButton("Oui");      OuiLoc.setUserData("Oui");
              final RadioButton    NonLoc                     = new RadioButton("Non");      NonLoc.setUserData("Non");
                                                                                             OuiLoc.setSelected(true);
              OuiLoc.setToggleGroup(Tgroup16);     NonLoc.setToggleGroup(Tgroup16);
        grid.add(Leucopenie,0,21);     grid.add(OuiLoc,1,21); grid.add(NonLoc,2,21);
        
        final Label            Thrombopenie                     = new Label("-thrombopénie");
              final RadioButton    OuiThrom                     = new RadioButton("Oui");     OuiThrom.setUserData("Oui");
              final RadioButton    NonThrom                     = new RadioButton("Non");     NonThrom.setUserData("Non");
                                                                                              OuiThrom.setSelected(true);
              OuiThrom.setToggleGroup(Tgroup17);     NonThrom.setToggleGroup(Tgroup17);
        grid.add(Thrombopenie,0,22);     grid.add(OuiThrom,1,22); grid.add(NonThrom,2,22);
        
        final Label            Reaction                    = new Label("Réaction allergique en rapport \n "
                                                                    + " avec l'injection de produit de contraste" );
              final RadioButton    OuiR                     = new RadioButton("Oui");      OuiR.setUserData("Oui");
              final RadioButton    NonR                     = new RadioButton("Non");      NonR.setUserData("Non");
                                                                                           OuiR.setSelected(true);
              
              OuiR.setToggleGroup(Tgroup18);     NonR.setToggleGroup(Tgroup18);
        grid.add(Reaction,0,24,2,2);     grid.add(OuiR,2,24); grid.add(NonR,3,24);
        
        final Label            Risque                     = new Label("Risque d'atteintes rénales \n"
                                                                 + "  (produit de contraste) ");
              final RadioButton    OuiRS                     = new RadioButton("Oui");      OuiRS.setUserData("Oui");
              final RadioButton    NonRS                     = new RadioButton("Non");      NonRS.setUserData("Non");
                                                                                            OuiRS.setSelected(true);
              OuiRS.setToggleGroup(Tgroup19);     NonRS.setToggleGroup(Tgroup19);
        grid.add(Risque,0,26,2,2);     grid.add(OuiRS,2,26); grid.add(NonRS,3,26);
        
        final Label              Compl                    = new Label("Complication grave");
              final RadioButton    OuiC                     = new RadioButton("Oui");      OuiC.setUserData("Oui");
              final RadioButton    NonC                     = new RadioButton("Non");      NonC.setUserData("Non");OuiC.setSelected(true);
              
              OuiC.setToggleGroup(Tgroup20);     NonC.setToggleGroup(Tgroup20);
        grid.add(Compl,0,28);     grid.add(OuiC,1,28); grid.add(NonC,2,28);
        
        final Label            Cholangite                     = new Label("Cholangite");
              final RadioButton    OuiCholan                    = new RadioButton("Oui");  OuiCholan.setUserData("Oui");
              final RadioButton    NonCholan                    = new RadioButton("Non");  NonCholan.setUserData("Non");
                                                                                           OuiCholan.setSelected(true);
              OuiCholan.setToggleGroup(Tgroup23);     NonCholan.setToggleGroup(Tgroup23);
        grid.add(Cholangite,0,29);     grid.add(OuiCholan,1,29); grid.add(NonCholan,2,29);
        
        
        final Label            Choleycist                     = new Label("choléycistite");
              final RadioButton    OuiCholey                     = new RadioButton("Oui");   OuiCholey.setUserData("Oui");
              final RadioButton    NonCholey                     = new RadioButton("Non");   NonCholey.setUserData("Non");
                                                                                             OuiCholey.setSelected(true);
              OuiCholey.setToggleGroup(Tgroup21);     NonCholey.setToggleGroup(Tgroup21);
        grid.add(Choleycist,0,30);     grid.add(OuiCholey,1,30); grid.add(NonCholey,2,30);
        
        final Label            Abces                     = new Label("Abcès");
              final RadioButton    OuiAB                     = new RadioButton("Oui");     OuiAB.setUserData("Oui");
              final RadioButton    NonAB                     = new RadioButton("Non");     NonAB.setUserData("Non");
                                                                                           OuiAB.setSelected(true);
              OuiAB.setToggleGroup(Tgroup22);     NonAB.setToggleGroup(Tgroup22);
        grid.add(Abces,0,31);     grid.add(OuiAB,1,31); grid.add(NonAB,2,31);
        
        
        
        
        Autre  = champSaisierA();
        Autre.setPromptText("Autre");
        Autre.setPrefSize(200,80);
        grid.add(Autre,0,32);
        
         final Label             NombreCure        = new Label(" Nombre de cure ");
              final RadioButton      Nombre1         = new RadioButton("1");     Nombre1.setUserData("1");
              final RadioButton      Nombre2         = new RadioButton("2");     Nombre2.setUserData("2");
              final RadioButton      Nombre3         = new RadioButton("3");     Nombre3.setUserData("3");
              final RadioButton      Nombre4         = new RadioButton(">3");    Nombre4.setUserData(">3");
                                                                                 Nombre1.setSelected(true);
              Nombre1.setToggleGroup(Tgroup24); Nombre2.setToggleGroup(Tgroup24); Nombre3.setToggleGroup(Tgroup24);
              Nombre4.setToggleGroup(Tgroup24); 
        grid.add(NombreCure,0,34); grid.add(Nombre1,1,34); grid.add(Nombre2,2,34); grid.add(Nombre3,3,34);
                                   grid.add(Nombre4,4,34);
              
                                   
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
                    IndIns.setText(" L’insertion des Traitements\n Propose (ChimioEmbolisation) \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Traitements de même type \n au niveau d'un dossier \n sur la même date ");
                   } 
            } catch (SQLException ex) {
                Logger.getLogger(ChimieomBolisationBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 5,35);
        grid.add(IndIns, 4,30,4,4);
        ///
        Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov , Toggle old_value ,
        Toggle new_value)->{
            if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
                grid.getChildren().removeAll(dateCh,Drogue,Posologie,DateDebutTRT,Incidents,DouleurHep,OuiDH,NonDH,Nausees,OuiN,NonN,
        Vomissement,OuiV,NonV,Fievre,OuiF,NonF,autreIncident,SyndromPostEmbolisation,OuiSyndrom,NonSyndrom,
        DouleurHepS,OuiDHS,NonDHS,NauseesS,OuiNS,NonNS,VomissementS,OuiVS,NonVS,FievreS,OuiFS,NonFS,
        EffetSecondairAntim,OuiEffet,NonEffet,alopecie,OuiAlop,NonAlop,TroubleHem,OuiTH,NonTH,Anemie,OuiAnemie,
        NonAnemie,Leucopenie,OuiLoc,NonLoc,Thrombopenie,NonThrom,OuiThrom,Reaction,OuiR,NonR,Risque,OuiRS,NonRS,
        Compl,OuiC,NonC,Cholangite,OuiCholan,NonCholan,Choleycist,OuiCholey,NonCholey,Abces,OuiAB,NonAB,Autre,
        NombreCure,Nombre1,Nombre2,Nombre3,Nombre4,Ajouter,DateCHLab,txtDrogue,txtPosologie,DateTRT,IndIns);
            }else {
                grid.getChildren().addAll(dateCh,Drogue,Posologie,DateDebutTRT,Incidents,DouleurHep,OuiDH,NonDH,Nausees,OuiN,NonN,
        Vomissement,OuiV,NonV,Fievre,OuiF,NonF,autreIncident,SyndromPostEmbolisation,OuiSyndrom,NonSyndrom,
        DouleurHepS,OuiDHS,NonDHS,NauseesS,OuiNS,NonNS,VomissementS,OuiVS,NonVS,FievreS,OuiFS,NonFS,
        EffetSecondairAntim,OuiEffet,NonEffet,alopecie,OuiAlop,NonAlop,TroubleHem,OuiTH,NonTH,Anemie,OuiAnemie,
        NonAnemie,Leucopenie,OuiLoc,NonLoc,Thrombopenie,NonThrom,OuiThrom,Reaction,OuiR,NonR,Risque,OuiRS,NonRS,
        Compl,OuiC,NonC,Cholangite,OuiCholan,NonCholan,Choleycist,OuiCholey,NonCholey,Abces,OuiAB,NonAB,Autre,
        NombreCure,Nombre1,Nombre2,Nombre3,Nombre4,Ajouter,DateCHLab,txtDrogue,txtPosologie,DateTRT,IndIns);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////// La Partie Consultation     //////////////////////////////////////////////////////////////////////////
        
        
        
      final Label ConsDateDeTrait                         = new Label("Date de la chimioembolisation                     :") ;
      final Label ConsChimioembolisation                  = new Label("Chimioembolisation                                :");
      final Label ConsDateChimio                          = new Label("Date                                              :") ;
      final Label ConsChimioDroque                        = new Label("Droque                                            :") ;
      final Label ConsChimioPosologie                     = new Label("Posologie                                         :") ;
      final Label ConsChimioDateDebTrt                    = new Label("Date de debut TRT                                 :");
      final Label ConsChimioDouleurHepa                   = new Label("-Douleur hépatique                                :") ;
      final Label ConsChimioNausee                        = new Label("-Nausées                                          :") ;
      final Label ConsChimioVomiss                        = new Label("-Vomissements                                     :") ;
      final Label ConsChimioFievre                        = new Label("-Fièvre                                           :") ;
      final Label ConsPreciseAutreChimio                  = new Label("-Autres                                           :");
      final Label ConsSyndromePostEmbo                    = new Label("Le syndrome post embolisation                     :") ;
      final Label ConsDouleurHepatique                    = new Label("-Douleur hépatique                                :") ;
      final Label ConsSPENausee                           = new Label("-Nausées                                          :");
      final Label ConsSPEVoumissement                     = new Label("-Vomissement                                      :");
      final Label ConsSPEfievre                           = new Label("-Fièvre                                           :");
      final Label ConsEffetSecondAntimiotique             = new Label("Effet secondaires des antimiotiques               :");
      final Label ConsESAAlopecie                         = new Label("Alpécie                                           :");
      final Label ConsESATroubleHematologique             = new Label("Troubleshématologiques                            :");
      final Label ConsESATHAnemie                         = new Label("-Anémie                                           :");
      final Label ConsESATHLeucopenie                     = new Label("-Leucopénie                                       :");
      final Label ConsESATHThrombopenie                   = new Label("-Trombopénie                                      :");
      final Label ConsReactAllergRelInkectProdContraste   = new Label("Réaction allergique en rapport \n avec l'injection de produit de contraste         :");
                                                                    
      final Label ConsRisqueAtteinteRenale                = new Label("Risque d'atteintes rénales (produit de contraste) :");
      final Label ConsComplicationGrave                   = new Label("Complications graves                              :");
      final Label ConsCGCholangite                        = new Label("-Cholangite                                       :");
      final Label ConsGCholesistite                       = new Label("-Cholécystite aigue                               :");
      final Label ConsCGAbces                             = new Label("-Abcès                                            :");
      final Label ConsCGAutres                            = new Label("Autres                                            :");
      final Label ConsChimioEmboNbrCure                   = new Label("Nombre de cure                                    :");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    final GridPane        gridC    = new GridPane();
    gridC.setVgap(10);
    gridC.setHgap(7);
  
    final Label ChimiOLabel               = new Label("CHIMIOEMBOLISATION : ");
    ChimiOLabel.getStyleClass().add("setStyleCirconsanceDic");
  gridC.add(ChimiOLabel,0,0);
  gridC.add(ConsDateDeTrait , 0,1);                        gridC.add(TDateDeTrait,1,1);
  gridC.add(ConsChimioembolisation ,0, 2);                 gridC.add(TChimioembolisation,1,2);
  gridC.add(ConsDateChimio, 0,3);                          gridC.add(TDateChimio,1,3);
  gridC.add(ConsChimioDroque, 0,4);                        gridC.add(TChimioDroque,1,4);
  gridC.add(ConsChimioPosologie,0,5);                      gridC.add(TChimioPosologie,1,5);
  gridC.add(ConsChimioDateDebTrt  ,0, 6);                  gridC.add(TChimioDateDebTrt ,1, 6);
  gridC.add(ConsChimioDouleurHepa , 0,7);                  gridC.add(TChimioDouleurHepa ,1, 7);
  gridC.add(ConsChimioNausee , 0,8);                       gridC.add(TChimioNausee, 1,8);
  gridC.add(ConsChimioVomiss , 0,9);                       gridC.add(TChimioVomiss , 1,9);
  gridC.add(ConsChimioFievre , 0,10);                      gridC.add(TChimioFievre ,1,10);  
  gridC.add(ConsPreciseAutreChimio ,0, 11);                gridC.add(TPreciseAutreChimio ,1, 11);
  gridC.add(ConsSyndromePostEmbo ,0,12);                   gridC.add(TSyndromePostEmbo , 1,12);  
  gridC.add(ConsDouleurHepatique , 0,13);                  gridC.add(TDouleurHepatique , 1,13);
  gridC.add(ConsSPENausee , 0,14);                         gridC.add(TSPENausee, 1,14);  
  gridC.add(ConsSPEVoumissement , 0,15);                   gridC.add(TSPEVoumissement , 1,15);
  gridC.add(ConsSPEfievre , 0,16);                         gridC.add(TSPEfievre , 1,16);
  gridC.add(ConsEffetSecondAntimiotique ,0, 17);           gridC.add(TEffetSecondAntimiotique ,1, 17);
  gridC.add(ConsESAAlopecie , 0,18);                       gridC.add(TESAAlopecie , 1,18);
  gridC.add(ConsESATroubleHematologique ,0, 19);           gridC.add(TESATroubleHematologique, 1,19);
  gridC.add(ConsESATHAnemie, 0,20);                        gridC.add(TESATHAnemie , 1,20);
  gridC.add(ConsESATHLeucopenie , 0,21);                   gridC.add(TESATHLeucopenie , 1,21);
  gridC.add(ConsESATHThrombopenie , 0,22);                 gridC.add(TESATHThrombopenie, 1,22);
  gridC.add(ConsReactAllergRelInkectProdContraste , 0,23); gridC.add(TReactAllergRelInkectProdContraste , 1,23); 
  gridC.add(ConsRisqueAtteinteRenale , 0,24);              gridC.add(TRisqueAtteinteRenale, 1,24); 
  gridC.add(ConsComplicationGrave , 0,25);                 gridC.add(TComplicationGrave , 1,25); 
  gridC.add(ConsCGCholangite ,0, 26);                      gridC.add(TCGCholangite , 1,26); 
  gridC.add(ConsGCholesistite ,0, 27);                     gridC.add(TGCholesistite , 1,27); 
  gridC.add(ConsCGAbces , 0,28);                           gridC.add(TCGAbces , 1,28); 
  gridC.add(ConsCGAutres , 0,29);                          gridC.add(TCGAutres , 1,29); 
  gridC.add(ConsChimioEmboNbrCure ,0, 30);                 gridC.add(TChimioEmboNbrCure,1, 30); 
      
  
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
        gridC.add(barOutil, 2,33,2,2);
        gridC.add(vbMod,0,33,2,3);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
     }
         ///////////////;
        
        
    }

    public String getChimieOmb() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateCh() {
        return dateCh.getValue();
    }

    public LocalDate getDateDebutTRT() {
        return DateDebutTRT.getValue();
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

    public String getSyndromPE() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }

    public String getSDouleurH() {
        return Tgroup8.getSelectedToggle().getUserData().toString();
    }

    public String getSNausees() {
        return Tgroup9.getSelectedToggle().getUserData().toString();
    }

    public String getSVomissement() {
        return Tgroup10.getSelectedToggle().getUserData().toString();
    }

    public String getSFievre() {
        return Tgroup11.getSelectedToggle().getUserData().toString();
    }

    public String getEffetSA() {
        return Tgroup12.getSelectedToggle().getUserData().toString();
    }

    public String getAlopecie() {
        return Tgroup13.getSelectedToggle().getUserData().toString();
    }

    public String getTroubleHematologique() {
        return Tgroup14.getSelectedToggle().getUserData().toString();
    }

    public String getAnemie() {
        return Tgroup15.getSelectedToggle().getUserData().toString();
    }

    public String getLeucopenie() {
        return Tgroup16.getSelectedToggle().getUserData().toString();
    }

    public String getThrombopenie() {
        return Tgroup17.getSelectedToggle().getUserData().toString();
    }

    public String getReactioAllergique() {
        return Tgroup18.getSelectedToggle().getUserData().toString();
    }

    public String getRisqueAtteint() {
        return Tgroup19.getSelectedToggle().getUserData().toString();
    }

    public String getComplicationG() {
        return Tgroup20.getSelectedToggle().getUserData().toString();
    }

    public String getCholongit() {
        return Tgroup23.getSelectedToggle().getUserData().toString();
    }

    public String getCholeycistte() {
        return Tgroup21.getSelectedToggle().getUserData().toString();
    }

    public String getAbces() {
        return Tgroup22.getSelectedToggle().getUserData().toString();
    }

    public String getAutre() {
        return Autre.getText();
    }

    public String getNombreCur() {
        return Tgroup24.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }

    public String getTxtDrogue() {
        return txtDrogue.getText();
    }

    public String getTxtPosologie() {
        return txtPosologie.getText();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getChimieOmb()+"\n"+this.getDateCh()+"\n"+this.getDateDebutTRT()+"\n"+this.getDouleurH()+"\n"+
                this.getNausees()+"\n"+this.getVomissement()+"\n"+this.getFievre()+"\n"+this.getAutreIncident()+"\n"+this.getSDouleurH()+"\n"+
                this.getSNausees()+"\n"+this.getSVomissement()+"\n"+this.getSFievre()+"\n"+this.getEffetSA()+"\n"+this.getAlopecie()+"\n"+
                this.getTroubleHematologique()+"\n"+this.getAnemie()+"\n"+this.getLeucopenie()+"\n"+this.getThrombopenie()+"\n"+this.getReactioAllergique()+"\n"+
                this.getRisqueAtteint()+"\n"+this.getComplicationG()+"\n"+this.getCholongit()+"\n"+this.getCholeycistte()+"\n"+this.getAbces()+"\n"+
                this.getAutre()+"\n"+this.getNombreCur()+"\n");
        
        MiseAjour    bddInsert    = new MiseAjour();
        int i = bddInsert.AddElement("insert into ChimioEmbolisation values (0,'"+this.getChimieOmb()+"','"+this.getDateCh()+"','"+this.getTxtDrogue()+"','"+this.getTxtPosologie()+"','"+this.getDateDebutTRT()+"','"+
                this.getDouleurH()+"','"+
                this.getNausees()+"','"+this.getVomissement()+"','"+this.getFievre()+"','"+this.getAutreIncident()+"','"+this.getSyndromPE()+"','"+this.getSDouleurH()+"','"+
                this.getSNausees()+"','"+this.getSVomissement()+"','"+this.getSFievre()+"','"+this.getEffetSA()+"','"+this.getAlopecie()+"','"+
                this.getTroubleHematologique()+"','"+this.getAnemie()+"','"+this.getLeucopenie()+"','"+this.getThrombopenie()+"','"+this.getReactioAllergique()+"','"+
                this.getRisqueAtteint()+"','"+this.getComplicationG()+"','"+this.getCholongit()+"','"+this.getCholeycistte()+"','"+this.getAbces()+"','"+
                this.getAutre()+"','"+this.getNombreCur()+"','"+NumDossier+"','"+this.getDateB()+"')");
        
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
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /////  La Partie Consultation    ///////////////////////////////////////////////////////////////////////////////////
    
     public void setTDateDeTrait(String a) {
        TDateDeTrait.setText(a);
    }

    public void setTChimioembolisation(String a) {
        TChimioembolisation.setText(a);
    }

    public void setTDateChimio(String a) {
        TDateChimio.setText(a);
    }
    public void setTChimioDroque(String a) {
        TChimioDroque.setText(a);
    }

    public void setTChimioPosologie(String a) {
        TChimioPosologie.setText(a);
    }

    public void setTChimioDateDebTrt(String a) {
        TChimioDateDebTrt.setText(a);
    }

    public void setTChimioDouleurHepa(String a) {
        TChimioDouleurHepa.setText(a);
    }

    public void setTChimioNausee(String a) {
        TChimioNausee.setText(a);
    }
    public void setTChimioVomiss(String a) {
        TChimioVomiss.setText(a);
    }

    public void setTChimioFievre(String a) {
        TChimioFievre.setText(a);
    }

    public void setTPreciseAutreChimio(String a) {
        TPreciseAutreChimio.setText(a);
    }

    public void setTSyndromePostEmbo(String a) {
        TSyndromePostEmbo.setText(a);
    }

    public void setTDouleurHepatique(String a) {
        TDouleurHepatique.setText(a);
    }

    public void setTSPENausee(String a) {
        TSPENausee.setText(a);
    }

    public void setTSPEVoumissement(String a) {
        TSPEVoumissement.setText(a);
    }

    public void setTSPEfievre(String a) {
       TSPEfievre.setText(a);
    }
    public void setTEffetSecondAntimiotique(String a) {
       TEffetSecondAntimiotique.setText(a);
    }

    public void setTESAAlopecie(String a) {
       TESAAlopecie.setText(a);
    }

    public void setTESATroubleHematologique(String a) {
       TESATroubleHematologique.setText(a);
    }

    public void setTESATHAnemie(String a) {
       TESATHAnemie.setText(a);
    }

    public void setTESATHLeucopenie(String a) {
       TESATHLeucopenie.setText(a);
    }

    public void setTESATHThrombopenie(String a) {
       TESATHThrombopenie.setText(a);
    }

    public void setTReactAllergRelInkectProdContraste(String a) {
       TReactAllergRelInkectProdContraste.setText(a);
    }

    public void setTRisqueAtteinteRenale(String a) {
       TRisqueAtteinteRenale.setText(a);
    }

    public void setTComplicationGrave(String a) {
       TComplicationGrave.setText(a);
    }

    public void setTCGCholangite(String a) {
       TCGCholangite.setText(a);
    }

    public void setTGCholesistite(String a) {
       TGCholesistite.setText(a);
    }

    public void setTCGAbces(String a) {
       TCGAbces.setText(a);
    }

    public void setTCGAutres(String a) {
       TCGAutres.setText(a);
    }

    public void setTChimioEmboNbrCure(String a) {
        TChimioEmboNbrCure.setText(a);
    }
    
    
    public void ConsultationE(String NumDossier) throws SQLException{
        
        ChimiOembolisationClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from ChimiOembolisation where NumDossier = '"+NumDossier+"'"
                                           +"and DateDeTrait = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new ChimiOembolisationClasse(res.getDate(32),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12)
     ,res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),res.getString(18),res.getString(19)
     ,res.getString(20),res.getString(21),res.getString(22),res.getString(23),res.getString(24),res.getString(25),res.getString(26)
     ,res.getString(27),res.getString(28),res.getString(29),res.getString(30)
     );}
    
    try{
    this.setTDateDeTrait(Bilan.getTDateDeTrait().toString());
    this.setTChimioembolisation(Bilan.getTChimioembolisation());
    this.setTDateChimio(Bilan.getTDateChimio());
    this.setTChimioDroque(Bilan.getTChimioDroque());
    this.setTChimioPosologie(Bilan.getTChimioPosologie());
    this.setTChimioDateDebTrt(Bilan.getTChimioDateDebTrt());
    this.setTChimioDouleurHepa(Bilan.getTChimioDouleurHepa());
    this.setTChimioNausee(Bilan.getTChimioNausee());
    this.setTChimioVomiss(Bilan.getTChimioVomiss());
    this.setTChimioFievre(Bilan.getTChimioFievre());
    this.setTPreciseAutreChimio(Bilan.getTPreciseAutreChimio());
    this.setTSyndromePostEmbo(Bilan.getTSyndromePostEmbo());
    this.setTDouleurHepatique(Bilan.getTDouleurHepatique());
    this.setTSPENausee(Bilan.getTSPENausee());
    this.setTSPEVoumissement(Bilan.getTSPEVoumissement());
    this.setTSPEfievre(Bilan.getTSPEfievre());
    this.setTEffetSecondAntimiotique(Bilan.getTEffetSecondAntimiotique());
    this.setTESAAlopecie(Bilan.getTESAAlopecie());
    this.setTESATHAnemie(Bilan.getTESATHAnemie());
    this.setTESATHLeucopenie(Bilan.getTESATHLeucopenie());
    this.setTESATHThrombopenie(Bilan.getTESATHThrombopenie());
    this.setTESATroubleHematologique(Bilan.getTESATroubleHematologique());
    this.setTReactAllergRelInkectProdContraste(Bilan.getTReactAllergRelInkectProdContraste());
    this.setTRisqueAtteinteRenale(Bilan.getTRisqueAtteinteRenale());
    this.setTComplicationGrave(Bilan.getTComplicationGrave());
    this.setTCGAbces(Bilan.getTCGAbces());
    this.setTCGAutres(Bilan.getTCGAutres());
    this.setTCGCholangite(Bilan.getTCGCholangite());
    this.setTGCholesistite(Bilan.getTGCholesistite());
    this.setTChimioEmboNbrCure(Bilan.getTChimioEmboNbrCure());
    } catch(Exception e){
     
    this.setTDateDeTrait("---------------");
    this.setTChimioembolisation("---------------");
    this.setTDateChimio("---------------");
    this.setTChimioDroque("---------------");
    this.setTChimioPosologie("---------------");
    this.setTChimioDateDebTrt("---------------");
    this.setTChimioDouleurHepa("---------------");
    this.setTChimioNausee("---------------");
    this.setTChimioVomiss("---------------");
    this.setTChimioFievre("---------------");
    this.setTPreciseAutreChimio("---------------");
    this.setTSyndromePostEmbo("---------------");
    this.setTDouleurHepatique("---------------");
    this.setTSPENausee("---------------");
    this.setTSPEVoumissement("---------------");
    this.setTSPEfievre("---------------");
    this.setTEffetSecondAntimiotique("---------------");
    this.setTESAAlopecie("---------------");
    this.setTESATHAnemie("---------------");
    this.setTESATHLeucopenie("---------------");
    this.setTESATHThrombopenie("---------------");
    this.setTESATroubleHematologique("---------------");
    this.setTReactAllergRelInkectProdContraste("---------------");
    this.setTRisqueAtteinteRenale("---------------");
    this.setTComplicationGrave("---------------");
    this.setTCGAbces("---------------");
    this.setTCGAutres("---------------");
    this.setTCGCholangite("---------------");
    this.setTGCholesistite("---------------");
    this.setTChimioEmboNbrCure("---------------");
    }
    }
    
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from ChimiOembolisation where NumDossier ='"+NumDossier+"' and dateDeTrait ='"+DateInsBilan+"'" );
            
            return j;
        } 
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
