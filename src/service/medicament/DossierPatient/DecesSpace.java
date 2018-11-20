
package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import service.medicament.BilanPatient.BilanBiologique;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class DecesSpace extends Parent{
    
    
     
      final DatePicker DateDeces              = new DatePicker() ;
      final CheckBox   Rvo                    = new CheckBox("- Rvo ");
      final CheckBox   Encephalopathie        = new CheckBox("- Encephalopathie");
      final CheckBox   ProgressionTumorale    = new CheckBox("- Progression Tumorale");
      final TextArea   AutreCause             ;
    
      /*****/
      
      private Label    DateDecesT             = new Label();
      private Label    RvoT                   = new Label();
      private Label    EncephalopathieT       = new Label();
      private Label    ProgressionTumoraleT   = new Label();
      private Label    AutreCauseT            = new Label();
      
          
                                              /**********/
    final HBox         barOutil            = new HBox(2);

    final Button       EnregButton         = new Button();  
    final ImageView    EnregfImg           = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png")));
    final Button       SuppButton          = new Button();
    final ImageView    SuppImg             = new ImageView(new Image(getClass().getResourceAsStream("Images/7_3.jpg")));
    
    final VBox         vbMod           = new VBox(5);
    final Label        IndModifS       = new Label();
    final Hyperlink    hperAnnul       = new Hyperlink("Ou Annuler l'opération ... ");
    final ImageView    IndImgS         = new ImageView(new Image(getClass().getResourceAsStream("Images/9_2.jpg")));
    final ImageView    IndImgF         = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg")));

    /**********/

      ////////////////////////////////////////////////////////////////////////////////////////////////////
    
           final Label       IndIns        = new Label();
           final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
           final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
       
    public DecesSpace(String NumDossier,int i) throws SQLException{
        
        final GridPane     grid   = new GridPane();
        grid.setVgap(5); grid.setHgap(5);
        
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

        
        /**/
        ImgSucc.setFitHeight(50);          ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);    ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        /**/
        
         final Label DecesLabel   = new Label("Décès :"); DecesLabel.getStyleClass().add("setstyleTraitementPabs");
         grid.add(DecesLabel, 0,0);
         
         final Label DateLabel    = new Label("Date :");            grid.add(DateLabel, 0,1);   grid.add(DateDeces,1,1);
         final Label CauseLabel   = new Label("Cause du décès :");  grid.add(CauseLabel, 0,2);  CauseLabel.getStyleClass().add("styleLabel");
                                                                                                grid.add(Rvo ,1,2);
        DateDeces.setDayCellFactory(this.RegDate());                                            grid.add(Encephalopathie ,1,3);
        DateDeces.setValue(LocalDate.now());                                                                                       grid.add(ProgressionTumorale ,1,4);
        AutreCause   = champSaisierA(); 
        grid.add(AutreCause ,1,5,3,2);
        AutreCause.setPromptText("Autre Causes ");
          
        grid.setPadding(new Insets(10,10,10,50));
        
        final Button  Ajouter   = new Button("Ajouter ");
        
         Ajouter.setOnAction((ActionEvent)-> {
               try {//ImgSucc  ImgFaild   IndIns
                   int j =this.InsertionSGBD(NumDossier);
                   if(j == 1){
                    IndIns.setGraphic(ImgSucc); IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion du Décès \n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion du Décès est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n du Décès au niveau\n d'un dossier   ");
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(ANTCDfamiliauxSpace.class.getName()).log(Level.SEVERE, null, ex);
               }
        });
        grid.add(Ajouter,6,8);
        grid.add(IndIns,3,1,4,4);
          
            
        
        /******************************Partie Consultation **************************************************/
        
        final GridPane     gridC   = new GridPane();
        gridC.setVgap(5);  gridC.setHgap(5);
        final Label  DecesLabCons               = new Label("Décès   :");                   gridC.add(DecesLabCons,0,0);
        DecesLabCons.getStyleClass().add("setStyleCirconsanceDic");
      final Label    ConsDateDecesT             = new Label("Date DU DECES              :"); gridC.add(ConsDateDecesT,0,1);            gridC.add(DateDecesT,5,1);
      final Label    CauseDeDeces               = new Label("Causes                     :"); gridC.add(CauseDeDeces, 0,2);             CauseDeDeces.getStyleClass().add("styleLabel");
      final Label    ConsRvoT                   = new Label("_Rvo                       :"); gridC.add(ConsRvoT, 0,3);                 gridC.add(RvoT, 5,3); 
      final Label    ConsEncephalopathieT       = new Label("_Encephalopathie           :"); gridC.add(ConsEncephalopathieT , 0,4);    gridC.add(EncephalopathieT , 5,4);
      final Label    ConsProgressionTumoraleT   = new Label("_Progression Tumorale      :"); gridC.add(ConsProgressionTumoraleT,0,5);  gridC.add(ProgressionTumoraleT,5,5);
      final Label    ConsAutreCauseT            = new Label("Autre                      :"); gridC.add(ConsAutreCauseT, 0,6);          gridC.add(AutreCauseT, 5,6,4,3);
        /****************************************************************************************************/
      
               /**********************Partie Modification ***********************************************************/
        final ImageView ImgEnregSup   = new ImageView(new Image(getClass().getResourceAsStream("Images/12_1.jpg")));
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

        if(i == 0){
        grid.setPadding(new Insets(30,10,10,30));
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        getChildren().add(pane);
        }else {
          final StackPane   paneCons     =  new StackPane();
        this.ConsultationE(NumDossier);
        paneCons.getStyleClass().add("setStylingRootCons");
        gridC.setPadding(new Insets(30,10,10,30));
        gridC.add(barOutil,7,9,2,2);
        gridC.add(vbMod,0,9,8,2);
        barOutil.setTranslateX(100);
        gridC.setMinWidth(900);
        paneCons.getChildren().add(gridC);
        getChildren().add(paneCons);  
        }
                                                                                                
    }       
    
    
    public Callback<DatePicker, DateCell> RegDate(){
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
        
        return dayCellFactory;
    }

    public LocalDate getDateDeces() {
        return DateDeces.getValue();
    }

    public String getRvo() {
        if(Rvo.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getEncephalopathie() {
        if(Encephalopathie.isSelected())
        return "Oui";
        else return "Non";
    }

    public String getProgressionTumorale() {
        if(ProgressionTumorale.isSelected())
        return "Oui";
        else return "Oui";
    }

    public String getAutreCause() {
        return AutreCause.getText();
    }
    /***/
        public TextArea champSaisierA(){
 TextArea textA = new TextArea(){
            
            public void replaceText(int start , int end , String text){
                if(!text.matches("[']")){
                    super.replaceText(start, end, text);
                   
                }
              
            }
    
 };   

   return textA;  
    
}

    public void setDateDecesT(String DateDecesT) {
        this.DateDecesT.setText(DateDecesT);
    }

    public void setRvoT(String RvoT) {
        this.RvoT.setText(RvoT);
    }

    public void setEncephalopathieT(String EncephalopathieT) {
        this.EncephalopathieT.setText(EncephalopathieT);
    }

    public void setProgressionTumoraleT(String ProgressionTumoraleT) {
        this.ProgressionTumoraleT.setText(ProgressionTumoraleT);
    }
    

    public void setAutreCauseT(String AutreCauseT) {
        this.AutreCauseT.setText(AutreCauseT);
    }
        
        
    
    /***/
    
    public int  InsertionSGBD(String NumDossier) throws SQLException{
        
        MiseAjour   bddInsert    = new MiseAjour();
        int j =bddInsert.AddElement("Insert into Deces values('"+this.getDateDeces()+"','"+this.getRvo()+"','"
                             +this.getEncephalopathie()+"','"+this.getProgressionTumorale()+"','"+this.getAutreCause()+"','"
                             +NumDossier+"')");
    
      return j;
    }
    
    
    public void ConsultationE(String NumDossier) throws SQLException{
        
        DecesClasse     Deces = null  ;
        Consultation    bddCons     = new Consultation();
        ResultSet res   = bddCons.ExtElement("Select * from Deces where NumDossier ='"+NumDossier+"'");
        
        while(res.next()){
            Deces  = new DecesClasse(res.getDate(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
        }
        try{
            this.setAutreCauseT(Deces.getAutreCause());
            this.setRvoT(Deces.getRvo());
            this.setDateDecesT(Deces.getDateDeces().toString());
            this.setEncephalopathieT(Deces.getEncephalopathie());
            this.setProgressionTumoraleT(Deces.getProgressionTumorale());
            
        }
        catch(Exception e){
            this.setAutreCauseT("------------");
            this.setRvoT("------------");
            this.setDateDecesT("------------");
            this.setEncephalopathieT("------------");
            this.setProgressionTumoraleT("------------");
        }
        
        
        bddCons.CloseConnex();
    }
    
    
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from Deces where NumDossier ='"+NumDossier+"'");
            
            return j;
        }
    
    
}
