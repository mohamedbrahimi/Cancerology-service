
package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;


public final class ANTCDpersonnelSpace extends Parent{
    
    
    final  Label                 HepatopathiesSousJacent        = new Label("Hepatopathies sous jacentes ");
    final  RadioButton           OuiHepathie                    = new RadioButton("Oui");
    final  RadioButton           NonHepathie                    = new RadioButton("Non");
    final ToggleGroup Tgroup1 = new ToggleGroup();

    

    
    final  DatePicker            depuis                         = new DatePicker();
    
    
    final  TitledPane            causeTitled                    = new TitledPane();
           final     RadioButton    hepathieChronque                    = new RadioButton("hépathie chronique");                 
           final     RadioButton    cirrhose                            = new RadioButton("cirrhose");
           final     ToggleGroup    Tgroup20                            = new ToggleGroup();
           final     Separator  sepH                                = new Separator();
           final     RadioButton    viraleB                             = new RadioButton("viral B");
           final     RadioButton    viraleC                             = new RadioButton("viral C");
           final     RadioButton    NASH                                = new RadioButton("NASH");
           final     RadioButton    Autoimmun                           = new RadioButton("AUOIMMUNE");
           final     RadioButton    AutreRad                            = new RadioButton("Autre");
           final     ToggleGroup    Tgroup21                            = new ToggleGroup();

           final     TextArea    Autre                               ;
    final  TitledPane            contageViralAB                 = new TitledPane();
           final     CheckBox    TransfusionSanguine                 = new CheckBox("Transfusion sanguine");
           final     CheckBox    ExtractionDentaireTraditionelle     = new CheckBox("Extraction dentaire traditionnelle");
           final     CheckBox    Sacrification                       = new CheckBox("Sacrification ");
           final     CheckBox    Tatouage                            = new CheckBox("Tatouage");
           final     CheckBox    Chirugie                            = new CheckBox("Chirugie");
           final     TextArea    AutreContage                        ;
           
    final  TitledPane            PriseDalcool                   = new TitledPane();
           final     TextField   duree                               ;
           final     TextField   quantite                            ;
           final     TextField   nature                              ;
           final     TextField   sevrage                             ;
           
    final Accordion  accord                                          = new Accordion();
           
    final  Label             priseDeCafe                    = new Label("prise de café");
           final RadioButton    OuiPCafe                             = new RadioButton("Oui");
           final RadioButton    NonPCafe                             = new RadioButton("Non");
           final ToggleGroup   Tgroup6     =  new ToggleGroup();
           final TextField      QteJ                                 ;
    
    final  Label                 priseDeCannabis                = new Label("Prise de cannabis");
           final     RadioButton OuiPC                               = new RadioButton("Oui");
           final     RadioButton NonPC                               = new RadioButton("Non");
           final ToggleGroup Tgroup2 = new ToggleGroup();
           
    final  TextField    MaladieAutoImmune                       ;
    
    final  Label        ContraceptionOrale                      = new Label("Contraception orale");
    final  RadioButton  OuiContra                               = new RadioButton("Oui");
    final  RadioButton  NonContra                               = new RadioButton("Non");
    ToggleGroup    Tgroup7     =  new ToggleGroup();
    final  TextField    molecule                                ;
    final  TextField    dureeCO                                 ;
    
    final  Label        NeoplasmeConnu                          = new Label("Néoplasme connu");
           final     RadioButton OuiNC                               = new RadioButton("Oui");
           final     RadioButton NonNC                               = new RadioButton("Non");
           final ToggleGroup Tgroup3 = new ToggleGroup();
           final     TextField   preciseNeo                          ;
           
    final  TextField    Dyslipidemei                            ;
    final  Label        diabete                                 = new Label("Diabète");
           final     RadioButton OuiDiabete                          = new RadioButton("Oui");
           final     RadioButton NonDiabete                          = new RadioButton("Non");
           final ToggleGroup Tgroup8 = new ToggleGroup();
           
           final     RadioButton type1                               = new RadioButton("Type1");
           final     RadioButton type2                               = new RadioButton("Type2");
           final ToggleGroup Tgroup4 = new ToggleGroup();
           final     DatePicker   depuisD                            = new DatePicker();
           
    final  Label        HTA                                     = new Label("HTA");
           final     RadioButton OuiHta                              = new RadioButton("Oui");
           final     RadioButton NonHta                              = new RadioButton("Non");
           final ToggleGroup Tgroup5 = new ToggleGroup();
           final     TextArea    preciseTrt  ;
           
    final  TextArea  autreTares ;  
    
    /////////////////////////PCons/////////////////////////////////////////////////////////////////
    private Label  ConsHepathieSousJacent            = new Label("--------");
    private Label  ConsDepuis                        = new Label("1999-01-01");
    private Label  ConsPrecise                       = new Label("--------");
    private Label  ConsCause                         = new Label("--------");
    private Label  ConsTransSang                     = new Label("--------");
    private Label  ConsExtrDenTrad                   = new Label("--------");
    private Label  ConsSacrification                 = new Label("--------");
    private Label  ConsTatouage                      = new Label("--------");
    private Label  ConsChirurgie                     = new Label("--------");
    private Label  ConsAutre                         = new Label("--------");
    private Label  ConsAlcoolDuree                   = new Label("--------");
    private Label  ConsAlcoolQuantite                = new Label("--------");
    private Label  ConsAlcoolNature                  = new Label("--------");
    private Label  ConsAlcoolSevrage                 = new Label("--------");
    private Label  ConsCafe                          = new Label("--------");
    private Label  ConsCafeNbrDeTasse                = new Label("--------");
    private Label  ConsCannabis                      = new Label("--------");
    private Label  ConsMaladieAutoImmune             = new Label("--------");
    private Label  ConsContreOrale                   = new Label("--------");
    private Label  ConsMolecule                      = new Label("--------");
    private Label  ConsDuree                         = new Label("--------");
    private Label  ConsNeoplasmeConnu                = new Label("--------");
    private Label  ConsNeoplasmePrecise              = new Label("--------");
    private Label  ConsDyslipidemie                  = new Label("--------");
    private Label  ConsDiabete                       = new Label("--------");
    private Label  ConsTypeDiabete                   = new Label("--------");
    private Label  ConsDepuisD                       = new Label("1993-01-01");
    private Label  ConsHTA                           = new Label("--------");
    private Label  ConsTRT                           = new Label("--------");
    private Label  ConsAutreTares                    = new Label("--------");
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    //////// Partie Modification  /////////////////////////////////////////////////////////////////
    final TextField  ConsHepathieSousJacentMod         ;  
    final DatePicker  ConsDepuisMod                         ; 
    final TextField  ConsPreciseMod                        ;      
    final TextField  ConsCauseMod                          ;      
              
    final TextField  ConsTransSangMod                      ;       
    final TextField  ConsExtrDenTradMod                    ;    
    final TextField  ConsSacrificationMod                  ;     
    final TextField  ConsTatouageMod                       ;     
    final TextField  ConsChirurgieMod                      ;  	
    final TextArea   ConsAutreMod                          ;                                   
                                
    final TextField  ConsAlcoolDureeMod                    ;                        
    final TextField  ConsAlcoolQuantiteMod                 ;                              
    final TextField  ConsAlcoolNatureMod                   ;                               
    final TextField  ConsAlcoolSevrageMod                  ;                               
    final TextField  ConsCafeMod                           ;                 
    final TextField  ConsCafeNbrDeTasseMod                 ;                
    final TextField  ConsCannabisMod                       ;                 
    final TextField  ConsMaladieAutoImmuneMod              ;                
    final TextField  ConsContreOraleMod                    ;                
    final TextField  ConsMoleculeMod                       ;                                          
    final TextField  ConsDureeMod                          ;                                     
    final TextField  ConsNeoplasmeConnuMod                 ; 
    final TextField  ConsNeoplasmePreciseMod               ;                            
    final TextField  ConsDyslipidemieMod                   ;                 
    final TextField  ConsDiabeteMod                        ;                 
    final TextField  ConsTypeDiabeteMod                    ;                
    final DatePicker  ConsDepuisDMod                        ;                
    final TextField  ConsHTAMod                            ;                
    final TextArea   ConsTRTMod                            ;          
    final TextArea   ConsAutreTaresMod                     ; 
    
        
    final HBox         barOutil            = new HBox(2);
    final Button       ModifButton         = new Button();
    final ImageView    ModifImg            = new ImageView(new Image(getClass().getResourceAsStream("Images/15.jpg")));
    final Button       EnregButton         = new Button();  
    final ImageView    EnregfImg           = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png")));
    final Button       SuppButton          = new Button();
    final ImageView    SuppImg             = new ImageView(new Image(getClass().getResourceAsStream("Images/1_1.jpg")));
    
    final VBox         vbMod           = new VBox(5);
    final Label        IndModifS       = new Label();
    final Hyperlink    hperAnnul       = new Hyperlink("Ou Annuler l'opération ... ");
    final ImageView    IndImgS         = new ImageView(new Image(getClass().getResourceAsStream("Images/31.jpg")));
    final ImageView    IndImgF         = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg")));
    ///////////////////////////////////////////////////////////////////////////////////////////////
           final Label       IndIns        = new Label();
           final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
           final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
           
            int TypeMod  = 0;
            int DejaMode = 0;
    public ANTCDpersonnelSpace(int TypeCCP,String NumDossier) throws SQLException{
    vbMod.setVisible(false);
    ModifImg.setFitHeight(50);   ModifImg.setPreserveRatio(true);
    ModifButton.setGraphic(ModifImg);
    EnregfImg.setFitHeight(50);  EnregfImg.setPreserveRatio(true); EnregButton.setDisable(true);
    EnregButton.setGraphic(EnregfImg);
    SuppImg.setFitHeight(50);    SuppImg.setPreserveRatio(true);
    SuppButton.setGraphic(SuppImg);
    barOutil.getChildren().addAll(ModifButton,SuppButton,EnregButton);
    barOutil.getStyleClass().add("barOutil");
    
    IndImgS.setFitHeight(50); IndImgS.setPreserveRatio(true);
    IndImgF.setFitHeight(50); IndImgF.setPreserveRatio(true);
        /////
        //   
        ImgSucc.setFitHeight(50);          ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);    ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        //
        /////
        final  GridPane     grid      =    new   GridPane();
        grid.setVgap(5);
        grid.setHgap(7);
        
        grid.add(HepatopathiesSousJacent,0, 0);
        
        OuiHepathie.setToggleGroup(Tgroup1);  OuiHepathie.setUserData("Oui"); OuiHepathie.setSelected(true);
        OuiHepathie.setSelected(true);
        grid.add(OuiHepathie,1,0);
        NonHepathie.setToggleGroup(Tgroup1);   NonHepathie.setUserData("Non");
        grid.add(NonHepathie,2,0);
        ///////////
        ////
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
        ////
        ///////////
        depuis.setDayCellFactory(dayCellFactory);
        depuis.setPromptText("Depuis ");
        depuis.setValue(LocalDate.now());
        final Label HepathieDepuis       = new Label("Depuis :");  
        grid.add(HepathieDepuis, 0,1);  grid.add(depuis,1, 1);
        
        final VBox    vbPrecise    =  new VBox();
        vbPrecise.setPadding(new Insets(10,10,10,10));
        vbPrecise.setSpacing(5);
        Autre  =  champSaisierA();
        hepathieChronque.setToggleGroup(Tgroup20);   cirrhose.setToggleGroup(Tgroup20);
        AutreRad.setUserData("Autre");  NASH.setUserData("NASH");
        viraleB.setUserData("viraleB"); viraleC.setUserData("viraleC");
        Autoimmun.setUserData("Autoimmun");
        
        vbPrecise.getChildren().addAll(hepathieChronque,cirrhose,sepH,viraleB,viraleC,NASH,Autoimmun,AutreRad,Autre);
        viraleB.setToggleGroup(Tgroup21); viraleC.setToggleGroup(Tgroup21);
        NASH.setToggleGroup(Tgroup21);    Autoimmun.setToggleGroup(Tgroup21);
        AutreRad.setToggleGroup(Tgroup21);
        
        
        AutreRad.setOnAction((ActionEvent)->{
            if(AutreRad.isSelected())
            Autre.setDisable(false);
            else {Autre.setDisable(true); Autre.setText("");}
        });
        Tgroup20.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value,
        Toggle new_value)->{
         if(hepathieChronque.isSelected() || cirrhose.isSelected()){
             
             viraleB.setDisable(false);   viraleC.setDisable(false);  NASH.setDisable(false); 
             Autoimmun.setDisable(false); AutreRad.setDisable(false);
         }
        });
        Tgroup21.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov,Toggle old_value,
        Toggle new_value)->{
            if( viraleB.isSelected() || viraleC.isSelected() ||  NASH.isSelected() || 
             Autoimmun.isSelected() ){
                Autre.setDisable(true);Autre.setText("");
            }
        });
        
       
        
        
        Autre.setPrefWidth(150);
        Autre.setPrefHeight(80);
        Autre.setPromptText("Autre ");
        causeTitled.setContent(vbPrecise);
        causeTitled.setText("Préciser ");
        
        
        final VBox    vbContage          =  new VBox();
        vbContage.setPadding(new Insets(10,10,10,10));
        vbContage.setSpacing(5);
        AutreContage = champSaisierA();
        vbContage.getChildren().addAll(TransfusionSanguine,ExtractionDentaireTraditionelle,Sacrification,Tatouage,Chirugie,AutreContage);
        AutreContage.setPrefWidth(150);
        AutreContage.setPrefHeight(80);
        AutreContage.setPromptText("Autre ");
        contageViralAB.setText("Contage Virale B et C");
        contageViralAB.setContent(vbContage);
        
        
        final VBox    vbPrisedAlcool    =  new VBox();
        vbPrisedAlcool.setPadding(new Insets(10,10,10,10));
        vbPrisedAlcool.setSpacing(5);
        duree       = champSaisier();
        quantite    = champSaisier();
        nature      = champSaisier();
        sevrage     = champSaisier(); 
        vbPrisedAlcool.getChildren().addAll(duree,quantite,nature,sevrage);
        duree.setPromptText("Duree");
        quantite.setPromptText("Quantite ");
        nature.setPromptText("Nature");
        sevrage.setPromptText("Sevrage ");
        
        PriseDalcool.setText("Prise d'Alcool ");
        PriseDalcool.setContent(vbPrisedAlcool);
        
        accord.getPanes().addAll(causeTitled,contageViralAB);
        viraleB.setDisable(true);  viraleC.setDisable(true); NASH.setDisable(true);     
        Autoimmun.setDisable(true); AutreRad.setDisable(true);
         Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov , Toggle old_value,
        Toggle new_value)->{
           if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
               grid.getChildren().removeAll(depuis,accord);
               //
          TransfusionSanguine.setSelected(false);ExtractionDentaireTraditionelle.setSelected(false);
          Sacrification.setSelected(false);      Tatouage.setSelected(false);Chirugie.setSelected(false);
          AutreContage.setText("");
          hepathieChronque.setSelected(false); cirrhose.setSelected(false);
          viraleB.setSelected(false);    AutreRad.setSelected(false);  viraleC.setSelected(false);
          NASH.setSelected(false);       Autoimmun.setSelected(false);
          Autre.setDisable(true);        Autre.setText("");
          viraleB.setDisable(true);  viraleC.setDisable(true); NASH.setDisable(true);     
          Autoimmun.setDisable(true); AutreRad.setDisable(true);
          Autre.setText("");  Autre.setDisable(true);

               //
               }
           else {
               grid.getChildren().addAll(depuis,accord);
           }
            
        });
        grid.add(accord, 0,2,1,8);
        grid.add(PriseDalcool,0,10);
       
        //final  Separator      sepANTCDp     =  new Separator();
        //sepANTCDp.setOrientation(Orientation.VERTICAL);
        //grid.add(sepANTCDp,0,3,1,9);
        
        QteJ  = champSaisier();
        QteJ.setPromptText("qt en nbre de tasse /j");
        grid.add(priseDeCafe,0,11);
        grid.add(OuiPCafe,1,11);       grid.add(NonPCafe,2,11);   grid.add(QteJ,3,11);
        
        OuiPCafe.setUserData("Oui");        NonPCafe.setUserData("Non");
        OuiPCafe.setToggleGroup(Tgroup6);   NonPCafe.setToggleGroup(Tgroup6); OuiPCafe.setSelected(true);
        Tgroup6.selectedToggleProperty().addListener((ObservableValue<?extends Toggle>ov , Toggle old_value,
         Toggle new_value)-> {
            if(Tgroup6.getSelectedToggle().getUserData().equals("Non")){
                grid.getChildren().removeAll(QteJ);QteJ.setText("");
            }
            else {grid.getChildren().add(QteJ);}
        });
        
        grid.add(priseDeCannabis, 0,12);
        
        OuiPC.setToggleGroup(Tgroup2);OuiPC.setUserData("Oui");OuiPC.setSelected(true);
        grid.add(OuiPC,1,12);
        NonPC.setToggleGroup(Tgroup2);NonPC.setUserData("Non");
        grid.add(NonPC,2,12);
        
        MaladieAutoImmune = champSaisier();
        MaladieAutoImmune.setPromptText("Maladie auto-immune");
        grid.add(MaladieAutoImmune,0,13);
        
        
        grid.add(ContraceptionOrale ,0,14);
        
        OuiContra.setToggleGroup(Tgroup7);  NonContra.setToggleGroup(Tgroup7); OuiContra.setSelected(true);
        molecule   = champSaisier();
        molecule.setPromptText(" molécule");
        grid.add(OuiContra,1,14); OuiContra.setUserData("Oui");
        dureeCO   = champSaisier();
        dureeCO.setPromptText("Durée");
        grid.add(NonContra,2,14); NonContra.setUserData("Non");
        grid.add(molecule, 0,15);  grid.add(dureeCO,1,15,3,1);dureeCO.setPrefWidth(100);
        Tgroup7.selectedToggleProperty().addListener((ObservableValue<?extends Toggle>ov , Toggle old_value ,
        Toggle new_value)->{
            if(Tgroup7.getSelectedToggle().getUserData().equals("Non")){
               grid.getChildren().removeAll(molecule,dureeCO);molecule.setText("");dureeCO.setText("");
            }else {
                grid.getChildren().addAll(molecule,dureeCO);
            }
        });
        
        grid.add(NeoplasmeConnu, 0,16);
         
         OuiNC.setToggleGroup(Tgroup3);
        grid.add(OuiNC,1,16);   OuiNC.setUserData("Oui");OuiNC.setSelected(true);
         NonNC.setToggleGroup(Tgroup3);
        grid.add(NonNC,2,16);   NonNC.setUserData("Non");
        
        preciseNeo  = champSaisier();
        grid.add(preciseNeo,3,16,3,1); preciseNeo.setPromptText("Préciser ");
        Tgroup3.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value,
        Toggle new_value)->{
            if(Tgroup3.getSelectedToggle().getUserData().equals("Non")){
                grid.getChildren().remove(preciseNeo);preciseNeo.setText("");
            }else {
                grid.getChildren().add(preciseNeo);
            }
        });
        
        Dyslipidemei  = champSaisier();
        Dyslipidemei.setPromptText("Dyslipidémie ");
        grid.add(Dyslipidemei, 0,17);
        
        grid.add(diabete,0,18);
         
         OuiDiabete.setToggleGroup(Tgroup8);   OuiDiabete.setUserData("Oui"); OuiDiabete.setSelected(true);
         NonDiabete.setToggleGroup(Tgroup8);   NonDiabete.setUserData("Non");
         grid.add(OuiDiabete,1,18);   grid.add(NonDiabete,2,18);
         
         type1.setToggleGroup(Tgroup4);type1.setUserData("type1");type1.setSelected(true);
         grid.add(type1,1,19);
         type2.setToggleGroup(Tgroup4);type2.setUserData("type2");
         grid.add(type2,2,19);
         
         depuisD.setDayCellFactory(dayCellFactory);
         depuisD.setValue(LocalDate.now());
         depuisD.setPromptText("Depuis ");
         grid.add(depuisD,3,19);
         
         Tgroup8.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov , Toggle old_value,
         Toggle new_value)-> {
             if(Tgroup8.getSelectedToggle().getUserData().equals("Non")){
                 grid.getChildren().removeAll(type1,type2,depuisD);Tgroup4.getSelectedToggle().setSelected(false);
                 depuisD.setValue(null);
             }else {
                 grid.getChildren().addAll(type1,type2,depuisD);
                 type1.setSelected(true); depuisD.setValue(LocalDate.now());
             }
         });
         
         grid.add(HTA, 0,20);
         
         OuiHta.setToggleGroup(Tgroup5);OuiHta.setUserData("Oui");OuiHta.setSelected(true);
         grid.add(OuiHta,1, 20);
         NonHta.setToggleGroup(Tgroup5);NonHta.setUserData("Non");
         grid.add(NonHta,2,20);
         
         preciseTrt  = champSaisierA();
         preciseTrt.setPromptText("préciser trt ");
         preciseTrt.setPrefWidth(150);
         preciseTrt.setPrefHeight(50);
         grid.add(preciseTrt,3,20);
         
         autreTares = champSaisierA();
         autreTares.setPrefWidth(150);
         autreTares.setPrefHeight(50);
         autreTares.setPromptText("Autre Tares  ");
         
         grid.add(autreTares, 0,22);
        
         //
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
                    IndIns.setText(" L’insertion des ATCDS\n Personnel au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des ATCDS\n Personnel est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des ATCDS au niveau\n d'un dossier   ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(ANTCDpersonnelSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////***********************Partie Consultation**********************************************////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final  GridPane     gridC      =    new   GridPane();
        gridC.setVgap(5);
        gridC.setHgap(7);
           final Label ConsATCDp                   =   new Label("ATCDS Personnel : "); gridC.add(ConsATCDp, 0,0); ConsATCDp.getStyleClass().add("setStyleCirconsanceDic");
    final Label  TConsHepathieSousJacent            = new Label("Hepatopathies sous jacentes            :");                                gridC.add(TConsHepathieSousJacent, 0,1,2,1);   gridC.add(ConsHepathieSousJacent, 5,1); 
    final Label  TConsDepuis                        = new Label("Depuis                                 :");                                gridC.add(TConsDepuis, 0,2,3,1);               gridC.add(ConsDepuis, 5,2);
    final Label  TConsPrecise                       = new Label("Precise                                :");                                gridC.add(TConsPrecise, 0,3,3,1);              gridC.add(ConsPrecise, 5,3);
    final Label  TConsCause                         = new Label("Cause                                  :");                                gridC.add(TConsCause,0,4,2,3);                 gridC.add(ConsCause,5,4,2,3);       
      final Label ContageVab                       =   new Label("Contage Virale B et C  :");                                               gridC.add(ContageVab, 0,7,3,1);
      ContageVab.getStyleClass().add("styleLabel");
    final Label  TConsTransSang                     = new Label("- transfusion sanguine                 :");                                gridC.add(TConsTransSang,0,8,3,1);             gridC.add(ConsTransSang,5,8);
    final Label  TConsExtrDenTrad                   = new Label("- extraction dentaire traditionnelle   :");                                gridC.add(TConsExtrDenTrad,0,9,3,1);           gridC.add(ConsExtrDenTrad,5,9);
    final Label  TConsSacrification                 = new Label("- scarification                        :");                                gridC.add(TConsSacrification,0,10,3,1);        gridC.add(ConsSacrification,5,10);
    final Label  TConsTatouage                      = new Label("- tatouage                             :");                                gridC.add(TConsTatouage, 0,11,3,1);            gridC.add(ConsTatouage, 5,11);
    final Label  TConsChirurgie                     = new Label("- chirurgie                            :");                                gridC.add(TConsChirurgie,0,12,3,1);            gridC.add(ConsChirurgie,5,12);
    final Label  TConsAutre                         = new Label("- autre  :");                                                              gridC.add(TConsAutre,0,13,3,3);                gridC.add(ConsAutre,5,13,2,3);        
     final Label  PriseDalcool                            = new Label("Prise d'alccol    :");                                               gridC.add(PriseDalcool,0,16,3,1);
     PriseDalcool.getStyleClass().add("styleLabel");
    final Label  TConsAlcoolDuree                   = new Label("Duree                                  :");                                gridC.add(TConsAlcoolDuree,0,17,3,1);          gridC.add(ConsAlcoolDuree,5,17);
    final Label  TConsAlcoolQuantite                = new Label("Quantite                               :");                                gridC.add(TConsAlcoolQuantite,0,18,3,1);       gridC.add(ConsAlcoolQuantite,5,18);
    final Label  TConsAlcoolNature                  = new Label("Nature                                 :");                                gridC.add(TConsAlcoolNature, 0,19,3,1);        gridC.add(ConsAlcoolNature, 5,19);
    final Label  TConsAlcoolSevrage                 = new Label("Sevrage                                :");                                gridC.add(TConsAlcoolSevrage,0,20,3,1);        gridC.add(ConsAlcoolSevrage,5,20);
    final Label  TConsCafe                          = new Label("Pise de Cafe                           :");                                gridC.add(TConsCafe,0,22,3,1);                 gridC.add(ConsCafe,5,22);
    final Label  TConsCafeNbrDeTasse                = new Label("qt en Nombre de Tasse                  :");                                gridC.add(TConsCafeNbrDeTasse,0,23,3,1);       gridC.add(ConsCafeNbrDeTasse,5,23);
    final Label  TConsCannabis                      = new Label("Prise de Cannabis                      :");                                gridC.add(TConsCannabis,0,24,3,1);             gridC.add(ConsCannabis,5,24);
    final Label  TConsMaladieAutoImmune             = new Label("Maldie Auto immune                     :");                                gridC.add(TConsMaladieAutoImmune, 0,25,3,1);   gridC.add(ConsMaladieAutoImmune, 5,25);
    final Label  TConsContreOrale                   = new Label("Contracéption Orale                    :");                                gridC.add(TConsContreOrale, 0,26,3,1);         gridC.add(ConsContreOrale, 5,26);
    final Label  TConsMolecule                      = new Label("Molecule                               :");                                gridC.add(TConsMolecule, 0,27,3,1);            gridC.add(ConsMolecule, 5,27);                
    final Label  TConsDuree                         = new Label("Dree                                   :");                                gridC.add(TConsDuree, 0,28,3,1);               gridC.add(ConsDuree, 5,28);
    final Label  TConsNeoplasmeConnu                = new Label("Neoplasme connu                        :");                                gridC.add(TConsNeoplasmeConnu, 0,29,3,1);      gridC.add(ConsNeoplasmeConnu, 5,29);
    final Label  TConsNeoplasmePrecise              = new Label("precise Neoplamse                      :");                                gridC.add(TConsNeoplasmePrecise, 0,30,3,2);    gridC.add(ConsNeoplasmePrecise, 5,30,2,2); 
    final Label  TConsDyslipidemie                  = new Label("Dyslipidemie                           :");                                gridC.add(TConsDyslipidemie, 0,32,3,1);        gridC.add(ConsDyslipidemie, 5,32);
    final Label  TConsDiabete                       = new Label("Diabete                                :");                                gridC.add(TConsDiabete, 0,33,3,1);             gridC.add(ConsDiabete, 5,33);
    final Label  TConsTypeDiabete                   = new Label("Type de diabete                        :");                                gridC.add(TConsTypeDiabete, 0,34,3,1);         gridC.add(ConsTypeDiabete, 5,34);
    final Label  TConsDepuisD                       = new Label("depuis                                 :");                                gridC.add(TConsDepuisD,0,35,3,1);              gridC.add(ConsDepuisD,5,35);
    final Label  TConsHTA                           = new Label("HTA                                    :");                                gridC.add(TConsHTA, 0,36,3,1);                 gridC.add(ConsHTA, 5,36);
    final Label  TConsTRT                           = new Label("TRT                                    :");                                gridC.add(TConsTRT, 0,37,3,1);                 gridC.add(ConsTRT, 5,37);
    final Label  TConsAutreTares                    = new Label("Autre Tares                            :");                                gridC.add(TConsAutreTares,0,38,3,1);           gridC.add(ConsAutreTares,5,38,2,1);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //************** Partie Modification ****************************************************/
    ConsHepathieSousJacentMod            =this.champSaisier();  ConsHepathieSousJacentMod.setMaxWidth(200);
    ConsDepuisMod                        =new DatePicker();     ConsDepuisMod.setMaxWidth(200);
    ConsPreciseMod                       =this.champSaisier();  ConsPreciseMod.setMaxWidth(200);    
    ConsCauseMod                         =this.champSaisier();  ConsCauseMod.setMaxWidth(200);    
              
    ConsTransSangMod                     =this.champSaisier();  ConsTransSangMod.setMaxWidth(200);     
    ConsExtrDenTradMod                   =this.champSaisier();  ConsExtrDenTradMod.setMaxWidth(200);  
    ConsSacrificationMod                 =this.champSaisier();  ConsSacrificationMod.setMaxWidth(200);   
    ConsTatouageMod                      =this.champSaisier();  ConsTatouageMod.setMaxWidth(200);   
    ConsChirurgieMod                     =this.champSaisier();  ConsChirurgieMod.setMaxWidth(200);	
    ConsAutreMod                         =this.champSaisierA(); ConsAutreMod.setMaxWidth(200);     ConsAutreMod.setMaxHeight(70);
                                
    ConsAlcoolDureeMod                   =this.champSaisier();  ConsAlcoolDureeMod.setMaxWidth(200);                     
    ConsAlcoolQuantiteMod                =this.champSaisier();  ConsAlcoolQuantiteMod.setMaxWidth(200);                            
    ConsAlcoolNatureMod                  =this.champSaisier();  ConsAlcoolNatureMod.setMaxWidth(200);                             
    ConsAlcoolSevrageMod                 =this.champSaisier();  ConsAlcoolSevrageMod.setMaxWidth(200);                            
    ConsCafeMod                          =this.champSaisier();  ConsCafeMod.setMaxWidth(200);             
    ConsCafeNbrDeTasseMod                =this.champSaisier();  ConsCafeNbrDeTasseMod.setMaxWidth(200);             
    ConsCannabisMod                      =this.champSaisier();  ConsCannabisMod.setMaxWidth(200);             
    ConsMaladieAutoImmuneMod             =this.champSaisier();  ConsMaladieAutoImmuneMod.setMaxWidth(200);             
    ConsContreOraleMod                   =this.champSaisier();  ConsContreOraleMod.setMaxWidth(200);              
    ConsMoleculeMod                      =this.champSaisier();  ConsMoleculeMod.setMaxWidth(200);                                        
    ConsDureeMod                         =this.champSaisier();  ConsDureeMod.setMaxWidth(200);                                   
    ConsNeoplasmeConnuMod                =this.champSaisier();  ConsNeoplasmeConnuMod .setMaxWidth(200);
    ConsNeoplasmePreciseMod              =this.champSaisier();  ConsNeoplasmePreciseMod.setMaxWidth(200);                        
    ConsDyslipidemieMod                  =this.champSaisier();  ConsDyslipidemieMod.setMaxWidth(200);              
    ConsDiabeteMod                       =this.champSaisier();  ConsDiabeteMod.setMaxWidth(200);              
    ConsTypeDiabeteMod                   =this.champSaisier();  ConsTypeDiabeteMod.setMaxWidth(200);             
    ConsDepuisDMod                       =new DatePicker();     ConsDepuisDMod.setMaxWidth(200);          
    ConsHTAMod                           =this.champSaisier();  ConsHTAMod.setMaxWidth(200);             
    ConsTRTMod                           =this.champSaisierA(); ConsTRTMod .setMaxWidth(200);        ConsTRTMod.setMaxHeight(70);
    ConsAutreTaresMod                    =this.champSaisierA(); ConsAutreTaresMod .setMaxWidth(200); ConsAutreTaresMod.setMaxHeight(70);
    /*******/
      final ImageView ImgEnregMod    = new ImageView(new Image(getClass().getResourceAsStream("Images/20_1.jpg")));
      ImgEnregMod.setFitHeight(40); ImgEnregMod.setPreserveRatio(true);
      
      final ImageView ImgEnregSup   = new ImageView(new Image(getClass().getResourceAsStream("Images/12_1.jpg")));
      ImgEnregSup.setFitHeight(40); ImgEnregSup.setPreserveRatio(true);
      
      vbMod.getChildren().addAll(IndModifS,hperAnnul);
     /*/*/
    
    ModifButton.setOnAction((ActionEvent)->{
        
        TypeMod = 1;
    gridC.getChildren().removeAll(ConsHepathieSousJacent,ConsDepuis,ConsPrecise,ConsCause,ConsTransSang,ConsExtrDenTrad,ConsSacrification,ConsTatouage,ConsChirurgie,ConsAutre,ConsAlcoolDuree,ConsAlcoolQuantite,ConsAlcoolNature,ConsAlcoolSevrage,ConsCafe,ConsCafeNbrDeTasse,ConsCannabis,ConsMaladieAutoImmune,ConsContreOrale,ConsMolecule,ConsDuree,ConsNeoplasmePrecise,ConsDyslipidemie,ConsDiabete,ConsTypeDiabete,ConsDepuisD,ConsHTA,ConsTRT,ConsAutreTares);
    gridC.add(ConsHepathieSousJacentMod, 5,1);   
    gridC.add(ConsDepuisMod, 5,2);
    gridC.add(ConsPreciseMod, 5,3);
    gridC.add(ConsCauseMod,5,4,2,2);       
       
    gridC.add(ConsTransSangMod,5,8);
    gridC.add(ConsExtrDenTradMod,5,9);
    gridC.add(ConsSacrificationMod,5,10);
    gridC.add(ConsTatouageMod, 5,11);
    gridC.add(ConsChirurgieMod,5,12);
    gridC.add(ConsAutreMod,5,13,2,2);
    gridC.add(ConsAlcoolDureeMod,5,17);
    gridC.add(ConsAlcoolQuantiteMod,5,18);
    gridC.add(ConsAlcoolNatureMod, 5,19);
    gridC.add(ConsAlcoolSevrageMod,5,20);
    gridC.add(ConsCafeMod,5,22);
    gridC.add(ConsCafeNbrDeTasseMod,5,23);
    gridC.add(ConsCannabisMod,5,24);
    gridC.add(ConsMaladieAutoImmuneMod, 5,25);
    gridC.add(ConsContreOraleMod, 5,26);
    gridC.add(ConsMoleculeMod, 5,27);                
    gridC.add(ConsDureeMod, 5,28);
    gridC.add(ConsNeoplasmeConnuMod, 5,29);
    gridC.add(ConsNeoplasmePreciseMod, 5,30,2,2); 
    gridC.add(ConsDyslipidemieMod, 5,32);
    gridC.add(ConsDiabeteMod, 5,33);
    gridC.add(ConsTypeDiabeteMod, 5,34);
    gridC.add(ConsDepuisDMod,5,35);      
    gridC.add(ConsHTAMod, 5,36);
    gridC.add(ConsTRTMod, 5,37);
    gridC.add(ConsAutreTaresMod,5,38,2,2);
    hperAnnul.setVisible(true);
    AffectChampModi();
    EnregButton.setDisable(false);
    ModifButton.setDisable(true);
    
    
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer les Modification");
    IndModifS.setGraphic(ImgEnregMod);
    vbMod.setVisible(true);
    
    DejaMode = 1;
    });
    IndModifS.getStyleClass().add("erreurchamp");
     SuppButton.setOnAction((ActionEvent)->{
         hperAnnul.setVisible(true);
         
       TypeMod = 0;
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer la Suppression du document");
    IndModifS.setGraphic(ImgEnregSup);
    vbMod.setVisible(true);
    EnregButton.setDisable(false);
        
    });
    hperAnnul.setOnAction((ActionEvent)->{
        if(DejaMode == 1){
             gridC.getChildren().removeAll(ConsHepathieSousJacentMod,ConsDepuisMod,ConsPreciseMod,ConsCauseMod,ConsTransSangMod,       
             ConsExtrDenTradMod,ConsSacrificationMod,ConsTatouageMod,ConsChirurgieMod,ConsAutreMod,ConsAlcoolDureeMod,ConsAlcoolQuantiteMod,
             ConsAlcoolNatureMod,ConsAlcoolSevrageMod, ConsCafeMod,ConsCafeNbrDeTasseMod,ConsCannabisMod,ConsMaladieAutoImmuneMod,
             ConsContreOraleMod,ConsMoleculeMod,ConsDureeMod,ConsNeoplasmeConnuMod,ConsNeoplasmePreciseMod,
             ConsDyslipidemieMod,ConsDiabeteMod,ConsTypeDiabeteMod,ConsDepuisDMod,ConsHTAMod,ConsTRTMod,ConsAutreTaresMod);
             
              gridC.getChildren().addAll(ConsHepathieSousJacent,ConsDepuis,ConsPrecise,ConsCause,ConsTransSang,ConsExtrDenTrad,
                    ConsSacrification,ConsTatouage,ConsChirurgie,ConsAutre,ConsAlcoolDuree,ConsAlcoolQuantite,ConsAlcoolNature,
                    ConsAlcoolSevrage,ConsCafe,ConsCafeNbrDeTasse,ConsCannabis,ConsMaladieAutoImmune,ConsContreOrale,ConsMolecule,
                    ConsDuree,ConsNeoplasmePrecise,ConsDyslipidemie,ConsDiabete,ConsTypeDiabete,ConsDepuisD,ConsHTA,ConsTRT,ConsAutreTares);
        
        DejaMode = 0;
        }
              
     vbMod.setVisible(false);
     EnregButton.setDisable(true);
     ModifButton.setDisable(false);
     
     
             
    });
    /*****/
    EnregButton.setOnAction((ActionEvent)->{
        hperAnnul.setVisible(false);
       if(TypeMod == 1){
         try {
            int j = this.UpdateSGBD(NumDossier);
            //this.requestParentLayout();
            
            gridC.getChildren().removeAll(ConsHepathieSousJacentMod,ConsDepuisMod,ConsPreciseMod,ConsCauseMod,ConsTransSangMod,       
             ConsExtrDenTradMod,ConsSacrificationMod,ConsTatouageMod,ConsChirurgieMod,ConsAutreMod,ConsAlcoolDureeMod,ConsAlcoolQuantiteMod,
             ConsAlcoolNatureMod,ConsAlcoolSevrageMod, ConsCafeMod,ConsCafeNbrDeTasseMod,ConsCannabisMod,ConsMaladieAutoImmuneMod,
             ConsContreOraleMod,ConsMoleculeMod,ConsDureeMod,ConsNeoplasmeConnuMod,ConsNeoplasmePreciseMod,
             ConsDyslipidemieMod,ConsDiabeteMod,ConsTypeDiabeteMod,ConsDepuisDMod,ConsHTAMod,ConsTRTMod,ConsAutreTaresMod);
            this.ConsultationE(NumDossier);
            gridC.getChildren().addAll(ConsHepathieSousJacent,ConsDepuis,ConsPrecise,ConsCause,ConsTransSang,ConsExtrDenTrad,
                    ConsSacrification,ConsTatouage,ConsChirurgie,ConsAutre,ConsAlcoolDuree,ConsAlcoolQuantite,ConsAlcoolNature,
                    ConsAlcoolSevrage,ConsCafe,ConsCafeNbrDeTasse,ConsCannabis,ConsMaladieAutoImmune,ConsContreOrale,ConsMolecule,
                    ConsDuree,ConsNeoplasmePrecise,ConsDyslipidemie,ConsDiabete,ConsTypeDiabete,ConsDepuisD,ConsHTA,ConsTRT,ConsAutreTares);
            
             EnregButton.setDisable(true);
             ModifButton.setDisable(false);
             if(j==1){
             IndModifS.setText("Les Modification sont Enregistrées ");
             IndModifS.setGraphic(IndImgS);
             }else{
               IndModifS.setText("doncument n'est pas enregistré ");
               IndModifS.setGraphic(IndImgF);  
             }
             
         } catch (SQLException ex) {
            Logger.getLogger(ANTCDpersonnelSpace.class.getName()).log(Level.SEVERE, null, ex);
        } } else {
           
           try {
               int j = this.DeleteSGBD(NumDossier);
               this.ConsultationE(NumDossier);
               if(j == 1){
               IndModifS.setText("Le Document est Supprimé ");
             IndModifS.setGraphic(IndImgS);
               }else
               { IndModifS.setText("doncument n'est pas enregistré ");
               IndModifS.setGraphic(IndImgF);
                   
                }
           
           } catch (SQLException ex) {
               Logger.getLogger(ANTCDpersonnelSpace.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        
    } );
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
        grid.add(Ajouter, 3,24);
        grid.add(IndIns, 0, 24,5,5);
         
        
        grid.setPadding(new Insets(30,10,10,30));
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        if(TypeCCP == 0)
        getChildren().add(pane);
        else{
            this.ConsultationE(NumDossier);
        gridC.setPadding(new Insets(30,10,10,30));
        final StackPane   pane1     =  new StackPane();
        pane1.getStyleClass().add("setStylingRootCons");
        barOutil.setTranslateX(100);
        gridC.add(barOutil, 3,41,3,2);
        gridC.add(vbMod,0,41,3,3);
        gridC.setMinWidth(900);
        pane1.getChildren().add(gridC);
        getChildren().add(pane1);
        }
    }


    public String getHepathie() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDepuis() {
        return depuis.getValue();
    }


    public String getHepathieChronque() {
        if(hepathieChronque.isSelected())
        return hepathieChronque.getText();
        else return "";
    }

    public String getCirrhose() {
        if(cirrhose.isSelected())
        return cirrhose.getText();
        else return "";
    }
    public String getPreciseHS(){
        return getHepathieChronque()+getCirrhose();
    }


    public String getViraleB() { 
        if(viraleB.isSelected())
        return viraleB.getText();
        else return "";
    }

    public String getViraleC() {
        if(viraleC.isSelected())
        return viraleC.getText();
        else return "";
    }

    public String getNASH() {
        if(NASH.isSelected())
        return NASH.getText();
        else return "";
    }

    public String getAutoimmun() {
        if(Autoimmun.isSelected())
        return Autoimmun.getText();
        else return "";
    }

    public String getAutre() { 
        return  Autre.getText();
    }
    public String getCauseHS(){
        return  getViraleB() + getViraleC() + getNASH() + getAutoimmun() + getAutre();
    }

    public String getTransfusionSanguine() {
        if(TransfusionSanguine.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getExtractionDentaireTraditionelle() {
        if(ExtractionDentaireTraditionelle.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getSacrification() {
        if(Sacrification.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getTatouage() {
        if(Tatouage.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getChirugie() {
        if(Chirugie.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getAutreContage() {
        return AutreContage.getText();
    }

    public String getDuree() {
        return duree.getText();
    }

    public String getQuantite() {
        return quantite.getText();
    }

    public String getNature() {
        return nature.getText();
    }

    public String getSevrage() {
        return sevrage.getText();
    }

    public String getPCafe() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }


    public String getQteJ() {
        return QteJ.getText();
    }

////////////////
    public String getPC() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getMaladieAutoImmune() {
        return MaladieAutoImmune.getText();
    }
///////
    public String getContra() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }


    public String getMolecule() {
        return molecule.getText();
    }

    public String getDureeCO() {
        return dureeCO.getText();
    }

    public String getNC() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getPreciseNeo() {
        return preciseNeo.getText();
    }

    public String getDyslipidemei() {
        return Dyslipidemei.getText();
    }

    public String getDiabete() {
        return Tgroup8.getSelectedToggle().getUserData().toString();
    }

    public String getType() {
        if(getDiabete().equals("Oui"))
        return Tgroup4.getSelectedToggle().getUserData().toString();
        else return "";
    }


    public LocalDate getDepuisD() {
        if(getDiabete().equals("Oui")){
        return depuisD.getValue();
        }else {
            return this.ConvertStrDate("1993-01-01");
        }
    }

    public String getHta() {
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }


    public String getPreciseTrt() {
        return preciseTrt.getText();
    }

    public String getAutreTares() {
        return autreTares.getText();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getHepathie()+"\n"+this.getDepuis()+"\n"+this.getHepathieChronque()+"\n"+
                this.getCirrhose()+"\n"+this.getViraleB()+"\n"+this.getViraleC()+"\n"+this.getNASH()+"\n"+
                this.getAutoimmun()+"\n"+this.getAutre()+"\n"+this.getTransfusionSanguine()+"\n"+this.getExtractionDentaireTraditionelle()+"\n"+
                this.getSacrification()+"\n"+this.getTatouage()+"\n"+this.getChirugie()+"\n"+this.getAutreContage()+"\n"+
                this.getDuree()+"\n"+this.getQuantite()+"\n"+this.getNature()+"\n"+this.getSevrage()+"\n"+this.getPCafe()+"  "+this.getQteJ()+"\n"+
                this.getPC()+"\n"+this.getMaladieAutoImmune()+"\n"+this.getContra()+"\n"+this.getMolecule()+" "+this.getDureeCO()+"\n"+
                this.getNC()+" "+this.getPreciseNeo()+"\n"+this.getDyslipidemei()+"\n"+this.getDiabete()+"\n"+
                this.getType()+" "+this.getDepuisD()+"\n"+this.getHta()+" "+this.getPreciseTrt()+"\n"+this.getAutreTares());
    //NumDossierImp
      MiseAjour     bddInsert     =  new MiseAjour();
      int i =bddInsert.AddElement("insert into atcdspersonnel values(0,'"+getHepathie()+"','"+getDepuis()+"','"+getPreciseHS()+"','"+
      getTransfusionSanguine()+"','"+getExtractionDentaireTraditionelle()+"','"+getSacrification()+"','"+getTatouage()+"','"+
      getChirugie()+"','"+getAutreContage()+"','"+getDuree()+"','"+getQuantite()+"','"+getNature()+"','"+getSevrage()+"','"+
      getPCafe()+"','"+getQteJ()+"','"+getPC()+"','"+getMaladieAutoImmune()+"','"+getContra()+"','"+getMolecule()+"','"+
      getDureeCO()+"','"+getNC()+"','"+getPreciseNeo()+"','"+getDyslipidemei()+"','"+getDiabete()+"','"+getType()+"','"+
      getDepuisD()+"','"+getHta()+"','"+getPreciseTrt()+"','"+getAutreTares()+"','"+NumDossier+"','"+getCauseHS()+"')");
    return i;
    }
    public TextField champSaisier(){
 TextField textF = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(!text.matches("[,']")){
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

   return textF;  
    
}

    /**
     *
     * @return
     */
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////--------------- Les Fonctions de la Consultation-------------------------------------------/////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setConsHepathieSousJacent(String ConsHepathieSousJacent) {
     this.ConsHepathieSousJacent.setText(ConsHepathieSousJacent);
    }

    public void setConsDepuis(String ConsDepuis) {
        this.ConsDepuis.setText(ConsDepuis);
    }

    public void setConsPrecise(String ConsPrecise) {
        this.ConsPrecise.setText(ConsPrecise);
    }

    public void setConsCause(String ConsCause) {
        this.ConsCause.setText(ConsCause);
    }

    public void setConsTransSang(String ConsTransSang) {
        this.ConsTransSang.setText(ConsTransSang);
    }

    public void setConsExtrDenTrad(String ConsExtrDenTrad) {
        this.ConsExtrDenTrad.setText(ConsExtrDenTrad);
    }

    public void setConsSacrification(String ConsSacrification) {
        this.ConsSacrification.setText(ConsSacrification);
    }

    public void setConsTatouage(String ConsTatouage) {
        this.ConsTatouage.setText(ConsTatouage);
    }

    public void setConsChirurgie(String ConsChirurgie) {
        this.ConsChirurgie.setText(ConsChirurgie);
    }

    public void setConsAutre(String ConsAutre) {
        this.ConsAutre.setText(ConsAutre);
    }

    public void setConsAlcoolDuree(String ConsAlcoolDuree) {
        this.ConsAlcoolDuree.setText(ConsAlcoolDuree);
    }

    public void setConsAlcoolQuantite(String ConsAlcoolQuantite) {
        this.ConsAlcoolQuantite.setText(ConsAlcoolQuantite);
    }

    public void setConsAlcoolNature(String ConsAlcoolNature) {
        this.ConsAlcoolNature.setText(ConsAlcoolNature);
    }

    public void setConsAlcoolSevrage(String ConsAlcoolSevrage) {
        this.ConsAlcoolSevrage.setText(ConsAlcoolSevrage);
    }

    public void setConsCafe(String ConsCafe) {
        this.ConsCafe.setText(ConsCafe);
    }

    public void setConsCafeNbrDeTasse(String ConsCafeNbrDeTasse) {
        this.ConsCafeNbrDeTasse.setText(ConsCafeNbrDeTasse);
    }

    public void setConsCannabis(String ConsCannabis) {
        this.ConsCannabis.setText(ConsCannabis);
    }

    public void setConsMaladieAutoImmune(String ConsMaladieAutoImmune) {
        this.ConsMaladieAutoImmune.setText(ConsMaladieAutoImmune);
    }

    public void setConsContreOrale(String ConsContreOrale) {
        this.ConsContreOrale.setText(ConsContreOrale);
    }

    public void setConsMolecule(String ConsMolecule) {
        this.ConsMolecule.setText(ConsMolecule);
    }

    public void setConsDuree(String ConsDuree) {
        this.ConsDuree.setText(ConsDuree);
    }

    public void setConsNeoplasmeConnu(String ConsNeoplasmeConnu) {
        this.ConsNeoplasmeConnu.setText(ConsNeoplasmeConnu);
    }

    public void setConsNeoplasmePrecise(String ConsNeoplasmePrecise) {
        this.ConsNeoplasmePrecise.setText(ConsNeoplasmePrecise);
    }

    public void setConsDyslipidemie(String ConsDyslipidemie) {
        this.ConsDyslipidemie.setText(ConsDyslipidemie);
    }

    public void setConsDiabete(String ConsDiabete) {
        this.ConsDiabete.setText(ConsDiabete);
    }

    public void setConsTypeDiabete(String ConsTypeDiabete) {
        this.ConsTypeDiabete.setText(ConsTypeDiabete);
    }

    public void setConsDepuisD(String ConsDepuisD) {
        this.ConsDepuisD.setText(ConsDepuisD);
    }

    public void setConsHTA(String ConsHTA) {
        this.ConsHTA.setText(ConsHTA);
    }

    public void setConsTRT(String ConsTRT) {
        this.ConsTRT.setText(ConsTRT);
    }

    public void setConsAutreTares(String ConsAutreTares) {
        this.ConsAutreTares.setText(ConsAutreTares);
    }
    
    public void ConsultationE(String NumDossier) throws SQLException{
        ANTCDpersonnelClasse      ANTCDp  = null;
        Consultation   bddCons      = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from atcdspersonnel where NumDossier = '"+NumDossier+"'");
        while(res.next()){
            ANTCDp = new ANTCDpersonnelClasse(res.getString(2),res.getDate(3),res.getString(4),res.getString(32),res.getString(5),
            res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),
            res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),res.getString(18),res.getString(19),
            res.getString(20),res.getString(21),res.getString(22),res.getString(23),res.getString(24),res.getString(25),res.getString(26),
            res.getString(27),res.getString(28),res.getString(29),res.getString(30));
        }
        try {
        
        this.setConsHepathieSousJacent(ANTCDp.getHepathieSousJacent());
        this.setConsDepuis(ANTCDp.getDepuis().toString());
        this.setConsPrecise(ANTCDp.getPrecise());
        this.setConsCause(ANTCDp.getCause());
        this.setConsExtrDenTrad(ANTCDp.getExtrDenTrad());
        this.setConsTatouage(ANTCDp.getTatouage());
        this.setConsTransSang(ANTCDp.getTransSang());
        this.setConsSacrification(ANTCDp.getSacrification());
        this.setConsChirurgie(ANTCDp.getChirurgie());
        this.setConsAutre(ANTCDp.getAutre());
        
        this.setConsAlcoolDuree(ANTCDp.getAlcoolDuree());
        this.setConsAlcoolNature(ANTCDp.getAlcoolNature());
        this.setConsAlcoolQuantite(ANTCDp.getAlcoolQuantite());
        this.setConsAlcoolSevrage(ANTCDp.getAlcoolSevrage());
        
        this.setConsCafe(ANTCDp.getCafe());
        this.setConsCafeNbrDeTasse(ANTCDp.getCafeNbrDeTasse());
        this.setConsCannabis(ANTCDp.getCannabis());
        this.setConsMaladieAutoImmune(ANTCDp.getMaladieAutoImmune());
        this.setConsContreOrale(ANTCDp.getContreOrale());
        this.setConsMolecule(ANTCDp.getMolecule());
        this.setConsDuree(ANTCDp.getDuree());
        this.setConsNeoplasmeConnu(ANTCDp.getNeoplasmeConnu());
        this.setConsNeoplasmePrecise(ANTCDp.getNeoplasmePrecise());
        this.setConsDyslipidemie(ANTCDp.getDyslipidemie());
        this.setConsDiabete(ANTCDp.getDiabete());  this.setConsTypeDiabete(ANTCDp.getTypeDiabete());
        this.setConsDepuisD(ANTCDp.getDepuisD());  this.setConsHTA(ANTCDp.getHTA());
        this.setConsTRT(ANTCDp.getTRT());
        this.setConsAutreTares(ANTCDp.getAutreTares());
        }catch(Exception e){
         this.setConsHepathieSousJacent("-----");
        this.setConsDepuis("1999-09-09");
        this.setConsPrecise("-----");
        this.setConsCause("-----");
        this.setConsExtrDenTrad("-----");
        this.setConsTatouage("-----");
        this.setConsTransSang("-----");
        this.setConsSacrification("-----");
        this.setConsChirurgie("-----");
        this.setConsAutre("-----");
        
        this.setConsAlcoolDuree("-----");
        this.setConsAlcoolNature("-----");
        this.setConsAlcoolQuantite("-----");
        this.setConsAlcoolSevrage("-----");
        
        this.setConsCafe("-----");
        this.setConsCafeNbrDeTasse("-----");
        this.setConsCannabis("-----");
        this.setConsMaladieAutoImmune("-----");
        this.setConsContreOrale("-----");
        this.setConsMolecule("-----");
        this.setConsDuree("-----");
        this.setConsNeoplasmeConnu("-----");
        this.setConsNeoplasmePrecise("-----");
        this.setConsDyslipidemie("-----");
        this.setConsDiabete("-----");  this.setConsTypeDiabete("-----");
        this.setConsDepuisD("1999-09-09");  this.setConsHTA("-----");
        this.setConsTRT("-----");
        this.setConsAutreTares("-----");   
        }
        bddCons.CloseConnex();
        
        }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////// Methode De la Modification //////////////////////////////////////////////////////////////////////
    
    
     public String getConsHepathieSousJacentMod() {
        return ConsHepathieSousJacentMod.getText();
    }

    public LocalDate getConsDepuisMod() {
        return ConsDepuisMod.getValue();
    }

    public String getConsPreciseMod() {
        return ConsPreciseMod.getText();
    }

    public String getConsCauseMod() {
        return ConsCauseMod.getText();
    }



    public String getConsTransSangMod() {
        return ConsTransSangMod.getText();
    }

    public String getConsExtrDenTradMod() {
        return ConsExtrDenTradMod.getText();
    }

    public String getConsSacrificationMod() {
        return ConsSacrificationMod.getText();
    }

    public String getConsTatouageMod() {
        return ConsTatouageMod.getText();
    }

    public String getConsChirurgieMod() {
        return ConsChirurgieMod.getText();
    }

    public String getConsAutreMod() {
        return ConsAutreMod.getText();
    }

   

    public String getConsAlcoolDureeMod() {
        return ConsAlcoolDureeMod.getText();
    }

    public String getConsAlcoolQuantiteMod() {
        return ConsAlcoolQuantiteMod.getText();
    }

    public String getConsAlcoolNatureMod() {
        return ConsAlcoolNatureMod.getText();
    }

    public String getConsAlcoolSevrageMod() {
        return ConsAlcoolSevrageMod.getText();
    }

    public String getConsCafeMod() {
        return ConsCafeMod.getText();
    }

    public String getConsCafeNbrDeTasseMod() {
        return ConsCafeNbrDeTasseMod.getText();
    }

    public String getConsCannabisMod() {
        return ConsCannabisMod.getText();
    }

    public String getConsMaladieAutoImmuneMod() {
        return ConsMaladieAutoImmuneMod.getText();
    }

    public String getConsContreOraleMod() {
        return ConsContreOraleMod.getText();
    }

    public String getConsMoleculeMod() {
        return ConsMoleculeMod.getText();
    }

    public String getConsDureeMod() {
        return ConsDureeMod.getText();
    }

    public String getConsNeoplasmeConnuMod() {
        return ConsNeoplasmeConnuMod.getText();
    }

    public String getConsNeoplasmePreciseMod() {
        return ConsNeoplasmePreciseMod.getText();
    }

    public String getConsDyslipidemieMod() {
        return ConsDyslipidemieMod.getText();
    }

    public String getConsDiabeteMod() {
        return ConsDiabeteMod.getText();
    }

    public String getConsTypeDiabeteMod() {
        return ConsTypeDiabeteMod.getText();
    }

    public LocalDate getConsDepuisDMod() {
        return ConsDepuisDMod.getValue();
    }

    public String getConsHTAMod() {
        return ConsHTAMod.getText();
    }

    public String getConsTRTMod() {
        return ConsTRTMod.getText();
    }

    public String getConsAutreTaresMod() {
        return ConsAutreTaresMod.getText();
    }

    
    
    
    
    public void setConsHepathieSousJacentMod() {
        ConsHepathieSousJacentMod.setText(ConsHepathieSousJacent.getText());
    }

    public void setConsDepuisMod() {
        ConsDepuisMod.setValue(ConvertStrDate(ConsDepuis.getText()));
    }

    public void setConsPreciseMod() {
        ConsPreciseMod.setText(ConsPrecise.getText());
    }

    public void setConsCauseMod() {
        ConsCauseMod.setText(ConsCause.getText());
    }

 

    public void setConsTransSangMod() { 
        ConsTransSangMod.setText(ConsTransSang.getText());
    }
    public void setConsExtrDenTradMod() {
        ConsExtrDenTradMod.setText(ConsExtrDenTrad.getText());
    }

    public void setConsSacrificationMod() {
        ConsSacrificationMod.setText(ConsSacrification.getText());
    }

    public void setConsTatouageMod() {
        ConsTatouageMod.setText(ConsTatouage.getText());
    }

    public void setConsChirurgieMod() {
        ConsChirurgieMod.setText(ConsChirurgie.getText());
    }

    public void setConsAutreMod() {
        ConsAutreMod.setText(ConsAutre.getText());
    }

   

    public void setConsAlcoolDureeMod() {
        ConsAlcoolDureeMod.setText(ConsAlcoolDuree.getText());
    }

    public void setConsAlcoolQuantiteMod() {
        ConsAlcoolQuantiteMod.setText(ConsAlcoolQuantite.getText());
    }

    public void setConsAlcoolNatureMod() {
        ConsAlcoolNatureMod.setText(ConsAlcoolNature.getText());
    }//setConsHepathieSousJacentMod();setConsDepuisMod();setConsPreciseMod();setConsCauseMod();setConsTransSangMod();
     //setConsExtrDenTradMod();setConsSacrificationMod();setConsTatouageMod();setConsChirurgieMod();setConsAutreMod();
     //setConsAlcoolDureeMod();setConsAlcoolQuantiteMod();setConsAlcoolNatureMod();setConsAlcoolSevrageMod();setConsCafeMod();
     //setConsCafeNbrDeTasseMod();setConsCannabisMod()

    public void setConsAlcoolSevrageMod() {
        ConsAlcoolSevrageMod.setText(ConsAlcoolSevrage.getText());
    }

    public void setConsCafeMod() {
        ConsCafeMod.setText(ConsCafe.getText());
    }

    public void setConsCafeNbrDeTasseMod() {
        ConsCafeNbrDeTasseMod.setText(ConsCafeNbrDeTasse.getText());
    }

    public void setConsCannabisMod() {
        ConsCannabisMod.setText(ConsCannabis.getText());
    }

    public void setConsMaladieAutoImmuneMod() {
        ConsMaladieAutoImmuneMod.setText(ConsMaladieAutoImmune.getText());
    }//setConsHepathieSousJacentMod();setConsDepuisMod();setConsPreciseMod();setConsCauseMod();setConsTransSangMod();
     //setConsExtrDenTradMod();setConsSacrificationMod();setConsTatouageMod();setConsChirurgieMod();setConsAutreMod();
     //setConsAlcoolDureeMod();setConsAlcoolQuantiteMod();setConsAlcoolNatureMod();setConsAlcoolSevrageMod();setConsCafeMod();
     //setConsCafeNbrDeTasseMod();setConsCannabisMod();setConsMaladieAutoImmuneMod();setConsContreOraleMod();setConsMoleculeMod();
     //setConsDureeMod();setConsNeoplasmeConnuMod();

    public void setConsContreOraleMod() {
        ConsContreOraleMod.setText(ConsContreOrale.getText());
    }

    public void setConsMoleculeMod() {
        ConsMoleculeMod.setText(ConsMolecule.getText());
    }

    public void setConsDureeMod() {
        ConsDureeMod.setText(ConsDuree.getText());
    }

    public void setConsNeoplasmeConnuMod() {
        ConsNeoplasmeConnuMod.setText(ConsNeoplasmeConnu.getText());
    }

    public void setConsNeoplasmePreciseMod() {
        ConsNeoplasmePreciseMod.setText(ConsNeoplasmePrecise.getText());
    }

    public void setConsDyslipidemieMod() {
        ConsDyslipidemieMod.setText(ConsDyslipidemie.getText());
    }
    public void setConsDiabeteMod() {
        ConsDiabeteMod.setText(ConsDiabete.getText());
    }

    public void setConsTypeDiabeteMod() {
        ConsTypeDiabeteMod.setText(ConsTypeDiabete.getText());
    }

    public void setConsDepuisDMod() {
        ConsDepuisDMod.setValue(ConvertStrDate(ConsDepuisD.getText()));
    }

    public void setConsHTAMod() {
        ConsHTAMod.setText(ConsHTA.getText());
    }

    public void setConsTRTMod() {
        ConsTRTMod.setText(ConsTRT.getText());
    }

    public void setConsAutreTaresMod() {
        ConsAutreTaresMod.setText(ConsAutreTares.getText());
    }
    /**/
    public LocalDate ConvertStrDate(String DateStr){
      
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(DateStr, formatter);
        
        return date;
    }
    /**/
    
    /**************************************/
    public void AffectChampModi(){
      setConsHepathieSousJacentMod();setConsDepuisMod();setConsPreciseMod();setConsCauseMod();setConsTransSangMod();
      setConsExtrDenTradMod();setConsSacrificationMod();setConsTatouageMod();setConsChirurgieMod();setConsAutreMod();
      setConsAlcoolDureeMod();setConsAlcoolQuantiteMod();setConsAlcoolNatureMod();setConsAlcoolSevrageMod();setConsCafeMod();
      setConsCafeNbrDeTasseMod();setConsCannabisMod();setConsMaladieAutoImmuneMod();setConsContreOraleMod();setConsMoleculeMod();
      setConsDureeMod();setConsNeoplasmeConnuMod();setConsNeoplasmePreciseMod();setConsDyslipidemieMod();setConsDiabeteMod();
      setConsTypeDiabeteMod();setConsDepuisDMod();setConsHTAMod();setConsTRTMod();setConsAutreTaresMod(); 
    }
    
    public int UpdateSGBD(String NumDossier) throws SQLException{
       
        MiseAjour  bddUpdate        = new MiseAjour();//"',Scarification ='"+this.getConsSacrificationMod()+"',MaladieAutolmmune ='"+this.getConsMaladieAutoImmuneMod()+
        int j =bddUpdate.AddElement("update atcdspersonnel set HepSouJac ='"+this.getConsHepathieSousJacentMod()+"',Depui ='"+this.getConsDepuisMod()+"',Precise ='"+this.getConsPreciseMod()+
                "',Cause ='"+this.getConsCauseMod()+"',Sacrification ='"+this.getConsSacrificationMod()+"',MaladieAutoImmune ='"+this.getConsMaladieAutoImmuneMod()+
                "',TransSang ='"+this.getConsTransSangMod()+"',ExtrDenTrad ='"+this.getConsExtrDenTradMod()+"',Tatouage ='"+this.getConsTatouageMod()+
                "',Chirurgie ='"+this.getConsChirurgieMod()+"',Autre ='"+this.getConsAutreMod()+"',AlcoolDuree ='"+this.getConsAlcoolDureeMod()+"',AlcoolQuntite ='"+this.getConsAlcoolQuantiteMod()+
                "',AlcoolNature ='"+this.getConsAlcoolNatureMod()+"',AlcoolSevrage ='"+this.getConsAlcoolSevrageMod()+"',Cafe ='"+this.getConsCafeMod()+"',CafeNbrDeTasse ='"+this.getConsCafeNbrDeTasseMod()+
                "',Cannabis ='"+this.getConsCannabisMod()+"',ContreOrale ='"+this.getConsContreOraleMod()+"',Molecule ='"+this.getConsMoleculeMod()+
                "',Duree ='"+this.getConsDureeMod()+"',NeoplasmeConnu ='"+this.getConsNeoplasmeConnuMod()+"',NeoplasmePrecise ='"+this.getConsNeoplasmePreciseMod()+"',Dyslipidemie ='"+this.getConsDyslipidemieMod()+
                "',Diabete ='"+this.getConsDiabeteMod()+"',TypeDiabete ='"+this.getConsTypeDiabeteMod()+"',DepuiD ='"+this.getConsDepuisDMod()+"' ,HTA ='"+this.getConsHTAMod()+"',TRT ='"+this.getConsTRTMod()+
                "',AutresTares = '"+this.getConsAutreTaresMod()+"' where NumDossier = '"+NumDossier+"'" );
    return j;
    
    }
    
        public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from atcdspersonnel where NumDossier ='"+NumDossier+"'");
            
            return j;
        }
        
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////


    
}
