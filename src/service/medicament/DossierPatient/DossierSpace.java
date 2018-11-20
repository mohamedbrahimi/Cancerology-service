
package service.medicament.DossierPatient;

import java.awt.Dialog;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import service.medicament.*;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public class DossierSpace extends   Application {

      final DropShadow          shadow         =  new DropShadow();
      final       Button         Retour        =   new Button("Retour");
    
      final       String[]       namesButton   =   {"Accueil","Création       " ,"Consultation     " };
      final       String[]       IconFolder    =   {"Images/16.jpg","Images/14.jpg","Images/12.jpg"};         
      final       Button[]       fonctions     =   new Button[namesButton.length]; 
      final       ImageView[]    IconImg       =   new ImageView[namesButton.length]; 
      
      
      
      
      
      final       Group          root          =  new Group();
      final       VBox           rootPane      =  new VBox();
                  Stage          stage         = new Stage();
      
      final Button          Consulter     = new Button("Consulter");
      TextField       textCH        ;
      final HBox            hbox          = new HBox(1);
      ////
      final Label           NumDossierCons      = new Label("Numéro Dossier          :");
      final Label           DateHospital        = new Label("Date   Hospitalisation :");
      ////
      ////
      final Label           MessageErreur       = new Label();
      final ImageView       ImgErr              = new ImageView(new Image(getClass().getResourceAsStream("Images/17.jpg")));
      final  VBox   hbConsDossCurent     = new VBox(5);
      final ImageView       ImgAcc              = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
      ////
      
      final HBox         barOutil            = new HBox(2);
      final String[]     NameFunct           = {"Suppression \nde Dossier ","EVOLUTION ","Décès ","La suppression de dossier concerne \nimmédiatement tous les fichiers de patient "};
      final String[]     NameImg             = {"Images/4_1.jpg","Images/29.jpg","Images/10.png","Images/4.png"};
      final ImageView[]  ImageFunct          = new ImageView[NameFunct.length];
      final Tooltip[]    ToolFunct           = new Tooltip[NameFunct.length];
      final Button[]     buttonFunct         = new Button[NameFunct.length]; 
      
      
      final VBox         vbSupp              = new VBox(5);
      final Button       hyperAnnul          = new Button(" Annuler ");
      final Label        IndSuppDoss         = new Label();
      final ImageView    IndImgSuppD         = new ImageView(new Image(getClass().getResourceAsStream("Images/2.png")));
      
      final ImageView    IndImgDossDisc      = new ImageView(new Image(getClass().getResourceAsStream("Images/1_2.jpg")));
      ///
      /**/
      int EtatEnreg = 0;
      /**/
    @Override
    public void start(Stage primaryStage)  {
        ///////*****/////////////////////////////////////
        // Bar d'outils
        for(int i =0;i<NameFunct.length;i++){
            final ImageView img = ImageFunct[3-i]  =  new ImageView(new Image(getClass().getResourceAsStream(NameImg[3-i]))); 
            img.setFitHeight(40); img.setFitWidth(40);
            final Button    b   = buttonFunct[3-i] =  new Button("",img);
            final Tooltip   t   = ToolFunct[3-i]   =  new Tooltip(NameFunct[3-i]);  
            b.setTooltip(t);
            this.FuctionBar(b, 3-i);
            if(i != 0)
            barOutil.getChildren().add(b);
        }
            barOutil.setVisible(false);
            barOutil.setOpacity(0.7);
            barOutil.setTranslateX(1000);
            barOutil.setTranslateY(65);
           
            vbSupp.getStyleClass().add("setsttyleTraitementPpartie");
            IndSuppDoss.getStyleClass().add("setsttyleTraitementPpartie");
            vbSupp.setVisible(false);
            vbSupp.setTranslateX(550);
            vbSupp.setTranslateY(200);
            vbSupp.setPadding(new Insets(50,50,50,50));
            vbSupp.getChildren().addAll(IndSuppDoss ,hyperAnnul,this.buttonFunct[3]);
            this.buttonFunct[3].setTranslateX(300);  hyperAnnul.setTranslateY(50);
            IndImgSuppD.setFitHeight(50);IndImgSuppD.setPreserveRatio(true);
            IndImgDossDisc.setFitHeight(50); IndImgDossDisc.setPreserveRatio(true);
            /****/
            hyperAnnul.setOnAction((ActionEvent)->{
                vbSupp.setVisible(false);
                buttonFunct[3].setVisible(false);
            });
            /****/
        /////////////////////////////////////////////////
        hbConsDossCurent.setPadding(new Insets(10,15,10,15));
        hbConsDossCurent.getChildren().addAll(NumDossierCons,DateHospital);hbConsDossCurent.setVisible(false);
        hbConsDossCurent.setPrefSize(350,70); hbConsDossCurent.setTranslateX(10); hbConsDossCurent.setTranslateY(40);
        hbConsDossCurent.setOpacity(0.8);
        hbConsDossCurent.getStyleClass().add("Style2");
        /////////////////////////////////
        MessageErreur.setTranslateX(930);    ImgErr.setFitHeight(50);ImgErr.setPreserveRatio(true);
        MessageErreur.setTranslateY(5);      ImgAcc.setFitHeight(50);ImgAcc.setPreserveRatio(true);
        MessageErreur.setOpacity(0.7);
        /////////////////////////////////////////////////
        
        shadow.setOffsetX(1);
        shadow.setOffsetY(0.5);
        shadow.setColor(Color.AQUA);

       
       HBox            hb      =   new   HBox();
       hb.setPadding(new Insets(0,10,10,0));
       hb.setSpacing(0);
    
       for(int i = 0 ; i < namesButton.length ; i++){
           Button     b        =  fonctions[i]  =  new Button(namesButton[i]);
           ImageView  icon     =  IconImg[i]    =  new ImageView(new Image(getClass().getResourceAsStream(IconFolder[i])));  
           styleButton(b, icon);
           fonctionButton(b, i);
          
           hb.getChildren().add(b);
           
           
       }
        
        Consulter.getStyleClass().add("styleButton");
        textCH = this.champSaisier();
        textCH.setPromptText(" Cherche Ex : 111/12 "); textCH.setPrefWidth(250);
       Consulter.setOnMouseEntered(new EventHandler<MouseEvent>(){
           public void handle(MouseEvent event) {
           Consulter.setEffect(shadow);
           }
       });
       Consulter.setOnMouseExited(new EventHandler<MouseEvent>(){
           public void handle(MouseEvent event) {
          Consulter.setEffect(null);
               }
         });
       Consulter.setOnAction((ActionEvent)->{
            try {
                System.out.println(textCH.getText());
                int i = this.ConsultationDossier(textCH.getText());
                if(i == 1 ){
                hbConsDossCurent.setVisible(true);
                ConsultationSpace CS    = new ConsultationSpace(textCH.getText());
                rootPane.getChildren().clear();
                vbSupp.setVisible(false);
                this.buttonFunct[3].setVisible(false);
                barOutil.setVisible(true);
                rootPane.getChildren().add(CS);
                
                AddConsult(textCH.getText());
                }else {
                    rootPane.getChildren().clear();
                    this.setDateHospital("!!!!");this.setNumDossierCons("!!!!");
                    vbSupp.setVisible(false);
                    rootPane.getChildren().clear();
                    vbSupp.setVisible(false);
                    barOutil.setVisible(false);
                }
            } catch (SQLException ex) {
                this.setDateHospital("!!!!");this.setNumDossierCons("!!!!");
                rootPane.getChildren().clear();
                Logger.getLogger(DossierSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
         
       });
       
       
        
       hbox.setTranslateX(530); hbox.setTranslateY(2);
       hbox.getChildren().addAll(textCH,Consulter);hbox.setAlignment(Pos.CENTER);
       hbox.setVisible(false);
     
       
        hb.setTranslateX(0);
        hb.setTranslateY(0);
        
        
        Scene   scene       =  new Scene(root, 1300 , 600 , Color.WHITESMOKE);
        StyleImg        styleImge   =  new StyleImg();
        
        root.getChildren().add(styleImge);
        rootPane.setTranslateY(20);
        root.getChildren().add(rootPane);
        root.getChildren().add(hb);
        root.getChildren().add(hbox);root.getChildren().addAll(hbConsDossCurent,MessageErreur,barOutil,vbSupp);
        scene.getStylesheets().add(getClass().getResource("Styling.css").toExternalForm());
        primaryStage.setScene(scene);
        stage = primaryStage;
        
        stage.show();
    }
    
    public void styleButton(Button b,ImageView icon){
         b.setMaxWidth(215);                               icon.setFitHeight(20);
         b.setMinWidth(100);
         b.setPrefHeight(20);                               icon.setPreserveRatio(true);
         b.getStyleClass().add("styleButton");              icon.setOpacity(0.1);
         
        //
          b.setGraphic(icon);
           
           b.setOnMouseEntered(new EventHandler<MouseEvent>(){

               @Override
               public void handle(MouseEvent event) {

                   b.setScaleX(1.05);
                   b.setScaleY(1.09);
                   b.setEffect(shadow);
                   icon.setOpacity(0.71);
               }
               
           });
           b.setOnMouseExited(new EventHandler<MouseEvent>(){

               @Override
               public void handle(MouseEvent event) {
                   
                b.setScaleX(1);
                b.setScaleY(1);
                b.setEffect(null);
                icon.setOpacity(0.1);
               }
               
           });
        //
         
         
         
        
        
    }
    public void  generiqueButton(Button b ){
        b.setDisable(true);
        for(Button n : fonctions){
                   if(b.getText() != n.getText()){
                       n.setEffect(null);
                       n.setScaleX(1);
                       n.setScaleY(1);
                       n.getGraphic().setOpacity(0.1);
                       n.setDisable(false);
                       
                        
                   }
           
               }
        
    }
    
    public void  fonctionButton(Button b , int i){
         
               b.setOnAction((ActionEvent)-> {
              if(i == 1) {
                  FichePatientSpace    cds = null;
                  try {
                      cds = new  FichePatientSpace();
                      vbSupp.setVisible(false);
                    barOutil.setVisible(false);
                  } catch (SQLException ex) {
                      Logger.getLogger(DossierSpace.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  rootPane.getChildren().clear();  MessageErreur.setGraphic(null); hbConsDossCurent.setVisible(false);
                  rootPane.getChildren().add(cds); MessageErreur.setText("");
                  hbox.setVisible(false);
                  generiqueButton(b);
              }
              if(i==0){
             
             GroupDesFonctions      gdf       =  new GroupDesFonctions(1);
                  try {
                      gdf.start(stage);
                      vbSupp.setVisible(false);
                    barOutil.setVisible(false);
                  } catch (SQLException ex) {
                      Logger.getLogger(DossierSpace.class.getName()).log(Level.SEVERE, null, ex);
                  }
MessageErreur.setText(""); hbConsDossCurent.setVisible(false);
             generiqueButton(b);    MessageErreur.setGraphic(null);
        }
             if(i == 2){
              
              vbSupp.setVisible(false);
              barOutil.setVisible(false);
              rootPane.getChildren().clear();
              hbox.setVisible(true); MessageErreur.setText(""); hbConsDossCurent.setVisible(false);
              generiqueButton(b);    MessageErreur.setGraphic(null);
              
             } 
                 } );
    
}

    public void setNumDossierCons(String NumDossierConsD) {
        NumDossierCons.setText("Numéro Dossier         :"+NumDossierConsD);
    }

    public void setDateHospital(String DateH) {
        DateHospital.setText("Date   Hospitalisation :"+DateH);
    }
    public int ConsultationDossier(String NumDossier) throws SQLException{
        DossierClasse Dossier = null;
        Consultation bddCons    = new Consultation();
        System.out.println(NumDossier);
        ResultSet res = bddCons.ExtElement("select * from dossierMedicale where NumDossier = '"+NumDossier+"'");
        int i ;
        while(res.next()){
            Dossier = new DossierClasse(res.getString(1),res.getDate(2));
        }
        try{
        this.setNumDossierCons(Dossier.getNumDossier());
        this.setDateHospital(Dossier.getDateHospitalisation().toString());
        MessageErreur.getStyleClass().remove("erreurchamp");
        MessageErreur.setText("");
        MessageErreur.setGraphic(ImgAcc);
        i = 1;
        } catch(Exception ex){
        MessageErreur.setText(" Le Numéro du dossier que \n Vous avait tapé est \n incorrect ou le Dossier \n n'existe pas ");
        MessageErreur.getStyleClass().add("erreurchamp");
        MessageErreur.setGraphic(ImgErr);
        
        i = 0;
        }
        return i ;
        
    }
    public TextField champSaisier(){
 TextField textF = new TextField(){
            
            public void replaceText(int start , int end , String text){
                if(text.matches("[0-9/]")){
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
    
    public void FuctionBar(Button b ,int i){
        if(i == 0){
           
           b.setOnAction((ActionEvent)->{
           EtatEnreg = i;
           rootPane.getChildren().clear();
           buttonFunct[3].setVisible(true);
           vbSupp.setVisible(true); 
           this.hyperAnnul.setVisible(true);
           IndSuppDoss.setText("Appuyer sur l'icon d'enregistrement pour \nAssurer la suppression définitive du Dossier \n La suppression concerne Tous Les Fichiers du patient");
           IndSuppDoss.setGraphic(this.IndImgSuppD);
           });
           
           
        }
        if(i == 1){
            b.setOnAction((ActionEvent)->{
         
          vbSupp.setVisible(false);
          rootPane.getChildren().clear();
          EvolutionSpace   Evol;
                try {
                    Evol = new EvolutionSpace(textCH.getText(),0);
                    Evol.setTranslateX(500);
                    Evol.setTranslateY(150);
                    rootPane.getChildren().add(Evol);
                } catch (SQLException ex) {
                    Logger.getLogger(DossierSpace.class.getName()).log(Level.SEVERE, null, ex);
                }
         
          
            });
        }
        if(i == 2){
         EtatEnreg = i;
         b.setVisible(false);
        }
        if(i == 3){
           b.setVisible(false);
           b.setOnAction((ActionEvent)->{
               if(EtatEnreg == 0)
               try {
                   rootPane.getChildren().clear();
                   this.IndSuppDoss.setGraphic(IndImgDossDisc);
                   this.DropDossier(textCH.getText());
                   this.IndSuppDoss.setText("Le Dossier Numéro "+textCH.getText()+"\nde la "+this.DateHospital.getText()+" \nest retiré" );
                   this.hyperAnnul.setVisible(false);
                   IndSuppDoss.setStyle("");
                   barOutil.setVisible(false);
                   /***/
                   this.DateHospital.setText("******");
                   this.NumDossierCons.setText("******");
                   
                   b.setVisible(false);
                   /***/
               } catch (SQLException ex) {
                   Logger.getLogger(DossierSpace.class.getName()).log(Level.SEVERE, null, ex);
               }
           });
        }
    }
    
    public void DropDossier(String NumDossier) throws SQLException{
        
      String[]  tables    = {"alcoolisation","atcdsfamiliale","atcdspersonnel","autreexamens"
       ,"bilananapath","bilanandoschopique","bilanbiologique","bilanimmunologique","chimioembolisation"
       ,"chirurgie","circonstancedec","classification","echographie","echographiedoppler","irm"
       ,"patient","radiofrequence","tdm","therapiescibles","traitementantivirale","dossiermedicale"};
        MiseAjour bddDrop           = new MiseAjour();
        for(int i=0;i<tables.length;i++){
        bddDrop.AddElement("delete from "+tables[i]+" where NumDossier ='"+NumDossier+"'");
     
        }
        
    }
    
    public void AddConsult(String NumDossier) throws SQLException{
       
        MiseAjour  bddCons        =  new MiseAjour();
        bddCons.AddElement("insert into DossierTrait values ('"+NumDossier+"','"+this.ExtNomDossierP(NumDossier)+"','Consultation',Now())");
       
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

