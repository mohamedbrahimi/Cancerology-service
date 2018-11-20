
package service.medicament.BilanPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class BilanFOGS extends Parent{
      
      final DatePicker  DateB                  =  new DatePicker();
      final ToggleGroup Tgroup5                =   new ToggleGroup();
      final CheckBox    VaricesCardiales       =   new CheckBox("VARICES S/S CARDIALES ");
      final ToggleGroup Tgroup6                =   new ToggleGroup();
      final TextArea    AutresFOGS             ;
      
      
      final Label       IndIns        = new Label();
      final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
      final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////
       /////////////////////// La Partie Conceptionnelle //////////////////////////////////////////////////////////
             private final Label TDateBilanFOGS      = new Label("------");
             private final Label TFOGD               = new Label("------");
             private final Label TVARICES            = new Label("------");
             private final Label TFOGDSignesRouge    = new Label("------");
             private final Label TAndoscopAutres     = new Label("------");
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////
             
                              /**********/
    final HBox         barOutil            = new HBox(2);

    final Button       EnregButton         = new Button();  
    final ImageView    EnregfImg           = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png")));
    final Button       SuppButton          = new Button();
    final ImageView    SuppImg             = new ImageView(new Image(getClass().getResourceAsStream("Images/7.jpg")));
    
    final VBox         vbMod           = new VBox(5);
    final Label        IndModifS       = new Label();
    final Hyperlink    hperAnnul       = new Hyperlink("Ou Annuler l'opération ... ");
    final ImageView    IndImgS         = new ImageView(new Image(getClass().getResourceAsStream("Images/9_1.jpg")));
    final ImageView    IndImgF         = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg")));

    /**********/
       final String DateInsBilan;    
    public BilanFOGS(int TypeCCP,String NumDossier,String DateInsBilan) throws SQLException{
        
      this.DateInsBilan = DateInsBilan ;  
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
        final Label       DateBilan                               = new Label("Date Bilan Andoschopique ");
        DateB.setDayCellFactory(dayCellFactory);
        DateB.setValue(LocalDate.now());
        
        /////
        //
        ImgSucc.setFitHeight(50);          ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);    ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        //
        /////
        final GridPane       grid    = new GridPane();
        grid.setVgap(5);    grid.setHgap(5);
        
        grid.add(DateBilan,0,0);   grid.add(DateB,1,0);
        
         final Label        FOGD                                    = new Label("FOGD ");
             final  RadioButton      VO1                    = new RadioButton("VO I  "); VO1.setUserData("VO I");
             final  RadioButton      VO2                    = new RadioButton("VO II "); VO2.setUserData("VO II");
             final  RadioButton      VO3                    = new RadioButton("VO III"); VO3.setUserData("VO III");
                                                                                         VO1.setSelected(true);
             VO1.setToggleGroup(Tgroup5); VO2.setToggleGroup(Tgroup5); VO3.setToggleGroup(Tgroup5);
        grid.add(FOGD,0,1);    grid.add(VO1,1,1); grid.add(VO2,2,1); grid.add(VO3,3,1);
       
             
        grid.add(VaricesCardiales, 4,0);
        
        final Label       SignesRouges                            = new Label("SIGNES ROUGES");
              final RadioButton      OuiSignesR             = new RadioButton("Oui");OuiSignesR.setUserData("Oui");
              final RadioButton      NonSignesR             = new RadioButton("Non");NonSignesR.setUserData("Non");
                                                                                     OuiSignesR.setSelected(true);
              OuiSignesR.setToggleGroup(Tgroup6); NonSignesR.setToggleGroup(Tgroup6);
        grid.add(SignesRouges,0,2);  grid.add(OuiSignesR,1,2); grid.add(NonSignesR, 2,2);
        
        
        AutresFOGS  = champSaisierA();
        AutresFOGS.setPrefSize(180,70);  AutresFOGS.setPromptText("Autres");
        grid.add(AutresFOGS,0,3);
        
        ////
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
                    IndIns.setText(" L’insertion du Bilan\n Andoschopique au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Bilans \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des bilan de même type \n au niveau d'un dossier \n sur la même date ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(BilanFOGS.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        grid.add(IndIns,0,5,3,3);
        grid.add(Ajouter, 4,5);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //// lA PARTIE CONCPTUELLE //////
        final GridPane       gridC    = new GridPane();
        gridC.setVgap(5);    gridC.setHgap(5);
        final Label BilanAndoscohpieLab = new Label("Bilan Andoschopique  :");
        BilanAndoscohpieLab.getStyleClass().add("setStyleCirconsanceDic");                       gridC.add(BilanAndoscohpieLab, 0,0);
     final Label ConsDateBilanFOGS      = new Label("Date Bilan FOGD                :" );        gridC.add(ConsDateBilanFOGS,0,1);          gridC.add(TDateBilanFOGS, 5,1);
     final Label ConsFOGD               = new Label("FOGD                           :");         gridC.add(ConsFOGD, 0,2);                  gridC.add(TFOGD, 5,2);
     final Label ConsVARICES            = new Label("VARICES S/S CARDIALES          :");         gridC.add(ConsVARICES, 0,3);               gridC.add(TVARICES, 5,3);
     final Label ConsFOGDSignesRouge    = new Label("SIGNES ROUGES                  :");         gridC.add(ConsFOGDSignesRouge, 0,4);       gridC.add(TFOGDSignesRouge, 5,4);
     final Label ConsAndoscopAutres     = new Label("AUTRES                         :");         gridC.add(ConsAndoscopAutres, 0,5,2,3);    gridC.add(TAndoscopAutres,5,5,2,3);
     ConsAndoscopAutres.setAlignment(Pos.TOP_CENTER);                                            TAndoscopAutres.setAlignment(Pos.TOP_CENTER);
/////////////////////////////////
     /****/
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
       
     /****/
         grid.setPadding(new Insets(30,10,10,30));
         gridC.setPadding(new Insets(30,10,10,30));
        if(TypeCCP == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        getChildren().add(pane);
        }else {
        final StackPane   paneC     =  new StackPane();
        this.ConsultationE(NumDossier);
        gridC.setPrefWidth(900);
        gridC.add(barOutil,5,9,2,1);
        gridC.add(vbMod, 0,9,4,2);
        paneC.getStyleClass().add("setStylingRootCons");
        paneC.getChildren().add(gridC);
        getChildren().add(paneC);  
            
        }
        
     
     }
     public String getValVO() {
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }

    public String getVaricesCardiales() {
        if( VaricesCardiales.isSelected()){
         return "Oui"   ;
        }else return "Non";
    }

    public String getTgroup6() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getAutresFOGS() {
        return AutresFOGS.getText();
    }

    public LocalDate getDateB() {
        return DateB.getValue();
    }

    public int  InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getValVO()+"\n"+this.getVaricesCardiales()+"\n"+this.getTgroup6()+"\n"+this.getAutresFOGS()+"\n"+"\n");
    
        MiseAjour  bddInsert   =  new MiseAjour();
        int i = bddInsert.AddElement("insert into BilanAndoschopique VALUES(0,'"+getValVO()+"','"+
                getVaricesCardiales()+"','"+this.getTgroup6()+"','"+this.getAutresFOGS()+"','"+NumDossier+"','"+this.getDateB()+"')");
        
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////// Les Methodes de La conception   / ////////////////////////////////////////////////////////////////
    
    public void setDateBilanFOGS(String a) {
        TDateBilanFOGS.setText(a);
    }

    public void setFOGD(String a) {
        TFOGD.setText(a);
    }

    public void setVARICES(String a) {
        TVARICES.setText(a);
    }

    public void setFOGDSignesRouge(String a) {
        TFOGDSignesRouge.setText(a);
    }

    public void setAndoscopAutres(String a) {
        TAndoscopAutres.setText(a);
    }
    
    public void ConsultationE(String NumDossier) throws SQLException{
        BilanFOGDClasse    Bilan    = null;
        Consultation   bddCons   = new Consultation();
        ResultSet res  = bddCons.ExtElement("Select * from BilanAndoschopique Where NumDossier = '"+NumDossier+"'"
                + "and DateBilanFOGD = '"+ DateInsBilan+"'");
        while(res.next())
        Bilan  = new BilanFOGDClasse(res.getDate(7),res.getString(2),res.getString(3),res.getString(4)
        ,res.getString(5));
        
        try {
         this.setDateBilanFOGS(Bilan.getDateBilanFOGS().toString());
         this.setFOGD(Bilan.getFOGD());
         this.setVARICES(Bilan.getVARICES());
         this.setFOGDSignesRouge(Bilan.getFOGDSignesRouge());
         this.setAndoscopAutres(Bilan.getAndoscopAutres());  
        }catch (Exception e){
         this.setDateBilanFOGS("-----------");
         this.setFOGD("-----------");
         this.setVARICES("-----------");
         this.setFOGDSignesRouge("-----------");
         this.setAndoscopAutres("-----------"); 
        }
        
    }
    
          public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from BilanAndoschopique where NumDossier ='"+NumDossier+"' and dateBilanFOGD ='"+DateInsBilan+"'" );
            
            return j;
        }
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
}
