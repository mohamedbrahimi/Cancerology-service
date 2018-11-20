
package service.medicament.BilanPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.text.Text;
import javafx.util.Callback;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

  
public final class BilanImmunologique extends Parent{
      
       final DatePicker  DateB   =  new DatePicker();
       final ToggleGroup Tgroup1 =  new ToggleGroup();
       final ToggleGroup Tgroup2 =  new ToggleGroup();
       final ToggleGroup Tgroup3 =  new ToggleGroup(); 
       final ToggleGroup Tgroup4 =  new ToggleGroup(); 
       final TextArea    Autre   ;
       
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
       
       ////////////////////////////////////////////////////////////////////////////////////////////////////////////
       /////////////////////// La Partie Conceptionnelle //////////////////////////////////////////////////////////
             private final Label TDateBilanImmunologique      = new Label("------");
             private final Label TAcAntiNucleaires            = new Label("------");
             private final Label TAcAntimuscles               = new Label("------");
             private final Label TAcAntimitochondries         = new Label("------");
             private final Label TAcAntiLMK1                  = new Label("------");
             private final Label TAutres                       = new Label("------");
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
    public BilanImmunologique(int TypeCCP,String NumDossier,String DateInsBilan ) throws SQLException{
        
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
          GridPane grid                         = new GridPane();
          grid.setVgap(5); grid.setHgap(7);
        
        final Label       DateBilan                               = new Label("Date Bilan Immunologique ");
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
        grid.add(DateBilan, 0,0);   grid.add(DateB,1,0); DateB.setValue(LocalDate.now());
        final Label       AcAntiNucleaires                        = new Label("Ac anti nucleaires ");
              final RadioButton       OuiNuc                 = new RadioButton("Oui");   OuiNuc.setUserData("Oui");
              final RadioButton       NonNuc                 = new RadioButton("Non");   NonNuc.setUserData("Non");
                                                                                         OuiNuc.setSelected(true);
              OuiNuc.setToggleGroup(Tgroup1); NonNuc.setToggleGroup(Tgroup1);
        grid.add(AcAntiNucleaires, 0,1);  grid.add(OuiNuc,1,1); grid.add(NonNuc,2,1);
        
        final Label       AcAntiMuscles                           = new Label("Ac antimuscles lisses ");
              final RadioButton       OuiMuscle              = new RadioButton("Oui");   OuiMuscle.setUserData("Oui");
              final RadioButton       NonMuscle              = new RadioButton("Non");   NonMuscle.setUserData("Non");
                                                                                         OuiMuscle.setSelected(true);
              OuiMuscle.setToggleGroup(Tgroup2); NonMuscle.setToggleGroup(Tgroup2);
       grid.add(AcAntiMuscles,0,2);       grid.add(OuiMuscle,1,2); grid.add(NonMuscle,2,2);
       
        final Label       AcAntimitochondries                     = new Label("Ac antimitochondries   ");
              final RadioButton       OuiMitocho              = new RadioButton("Oui");   OuiMitocho.setUserData("Oui");
              final RadioButton       NonMitocho              = new RadioButton("Non");   NonMitocho.setUserData("Non");
                                                                                          OuiMitocho.setSelected(true);
              OuiMitocho.setToggleGroup(Tgroup3); NonMitocho.setToggleGroup(Tgroup3);
       grid.add(AcAntimitochondries,0,3);       grid.add(OuiMitocho,1,3); grid.add(NonMitocho,2,3);
       
        final Label       AcAntiLMK1                              = new Label("Ac anti LMK1 ");
              final RadioButton       OuiLMK1              = new RadioButton("Oui"); OuiLMK1.setUserData("Oui");
              final RadioButton       NonLMK1              = new RadioButton("Non"); NonLMK1.setUserData("Non");
                                                                                     OuiLMK1.setSelected(true);
              OuiLMK1.setToggleGroup(Tgroup4); NonLMK1.setToggleGroup(Tgroup4);
       grid.add(AcAntiLMK1,0,4);       grid.add(OuiLMK1,1,4); grid.add(NonLMK1,2,4);
       
       
       Autre  = champSaisierA();
       Autre.setPromptText("Autre ");
       Autre.setPrefSize(180,70);
       grid.add(Autre,0,5);
       
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
        Ajouter.setOnAction((ActionEvent)-> {
              try {
                  int i = this.InsertionSGBD(NumDossier);
                   if(i == 1){
                    IndIns.setGraphic(ImgSucc); IndIns.getStyleClass().remove("erreurchamp");
                    IndIns.setText(" L’insertion du Bilan\n Immunologique au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Bilans \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des bilan de même type \n au niveau d'un dossier \n sur la même date ");
                   }
              } catch (SQLException ex) {
                  Logger.getLogger(BilanImmunologique.class.getName()).log(Level.SEVERE, null, ex);
              }
            
        });
        Ajouter.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            Ajouter.setScaleX(1);
            Ajouter.setScaleY(1);
            Ajouter.setEffect(null);   
            }
        });
        grid.add(IndIns,5,0,5,5);
        grid.add(Ajouter, 5,5);
       ////
       /////////////////////////////////////////////////////////////////////////////////////////////////////////
       ////  La Partie De La Conception ////////////////////////////////////////////////////////////////////////
        GridPane gridC                         = new GridPane();
          gridC.setVgap(5); gridC.setHgap(7);
                   final Label BilanImmLabel              = new Label("Bilan Immunologique :");                      gridC.add(BilanImmLabel, 0,0);
                 BilanImmLabel.getStyleClass().add("setStyleCirconsanceDic");                               
              final Label ConsDateBilanImmunologique      = new Label("Date Bilan                     : ");          gridC.add(ConsDateBilanImmunologique, 0,1);        gridC.add(TDateBilanImmunologique,5,1);
              final Label ConsAcAntiNucleaires            = new Label("Ac anti nucleaires             : ");          gridC.add(ConsAcAntiNucleaires, 0,2);              gridC.add(TAcAntiNucleaires, 5,2);
              final Label ConsAcAntimuscles               = new Label("Ac antimuscles lisses          : ");          gridC.add(ConsAcAntimuscles, 0,3);                 gridC.add(TAcAntimuscles, 5,3);
              final Label ConsAcAntimitochondries         = new Label("Ac antimitochondries           : ");          gridC.add(ConsAcAntimitochondries,0,4);            gridC.add(TAcAntimitochondries,5,4);
              final Label ConsAcAntiLMK1                  = new Label("Ac anti LMK1                   : ");          gridC.add(ConsAcAntiLMK1,0,5);                     gridC.add(TAcAntiLMK1, 5,5);
              final Label ConsAutres                      = new Label("Autres                         : ");          gridC.add(ConsAutres, 0,6,2,3);                        gridC.add(TAutres, 5,6,2,3);
       /////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        
       
         grid.setPadding(new Insets(30,10,10,30));
         gridC.setPadding(new Insets(30,10,10,30));
         if(TypeCCP == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        pane.getChildren().add(grid);
        getChildren().add(pane);
         } else {
        final StackPane   paneC     =  new StackPane();
        this.ConsultationE(NumDossier);
        paneC.getStyleClass().add("setStylingRootCons");
        gridC.setPrefWidth(900);
        gridC.add(barOutil,4,9,3,1);
        gridC.add(vbMod,0,9,4,2);
        paneC.getChildren().add(gridC);
        getChildren().add(paneC ); 
         }
    }
     public String getAntiNucl() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public String getAntiMuscl() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String getAntiMithocond() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getAntiLMK1() {
        return Tgroup4.getSelectedToggle().getUserData().toString();
    }

    public String getAutre() {
        return Autre.getText();
    }
   
    public LocalDate getDateB() {
        return DateB.getValue();
    }
    public int InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getAntiNucl()+"\n"+this.getAntiMuscl()+"\n"+this.getAntiMithocond()+"\n"+
                this.getAntiLMK1()+"\n"+this.getAutre()+"\n"+"\n");
        
        MiseAjour  bddInsert      =  new MiseAjour();
        int i = bddInsert.AddElement("insert into BilanImmunologique values(0,'"+this.getAntiNucl()+"','"+this.getAntiMuscl()+"','"+
                this.getAntiMithocond()+"','"+this.getAntiLMK1()+"','"+this.getAutre() +"','"+NumDossier+"','"+this.getDateB()+"')");
       
        
        return i ;
    }
     public TextArea champSaisierA(){
 TextArea textA = new TextArea(){
            
            public void replaceText(int start , int end , String text){
                if(!text.matches("[',]")){
                    super.replaceText(start, end, text);
                   
                }
              
            }
           
         

            
 };   

   return textA;  
    
}
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     ////////La  partie Conceptuelle       //////////////////////////////////////////////////////////////////////////
    
    public void setTDateBilanImmunologique(String a) {
        TDateBilanImmunologique.setText(a);
    }

    public void setTAcAntiNucleaires(String a) {
        TAcAntiNucleaires.setText(a);
    }

    public void setTAcAntimuscles(String a) {
        TAcAntimuscles.setText(a);
    }

    public void setTAcAntimitochondries(String a) {
        TAcAntimitochondries.setText(a);
    }

    public void setTAcAntiLMK1(String a) {
        TAcAntiLMK1.setText(a);
    }

    public void setTAutres(String a) {
        TAutres.setText(a);
    }
    
    public void ConsultationE(String NumDossier) throws SQLException{
        BilanImmunologiqueClasse    Bilan    = null;
        Consultation   bddCons   = new Consultation();
        ResultSet res  = bddCons.ExtElement("Select * from BilanImmunologique Where NumDossier = '"+NumDossier+"'"
                + "and DateBilanImmunologique = '"+ DateInsBilan+"'");
      
       while(res.next())
       Bilan   = new BilanImmunologiqueClasse(res.getDate(8),res.getString(2),res.getString(3),res.getString(4)
       ,res.getString(5),res.getString(6));
       try{
       this.setTDateBilanImmunologique(Bilan.getDateBilanImmunologique().toString());
       this.setTAcAntiNucleaires(Bilan.getAcAntiNucleaires());
       this.setTAcAntimitochondries(Bilan.getAcAntimitochondries());
       this.setTAcAntiLMK1(Bilan.getAcAntiLMK1());
       this.setTAcAntimuscles(Bilan.getAcAntimuscles());
       this.setTAutres(Bilan.getAutres());
       }catch(Exception e){
           
       this.setTDateBilanImmunologique("-----------");
       this.setTAcAntiNucleaires("-----------");
       this.setTAcAntimitochondries("-----------");
       this.setTAcAntiLMK1("-----------");
       this.setTAcAntimuscles("-----------");
       this.setTAutres("-----------");  
       }
    }
    
      public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from BilanImmunologique where NumDossier ='"+NumDossier+"' and dateBilanImmunologique ='"+DateInsBilan+"'" );
            
            return j;
        }
    
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
}
