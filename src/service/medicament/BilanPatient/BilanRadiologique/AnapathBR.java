
package service.medicament.BilanPatient.BilanRadiologique;

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
import javafx.scene.effect.Shadow;
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

public final class AnapathBR extends Parent{
    
        final DatePicker    DateB                   = new DatePicker();
        final ToggleGroup   Tgroup1                 = new ToggleGroup();
        final ToggleGroup   Tgroup2                 = new ToggleGroup();
        final ToggleGroup   Tgroup3                 = new ToggleGroup();
        final ToggleGroup   Tgroup4                 = new ToggleGroup();
        final ToggleGroup   Tgroup5                 = new ToggleGroup();
        final TextArea      resultat                ;
        final TextField     txt                     ; 
        final ToggleGroup   Tgroup6                 = new ToggleGroup();
        final TextField     AutreServicePR          ;
        final ToggleGroup   Tgroup7                 = new ToggleGroup();
        final ToggleGroup   Tgroup8                 = new ToggleGroup();
        final ToggleGroup   Tgroup10                = new ToggleGroup();
        final ToggleGroup   Tgroup9                 = new ToggleGroup();
        final ToggleGroup   Tgroup11                = new ToggleGroup(); 
        final ToggleGroup   Tgroup12                = new ToggleGroup();
        
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
       ////// La Partie Conseption  ///////////////////////////////////////////////////////////////////////////
           private final Label TDateAnapath       = new Label();
    private final Label TAnapath           = new Label();
    private final Label TPEchoGuide        = new Label();
    private final Label TPBiopsieTumeur    = new Label();
    private final Label TPBiopsieFAdjacent = new Label();
    private final Label TPieceOperatoire   = new Label();
    private final Label TResultas          = new Label();
    private final Label TLame              = new Label();
    private final Label TService           = new Label();
    private final Label TAutreService      = new Label();
    private final Label TImmunom           = new Label();
    private final Label TClassifGrade      = new Label();
    private final Label TDifference        = new Label();
    private final Label TEFoieNTumoral     = new Label();
    private final Label TActivite          = new Label();
    private final Label TFibrose           = new Label();
    
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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
     final String DateInsBilan;
     public AnapathBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
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
        final Label DateBilan                     = new Label("Date Bilan Anapath ");  
        final HBox  hbDate                        = new HBox(10);
        hbDate.getChildren().addAll(DateBilan,DateB); hbDate.setPadding(new Insets(30,20,30,20));
        
        final GridPane   grid                         = new GridPane();
        grid.setVgap(5); grid.setHgap(5);
        final Label      Anapath                      = new Label("Anapath");
        Anapath.getStyleClass().add("setStyleParteBilan");
              final RadioButton   OuiAnapath              = new RadioButton("Oui"); OuiAnapath.setUserData("Oui"); OuiAnapath.setSelected(true);
              final RadioButton   NonAnapath              = new RadioButton("Non"); NonAnapath.setUserData("Non");
              
              OuiAnapath.setToggleGroup(Tgroup1); NonAnapath.setToggleGroup(Tgroup1);
        grid.add(Anapath,0,0);   grid.add(OuiAnapath,1,0);  grid.add(NonAnapath, 2,0);
        
        final Label      PonctionEchoG                = new Label("Ponction écho guidée ");
              final RadioButton   OuiEG                   = new RadioButton("Oui");OuiEG.setUserData("Oui");
              final RadioButton   NonEG                   = new RadioButton("Non");NonEG.setUserData("Non");
                                                                                   NonEG.setSelected(true);
              
              OuiEG.setToggleGroup(Tgroup2);  NonEG.setToggleGroup(Tgroup2);
        grid.add(PonctionEchoG,0,1);  grid.add(OuiEG,1,1); grid.add(NonEG,2,1);
        
        final Label      PonctionBT                = new Label("Ponction biopsie  de la tumeur ");
              final RadioButton   OuiBT                   = new RadioButton("Oui");OuiBT.setUserData("Oui");
              final RadioButton   NonBT                   = new RadioButton("Non");NonBT.setUserData("Non");
                                                                                   NonBT.setSelected(true);
              OuiBT.setToggleGroup(Tgroup3);  NonBT.setToggleGroup(Tgroup3);
        grid.add(PonctionBT,0,2);  grid.add(OuiBT,1,2); grid.add(NonBT,2,2);
        
        final Label      PonctionBA                = new Label("Ponction biopsie  du foie adjacent ");
              final RadioButton   OuiBA                   = new RadioButton("Oui");OuiBA.setUserData("Oui");
              final RadioButton   NonBA                   = new RadioButton("Non");NonBA.setUserData("Non");
                                                                                   NonBA.setSelected(true);
              OuiBA.setToggleGroup(Tgroup4);  NonBA.setToggleGroup(Tgroup4);
        grid.add(PonctionBA,0,3);  grid.add(OuiBA,1,3); grid.add(NonBA,2,3);
        
        final Label      PonctionO                 = new Label("Pièce opératoire   ");
              final RadioButton   OuiO                    = new RadioButton("Oui");OuiO.setUserData("Oui");
              final RadioButton   NonO                    = new RadioButton("Non");NonO.setUserData("Non");
                                                                                   NonO.setSelected(true);
              OuiO.setToggleGroup(Tgroup5);  NonO.setToggleGroup(Tgroup5);
        grid.add(PonctionO,0,4);  grid.add(OuiO,1,4); grid.add(NonO,2,4);
        
        resultat = this.champSaisierA();txt = this.champSaisier();
        grid.add(resultat,0,5);resultat.setPromptText(" Résultats :"); resultat.setPrefSize(200,80);
        txt.setPromptText(" Lame°n");
       
        grid.add(txt,0,6);
        final Label      service                   = new Label("SERVICE");
              final RadioButton   Mustapha                 = new RadioButton("MUSTAPHA");Mustapha.setUserData("MUSTAPHA");
              final RadioButton   cpmc                     = new RadioButton("CPMC");    cpmc.setUserData("CPMC");
              final RadioButton   autreService             = new RadioButton("AUTRE");   autreService.setUserData("Autre");
                                                                                         cpmc.setSelected(true);
              AutreServicePR  =  this.champSaisier();AutreServicePR.setVisible(false);AutreServicePR.setPromptText("Autre Service");
              AutreServicePR.setPrefWidth(150);
              Tgroup6.selectedToggleProperty().addListener((ObservableValue)->{
                  if(Tgroup6.getSelectedToggle().getUserData().equals("Autre")){
                      AutreServicePR.setVisible(true);
                  }else AutreServicePR.setVisible(false); AutreServicePR.setText("");
              });
        
              Mustapha.setToggleGroup(Tgroup6); cpmc.setToggleGroup(Tgroup6); autreService.setToggleGroup(Tgroup6);
        grid.add(service,0,7); grid.add(Mustapha,1,7); grid.add(cpmc,2,7); grid.add(autreService,3,7);grid.add(AutreServicePR,4,7);
        
        final RadioButton immunomCk7               = new RadioButton("IMMUNOM CK 7 ");   immunomCk7.setUserData("IMMUNOM CK 7 ");
        final RadioButton immunoCk19               = new RadioButton("IMMUNO CK 19 ");   immunoCk19.setUserData("IMMUNO CK 19 ");
                                                                                         immunoCk19.setSelected(true);
              immunomCk7.setToggleGroup(Tgroup7);  immunoCk19.setToggleGroup(Tgroup7);
        grid.add(immunomCk7, 0,8); grid.add(immunoCk19, 1,8);
        
        final Label        titelTxt                = new Label("ETUDE HISTOLOGIQUE DE LA TUMEUR Classification d’Edmonson et Steiner ");
        titelTxt.setPrefWidth(600);
        grid.add(titelTxt,0,9,5,1);
        
        
        ;
        final Label grad         = new Label("Grade"); 
        
         
        final RadioButton G1       = new RadioButton("1");G1.setToggleGroup(Tgroup8);G1.setUserData("1");
        final RadioButton G2       = new RadioButton("2");G2.setToggleGroup(Tgroup8);G2.setUserData("2");
        final RadioButton G3       = new RadioButton("3");G3.setToggleGroup(Tgroup8);G3.setUserData("3");
        final RadioButton G4       = new RadioButton("4");G4.setToggleGroup(Tgroup8);G4.setUserData("4");G4.setSelected(true);
       
        grid.add(grad, 0,10); grid.add(G1,1, 10); grid.add(G2,2, 10); grid.add(G3,3, 10);  grid.add(G4,4, 10);
       
        final RadioButton diff     = new RadioButton("BIEN DIFFERENCIE"); diff.setUserData("BIEN DIFFERENCIE");
        final RadioButton diffM    = new RadioButton("MOY DIFFERENCIE");  diffM.setUserData("MOY DIFFERENCIE");
        final RadioButton diffIND  = new RadioButton("INDIFFERENCIE");    diffIND.setUserData("INDIFFERENCIE");
                                                                          diff.setSelected(true);
        
        diff.setToggleGroup(Tgroup10); diffIND.setToggleGroup(Tgroup10); diffM.setToggleGroup(Tgroup10);
        grid.add(diff,0,11); grid.add(diffM,1,11); grid.add(diffIND,2,11);
       
        
        final Label          EtudeHFNT                = new Label("ETUDE HISTOLOGIQUE DU FOIE NON TUMORAL");
              final RadioButton Sain                     = new RadioButton("SAIN");               Sain.setUserData("SAIN");
              final RadioButton HepatitCron              = new RadioButton("HEPATITE CHRONIQUE ");HepatitCron.setUserData("HEPATITE CHRONIQUE");
              final RadioButton Cirrhose                 = new RadioButton("CIRRHOSE");           Cirrhose.setUserData("CIRRHOSE");
                                                                                                  Sain.setSelected(true);
              Sain.setToggleGroup(Tgroup9); HepatitCron.setToggleGroup(Tgroup9); Cirrhose.setToggleGroup(Tgroup9);
        grid.add(EtudeHFNT,0,12,2,1); grid.add(Sain,2,12); grid.add(HepatitCron,3,12); grid.add(Cirrhose,4,12);
        
        
        final Label          ScoreMetavir             = new Label("SCORE METAVIR");
        grid.add(ScoreMetavir,0,13);
        final Label          Activite                 = new Label("Activité (nécrose et inflammation)");
        
        grid.add(Activite,1,14);
        final Label          Fibros                   = new Label("Fibrose");
        grid.add(Fibros,3,14);
         
        ///
        final Label Absent = new Label("Absent"); RadioButton A0 = new RadioButton("A0"); RadioButton F0 = new RadioButton("F0");
        grid.add(Absent, 0,15);                      grid.add(A0, 1,15);                grid.add(F0,3,15);
        final Label Minime = new Label("Minime"); RadioButton A1 = new RadioButton("A1"); RadioButton F1 = new RadioButton("F1");
        grid.add(Minime, 0,16);                      grid.add(A1, 1,16);                grid.add(F1,3,16);
        final Label Moderee = new Label("Modérée");RadioButton A2 = new RadioButton("A2"); RadioButton F2 = new RadioButton("F2");
        grid.add(Moderee, 0,17);                     grid.add(A2, 1,17);                grid.add(F2,3,17);
        final Label Severe = new Label("Sévère"); RadioButton A3 = new RadioButton("A3"); RadioButton F3 = new RadioButton("F3");
        grid.add(Severe, 0,18);                      grid.add(A3, 1,18);                grid.add(F3,3,18);
        final Label CirrhoseA = new Label("Cirrhose"); RadioButton A4 = new RadioButton("A4"); RadioButton F4 = new RadioButton("F4");
        A0.setUserData("A0");      F0.setUserData("F0");
        A1.setUserData("A1");      F1.setUserData("F1");
        A2.setUserData("A2");      F2.setUserData("F2");
        A3.setUserData("A3");      F3.setUserData("F3");
        A4.setUserData("A4");      F4.setUserData("F4");
        A1.setSelected(true);      F1.setSelected(true);
        
        A0.setToggleGroup(Tgroup11);A1.setToggleGroup(Tgroup11); A2.setToggleGroup(Tgroup11); A3.setToggleGroup(Tgroup11); A4.setToggleGroup(Tgroup11);
       
        F0.setToggleGroup(Tgroup12); F1.setToggleGroup(Tgroup12); F2.setToggleGroup(Tgroup12); F3.setToggleGroup(Tgroup12); F4.setToggleGroup(Tgroup12);
        grid.add(CirrhoseA, 0,19);                   grid.add(A4, 1,19);                grid.add(F4,3,19);
        
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
        Ajouter.setOnAction((ActionEvent)->{
            try {
                 int i = this.InsertionSGBD(NumDossier);
                   if(i == 1){
                    IndIns.setGraphic(ImgSucc); IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion du Bilan\n Radiologique(Anapath) au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Bilans \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des bilan de même type \n au niveau d'un dossier \n sur la même date ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(AnapathBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        grid.add(Ajouter, 3,23);
        grid.add(IndIns, 0,23,3,3);
        ///
        Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value,
        Toggle new_value)->{
            if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
               grid.getChildren().removeAll(PonctionEchoG,OuiEG,NonEG,PonctionBT,OuiBT,NonBT,PonctionBA,OuiBA,NonBA,
        PonctionO,OuiO,NonO,resultat,txt,service,Mustapha,cpmc,autreService,immunomCk7,
        immunoCk19,titelTxt,grad,G1,G2,G3,G4,diff,diffM,diffIND,EtudeHFNT,Sain,HepatitCron,Cirrhose,
        ScoreMetavir,Activite,Fibros,Absent,Minime,Moderee,Severe,CirrhoseA,A0,A1,A2,A3,
        A4,F0,F1,F2,F3,F4,Ajouter);
            }else {
               grid.getChildren().addAll(PonctionEchoG,OuiEG,NonEG,PonctionBT,OuiBT,NonBT,PonctionBA,OuiBA,NonBA,
        PonctionO,OuiO,NonO,resultat,txt,service,Mustapha,cpmc,autreService,immunomCk7,
        immunoCk19,titelTxt,grad,G1,G2,G3,G4,diff,diffM,diffIND,EtudeHFNT,Sain,HepatitCron,Cirrhose,
        ScoreMetavir,Activite,Fibros,Absent,Minime,Moderee,Severe,CirrhoseA,A0,A1,A2,A3,
        A4,F0,F1,F2,F3,F4,Ajouter);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////// La Partie Consultation     //////////////////////////////////////////////////////////////////////
        final GridPane   gridC                         = new GridPane();
        gridC.setVgap(5); gridC.setHgap(5);
     final Label ConsDateAnapath        = new Label("Date Anapath                              :");    
     final Label ConsAnapath            = new Label("Anapath                                   :");
     final Label ConsPEchoGuide         = new Label("Ponction écho guidée                      :");
     final Label ConsPBiopsieTumeur     = new Label("Ponction biopsie  de la tumeur            :");
     final Label ConsPBiopsieFAdjacent  = new Label("Ponction biopsie  du foie adjacent        :");
     final Label ConsPieceOperatoire    = new Label("Pièce opératoire                          :");
     final Label ConsResultas           = new Label("Résultats                                 :");
     final Label ConsLame               = new Label("Lame n°                                   :");
     final Label ConsService            = new Label("SERVICE                                   :");
     final Label ConsAutreService       = new Label("Autre Service                             :");
     final Label ConsImmunom            = new Label("IMMUNOM                                   :");
	    final Label EtudLabel              = new Label("ETUDE HISTOLOGIQUE DE LA TUMEUR \n Classification d’Edmonson et Steiner :");EtudLabel.getStyleClass().add("setStyleParteBilan");
     final Label ConsClassifGrade       = new Label("GRADE                                     :");
     final Label ConsDifference         = new Label("Difference                                :");
     final Label ConsEFoieNTumoral      = new Label("ETUDE HISTOLOGIQUE DU FOIE NON TUMORAL    :");
	    final Label ScorLabel              = new Label("SCORE METAVIR ");                        ScorLabel.getStyleClass().add("setStyleParteBilan");
     final Label ConsActivite           = new Label("Activite                                  :");
     final Label ConsFibrose            = new Label("Fibrose                                   :");
        
     final Label LabelAnapath       = new Label("Bilan Anapath    :");
     LabelAnapath.getStyleClass().add("setStyleCirconsanceDic");
  gridC.add(LabelAnapath,0,0);
  gridC.add(ConsDateAnapath , 0, 1);                   gridC.add(TDateAnapath,5,1);
  gridC.add(ConsAnapath , 0, 2);                       gridC.add(TAnapath,5,2);
  gridC.add(ConsPEchoGuide, 0,3);                      gridC.add(TPEchoGuide,5,3);
  gridC.add(ConsPBiopsieTumeur,0, 4);                  gridC.add(TPBiopsieTumeur,5,4);
  gridC.add(ConsPBiopsieFAdjacent,0,5);                gridC.add(TPBiopsieFAdjacent,5,5);
  gridC.add(ConsPieceOperatoire  ,0, 6);               gridC.add(TPieceOperatoire , 5,6);
  gridC.add(ConsResultas ,0, 7);                       gridC.add(TResultas , 5,7);
  gridC.add(ConsLame , 0,8);                           gridC.add(TLame , 5,8);
  gridC.add(ConsService , 0,9);                        gridC.add(TService ,  5,9);
  gridC.add(ConsAutreService ,0, 10);                  gridC.add(TAutreService , 5,10);  
  gridC.add(ConsImmunom , 0,11);                       gridC.add(TImmunom , 5,11 );
  gridC.add(EtudLabel,0,12);
  gridC.add(ConsClassifGrade ,0, 13);                  gridC.add(TClassifGrade ,5,13);  
  gridC.add(ConsDifference ,0, 14);                    gridC.add(TDifference , 5,14);
  gridC.add(ConsEFoieNTumoral ,0, 15);                 gridC.add(TEFoieNTumoral,  5,15); 
  gridC.add(ScorLabel,0,16);  
  gridC.add(ConsActivite , 0,17);                      gridC.add(TActivite ,  5,17);
  gridC.add(ConsFibrose , 0,18);                       gridC.add(TFibrose ,5,18);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
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
      if(TypeCCP  == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        grid.setTranslateY(50);
        pane.getChildren().addAll(hbDate,grid);
        getChildren().add(pane);
      } else {
         final StackPane   paneC     =  new StackPane();
        paneC.getStyleClass().add("setStylingRootCons");
        gridC.setPrefWidth(900);
        gridC.add(barOutil,6,21,2,2);
        gridC.add(vbMod,0,21,5,2);
        this.ConsultationE(NumDossier);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
      }
    } 
    public String getAnapath() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public String getPonctionEcho() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getPonctionBiopT() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getPonctionBiopF() {
        return Tgroup4.getSelectedToggle().getUserData().toString();
    }

    public String getPieceOperat() {
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }

    public String getResultat() {
        return resultat.getText();
    }

    public String getLameN() {
        return txt.getText();
    }

    public String getService() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getAutreServicePR() {
        return AutreServicePR.getText();
    } 

    public String getImmunome() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }

    public String getGrade() {
        return Tgroup8.getSelectedToggle().getUserData().toString();
    }

    public String getDiff() {
        return Tgroup10.getSelectedToggle().getUserData().toString();
    }

    public String getFoieNT() {
        return Tgroup9.getSelectedToggle().getUserData().toString();
    }

    public String getActivite() {
        return Tgroup11.getSelectedToggle().getUserData().toString();
    }

    public String getFibrose() {
        return Tgroup12.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getAnapath()+"\n"+this.getPonctionEcho()+"\n"+this.getPonctionBiopT()+"\n"+this.getPonctionBiopF()+"\n"+
        this.getPieceOperat()+"\n"+this.getResultat()+"\n"+this.getLameN()+this.getService()+"\n"+this.getImmunome()+"\n"+
        this.getGrade()+"\n"+this.getDiff()+"\n"+this.getFoieNT()+"\n"+this.getActivite()+" "+this.getFibrose() );
    
         MiseAjour    bddInsert    =  new MiseAjour();
        int i = bddInsert.AddElement("Insert into BilanAnapath values (0,'"+this.getAnapath()+"','"+this.getPonctionEcho()+"','"+this.getPonctionBiopT()+"','"+this.getPonctionBiopF()+"','"+
        this.getPieceOperat()+"','"+this.getResultat()+"','"+this.getLameN()+"','"+this.getService()+"','"+this.getAutreServicePR()+"','"+this.getImmunome()+"','"+
        this.getGrade()+"','"+this.getDiff()+"','"+this.getFoieNT()+"','"+this.getActivite()+"','"+this.getFibrose()+"','"+NumDossier+"','"+this.getDateB()+"')");
    
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// La partie Consultation///////////////////////////////////////////////////////////////////////
    
    public void setDateAnapath(String a) {
        TDateAnapath.setText(a);
    }

    public void setAnapath(String a) {
        TAnapath.setText(a);
    }

    public void setPEchoGuide(String a) {
        TPEchoGuide.setText(a);
    }

    public void setPBiopsieTumeur(String a) {
        TPBiopsieTumeur.setText(a);
    }

    public void setPBiopsieFAdjacent(String a) {
        TPBiopsieFAdjacent.setText(a);
    }

    public void setPieceOperatoire(String a) {
        TPieceOperatoire.setText(a);
    }

    public void setResultas(String a) {
        TResultas.setText(a);
    }

    public void setLame(String a) {
        TLame.setText(a);
    }

    public void setService(String a) {
        TService.setText(a);
    }

    public void setAutreService(String a) {
        TAutreService.setText(a);
    }

    public void setImmunom(String a) {
        TImmunom.setText(a);
    }

    public void setClassifGrade(String a) {
        TClassifGrade.setText(a);
    }

    public void setDifference(String a) {
        TDifference.setText(a);
    }

    public void setEFoieNTumoral(String a) {
         TEFoieNTumoral.setText(a);
    }

    public void setActivite(String a) {
        TActivite.setText(a);
    }

    public void setFibrose(String a) {
        TFibrose.setText(a);
    }
    
 public void ConsultationE(String NumDossier) throws SQLException{
        
        AnapathClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from BilanAnapath where NumDossier = '"+NumDossier+"'"
                                           +"and DateAnapath = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new AnapathClasse(res.getDate(18),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)
     ,res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15),res.getString(16));
}
     try{
      this.setDateAnapath(Bilan.getTDateAnapath().toString());
      this.setAnapath(Bilan.getTAnapath());
      this.setActivite(Bilan.getTAnapath());
      this.setPEchoGuide(Bilan.getTPEchoGuide());
      this.setPBiopsieFAdjacent(Bilan.getTPBiopsieFAdjacent());
      this.setPBiopsieTumeur(Bilan.getTPBiopsieTumeur());
      this.setPieceOperatoire(Bilan.getTPieceOperatoire());
      this.setResultas(Bilan.getTResultas());
      this.setLame(Bilan.getTLame());
      this.setService(Bilan.getTService());
      this.setAutreService(Bilan.getTAutreService());
      this.setImmunom(Bilan.getTImmunom());
      this.setClassifGrade(Bilan.getTClassifGrade());
      this.setDifference(Bilan.getTDifference());
      this.setEFoieNTumoral(Bilan.getTEFoieNTumoral());
      this.setActivite(Bilan.getTActivite());
      this.setFibrose(Bilan.getTFibrose());
     } catch (Exception e){
            this.setDateAnapath("-------------");
      this.setAnapath("-------------");
      this.setActivite("-------------");
      this.setPEchoGuide("-------------");
      this.setPBiopsieFAdjacent("-------------");
      this.setPBiopsieTumeur("-------------");
      this.setPieceOperatoire("-------------");
      this.setResultas("-------------");
      this.setLame("-------------");
      this.setService("-------------");
      this.setAutreService("-------------");
      this.setImmunom("-------------");
      this.setClassifGrade("-------------");
      this.setDifference("-------------");
      this.setEFoieNTumoral("-------------");
      this.setActivite("-------------");
      this.setFibrose("-------------");   
     }  
 }
 
   
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from BilanAnapath where NumDossier ='"+NumDossier+"' and dateAnapath ='"+DateInsBilan+"'" );
            
            return j;
        }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
