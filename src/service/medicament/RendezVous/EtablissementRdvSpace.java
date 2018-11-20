
package service.medicament.RendezVous;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import service.medicament.RendezVous.SGBD.MiseAjourRDV;

public class EtablissementRdvSpace extends Parent{
    
    final DatePicker     daterdv            = new DatePicker();
    final ComboBox       Heure              = new ComboBox();
    final TextField      avec               = new TextField();
    final TextField      sujetRDV           = new TextField();
    final Button         AffecterRdv        = new Button("Affecter lerendez-vous ");
    final TitledPane     Etablissement      = new TitledPane();
    ////
    final DatePicker        dateAnnulée     = new DatePicker();
    final ComboBox          HeureAnnulée    = new ComboBox();
    final Button            AnnulDate       = new Button("Annuler Le rendez-vous");
    final TitledPane        titledPane      = new TitledPane();
    
    ////////////////////////
     final Label       IndInsertBaseRDV    = new Label();
     final ImageView   IndImgSucc          = new ImageView(new Image(getClass().getResourceAsStream("Images/31.jpg")));
     final ImageView   IndImgrefu          = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg"))); 

     final Label       IndDeletLabel       = new Label();
     final ImageView   IndImgSuccD          = new ImageView(new Image(getClass().getResourceAsStream("Images/31.jpg")));
     final ImageView   IndImgrefuD          = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg"))); 
    ////////////////////////
    ////
    
    public EtablissementRdvSpace(){
        
        //////////////
        IndImgrefu.setFitHeight(30); IndImgrefu.setPreserveRatio(true);
        IndImgSucc.setFitHeight(30); IndImgSucc.setPreserveRatio(true);
        
        IndImgrefuD.setFitHeight(30); IndImgrefuD.setPreserveRatio(true);
        IndImgSuccD.setFitHeight(30); IndImgSuccD.setPreserveRatio(true);
        //////////////
        final VBox    vbox       = new VBox(5);   vbox.setPadding(new Insets(10,10,10,10));
        daterdv.setPromptText("Date du rendez-vous");
        daterdv.setDayCellFactory(RegDateRDV());
        
        Heure.getItems().addAll("09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00");
        Heure.setValue("09:00");
        avec.setPromptText(" Avec ...");
        sujetRDV.setPromptText("sujet du rendez-vous");
        
        vbox.getChildren().addAll(daterdv,Heure,avec,sujetRDV,AffecterRdv,IndInsertBaseRDV);
        
        AffecterRdv.setOnAction((ActionEvent)->{
            try {
                this.InsertionSGBDrdv();
            } catch (SQLException ex) {
                Logger.getLogger(EtablissementRdvSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Etablissement.setContent(vbox);
        Etablissement.setText("Etablire un Rendez Vous");
        
        ////
         final VBox     vbox1      = new VBox(5);  vbox1.setPadding(new Insets(10,10,10,10));
    
        dateAnnulée.setPromptText("Date Du rendez-vous");
        dateAnnulée.setDayCellFactory(RegDateRDV());
        HeureAnnulée.getItems().addAll("09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00");
        HeureAnnulée.setValue("09:00");
        
        titledPane.setText("Annuler un rendez-Vous");
        
        vbox1.getChildren().addAll(dateAnnulée,HeureAnnulée,AnnulDate,this.IndDeletLabel);
        AnnulDate.setOnAction((ActionEvent)->{
            try { 
                DeleteSGBDrdv();
            } catch (SQLException ex) {
                Logger.getLogger(EtablissementRdvSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        titledPane.setContent(vbox1);
        ////
        Accordion                           Accord    = new Accordion();
        Accord.getPanes().addAll(Etablissement,titledPane);
        Accord.getStyleClass().add("AccrodStyle");
        
        getChildren().add(Accord);
        
        this.setTranslateX(10);
        this.setTranslateY(200);
                
        
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Callback<DatePicker, DateCell> RegDateRDV(){
         final Callback<DatePicker, DateCell> dayCellFactory =

                     new Callback<DatePicker, DateCell>() {

                         @Override

                         public DateCell call(final DatePicker datePicker) {

                             return new DateCell() {

                        @Override
                       public void updateItem(LocalDate item, boolean empty) {

                           super.updateItem(item, empty);
                           if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color : rgb(157,157,0);");
                            }
                            
                             };
                         };
                     }};
         return dayCellFactory;
    } 
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public LocalDate getDaterdv() {
        return daterdv.getValue();
    }

    public String getHeure() {
        if(Heure.getValue().toString().equals("Heure"))
        return "";
        else return Heure.getValue().toString();
    }

    public String getAvec() {
        return avec.getText();
    }

    public String getSujetRDV() {
        return sujetRDV.getText();
    }

    public LocalDate getDateAnnulée() {
        return dateAnnulée.getValue();
    }

    public String getHeureAnnulée() {
        return HeureAnnulée.getValue().toString();
    }
    
    
    public void InsertionSGBDrdv() throws SQLException{
        
        MiseAjourRDV       bddInsert      = new MiseAjourRDV();
         this.setIndInsertBaseRDV(bddInsert.AddElement("Insert into RendezVous values(0,'"+this.getDaterdv()+"','"+this.getHeure()+"','"+
                this.getAvec()+"','"+this.getSujetRDV()+"')"));
        
        
    }
    
    public void DeleteSGBDrdv() throws SQLException{
                MiseAjourRDV       bddDelete      = new MiseAjourRDV();
                this.setIndDeletetBaseRDV(bddDelete .removeElement("delete from RendezVous where DateRendezVous ='"+this.getDateAnnulée()+"' and HeureRendezVous ='"+this.getHeureAnnulée()+"'"));
    }
    public  void setIndInsertBaseRDV(int typeErreur) {
       if(typeErreur == 0){
        IndInsertBaseRDV.setStyle("-fx-text-fill        : orange;" +
                                  "-fx-font-family      : \"Georgia\";"+
                                  "-fx-background-color : blue;"+
                                  "-fx-opacity          : 0.7");
        IndInsertBaseRDV.setText("Rendez Vous Déja Affecté \n"
                                + "Ou Parmètres Insuffisante  ");
        IndInsertBaseRDV.setGraphic(IndImgrefu);
        
       } else {
        IndInsertBaseRDV.setText("");
        IndInsertBaseRDV.setGraphic(IndImgSucc);  
       }
       }
        public  void setIndDeletetBaseRDV(int typeErreur) {
       if(typeErreur == 0){
        this.IndDeletLabel.setGraphic(IndImgrefuD);
        
       } else {
      
        this.IndDeletLabel.setGraphic(IndImgSuccD);  
       }
       }
    
}
