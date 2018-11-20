
package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import service.medicament.Patient.PatientClasse;
import service.medicament.SGBD.Consultation;

import service.medicament.SGBD.MiseAjour;

public final class IdentiteSpace extends Parent{
    
    final         TextField         nameText          ;final Label  Indname  = new Label();
    final         TextField         prenomText        ;final Label  Indpreno = new Label();
    final         TextField         ageText           ;final Label  Indage   = new Label();
    
    final         RadioButton       sexeFrb           =      new RadioButton();    
    final         RadioButton       sexeMrb           =      new RadioButton();
    final ToggleGroup Tgroup1 = new ToggleGroup();
    final         ComboBox          origineCombo      =      new ComboBox();      
    
    final         TextField         professionText    ; final Label  IndProf = new Label();
    final         TextField         adresseText       ; final Label  Indadr  = new Label();
    final         TextField         telephone1Text    ; final Label  IndTel1 = new Label();
    final         TextField         telephone2Text    ; final Label  IndTel2 = new Label();
    
    final         RadioButton       situationFamM     =      new RadioButton();
    final         RadioButton       situationFamC     =      new RadioButton();
    final ToggleGroup Tgroup2 = new ToggleGroup();
    
    final         ComboBox          conditionSE       =      new ComboBox();
    final         Separator         sep               =      new Separator();  
    
    /// les Champs de la Consultation ////
    final private        Label             NomC              =  new Label();
    final private        Label             PrenomC           =  new Label();
    final private        Label             AgeC              =  new Label();
    final private        Label             SexeC             =  new Label();
    final private        Label             OrigineC          =  new Label();
    final private        Label             ProfessionC       =  new Label();
    final private        Label             AdresseC          =  new Label();
    final private        Label             Tel1C             =  new Label();
    final private        Label             Tel2C             =  new Label();
    final private        Label             SituationFamC     =  new Label();
    final private        Label             ConditionEcC      =  new Label();
    //////////////////////////////////////
    
    ////////////////////////////////////////////
    /// partie Supression et modification///////
    
    final HBox         barOutil            = new HBox(2);
    final Button       ModifButton         = new Button();
    final ImageView    ModifImg            = new ImageView(new Image(getClass().getResourceAsStream("Images/15.jpg")));
    final Button       EnregButton         = new Button();  
    final ImageView    EnregfImg           = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png")));
    
    /// les Champs de la Modification////
    final TextField NomCMod                 ; 
    final TextField PrenomCMod              ; 
    final TextField AgeCMod                 ;  
    final TextField SexeCMod                ;
    final TextField OrigineCMod             ;  
    final TextField ProfessionCMod          ;  
    final TextField AdresseCMod             ;  
    final TextField Tel1CMod                ;  
    final TextField Tel2CMod                ;  
    final TextField SituatCMod              ;  
    final TextField CondSCMod               ;
    
    
    final Label        IndModifS       = new Label();
    final ImageView    IndImgS         = new ImageView(new Image(getClass().getResourceAsStream("Images/31.jpg")));
    final ImageView    IndImgF         = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg")));
    ////////////////////////////////////////////
    public IdentiteSpace(int TypeCCP,String NumDossier) throws SQLException{
        
    ///////////////////////////Prtie Modification/////////////////////////////////////////////////////
    ModifImg.setFitHeight(50);   ModifImg.setPreserveRatio(true);
    ModifButton.setGraphic(ModifImg);
    EnregfImg.setFitHeight(50);  EnregfImg.setPreserveRatio(true); EnregButton.setDisable(true);
    EnregButton.setGraphic(EnregfImg);
    barOutil.getChildren().addAll(ModifButton,EnregButton);
    barOutil.getStyleClass().add("barOutil");
    
    IndImgS.setFitHeight(50); IndImgS.setPreserveRatio(true);
    IndImgF.setFitHeight(50); IndImgF.setPreserveRatio(true);
    
    ////////////////////////////////////////////////////////////////////////////////
        
    final         GridPane          grid              =      new GridPane();   
    
    grid.setVgap(10);
    grid.setHgap(10);
    
    
    nameText    = this.champSaisier(Indname);
    nameText.setPromptText("Nom Patient ");                   grid.add(nameText,0, 0);   grid.add(Indname,1,0);   Indname.getStyleClass().add("erreurchamp");
    prenomText  = this.champSaisier(Indpreno);
    prenomText.setPromptText("Prenom Patient");               grid.add(prenomText,0, 1); grid.add(Indpreno,1,1);  Indpreno.getStyleClass().add("erreurchamp");
    ageText = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && ageText.getText().length() < 2){
                    super.replaceText(start, end, text);
                    Indage.setText(""); 
                    
                }else 
                    if(ageText.getText().length() < 2){
                Indage.setText(" Entrer une valeur numerique ");
                }else Indage.setText("");
            }
           
           @Override
         
           public void replaceSelection(String text) {
               
               if (!text.matches("[a-z, A-Z]")) {
                    super.replaceSelection(text);
             }

            }
          
        };
    ageText.setPromptText("Age Patient");                     grid.add(ageText,0, 2);    grid.add(Indage,1,2);    Indage.getStyleClass().add("erreurchamp");
    
   
    sexeFrb.setToggleGroup(Tgroup1);
    sexeFrb.setText("Féminin");                                
    sexeFrb.setUserData("Féminin");                                 grid.add(sexeFrb,0, 3);
    sexeMrb.setToggleGroup(Tgroup1);  
    sexeMrb.setText("Masculin");
    sexeMrb.setUserData("Masculin");                                    grid.add(sexeMrb, 1, 3);
    //nameText, prenomText,ageText,Tgroup1
    sexeMrb.setSelected(true);
    
    origineCombo.getItems().addAll("Adrar","Chlef","Tamanrasset","Illizi","Ouargla","Béchar","Tindouf","Ghardaïa",
                                   "Bayadh","Djelfa","Oued","Naâma","Laghouat","Biskra","Tiaret","Msila","Tébessa",
                                   "Batna","Khenchela","Sidi Bel Abbès","Tlemcen","Médéa","Oum El Bouaghi","Saïda",
                                   "Sétif","Mascara","Aïn Defla","Relizane","Souk Ahras"," Bouira","Bordj Bou Arreridj",
                                   "Guelma","Skikda","Tizi Ouzou"," Mila","El Tarf","Béjaïa","Tissemsilt","Jijel",
                                   "Aïn Témouchent","Constantine","Mostaganem","Tipaza","Oran","Boumerdès","Blida","Annaba",
                                   "Alger");
    
    origineCombo.setValue("Alger");
    Text     text1          =  new Text("Origine : ");
    grid.add(text1,0, 4);      grid.add(origineCombo,1,4);
    
    //sep.setOrientation(Orientation.VERTICAL
    //grid.add(sep, 2, 0,1,4);
    professionText   = this.champSaisier(IndProf);
    professionText.setPromptText("Profession ");             grid.add(professionText,0,5);    grid.add(IndProf,1,5);IndProf.getStyleClass().add("erreurchamp");
    adresseText   =  this.champSaisierAdr(Indadr);
    adresseText.setPromptText("Adresse ");                   grid.add(adresseText, 5, 0);     grid.add(Indadr,6,0); Indadr.getStyleClass().add("erreurchamp");
    
    telephone1Text   = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && telephone1Text.getText().length() < 10){
                    super.replaceText(start, end, text);
                    IndTel1.setText(""); 
                    
                }else 
                    if(telephone1Text.getText().length() < 10){
                IndTel1.setText(" Entrer une valeur numerique ");
                }else IndTel1.setText("");
            }
           
           @Override
         
           public void replaceSelection(String text) {
               
               if (!text.matches("[a-z, A-Z]")) {
                    super.replaceSelection(text);
             }

            }
          
        };
    telephone1Text.setPromptText("Numéro Telephone 1");      grid.add(telephone1Text,5,1);    grid.add(IndTel1,6,1);IndTel1.getStyleClass().add("erreurchamp");
    telephone2Text  = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && telephone2Text.getText().length() < 10){
                    super.replaceText(start, end, text);
                    IndTel2.setText(""); 
                    
                }else 
                    if(telephone2Text.getText().length() < 10){
                IndTel2.setText(" Entrer une valeur numerique ");
                }else IndTel2.setText("");
            }
           
           @Override
         
           public void replaceSelection(String text) {
               
               if (!text.matches("[a-z, A-Z]")) {
                    super.replaceSelection(text);
             }

            }
          
        };
    telephone2Text.setPromptText("Numéro Telephone 2");      grid.add(telephone2Text,5,2);    grid.add(IndTel2,6,2);IndTel2.getStyleClass().add("erreurchamp");
    
   
    
    situationFamM.setToggleGroup(Tgroup2);
    situationFamM.setText("Marie");               
    situationFamM.setUserData("Marie");                          grid.add(situationFamM,5, 3);
     
     
    situationFamC.setToggleGroup(Tgroup2);
    situationFamC.setText("Célibataire ");
    situationFamC.setUserData("Célibataire");
    situationFamM.setSelected(true);                         grid.add(situationFamC,6, 3);
    
    conditionSE.getItems().addAll("bonne ","moyenne","mauvaise");
    
    
    Text         text2           =   new Text("Condition socio_economique :");
    grid.add(text2,5,4 );                                   grid.add(conditionSE,6, 4);
    
    conditionSE.setValue("bonne");
    //////////////////////////////////////////////////////////////////////////////////////////
    //**************** Consultation /*******************************************//////////////
    final         GridPane          gridC              =      new GridPane();   
    gridC.setVgap(10);    gridC.setHgap(10);
    final Label Laffichage           = new Label("L'identité   ");                gridC.add(Laffichage,0,0);  
    Laffichage.getStyleClass().add("setStyleCirconsanceDic");
    final Label NomCons                 = new Label("Nom                   : ");  gridC.add(NomCons,0,1,2,1);          gridC.add(NomC,5,1);
    final Label PrenomCons              = new Label("Prenom                : ");  gridC.add(PrenomCons,0,2,2,1);       gridC.add(PrenomC,5,2);
    final Label AgeCons                 = new Label("Age                   : ");  gridC.add(AgeCons,0,3,2,1);          gridC.add(AgeC,5,3);
    final Label SexeCons                = new Label("Sexe                  : ");  gridC.add(SexeCons,0,4,2,1);         gridC.add(SexeC,5,4);
    final Label OrigineCons             = new Label("Origine               : ");  gridC.add(OrigineCons,0,5,2,1);      gridC.add(OrigineC,5,5);
    final Label ProfessionCons          = new Label("Profession            : ");  gridC.add(ProfessionCons,0,6,2,1);   gridC.add(ProfessionC,5,6);
    final Label AdresseCons             = new Label("Adresse               : ");  gridC.add(AdresseCons,0,7,2,1);      gridC.add(AdresseC,5,7);
    final Label Tel1Cons                = new Label("Telephone 1           : ");  gridC.add(Tel1Cons,0,8,2,1);         gridC.add(Tel1C,5,8);
    final Label Tel2Cons                = new Label("Telephone 2           : ");  gridC.add(Tel2Cons,0,9,2,1);         gridC.add(Tel2C,5,9);
    final Label SituatCons              = new Label("Situation Familiale   : ");  gridC.add(SituatCons,0,10,2,1);      gridC.add(SituationFamC,5,10);
    final Label CondSCons               = new Label("Conditions SocioEco   : ");  gridC.add(CondSCons,0,11,2,1);       gridC.add(ConditionEcC,5,11);
    //////////////////////////////////////////////////////////////////////////////////////////
    
    /////////////////////Modification    ////////////////////////////////////////////////////////////////////////
    NomCMod                 = champSaisier(new Label());    
    PrenomCMod              = champSaisier(new Label()); 
    AgeCMod                 = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && AgeCMod.getText().length() < 2){
                    super.replaceText(start, end, text);
                    Indage.setText(""); 
                    
                }else 
                    if(ageText.getText().length() < 2){
                Indage.setText(" Entrer une valeur numerique ");
                }else Indage.setText("");
            }
        
        };  
    SexeCMod                = champSaisier(new Label());
    OrigineCMod             = champSaisier(new Label());  
    ProfessionCMod          = champSaisier(new Label());  
    AdresseCMod             = champSaisierAdr(Indadr);  
    Tel1CMod                = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && Tel1CMod.getText().length() < 10){
                    super.replaceText(start, end, text);
                    IndTel2.setText(""); 
                    
                }else 
                    if(telephone2Text.getText().length() < 10){
                IndTel2.setText(" Entrer une valeur numerique ");
                }else IndTel2.setText("");
            }
           
        }; 
    Tel2CMod             =  new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9]") && Tel2CMod.getText().length() < 10){
                    super.replaceText(start, end, text);
                    IndTel2.setText(""); 
                    
                }else 
                    if(telephone2Text.getText().length() < 10){
                IndTel2.setText(" Entrer une valeur numerique ");
                }else IndTel2.setText("");
            }
           
        } ;  
    SituatCMod              = champSaisier(new Label());  
    CondSCMod               = champSaisier(new Label());
    ModifButton.setOnAction((ActionEvent)->{
      
      EnregButton.setDisable(false);
      IndModifS.setGraphic(null);
      gridC.getChildren().removeAll(NomC,PrenomC,AgeC,SexeC,OrigineC,ProfessionC,AdresseC,Tel1C,Tel2C,SituationFamC,ConditionEcC);
      gridC.add(NomCMod,5,1);
      gridC.add(PrenomCMod,5,2);
      gridC.add(AgeCMod,5,3);
      gridC.add(SexeCMod,5,4);
      gridC.add(OrigineCMod,5,5);
      gridC.add(ProfessionCMod,5,6);
      gridC.add(AdresseCMod,5,7);
      gridC.add(Tel1CMod,5,8);
      gridC.add(Tel2CMod,5,9);
      gridC.add(SituatCMod,5,10);
      gridC.add(CondSCMod,5,11); //
      
      AffectChampModif();
      ModifButton.setDisable(true);
    });
    
    EnregButton.setOnAction((ActionEvent)->{
      if(VerifChampModif() == 1){
          IndModifS.setGraphic(IndImgS);
          try {
              this.UpdateFunction(NumDossier);
              ModifButton.setDisable(false);
              EnregButton.setDisable(true);
              gridC.getChildren().removeAll(NomCMod,PrenomCMod,AgeCMod,SexeCMod,OrigineCMod,ProfessionCMod,AdresseCMod,Tel1CMod,Tel2CMod,SituatCMod,CondSCMod);
              this.ConsultationE(NumDossier);
              gridC.getChildren().addAll(NomC,PrenomC,AgeC,SexeC,OrigineC,ProfessionC,AdresseC,Tel1C,Tel2C,SituationFamC,ConditionEcC);
          } catch (SQLException ex) {
              Logger.getLogger(IdentiteSpace.class.getName()).log(Level.SEVERE, null, ex);
          }
      } else {
          IndModifS.setGraphic(IndImgF);
      };    
    });
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////******** Partie Consultation /*********************************************/////
    if(TypeCCP == 0){
    getChildren().add(grid);
    }else {///////////////////////////////////////////////////////////////////////////////////
    
        this.ConsultationE(NumDossier);
        gridC.setPadding(new Insets(30,10,10,30));
        final StackPane   pane     =  new StackPane();
        pane.setMinWidth(900);
        pane.getStyleClass().add("setStylingRootCons");
        barOutil.setTranslateX(100);
        IndModifS.setTranslateX(100);
       /* barOutil.setTranslateY(300);
        barOutil.setPrefHeight(30);*/
        gridC.add(barOutil, 16,9,2,2);
        gridC.add(IndModifS,16,11,1,2);
        pane.getChildren().addAll(gridC);
        getChildren().addAll(pane);
        
   
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    }
    //nameText, prenomText,ageText,Tgroup1,origineCombo,professionText,adresseText,telephone1Text,telephone2Text
     //Tgroup2 ,conditionSE
    public String getNameText() {   
        return nameText.getText();   //
    }

    public String getPrenomText() {
        return prenomText.getText();
    }

    public String getAgeText() {
        return ageText.getText();
    }

    public String getSexe() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }


    public String getOrigineCombo() {
        return origineCombo.getValue().toString();
    }

    public String getProfessionText() {
        return professionText.getText();
    }

    public String getAdresseText() {
        return adresseText.getText();
    } 
    public String getTelephone1Text() { //
        return telephone1Text.getText();//getConditionSE()
    }

    public String getTelephone2Text() {
        return telephone2Text.getText();
    }

    public String getSituationFam() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

   

    public String getConditionSE() {
        return conditionSE.getValue().toString();
    }
        public void setNameText() {
        nameText.setText("");
    }

    public void setPrenomText() {
        prenomText.setText("");
    }

    public void setAgeText() {
      ageText.setText("");
    }

    


   

    public void setProfessionText() {
        professionText.setText("");
    }

    public void setAdresseText() {
        adresseText.setText("");
    }

    public void setTelephone1Text() {
        telephone1Text.setText("");
    }

    public void setTelephone2Text() {
       telephone2Text.setText("");
    }

    public boolean setIndname() {
        if(nameText.getText().trim().length() < 3){
        Indname.setText("Nom Patient ...!!");
        return true;
        }
        else {Indname.setText("");
        return false;}
    }
   

    public boolean setIndpreno() {
        if(prenomText.getText().trim().length() < 3){
        Indpreno.setText("Prenom Patient ...!!");
        return true;
        }
        else {Indpreno.setText("");
        return false;}
    }

    public boolean setIndage() {
        if(ageText.getText().trim().equals("")){
        Indage.setText("Age Patient...!!");
        return true; 
        }
        else {Indage.setText("");
        return false;}
    }

    public boolean setIndProf() {
        if(professionText.getText().trim().length() < 3){
        IndProf.setText("Profession Patient...!!");
        return true;
        }
        else {IndProf.setText("");
        return false;}
    }

    public boolean setIndadr() {
        if(adresseText.getText().trim().length() < 2){
        Indadr.setText("Adresse Patient ...!!");
        return true ; 
        }
        else {Indadr.setText("");
        return false;
        }
    }

    public boolean setIndTel1() {
        if(telephone1Text.getText().trim().length() < 10){
        IndTel1.setText("Telephone Patient...!!");
        return true;
        }
        else {IndTel1.setText("");
        return false;
        }
    }

    public boolean setIndTel2() {
        if(telephone2Text.getText().trim().length() < 10){
        IndTel2.setText("Telephone Patient...!!");
        return true;
        }
        else {IndTel2.setText("");
        return false;
        }
    }
    
    //////////.... les Fonctions de La consultation..../////////
    
    

    public RadioButton getSituationFamC() {
        return situationFamC;
    }

    public void setNomC(String Nom) {
        NomC.setText(Nom);
    }

    public void setPrenomC(String Prenom) {
        PrenomC.setText(Prenom);
    }

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
    ////////////////////////////////////////////////////////////
public boolean  VerifChamp(){
    if(this.setIndname() || this.setIndpreno() || this.setIndage()  || 
       this.setIndProf() || this.setIndTel1()  || this.setIndTel2() || this.setIndadr()){
    this.setIndname();this.setIndpreno();this.setIndage();
    this.setIndProf();this.setIndTel1();this.setIndTel2(); this.setIndadr();
    return false;
    }else {
       return true; 
    }
}

public void Initialisation(){
this.setPrenomText();   this.setTelephone1Text(); this.setTelephone2Text(); this.setAgeText();
this.setNameText();  this.setAdresseText(); this.setProfessionText(); 
}
public int InsertionSGBD(String NumDossier ,LocalDate dateHospitalisation) throws SQLException{
    
    MiseAjour   bddInsert          =  new MiseAjour();   
    
    int l =bddInsert.AddElement("insert into dossiermedicale values ('"+NumDossier+"','"+dateHospitalisation+"');");
    if(l != 0){
    int v =bddInsert.AddElement("insert into patient values (0,'"+getNameText()+"','"+getPrenomText()+"','"+""+"','"+
                          getSexe()+"','"+getOrigineCombo()+"','"+getProfessionText()+"','"+getAdresseText()+"','"+
                          getTelephone1Text()+"','"+getTelephone2Text()+"','"+
                          getSituationFam()+"','"+getConditionSE()+"','"+NumDossier+"','"+getAgeText()+"');");
    
    }return l ;
}
    @SuppressWarnings("null")
    public void ConsultationE(String NumDossier ) throws SQLException{
    PatientClasse  Patient = null ;
    Consultation bddCons     = new Consultation();
    ResultSet résultat   =  bddCons.ExtElement("select * from Patient where NumDossier = '"+NumDossier+"'");
                System.out.println("Ext ");
          while(résultat.next()){
                System.out.println("L'INT");
         Patient  = new PatientClasse(résultat.getString(2), résultat.getString(3) ,résultat.getString(14),
                résultat.getString(5),résultat.getString(6), résultat.getString(7) ,résultat.getString(8),
                résultat.getString(9),résultat.getString(10),résultat.getString(11),résultat.getString(12));   
         }
         
    this.setNomC(Patient.getNom());                 this.setConditionEcC(Patient.getCondSocioEco());
    this.setPrenomC(Patient.getPrenom());           this.setTel1C(Patient.getTel1());
    this.setAgeomC(Patient.getAge());               this.setTel2C(Patient.getTel2());
    this.setSexeC(Patient.getSexe());               this.setSituationFamCC(Patient.getSituationFamiliale());
    this.setAdresseC(Patient.getAdresse());         this.setOrigineC(Patient.getWilaya());
    this.setProfessionC(Patient.getProfession());

    bddCons.CloseConnex();
               }
public TextField champSaisier(Label l){
 TextField textF = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[a-z A-Z çéàùè^µ]")){
                    super.replaceText(start, end, text);
                    l.setText("");
                }else l.setText(" Entrer des lettres ");
              
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
public TextField champSaisierAdr(Label l){
 TextField textF = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[a-z A-Z0-9-çéàùè^µ]")){
                    super.replaceText(start, end, text);
                    l.setText("");
                    getStyleClass().remove("textFielderr");
                }else {
                    l.setText(" Entrer des lettres OU des Chiffres numérique ");
                    getStyleClass().add("textFielderr");
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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////// les Méthode de la Modification///////////////////////////////////////////////////////////////////////
    public String getNomCMod() {
        return NomCMod.getText();
    }

    public String getPrenomCMod() {
        return PrenomCMod.getText();
    }

    public String getAgeCMod() {
        return AgeCMod.getText();
    }

    public String getSexeCMod() {
        return SexeCMod.getText();
    }

    public String getOrigineCMod() {
        return OrigineCMod.getText();
    }

    public String getProfessionCMod() {
        return ProfessionCMod.getText();
    }

    public String getAdresseCMod() {
        return AdresseCMod.getText();
    }

    public String getTel1CMod() {
        return Tel1CMod.getText();
    }

    public String getTel2CMod() {
        return Tel2CMod.getText();
    }

    public String getSituatCMod() {
        return SituatCMod.getText();
    }

    public String getCondSCMod() {
        return CondSCMod.getText();
    }
    
    /*************************************/
    
    public void setNomCMod() {
         NomCMod.setText(NomC.getText());
    }

    public void setPrenomCMod() {
         PrenomCMod.setText(PrenomC.getText());
    }

    public void setAgeCMod() {
         AgeCMod.setText(AgeC.getText());
    }
    public void setSexeCMod() {
         SexeCMod.setText(SexeC.getText());
    }

    public void setOrigineCMod() {
        OrigineCMod.setText(OrigineC.getText());
    }
    public void setProfessionCMod() {
        ProfessionCMod.setText(ProfessionC.getText());
    }

    public void setAdresseCMod() {
       AdresseCMod.setText(AdresseC.getText());
    }

    public void setTel1CMod() {
       Tel1CMod.setText(Tel2C.getText());
    }

    public void setTel2CMod() {
       Tel2CMod.setText(Tel2C.getText());
    }

    public void setSituatCMod() {
	   SituatCMod.setText(SituationFamC.getText());
    }

    public void setCondSCMod() {
       CondSCMod.setText(ConditionEcC.getText());
    }

    /*function modif*/
    public void AffectChampModif(){
        this.setNomCMod();            this.setProfessionCMod();   this.setTel2CMod();
        this.setPrenomCMod();         this.setSexeCMod();         this.setOrigineCMod();
        this.setAgeCMod();            this.setCondSCMod();        this.setSituatCMod();
        this.setAdresseCMod();        this.setTel1CMod();
        
    }
    
    public int VerifChampModif(){
        int i = 1;
        if(this.getNomCMod().equals("")){NomCMod.getStyleClass().add("textFielderr"); i = 0;}             else NomCMod.getStyleClass().remove("textFielderr");
        if(this.getPrenomCMod().equals("")){PrenomCMod.getStyleClass().add("textFielderr");i = 0;}        else PrenomCMod.getStyleClass().remove("textFielderr");
        if(this.getSexeCMod().equals("")){SexeCMod.getStyleClass().add("textFielderr");i = 0;}            else SexeCMod.getStyleClass().remove("textFielderr");
        if(this.getAgeCMod().equals("")){AgeCMod.getStyleClass().add("textFielderr");i = 0;}              else AgeCMod.getStyleClass().remove("textFielderr");
        if(this.getAdresseCMod().equals("")){AdresseCMod.getStyleClass().add("textFielderr");i = 0;}      else AdresseCMod.getStyleClass().remove("textFielderr");
        if(this.getCondSCMod().equals("")){CondSCMod.getStyleClass().add("textFielderr");i = 0;}          else CondSCMod.getStyleClass().remove("textFielderr");
        if(this.getProfessionCMod().equals("")){ProfessionCMod.getStyleClass().add("textFielderr");i = 0;}else ProfessionCMod.getStyleClass().remove("textFielderr");
        if(this.getOrigineCMod().equals("")){OrigineCMod.getStyleClass().add("textFielderr");i = 0;}      else OrigineCMod.getStyleClass().remove("textFielderr");
        if(!(this.getTel1CMod().length() == 10)){Tel1CMod.getStyleClass().add("textFielderr");i = 0;}            else Tel1CMod.getStyleClass().remove("textFielderr");
        if(!(this.getTel2CMod().length() == 10)){Tel2CMod.getStyleClass().add("textFielderr");i = 0;}            else Tel2CMod.getStyleClass().remove("textFielderr");
        if(this.getSituatCMod().equals("")){SituatCMod.getStyleClass().add("textFielderr");i = 0;}        else SituatCMod.getStyleClass().remove("textFielderr");
    
    return i;
    }
    
    public void UpdateFunction(String NumDossier) throws SQLException{
        
        MiseAjour   bddUpdate      = new MiseAjour();
        bddUpdate.AddElement("Update patient set nom ='"+this.getNomCMod()+"',prenom = '"+this.getPrenomCMod()+"',Sexe = '"+this.getSexeCMod()+"',Wilaya = '"+this.getOrigineCMod()+"',Age = '"+this.getAgeCMod()+
                             "' ,Profession = '"+this.getProfessionCMod()+"',Adresse = '"+this.getAdresseCMod()+"',Telephone1='"+this.getTel1CMod()+"',Telephone2 ='"+this.getTel2CMod()+"',SituationFamiliale='"+this.getSituatCMod()+
                             "' ,CondSocioEco ='"+this.getCondSCMod()+"' where NumDossier ='"+NumDossier+"'");
        
        
    }
    
    /**/
    

    
  ///*************************************************************************************************************//
 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
