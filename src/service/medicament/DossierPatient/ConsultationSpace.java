package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import service.medicament.BilanPatient.BilanBiologique;
import service.medicament.BilanPatient.BilanFOGS;
import service.medicament.BilanPatient.BilanImmunologique;
import service.medicament.BilanPatient.BilanRadiologique.AnapathBR;
import service.medicament.BilanPatient.BilanRadiologique.AutreExamenBR;
import service.medicament.BilanPatient.BilanRadiologique.ClassificationChildPughBR;
import service.medicament.BilanPatient.BilanRadiologique.EchographieDopplerBR;
import service.medicament.BilanPatient.BilanRadiologique.EchographiqueBR;
import service.medicament.BilanPatient.BilanRadiologique.IRMBR;
import service.medicament.BilanPatient.BilanRadiologique.TDMBR;
import service.medicament.Patient.CirconstanceDeDicouvertSpace;
import service.medicament.SGBD.Consultation;
import service.medicament.TraitementProposer.AlcoolisationTR;
import service.medicament.TraitementProposer.ChimieomBolisationBR;
import service.medicament.TraitementProposer.RadioFrequenceBR;
import service.medicament.TraitementProposer.TherapieCibles;
import service.medicament.TraitementProposer.TraitementAntiViralBR;
import service.medicament.TraitementProposer.TraitementProposerBR;


public class ConsultationSpace extends Parent{
    
    
    final String[]    BilanRacineName        = {"Bilan Biologique ","Bilan Immunologique ","Bilan FOGS","Bilan Radiologique",
                                                "Bilan Anapath"};
    final String[][]  BilanFeuilName         = {{"bilan biologique"},{"bilan immunologique"},{"FOGS"},{"Echographie","Echographie doppler","TDM","IRM","Autre Examens"},
                                                {"Anapath"}};
    final String[]    TraitementPFeuillName  = {"Chirurgie","Alcoolisation","Radiofréquence",
                                                "ChimieOembolisation","Therapies Cibles",
                                                "Traitement ANTI-VIRAL"};
    
    final String[]    RacineFName             = {"Bilan","Classification","Traitement Proposer"}; 
    final String[]    ATCD                    = {"ATCDS Personnels","ATCDS Familiaux"};
    ////?????? 
    ////////////////////////
      final HBox  hbConsultPane               = new HBox(5);
      final String NumDossier;
    ////////////////////////
    ////§§§§§§
    final  TreeItem<String>[]    RacineF           = new TreeItem[RacineFName.length];
    final  TreeItem<String>[]    BlanRacine        = new TreeItem[BilanRacineName.length];
    
    final ImageView RootImg           = new ImageView(new Image(getClass().getResourceAsStream("Images/14.jpg")));
    final TreeItem<String> RtreeD   = new TreeItem("Dossier ",RootImg);
    final TreeView<String> tree     = new TreeView<String>(RtreeD);
    final  DropShadow            shadow            = new DropShadow();
    
    public ConsultationSpace(String NumDossier) throws SQLException{
        this.NumDossier = NumDossier;
        
       
        ResultSet resBilanMat[][]      = {{this.ConsultBilan("select DateBilanBiologique from bilanBiologique Where NumDossier =")},
                                        {  this.ConsultBilan("select DateBilanImmunologique from bilanImmunologique   Where NumDossier =")},
                                        {  this.ConsultBilan("select DateBilanFOGD from bilanandoschopique Where NumDossier =")},
                                    {this.ConsultBilan("select DateEchographie from echographie Where NumDossier ="),
                                     this.ConsultBilan("select DateDoppler from echographieDoppler Where NumDossier ="),
                                     this.ConsultBilan("select DateTdm from tdm Where NumDossier ="),
                                     this.ConsultBilan("select DateIrm from irm Where NumDossier ="),
                                     this.ConsultBilan("select DateExamen from autreExamens Where NumDossier =")},
                                        {  this.ConsultBilan("select DateAnapath from bilanAnapath Where NumDossier =")}};
        
        ResultSet TraitTab[]                = {this.ConsultBilan("select DateTrait  from Chirurgie Where NumDossier ="),
                                          this.ConsultBilan("select DateTrait  from Alcoolisation Where NumDossier ="),
                                          this.ConsultBilan("select DateTraitement  from RadioFrequence Where NumDossier ="),
                                          this.ConsultBilan("select DateDeTrait  from chimiOembolisation Where NumDossier ="),
                                          this.ConsultBilan("select DateTrait  from therapiesCibles Where NumDossier ="),
                                          this.ConsultBilan("select DateTrait  from traitementAntiVirale Where NumDossier ="),}; 
        
              
       shadow.setOffsetX(0.05);
        
       shadow.setOffsetY(0.05);
       shadow.setColor(Color.AQUA);
       ///////////////////////////////////////////////////////////////////////////////////
       hbConsultPane.setTranslateY(00);    
       hbConsultPane.setTranslateX(380 );  hbConsultPane.setPrefSize(900,400);
                                           hbConsultPane.setMinWidth(400);
                                           hbConsultPane.setOpacity(0.7);
                                           hbConsultPane.setAlignment(Pos.TOP_LEFT);
       ///////////////////////////////////////////////////////////////////////////////////
        // Traitement des Bilan;
                                           
        
        RootImg.setFitHeight(25); RootImg.setPreserveRatio(true);
        
        //////////
        final ImageView ImageBR           = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageBR.setFitHeight(15); ImageBR.setPreserveRatio(true);
        final TreeItem<String> BilanRoot  = new TreeItem("Bilan ",ImageBR);  
       for(int i=0 ; i<BilanRacineName.length ;i++ ){
            ImageView        ImgRg = new ImageView(new Image(getClass().getResourceAsStream("Images/6.jpg")));
            ImgRg.setFitHeight(20); ImgRg.setPreserveRatio(true);
            TreeItem<String> RootB = BlanRacine[i] = new TreeItem(BilanRacineName[i],ImgRg);
            for(int j = 0;j<BilanFeuilName[i].length;j++){
            ImageView        Imgrg  = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
            Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
            TreeItem<String> ItemB  = new TreeItem(BilanFeuilName[i][j],Imgrg);
            while(resBilanMat[i][j].next()){
                System.out.println(i +" "+ j +  BilanFeuilName[i][j]);
            String DateB   = resBilanMat[i][j].getDate(1).toString();
                System.out.println(DateB);
               TreeItem<String> RootBD =  new TreeItem(BilanFeuilName[i][j]+" Le "+DateB); 
               
               ItemB.getChildren().add(RootBD);
            
            Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
            
            
            }
            RootB.getChildren().add(ItemB);
            }
            
            BilanRoot.getChildren().add(RootB);
        }
       // Traitement des Classifaction 
        final ImageView ImageCR           = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageCR.setFitHeight(15); ImageCR.setPreserveRatio(true);
        final TreeItem<String> ClassRoot  = new TreeItem("Classification",ImageCR);
        for(int i=0 ;i< 1;i++){
            ImageView        Imgrg = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
            
            Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
           TreeItem<String> feuil  = new TreeItem("classification",Imgrg);
           ClassRoot.getChildren().add(feuil);
        }
        /////////////////////
        final ImageView ImageTR            = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageTR.setFitHeight(15);  ImageTR.setPreserveRatio(true);
        final TreeItem<String> TraitPRoot  = new TreeItem("Traitement Propser ",ImageTR);
        for(int i =0 ;i< TraitementPFeuillName.length;i++){
            ImageView        Imgrg = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
            Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
            TreeItem<String> feuil = new TreeItem(TraitementPFeuillName[i],Imgrg);
            System.out.println(i +" "+ TraitementPFeuillName[i].toLowerCase(Locale.FRENCH));
            while(TraitTab[i].next()){
            TreeItem<String> fiche = new TreeItem(TraitementPFeuillName[i].toLowerCase()+" Le "+TraitTab[i].getDate(1).toString());
            feuil.getChildren().add(fiche);
            }
            TraitPRoot.getChildren().add(feuil);
        }
        /////
        final ImageView ImageIR            = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageIR.setFitHeight(15);  ImageIR.setPreserveRatio(true);
        final TreeItem<String> IdentitRoot = new TreeItem("Identite ",ImageIR);
        for(int i =0 ; i<1 ; i++){
         ImageView        Imgrg = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
         Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
         TreeItem<String> feuil = new TreeItem("Identite",Imgrg);
         IdentitRoot.getChildren().add(feuil);
        }
        ////
        final ImageView ImageAR           = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageAR.setFitHeight(15);  ImageAR.setPreserveRatio(true);
        final TreeItem<String> ATCDS = new TreeItem("ATCDS ",ImageAR);
        for(int i =0 ; i<ATCD.length ; i++){
         ImageView     Imgrg    = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
         Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
         TreeItem<String> feuil = new TreeItem(ATCD[i],Imgrg);
         ATCDS.getChildren().add(feuil);
        }
        /////
        final ImageView ImageCIR           = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageCIR.setFitHeight(15);  ImageCIR.setPreserveRatio(true);
        final TreeItem<String> CIR = new TreeItem("Circonstances De Decouverte",ImageCIR);
        for(int i =0 ; i<1 ; i++){
         ImageView     Imgrg    = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
         Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
         TreeItem<String> feuil = new TreeItem("circonstances de decouverte",Imgrg);
         CIR.getChildren().add(feuil);
        }
        
        final ImageView ImageEvo           = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageEvo.setFitHeight(15);  ImageEvo.setPreserveRatio(true);
        final TreeItem<String> Evol = new TreeItem("Evolution ",ImageEvo);
        for(int i =0 ; i<1 ; i++){
         ImageView     Imgrg    = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
         Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
         TreeItem<String> feuil = new TreeItem("evolution",Imgrg);
         Evol.getChildren().add(feuil);
        
        }
        
        final ImageView ImageDec           = new ImageView(new Image(getClass().getResourceAsStream("Images/12.jpg")));
        ImageDec.setFitHeight(15);  ImageDec.setPreserveRatio(true);
        final TreeItem<String> Dec = new TreeItem("Décès",ImageDec);
        for(int i =0 ; i<1 ; i++){
         ImageView     Imgrg    = new ImageView(new Image(getClass().getResourceAsStream("Images/2_1.png")));
         Imgrg.setFitHeight(10); Imgrg.setPreserveRatio(true);
         TreeItem<String> feuil = new TreeItem("décès",Imgrg);
         Dec.getChildren().add(feuil);
        
        }
        RtreeD.getChildren().addAll(IdentitRoot,ATCDS,CIR,BilanRoot,ClassRoot,TraitPRoot,Evol,Dec);
        //////////////////////////////////////////////////////////////////
        tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
                @Override
                public void changed( ObservableValue<? extends TreeItem<String>> observable,
                        TreeItem<String> old_val, TreeItem<String> new_val) {
                    TreeItem<String> selectedItem = new_val;
                    System.out.println("Selected Text : " + selectedItem.getValue());
                    try {
                        Action(selectedItem.getValue(),tree);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConsultationSpace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
        
        //////////////////////////////////////////////////////////////////
        tree.getStyleClass().add("treeStyle");
        tree.setId("Style2");
        tree.setMinWidth(350);
        tree.setMinHeight(150);
        getChildren().addAll(tree);
        getChildren().addAll(hbConsultPane);
        
        this.setTranslateX(10);
        this.setTranslateY(100);
        
       
    }
    
    
    public void Action(String Fonction,TreeView<String> item) throws SQLException{
        if(Fonction.equals("Identite")){
           hbConsultPane.getChildren().clear();
           hbConsultPane.getChildren().add(new ScrollPane(new IdentiteSpace(1,NumDossier)));
        }
        if(Fonction.equals("ATCDS Personnels")){
           hbConsultPane.getChildren().clear();
           hbConsultPane.getChildren().add(new ScrollPane(new ANTCDpersonnelSpace(1,NumDossier))); 
        }
        if(Fonction.equals("ATCDS Familiaux")){
           hbConsultPane.getChildren().clear();
           hbConsultPane.getChildren().add(new ScrollPane(new ANTCDfamiliauxSpace(1,NumDossier))); 
        }
        if(Fonction.equals("circonstances de decouverte")){
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new CirconstanceDeDicouvertSpace(1,NumDossier)));    
        }
        if(Fonction.contains("bilan biologique Le ")){
        System.out.println(Fonction.substring(19));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new BilanBiologique(1,NumDossier,Fonction.substring(19)))); 
        }
        if(Fonction.contains("bilan immunologique Le ")){
        System.out.println(Fonction.substring(23));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new BilanImmunologique(1,NumDossier,Fonction.substring(23)))); 
        }
        if(Fonction.contains("FOGS Le ")){
        System.out.println(Fonction.substring(8));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new BilanFOGS(1,NumDossier,Fonction.substring(8)))); 
        }
        if(Fonction.contains("Echographie Le ")){
        System.out.println(Fonction.substring(15));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new EchographiqueBR(1,NumDossier,Fonction.substring(15)))); 
        }
         if(Fonction.contains("Echographie doppler Le ")){
        System.out.println(Fonction.substring(23));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new EchographieDopplerBR(1,NumDossier,Fonction.substring(23)))); 
        }
         if(Fonction.contains("TDM Le ")){
        System.out.println(Fonction.substring(7));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new TDMBR(1,NumDossier,Fonction.substring(7)))); 
        }
        if(Fonction.contains("IRM Le ")){
        System.out.println(Fonction.substring(7));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new IRMBR(1,NumDossier,Fonction.substring(7)))); 
        }
        if(Fonction.contains("Autre Examens Le ")){
        System.out.println(Fonction.substring(17));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new AutreExamenBR(1,NumDossier,Fonction.substring(17)))); 
        }//classification
        if(Fonction.contains("Anapath Le ")){
        System.out.println(Fonction.substring(11));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new AnapathBR(1,NumDossier,Fonction.substring(11)))); 
        }
        if(Fonction.contains("classification")){
        System.out.println(Fonction.substring(14));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new ClassificationChildPughBR(1,NumDossier,Fonction.substring(14)))); 
        }
        if(Fonction.contains("chirurgie Le ")){
        System.out.println(Fonction.substring(13));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new TraitementProposerBR(1,NumDossier,Fonction.substring(13)))); 
        }
        if(Fonction.contains("alcoolisation Le ")){
        System.out.println(Fonction.substring(17));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new AlcoolisationTR(1,NumDossier,Fonction.substring(17)))); 
        }
        if(Fonction.contains("radiofréquence Le ")){
        System.out.println(Fonction.substring(18));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new RadioFrequenceBR(1,NumDossier,Fonction.substring(18)))); 
        }
        if(Fonction.contains("chimieoembolisation Le ")){
        System.out.println(Fonction.substring(18));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new ChimieomBolisationBR(1,NumDossier,Fonction.substring(23)))); 
        }
        if(Fonction.contains("therapies cibles Le ")){
        System.out.println(Fonction.substring(20));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new TherapieCibles(1,NumDossier,Fonction.substring(20)))); 
        }
        if(Fonction.contains("traitement anti-viral Le ")){
        System.out.println(Fonction.substring(25));
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new TraitementAntiViralBR(1,NumDossier,Fonction.substring(25)))); 
        }
        
        if(Fonction.contains("evolution")){
        
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new EvolutionSpace(NumDossier,1))); 
        }//décès
        if(Fonction.contains("décès")){
        
        hbConsultPane.getChildren().clear();
        hbConsultPane.getChildren().add(new ScrollPane(new DecesSpace(NumDossier,1))); 
        }
    }
    
    public  ResultSet ConsultBilan(String ReqSql) throws SQLException{
 
        Consultation  bddCons    = new Consultation();
        ResultSet res = bddCons.ExtElement(ReqSql+"'"+NumDossier+"'");
        
        return res;
        
    }
    
    
    
}
