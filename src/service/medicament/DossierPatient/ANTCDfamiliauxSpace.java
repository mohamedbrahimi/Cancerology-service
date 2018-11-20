
package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class ANTCDfamiliauxSpace extends Parent {
    
    final  Label    HepatopathieVF           =  new Label("Hepatopathie virale dans la famille ");

           final    RadioButton       OuiHF     = new RadioButton("Oui");
           final    RadioButton       NonHF     = new RadioButton("Non");
           final ToggleGroup Tgroup1 = new ToggleGroup();
           
           final    RadioButton       OuiNF     = new RadioButton("Oui");
           final    RadioButton       NonNF     = new RadioButton("Non");
           final ToggleGroup Tgroup2 = new ToggleGroup();   
           final    TextArea          precisTV  ;
           
           final  TextArea NeoplasieDF              ;
           final  TextArea Autre                    ;
           
           //////////////////////////////////////////////////////////////////////////////////////////////////
           /////Partie Consultation//////////////////////////////////////////////////////////////////////////
           private Label ConsHepatovirale        = new Label("--------");
           private Label ConsTypeHepato          = new Label("--------"); 
           private Label ConsNplsm               = new Label("--------");
           private Label ConsNeoplasme           = new Label("--------");
           private Label ConsAutreAtcd           = new Label("--------");
           //////////////////////////////////////////////////////////////////////////////////////////////////
           
           
           /**************************************************************************************************/
           //////// Partie Modification ///////////////////////////////////////////////////////////////////////
   final TextField ConsHepatoviraleMod        ; 
   final TextField ConsTypeHepatoMod          ; 
   final TextField ConsNplsmMod               ;
   final TextField ConsNeoplasmeMod           ;    
   final TextArea  ConsAutreAtcdMod           ;
           //////////////////////////////////////////Partie Modification///////////////////////////////////////
           final HBox         barOutil            = new HBox(2);
    final Button       ModifButton         = new Button();
    final ImageView    ModifImg            = new ImageView(new Image(getClass().getResourceAsStream("Images/15.jpg")));
    final Button       EnregButton         = new Button();  
    final ImageView    EnregfImg           = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png")));
    final Button       SuppButton          = new Button();
    final ImageView    SuppImg             = new ImageView(new Image(getClass().getResourceAsStream("Images/1_1.jpg")));
    
    final VBox         vbMod           = new VBox(5);
    final Label        IndModifS       = new Label();
    final Hyperlink    hperAnnul       = new Hyperlink("Ou Annuler l'opération ... ");
    final ImageView    IndImgS         = new ImageView(new Image(getClass().getResourceAsStream("Images/31.jpg")));
    final ImageView    IndImgF         = new ImageView(new Image(getClass().getResourceAsStream("Images/38.jpg")));
    
    int TypeMod  = 0;
    int DejaMode = 0;
           ////////////////////////////////////////////////////////////////////////////////////////////////////
    
           final Label       IndIns        = new Label();
           final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
           final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
       
    public ANTCDfamiliauxSpace(int TypeCCP,String NumDossier) throws SQLException{
        /*****************************************************************************/
        
        
     ConsHepatoviraleMod        = this.champSaisier(); 
     ConsTypeHepatoMod          = this.champSaisier(); 
     ConsNplsmMod               = this.champSaisier();
     ConsNeoplasmeMod           = this.champSaisier();    
     ConsAutreAtcdMod           = this.champSaisierA();
            vbMod.setVisible(false);
    ModifImg.setFitHeight(50);   ModifImg.setPreserveRatio(true);
    ModifButton.setGraphic(ModifImg);
    EnregfImg.setFitHeight(50);  EnregfImg.setPreserveRatio(true); EnregButton.setDisable(true);
    EnregButton.setGraphic(EnregfImg);
    SuppImg.setFitHeight(50);    SuppImg.setPreserveRatio(true);
    SuppButton.setGraphic(SuppImg);
    barOutil.getChildren().addAll(ModifButton,SuppButton,EnregButton);
    barOutil.getStyleClass().add("barOutil");
    
    IndImgS.setFitHeight(50); IndImgS.setPreserveRatio(true);
    IndImgF.setFitHeight(50); IndImgF.setPreserveRatio(true);
    
    vbMod.getChildren().addAll(IndModifS,hperAnnul);
    
        /***/
        /////
        //   
        ImgSucc.setFitHeight(50);          ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);    ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        //
        ///// 
           final    GridPane    grid   = new GridPane(); 
           grid.setVgap(5);
           grid.setHgap(7);
           
           grid.add(HepatopathieVF,0, 0,2,1);
           
           OuiHF.setToggleGroup(Tgroup1);OuiHF.setUserData("Oui"); OuiHF.setSelected(true);
           grid.add(OuiHF,2,0);
           NonHF.setToggleGroup(Tgroup1);NonHF.setUserData("Non");
           grid.add(NonHF, 3,0);
           
           precisTV   = champSaisierA();
           precisTV.setPromptText(" (préciser type)  ");
           precisTV.setPrefHeight(50);
           precisTV.setPrefWidth(150);
           grid.add(precisTV,0,1);
           Tgroup1.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov,Toggle old_value,
           Toggle new_value)-> {
               if(Tgroup1.getSelectedToggle().getUserData().equals("Oui")){
                 grid.getChildren().add(precisTV);  
               }else {
                 grid.getChildren().remove(precisTV); precisTV.setText("");
               }
               
           });
           
           OuiNF.setToggleGroup(Tgroup2);OuiNF.setUserData("Oui"); OuiNF.setSelected(true);
           NonNF.setToggleGroup(Tgroup2);NonNF.setUserData("Non");

          
           final Label NplsmLab    = new Label("Néoplasie dans la famille ");
           grid.add(NplsmLab,0, 2);   grid.add(OuiNF, 1,2); grid.add(NonNF, 2,2);
           
           NeoplasieDF  = champSaisierA();
           NeoplasieDF.setPromptText("Néoplasie dans la famille (préciser)");
           NeoplasieDF.setPrefHeight(50);
           NeoplasieDF.setPrefWidth(150);
           grid.add(  NeoplasieDF, 0,3);
           
           Tgroup2.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov,Toggle old_value,
           Toggle new_value)-> {
               if(Tgroup2.getSelectedToggle().getUserData().equals("Oui")){
                   NeoplasieDF.setVisible(true);
               }else {
                   NeoplasieDF.setVisible(false);   NeoplasieDF.setText("");
               }
               
           });
           
           Autre  = champSaisierA();
           Autre.setPromptText(" Autre ");
           Autre.setPrefHeight(50);
           Autre.setPrefWidth(150);
           grid.add(Autre, 0,4);
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
               try {//ImgSucc  ImgFaild   IndIns
                   int i = this.InsertionSGBD(NumDossier);
                   if(i == 1){
                    IndIns.setGraphic(ImgSucc); IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion des ATCDS\n Familiaux au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des ATCDS\n Familiaux est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des ATCDS au niveau\n d'un dossier   ");
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(ANTCDfamiliauxSpace.class.getName()).log(Level.SEVERE, null, ex);
               }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////partie Consultation  //////////////////////////////////////////////////////////////////////
         final    GridPane    gridC   = new GridPane(); 
         gridC.setVgap(5);
         gridC.setHgap(7);
         final Label ATCDfCons           = new Label("ATCDS Familiaux ");                            gridC.add(ATCDfCons, 0,0);   ATCDfCons.getStyleClass().add("setStyleCirconsanceDic");
         final Label Hepatovirale        = new Label("Hepatopathie virale dans la famille   :");     gridC.add(Hepatovirale,0,1); gridC.add(ConsHepatovirale,1,1);
         final Label TypeHepato          = new Label("préciser type                         :");     gridC.add(TypeHepato, 0,2);  gridC.add(ConsTypeHepato, 1,2);
         final Label NplsmAff            = new Label("Néoplasie dans la famille             :");     gridC.add(NplsmAff , 0,3);   gridC.add(ConsNplsm, 1,3);
         final Label Neoplasme           = new Label("Néoplasie dans la famille (Preciser)  :");     gridC.add(Neoplasme,0,4);    gridC.add(ConsNeoplasme,1,4);
         final Label AutreAtcd           = new Label("Autres                                :");     gridC.add(AutreAtcd,0,5);    gridC.add(ConsAutreAtcd,1,5);
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        grid.add(IndIns,5,0,4,4);
        grid.add(Ajouter, 5,5);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /******** la Partie Modification**************************************************************************///
      final ImageView ImgEnregMod    = new ImageView(new Image(getClass().getResourceAsStream("Images/20_1.jpg")));
      ImgEnregMod.setFitHeight(40); ImgEnregMod.setPreserveRatio(true);
      
      final ImageView ImgEnregSup   = new ImageView(new Image(getClass().getResourceAsStream("Images/12_1.jpg")));
      ImgEnregSup.setFitHeight(40); ImgEnregSup.setPreserveRatio(true);
        ModifButton.setOnAction((ActionEvent)->{
            TypeMod = 1;
            gridC.getChildren().removeAll(ConsHepatovirale,ConsTypeHepato,ConsNeoplasme,ConsAutreAtcd,ConsNplsm);
                            gridC.add(ConsHepatoviraleMod,1,1);     ConsHepatoviraleMod.setMaxWidth(200);
			    gridC.add(ConsTypeHepatoMod, 1,2);      ConsTypeHepatoMod.setMaxWidth(200);
                            gridC.add(ConsNplsmMod, 1,3);
			    gridC.add(ConsNeoplasmeMod,1,4);        ConsNeoplasmeMod.setMaxWidth(200);
			    gridC.add(ConsAutreAtcdMod,1,5);        ConsAutreAtcdMod.setMaxWidth(200); ConsAutreAtcdMod.setMaxHeight(70);
        
        ModifChamp();
         hperAnnul.setVisible(true);
    
    EnregButton.setDisable(false);
    ModifButton.setDisable(true);
    
    
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer les Modification");
    IndModifS.setGraphic(ImgEnregMod);
    vbMod.setVisible(true);
    
    DejaMode = 1;
        });
    /***/
     IndModifS.getStyleClass().add("erreurchamp");
     SuppButton.setOnAction((ActionEvent)->{
         hperAnnul.setVisible(true);
         
       TypeMod = 0;
    IndModifS.setText("Appuyez sur l'icon d'enregistrement \n pour effectuer la Suppression du document");
    IndModifS.setGraphic(ImgEnregSup);
    vbMod.setVisible(true);
    EnregButton.setDisable(false);
        
    });
    /****/
        hperAnnul.setOnAction((ActionEvent)->{
        if(DejaMode == 1){
             gridC.getChildren().removeAll(ConsHepatoviraleMod,ConsTypeHepatoMod,ConsNeoplasmeMod,ConsAutreAtcdMod,ConsNplsmMod);
             
              gridC.getChildren().addAll(ConsHepatovirale,ConsTypeHepato,ConsNeoplasme,ConsAutreAtcd,ConsNplsm);
        
        DejaMode = 0;
        }
     vbMod.setVisible(false);
     EnregButton.setDisable(true);
     ModifButton.setDisable(false);
        
        });   
        /****/
     EnregButton.setOnAction((ActionEvent)->{
        hperAnnul.setVisible(false);
       if(TypeMod == 1){
         try {
            int j = this.UpdateSGBD(NumDossier);
            //this.requestParentLayout();
            
            gridC.getChildren().removeAll(ConsHepatoviraleMod,ConsTypeHepatoMod,ConsNeoplasmeMod,ConsAutreAtcdMod);
            this.ConsultationE(NumDossier);
            gridC.getChildren().addAll(ConsHepatovirale,ConsTypeHepato,ConsNeoplasme,ConsAutreAtcd);
            
             EnregButton.setDisable(true);
             ModifButton.setDisable(false);
             if(j==1){
             IndModifS.setText("Les Modification sont Enregistrées ");
             IndModifS.setGraphic(IndImgS);
             }else{
               IndModifS.setText("doncument n'est pas enregistré ");
               IndModifS.setGraphic(IndImgF);  
             }
             
         } catch (SQLException ex) {
            Logger.getLogger(ANTCDpersonnelSpace.class.getName()).log(Level.SEVERE, null, ex);
        } } else {
           
           try {
               int j = this.DeleteSGBD(NumDossier);
               this.ConsultationE(NumDossier);
               if(j == 1){
               IndModifS.setText("Le Document est Supprimé ");
             IndModifS.setGraphic(IndImgS);
               }else
               { IndModifS.setText("doncument n'est pas enregistré ");
               IndModifS.setGraphic(IndImgF);
                   
                }
           
           } catch (SQLException ex) {
               Logger.getLogger(ANTCDpersonnelSpace.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        
    } );
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////    
           ///
           
            grid.setPadding(new Insets(30,10,10,30));
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
        gridC.add(barOutil,8,6,3,1);
        gridC.add(vbMod,0,6,3,1);
        //barOutil.setTranslateX(100);
        gridC.setMinWidth(900);
        paneCons.getChildren().add(gridC);
        getChildren().add(paneCons);
        }
    }
    
    public String getHF() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }


    public String getPrecisTV() {
        return precisTV.getText();
    }

    public String getNplsm() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    
    public String getNeoplasieDF() {
        return NeoplasieDF.getText();
    }

    public String getAutre() {
        return Autre.getText();
    }
    
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getHF()+"\n"+this.getPrecisTV()+"\n"+this.getNeoplasieDF()+"\n"+this.getAutre());
        MiseAjour  bddInsert    =  new MiseAjour();
       int i = bddInsert.AddElement("Insert into atcdsfamiliale values (0,'"+getHF()+"','"+getPrecisTV()+"','"+getNeoplasieDF()+"','"+
        getAutre()+"','"+NumDossier+"','"+this.getNplsm()+"')");
        
        return i ;
    }
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
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////***les Methodes de la Consultation***********************///////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public void setConsHepatovirale(String ConsHepatovirale) {
        this.ConsHepatovirale.setText(ConsHepatovirale);
    }

    public void setConsTypeHepato(String ConsTypeHepato) {
        this.ConsTypeHepato.setText(ConsTypeHepato);
    }
    
    public void setConsNplsm(String Nplsm){
        this.ConsNplsm.setText(Nplsm);
    }

    public void setConsNeoplasme(String ConsNeoplasme) {
        this.ConsNeoplasme.setText(ConsNeoplasme);
    }

    public void setConsAutreAtcd(String ConsAutreAtcd) {
        this.ConsAutreAtcd.setText(ConsAutreAtcd);
    }
    
    
    public void ConsultationE(String NumDossier) throws SQLException{
        
        ANTCDfamiliauxClasse    ANTCDf = null;
        Consultation bddCons      = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from atcdsfamiliale where NumDossier ='"+NumDossier+"'");
        while(res.next()){
            ANTCDf  = new ANTCDfamiliauxClasse(res.getString(2),res.getString(3),res.getString(7),res.getString(4),res.getString(5));
    } 
    try{
        this.setConsHepatovirale(ANTCDf.getHepatovirale());
        this.setConsNplsm(ANTCDf.getNplsm());
        this.setConsNeoplasme(ANTCDf.getNeoplasme());
        this.setConsTypeHepato(ANTCDf.getTypeHepato());
        this.setConsAutreAtcd(ANTCDf.getAutreAtcd());
    }catch(Exception e){
        this.setConsHepatovirale("------");
        this.setConsNplsm("------");
        this.setConsNeoplasme("------");
        this.setConsTypeHepato("------");
        this.setConsAutreAtcd("------");
    }
    bddCons.CloseConnex();
    
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
    /////****************************** Partie Modification//////////////////////////////////////////////////////////
     public String getConsHepatoviraleMod() {
        return ConsHepatoviraleMod.getText();
    }

    public String getConsTypeHepatoMod() {
        return ConsTypeHepatoMod.getText();
    }

    public String getConsNplsm() {
        return ConsNplsmMod.getText();
    }

    
    public String getConsNeoplasmeMod() {
        return ConsNeoplasmeMod.getText();
    }

    public String getConsAutreAtcdMod() {
        return ConsAutreAtcdMod.getText();
    }
    /****/
        public void setConsHepatoviraleMod() {      
        ConsHepatoviraleMod.setText(ConsHepatovirale.getText());
    }

    public void setConsTypeHepatoMod() {
        ConsTypeHepatoMod.setText(ConsTypeHepato.getText());
    }

    public void setConsNplsmMod() {
        ConsNplsmMod.setText(ConsNplsm.getText());
    }

    
    public void setConsNeoplasmeMod() {
        ConsNeoplasmeMod.setText(ConsNeoplasme.getText());
    }
        //setConsHepatoviraleMod();setConsTypeHepatoMod();setConsNeoplasmeMod();setConsAutreAtcdMod()
    public void setConsAutreAtcdMod() {
        ConsAutreAtcdMod.setText(ConsAutreAtcd.getText());
    }
    
    /******/
    public void ModifChamp(){
        setConsHepatoviraleMod();setConsTypeHepatoMod();setConsNeoplasmeMod();setConsAutreAtcdMod();
    }
    
     public int UpdateSGBD(String NumDossier) throws SQLException{
       
        MiseAjour  bddUpdate        = new MiseAjour();
        int j =bddUpdate.AddElement("update atcdsfamiliale set hepatovirale = '"+this.getConsHepatoviraleMod()+"',TypeHepato = '"+this.getConsTypeHepatoMod()+
                                    "',Neoplasme ='"+this.getConsNeoplasmeMod()+"',AutreAtcd ='"+this.getConsAutreAtcdMod()+"' where NumDossier ='"+NumDossier+"'" );
    return j;
    
    }
    
        public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from atcdsfamiliale where NumDossier ='"+NumDossier+"'");
            
            return j;
        }
        
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
