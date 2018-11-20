
package service.medicament.DossierPatient;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.event.EventType; 
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import service.medicament.BilanPatient.*;
import service.medicament.BilanPatient.BilanRadiologique.*;
import service.medicament.Patient.*;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;
import service.medicament.TraitementProposer.*;


public class FichePatientSpace extends Parent {
    
    final     Label         titleL       =   new Label();     
    final     Button        creerb       =   new Button("Creér");
    final     TextField     numdtext     ;
    Label labelNum    =  new Label(); 
    final     HBox          hbox         =   new  HBox();
    final     IdentiteSpace IdSpace      ; 
    
    final     String[]      NamePartie   =  {"Création de Dossier","IDENTITE"};  
    final     Label[]       PartieN      =  new Label[NamePartie.length];
    
    final DropShadow          shadow     =  new DropShadow();
    
    final DatePicker          datepickerDC    =   new DatePicker();
    final VBox           vbox            =   new VBox();
    final VBox           vbox1           =   new VBox();
    final VBox vbFonction     = new VBox(5);
     final VBox HyperAccord   =  new VBox(5);
    
     final String[]       NamesANTCD       = {"ATCDS Personnels","ATCDS Familiaux","Circonstances DE Decouverte "};
      final Label[]        ANTCD123         = new Label[NamesANTCD.length]; 
      final  String[]      NamesBilan123    = {"Bilan biologique","Bilan Immunologique","FOGD"};
      final  Label[]       Bilan123         = new Label[NamesBilan123.length];
      final String[]       NamesBR          = {"Echographie","Echographie doppler","TDM","IRM","AutreExamens"};
      final Label[]        BilanBR          = new Label[NamesBR.length ];
      Label                AnapathBilan     = new Label("Anapath");
       final Label       RemplirClass         = new Label("Remplir les Classifications");
       
       final Label       Deces                = new Label("Décès");
      final String[]    NamesTraitement      = {"Chirurgie","Alcoolisation","Radiofréquence",
                                                " ChimioEmbolisation ","Therapies Cibles  ",
                                                "Traitement ANTI-VIRAL "};
      final Label[]     Traitement16          = new Label[NamesTraitement.length];
      
      final Label       LabelNum              = new Label("Numéro du dosssier : ");
      final Text        NumDossCurent         = new Text();
      final Label       LabelName             = new Label("Nom du Patient     : ");
      final Text        NameDossie            = new Text();
      final Label       LabelPrenom           = new Label("Prénom du Patient  : " );
      final Text        PrenomLabel           = new Text();
      final GridPane    gridDC                = new GridPane();
      final StackPane   panelDC               = new StackPane();
      
      
     final TextField    TextNumDoss;
     final Label        IndErrLabel;
     
    public FichePatientSpace() throws SQLException{
                           IdSpace    = new IdentiteSpace(0,NumDossCurent.getText());
        final     Node[]   PartieD    =   {hbox,IdSpace
                };
        
        vbFonction.setTranslateX(350);  vbFonction.setTranslateY(-50);
        vbFonction.setPrefSize(900,500);vbFonction.setMinHeight(500); 
        vbFonction.setOpacity(0.7);
        /////
        gridDC.setVgap(5); gridDC.setHgap(5); gridDC.setPadding(new Insets(5,10,5,5));
        gridDC.add(LabelNum, 0,0);     gridDC.add(LabelName, 0,1);  gridDC.add(LabelPrenom,0,2);
        gridDC.add(NumDossCurent,1,0); gridDC.add(NameDossie,1,1);  gridDC.add(PrenomLabel,1,2);
        panelDC.getChildren().add(gridDC);  gridDC.getStyleClass().add("setStylingRoot");
        panelDC.setStyle("-fx-background-color: rgb(225, 228, 203);");
        panelDC.setOpacity(0.8);
        panelDC.setTranslateX(750); panelDC.setTranslateY(-100);
        panelDC.setMinWidth(400);
        /////
       
        
        titleL.setText("La Creation d' un dossier ");
        ImageView titleimg    =   new ImageView(new Image(getClass().getResourceAsStream("Images/7_1.jpg")));
        titleimg.setFitHeight(50);
        titleimg.setPreserveRatio(true);
        titleL.setGraphic(titleimg);
        
       
        
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(5);
       //////
      
        datepickerDC.setValue(LocalDate.now());
        //datepickerDC.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        //datepickerDC.setTextFill(Color.web("#0076a3"));
        datepickerDC.setTooltip(new Tooltip(" Date de Création "));
        
        numdtext    = ChampNumDoss1();
        numdtext.setPromptText("Veuillez saisir le numéro du dossier ");
        numdtext.setPrefWidth(150);
        
       hbox.setPadding(new Insets(10,10,10,10));
       hbox.setSpacing(20);labelNum.getStyleClass().add("erreurchamp");
       hbox.getChildren().addAll(numdtext,datepickerDC,labelNum);
       //////
    
       final  VBox              vbox1         =   new VBox();
       vbox1.setPadding(new Insets(10,10,10,10));
       vbox1.setSpacing(20);
     
       for(int i =0 ; i < PartieD.length ; i++){
           Label l = PartieN[i] = new Label(NamePartie[i]);
           l.getStyleClass().add("setyleLabelPatieName");
           vbox1.getChildren().addAll(l , PartieD[i]);
           
       }
       
       creerb.getStyleClass().add("styleButton");
       
       creerb.setTranslateY(90);
       creerb.setTranslateX(170);
       creerb.setPrefWidth(100);
        //
        shadow.setOffsetX(1);
        shadow.setOffsetY(0.5);
        shadow.setColor(Color.AQUA);
     
       
       creerb.setTranslateX(600);creerb.setTranslateY(0);
       final ImageView   IndImg         = new ImageView(new Image(getClass().getResourceAsStream("Images/17.jpg")));
       IndImg.setFitHeight(30); IndImg.setPreserveRatio(true);
       final Label       IndInsSQL      = new Label("Vous devez changer le numéro du dossier",IndImg);
       IndInsSQL.setVisible(false);
       IndInsSQL.getStyleClass().add("erreurchamp");
       vbox1.getChildren().addAll(IndInsSQL ,creerb);
      
      
      
       vbox.getChildren().addAll(vbox1);
       
      vbox1.setStyle(" -fx-background-color: white;");
      vbox1.setMaxHeight(500);
      vbox1.setMinHeight(200);
      vbox1.setMinWidth(900);
      
      final  Accordion     Accord           = new Accordion();
      //////
      final TitledPane     titledANTCD      = new TitledPane();
      titledANTCD.setText("Remplir les ATCDS");
     
      final VBox           vbANTCD          = new VBox(5);
      for(int i =0 ;i<NamesANTCD.length ; i++){
          Label l = ANTCD123[i] = new Label(NamesANTCD[i]);
          generateEffect(l);
          l.getStyleClass().add("setsttyleTraitementPpartie");
          vbANTCD.getChildren().add(l);
          genereteFonstionATCD(l, i);
      }
      titledANTCD.setContent(vbANTCD);
      //////
      
      final  TitledPane    titledBilan      = new TitledPane(); titledBilan.setPrefWidth(200);
      titledBilan.setText("Ajouter BILAN");
      
      final  VBox          vbBilan1234       = new VBox(5);
      for(int i =0 ; i <  NamesBilan123.length ; i++){
          Label l = Bilan123[i] = new Label(NamesBilan123[i]);
          generateEffect(l);
          genereteFonstionATCD(l, (i+1)*3);
          l.getStyleClass().add("setsttyleTraitementPpartie");
          vbBilan1234.getChildren().add(l);
          
      }
      final TitledPane    BilanRadioTitled  = new TitledPane();
      BilanRadioTitled.setText("Bilan Radiologique");
      
      final VBox           vbBR             = new VBox(5);
      
      for(int i =0 ; i< NamesBR.length ; i++){
          Label l =   BilanBR[i] = new Label(NamesBR[i]);
           generateEffect(l);
           if(i != 4)
           genereteFonstionATCD(l, (i+1)*4);
           else  genereteFonstionATCD(l, 19);
          l.getStyleClass().add("setsttyleTraitementPpartie");
          vbBR.getChildren().add(l);
      }
     
      Accord.getPanes().addAll(titledANTCD,titledBilan);
      BilanRadioTitled.setContent(vbBR);
      vbBilan1234.getChildren().add(BilanRadioTitled);
      
       
      AnapathBilan.getStyleClass().add("setsttyleTraitementPpartie");
      generateEffect(AnapathBilan);
      genereteFonstionATCD(AnapathBilan,21);
      vbBilan1234.getChildren().add(AnapathBilan);
      titledBilan.setContent(vbBilan1234);
      
      final TitledPane  titledClassification = new TitledPane();
      titledClassification.setText("CLASSIFICATION");
      
      RemplirClass.getStyleClass().add("setsttyleTraitementPpartie");
      generateEffect(RemplirClass);
      genereteFonstionATCD(RemplirClass,22);
      titledClassification.setContent(RemplirClass);
      
      Accord.getPanes().add(titledClassification);
      
      final TitledPane  titledTraitement     = new TitledPane();
      titledTraitement.setText("TRAITEMENT PROPOSE");
      
      final VBox        vbTraitement         = new VBox(5);
      for(int i =0 ; i <NamesTraitement.length ; i++ ){
          Label l = Traitement16[i] = new Label(NamesTraitement[i]);
          generateEffect(l);
          genereteFonstionATCD(l, (i+1)*5);
          l.getStyleClass().add("setsttyleTraitementPpartie");
          vbTraitement.getChildren().add(l);
      }
      titledTraitement.setContent(vbTraitement);
      
      Accord.getPanes().add(titledTraitement);
      
      /******/
       final TitledPane  titledDeces = new TitledPane();
      titledDeces.setText("Décès");
      
      Deces.getStyleClass().add("setsttyleTraitementPpartie");
      generateEffect(Deces);
      genereteFonstionATCD(Deces,35);
      titledDeces.setContent(Deces);
      
      Accord.getPanes().add(titledDeces);
     
      final  Hyperlink    CreerH    = new Hyperlink("Creér autre dossier");
      ////////////////////////////////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////////////////////////////
        final VBox          vbTraitDoss1             = new VBox(5);
        final HBox          vbTraitDoss              = new HBox(10);
       // vbTraitDoss.getChildren().add(vbTraitDoss1);
        final Label         DiffLabel               = new Label("Compléter un dossier ; ");
        DiffLabel.getStyleClass().add("labelCons");
        TextNumDoss             =  ChampNumDoss(); 
        TextNumDoss.setPromptText("Numéro du dossier Ex(111/12)");
        TextNumDoss.setMaxWidth(380);
                            IndErrLabel             = new Label();
        final Button        TraiterDoss             = new Button("Traiter");TraiterDoss.getStyleClass().add("styleButton");
        final Label         IndOu                   = new Label("Ou ");
        IndOu.setAlignment(Pos.BOTTOM_CENTER);
        final Hyperlink     hyperAutreD             = new Hyperlink("Créer un nouveau dossier");IndOu.getStyleClass().addAll("labelAutre","labelCons");
        vbTraitDoss1.getChildren().addAll(DiffLabel,TextNumDoss,IndErrLabel,TraiterDoss);
        
        final Separator   SepDoss    = new Separator();
        SepDoss.setOrientation(Orientation.VERTICAL);
        SepDoss.getStyleClass().add("Sep");
        vbTraitDoss.getChildren().addAll(hyperAutreD,SepDoss,vbTraitDoss1);
        
        vbTraitDoss.getStyleClass().add("vbCons");       
        hyperAutreD.getStyleClass().add("LineCree");
        vbTraitDoss.setPrefSize(1150,300);
        
        TraiterDoss.setOnAction((AcionEvent)->{
                               try {   
                                   VerifTraitDoss(TextNumDoss.getText());
                               } catch (SQLException ex) {
                                   Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                               }
        });
        
        
        hyperAutreD.setOnAction((ActionEvent)->{
      final Label l = new Label();
            genrateLabel(l,ANTCD123);genrateLabel(l,Bilan123);genrateLabel(l,BilanBR);genrateLabel(l,Traitement16);
                AnapathBilan.setDisable(false);RemplirClass.setDisable(false);
             IdSpace.Initialisation();
             numdtext.setText("");
             labelNum.setText("");
             getChildren().clear();
             vbox.setOpacity(0.8);
             vbox.getChildren().clear();
             vbox.getChildren().add(vbox1);
             getChildren().add(vbox);this.setTranslateX(300);
                                     this.setTranslateY(100);   
    });
        //////////////////// ///////////////////////////////////////////////////////////////////////////
        CreerH.setOnAction((ActionEvent)->{
            final Label l = new Label();
            genrateLabel(l,ANTCD123);genrateLabel(l,Bilan123);genrateLabel(l,BilanBR);genrateLabel(l,Traitement16);
                AnapathBilan.setDisable(false);RemplirClass.setDisable(false);
             IdSpace.Initialisation();
             numdtext.setText("");
             labelNum.setText("");
             getChildren().clear();
             vbox.setOpacity(0.8);
             vbox.getChildren().clear();
            // vbox.getChildren().add(vbTraitDoss);
             getChildren().add(vbTraitDoss);//this.setTranslateX(300);
                                            //this.setTranslateY(100);
             
      this.setTranslateX(100);
      this.setTranslateY(100);
        });
        Accord.getStyleClass().add("setStylingRoot");
        HyperAccord.getChildren().addAll(CreerH,Accord);
      
      
      creerb.setOnAction((ActionEvent)->{
          // NumDossCurent  NameDossie PrenomLabel  *numdtext
          if( VerifChamp()){
              if(IdSpace.VerifChamp()){ 
                  try {
                      vbox.setOpacity(1);           System.out.println(numdtext.getText()+"/"+(datepickerDC.getValue().getYear()-2000));
                      
                      int l =IdSpace.InsertionSGBD(numdtext.getText()+"/"+(datepickerDC.getValue().getYear()-2000),datepickerDC.getValue());
                      if(l != 0){
                      getChildren().clear();
                      getChildren().add(HyperAccord);  this.setTranslateX(10); this.setTranslateY(50);
                      NumDossCurent.setText(numdtext.getText()+"/"+(datepickerDC.getValue().getYear()-2000));
                      NameDossie.setText(IdSpace.getNameText());
                      PrenomLabel.setText(IdSpace.getPrenomText());
                      getChildren().add(panelDC);
                      IndInsSQL.setVisible(false);
                      }
                      else {
                       IndInsSQL.setVisible(true);
                      }
                  } catch (SQLException ex) {
                      Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
          }
          });
      
      
      vbox.setOpacity(0.8);
      getChildren().addAll(vbTraitDoss);
      this.setTranslateX(100);
      this.setTranslateY(100);
    
    }
    public void genrateLabel(Label l , Label[] tab){
        l.setDisable(true);
        for(Label n : tab){
                   if(l.getText() != n.getText()){
                       n.setDisable(false);
                   }
           
               }
    
    }
  
    public void generateEffect(Label l){
        l.setPrefWidth(280);
        l.setOnMouseEntered(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {        
            l.setScaleX(1.1);  l.setScaleY(1.08); l.setEffect(shadow);
            }
        });
        l.setOnMouseExited(new EventHandler<MouseEvent>(){  

            @Override
            public void handle(MouseEvent event) {
            l.setScaleX(1);    l.setScaleY(1);   l.setEffect(null);
            }
            
        });
    }
    public void genereteFonstionATCD(Label l ,int i){
        
        vbFonction.setPadding(new Insets(20,10,20,20));
        //vbFonction.setTranslateX(400); vbFonction.setTranslateY(-50);
        //vbFonction.setPrefSize(700,500);
        //vbFonction.setStyle("-fx-background-color: white;");
        l.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                getChildren().remove(vbFonction);
                vbox.getChildren().remove(vbox1);
                
                vbFonction.getChildren().clear();
                
                genrateLabel(l,ANTCD123);genrateLabel(l,Bilan123);genrateLabel(l,BilanBR);genrateLabel(l,Traitement16);
                AnapathBilan.setDisable(false);RemplirClass.setDisable(false);
                if(i == 0){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new ANTCDpersonnelSpace(0,NumDossCurent.getText())));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 1){
                    try {
                        vbFonction.getChildren().add(new ScrollPane(new ANTCDfamiliauxSpace(0,NumDossCurent.getText())));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                if(i == 2){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new CirconstanceDeDicouvertSpace(0,NumDossCurent.getText())));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 3){
                    try {
                        vbFonction.getChildren().add(new ScrollPane(new BilanBiologique(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 6){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new BilanImmunologique(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 9){
                    try {  
                        vbFonction.getChildren().add(new ScrollPane(new BilanFOGS(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 4){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new EchographiqueBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 8){
                    try {  
                        vbFonction.getChildren().add(new ScrollPane(new EchographieDopplerBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 12){
                    try {
                        vbFonction.getChildren().add(new ScrollPane(new TDMBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 16){
                    try {  
                        vbFonction.getChildren().add(new ScrollPane(new IRMBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 19){
                    try {  
                        vbFonction.getChildren().add(new ScrollPane(new AutreExamenBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 21){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new AnapathBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   AnapathBilan.setDisable(true);
                }
                if(i == 22){
                    try {
                        vbFonction.getChildren().add(new ScrollPane(new ClassificationChildPughBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   RemplirClass.setDisable(true);
                }
                if(i == 5){
                    try {  
                        vbFonction.getChildren().add(new ScrollPane(new TraitementProposerBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 10){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new AlcoolisationTR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 15){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new RadioFrequenceBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 20){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new ChimieomBolisationBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 25){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new TherapieCibles(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(i == 30){
                    try { 
                        vbFonction.getChildren().add(new ScrollPane(new TraitementAntiViralBR(0,NumDossCurent.getText(),"")));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(i == 35){
         
                    try {
                        vbFonction.getChildren().add(new ScrollPane(new DecesSpace(NumDossCurent.getText(),0)));
                    } catch (SQLException ex) {
                        Logger.getLogger(FichePatientSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                getChildren().add(vbFonction);
                
            }
            
        });
    }
    public boolean VerifChamp(){
        if(numdtext.getText().equals("")){
            labelNum.setText("Numéro du dossier... !! ");
            return false; 
            
        }else {
            labelNum.setText("");
            return true;
        }
    }

    private TextField ChampNumDoss1() {
      TextField textF =  new TextField(){
            String str = "";
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && numdtext.getText().length() < 3){
                    super.replaceText(start, end, text);
                    labelNum.setText(""); 
                    
                }else 
                    if(numdtext.getText().length() < 3){
                labelNum.setText(" Entrer une valeur numerique ");
                }else labelNum.setText("");
            }
          
        };
      return textF;
    };
      private TextField ChampNumDoss() {
      TextField textF =  new TextField(){
            String str = "";
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9/]") &&  TextNumDoss.getText().length() < 6){
                    super.replaceText(start, end, text);
                    IndErrLabel.setText(""); 
                    
                }else 
                    if(numdtext.getText().length() < 5){
                IndErrLabel.setText(" Entrer une valeur numerique ");IndErrLabel.getStyleClass().add("erreurchamp");
                }else{
                        IndErrLabel.setText("");
                        
                    }
            }
          
        };
      return textF;
    };
      
      public void VerifTraitDoss(String NumDossier) throws SQLException{
          DossierClasse    Dossier    = null;
          Consultation     bddVerif   = new Consultation();
          boolean existe = bddVerif.VerifElement("select * from dossiermedicale where NumDossier ='"+NumDossier+"'");
          
          
          if(existe){
            final Label l = new Label();
             genrateLabel(l,ANTCD123);genrateLabel(l,Bilan123);genrateLabel(l,BilanBR);genrateLabel(l,Traitement16);
             AnapathBilan.setDisable(false);RemplirClass.setDisable(false);
             NumDossCurent.setText(TextNumDoss.getText());
             ResultSet res = bddVerif.ExtElement("select nom,prenom from patient where NumDossier = '"+NumDossier+"'");
            while(res.next()){
             NameDossie.setText(res.getString(1));
             PrenomLabel.setText(res.getString(2));
             
             AddConsult(NumDossier);
            }
             bddVerif.CloseConnex();
             IdSpace.Initialisation();
             numdtext.setText("");
             labelNum.setText("");
             getChildren().clear();
             getChildren().add(panelDC);
             getChildren().add(HyperAccord);  this.setTranslateX(10); this.setTranslateY(50);
             
                 
          }else{
             IndErrLabel.setText("Le numéro est  irrégulier  ou \n le dossier n'existe pas ");
             IndErrLabel.getStyleClass().add("erreurchamp");
          }
          
      }
      
      
       public void AddConsult(String NumDossier) throws SQLException{
       
        MiseAjour  bddCons        =  new MiseAjour();
        bddCons.AddElement("insert into DossierTrait values ('"+NumDossier+"','"+this.ExtNomDossierP(NumDossier)+"','Traitement',Now())");
       
    }
    
    public String ExtNomDossierP(String NumDossier) throws SQLException{
        String nom = null;
        Consultation bddCons      = new Consultation();
        ResultSet res =bddCons.ExtElement("select Nom from Patient where NumDossier ='"+NumDossier+"'");
        
        while(res.next())
        nom = res.getString(1);
    
        bddCons.CloseConnex();
        return nom;
    }

    

   
    
}
