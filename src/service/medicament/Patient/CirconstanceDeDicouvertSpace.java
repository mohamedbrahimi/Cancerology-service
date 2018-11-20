package service.medicament.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javax.swing.JScrollPane;
import service.medicament.DossierPatient.ANTCDpersonnelSpace;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class CirconstanceDeDicouvertSpace extends Parent {

    final ToggleGroup Tgroup1 = new ToggleGroup();
    final DatePicker dateDebut = new DatePicker();
    final ToggleGroup Tgroup2 = new ToggleGroup();
    final ToggleGroup Tgroup3 = new ToggleGroup();
    final ToggleGroup Tgroup4 = new ToggleGroup();
    final ToggleGroup Tgroup5 = new ToggleGroup();
    final ToggleGroup Tgroup6 = new ToggleGroup();
    final ToggleGroup Tgroup7 = new ToggleGroup();
    final ToggleGroup Tgroup8 = new ToggleGroup();
    final ToggleGroup Tgroup9 = new ToggleGroup();
    final ToggleGroup Tgroup10 = new ToggleGroup();
    final ToggleGroup Tgroup11 = new ToggleGroup();
    final ToggleGroup Tgroup12 = new ToggleGroup();
    final ToggleGroup Tgroup13 = new ToggleGroup();
    final TextArea AutreSigne;
    final ToggleGroup Tgroup14 = new ToggleGroup();
    final ToggleGroup Tgroup15 = new ToggleGroup();
    final ToggleGroup Tgroup16 = new ToggleGroup();
    final ToggleGroup Tgroup17 = new ToggleGroup();
    final CheckBox FH = new CheckBox("FH");
    final ToggleGroup Tgroup18 = new ToggleGroup();
    final ToggleGroup Tgroup19 = new ToggleGroup();
    final ToggleGroup Tgroup20 = new ToggleGroup();
    final TextArea AutreSignePh;
    final ToggleGroup Tgroup21 = new ToggleGroup();
    final TextArea PreciseAutre;

    final Label IndIns = new Label();
    final ImageView ImgSucc = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
    final ImageView ImgFaild = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
    /////**********************la partie consultation **************************************************///////
    private Label ConsEMTHepato      = new Label("-------");
    private Label ConsDDebSympto     = new Label("-------");
    private Label ConsFortuit        = new Label("-------");
    private Label ConsDECSyrrhose    = new Label("-------");
    private Label ConsEchographie    = new Label("-------");
    private Label ConsDosAFP         = new Label("-------");
    private Label ConsAmaigre        = new Label("-------");
    private Label ConsFièvre         = new Label("-------");
    private Label ConsIctère         = new Label("-------");
    private Label ConsDouleurHD      = new Label("-------");
    private Label ConsHemoragieDes   = new Label("-------");
    private Label ConsAscite         = new Label("-------");
    private Label ConsSplénomegalie  = new Label("-------");
    private Label ConsTypeSpleno     = new Label("-------");
    private Label ConsAutres         = new Label("-------");
    private Label ConsETGSOms        = new Label("-------");
    private Label ConsBMI            = new Label("-------");
    private Label ConsCVC            = new Label("-------");
    private Label ConsHPM            = new Label("-------");
    private Label ConsOMI            = new Label("-------");
    private Label ConsAutreS         = new Label("-------");
    private Label ConsSyndrParaneo   = new Label("-------");
    private Label ConsSyndrPrecise   = new Label("-------");
    private Label ConshpmFH          = new Label("-------");
    private Label ConshpmConsistance = new Label("-------");
    private Label ConshmpSurface     = new Label("-------");
           ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /****************Partie Modification**************************************/
    final TextField      ConsEMTHepatoMod       ;        
    final DatePicker     ConsDDebSymptoMod     = new DatePicker();        
    final TextField      ConsFortuitMod         ;         
    final TextField      ConsDECSyrrhoseMod     ;        
    final TextField      ConsEchographieMod     ;        
    final TextField      ConsDosAFPMod          ;  
    final TextField      ConsSignLabelMod       ;              
    final TextField      ConsAmaigreMod         ;     
    final TextField      ConsFièvreMod          ; 
    final TextField      ConsIctereMod          ;	
    final TextField      ConsDouleurHDMod       ;      
    final TextField      ConsSignHLabelMod      ;                  
    final TextField      ConsHemoragieDesMod    ;         
    final TextField      ConsAsciteMod          ;      
    final TextField      ConsSplénomegalieMod   ;         
    final TextField      ConsTypeSplenoMod      ;        
    final TextArea       ConsAutresMod          ;           
    final TextField      ConsSignPhMod          ;                                
    final TextField      ConsETGSOmsMod         ;         
    final TextField      ConsBMIMod             ;         
    final TextField      ConsCVCMod             ;          
    final TextField      ConsHPMMod             ;          
    final TextField      ConshpmFHMod           ;         
    final TextField      ConshpmConsistanceMod  ;         
    final TextField      ConshmpSurfaceMod      ;        
    final TextField      ConsOMIMod             ;          
    final TextArea       ConsAutreSMod          ;          
    final TextField      ConsSyndrParaneoMod    ;          
    final TextArea       ConsSyndrPreciseMod    ;
    
    /*************************************************************************/
    //////////////////////////////////////////////////////////////////////////
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
    
    int TypeMod  = 0;
    int DejaMode = 0;
    /******************************************************/

    public CirconstanceDeDicouvertSpace(int TypeCCP,String NumDossier) throws SQLException {
/*******************************/
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
    
    vbMod.getChildren().addAll(IndModifS,hperAnnul);
        /*****/
        /////
        //   
        ImgSucc.setFitHeight(50);
        ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);
        ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        //
        /////
        /*******/
          ConsEMTHepatoMod      = this.champSaisier();        
          ConsFortuitMod        = this.champSaisier();         
          ConsDECSyrrhoseMod    = this.champSaisier();        
          ConsEchographieMod    = this.champSaisier();        
          ConsDosAFPMod         = this.champSaisier();  
          ConsSignLabelMod      = this.champSaisier();              
          ConsAmaigreMod        = this.champSaisier();     
          ConsFièvreMod         = this.champSaisier(); 
          ConsIctereMod         = this.champSaisier();	
          ConsDouleurHDMod      = this.champSaisier();      
          ConsSignHLabelMod     = this.champSaisier();                  
          ConsHemoragieDesMod   = this.champSaisier();         
          ConsAsciteMod         = this.champSaisier();      
          ConsSplénomegalieMod  = this.champSaisier();         
          ConsTypeSplenoMod     = this.champSaisier();        
          ConsAutresMod         = this.champSaisierA();           
          ConsSignPhMod         = this.champSaisier();                                
          ConsETGSOmsMod        = this.champSaisier();         
          ConsBMIMod            = this.champSaisier();         
          ConsCVCMod            = this.champSaisier();          
          ConsHPMMod            = this.champSaisier();          
          ConshpmFHMod          = this.champSaisier();         
          ConshpmConsistanceMod = this.champSaisier();         
          ConshmpSurfaceMod     = this.champSaisier();        
          ConsOMIMod            = this.champSaisier();          
          ConsAutreSMod         = this.champSaisierA();          
          ConsSyndrParaneoMod   = this.champSaisier();          
          ConsSyndrPreciseMod   = this.champSaisierA();

        /*******/
        ///////////
        ////
        final Callback<DatePicker, DateCell> dayCellFactory
                = new Callback<DatePicker, DateCell>() {

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

                            }
                        ;
                    }
                ;
        }};
        ////
        ///////////
           GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(7);
        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(1);
        shadow.setOffsetY(0.5);
        shadow.setColor(Color.AQUA);

        final Label label1 = new Label("En même temps que l’hepatopathie sous jacente");
        final RadioButton OuiL = new RadioButton("Oui");
        final RadioButton NonL = new RadioButton("Non");

        OuiL.setToggleGroup(Tgroup1);
        NonL.setToggleGroup(Tgroup1);
        OuiL.setSelected(true);
        OuiL.setUserData("Oui");
        NonL.setUserData("Non");
        grid.add(label1, 0, 0, 3, 1);
        grid.add(OuiL, 3, 0);
        grid.add(NonL, 4, 0);

        final Label label2 = new Label("Date du début de la symptomatologie ");

        dateDebut.setValue(LocalDate.now());
        dateDebut.setDayCellFactory(dayCellFactory);
        grid.add(label2, 0, 1, 2, 1);
        grid.add(dateDebut, 1, 1, 2, 1);

        final Label fourtuit = new Label("Fortuite ");
        fourtuit.getStyleClass().add("setStyleCirconsanceDic");
        final RadioButton OuiF = new RadioButton("Oui");
        final RadioButton NonF = new RadioButton("Non");

        OuiF.setToggleGroup(Tgroup2);
        NonF.setToggleGroup(Tgroup2);
        OuiF.setSelected(true);
        OuiF.setUserData("Oui");
        NonF.setUserData("Non");
        grid.add(fourtuit, 0, 2);
        grid.add(OuiF, 1, 2);
        grid.add(NonF, 2, 2);

        final Label Depistage = new Label("Dépistage en cas de cirrhose connue : ");
        Depistage.getStyleClass().add("setStyleCirconsanceDic");
        final RadioButton OuiD = new RadioButton("Oui");
        OuiD.setUserData("Oui");
        OuiD.setSelected(true);
        final RadioButton NonD = new RadioButton("Non");
        NonD.setUserData("Non");

        OuiD.setToggleGroup(Tgroup3);
        NonD.setToggleGroup(Tgroup3);

        grid.add(Depistage, 0, 3);
        grid.add(OuiD, 1, 3);
        grid.add(NonD, 2, 3);

        final Label Echographie = new Label("Echographie ");
        final RadioButton OuiEcho = new RadioButton("Oui");
        final RadioButton NonEcho = new RadioButton("Non");

        OuiEcho.setUserData("Oui");
        NonEcho.setUserData("Non");
        OuiEcho.setToggleGroup(Tgroup4);
        NonEcho.setToggleGroup(Tgroup4);
        OuiEcho.setSelected(true);

        grid.add(Echographie, 0, 4);
        grid.add(OuiEcho, 1, 4);
        grid.add(NonEcho, 2, 4);

        final Label DosageAFP = new Label("Dosage de AFP");
        final RadioButton OuiDosage = new RadioButton("Oui");
        final RadioButton NonDosage = new RadioButton("Non");

        OuiDosage.setUserData("Oui");
        NonDosage.setUserData("Non");
        OuiDosage.setSelected(true);
        OuiDosage.setToggleGroup(Tgroup5);
        NonDosage.setToggleGroup(Tgroup5);

        Tgroup3.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_value,
                Toggle new_value) -> {
                    if (Tgroup3.getSelectedToggle().getUserData().equals("Non")) {
                        grid.getChildren().removeAll(Echographie, OuiEcho, NonEcho, DosageAFP, OuiDosage, NonDosage);
                        Tgroup4.getSelectedToggle().setSelected(false);
                        Tgroup5.getSelectedToggle().setSelected(false);
                    } else {
                        grid.getChildren().addAll(Echographie, OuiEcho, NonEcho, DosageAFP, OuiDosage, NonDosage);
                        OuiEcho.setSelected(true);
                        OuiDosage.setSelected(true);
                    }
                });

        grid.add(DosageAFP, 0, 5);
        grid.add(OuiDosage, 1, 5);
        grid.add(NonDosage, 2, 5);

        final Label SignesGF = new Label("Signes généraux et fonctionnels : ");
        SignesGF.getStyleClass().add("setStyleCirconsanceDic");
        grid.add(SignesGF, 0, 7, 2, 1);

        final Label Amaigrissemnt = new Label("Amaigrissement");
        final RadioButton OuiAmaig = new RadioButton("Oui");
        final RadioButton NonAmaig = new RadioButton("Non");

        OuiAmaig.setUserData("Oui");
        NonAmaig.setUserData("Non");
        OuiAmaig.setToggleGroup(Tgroup6);
        NonAmaig.setToggleGroup(Tgroup6);
        OuiAmaig.setSelected(true);

        grid.add(Amaigrissemnt, 0, 8);
        grid.add(OuiAmaig, 1, 8);
        grid.add(NonAmaig, 2, 8);

        final Label Fievre = new Label("Fièvre ");
        final RadioButton OuiFievre = new RadioButton("Oui");
        final RadioButton NonFievre = new RadioButton("Non");

        OuiFievre.setToggleGroup(Tgroup7);
        NonFievre.setToggleGroup(Tgroup7);
        OuiFievre.setUserData("Oui");
        NonFievre.setUserData("Non");
        NonFievre.setSelected(true);

        grid.add(Fievre, 0, 9);
        grid.add(OuiFievre, 1, 9);
        grid.add(NonFievre, 2, 9);

        final Label Ictere = new Label("Ictère ");
        final RadioButton OuiIctere = new RadioButton("Oui");
        final RadioButton NonIctere = new RadioButton("Non");

        OuiIctere.setToggleGroup(Tgroup8);
        NonIctere.setToggleGroup(Tgroup8);
        OuiIctere.setUserData("Oui");
        NonIctere.setUserData("Non");
        OuiIctere.setSelected(true);

        grid.add(Ictere, 0, 10);
        grid.add(OuiIctere, 1, 10);
        grid.add(NonIctere, 2, 10);
        final Label DouleurHD = new Label("Douleur de l’hypochondre droit ");
        final RadioButton OuiDouleur = new RadioButton("Oui");
        final RadioButton NonDouleur = new RadioButton("Non");

        OuiDouleur.setToggleGroup(Tgroup9);
        NonDouleur.setToggleGroup(Tgroup9);
        OuiDouleur.setUserData("Oui");
        NonDouleur.setUserData("Non");
        NonDouleur.setSelected(true);

        grid.add(DouleurHD, 0, 11, 2, 1);
        grid.add(OuiDouleur, 1, 11);
        grid.add(NonDouleur, 2, 11);

        final Label SignesHP = new Label("Signes d’hypertension portale : ");
        SignesHP.getStyleClass().add("setStyleCirconsanceDic");
        grid.add(SignesHP, 0, 13, 2, 1);

        final Label HemorragieD = new Label("Hémorragies digestives ");
        final RadioButton OuiHem = new RadioButton("Oui");
        final RadioButton NonHem = new RadioButton("Non");

        OuiHem.setToggleGroup(Tgroup10);
        NonHem.setToggleGroup(Tgroup10);
        OuiHem.setUserData("Oui");
        NonHem.setUserData("Non");
        NonHem.setSelected(true);

        grid.add(HemorragieD, 0, 14);
        grid.add(OuiHem, 1, 14);
        grid.add(NonHem, 2, 14);

        final Label Ascite = new Label("Ascite");
        final RadioButton OuiAscite = new RadioButton("Oui");
        final RadioButton NonAscite = new RadioButton("Non");

        OuiAscite.setToggleGroup(Tgroup11);
        NonAscite.setToggleGroup(Tgroup11);
        OuiAscite.setUserData("Oui");
        NonAscite.setUserData("Non");
        NonAscite.setSelected(true);

        grid.add(Ascite, 0, 15);
        grid.add(OuiAscite, 1, 15);
        grid.add(NonAscite, 2, 15);

        final Label Splenomegalie = new Label("Splénomégalie");
        ////////////
        final RadioButton OuiSp = new RadioButton("Oui");
        final RadioButton NonSp = new RadioButton("Non");
           ////////////   

        NonSp.setSelected(true);
        OuiSp.setToggleGroup(Tgroup12);
        NonSp.setToggleGroup(Tgroup12);
        OuiSp.setUserData("Oui");
        NonSp.setUserData("Non");

        grid.add(Splenomegalie, 0, 16);
        grid.add(OuiSp, 1, 16);
        grid.add(NonSp, 2, 16);

        final Label siOui = new Label("Type ");
        siOui.setVisible(false);
        final RadioButton T1 = new RadioButton("1");
        T1.setVisible(false);
        final RadioButton T2 = new RadioButton("2");
        T2.setVisible(false);
        final RadioButton T3 = new RadioButton("3");
        T3.setVisible(false);
        final RadioButton T4 = new RadioButton("4");
        T4.setVisible(false);

        T1.setToggleGroup(Tgroup13);
        T2.setToggleGroup(Tgroup13);
        T3.setToggleGroup(Tgroup13);
        T4.setToggleGroup(Tgroup13);
        T1.setUserData("1");
        T2.setUserData("2");
        T3.setUserData("3");
        T4.setUserData("4");
        T1.setSelected(true);
        //////////
        Tgroup12.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle,
                Toggle new_toggle) -> {
                    if (Tgroup12.getSelectedToggle().getUserData().toString().equals("Oui")) {
                        siOui.setVisible(true);
                        T1.setVisible(true);
                        T2.setVisible(true);
                        T3.setVisible(true);
                        T4.setVisible(true);
                        T1.setSelected(true);
                    } else {
                        siOui.setVisible(false);
                        T1.setVisible(false);
                        T2.setVisible(false);
                        T3.setVisible(false);
                        T4.setVisible(false);
                        Tgroup13.getSelectedToggle().setSelected(false);
                    }
                });

        grid.add(siOui, 0, 17);
        grid.add(T1, 1, 17);
        grid.add(T2, 2, 17);
        grid.add(T3, 3, 17);
        grid.add(T4, 4, 17);

        AutreSigne = champSaisierA();
        AutreSigne.setPrefSize(150, 80);
        AutreSigne.setPromptText("Autre ");

        grid.add(AutreSigne, 0, 18);
        final Label SignesPh = new Label("Signes physiques : ");
        SignesPh.getStyleClass().add("setStyleCirconsanceDic");
        grid.add(SignesPh, 0, 20);
        final Label ETATg = new Label("ETAT GENERAL STADE OMS");
        grid.add(ETATg, 0, 21);
        final RadioButton TT1 = new RadioButton("1");
        final RadioButton TT2 = new RadioButton("2");
        final RadioButton TT3 = new RadioButton("3");
        final RadioButton TT4 = new RadioButton("4");

        TT1.setToggleGroup(Tgroup14);
        TT2.setToggleGroup(Tgroup14);
        TT3.setToggleGroup(Tgroup14);
        TT4.setToggleGroup(Tgroup14);
        TT1.setUserData("1");
        TT2.setUserData("2");
        TT3.setUserData("3");
        TT4.setUserData("4");
        TT1.setSelected(true);

        grid.add(TT1, 1, 21);
        grid.add(TT2, 2, 21);
        grid.add(TT3, 3, 21);
        grid.add(TT4, 4, 21);
        final Label BMI = new Label("BMI");
        final RadioButton Tt1 = new RadioButton("30<");
        final RadioButton Tt2 = new RadioButton("25-30");
        final RadioButton Tt3 = new RadioButton("18-25");
        final RadioButton Tt4 = new RadioButton("<18");

        Tt1.setToggleGroup(Tgroup15);
        Tt2.setToggleGroup(Tgroup15);
        Tt3.setToggleGroup(Tgroup15);
        Tt4.setToggleGroup(Tgroup15);
        Tt1.setUserData("30<");
        Tt2.setUserData("25-30");
        Tt3.setUserData("18-25");
        Tt4.setUserData("<18");
        Tt1.setSelected(true);

        grid.add(BMI, 0, 23);
        grid.add(Tt1, 1, 23);
        grid.add(Tt2, 2, 23);
        grid.add(Tt3, 3, 23);
        grid.add(Tt4, 4, 23);
        final Label CVC = new Label("CVC");
        final RadioButton Ouicvc = new RadioButton("Oui");
        final RadioButton Noncvc = new RadioButton("Non");

        Ouicvc.setToggleGroup(Tgroup16);
        Noncvc.setToggleGroup(Tgroup16);
        Ouicvc.setUserData("Oui");
        Noncvc.setUserData("Non");
        Ouicvc.setSelected(true);

        grid.add(CVC, 0, 24);
        grid.add(Ouicvc, 1, 24);
        grid.add(Noncvc, 2, 24);
        final Label HPM = new Label("HPM");
        ///////////////
        final RadioButton Ouihpm = new RadioButton("Oui");
        final RadioButton Nonhpm = new RadioButton("Non");
           ////////////////

        Ouihpm.setToggleGroup(Tgroup17);
        Nonhpm.setToggleGroup(Tgroup17);
        Ouihpm.setUserData("Oui");
        Nonhpm.setUserData("Non");
        Nonhpm.setSelected(true);

        grid.add(HPM, 0, 25);
        grid.add(Ouihpm, 1, 25);
        grid.add(Nonhpm, 2, 25);
        final Label consistance = new Label("Consistance ");
        consistance.getStyleClass().add("styleLabel");
        final RadioButton ferme = new RadioButton("ferme");
        final RadioButton dure = new RadioButton("dure");

        ferme.setToggleGroup(Tgroup18);
        dure.setToggleGroup(Tgroup18);
        ferme.setUserData("ferme");
        dure.setUserData("dure");
        dure.setSelected(true);

        final Label surface = new Label("surface");
        surface.getStyleClass().add("styleLabel");
        final RadioButton reguliere = new RadioButton("réguliére");
        final RadioButton irreguliere = new RadioButton("irrégulière");

        reguliere.setToggleGroup(Tgroup19);
        irreguliere.setToggleGroup(Tgroup19);
        reguliere.setUserData("reguliere");
        irreguliere.setUserData("irreguliere");
        reguliere.setSelected(true);

        final HBox hb = new HBox();
        hb.setPadding(new Insets(10, 10, 10, 10));
        hb.setSpacing(5);
        hb.getChildren().addAll(FH, consistance, ferme, dure, surface, reguliere, irreguliere);
        Tgroup17.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle,
                Toggle new_toggle) -> {
                    if (Tgroup17.getSelectedToggle().getUserData().toString().equals("Oui")) {
                        hb.setVisible(true);
                        ferme.setSelected(true);
                        reguliere.setSelected(true);
                    } else {
                        hb.setVisible(false);
                        Tgroup18.getSelectedToggle().setSelected(false);
                        FH.setSelected(false);
                        Tgroup19.getSelectedToggle().setSelected(false);
                    }
                });
        hb.setVisible(false);
        grid.add(hb, 0, 26, 4, 1);

        final Label OMI = new Label("OMI");
        final RadioButton Ouiomi = new RadioButton("Oui");
        final RadioButton Nonomi = new RadioButton("Non");

        Ouiomi.setToggleGroup(Tgroup20);
        Nonomi.setToggleGroup(Tgroup20);
        Ouiomi.setUserData("Oui");
        Nonomi.setUserData("Non");
        Ouiomi.setSelected(true);

        grid.add(OMI, 0, 27);
        grid.add(Ouiomi, 1, 27);
        grid.add(Nonomi, 2, 27);

        AutreSignePh = champSaisierA();
        AutreSignePh.setPrefSize(150, 80);
        AutreSignePh.setPromptText("Autre");
        grid.add(AutreSignePh, 0, 28);

        final Label SyndromeParaneoplasique = new Label("Syndrome paranéoplasique ");
        SyndromeParaneoplasique.getStyleClass().add("setStyleCirconsanceDic");
        final RadioButton OuiSy = new RadioButton("Oui");
        final RadioButton NonSy = new RadioButton("Non");

        PreciseAutre = champSaisierA();
        PreciseAutre.setPromptText("Préciser");
        PreciseAutre.setPrefSize(200, 80);

        OuiSy.setSelected(true);
        OuiSy.setToggleGroup(Tgroup21);
        NonSy.setToggleGroup(Tgroup21);
        OuiSy.setUserData("Oui");
        NonSy.setUserData("Non");

        Tgroup21.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_value,
                Toggle new_value) -> {
                    if (Tgroup21.getSelectedToggle().getUserData().equals("Non")) {
                        grid.getChildren().remove(PreciseAutre);
                        PreciseAutre.setText("");
                    } else {
                        grid.getChildren().add(PreciseAutre);
                    }
                });

        grid.add(SyndromeParaneoplasique, 0, 29);
        grid.add(OuiSy, 1, 29);
        grid.add(NonSy, 2, 29);
        grid.add(PreciseAutre, 0, 30);

        /////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////
        final Button Ajouter = new Button("Ajouter");
        Ajouter.setEffect(null);
        Ajouter.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Ajouter.setScaleX(1.1);
                Ajouter.setScaleY(1.1);
                Ajouter.setEffect(shadow);
            }
        });
        Ajouter.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Ajouter.setScaleX(1);
                Ajouter.setScaleY(1);
                Ajouter.setEffect(null);
            }
        });
        Ajouter.setOnAction((ActionEvent) -> {
            try {

                int i = this.InsertionSGBD(NumDossier);
                if (i == 1) {
                    IndIns.setGraphic(ImgSucc);
                    IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion des Ciconstances\n au niveau du \n Dossier numero " + NumDossier + "\n est faite par succès  ");
                } else {
                    IndIns.setGraphic(ImgFaild);
                    IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Circonstances\n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Circonstances au niveau\n d'un dossier   ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ANTCDpersonnelSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(IndIns, 0, 32, 4, 4);
        grid.add(Ajouter, 5, 32);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////***********************partie consultation************************************************/////////////
        GridPane gridC = new GridPane();
        gridC.setVgap(10);
        gridC.setHgap(7);
           final Label circonstanceLabel    = new Label("CIRCONSTANCES DE DECOUVERTE : ");
           circonstanceLabel.getStyleClass().add("setStyleCirconsanceDic");   gridC.add(circonstanceLabel,0,0);
    final Label     TEMTHepato      = new Label("- En même temps que l’hepatopathie sous jacente  :");          gridC.add(TEMTHepato, 0,1);       gridC.add(ConsEMTHepato, 3,1);
    final Label     TDDebSympto     = new Label("- Date du début de la symptomatologie (en mois)  :");          gridC.add(TDDebSympto,0,2);       gridC.add(ConsDDebSympto,3,2);
    final Label     TFortuit        = new Label("- Fortuite                                       :");          gridC.add(TFortuit,0,3);          gridC.add(ConsFortuit,3,3);
    final Label     TDECSyrrhose    = new Label("- Dépistage en cas de cirrhose connue            :");          gridC.add(TDECSyrrhose, 0,4);     gridC.add(ConsDECSyrrhose,3,4);
    final Label     TEchographie    = new Label("  Echographie                                    :");          gridC.add(TEchographie, 0,5);     gridC.add(ConsEchographie,3,5);
    final Label     TDosAFP         = new Label("  Dosage des AFP                                 :");          gridC.add(TDosAFP, 0,6);          gridC.add(ConsDosAFP, 3,6);
    final Label     SignLabel       = new Label("- Signes généraux et fonctionnels    :");                      gridC.add(SignLabel,0,7);
                    SignLabel.getStyleClass().add("setstyleTraitementPabs");
    final Label     TAmaigre        = new Label("  Amaigrissement                                 :");          gridC.add(TAmaigre,0,8);          gridC.add(ConsAmaigre,3,8);
    final Label     TFièvre         = new Label("  Fièvre                                         :");          gridC.add(TFièvre, 0,9);          gridC.add(ConsFièvre, 3,9);
    final Label     TIctère         = new Label("  Ictère                                         :");          gridC.add(TIctère, 0,10);         gridC.add(ConsIctère,3,10);
    final Label     TDouleurHD      = new Label("  Douleur de l’hypochondre droit                  :");         gridC.add(TDouleurHD, 0,11);      gridC.add(ConsDouleurHD,3,11);
    final Label     SignHLabel      = new Label("Signes d’hypertension portale         : ");                    gridC.add(SignHLabel,0,12);
                    SignHLabel.getStyleClass().add("setstyleTraitementPabs");                             
    final Label     THemoragieDes   = new Label("  Hémorragies digestives                         :");          gridC.add(THemoragieDes,0,13);   gridC.add(ConsHemoragieDes,3,13);
    final Label     TAscite         = new Label("  Ascite                                         :");          gridC.add(TAscite, 0,14);        gridC.add(ConsAscite,3,14);
    final Label     TSplénomegalie  = new Label("  Splénomégalie                                  :");          gridC.add(TSplénomegalie, 0,15); gridC.add(ConsSplénomegalie,3,15);
    final Label     TTypeSpleno     = new Label("  Type                                           :");          gridC.add(TTypeSpleno, 0,16);    gridC.add(ConsTypeSpleno, 3,16);
    final Label     TAutres         = new Label("  Autre                                          :");          gridC.add(TAutres, 0,17,2,3);    gridC.add(ConsAutres, 3,17,2,3);
    final Label     SignPh          = new Label("- Signes physiques            : ");                            gridC.add(SignPh, 0,20);         
                    SignPh.getStyleClass().add("setstyleTraitementPabs");
    final Label     TETGSOms        = new Label("  ETAT GENERAL   STADE   OMS                     :");          gridC.add(TETGSOms,0,21);        gridC.add(ConsETGSOms, 3,21);
    final Label     TBMI            = new Label("  BMI                                            :");          gridC.add(TBMI, 0,22);           gridC.add(ConsBMI, 3,22);
    final Label     TCVC            = new Label("  CVC                                            :");          gridC.add(TCVC, 0,23);           gridC.add(ConsCVC,3,23);
    final Label     THPM            = new Label("  HPM                                            :");          gridC.add(THPM, 0,24);           gridC.add(ConsHPM,3,24);
     final Label    ThpmFH          = new Label("  FH                                             :");          gridC.add(ThpmFH,0,25); gridC.add(ConshpmFH, 3,25);
    final Label     ThpmConsistance = new Label("  consistance                                    :");          gridC.add(ThpmConsistance,0,26); gridC.add(ConshpmConsistance, 3,26);
    final Label     ThmpSurface     = new Label("  surface                                        :");          gridC.add(ThmpSurface,0,27);     gridC.add(ConshmpSurface, 3,27);
    final Label     TOMI            = new Label("  OMI                                            :");          gridC.add(TOMI, 0,28);           gridC.add(ConsOMI, 3,28);
    final Label     TAutreS         = new Label("  Autre                                          :");          gridC.add(TAutreS,0,29,2,3);     gridC.add(ConsAutreS,3,29,2,3);
    final Label     TSyndrParaneo   = new Label("- Syndrome paranéoplasique                       :");          gridC.add(TSyndrParaneo, 0,32);  gridC.add(ConsSyndrParaneo, 3,32);
    final Label     TSyndrPrecise   = new Label("  Precise                                        :");          gridC.add(TSyndrPrecise,0,33,2,3);   gridC.add(ConsSyndrPrecise,3,33,2,3);
   
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ;

        grid.setPadding(new Insets(30, 10, 10, 30));
        gridC.setPadding(new Insets(30, 10, 10, 30));
        
        /*************************************************************************************************************/
       final ImageView ImgEnregMod    = new ImageView(new Image(getClass().getResourceAsStream("Images/20_1.jpg")));
      ImgEnregMod.setFitHeight(40); ImgEnregMod.setPreserveRatio(true);
      
      final ImageView ImgEnregSup   = new ImageView(new Image(getClass().getResourceAsStream("Images/12_1.jpg")));
      ImgEnregSup.setFitHeight(40); ImgEnregSup.setPreserveRatio(true);
      /***/
       ModifButton.setOnAction((ActionEvent)->{
            TypeMod = 1;
 gridC.getChildren().removeAll(ConsEMTHepato,ConsDDebSympto,ConsFortuit, ConsDECSyrrhose,ConsEchographie,ConsDosAFP,ConsAmaigre,ConsFièvre,ConsIctère,ConsDouleurHD,ConsHemoragieDes,ConsAscite,ConsSplénomegalie,ConsTypeSpleno,ConsAutres,ConsETGSOms,ConsBMI,ConsCVC,ConsHPM,ConshpmFH,ConshpmConsistance,ConshmpSurface,ConsOMI,ConsAutreS,ConsSyndrParaneo,ConsSyndrPrecise);
                 gridC.add(ConsEMTHepatoMod, 3,1);    ConsEMTHepatoMod.setMaxWidth(200);
              	 gridC.add(ConsDDebSymptoMod,3,2);    ConsDDebSymptoMod.setMaxWidth(200);
                 gridC.add(ConsFortuitMod,3,3);       ConsFortuitMod.setMaxWidth(200);
             	 gridC.add(ConsDECSyrrhoseMod,3,4);   ConsDECSyrrhoseMod.setMaxWidth(200);
             	 gridC.add(ConsEchographieMod,3,5);   ConsEchographieMod.setMaxWidth(200);
                 gridC.add(ConsDosAFPMod, 3,6);       ConsDosAFPMod.setMaxWidth(200);
        
       
                 gridC.add(ConsAmaigreMod,3,8);       ConsAmaigreMod.setMaxWidth(200);
              	 gridC.add(ConsFièvreMod, 3,9);       ConsFièvreMod.setMaxWidth(200);
              	 gridC.add(ConsIctereMod,3,10);       ConsIctereMod.setMaxWidth(200);
                 gridC.add(ConsDouleurHDMod,3,11);    ConsDouleurHDMod.setMaxWidth(200);
       
                                    
              	 gridC.add(ConsHemoragieDesMod,3,13); ConsHemoragieDesMod.setMaxWidth(200);
              	 gridC.add(ConsAsciteMod,3,14);       ConsAsciteMod.setMaxWidth(200);
                 gridC.add(ConsSplénomegalieMod,3,15);ConsSplénomegalieMod.setMaxWidth(200);
                 gridC.add(ConsTypeSplenoMod, 3,16);  ConsTypeSplenoMod.setMaxWidth(200);
                 gridC.add(ConsAutresMod, 3,17,2,3);  ConsAutresMod.setMaxWidth(200);  ConsAutresMod.setMaxHeight(70);
                 
        
                 gridC.add(ConsETGSOmsMod, 3,21);           ConsETGSOmsMod.setMaxWidth(200);
            	 gridC.add(ConsBMIMod, 3,22);               ConsBMIMod.setMaxWidth(200);
                 gridC.add(ConsCVCMod,3,23);                ConsCVCMod.setMaxWidth(200);
                 gridC.add(ConsHPMMod,3,24);                ConsHPMMod.setMaxWidth(200);
                 gridC.add(ConshpmFHMod, 3,25);             ConshpmFHMod.setMaxWidth(200);
                 gridC.add(ConshpmConsistanceMod, 3,26);    ConshpmConsistanceMod.setMaxWidth(200);
                 gridC.add(ConshmpSurfaceMod, 3,27);        ConshmpSurfaceMod.setMaxWidth(200);
                 gridC.add(ConsOMIMod, 3,28);               ConsOMIMod.setMaxWidth(200);
             	 gridC.add(ConsAutreSMod,3,29,2,3);         ConsAutreSMod.setMaxWidth(200); ConsAutreSMod.setMaxHeight(70);
             	 gridC.add(ConsSyndrParaneoMod, 3,32);      ConsSyndrParaneoMod.setMaxWidth(200);
                 gridC.add(ConsSyndrPreciseMod,3,33,2,3);   ConsSyndrPreciseMod.setMaxWidth(200);ConsSyndrPreciseMod.setMaxHeight(70);
      
        ModifChamp();
         hperAnnul.setVisible(true);
    
    EnregButton.setDisable(false);
    ModifButton.setDisable(true);
    
    
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer les Modification");
    IndModifS.setGraphic(ImgEnregMod);
    vbMod.setVisible(true);
    
    DejaMode = 1;
        });
    /***/
     IndModifS.getStyleClass().add("erreurchamp");
     SuppButton.setOnAction((ActionEvent)->{
         hperAnnul.setVisible(true);
         
       TypeMod = 0;
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer la Suppression du document");
    IndModifS.setGraphic(ImgEnregSup);
    vbMod.setVisible(true);
    EnregButton.setDisable(false);
        
    });
    /****/
        hperAnnul.setOnAction((ActionEvent)->{
        if(DejaMode == 1){
            gridC.getChildren().removeAll(ConsEMTHepatoMod,ConsDDebSymptoMod,ConsFortuitMod ,ConsDECSyrrhoseMod ,ConsEchographieMod,ConsDosAFPMod ,
                                         ConsSignLabelMod,ConsAmaigreMod ,ConsFièvreMod ,ConsDouleurHDMod ,ConsSignHLabelMod,ConsHemoragieDesMod , 
                                         ConsAsciteMod , ConsSplénomegalieMod, ConsTypeSplenoMod,ConsAutresMod, ConsSignPhMod, ConsETGSOmsMod 
					,ConsBMIMod,ConsCVCMod,ConsHPMMod,ConshpmFHMod,ConshpmConsistanceMod,ConshmpSurfaceMod,ConsOMIMod ,
					 ConsAutreSMod,ConsSyndrParaneoMod,ConsSyndrPreciseMod,ConsIctereMod);
             
            gridC.getChildren().addAll(ConsEMTHepato,ConsDDebSympto,ConsFortuit, ConsDECSyrrhose,ConsEchographie,
                     ConsDosAFP,ConsAmaigre,ConsFièvre,ConsIctère,ConsDouleurHD,ConsHemoragieDes,ConsAscite,
                     ConsSplénomegalie,ConsTypeSpleno,ConsAutres,ConsETGSOms,ConsBMI,ConsCVC,ConsHPM,ConshpmFH,
                     ConshpmConsistance,ConshmpSurface,ConsOMI,ConsAutreS,ConsSyndrParaneo,ConsSyndrPrecise);
        
        DejaMode = 0;
        }
     vbMod.setVisible(false);
     EnregButton.setDisable(true);
     ModifButton.setDisable(false);
        
        });
        
        EnregButton.setOnAction((ActionEvent)->{
        hperAnnul.setVisible(false);
       if(TypeMod == 1){
         try {
            int j = this.UpdateSGBD(NumDossier);
            //this.requestParentLayout();
            
             gridC.getChildren().removeAll(ConsEMTHepatoMod,ConsDDebSymptoMod,ConsFortuitMod ,ConsDECSyrrhoseMod ,ConsEchographieMod,ConsDosAFPMod ,
                                         ConsSignLabelMod,ConsAmaigreMod ,ConsFièvreMod ,ConsDouleurHDMod ,ConsSignHLabelMod,ConsHemoragieDesMod , 
                                         ConsAsciteMod , ConsSplénomegalieMod, ConsTypeSplenoMod,ConsAutresMod, ConsSignPhMod, ConsETGSOmsMod 
					,ConsBMIMod,ConsCVCMod,ConsHPMMod,ConshpmFHMod,ConshpmConsistanceMod,ConshmpSurfaceMod,ConsOMIMod ,
					 ConsAutreSMod,ConsSyndrParaneoMod,ConsSyndrPreciseMod,ConsIctereMod);
            this.ConsultationE(NumDossier);
             gridC.getChildren().addAll(ConsEMTHepato,ConsDDebSympto,ConsFortuit, ConsDECSyrrhose,ConsEchographie,
                     ConsDosAFP,ConsAmaigre,ConsFièvre,ConsIctère,ConsDouleurHD,ConsHemoragieDes,ConsAscite,
                     ConsSplénomegalie,ConsTypeSpleno,ConsAutres,ConsETGSOms,ConsBMI,ConsCVC,ConsHPM,ConshpmFH,
                     ConshpmConsistance,ConshmpSurface,ConsOMI,ConsAutreS,ConsSyndrParaneo,ConsSyndrPrecise);
        
            
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
        
        
        /*************************************************************************************************************/

     if(TypeCCP == 0){
        final StackPane pane = new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        getChildren().add(pane);
     }
     else{
        final StackPane paneC = new StackPane();
        this.ConsultationE(NumDossier);
        paneC.getStyleClass().add("setStylingRootCons");
        gridC.setMinWidth(900);
        gridC.add(barOutil,3, 36,3,1);
        gridC.add(vbMod,0,36,3,1);

        paneC.getChildren().add(gridC);
        getChildren().add(paneC);
         
     }
    }

    public String getHepathieSousJacente() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateDebut() {
        return dateDebut.getValue();
    }

    public String getFourtuit() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getDepistage() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getEchographie() {
        if (getDepistage().equals("Oui")) {
            return Tgroup4.getSelectedToggle().getUserData().toString();
        } else {
            return "";
        }
    }

    public String getDosageAFP() {
        if (getDepistage().equals("Oui")) {
            return Tgroup5.getSelectedToggle().getUserData().toString();
        } else {
            return "";
        }
    }

    public String getAmaigrissement() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getFievre() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }

    public String getIctere() {
        return Tgroup8.getSelectedToggle().getUserData().toString();
    }

    public String getDouleurHD() {
        return Tgroup9.getSelectedToggle().getUserData().toString();
    }

    public String getHemmorragieD() {
        return Tgroup10.getSelectedToggle().getUserData().toString();
    }

    public String getAscite() {
        return Tgroup11.getSelectedToggle().getUserData().toString();
    }

    public String getSplénomegalie() {
        return Tgroup12.getSelectedToggle().getUserData().toString();
    }

    public String getTypeSplénomegalie() {
        if (getSplénomegalie().equals("Oui")) {
            return Tgroup13.getSelectedToggle().getUserData().toString();
        } else {
            return "";
        }
    }

    public String getAutreSigne() {
        return AutreSigne.getText();
    }

    public String getEtatG() {
        return Tgroup14.getSelectedToggle().getUserData().toString();
    }

    public String getBMI() {
        return Tgroup15.getSelectedToggle().getUserData().toString();
    }

    public String getCVC() {
        return Tgroup16.getSelectedToggle().getUserData().toString();
    }

    public String getHPM() {
        return Tgroup17.getSelectedToggle().getUserData().toString();
    }

    public String getFH() {   // getFH()  getConsistance()  getSuface() 
        if (FH.isSelected()) {
            return "Oui";
        } else {
            return "Non";
        }
    }

    public String getConsistance() {
        if (getHPM().equals("Oui")) {
            return Tgroup18.getSelectedToggle().getUserData().toString();
        } else {
            return "";
        }
    }

    public String getSuface() {
        if (getHPM().equals("Oui")) {
            return Tgroup19.getSelectedToggle().getUserData().toString();
        } else {
            return "";
        }
    }

    public String getOMI() {
        return Tgroup20.getSelectedToggle().getUserData().toString();
    }

    public String getAutreSignePh() {
        return AutreSignePh.getText();
    }

    public String getSyndrom() {
        return Tgroup21.getSelectedToggle().getUserData().toString();
    }

    public String getPreciseAutre() {
        return PreciseAutre.getText();
    }

    public int InsertionSGBD(String NumDossier) throws SQLException {
        System.out.println(this.getHepathieSousJacente() + "\n" + this.getDateDebut() + "\n" + this.getFourtuit() + "\n"
                + this.getDepistage() + "\n" + this.getEchographie() + "\n" + this.getDosageAFP() + "\n" + this.getAmaigrissement() + "\n"
                + this.getFievre() + "\n" + this.getIctere() + "\n" + this.getDouleurHD() + "\n" + this.getHemmorragieD() + "\n" + this.getAscite() + "\n"
                + this.getSplénomegalie() + "\n" + this.getTypeSplénomegalie() + "\n" + this.getAutreSigne() + "\n" + this.getEtatG() + "\n" + this.getBMI() + "\n" + this.getCVC() + "\n"
                + this.getHPM() + "\n" + this.getOMI() + "\n" + this.getAutreSignePh() + "\n" + this.getSyndrom() + "\n" + this.getPreciseAutre() + "\n");

        MiseAjour bddInsert = new MiseAjour();                                            //    
        int i = bddInsert.AddElement("insert into circonstanceDec values(0,'" + getHepathieSousJacente() + "','" + getDateDebut() + "','" + getFourtuit() + "','"
                + getDepistage() + "','" + getEchographie() + "','" + getDosageAFP() + "','" + getAmaigrissement() + "','" + getFievre() + "','" + getIctere() + "','" + getDouleurHD() + "','"
                + getHemmorragieD() + "','" + getAscite() + "','" + getSplénomegalie() + "','" + getTypeSplénomegalie() + "','" + getAutreSigne() + "','" + getEtatG() + "','" + getBMI() + "','"
                + getCVC() + "','" + getHPM() + "','" + getOMI() + "','" + getAutreSignePh() + "','" + getSyndrom() + "','" + getPreciseAutre() + "','" + NumDossier + "','" + getFH() + "','" + getConsistance() + "','" + getSuface() + "')");

        return i;
    }

    public TextArea champSaisierA() {
        TextArea textA = new TextArea() {

            public void replaceText(int start, int end, String text) {
                if (!text.matches("[',]")) {
                    super.replaceText(start, end, text);

                }

            }

        
        };

        return textA;

    }
    public TextField champSaisier(){
 TextField textF = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(!text.matches("[',]")){
                    super.replaceText(start, end, text);
                   
                }
              
            }
    
 };   

   return textF;  
    
}
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////******************//////////////les foctions de consultation*********************////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
    public void setConsEMTHepato(String ConsEMTHepato) {
        this.ConsEMTHepato.setText(ConsEMTHepato);
    }

    public void setConsDDebSympto(String ConsDDebSympto) {
        this.ConsDDebSympto.setText(ConsDDebSympto);
                
    }

    public void setConsFortuit(String ConsFortuit) {
        this.ConsFortuit.setText(ConsFortuit);
    }

    public void setConsDECSyrrhose(String ConsDECSyrrhose) {
        this.ConsDECSyrrhose.setText(ConsDECSyrrhose);
    }

    public void setConsEchographie(String ConsEchographie) {
        this.ConsEchographie.setText(ConsEchographie);
    }

    public void setConsDosAFP(String ConsDosAFP) {
        this.ConsDosAFP.setText(ConsDosAFP);
    }

    public void setConsAmaigre(String ConsAmaigre) {
        this.ConsAmaigre.setText(ConsAmaigre);
    }

    public void setConsFièvre(String ConsFièvre) {
        this.ConsFièvre .setText(ConsFièvre);
    }

    public void setConsIctère(String ConsIctère) {
        this.ConsIctère.setText(ConsIctère);
    }

    public void setConsDouleurHD(String ConsDouleurHD) {
        this.ConsDouleurHD.setText(ConsDouleurHD);
    }

    public void setConsHemoragieDes(String ConsHemoragieDes) {
        this.ConsHemoragieDes.setText(ConsHemoragieDes);
    }

    public void setConsAscite(String ConsAscite) {
        this.ConsAscite .setText(ConsAscite);
    }

    public void setConsSplénomegalie(String ConsSplénomegalie) {
        this.ConsSplénomegalie.setText(ConsSplénomegalie);
    }

    public void setConsTypeSpleno(String ConsTypeSpleno) {
        this.ConsTypeSpleno.setText(ConsTypeSpleno);
    }

    public void setConsAutres(String ConsAutres) {
        this.ConsAutres.setText(ConsAutres);
    }

    public void setConsETGSOms(String ConsETGSOms) {
        this.ConsETGSOms.setText(ConsETGSOms);
    }

    public void setConsBMI(String ConsBMI) {
        this.ConsBMI.setText(ConsBMI);
    }

    public void setConsCVC(String ConsCVC) {
        this.ConsCVC.setText(ConsCVC);
    }

    public void setConsHPM(String ConsHPM) {
        this.ConsHPM.setText(ConsHPM);
    }

    public void setConsOMI(String ConsOMI) {
        this.ConsOMI.setText(ConsOMI);
    }

    public void setConsAutreS(String ConsAutreS) {
        this.ConsAutreS.setText(ConsAutreS);
    }

    public void setConsSyndrParaneo(String ConsSyndrParaneo) {
        this.ConsSyndrParaneo.setText(ConsSyndrParaneo);
    }

    public void setConsSyndrPrecise(String ConsSyndrPrecise) {
        this.ConsSyndrPrecise.setText(ConsSyndrPrecise);
    }

    public void setConshpmFH(String ConshpmFH) {
        this.ConshpmFH.setText(ConshpmFH);
    }

    public void setConshpmConsistance(String ConshpmConsistance) {
        this.ConshpmConsistance.setText(ConshpmConsistance);
    }

    public void setConshmpSurface(String ConshmpSurface) {
        this.ConshmpSurface.setText(ConshmpSurface);
    }
    
    
    public void ConsultationE(String NumDossier) throws SQLException{
        
        CirconstanceDeDecouvertClasse cird        =  null;
        Consultation  bddCons  = new Consultation();
  ResultSet res = bddCons.ExtElement("select * from circonstancedec where NumDossier = '"+NumDossier+"'");
  if(res.next()){
  cird = new CirconstanceDeDecouvertClasse(res.getString(2),res.getDate(3),res.getString(4),res.getString(5),
        res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),
        res.getString(12),res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),
        res.getString(18),res.getString(19),res.getString(20),res.getString(21),res.getString(22),res.getString(23),
        res.getString(24),res.getString(26),res.getString(27),res.getString(28));
  bddCons.CloseConnex();
  }
    try{
        this.setConsEMTHepato(cird.getEMTHepato());
        this.setConsDDebSympto(cird.getDDebSympto().toString());
        this.setConsFortuit(cird.getFortuit());
        this.setConsDECSyrrhose(cird.getDECSyrrhose());
        this.setConsEchographie(cird.getEchographie());
        this.setConsDosAFP(cird.getDosAFP());
        this.setConsAmaigre(cird.getAmaigre());
        this.setConsFièvre(cird.getFièvre());
        this.setConsIctère(cird.getIctère());
        this.setConsDouleurHD(cird.getDouleurHD());
        this.setConsHemoragieDes(cird.getHemoragieDes());
        this.setConsAscite(cird.getAscite());
        this.setConsSplénomegalie(cird.getSplénomegalie());
        this.setConsTypeSpleno(cird.getTypeSpleno());
        this.setConsAutres(cird.getAutres());
        this.setConsETGSOms(cird.getETGSOms());
        this.setConsBMI(cird.getBMI());
        this.setConsCVC(cird.getCVC());
        this.setConsHPM(cird.getHPM());
        this.setConsOMI(cird.getOMI());
        this.setConsAutreS(cird.getAutreS());
        this.setConsSyndrParaneo(cird.getSyndrParaneo());
        this.setConsSyndrPrecise(cird.getSyndrPrecise());
        this.setConshpmFH(cird.getHpmFH());
        this.setConshpmConsistance(cird.getHpmConsistance());
        this.setConshmpSurface(cird.getHmpSurface());
        
    }catch(Exception e){
              this.setConsEMTHepato("----------");
        this.setConsDDebSympto("1999-09-09");
        this.setConsFortuit("----------");
        this.setConsDECSyrrhose("----------");
        this.setConsEchographie("----------");
        this.setConsDosAFP("----------");
        this.setConsAmaigre("----------");
        this.setConsFièvre("----------");
        this.setConsIctère("----------");
        this.setConsDouleurHD("----------");
        this.setConsHemoragieDes("----------");
        this.setConsAscite("----------");
        this.setConsSplénomegalie("----------");
        this.setConsTypeSpleno("----------");
        this.setConsAutres("----------");
        this.setConsETGSOms("----------");
        this.setConsBMI("----------");
        this.setConsCVC("----------");
        this.setConsHPM("----------");
        this.setConsOMI("----------");
        this.setConsAutreS("----------");
        this.setConsSyndrParaneo("----------");
        this.setConsSyndrPrecise("----------");
        this.setConshpmFH("----------");
        this.setConshpmConsistance("----------");
        this.setConshmpSurface("----------");  
    }
    }
    /***************************Partie* Modification***************************************************************************/
    public String getEMTHepatoMod() {
        return ConsEMTHepatoMod.getText();
    }

    public LocalDate getConsDDebSymptoMod() {
        return ConsDDebSymptoMod.getValue();
    }

    public String getConsFortuitMod() {
        return ConsFortuitMod.getText();
    }

    public String getConsDECSyrrhoseMod() {
        return ConsDECSyrrhoseMod.getText();
    }

    public String getConsEchographieMod() {
        return ConsEchographieMod.getText();
    }

    public String getConsDosAFPMod() {
        return ConsDosAFPMod.getText();
    }

    public String getConsSignLabelMod() {
        return ConsSignLabelMod.getText();
    }

    public String getConsAmaigreMod() {
        return ConsAmaigreMod.getText();
    }

    public String getConsFièvreMod() {
        return ConsFièvreMod.getText();
    }
    //ConsIctereMod,ConsIctère
    public String getConsIctere(){
        return ConsIctereMod.getText();
    }
                

    public String getConsDouleurHDMod() {
        return ConsDouleurHDMod.getText();
    }

    public String getConsSignHLabelMod() {
        return ConsSignHLabelMod.getText();
    }

    public String getConsHemoragieDesMod() {
        return ConsHemoragieDesMod.getText();
    }

    public String getConsAsciteMod() {
        return ConsAsciteMod.getText();
    }

    public String getConsSplénomegalieMod() {
        return ConsSplénomegalieMod.getText();
    }

    public String getConsTypeSplenoMod() {
        return ConsTypeSplenoMod.getText();
    }

    public String getConsAutresMod() {
        return ConsAutresMod.getText();
    }

    public String getConsSignPhMod() {
        return ConsSignPhMod.getText();
    }

    public String getConsETGSOmsMod() {
        return ConsETGSOmsMod.getText();
    }

    public String getConsBMIMod() {
        return ConsBMIMod.getText();
    }

    public String getConsCVCMod() {
        return ConsCVCMod.getText();
    }

    public String getConsHPMMod() {
        return ConsHPMMod.getText();
    }

    public String getConshpmFHMod() {
        return ConshpmFHMod.getText();
    }

    public String getConshpmConsistanceMod() {
        return ConshpmConsistanceMod.getText();
    }

    public String getConshmpSurfaceMod() {
        return ConshmpSurfaceMod.getText();
    }

    public String getConsOMIMod() {
        return ConsOMIMod.getText();
    }

    public String getConsAutreSMod() {
        return ConsAutreSMod.getText();
    }

    public String getConsSyndrParaneoMod() {
        return ConsSyndrParaneoMod.getText();
    }

    public String getConsSyndrPreciseMod() {
        return ConsSyndrPreciseMod.getText();
    }

    
    
    
    public void setConsEMTHepatoMod() {     
        ConsEMTHepatoMod.setText(ConsEMTHepato.getText());
    }

    public void setConsDDebSymptoMod() {
        ConsDDebSymptoMod.setValue(ConvertStrDate(ConsDDebSympto.getText()));
    }

    public void setConsFortuitMod() {
        ConsFortuitMod.setText(ConsFortuit.getText());
    }

    public void setConsDECSyrrhoseMod() {//setConsEMTHepatoMod();setConsDDebSymptoMod();setConsFortuitMod()
        ConsDECSyrrhoseMod.setText( ConsDECSyrrhose.getText());
    }
                                         
    public void setConsEchographieMod() { 
        ConsEchographieMod.setText(ConsEchographie.getText());
    }

    public void setConsDosAFPMod() {
        ConsDosAFPMod.setText(ConsDosAFP.getText());
    }
                                           
    public void setConsAmaigreMod() {
        ConsAmaigreMod.setText(ConsAmaigre.getText());
    }

    public void setConsFièvreMod() {
        ConsFièvreMod.setText(ConsFièvre.getText());
    }
    
    public void setConsIctere(){
         ConsIctereMod.setText(ConsIctère.getText());
    }

    public void setConsDouleurHDMod() {
        ConsDouleurHDMod.setText(ConsDouleurHD.getText());
    }
  
    public void setConsHemoragieDesMod() {
        ConsHemoragieDesMod.setText(ConsHemoragieDes.getText());
    }

    public void setConsAsciteMod() {
        ConsAsciteMod.setText(ConsAscite.getText());
    }

    public void setConsSplénomegalieMod() {
       ConsSplénomegalieMod.setText(ConsSplénomegalie.getText());
    }

    public void setConsTypeSplenoMod() {
        ConsTypeSplenoMod.setText(ConsTypeSpleno.getText());
    }

    public void setConsAutresMod() {
        ConsAutresMod.setText(ConsAutres.getText());
    }

    public void setConsETGSOmsMod() {
        ConsETGSOmsMod.setText(ConsETGSOms.getText());
    }

    public void setConsBMIMod() {
        ConsBMIMod.setText(ConsBMI.getText());
    }

    public void setConsCVCMod() {
        ConsCVCMod.setText(ConsCVC.getText());
    }

    public void setConsHPMMod() {
        ConsHPMMod.setText(ConsHPM.getText());
    }

    public void setConshpmFHMod() {
        ConshpmFHMod.setText(ConshpmFH.getText());
    }

    public void setConshpmConsistanceMod() {
        ConshpmConsistanceMod.setText(ConshpmConsistance.getText());
    }

    public void setConshmpSurfaceMod() {
        ConshmpSurfaceMod.setText(ConshmpSurface.getText());
    }

    public void setConsOMIMod() {
        ConsOMIMod.setText(ConsOMI.getText());
    }

    public void setConsAutreSMod() {
        ConsAutreSMod.setText(ConsAutreS.getText());
    }

    public void setConsSyndrParaneoMod() {   
        ConsSyndrParaneoMod.setText(ConsSyndrParaneo.getText());
    }

    public void setConsSyndrPreciseMod() {
        ConsSyndrPreciseMod.setText(ConsSyndrPrecise.getText());
                }
    
    /********/
     public LocalDate ConvertStrDate(String DateStr){
      
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(DateStr, formatter);
        
        return date;
    }
     
     
     public void ModifChamp(){
      setConsEMTHepatoMod();setConsDDebSymptoMod();setConsFortuitMod();
      setConsDECSyrrhoseMod();setConsEchographieMod();setConsDosAFPMod();
      setConsAmaigreMod();setConsFièvreMod();setConsDouleurHDMod();setConsHemoragieDesMod();setConsAsciteMod();
      setConsSplénomegalieMod();setConsTypeSplenoMod();setConsAutresMod();setConsETGSOmsMod();setConsBMIMod();
      setConsCVCMod();setConsHPMMod();setConsETGSOmsMod();setConsBMIMod();setConsCVCMod();setConsHPMMod();
      setConshpmFHMod();setConshpmConsistanceMod();setConshmpSurfaceMod();setConsOMIMod();setConsAutreSMod();
      setConsSyndrParaneoMod();setConsSyndrPreciseMod() ; setConsIctere(); 
     }
     
     /******/
     public int UpdateSGBD(String NumDossier) throws SQLException{
       
        MiseAjour  bddUpdate        = new MiseAjour();
        
        //EMTHepato =',DDebSympto =',Fortuite =',DECSyrrhose =',Echographie =',DosAFP =',Amaigre =',
        //Fièvre =',Ictère =',DouleurHD =',HemoragieDes =',Ascite =',Splénomegalie =',TypeSpleno =',
        //Autres =',ETGSOms =',BMI =',CVC =',HPM =',OMI =',AutreS =',SyndrParaneo =',SyndrPrecise =',
        //hpmFH =',hpmConsistance =',hmpSurface =');
           System.out.println("ici : "+getConsAutresMod());
        int j =bddUpdate.AddElement("update CirconstanceDec set EMTHepato ='"+this.getEMTHepatoMod()+"',DDedSympto ='"+this.getConsDDebSymptoMod()+"',Fortuit ='"+this.getConsFortuitMod()+
                "',DECSyrrhose ='"+this.getConsDECSyrrhoseMod()+"',Echographie ='"+this.getConsEchographieMod()+"',DosAFP ='"+this.getConsDosAFPMod()+"',Amaigre ='"+this.getConsAmaigreMod()+
                "',Fievre ='"+this.getConsFièvreMod()+"',Ictere ='"+this.getConsIctere()+"',DouleurHD ='"+this.getConsDouleurHDMod()+"',HemoragieDes ='"+this.getConsHemoragieDesMod()+
                "',Ascite ='"+this.getConsAsciteMod()+"',Splenomegalie ='"+this.getConsSplénomegalieMod()+"',TypeSpleno ='"+this.getConsTypeSplenoMod()+
                "',ETGSOms ='"+this.getConsETGSOmsMod()+"',BMI ='"+this.getConsBMIMod()+"',CVC ='"+this.getConsCVCMod()+"',HPM ='"+this.getConsHPMMod()+"',OMI ='"+this.getConsOMIMod()+
                "',AutreS ='"+this.getConsAutreSMod()+"',SyndrParaneo ='"+this.getConsSyndrParaneoMod()+"',SynderPrecise ='"+this.getConsSyndrPreciseMod()+"',hpmFH ='"+this.getConshpmFHMod()+
                "',hpmConsistance ='"+this.getConshpmConsistanceMod()+"',hpmSurface ='"+this.getConshmpSurfaceMod()+"',Autre ='"+this.getConsAutresMod()+"' where NumDossier ='"+NumDossier+"'");
    return j;
    
    }
    
        public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from CirconstanceDec where NumDossier ='"+NumDossier+"'");
            
            return j;
        }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
