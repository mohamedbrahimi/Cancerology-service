
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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


public class AutreExamenBR extends Parent{
              
              final DatePicker    DateB               = new DatePicker();
              final ToggleGroup   Tgroup11            = new ToggleGroup();
              final ToggleGroup   Tgroup12            = new ToggleGroup(); 
              final ToggleGroup   Tgroup13            = new ToggleGroup();
              final ToggleGroup   Tgroup14            = new ToggleGroup();
              final ToggleGroup   Tgroup15            = new ToggleGroup();
              final TextArea      preciseEx           = new TextArea();
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       //////   partie consultation //////////////////////////////////////////////////////////
    private final Label TDateAutreExamen  = new Label();
    private final Label Thoracique        = new Label();
    private final Label TMetastase        = new Label();
    private final Label TScintOss         = new Label();
    private final Label TScintMetastase   = new Label();
    private final Label TExpAutres        = new Label();
    private final Label TExpPrecise       = new Label();  
    
    
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
    final String DateInsBilan ;
    public AutreExamenBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
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
        final Label DateBilan                     = new Label("Date Des Examens ");  
        final HBox  hbDate                        = new HBox(10);
        hbDate.getChildren().addAll(DateBilan,DateB); hbDate.setPadding(new Insets(30,20,30,20));
        
        final GridPane     grid                               = new GridPane();
        grid.setVgap(5); grid.setHgap(5);
        grid.add(DateBilan,0,0);    grid.add(DateB,1,0);
        final Label           TDMIRMthoracique   = new Label("TDM/IRM THORACIQUE");
              final RadioButton      OuiTDMIRM       = new RadioButton("Oui");    OuiTDMIRM.setUserData("Oui");
              final RadioButton      NonTDMIRM       = new RadioButton("Non");    NonTDMIRM.setUserData("Non");
                                                                                  NonTDMIRM.setSelected(true);
                  
              OuiTDMIRM.setToggleGroup(Tgroup11); NonTDMIRM.setToggleGroup(Tgroup11);
    
    grid.add(TDMIRMthoracique,0,1); grid.add(OuiTDMIRM,1,1); grid.add(NonTDMIRM, 2,1);
        
       final HBox            hbHoracique         = new HBox(5);
             final Label             SiOui           = new Label("Si Oui métastase");
             final RadioButton       OuiMetastase    = new RadioButton("Oui");     OuiMetastase.setUserData("Oui");
             final RadioButton       NonMetastase    = new RadioButton("Non");     NonMetastase.setUserData("Non");
                                                                                   OuiMetastase.setSelected(true);
             
             OuiMetastase.setToggleGroup(Tgroup12); NonMetastase.setToggleGroup(Tgroup12);
             hbHoracique.getChildren().addAll(SiOui,OuiMetastase,NonMetastase);
    grid.add(hbHoracique,0,2,3,1); hbHoracique.setVisible(false);
        
        Tgroup11.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov ,Toggle old_toggle,
         Toggle new_toggle)->{
          if(Tgroup11.getSelectedToggle().getUserData().equals("Oui")){
              hbHoracique.setVisible(true);NonMetastase.setSelected(true);
          }else {
              hbHoracique.setVisible(false);Tgroup12.getSelectedToggle().setSelected(false);
          }  
        });
        
        final Label           ScinitigraphieOsseuse   = new Label("SCINITIGRAPHIE OSSEUSE");
              final RadioButton      OuiSO       = new RadioButton("Oui");    OuiSO.setUserData("Oui");
              final RadioButton      NonSO       = new RadioButton("Non");    NonSO.setUserData("Non");
                                                                              NonSO.setSelected(true);
                  
              OuiSO.setToggleGroup(Tgroup13); NonSO.setToggleGroup(Tgroup13);
        grid.add(ScinitigraphieOsseuse,0,4); grid.add(OuiSO,1,4); grid.add(NonSO, 2,4);
        
       final HBox            hbSO         = new HBox(5);
             final Label             SiOuiSO           = new Label("Si Oui métastase");
             final RadioButton       OuiMetastaseSO    = new RadioButton("Oui"); OuiMetastaseSO.setUserData("Oui");
             final RadioButton       NonMetastaseSO    = new RadioButton("Non"); NonMetastaseSO.setUserData("Non");
                                                                                 OuiMetastaseSO.setSelected(true);
              
             OuiMetastaseSO.setToggleGroup(Tgroup14); NonMetastaseSO.setToggleGroup(Tgroup14);
             hbSO.getChildren().addAll(SiOuiSO,OuiMetastaseSO,NonMetastaseSO);
    grid.add(hbSO,0,5,3,1); hbSO.setVisible(false);
        
        Tgroup13.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov ,Toggle old_toggle,
         Toggle new_toggle)->{
          if(Tgroup13.getSelectedToggle().getUserData().equals("Oui")){
              hbSO.setVisible(true);NonMetastaseSO.setSelected(true);
          }else {
              hbSO.setVisible(false);Tgroup14.getSelectedToggle().setSelected(false);
          }  
        });
        
            final Label     AutreExplorationRX      = new Label("AUTRE EXPLORATIONS RX");
                  final RadioButton      OuiRX         = new RadioButton("Oui"); OuiRX.setUserData("Oui");
                  final RadioButton      NonRX         = new RadioButton("Non"); NonRX.setUserData("Non");
                                                                                 NonRX.setSelected(true);
                  OuiRX.setToggleGroup(Tgroup15); NonRX.setToggleGroup(Tgroup15);
    grid.add(AutreExplorationRX,0,6); grid.add(OuiRX,1,6); grid.add(NonRX,2,6);
      
            
            preciseEx.setPrefSize(180,70);  
            preciseEx.setPromptText("préciser");
    grid.add(preciseEx, 0,7); preciseEx.setVisible(false);
    Tgroup15.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov , Toggle old_value,
    Toggle new_value )->{
        if(Tgroup15.getSelectedToggle().getUserData().equals("Oui")){
            preciseEx.setVisible(true);
        }else {
            preciseEx.setVisible(false);preciseEx.setText("");
        }
        
    });
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
                    IndIns.setText(" L’insertion du Bilan\n Radiologique(Autre Examens) \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Bilans \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des bilan de même type \n au niveau d'un dossier \n sur la même date ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(IRMBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    ///
        grid.add(Ajouter, 5,8);
        grid.add(IndIns,4,2,4,6);
        grid.setPadding(new Insets(30,10,10,30));
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////// la partie Consultation /////////////////////////////////////////////////////////////////////////
        final GridPane     gridC                               = new GridPane();
        gridC.setVgap(5); gridC.setHgap(5);
        gridC.setPadding(new Insets(30,10,10,30));
     final Label ConsDateAutreExamen    = new Label("Date autre examens                      :");
     final Label Conshoracique          = new Label("TDM/IRM THORACIQUE                     :");
     final Label ConsMetastase          = new Label("Si oui metastase                       :");
     final Label ConsScintOss           = new Label("Scintigraphie osseuse                  :");
     final Label ConsScintMetastase     = new Label("Si oui metastase                       :");
     final Label ConsExpAutres          = new Label("Autres exploration                     :");
     final Label ConsExpPrecise         = new Label("Préciser                               :");
        
     	final Label BilanRadLabel         = new Label("Bilan Radiologique :");    BilanRadLabel.getStyleClass().add("setStyleCirconsanceDic");
	final Label AutreAxamenLabel      = new Label("Autres Examnes  :");       AutreAxamenLabel.getStyleClass().add("setStyleCirconsanceDic");
  gridC.add(BilanRadLabel,0,0);
  gridC.add(AutreAxamenLabel,0,1);
  gridC.add(ConsDateAutreExamen , 0, 2);               gridC.add(TDateAutreExamen,5,2);
  gridC.add(Conshoracique , 0, 3);                     gridC.add(Thoracique,5,3);
  gridC.add(ConsMetastase, 0, 4);                      gridC.add(TMetastase,5,4);
  gridC.add(ConsScintOss, 0, 5);                       gridC.add(TScintOss,5,5);
  gridC.add(ConsScintMetastase,0, 6);                  gridC.add(TScintMetastase,5,6);
  gridC.add(ConsExpAutres  , 0, 7,1,3);                    gridC.add(TExpAutres , 5,7,2,3);
  gridC.add(ConsExpPrecise , 0, 10);                    gridC.add(TExpPrecise ,5,10,2,3);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
  
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

  if(TypeCCP == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        
        getChildren().add(pane);
  }else {
        
        final StackPane   paneC     =  new StackPane();
        paneC.getStyleClass().add("setStylingRootCons");
        gridC.setPrefWidth(900);
        this.ConsultationE(NumDossier);
        paneC.getChildren().add(gridC);
        gridC.add(barOutil,6,12,2,2);
        gridC.add(vbMod,0,12,5,2);
        getChildren().add(paneC);
  }  
  }
     public String getIRMTDM() {
        return Tgroup11.getSelectedToggle().getUserData().toString();
    }

    public String getMetataseIRMTDM() {
        if(getIRMTDM().equals("Oui")){
        return Tgroup12.getSelectedToggle().getUserData().toString();
        }else return "";
    }

    public String getScinitigraphOS() {
        return Tgroup13.getSelectedToggle().getUserData().toString();
    }

    public String getMetataseOS() {
        if(getScinitigraphOS().equals("Oui"))
        return Tgroup14.getSelectedToggle().getUserData().toString();
        else return "";
    }

    public String getAutreExp() {
        return Tgroup15.getSelectedToggle().getUserData().toString();
    }
    public String getPreciseEx() {
        return preciseEx.getText();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }
    
     public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(
   this.getIRMTDM()+"\n"+this.getMetataseIRMTDM()+"\n"+this.getScinitigraphOS()+"\n"+
        this.getMetataseOS()+"\n"+this.getAutreExp()+"\n"+this.getPreciseEx()
        );
        
        MiseAjour    bddInsert    = new MiseAjour();
        int i = bddInsert.AddElement("insert into AutreExamens values (0,'"+this.getIRMTDM()+"','"+this.getMetataseIRMTDM()+"','"+this.getScinitigraphOS()+"','"+
        this.getMetataseOS()+"','"+this.getAutreExp()+"','"+this.getPreciseEx()+"','"+NumDossier+"','"+this.getDateB()+"')");
        
        return i ;
}
     ///////////////////////////////////////////////////////////////////////////////////////////////////
      /////// les Methodes de Consultation  ////////////////////////////////////////////////////////////
     
    public void setDateAutreExamen(String a) {
        TDateAutreExamen.setText(a);
    }

    public void setHoracique(String a) {
        Thoracique.setText(a); 
    }

    public void setMetastase(String a) {
        TMetastase.setText(a);
    }

    public void setScintOss(String a) {
        TScintOss.setText(a);
    }

    public void setScintMetastase(String a) {
        TScintMetastase.setText(a);
    }

    public void setExpAutres(String a) {
        TExpAutres.setText(a);
    }

    public void setExpPrecise(String a) {
        TExpPrecise.setText(a);
    }
  public void ConsultationE(String NumDossier) throws SQLException{
        
        AutreExamenClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from autreexamens where NumDossier = '"+NumDossier+"'"
                                           +"and Dateexamen = '"+DateInsBilan+"'");
    while(res.next()){
     Bilan   = new AutreExamenClasse(res.getDate(9),res.getString(2),res.getString(3),res.getString(4),res.getString(5)
     ,res.getString(6),res.getString(7)
            
     ); 
    }try{
     this.setDateAutreExamen(Bilan.getTDateAutreExamen().toString());
     this.setHoracique(Bilan.getThoracique());
     this.setMetastase(Bilan.getTMetastase());
     this.setExpAutres(Bilan.getTExpAutres());
     this.setExpPrecise(Bilan.getTExpPrecise());
     this.setScintMetastase(Bilan.getTScintMetastase());
     this.setScintOss(Bilan.getTScintOss());
    }catch(Exception e){
           this.setDateAutreExamen("----------");
     this.setHoracique("----------");
     this.setMetastase("----------");
     this.setExpAutres("----------");
     this.setExpPrecise("----------");
     this.setScintMetastase("----------");
     this.setScintOss("----------");  
    }
     ///////////////////////////////////////////////////////////////////////////////////////////////////
}
  
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from AutreExamens where NumDossier ='"+NumDossier+"' and dateExamen ='"+DateInsBilan+"'" );
            
            return j;
        }
}
