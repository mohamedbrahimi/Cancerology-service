
package service.medicament.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import service.medicament.RendezVous.WeekClasse;
import service.medicament.SGBD.Consultation;

public class InfoPatient extends Parent{
     
    /***/
    final HBox      ContenuInfo          = new HBox(5);
    final TableColumn      NomCol        = new TableColumn("Nom");
    final TableColumn      PrenomCol     = new TableColumn("Prenom");
    final TableView        table         = new TableView(); 
    
    /***Info Detaille**/
    final private        Label             NumDossierC       =  new Label();        
    final private        Label             DateHospital      =  new Label();
    
    final private        Label             AgeC              =  new Label();
    final private        Label             SexeC             =  new Label();
    final private        Label             OrigineC          =  new Label();
    final private        Label             ProfessionC       =  new Label();
    final private        Label             AdresseC          =  new Label();
    final private        Label             Tel1C             =  new Label();
    final private        Label             Tel2C             =  new Label();
    final private        Label             SituationFamC     =  new Label();
    final private        Label             ConditionEcC      =  new Label();
    /********************/
    private Label BilanBiologique          = new Label(); 
    private Label BilanImmnologique        = new Label();;
    private Label BilanFOGD                = new Label();;
    
    private Label Echographie              = new Label();;
    private Label EchographieDoppler       = new Label();;
    private Label TDM                      = new Label();;
    private Label IRM                      = new Label();;
    private Label Anapath                  = new Label();;
    
    
    /***/
    private Label Chirurgie                = new Label();;
    private Label Alcoolisation            = new Label();;
    private Label RadioFrequence           = new Label();;
    private Label ChimieOembolisation      = new Label();;
    private Label TherapiesCibles          = new Label();;
    private Label TraitemenAntiViral       = new Label();;
    
    
    private TextField  Rech                = new TextField();
    /***/
    String[]  tables    = {"alcoolisation" ,"bilananapath","bilanandoschopique","bilanbiologique",
        "bilanimmunologique","chimioembolisation","chirurgie","echographie","echographiedoppler","irm"
       ,"radiofrequence","tdm","therapiescibles","traitementantivirale"};
    /**/
    
    private Label EtatEvolution             = new Label();
    /**/
    
    public InfoPatient() throws SQLException{
        
     final  ObservableList<PatientClasse> data = this.ExtrTablePatient(); 
    NomCol.setPrefWidth(200);
    NomCol.setMaxWidth(300);
    NomCol.setCellValueFactory(
    new PropertyValueFactory<>("Nom"));
    PrenomCol.setPrefWidth(200);
    PrenomCol.setMaxWidth(300);
    PrenomCol.setCellValueFactory(
    new PropertyValueFactory<>("Prenom"));
      
    table.getColumns().addAll(NomCol,PrenomCol);
    table.setItems(data);
    table.setPrefHeight(530);
    /**/
  table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
      try{
            PatientClasse Patient = (PatientClasse)table.getSelectionModel().getSelectedItem();


     if(Patient !=null){
                                                    this.setConditionEcC(Patient.getCondSocioEco());
                                                    this.setTel1C(Patient.getTel1());
    this.setAgeomC(Patient.getAge());               this.setTel2C(Patient.getTel2());
    this.setSexeC(Patient.getSexe());               this.setSituationFamCC(Patient.getSituationFamiliale());
    this.setAdresseC(Patient.getAdresse());         this.setOrigineC(Patient.getWilaya());
    this.setProfessionC(Patient.getProfession());       
    this.setNumDossier(Patient.getNumDossier());
    this.setDateHospital(Patient.getDateHospital());
    
    
    this.setAlcoolisation(Patient.getAlcoolisation());
    this.setAnapath(Patient.getAnapath());
    this.setTDM(Patient.getTDM());
    this.setIRM(Patient.getIRM());
    this.setBilanBiologique(Patient.getBilanBiologique());
    this.setBilanFOGD(Patient.getBilanFOGD());
    this.setBilanImmnologique(Patient.getBilanImmnologique());
    this.setChimieOembolisation(Patient.getChimieOembolisation());
    this.setChirurgie(Patient.getChirurgie());
    this.setEchographie(Patient.getEchographie());
    this.setEchographieDoppler(Patient.getEchographieDoppler());
    this.setTherapiesCibles(Patient.getTherapiesCibles());
    this.setTraitemenAntiViral(Patient.getTraitemenAntiViral());
    this.setRadioFrequence(Patient.getRadioFrequence());
    
    if(Patient.getEtatEvolution() == 2){
        this.setEtatEvolution("orange");
    }else if(Patient.getEtatEvolution() < 2){
        this.setEtatEvolution("red");
    }else{
        this.setEtatEvolution("green");
    }
          
     }
}catch(ClassCastException cce){
 // you error here
}
        });
  
   /***/
    final         GridPane          gridC              =      new GridPane();   
    gridC.setVgap(10);    gridC.setHgap(20);
    
    
    final Label LabelHeader             = new Label("Détails ");   LabelHeader.getStyleClass().add("label-header"); gridC.add(LabelHeader,0,0,1,3);
    final Label NumDossierCons          = new Label("Numéro Dossier         ");  gridC.add(NumDossierCons, 1,0,2,1);     NumDossierCons.getStyleClass().add("label-bright");    gridC.add(NumDossierC, 3,0);     
    final Label DateHospitalCons        = new Label("Date Hospitalisation   ");  gridC.add(DateHospitalCons,1,1,2,1);    DateHospitalCons.getStyleClass().add("label-bright");  gridC.add(DateHospital,3,1);     
    
    final Label AgeCons                 = new Label("Age                    ");  gridC.add(AgeCons,0,3,2,1);         AgeCons.getStyleClass().add("label-bright");          gridC.add(AgeC,1,3);
    final Label SexeCons                = new Label("Sexe                   ");  gridC.add(SexeCons,0,4,2,1);        SexeCons.getStyleClass().add("label-bright");         gridC.add(SexeC,1,4);
    final Label OrigineCons             = new Label("Origine                ");  gridC.add(OrigineCons,0,5,2,1);     OrigineCons.getStyleClass().add("label-bright");      gridC.add(OrigineC,1,5);
    final Label ProfessionCons          = new Label("Profession             ");  gridC.add(ProfessionCons,0,6,2,1);  ProfessionCons.getStyleClass().add("label-bright");   gridC.add(ProfessionC,1,6);
    final Label AdresseCons             = new Label("Adresse                ");  gridC.add(AdresseCons,0,7,2,1);     AdresseCons.getStyleClass().add("label-bright");      gridC.add(AdresseC,1,7);
    final Label Tel1Cons                = new Label("Telephone 1            ");  gridC.add(Tel1Cons,0,8,2,1);        Tel1Cons.getStyleClass().add("label-bright");         gridC.add(Tel1C,1,8);
    final Label Tel2Cons                = new Label("Telephone 2            ");  gridC.add(Tel2Cons,0,9,2,1);        Tel2Cons.getStyleClass().add("label-bright");         gridC.add(Tel2C,1,9);
    final Label SituatCons              = new Label("Situation Familiale    ");  gridC.add(SituatCons,0,10,2,1);     SituatCons.getStyleClass().add("label-bright");       gridC.add(SituationFamC,2,10);
    final Label CondSCons               = new Label("Conditions SocioEco    ");  gridC.add(CondSCons,0,11,2,1);      CondSCons.getStyleClass().add("label-bright");        gridC.add(ConditionEcC,2,11);
    
    
    gridC.getStyleClass().add("hb");
    gridC.setPrefSize(550, 400);
    gridC.setMaxHeight(400);
    
    final         GridPane          gridv              =      new GridPane();   
    gridv.setVgap(5);    gridv.setHgap(10);
    
    final Label CaptionA                = new Label("A");CaptionA.getStyleClass().add("label-header");                                          gridv.add(CaptionA, 0,0);
    final Label BilanBiologiqueC         = new Label("Bilans Biologique");        BilanBiologiqueC.getStyleClass().add("label-bright");         gridv.add(BilanBiologiqueC, 1,1);        gridv.add(BilanBiologique, 0,1);           BilanBiologique.setId("NumB");
    final Label BilanImmunologiqueC      = new Label("Bilans Immunologique");     BilanImmunologiqueC.getStyleClass().add("label-bright");      gridv.add(BilanImmunologiqueC, 1,2);     gridv.add(this.BilanImmnologique, 0,2);    BilanImmnologique.setId("NumB");
    final Label BilanAndoschopiqueC      = new Label("Bilans Andoschopique");     BilanAndoschopiqueC.getStyleClass().add("label-bright");      gridv.add(BilanAndoschopiqueC, 1,3);     gridv.add(BilanFOGD, 0,3);                 BilanFOGD.setId("NumB");
    
    final Label EchographieC              = new Label("Echographique");          EchographieC.getStyleClass().add("label-bright");              gridv.add(EchographieC, 1,4);            gridv.add(Echographie, 0,4);               Echographie.setId("NumB");
    final Label EchographieDopplerC       = new Label("Echographique Doppler");  EchographieDopplerC.getStyleClass().add("label-bright");       gridv.add(EchographieDopplerC, 1,5);     gridv.add(EchographieDoppler, 0,5);        EchographieDoppler.setId("NumB");
    final Label TDMC                      = new Label("TDM");                    TDMC.getStyleClass().add("label-bright");                      gridv.add(TDMC, 1,6);                    gridv.add(TDM, 0,6);                       TDM.setId("NumB");
    final Label IRMC                      = new Label("IRM");                    IRMC .getStyleClass().add("label-bright");                     gridv.add(IRMC, 1,7);                    gridv.add(IRM, 0,7);                       IRM.setId("NumB");
    final Label AnapathC                  = new Label("Anapath");                AnapathC.getStyleClass().add("label-bright");                  gridv.add(AnapathC, 1,8);                gridv.add(Anapath, 0,8);                   Anapath.setId("NumB");
    
    
    /***/
    
    final Label TraitP                    = new Label("Traitement Propose");  TraitP.setId("HeadLab");                                     gridv.add(TraitP, 0,10,2,1);
    
    final Label ChirurgieC                = new Label("Chirurgie");            ChirurgieC.getStyleClass().add("label-bright");             gridv.add(ChirurgieC, 1,11);          gridv.add(Chirurgie, 0,11);             Chirurgie.setId("NumB");
    final Label AlcoolisationC            = new Label("Alcoolisation");        AlcoolisationC.getStyleClass().add("label-bright");         gridv.add(AlcoolisationC, 1,12);      gridv.add(Alcoolisation,0,12);          Alcoolisation.setId("NumB");
    final Label RadioFrequenceC           = new Label("Radiofréquence");       RadioFrequenceC.getStyleClass().add("label-bright");        gridv.add(RadioFrequenceC, 1,13);     gridv.add(RadioFrequence,0,13);         RadioFrequence.setId("NumB");
    final Label ChimieOembolisationC      = new Label("ChimiOEmbolidation");   ChimieOembolisationC.getStyleClass().add("label-bright");   gridv.add(ChimieOembolisationC,1,14); gridv.add(ChimieOembolisation,0,14);    ChimieOembolisation.setId("NumB");
    final Label TherapiesCiblesC          = new Label("Therapies Cibles");     TherapiesCiblesC.getStyleClass().add("label-bright");       gridv.add(TherapiesCiblesC,1,15);     gridv.add(TherapiesCibles,0,15);        TherapiesCibles.setId("NumB");
    final Label TraitemenAntiViralC       = new Label("TRAITEMENT ANTI-VIRAL");TraitemenAntiViralC.getStyleClass().add("label-bright");    gridv.add(TraitemenAntiViralC,1,16);  gridv.add(TraitemenAntiViral,0,16);     TraitemenAntiViral.setId("NumB");
     
    gridv.getStyleClass().add("hb");
    gridv.setPadding(new Insets(1,5,5,5));
    gridv.setPrefWidth(300);
    
    /*****/
    final         GridPane          gridp              =      new GridPane();   
    gridp.setVgap(10);    gridp.setHgap(20);
    gridp.getStyleClass().add("hb");
    
    gridp.setPrefSize(200,170);
    
    final Label EtatEvolution            = new Label("Etat d'évolution ");EtatEvolution.setId("HeadLab");
    final Label IndAlert                 = new Label("Alerte ");  IndAlert.setId("NumB"); final Label ColAlert   = new Label(""); ColAlert.setPrefSize(20,20);  ColAlert.setId("red");       gridp.add(EtatEvolution, 0,0,2,1);  gridp.add(this.EtatEvolution,2,0);  this.EtatEvolution.setPrefSize(70, 20);
    final Label IndDanger                = new Label("Stable");  IndDanger.setId("NumB");final Label ColDanger  = new Label(""); ColDanger.setPrefSize(20,20); ColDanger.setId("orange");   gridp.add(IndAlert, 2,1);           gridp.add(ColAlert,  1,1);
    final Label IndGuerir                = new Label("Bien");    IndGuerir.setId("NumB");final Label ColGuerir  = new Label(""); ColGuerir.setPrefSize(20,20); ColGuerir.setId("green");    gridp.add(IndDanger,2,2);           gridp.add(ColDanger, 1,2);
                                                                                                                                                             gridp.add(IndGuerir,2,3);           gridp.add(ColGuerir, 1,3);        
    /***/ 
    final VBox  vbox       = new VBox(2);
    vbox.getChildren().addAll(gridC,gridp);
    
    
    final VBox  VbtabR              = new VBox(1);
    final ImageView  RechImg        = new ImageView(new Image(getClass().getResourceAsStream("Images/3.jpg")));
    RechImg.setFitHeight(50);
    RechImg.setPreserveRatio(true);
    
    HBox      hbRech          = new HBox(1);
    hbRech.getChildren().addAll(Rech,RechImg);
    VbtabR.getChildren().addAll(hbRech,table);
    
    ContenuInfo.getChildren().addAll(VbtabR,vbox,gridv);
   //////////////////////////////////////////////////////////////////////////////////////////
            Rech.setPrefWidth(250);
            Rech.setPromptText("Rechercher");
            Rech.setId("Champ");
            Rech.setOnKeyPressed(new EventHandler<KeyEvent>(){
         String text = "";
         @Override
         public void handle(KeyEvent event) {
           ObservableList<PatientClasse> rest        =  FXCollections.observableArrayList();
           
           if(!event.getCode().toString().equals("BACK_SPACE")){
               text = text + event.getText();
               //System.out.println(event.getCode()+"1");
           }
           else {
               if(text.length() > 0)text = text.substring(0,text.length() - 1);
              //System.out.println(event.getCode()+"2");
           }
            
           for(PatientClasse   d : data){
               if(d.getNom().toUpperCase().startsWith(text.toUpperCase())){
                   rest.add(d);
               } 
            }
           if(!text.equals("")){table.setItems(rest);
           table.getSelectionModel().selectFirst();
           }           else  table.setItems(data);
         }
    });
   
   /***/
 
    
    getChildren().add(ContenuInfo);
    }
    
    public ObservableList<PatientClasse> ExtrTablePatient() throws SQLException{
        final     ObservableList<PatientClasse> data        =  FXCollections.observableArrayList();
        Consultation    bddConsTab    = new Consultation();
        
         ResultSet      résultat      = bddConsTab.ExtElement("Select Patient.*,DossierMedicale.DateHospitalisation from Patient,dossiermedicale where Patient.NumDossier = dossierMedicale.NumDossier Order By Nom");
         
         while(résultat.next()){
                
         PatientClasse Patient  = new PatientClasse(résultat.getString(2), résultat.getString(3) ,résultat.getString(14),
                résultat.getString(5),résultat.getString(6), résultat.getString(7) ,résultat.getString(8),
                résultat.getString(9),résultat.getString(10),résultat.getString(11),résultat.getString(12)); 
         Patient.setNumDossier(résultat.getString(13));
         Patient.setDateHospital(résultat.getString(15));
         ArrayList<String>  list       = new ArrayList();
         for(int i = 0; i <tables.length;i++){
         Consultation   bddConsCount  = new Consultation(); 
         ResultSet      résultat1      = bddConsCount.ExtElement("select count(*) from "+tables[i]+" where NumDossier ='"+résultat.getString(13)+"'");
         while(résultat1.next()){
         list.add(résultat1.getString(1));
         }
         bddConsCount.CloseConnex();
         }
         /**/
         Consultation    bddConsCEvol    = new Consultation();
         ResultSet res = bddConsCEvol.ExtElement("select count(*) from Evolution where NumDossier ='"+résultat.getString(13)+"'");
         while(res.next()){
          
        
             if(res.getInt(1) > 4){
             final  Consultation    bddConsEvol    = new Consultation(); 
             ResultSet res1 = bddConsEvol.ExtElement("select count(EtatEvol) from (select * from Evolution where NumDossier ='"+résultat.getString(13)+"' limit "+(res.getInt(1)-4)+",4)as tab where EtatEvol ='Oui'");
             while(res1.next())Patient.setEtatEvolution(res1.getInt(1));
             bddConsEvol.CloseConnex();
             }else{
             final  Consultation    bddConsEvol    = new Consultation(); 
             ResultSet res1 = bddConsEvol.ExtElement("select count(EtatEvol) from Evolution where NumDossier ='"+résultat.getString(13)+"' and EtatEvol = 'Oui'");   
             while(res1.next())Patient.setEtatEvolution(res1.getInt(1));
             bddConsEvol.CloseConnex();
             }
         }bddConsCEvol.CloseConnex();
         //bddConsEvol.ExtElement("select count(EtatEvol) from ()");
         
         Patient.setAlcoolisation(list.get(0));      Patient.setChimieOembolisation(list.get(5)); 
         Patient.setBilanBiologique(list.get(3));    Patient.setChirurgie(list.get(6));           Patient.setEchographie(list.get(7));
         Patient.setBilanFOGD(list.get(2));          Patient.setEchographieDoppler(list.get(8));  Patient.setTraitemenAntiViral(list.get(13));
         Patient.setBilanImmnologique(list.get(4));  Patient.setIRM(list.get(9));                 Patient.setRadioFrequence(list.get(10));
         Patient.setTDM(list.get(11));               Patient.setAnapath(list.get(1));             Patient.setTherapiesCibles(list.get(12));
         
         data.add(Patient);
         }
          
         bddConsTab.CloseConnex();
          
          return data;
    }
    
    /******************************/
     public void setAgeomC(String Age) {
        AgeC.setText(Age);
    }

    public void setSexeC(String Sexe) {
        SexeC.setText(Sexe);
    }

    public void setOrigineC(String Origine) {
        OrigineC.setText(Origine);
    }

    public void setProfessionC(String Profession) {
        ProfessionC.setText(Profession);
    }

    public void setAdresseC(String Adresse) {
        AdresseC.setText(Adresse);
    }

    public void setTel1C(String Tel ) {
        Tel1C.setText(Tel);
    }

    public void setTel2C(String Tel2) {
        Tel2C.setText(Tel2);
    }

    public void setSituationFamCC(String Situation) {
        SituationFamC.setText(Situation);
    }

    public void setConditionEcC(String Condition) {
        ConditionEcC.setText(Condition);
    }
    
    public void setNumDossier(String NumDossier){
        this.NumDossierC.setText(NumDossier);
    }
    public void setDateHospital(String DateH){
        this.DateHospital.setText(DateH);
    }
    ////////////////////////////////////////////////////////////

    public void setBilanBiologique(String BilanBiologique) {
        this.BilanBiologique.setText(BilanBiologique);
    }

    public void setBilanImmnologique(String BilanImmnologique) {
        this.BilanImmnologique.setText(BilanImmnologique);
    }

    public void setBilanFOGD(String BilanFOGD) {
        this.BilanFOGD.setText(BilanFOGD);
    }

    public void setEchographie(String Echographie) {
        this.Echographie.setText(Echographie);
    }

    public void setEchographieDoppler(String EchographieDoppler) {
        this.EchographieDoppler.setText(EchographieDoppler);
    }

    public void setTDM(String TDM) {
        this.TDM.setText(TDM);
    }

    public void setIRM(String IRM) {
        this.IRM.setText(IRM);
    }

    public void setAnapath(String Anapath) {
        this.Anapath.setText(Anapath);
    }

    public void setChirurgie(String Chirurgie) {
        this.Chirurgie.setText(Chirurgie);
    }

    public void setAlcoolisation(String Alcoolisation) {
        this.Alcoolisation.setText(Alcoolisation);
    }

    public void setRadioFrequence(String RadioFrequence) {
        this.RadioFrequence.setText(RadioFrequence);
    }

    public void setChimieOembolisation(String ChimieOembolisation) {
        this.ChimieOembolisation.setText(ChimieOembolisation);
    }

    public void setTherapiesCibles(String TherapiesCibles) {
        this.TherapiesCibles.setText(TherapiesCibles);
    }

    public void setTraitemenAntiViral(String TraitemenAntiViral) {
        this.TraitemenAntiViral.setText(TraitemenAntiViral);
    }

    public void setEtatEvolution(String EtatEvolution) {
        this.EtatEvolution.setId(EtatEvolution);
    }
    
    
    
    
}
