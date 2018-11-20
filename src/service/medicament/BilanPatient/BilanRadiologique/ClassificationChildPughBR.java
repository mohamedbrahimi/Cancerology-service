
package service.medicament.BilanPatient.BilanRadiologique;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
import javax.swing.JButton;
import service.medicament.BilanPatient.BilanBiologique;
import service.medicament.DossierPatient.ANTCDfamiliauxClasse;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public class ClassificationChildPughBR extends Parent{
   
          
          final ToggleGroup     Tgroup1        = new ToggleGroup();
          final ToggleGroup     Tgroup5        = new ToggleGroup();
          final ToggleGroup     Tgroup6        = new ToggleGroup();
          final ToggleGroup     Tgroup2        = new ToggleGroup();
          final ToggleGroup     Tgroup3        = new ToggleGroup();
          final ToggleGroup     Tgroup4        = new ToggleGroup();
          
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("42.jpg")));
    
       ////////////////////////////////////////////////////////////////////////////////////////////////////////
       ///// La Partie Conception /////////////////////////////////////////////////////////////////////////////
        private final Label TClassifChildPugh       = new Label("-------") ;
        private final Label TClassifBCLC            = new Label("-------");
        private final Label TClassifOkuda           = new Label("-------");
        private final Label TClassifClip            = new Label("-------");
        private final Label TClassificationTnm      = new Label("-------");
       
        
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

       ////////////////////////////////////////////////////////////////////////////////////////////////////////
          final String DateInsBilan ;
    public ClassificationChildPughBR(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
       this.DateInsBilan   = DateInsBilan; 
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
     
     final GridPane  grid                       = new GridPane();
     grid.setVgap(5); grid.setHgap(5);
     final Label     ClassificationChildPugh    = new Label("CLASSIFICATION CHILD-PUGH");
     ClassificationChildPugh.getStyleClass().add("setStyleClassification");
           final RadioButton     A                 = new RadioButton("A");A.setUserData("A");
           final RadioButton     B                 = new RadioButton("B");B.setUserData("B");
           final RadioButton     C                 = new RadioButton("C");C.setUserData("C");A.setSelected(true);
          
           A.setToggleGroup(Tgroup1); B.setToggleGroup(Tgroup1); C.setToggleGroup(Tgroup1);
     grid.add(ClassificationChildPugh, 0,0,4,1); grid.add(A,1,1); grid.add(B,2,1); grid.add(C,3,1);
     
     final Label     ClassificationBclc         = new Label("CLASSIFICATION BCLC");
     ClassificationBclc.getStyleClass().add("setStyleClassification");
     grid.add(ClassificationBclc,0,3,2,1);
     
           final Label           StadeA            = new Label("STADE");
                 final RadioButton        A0             = new RadioButton("A");   A0.setUserData("A");
                 
                 A0.setToggleGroup(Tgroup5);
                 
                 final RadioButton        A1             = new RadioButton("A1");  A1.setUserData("A1"); A1.setToggleGroup(Tgroup6);A1.setVisible(false);
                 final RadioButton        A2             = new RadioButton("A2");  A2.setUserData("A2"); A2.setToggleGroup(Tgroup6);A2.setVisible(false);
                 final RadioButton        A3             = new RadioButton("A3");  A3.setUserData("A3"); A3.setToggleGroup(Tgroup6);A3.setVisible(false);
                 final RadioButton        A4             = new RadioButton("A4");  A4.setUserData("A4"); A4.setToggleGroup(Tgroup6);A4.setVisible(false);
     grid.add(StadeA,0,4);   grid.add(A0,1,4); grid.add(A1,2,4); grid.add(A2,3,4); grid.add(A3,4,4); grid.add(A4,5,4);   A1.setSelected(true);
     
           final Label           StadeB            = new Label("STADE");
                 final RadioButton        B0             = new RadioButton("B"); B0.setUserData("B");
                 B0.setToggleGroup(Tgroup5);       B0.setSelected(true);
     grid.add(StadeB, 0,5);  grid.add(B0,1,5);
           
           final Label           StadeC            = new Label("STADE");
                 final RadioButton        C0             = new RadioButton("C"); C0.setUserData("C");
                 C0.setToggleGroup(Tgroup5);
     grid.add(StadeC, 0,6);  grid.add(C0,1,6);    
     
           final Label           StadeD            = new Label("STADE");
                 final RadioButton        D0             = new RadioButton("D"); D0.setUserData("D");
                 D0.setToggleGroup(Tgroup5);
     grid.add(StadeD, 0,7);  grid.add(D0,1,7);
     Tgroup5.selectedToggleProperty().addListener((ObservableValue<? extends Toggle >ov ,Toggle old_value,
     Toggle new_value)-> {
         if(Tgroup5.getSelectedToggle().getUserData().equals("A")){
             A1.setVisible(true); A2.setVisible(true); A3.setVisible(true); A4.setVisible(true);
         }else {
             A1.setVisible(false); A2.setVisible(false); A3.setVisible(false); A4.setVisible(false);
         }
     });
     
     final Label     ClassificationOkuda          = new Label("CLASSIFICATION OKUDA");
     ClassificationOkuda.getStyleClass().add("setStyleClassification");
     grid.add(ClassificationOkuda,0,8);
           final Label            StadeN           = new Label("STADE");
                 final RadioButton N1                 = new RadioButton("1");    N1.setUserData("1");
                 final RadioButton N2                 = new RadioButton("2");    N2.setUserData("2");
                 final RadioButton N3                 = new RadioButton("3");    N3.setUserData("3");
                                                                                 N1.setSelected(true);
                 N1.setToggleGroup(Tgroup2); N2.setToggleGroup(Tgroup2); N3.setToggleGroup(Tgroup2);
     grid.add(StadeN,0,9); grid.add(N1,1,9); grid.add(N2,2,9); grid.add(N3,3,9);
     
     final Label     ClassificationClip            = new Label("CLASSIFICATION CLIP");
     ClassificationClip.getStyleClass().add("setStyleClassification");
            
                 final RadioButton V0                 = new RadioButton("0");      V0.setUserData("0");
                 final RadioButton V1                 = new RadioButton("1");      V1.setUserData("1");
                 final RadioButton V2                 = new RadioButton("2");      V2.setUserData("2");
                                                                                   V0.setSelected(true);
                 V0.setToggleGroup(Tgroup3); V1.setToggleGroup(Tgroup3); V2.setToggleGroup(Tgroup3);
     grid.add(ClassificationClip, 0,10);
     grid.add(V0,1,11); grid.add(V1,2,11); grid.add(V2,3,11);
     
     final Label     ClassificationTnm             = new Label("CLASSIFICATION  TNM");
     ClassificationTnm.getStyleClass().add("setStyleClassification");
             final Label            StadeI           = new Label("STADE");
                 final RadioButton I1                 = new RadioButton("I");      I1.setUserData("I");
                 final RadioButton I2                 = new RadioButton("II");     I2.setUserData("II");
                 final RadioButton I3                 = new RadioButton("IIIA");   I3.setUserData("IIIA");
                 final RadioButton I4                 = new RadioButton("IIIB");   I4.setUserData("IIIB");
                 final RadioButton I5                 = new RadioButton("IIIC");   I5.setUserData("IIIC");
                 final RadioButton I6                 = new RadioButton("IV");     I6.setUserData("IV");
                                                                                   I1.setSelected(true);
                 I1.setToggleGroup(Tgroup4); I2.setToggleGroup(Tgroup4); I3.setToggleGroup(Tgroup4);
                 I4.setToggleGroup(Tgroup4); I5.setToggleGroup(Tgroup4); I6.setToggleGroup(Tgroup4);
     grid.add(ClassificationTnm, 0,12);
     grid.add(StadeI,0,13); grid.add(I1,1,13); grid.add(I2,2,13); grid.add(I3,3,13);
                            grid.add(I4,4,13); grid.add(I5,5,13); grid.add(I6,6,13);
     
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
                    IndIns.setText(" L’insertion des Classifications\n au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Classifications\n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des Classifications  \n au niveau d'un dossier \n  ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(ClassificationChildPughBR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(Ajouter, 8,15); 
        grid.add(IndIns,5,3,4,6);
          ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////  la partie Consultation /////////////////////////////////////////////////////////////////////////////
         final Label ConsClassifChildPugh       = new Label("CLASSIFICATION CHILD-PUGH  stade         :");
         final Label ConsClassifBCLC            = new Label("CLASSIFICATION BCLC        stade         :");
         final Label ConsClassifOkuda           = new Label("CLASSIFIACTION OKUDA       stade         :");
         final Label ConsClassifClip            = new Label("CLASSIFICATION CLIP        stade         :");
         final Label ConsClassificationTnm      = new Label("CLASSIFICATION TNM         stade         :");
     
     final GridPane  gridC                       = new GridPane();
     gridC.setVgap(5); gridC.setHgap(5);
  final Label ClassifLabel         = new Label("Classificaion : ");
  ClassifLabel.getStyleClass().add("setStyleCirconsanceDic");
  gridC.add(ClassifLabel,0,0);	
  gridC.add(ConsClassifChildPugh , 0, 1);           gridC.add(TClassifChildPugh,5,1);
  gridC.add(ConsClassifBCLC , 0, 2);                gridC.add(TClassifBCLC,5,2);
  gridC.add(ConsClassifOkuda, 0, 3);                gridC.add(TClassifOkuda,5,3);
  gridC.add(ConsClassifClip, 0, 4);                 gridC.add(TClassifClip,5,4);
  gridC.add(ConsClassificationTnm,0, 5);            gridC.add(TClassificationTnm,5,5);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
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
      
if(TypeCCP == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        getChildren().add(pane);
        }else {
        final StackPane   paneCons     =  new StackPane();
        this.ConsultationE(NumDossier);
        paneCons.getStyleClass().add("setStylingRootCons");
        gridC.setPadding(new Insets(30,10,10,30));
        gridC.setMinWidth(900);
        gridC.add(barOutil, 6,8,2,2);
        gridC.add(vbMod, 0,8,5,2);
        paneCons.getChildren().add(gridC);
        getChildren().add(paneCons);
        }
     
    }
    

    public String getClassChildPugh() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public String getClassBCLC() {
        if(Tgroup5.getSelectedToggle().getUserData().equals("A")){
            return this.getAType();
        }else 
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }

    public String getAType() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getClassOkuda() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getClassCilp() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getClassTnm() {
        return Tgroup4.getSelectedToggle().getUserData().toString();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
       System.out.println(this.getClassChildPugh()+"\n"+this.getClassBCLC()+"\n"+this.getClassOkuda()+"\n"+
               this.getClassCilp()+"\n"+this.getClassTnm()+"\n");
       
       MiseAjour  bddInsert     =  new MiseAjour();
       int i = bddInsert.AddElement("Insert into Classification values (0,'"+this.getClassChildPugh()+"','"+this.getClassBCLC()+"','"+this.getClassOkuda()+"','"+
               this.getClassCilp()+"','"+this.getClassTnm()+"','"+NumDossier+"')");
    
       return i;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////// Methodes de Consultation /////////////////////////////////////////////////////////////////////////////
     public void setTClassifChildPugh(String a) {
        TClassifChildPugh.setText(a);
    }

    public void setTClassifBCLC(String a) {
        TClassifBCLC.setText(a);
    }

    public void setTClassifOkuda(String a) {
        TClassifOkuda.setText(a);
    }

    public void setTClassifClip(String a) {
        TClassifClip.setText(a);
    }

    public void setTClassificationTnm(String a) {
        TClassificationTnm.setText(a);
    }
    
    public void ConsultationE(String NumDossier) throws SQLException{
        
        ClassificationClasse    Classif = null;
        Consultation bddCons      = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from classification where NumDossier ='"+NumDossier+"'");
        while(res.next()){
            Classif  = new ClassificationClasse(res.getString(2),res.getString(3),res.getString(4),res.getString(5)
            ,res.getString(6));
        }
       try{
   
           
        this.setTClassifChildPugh(Classif.getTClassifChildPugh());
        this.setTClassifBCLC(Classif.getTClassifBCLC());
        this.setTClassifClip(Classif.getTClassifClip());
        this.setTClassifOkuda(Classif.getTClassifOkuda());
        this.setTClassificationTnm(Classif.getTClassificationTnm());
       }catch(Exception e){
        this.setTClassifChildPugh("--------------");
        this.setTClassifBCLC("--------------");
        this.setTClassifClip("--------------");
        this.setTClassifOkuda("--------------");
        this.setTClassificationTnm("--------------");
           
       }
    }
    
    
            public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from Classification where NumDossier ='"+NumDossier+"'" );
            
            return j;
        }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
