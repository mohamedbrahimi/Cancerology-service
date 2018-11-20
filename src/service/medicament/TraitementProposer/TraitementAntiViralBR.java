
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
import javafx.util.Callback;
import service.medicament.BilanPatient.BilanBiologique;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;


public final class TraitementAntiViralBR extends Parent{
    
     final       String         styleButton   =     " -fx-font: 16 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           + " -fx-background-color: black;"
                                           + " -fx-text-fill: white;"
                                           + " -fx-border-radius: 5;";
     
        final DatePicker     DateB                             = new DatePicker();
        final ToggleGroup    Tgroup1                           = new ToggleGroup();
        final DatePicker     dateD                             = new DatePicker(); 
        final TextField      ChargeVI                          ; 
        final TextField      txtDrogue                         ;
        final CheckBox       ch1                               = new CheckBox("Entecavir");
        final CheckBox       ch2                               = new CheckBox("lamividine");
        final CheckBox       ch3                               = new CheckBox("Bitherapie");
        final CheckBox       ch4                               = new CheckBox("tritherapie");
        final TextArea       autre                             ;
         
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
  //////////////////////////////////////////////////////////////////////////////////////////////////////
       //// La Partie Consultation    /////////////////////////////////////////////////////////////////////
     private final Label TDateTrait            = new Label();
     private final Label TTraitemAntiVirale    = new Label();
     private final Label TTADateDeb            = new Label();
     private final Label TChargeViraleInitail  = new Label();
     private final Label TTADrogue             = new Label();
     private final Label TTAEntecavir          = new Label();
     private final Label TTABitherapie         = new Label();
     private final Label TTATritherapie        = new Label();
     private final Label TTALamvidine          = new Label();
     private final Label TTAAutres             = new Label();
     
    
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
    public TraitementAntiViralBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
        
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
        final Label DateBilan                     = new Label("Date de Traitement ");  
        
        final HBox  hbDate                        = new HBox(10);
        hbDate.getChildren().addAll(DateBilan,DateB); hbDate.setPadding(new Insets(30,20,30,20));
        
        final GridPane       grid                              = new GridPane();   grid.setVgap(5);    grid.setHgap(5);
        final Label          TraitementAntiViral               = new Label("TRAITEMENT ANTI-VIRAL : ");
        TraitementAntiViral.setStyle(styleButton);
              final RadioButton      OuiTAV                       = new RadioButton("Oui");OuiTAV.setUserData("Oui"); OuiTAV.setSelected(true);
              final RadioButton      NonTAV                       = new RadioButton("Non");NonTAV.setUserData("Non");
              
              OuiTAV.setToggleGroup(Tgroup1);     NonTAV.setToggleGroup(Tgroup1);
        grid.add(TraitementAntiViral,0,0);   grid.add(OuiTAV,1,0);   grid.add(NonTAV,2,0);
        
        
        
        
        dateD.setValue(LocalDate.now());
        dateD.setTooltip(new Tooltip("Date Début  "));
        grid.add(dateD,0,1);  
       
        ChargeVI  = this.champSaisier();
        ChargeVI.setPrefWidth(150);
        ChargeVI.setPromptText("Charge Virale Initiale");
        grid.add(ChargeVI,1,1,3,1);
        
        final Label          drogue                            = new Label("Drogue : ");
        txtDrogue = this.champSaisier();      txtDrogue.setPrefWidth(150); txtDrogue.setPromptText("Drogue");
        grid.add(drogue,0,3);  grid.add(txtDrogue, 1,3,3,1);
        
        grid.add(ch1,0,4); grid.add(ch2,1,4); 
        grid.add(ch3,0,5); grid.add(ch4, 0,6);
        
        
        autre = this.champSaisierA();
        autre.setPromptText("Autre");
        autre.setPrefSize(200,80);
        grid.add(autre, 0,7);
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
                    IndIns.setText(" L’insertion des Traitements\n Propose (TraitementAntiVirale) \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Traitements \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Traitements de même type \n au niveau d'un dossier \n sur la même date ");
                   } 
            } catch (SQLException ex) {
                Logger.getLogger(ChimieomBolisationBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 5,9);
        grid.add(IndIns,4,3,5,5);
        ////
        Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov ,Toggle old_value ,
        Toggle new_value)-> {
          if(Tgroup1.getSelectedToggle().getUserData().equals("Non")){
           grid.getChildren().removeAll(dateD,ChargeVI,drogue,ch1,ch2,ch3,ch4,autre,Ajouter,txtDrogue,IndIns,IndIns);
          }else {
           grid.getChildren().addAll(   dateD,ChargeVI,drogue,ch1,ch2,ch3,ch4,autre,Ajouter,txtDrogue,IndIns,IndIns);
          }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///// La ¨Partie Consultation   ////////////////////////////////////////////////////////////////////////////////////
          final GridPane        gridC    = new GridPane();
          gridC.setVgap(10);
          gridC.setHgap(7);  
        
      final Label ConsDateTrait               = new Label("Date traitement anti-viral                :");
      final Label ConsTraitemAntiVirale       = new Label("TRAITEMENT ANTI-VIRAL                     :");
      final Label ConsTADateDeb               = new Label("Date début                                :");
      final Label ConsChargeViraleInitail     = new Label("Charge vu=irale initiale                  :");
      final Label ConsTADrogue                = new Label("Droques                                   :");
      final Label ConsTAEntecavir             = new Label("Entecavir                                 :");
      final Label ConsTABitherapie            = new Label("Bitherapie                                :");
      final Label ConsTATritherapie           = new Label("Tritherapie                               :");
      final Label ConsTALamvidine             = new Label("Lamividine                                :");
      final Label ConsTAAutres                = new Label("Autres                                    :");
  
      final Label TraitAntiLabel        = new Label("TRAITEMENT ANTI-VIRAL :");
      TraitAntiLabel.getStyleClass().add("setStyleCirconsanceDic");
   
  gridC.add(TraitAntiLabel,0,0);
  gridC.add(ConsDateTrait , 0,1);                    gridC.add(TDateTrait, 5,1);
  gridC.add(ConsTraitemAntiVirale ,0, 2);            gridC.add(TTraitemAntiVirale, 5,2);
  gridC.add(ConsTADateDeb, 0,3);                     gridC.add(TTADateDeb, 5,3);
  gridC.add(ConsChargeViraleInitail,0, 4);           gridC.add(TChargeViraleInitail,5,4);
  gridC.add(ConsTADrogue,0,5);                       gridC.add(TTADrogue,5,5);
  gridC.add(ConsTAEntecavir  ,0, 6);                 gridC.add(TTAEntecavir , 5,6);
  gridC.add(ConsTABitherapie , 0,7);                 gridC.add(TTABitherapie, 5,7);
  gridC.add(ConsTATritherapie ,0, 8);                gridC.add(TTATritherapie ,5, 8);
  gridC.add(ConsTALamvidine ,0, 9);                  gridC.add(TTALamvidine ,5, 9);
  gridC.add(ConsTAAutres , 0,10,2,3);                    gridC.add(TTAAutres ,5,10,2,3);
  
  
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

  
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        gridC.add(barOutil,6,14,2,2);
        gridC.add(vbMod, 0,14,5,3);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC); 
     }
         ///////////////
      
    }
  
    public String getTgroup1() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public LocalDate getDateD() {
        return dateD.getValue();
    }

    public String getChargeVI() {
        return ChargeVI.getText();
    }

    public String  getTxtDrogue() {
        return txtDrogue.getText();
    }
    

    public String getCh1() {
        if(ch1.isSelected()){
            return "Oui";
        }else
        return "Non";
    }

    public String getCh2() {
        if(ch2.isSelected()){
            return "Oui";
        }else
        return "Non";
    }

    public String getCh3() {
        if(ch3.isSelected()){
            return "Oui";
        }else
        return "Non";
    }

    public String getCh4() {
        if(ch4.isSelected()){
            return "Oui";
        }else
        return "Non";
    }

    public String getAutre() {
        return autre.getText();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getTgroup1()+"\n"+this.getDateD()+"  "+this.getChargeVI()+"\n"+this.getCh1()+"  "+this.getCh2() +"\n"+this.getCh3()+"\n"+this.getCh4()+"\n"+
                this.getAutre()+"\n");
        
        MiseAjour  bddInsert   =  new MiseAjour();
        int i = bddInsert.AddElement("Insert into TraitementAntiVirale values(0,'"+this.getTgroup1()+"','"+this.getDateD()+"','"+this.getChargeVI()+"','"+this.getTxtDrogue()+"','"+this.getCh1()+"','"+this.getCh2() +"','"+this.getCh3()+"','"+this.getCh4()+"','"+
                this.getAutre()+"','"+NumDossier+"','"+this.getDateB()+"')");
        
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
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //// La Partie Consultation  ////////////////////////////////////////////////////////////////////////////////////
 public void setTDateTrait(String a) {
        TDateTrait.setText(a);
    }

    public void setTTraitemAntiVirale(String a) {
        TTraitemAntiVirale.setText(a);
    }

    public void setTTADateDeb(String a) {
        TTADateDeb.setText(a);
    }

    public void setTChargeViraleInitail(String a) {
        TChargeViraleInitail.setText(a);
    }

    public void setTTADrogue(String a) {
        TTADrogue.setText(a);
    }

    public void setTTAEntecavir(String a) {
        TTAEntecavir.setText(a);
    }

    public void setTTABitherapie(String a) {
        TTABitherapie.setText(a);
    }

    public void setTTATritherapie(String a) {
        TTATritherapie.setText(a);
    }

    public void setTTALamvidine(String a) {
        TTALamvidine.setText(a);
    }

    public void setTTAAutres(String a) {
        TTAAutres.setText(a);
    }
    
 public void ConsultationE(String NumDossier) throws SQLException{
        
        TraitementAntiViralClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from TraitementAntiVirale where NumDossier = '"+NumDossier+"'"
                                           +"and DateTrait = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new TraitementAntiViralClasse(res.getDate(12),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)
     );
} 
    try{
    this.setTDateTrait(Bilan.getTDateTrait().toString());
    this.setTChargeViraleInitail(Bilan.getTChargeViraleInitail());
    this.setTTAAutres(Bilan.getTTAAutres());
    this.setTTABitherapie(Bilan.getTTABitherapie());
    this.setTTADateDeb(Bilan.getTTADateDeb());
    this.setTTADrogue(Bilan.getTTADrogue());
    this.setTTAEntecavir(Bilan.getTTAEntecavir());
    this.setTTALamvidine(Bilan.getTTALamvidine());
    this.setTTATritherapie(Bilan.getTTATritherapie());
    this.setTTraitemAntiVirale(Bilan.getTTraitemAntiVirale());
    }catch(Exception e){
        this.setTDateTrait("-------------");
    this.setTChargeViraleInitail("-------------");
    this.setTTAAutres("-------------");
    this.setTTABitherapie("-------------");
    this.setTTADateDeb("-------------");
    this.setTTADrogue("-------------");
    this.setTTAEntecavir("-------------");
    this.setTTALamvidine("-------------");
    this.setTTATritherapie("-------------");
    this.setTTraitemAntiVirale("-------------");
    }
}
 
 
    public int  DeleteSGBD(String NumDossier) throws SQLException{
       MiseAjour bddDelete   = new MiseAjour();
        
       int j = bddDelete.AddElement("delete from TraitementAntiVirale where NumDossier ='"+NumDossier+"' and dateTrait ='"+DateInsBilan+"'" );
            
            return j;
        }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
