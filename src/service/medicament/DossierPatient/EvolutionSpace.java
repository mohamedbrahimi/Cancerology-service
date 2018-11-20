
package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;


public final class EvolutionSpace extends Parent{
    
    final ToggleGroup     Tgroup1          = new  ToggleGroup();
    final TextField       Clinique         ;
    final TextField       Radiologique     ;
    final TextField       AFP              ;
    
    final String          TextMois;

    public EvolutionSpace(String NumDossier,int i) throws SQLException{
           Clinique         = this.champSaisier();
           Radiologique     = this.champSaisier();
           AFP              = this.champSaisier();  
           /**/
           
           final GridPane    grid        = new GridPane();
           grid.setVgap(5);  grid.setHgap(5);
           
           final Label EvolutionTap      = new Label("Evolution  :");  
           int count = this.ReturnMois(NumDossier);
           final Label MoisEvol     = new Label(count+" mois :");
           TextMois = MoisEvol.getText();
            final RadioButton  Oui        = new RadioButton("Oui "); Oui.setUserData("Oui"); Oui.setSelected(true);
            final RadioButton  Non        = new RadioButton("Non "); Non.setUserData("Non");
            Oui.setToggleGroup(Tgroup1);    Non.setToggleGroup(Tgroup1);
            
            grid.add(EvolutionTap,0,1);  
            grid.add(MoisEvol,1,2);  grid.add(Oui,2,2); grid.add(Non,3,2);
            final Label CliniqueLab = new Label("Clinique      :"); grid.add(CliniqueLab,0,4); grid.add(Clinique,1,4);
            final Label RadiologLab = new Label("Radiologique  :"); grid.add(RadiologLab,0,5); grid.add(Radiologique,1,5);
            final Label AFPLab      = new Label("AFP           :"); grid.add(AFPLab,0,6);      grid.add(AFP,1,6);
            
            
            /**/
            final Button  Evaluerb    = new Button("Evaluer");
            grid.add(Evaluerb,6,11);
            grid.getStyleClass().add("Evolution");
            
            final Button  EvalAnnul   = new Button("Annuler");
            grid.add(EvalAnnul,0,11);EvalAnnul.setVisible(false);
            
            
            final Label       IndSE       = new Label();
            final ImageView   ImgEv       = new ImageView(new Image(getClass().getResourceAsStream("Images/31.jpg")));
            ImgEv.setFitHeight(50); ImgEv.setPreserveRatio(true);
            
            final ImageView   ImgEvF       = new ImageView(new Image(getClass().getResourceAsStream("Images/9_2.jpg")));
            ImgEvF.setFitHeight(50); ImgEvF.setPreserveRatio(true);
            grid.add(IndSE,0,9,6,2);
            IndSE.getStyleClass().add("erreurchamp");
            Evaluerb.setOnAction((ActionEvent)->{
             
               try {
                   if(this.InsertionSGBD(NumDossier) == 1){
                   IndSE.setText("L'etat d'evolution pour "+this.getTextMois()+" est enregistrée "); IndSE.setGraphic(ImgEv);}
                   Evaluerb.setDisable(false);
                   EvalAnnul.setVisible(true);EvalAnnul.setDisable(false);
                   } catch (SQLException ex) {
                  
               } 
             
             
            });
           /**/
            EvalAnnul.setOnAction((ActionEvent)->{
               try {
                  if( this.DeleteSGBD(NumDossier) == 1){
              IndSE.setText("L'etat d'evolution pour "+this.getTextMois()+" est retiré ");
              IndSE.setGraphic(ImgEvF);
               Evaluerb.setDisable(false);
                  
               EvalAnnul.setDisable(true);
                  }
               } catch (SQLException ex) {
                   Logger.getLogger(EvolutionSpace.class.getName()).log(Level.SEVERE, null, ex);
               }
            });
           /**/
            
            grid.setPadding(new Insets(70,10,70,50));
            if(i == 0){
            getChildren().add(grid);
            }else {
            final GridPane  gridC     = new GridPane();
            gridC.setVgap(5); gridC.setHgap(5);
            final Label EvolutionLab           = new Label("Evolution :"); EvolutionLab.getStyleClass().add("setStyleCirconsanceDic");
            
            int pos = 1;
            gridC.add(EvolutionLab,0,0);
            
            /**/
            ResultSet  res = this.ConsultaionE(NumDossier);
            while(res.next()){
            final Label MoisLab   = new Label("Mois                     :");   gridC.add(MoisLab,  0, pos);  MoisLab.getStyleClass().add("styleLabel");
            final Label MoisCons  = new Label(res.getString(1));               gridC.add(MoisCons, 5, pos);  MoisCons.getStyleClass().add("setStylingRoot");
            pos ++;
            
            final Label EtatEvolL = new Label("Etat d'evolution         :");   gridC.add(EtatEvolL,0, pos);
            final Label EtatEvolC = new Label(res.getString(2));               gridC.add(EtatEvolC,5, pos);
            pos++;
            
            final Label CliniqueL = new Label("Cilnique                 :");   gridC.add(CliniqueL, 0,pos);
            final Label CliniqueC = new Label(res.getString(3));               gridC.add(CliniqueC, 5,pos);
            pos++;
            
            final Label RadiologL = new Label("Radiologique             :");   gridC.add(RadiologL, 0,pos);
            final Label RadiologC = new Label(res.getString(4));               gridC.add(RadiologC, 5,pos);
            pos++;
            
            final Label AFPL      = new Label("AFP                      :");   gridC.add(AFPL,0,pos);
            final Label AFPC      = new Label(res.getString(5));               gridC.add(AFPC,5,pos);
            
            pos++;
            
            final Separator sep   = new Separator(); sep.setOrientation(Orientation.HORIZONTAL); gridC.add(sep,0,pos,5,1);
            pos++;
            }
             final StackPane   paneCons     =  new StackPane();
        
             paneCons.getStyleClass().add("setStylingRootCons");
             gridC.setPadding(new Insets(30,10,10,30));
             gridC.setMinWidth(900);
             paneCons.getChildren().add(gridC);
             getChildren().add(paneCons);
            }
    } 

    public String getTgroup1() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public String getClinique() {
        return Clinique.getText();
    }

    public String getRadiologique() {
        return Radiologique.getText();
    }

    public String getAFP() {
        return AFP.getText();
    }
    
    public String getTextMois() {
        return TextMois.substring(0,TextMois.length()-1);
    }
    
 public TextField champSaisier(){
 TextField textF = new TextField(){
            
  public void replaceText(int start , int end , String text){
       if(!text.matches("[']")){
            super.replaceText(start, end, text);
                }
              
            }
        
 };   
   return textF;  
}
 
 /****** Insertion Evolution *********************************************/
  public int InsertionSGBD(String NumDossier) throws SQLException{
      MiseAjour     bddInsert   = new MiseAjour();
       int j =bddInsert.AddElement("Insert into Evolution values ('"+this.getTextMois()+"','"+this.getTgroup1()+"','"+this.getClinique()+"','"
                            +this.getRadiologique()+"','"+this.getAFP()+"','"+NumDossier+"')");
       
       return j;
  }
  
  public int  DeleteSGBD(String NumDossier) throws SQLException{
       MiseAjour     bddDelete   = new MiseAjour();
       int j =bddDelete.AddElement("Delete from Evolution where NumDossier ='"+NumDossier+"' and Mois ='"+this.getTextMois()+"'");
       
       return j;
  }
  
  public int ReturnMois(String NumDossier ) throws SQLException{
      Consultation  bddConsult    = new Consultation();
      ResultSet res   = bddConsult.ExtElement("Select count(*) from Evolution where NumDossier ='"+NumDossier+"'");
      int count =3;
      while(res.next()) count = count * res.getInt(1) + 3;
      
      bddConsult.CloseConnex();
      return count;
  }
  
  public ResultSet ConsultaionE(String NumDossier) throws SQLException{
      
      Consultation bddCons     = new Consultation();
      ResultSet  res   = bddCons.ExtElement("Select * from Evolution where NumDossier ='"+NumDossier+"'");
      
      return res; 
  }
}
