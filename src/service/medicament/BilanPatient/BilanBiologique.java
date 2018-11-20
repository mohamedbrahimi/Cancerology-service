
package service.medicament.BilanPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.ScrollPane;
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
import javafx.scene.text.Text;
import javafx.util.Callback;
import service.medicament.DossierPatient.ANTCDpersonnelSpace;
import service.medicament.SGBD.Consultation;
import service.medicament.SGBD.MiseAjour;

public final class BilanBiologique extends Parent {
    
    
    
              final DatePicker  DateB    = new DatePicker(); 
              final ToggleGroup Tgroup1  =  new ToggleGroup();
              final ToggleGroup Tgroup2  =  new ToggleGroup();
              final ToggleGroup Tgroup3  =  new ToggleGroup();
              final ToggleGroup Tgroup4  =  new ToggleGroup();
              final ToggleGroup Tgroup5  =  new ToggleGroup();
              final ToggleGroup Tgroup6  =  new ToggleGroup();
              final ToggleGroup Tgroup7  =  new ToggleGroup();
              final ToggleGroup Tgroup8  =  new ToggleGroup();
              final ToggleGroup Tgroup9  =  new ToggleGroup();
              final ToggleGroup Tgroup10 =  new ToggleGroup();
              final ToggleGroup Tgroup11 =  new ToggleGroup();
              final ToggleGroup Tgroup12 =  new ToggleGroup();
              final ToggleGroup Tgroup13 =  new ToggleGroup();
              final ToggleGroup Tgroup14 =  new ToggleGroup();
              final ToggleGroup Tgroup15 =  new ToggleGroup();
              final ToggleGroup Tgroup16 =  new ToggleGroup();
              final ToggleGroup Tgroup17 =  new ToggleGroup();
              final ToggleGroup Tgroup18 =  new ToggleGroup();
              final ToggleGroup Tgroup19 =  new ToggleGroup(); 
              final ToggleGroup Tgroup20 =  new ToggleGroup();
              final ToggleGroup Tgroup21 =  new ToggleGroup();
              final ToggleGroup Tgroup34 =  new ToggleGroup();
              final ToggleGroup Tgroup35 =  new ToggleGroup();
              final ToggleGroup Tgroup22 =  new ToggleGroup();
              final ToggleGroup Tgroup23 =  new ToggleGroup();
              final ToggleGroup Tgroup24 =  new ToggleGroup();
              final ToggleGroup Tgroup25 =  new ToggleGroup();
              final ToggleGroup Tgroup26 =  new ToggleGroup();
              final ToggleGroup Tgroup27 =  new ToggleGroup();
              final ToggleGroup Tgroup29 =  new ToggleGroup();
              final ToggleGroup Tgroup30 =  new ToggleGroup();
              final ToggleGroup Tgroup31 =  new ToggleGroup();
              final ToggleGroup Tgroup32 =  new ToggleGroup();
              final ToggleGroup Tgroup33 =  new ToggleGroup();
              final ToggleGroup Tgroup36 =  new ToggleGroup();
              
              
              ////////////////////////////////////////////////////////////////////////////////////////////////////
              //////////////////////////***partie consltation ********************************////////////////////
    private final Label  TDateBilanBiologique     = new Label();
    private final Label  TGroupSang               = new Label();
    private final Label  TTypeH                   = new Label();
    private final Label  THb                      = new Label();
    private final Label  TGB                      = new Label();
    private final Label  TPlaq                    = new Label();
    private final Label  TTP                      = new Label();
    private final Label  TFacteurV                = new Label();
    private final Label  TSGOT                    = new Label();
    private final Label  TSGPT                    = new Label();
    private final Label  TBT                      = new Label();
    private final Label  TBD                      = new Label();
    private final Label  TGGT                     = new Label();
    private final Label  TPAL                     = new Label();
    private final Label  TVS                      = new Label();
    private final Label  TUree                    = new Label();
    private final Label  TCreatinine              = new Label();
    private final Label  TAlbuminémie             = new Label();
    private final Label  TCalcemie                = new Label();
    private final Label  TCholesterol             = new Label();
    private final Label  TTryglycérides           = new Label();
    private final Label  THVC                     = new Label();
    private final Label  THVCChargeVirale         = new Label();
    private final Label  THVCGenotype             = new Label();
    private final Label  TAgHBs                   = new Label();
    private final Label  TAgHBe                   = new Label();
    private final Label  TAcHBe                   = new Label();
    private final Label  TAcHBs                   = new Label();
    private final Label  TAcHBc                   = new Label();
    private final Label  THBChargeVirale          = new Label();
    private final Label  THBGenotype              = new Label();
    private final Label  THVD                     = new Label();
    private final Label  THIV                     = new Label();
    private final Label  TAFP                     = new Label();
    private final Label  TACE                     = new Label();
    private final Label  TCA                      = new Label(); 
    
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
              ////////////////////////////////////////////////////////////////////////////////////////////////////
              ////////////////////////////////////////////////////////////////////////////////////////////////////
       final Label       IndIns        = new Label();
       final ImageView   ImgSucc       = new ImageView(new Image(getClass().getResourceAsStream("Images/6_1.jpg")));
       final ImageView   ImgFaild      = new ImageView(new Image(getClass().getResourceAsStream("Images/42.jpg")));
       
    final String DateInsBilan;
    public BilanBiologique(int TypeCCP,String NumDossier,String DateInsBilan ) throws SQLException{
        /////
        // 
        
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
        this.DateInsBilan = DateInsBilan;
        
        ImgSucc.setFitHeight(50);          ImgFaild.setFitHeight(50);
        ImgSucc.setPreserveRatio(true);    ImgFaild.setPreserveRatio(true);
        IndIns.setPrefWidth(350);
        //
        /////
        
        final GridPane        grid    = new GridPane();
        grid.setVgap(10);
        grid.setHgap(7);
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
        final Label DateBilan                     = new Label("Date Bilan Biologique ");  
        final HBox  hbDate                        = new HBox(10);
        hbDate.getChildren().addAll(DateBilan,DateB); hbDate.setPadding(new Insets(30,20,30,20));
        final Label GroupageSanguin               = new Label("Groupage Snguin");
              final RadioButton gA                   = new RadioButton("A");
              final RadioButton gB                   = new RadioButton("B");
              final RadioButton gAB                  = new RadioButton("AB");
              final RadioButton gO                   = new RadioButton("O"); 
              
              gA.setToggleGroup(Tgroup1); gB.setToggleGroup(Tgroup1); gAB.setToggleGroup(Tgroup1); gO.setToggleGroup(Tgroup1);
              gA.setUserData("A"); gB.setUserData("B"); gAB.setUserData("AB"); gO.setUserData("O"); gO.setSelected(true);
              final RadioButton gPositif                    = new RadioButton("POSITIF");
              final RadioButton gNegatif                    = new RadioButton("NEGATIF");
                   
              gNegatif.setToggleGroup(Tgroup2); gPositif.setToggleGroup(Tgroup2);
              gNegatif.setUserData("NEGATIF"); gPositif.setUserData("POSITIF"); gPositif.setSelected(true);
        grid.add(GroupageSanguin, 0,0); grid.add(gA,1,0); grid.add(gB,2,0); grid.add(gAB,3,0);  grid.add(gO,4,0); grid.add(gPositif,5,0); grid.add(gNegatif,6,0); 
              
        final Label NFS                            = new Label("_NFS");
              final Label       hb                    = new Label("hb");
                    final RadioButton t1                 = new RadioButton("<10");
                    final RadioButton t2                 = new RadioButton("10-12");
                    final RadioButton t3                 = new RadioButton(">12");
                    
                    t1.setToggleGroup(Tgroup3); t2.setToggleGroup(Tgroup3); t3.setToggleGroup(Tgroup3); 
                    t1.setUserData("<10"); t2.setUserData("10-12"); t3.setUserData(">12"); t1.setSelected(true);
        
        grid.add(NFS, 0,1); grid.add(hb, 0,2); grid.add(t1, 1,2); grid.add(t2, 2,2); grid.add(t3, 3,2);
        
              final Label       GB                    = new Label("GB");
                    final RadioButton tt1                = new RadioButton("<4000");
                    final RadioButton tt2                = new RadioButton(">4000");
                    
                    tt1.setToggleGroup(Tgroup4); tt2.setToggleGroup(Tgroup4);
                    tt1.setUserData("<4000"); tt2.setUserData(">4000"); tt1.setSelected(true);
        grid.add(GB,0,3); grid.add(tt1,1,3); grid.add(tt2,2,3);
              
              final Label       Palq                  = new Label("Plaq");
                    final RadioButton Tt1               = new RadioButton("<50000");       Tt1.setUserData("<50000");
                    final RadioButton Tt2               = new RadioButton("50000-100000"); Tt2.setUserData("50000-100000");
                    final RadioButton Tt3               = new RadioButton(">100000");      Tt3.setUserData(">100000"); Tt3.setSelected(true);
                    
                    Tt1.setToggleGroup(Tgroup5);  Tt2.setToggleGroup(Tgroup5);  Tt3.setToggleGroup(Tgroup5);
        grid.add(Palq,0,4); grid.add(Tt1,1,4); grid.add(Tt2,2,4); grid.add(Tt3,3,4);
        
        final Label BilanHemostace                 = new Label("Bilan d’hémostase ");
              final Label       TP                    = new Label("TP");
                    final RadioButton p1                 = new RadioButton("<40");    p1.setUserData("<40");
                    final RadioButton p2                 = new RadioButton("40-50");  p2.setUserData("40-50");
                    final RadioButton p3                 = new RadioButton(">50-70"); p3.setUserData(">50-70");
                    final RadioButton p4                 = new RadioButton(">70");    p4.setUserData(">70"); p4.setSelected(true);
                    
                    p1.setToggleGroup(Tgroup6); p2.setToggleGroup(Tgroup6); p3.setToggleGroup(Tgroup6);  p4.setToggleGroup(Tgroup6); 
        grid.add(BilanHemostace, 0,5); grid.add(TP,0,6); grid.add(p1,1,6); grid.add(p2,2,6); grid.add(p3,3,6); grid.add(p4,4,6);
        
              final Label       FACTEUR               = new Label("FACTEUR V" );
                    final RadioButton f1                 = new RadioButton("<50");    f1.setUserData("<50");
                    final RadioButton f2                 = new RadioButton("50-70");  f2.setUserData("50-70");
                    final RadioButton f3                 = new RadioButton(">70");    f3.setUserData(">70"); f3.setSelected(true);
                    
                    f1.setToggleGroup(Tgroup7); f2.setToggleGroup(Tgroup7); f3.setToggleGroup(Tgroup7);
        grid.add(FACTEUR,0,7); grid.add(f1,1,7); grid.add(f2,2,7); grid.add(f3,3,7);
        
        final Label BilanHepatique                 = new Label("bilan hépatique ");
              final Label       SGOT                  = new Label("SGOT");
                    final RadioButton so1                = new RadioButton("N");    so1.setUserData("N");
                    final RadioButton so2                = new RadioButton("2N");   so2.setUserData("2N");
                    final RadioButton so3                = new RadioButton(">2N");  so3.setUserData(">2N"); so3.setSelected(true);
                    
                    so1.setToggleGroup(Tgroup8); so2.setToggleGroup(Tgroup8); so3.setToggleGroup(Tgroup8); 
        grid.add(BilanHepatique,0,8);
        grid.add(SGOT,0,9); grid.add(so1,1,9); grid.add(so2,2,9); grid.add(so3,3,9);
           
              final Label       SGPT                  = new Label("SGPT");
                    final RadioButton sp1                = new RadioButton("N");   sp1.setUserData("N");
                    final RadioButton sp2                = new RadioButton("2N");  sp2.setUserData("2N");
                    final RadioButton sp3                = new RadioButton(">2N"); sp3.setUserData(">2N"); sp3.setSelected(true);
                    
                    sp1.setToggleGroup(Tgroup9); sp2.setToggleGroup(Tgroup9); sp3.setToggleGroup(Tgroup9); 
        grid.add(SGPT, 4,9); grid.add(sp1, 5,9); grid.add(sp2, 6,9); grid.add(sp3, 7,9);
            
              final Label      BT                     = new Label("BT");
                    final RadioButton mg1                = new RadioButton("<20 mg/l");    mg1.setUserData("<20 mg/l");
                    final RadioButton mg2                = new RadioButton("20-30 mg/l");  mg2.setUserData("20-30 mg/l");
                    final RadioButton mg3                = new RadioButton(">30mg/l");     mg3.setUserData(">30 mg/l");
                                                                                           mg3.setSelected(true);
                    mg1.setToggleGroup(Tgroup10); mg2.setToggleGroup(Tgroup10); mg3.setToggleGroup(Tgroup10);
        grid.add(BT,0,10);   grid.add(mg1,1,10); grid.add(mg2,2,10); grid.add(mg3,3,10);
        
              final Label     BD                      = new Label("BD");
                    final RadioButton b1                 = new RadioButton("<5");    b1.setUserData("<5");
                    final RadioButton b2                 = new RadioButton("5-10");  b2.setUserData("5-10");
                    final RadioButton b3                 = new RadioButton(">10");   b3.setUserData(">10"); b3.setSelected(true);
                    
                    b1.setToggleGroup(Tgroup11); b2.setToggleGroup(Tgroup11); b3.setToggleGroup(Tgroup11);
        grid.add(BD,0,11); grid.add(b1,1,11); grid.add(b2,2,11); grid.add(b3,3,11);
        
              final Label     GGT                     = new Label("GGT");
                    final RadioButton TT1                = new RadioButton("N");   TT1.setUserData("N");
                    final RadioButton TT2                = new RadioButton("2N");  TT2.setUserData("2N");
                    final RadioButton TT3                = new RadioButton(">2N"); TT3.setUserData(">2N");  TT3.setSelected(true);
                    
                    TT1.setToggleGroup(Tgroup12); TT2.setToggleGroup(Tgroup12); TT3.setToggleGroup(Tgroup12);
        grid.add(GGT,0,12); grid.add(TT1,1,12); grid.add(TT2,2,12); grid.add(TT3,3,12);
        
              final Label     Pal                     = new Label("Pal"); 
                    final RadioButton tT1                = new RadioButton("N");   tT1.setUserData("N");
                    final RadioButton tT2                = new RadioButton("2N");  tT2.setUserData("2N");
                    final RadioButton tT3                = new RadioButton(">2N"); tT3.setUserData(">2N");   tT3.setSelected(true);
                    
                    tT1.setToggleGroup(Tgroup13); tT2.setToggleGroup(Tgroup13); tT3.setToggleGroup(Tgroup13);
        grid.add(Pal,4,12);grid.add(tT1,5,12); grid.add(tT2,6,12); grid.add(tT3,7,12);
        
             final Label      VS                      = new Label("VS");
                   final  RadioButton nn1                = new RadioButton("<100"); nn1.setUserData("<100");
                   final  RadioButton nn2                = new RadioButton(">100"); nn2.setUserData(">100");
                                                                                    nn1.setSelected(true);
                   nn1.setToggleGroup(Tgroup14); nn2.setToggleGroup(Tgroup14);
        grid.add(VS, 0,14); grid.add(nn1, 1,14); grid.add(nn2,2,14);
        
        final Label FonctionRenal                   = new Label("Fonction rénale ");
              final Label uree                         = new Label("UREE");
                    final RadioButton u1                  = new RadioButton("N");      u1.setUserData("N");
                    final RadioButton u2                  = new RadioButton("ELEVEE"); u2.setUserData("ELEVEE");
                                                                                       u1.setSelected(true);
                    u1.setToggleGroup(Tgroup15); u2.setToggleGroup(Tgroup15);
        grid.add(FonctionRenal,0,16); grid.add(uree,0,17); grid.add(u1,1,17); grid.add(u2,2,17);
              final Label creatinine                = new Label("CREATININE");
                    final RadioButton U1               = new RadioButton("N");         U1.setUserData("N");
                    final RadioButton U2               = new RadioButton("ELEVEE");    U2.setUserData("ELEVEE");
                                                                                       U1.setSelected(true);
                    U1.setToggleGroup(Tgroup16); U2.setToggleGroup(Tgroup16); 
        grid.add(creatinine,0,18); grid.add(U1,1,18); grid.add(U2,2,18);
             
        final Label Albuminemie                  = new Label("Albuminémie");     
              final RadioButton uu1                 = new RadioButton("<28");    uu1.setUserData("<28");
              final RadioButton uu2                 = new RadioButton("28-35");  uu2.setUserData("28-35");
              final RadioButton uu3                 = new RadioButton(">35");    uu3.setUserData(">35");  uu3.setSelected(true);
              
              uu1.setToggleGroup(Tgroup17); uu2.setToggleGroup(Tgroup17); uu3.setToggleGroup(Tgroup17);
        grid.add(Albuminemie, 0,20); grid.add(uu1,1,20); grid.add(uu2,2,20); grid.add(uu3,3,20);
    
        final Label calcemie                     = new Label("calcémie");
              final RadioButton Uu1                 = new RadioButton("<85");    Uu1.setUserData("<85");
              final RadioButton Uu2                 = new RadioButton("85-100"); Uu2.setUserData("85-100");
              final RadioButton Uu3                 = new RadioButton(">100");   Uu3.setUserData(">100");
                                                                                 Uu3.setSelected(true);
              Uu1.setToggleGroup(Tgroup18); Uu2.setToggleGroup(Tgroup18); Uu3.setToggleGroup(Tgroup18);
        grid.add(calcemie,0,21); grid.add(Uu1,1,21); grid.add(Uu2,2,21); grid.add(Uu3,3,21);
        
        final Label cholesterol                  = new Label("cholestérol");
              final RadioButton c1                  = new RadioButton("<1g");  c1.setUserData("<1g");
              final RadioButton c2                  = new RadioButton("1-2g"); c2.setUserData("1-2g");
              final RadioButton c3                  = new RadioButton(">2g");  c3.setUserData(">2g");
                                                                               c3.setSelected(true);
              c1.setToggleGroup(Tgroup19); c2.setToggleGroup(Tgroup19); c3.setToggleGroup(Tgroup19);
        grid.add(cholesterol,0,23); grid.add(c1,1,23); grid.add(c2,2,23); grid.add(c3,3,23); 

        final Label triglycéride                 = new Label(" triglycérides");
              final RadioButton C1                  = new RadioButton("<1g");  C1.setUserData("<1g");
              final RadioButton C2                  = new RadioButton("1-2g"); C2.setUserData("1-2g");
              final RadioButton C3                  = new RadioButton(">2g");  C3.setUserData(">2g");
                                                                               C3.setSelected(true);
              C1.setToggleGroup(Tgroup20); C2.setToggleGroup(Tgroup20); C3.setToggleGroup(Tgroup20);
        grid.add(triglycéride,0,24); grid.add(C1,1,24); grid.add(C2,2,24); grid.add(C3,3,24);
    
        final Label Serologies                   = new Label("Sérologies ");
              final Label HVC                          = new Label("HVC");
                    final RadioButton OuiC                = new RadioButton("Oui"); OuiC.setUserData("Oui");OuiC.setSelected(true);
                    final RadioButton NonC                = new RadioButton("Non"); NonC.setUserData("Non");
                    
                    OuiC.setToggleGroup(Tgroup21); NonC.setToggleGroup(Tgroup21);
        grid.add(Serologies, 0,26); grid.add(HVC,0,27); grid.add(OuiC,1,27); grid.add(NonC,2,27);
                    final Label       ChargeVhvc       = new Label("Charge Virale ");
                    final RadioButton hvc1                     = new RadioButton("<2000");        hvc1.setUserData("<2000");hvc1.setSelected(true);
                    final RadioButton hvc2                     = new RadioButton(">2000-100000"); hvc2.setUserData(">2000-100000");
                    final RadioButton hvc3                     = new RadioButton(">100000-1M");   hvc3.setUserData(">100000-1M");
                    final RadioButton hvc4                     = new RadioButton("1M");           hvc4.setUserData("1M");
                                
              hvc1.setToggleGroup(Tgroup34); hvc2.setToggleGroup(Tgroup34); hvc3.setToggleGroup(Tgroup34); hvc4.setToggleGroup(Tgroup34);
              grid.add(ChargeVhvc,0,28); grid.add(hvc1,1,28); grid.add(hvc2,2,28); grid.add(hvc3,3,28); grid.add(hvc4,4,28);
              
              final Label Genotypehvc                   = new Label("Génotype");
              final RadioButton ghvc1                          = new RadioButton("1");   ghvc1.setUserData("1"); ghvc1.setSelected(true);
              final RadioButton ghvc2                          = new RadioButton("2");   ghvc2.setUserData("2");
              final RadioButton ghvc3                          = new RadioButton("3");   ghvc3.setUserData("3");
              final RadioButton ghvc4                          = new RadioButton("4");   ghvc4.setUserData("4");
              
              ghvc1.setToggleGroup(Tgroup35); ghvc2.setToggleGroup(Tgroup35); ghvc3.setToggleGroup(Tgroup35); ghvc4.setToggleGroup(Tgroup35);
        grid.add(Genotypehvc,0,29); grid.add(ghvc1,1,29); grid.add(ghvc2,2,29); grid.add(ghvc3,3,29); grid.add(ghvc4,4,29);
              
              
              Tgroup21.selectedToggleProperty().addListener((ObservableValue<? extends Toggle>ov , Toggle old_value,
              Toggle new_value)-> {
                  if(Tgroup21.getSelectedToggle().getUserData().equals("Non")){
                     grid.getChildren().removeAll(ChargeVhvc,hvc1,hvc2,hvc3,hvc4,
                                                  Genotypehvc,ghvc1,ghvc2,ghvc3,ghvc4);
                  }else {
                      grid.getChildren().addAll(ChargeVhvc,hvc1,hvc2,hvc3,hvc4,
                                                Genotypehvc,ghvc1,ghvc2,ghvc3,ghvc4);
                  }
              });
              final Label AgHBs                        = new Label("AgHBs");
                    final RadioButton Ouigs               = new RadioButton("Oui"); Ouigs.setUserData("Oui");
                    final RadioButton Nongs               = new RadioButton("Non"); Nongs.setUserData("Non");
                                                                                    Ouigs.setSelected(true);
                    Ouigs.setToggleGroup(Tgroup22); Nongs.setToggleGroup(Tgroup22);
        grid.add(AgHBs, 0,31);  grid.add(Ouigs,1,31); grid.add(Nongs,2,31);
                    
              final Label AgHBe                        = new Label("AgHBe");
                    final RadioButton Ouige               = new RadioButton("Oui");  Ouige.setUserData("Oui");
                    final RadioButton Nonge               = new RadioButton("Non");  Nonge.setUserData("Non");
                                                                                     Ouige.setSelected(true);
                    Ouige.setToggleGroup(Tgroup23); Nonge.setToggleGroup(Tgroup23);
        grid.add(AgHBe, 0,32);  grid.add(Ouige,1,32); grid.add(Nonge,2,32);
              final Label AcHBe                        = new Label("Ac HBe");
                    final RadioButton Ouice               = new RadioButton("Oui");  Ouice.setUserData("Oui");
                    final RadioButton Nonce               = new RadioButton("Non");  Nonce.setUserData("Non");
                                                                                     Ouice.setSelected(true);
                    Ouice.setToggleGroup(Tgroup24); Nonce.setToggleGroup(Tgroup24);
        grid.add(AcHBe, 0,33);  grid.add(Ouice,1,33); grid.add(Nonce,2,33);
        
              final Label AcHBs                        = new Label("Ac HBs");
                    final RadioButton Ouics               = new RadioButton("Oui");  Ouics.setUserData("Oui");
                    final RadioButton Noncs               = new RadioButton("Non");  Noncs.setUserData("Non");
                                                                                     Ouics.setSelected(true);
                    Ouics.setToggleGroup(Tgroup25); Noncs.setToggleGroup(Tgroup25);
        grid.add(AcHBs, 0,34);  grid.add(Ouics,1,34); grid.add(Noncs,2,34);
              final Label AcHBc                        = new Label("Ac HBc");
                    final RadioButton Ouicc               = new RadioButton("Oui");  Ouicc.setUserData("Oui");
                    final RadioButton Noncc               = new RadioButton("Non");  Noncc.setUserData("Non");
                                                                                     Noncc.setSelected(true);
                    Ouicc.setToggleGroup(Tgroup26); Noncc.setToggleGroup(Tgroup26);
        grid.add(AcHBc, 0,35);  grid.add(Ouicc,1,35); grid.add(Noncc,2,35);
        
        final Label ChargeVirale                     = new Label("Charge virale");         
              final RadioButton cv1                     = new RadioButton("<2000");       cv1.setUserData("<2000");
              final RadioButton cv2                     = new RadioButton(">2000-100000");cv2.setUserData(">2000-100000");
              final RadioButton cv3                     = new RadioButton(">100000-1M");  cv3.setUserData(">100000-1M");
              final RadioButton cv4                     = new RadioButton("1M");          cv4.setUserData("1M");
                                                                                          cv1.setSelected(true);
              cv1.setToggleGroup(Tgroup27); cv2.setToggleGroup(Tgroup27); cv3.setToggleGroup(Tgroup27); cv4.setToggleGroup(Tgroup27);
        grid.add(ChargeVirale, 0,37); grid.add(cv1,1,37); grid.add(cv2,2,37); grid.add(cv3,3,37);  grid.add(cv4,4,37);
    
        final Label Genotype                         = new Label("Génotype");
        /*
              final RadioButton g1                      = new RadioButton("1");
              final RadioButton g2                      = new RadioButton("2");
              final RadioButton g3                      = new RadioButton("3");
              final RadioButton g4                      = new RadioButton("4");
              final ToggleGroup Tgroup28 =  new ToggleGroup();
              g1.setToggleGroup(Tgroup28); g2.setToggleGroup(Tgroup28); g3.setToggleGroup(Tgroup28); g4.setToggleGroup(Tgroup28);
         */        
        grid.add(Genotype,0,39); /*grid.add(g1,1,39); grid.add(g2,2,39); grid.add(g3,3,39); grid.add(g4,4,39);
             */
              final RadioButton A                      = new RadioButton("A");   A.setUserData("A");
              final RadioButton B                      = new RadioButton("B");   B.setUserData("B");
              final RadioButton C                      = new RadioButton("C");   C.setUserData("C");
              final RadioButton D                      = new RadioButton("D");   D.setUserData("D"); A.setSelected(true);
              
              A.setToggleGroup(Tgroup29); B.setToggleGroup(Tgroup29); C.setToggleGroup(Tgroup29); D.setToggleGroup(Tgroup29);
        grid.add(A,1,39); grid.add(B,2,39); grid.add(C,3,39); grid.add(D,4,39);
        
        
        final Label HVD                              = new Label("HDV");
              final RadioButton i1                      = new RadioButton("Oui");    i1.setUserData("Oui");
              final RadioButton i2                      = new RadioButton("Non");    i2.setUserData("Non");
              final RadioButton i3                      = new RadioButton("NP");     i3.setUserData("NP");
                                                                                     i1.setSelected(true);
              i1.setToggleGroup(Tgroup30); i2.setToggleGroup(Tgroup30); i3.setToggleGroup(Tgroup30); 
        grid.add(HVD,0,40); grid.add(i1,1,40); grid.add(i2,2,40); grid.add(i3,3,40);
        final Label HIV                              = new Label("HIV");
              final RadioButton Ouihiv                      = new RadioButton("Oui");  Ouihiv.setUserData("Oui");
              final RadioButton Nonhiv                      = new RadioButton("Non");  Nonhiv.setUserData("Non");
              final RadioButton NPhiv                      = new RadioButton("NP");    NPhiv.setUserData("NP");
                                                                                       Ouihiv.setSelected(true);
              Ouihiv.setToggleGroup(Tgroup31); Nonhiv.setToggleGroup(Tgroup31); NPhiv.setToggleGroup(Tgroup31); 
        grid.add(HIV,0,41); grid.add(Ouihiv,1,41); grid.add(Nonhiv,2,41); grid.add(NPhiv,3,41);
   
        final Label DosagemT                          = new Label("Dosage des marqueurs tumoraux");
              final Label AFP                            = new Label("AFP");
                    final RadioButton a1                    = new RadioButton("N");          a1.setUserData("N");
                    final RadioButton a2                    = new RadioButton("<50");        a2.setUserData("<50");
                    final RadioButton a3                    = new RadioButton("50-100");     a3.setUserData("50-100");
                    final RadioButton a4                    = new RadioButton(">100-200");   a4.setUserData(">100-200");
                    final RadioButton a5                    = new RadioButton("200-400");    a5.setUserData("200-400");
                    final RadioButton a6                    = new RadioButton(">400");       a6.setUserData(">400");
                                                                                             a1.setSelected(true);
                    a1.setToggleGroup(Tgroup32); a2.setToggleGroup(Tgroup32); a3.setToggleGroup(Tgroup32);
                    a4.setToggleGroup(Tgroup32); a5.setToggleGroup(Tgroup32); a6.setToggleGroup(Tgroup32);
                    
        grid.add(DosagemT, 0,42); grid.add(AFP,0,43); grid.add(a1,1,43); grid.add(a2,2,43); grid.add(a3,3,43);
                                                      grid.add(a4,4,43); grid.add(a5,5,43); grid.add(a6,6,43);
              final Label ACE                            = new Label("ACE");
                    final RadioButton e1                    = new RadioButton("N");       e1.setUserData("N");
                    final RadioButton e2                    = new RadioButton("ELEVEE");  e2.setUserData("ELEVEE");
                                                                                          e1.setSelected(true);
                    e1.setToggleGroup(Tgroup33); e2.setToggleGroup(Tgroup33);
        grid.add(ACE,0,44); grid.add(e1,1,44); grid.add(e2,2,44);
              final Label CA                             = new Label("CA 19-9");
                    final RadioButton ea1                   = new RadioButton("N");      ea1.setUserData("N");    ea1.setSelected(true);
                    final RadioButton ea2                   = new RadioButton("ELEVEE"); ea2.setUserData("ELEVEE");
                    
                    ea1.setToggleGroup(Tgroup36); ea2.setToggleGroup(Tgroup36);
        grid.add(CA,0,45); grid.add(ea1,1,45); grid.add(ea2, 2,45);
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
                    IndIns.setText(" L’insertion du Bilan\n Biologique au niveau du \n Dossier numero "+NumDossier+"\n est faite par succès  ");
                   }else {
                    IndIns.setGraphic(ImgFaild);IndIns.getStyleClass().add("erreurchamp");
                    IndIns.setText(" L’insertion des Bilans \n est bloquée\n par le système ,\n Vous ne pouvez affecter\n qu'une seule insertion \n des bilan de même type \n au niveau d'un dossier \n sur la même date ");
                   }
            } catch (SQLException ex) {
                Logger.getLogger(BilanBiologique.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////La partie Consultation ///////////////////////////////////////////////////////////////////////
        final GridPane        gridC    = new GridPane();
        gridC.setVgap(10);
        gridC.setHgap(7);
     
     final Label ConsBilanbiologique     = new Label("Bilan Biologique : ");
     ConsBilanbiologique.getStyleClass().add("setStyleCirconsanceDic");                          gridC.add(ConsBilanbiologique,0,0);
     final Label ConsDateBilanBiologique = new Label("Date Bilan                :");             gridC.add(ConsDateBilanBiologique, 0,1);    gridC.add(TDateBilanBiologique, 5,1);
     final Label ConsGroupSang           = new Label("Groupage sanguin          :");             gridC.add(ConsGroupSang ,0,2);              gridC.add(TGroupSang ,5,2);
     final Label ConsTypeH               = new Label("TypeH                     :");             gridC.add(ConsTypeH, 0,3);                  gridC.add(TTypeH, 5,3);
      final Label NFSLabel               = new Label("- NFS   :");
      NFSLabel.getStyleClass().add("setstyleTraitementPabs");                                    gridC.add(NFSLabel,0,4);
     final Label  ConsHb                 = new Label("HB                        :");             gridC.add(ConsHb,0,5);                      gridC.add(THb,5,5);
     final Label  ConsGB                 = new Label("GB                        :");             gridC.add(ConsGB,0,6);                      gridC.add(TGB,5,6);
     final Label  ConsPlaq               = new Label("Plaq                      :");             gridC.add(ConsPlaq,0,7);                    gridC.add(TPlaq,5,7);
      final Label bilanHemostas          = new Label("- Bilan d’hémostase  :");
      bilanHemostas.getStyleClass().add("setstyleTraitementPabs");                               gridC.add(bilanHemostas,0,8);
     final Label  ConsTP                 = new Label("TP                        :");             gridC.add(ConsTP, 0,9);                     gridC.add(TTP, 5,9);
     final Label  ConsFacteurV           = new Label("FacteurV                  :");             gridC.add(ConsFacteurV ,0,10);              gridC.add(TFacteurV ,5,10);
      final Label bilanHepathiqu         = new Label("- bilan hépatique    :");
      bilanHepathiqu.getStyleClass().add("setstyleTraitementPabs");                              gridC.add(bilanHepathiqu, 0,11);
     final Label  ConsSGOT               = new Label("SGOT                      :");             gridC.add(ConsSGOT, 0,12);                   gridC.add(TSGOT, 5,12);
     final Label  ConsSGPT               = new Label("SGPT                      :");             gridC.add(ConsSGPT,0,13);                   gridC.add(TSGPT,5,13);
     final Label  ConsBT                 = new Label("BT                        :");             gridC.add(ConsBT,0,14);                     gridC.add(TBT,5,14);
     final Label  ConsBD                 = new Label("BD                        :");             gridC.add(ConsBD,0,15);                     gridC.add(TBD,5,15);
     final Label  ConsGGT                = new Label("GGT                       :");             gridC.add(ConsGGT,0,16);                    gridC.add(TGGT,5,16);
     final Label  ConsPAL                = new Label("PAL                       :");             gridC.add(ConsPAL,0,17);                    gridC.add(TPAL,5,17);
     final Label  ConsVS                 = new Label("VS                        :");             gridC.add(ConsVS ,0,18);                    gridC.add(TVS ,5,18);
      final Label FonctionRenalLabel     = new Label("- Fonction rénale     :");
      FonctionRenalLabel.getStyleClass().add("setstyleTraitementPabs");                          gridC.add(FonctionRenalLabel,0,19);
     final Label  ConsUree               = new Label("UREE                      :");             gridC.add(ConsUree ,0,20);                  gridC.add(TUree ,5,20);
     final Label  ConsCreatinine         = new Label("CREATININE                :");             gridC.add(ConsCreatinine ,0,21);            gridC.add(TCreatinine ,5,21);
     final Label  ConsAlbuminémie        = new Label("Albuminémie               :");             gridC.add(ConsAlbuminémie ,0,22);           gridC.add(TAlbuminémie ,5,22);
     final Label  ConsCalcemie           = new Label("Calcémie                  :");             gridC.add(ConsCalcemie ,0,23);              gridC.add(TCalcemie ,5,23);
     final Label  ConsCholesterol        = new Label("Cholestérol               :");             gridC.add(ConsCholesterol ,0,24);           gridC.add(TCholesterol ,5,24);
     final Label  ConsTryglycérides      = new Label("Triglycérides             :");             gridC.add(ConsTryglycérides ,0,25);         gridC.add(TTryglycérides ,5,25);
      final Label SerologiesLabel        = new Label("- Sérologies     :"); 
      SerologiesLabel.getStyleClass().add("setstyleTraitementPabs");                             gridC.add(SerologiesLabel,0,26);
     final Label  ConsHVC                = new Label("HVC                       :");             gridC.add(ConsHVC ,0,27);                   gridC.add(THVC ,5,27);
     final Label  ConsHVCChargeVirale    = new Label("Charge Virale             :") ;            gridC.add(ConsHVCChargeVirale ,0,28);       gridC.add(THVCChargeVirale ,5,28);
     final Label  ConsHVCGenotype        = new Label("Génotype                  :");             gridC.add(ConsHVCGenotype ,0,29);           gridC.add(THVCGenotype ,5,29); 
     final Label  ConsAgHBs              = new Label("AgHBs                     :");             gridC.add(ConsAgHBs ,0,30);                 gridC.add(TAgHBs ,5,30);
     final Label  ConsAgHBe              = new Label("AgHBe                     :");             gridC.add(ConsAgHBe ,0,31);                 gridC.add(TAgHBe ,5,31);
     final Label  ConsAcHBe              = new Label("Ac HBe                    :");             gridC.add(ConsAcHBe ,0,32);                 gridC.add(TAcHBe ,5,32);
     final Label  ConsAcHBs              = new Label("Ac HBs                    :");             gridC.add(ConsAcHBs ,0,33);                 gridC.add(TAcHBs ,5,33);
     final Label  ConsAcHBc              = new Label("Ac HBc                    :");             gridC.add(ConsAcHBc ,0,34);                 gridC.add(TAcHBc ,5,34);
     final Label  ConsHBChargeVirale     = new Label("Charge virale             :");             gridC.add(ConsHBChargeVirale ,0,35);        gridC.add(THBChargeVirale ,5,35);
     final Label  ConsHBGenotype         = new Label("Génotype                  :");             gridC.add(ConsHBGenotype ,0,36);            gridC.add(THBGenotype ,5,36);
     final Label  ConsHVD                = new Label("HVD                       :");             gridC.add(ConsHVD  ,0,37);                  gridC.add(THVD  ,5,37);
     final Label  ConsHIV                = new Label("HIV                       :");             gridC.add(ConsHIV  ,0,38);                  gridC.add(THIV  ,5,38);
      final Label marqueTum              = new Label("Dosage des marqueurs tumoraux :");
      marqueTum.getStyleClass().add("setstyleTraitementPabs");                                   gridC.add(marqueTum,0,39);
     final Label  ConsAFP                = new Label("AFP                       :");             gridC.add(ConsAFP ,0,40);                   gridC.add(TAFP ,5,40);
     final Label  ConsACE                = new Label("ACE                       :");             gridC.add(ConsACE ,0,41);                   gridC.add(TACE ,5,41);
     final Label  ConsCA                 = new Label("CA                        :");             gridC.add(ConsCA  ,0,42);                   gridC.add(TCA  ,5,42);
        //////////// /************************************************************************************//////////
        grid.add(Ajouter, 4,47);
        grid.add(IndIns,3,31,4,4);
        ///
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
        
        /*********************************************************************************/
         grid.setPadding(new Insets(30,10,10,30));
         gridC.setPadding(new Insets(30,10,10,30));
         if(TypeCCP == 0){
        final StackPane   pane     =  new StackPane();
        pane.getStyleClass().add("setStylingRoot");
        grid.setTranslateY(50);
        pane.getChildren().addAll(hbDate,grid);
        getChildren().add(pane);
         }
        else{
        final StackPane   paneC     =  new StackPane();
        paneC.getStyleClass().add("setStylingRootCons");
        this.ConsultationE(NumDossier);
        
        gridC.setMinWidth(900);
        
        gridC.add(barOutil, 10, 42,2,1);
        gridC.add(vbMod,10,38,3,3);
        paneC.getChildren().addAll(gridC);
        getChildren().add(paneC);      
        }
    } 
    
    public String getGroupage() {
        return Tgroup1.getSelectedToggle().getUserData().toString();
    }

    public String getH() {
        return Tgroup2.getSelectedToggle().getUserData().toString();
    }

    public String gethp() {
        return Tgroup3.getSelectedToggle().getUserData().toString();
    }

    public String getGB() {
        return Tgroup4.getSelectedToggle().getUserData().toString();
    }

    public String getPlaq() {
        return Tgroup5.getSelectedToggle().getUserData().toString();
    }

    public String getTP() {
        return Tgroup6.getSelectedToggle().getUserData().toString();
    }

    public String getFacteurV() {
        return Tgroup7.getSelectedToggle().getUserData().toString();
    }

    public String getSGOT() {
        return Tgroup8.getSelectedToggle().getUserData().toString();
    }

    public String getSGPT() {
        return Tgroup9.getSelectedToggle().getUserData().toString();
    }

    public String getBT() {
        return Tgroup10.getSelectedToggle().getUserData().toString();
    }

    public String getBD() {
        return Tgroup11.getSelectedToggle().getUserData().toString();
    }

    public String getGGT() {
        return Tgroup12.getSelectedToggle().getUserData().toString();
    }

    public String getPal() {
        return Tgroup13.getSelectedToggle().getUserData().toString();
    }

    public String getVS() {
        return Tgroup14.getSelectedToggle().getUserData().toString();
    }

    public String getUREE() {
        return Tgroup15.getSelectedToggle().getUserData().toString();
    }

    public String getCreatinine() {
        return Tgroup16.getSelectedToggle().getUserData().toString();
    }

    public String getAlbuminemie() {
        return Tgroup17.getSelectedToggle().getUserData().toString();
    }

    public String getCalcemie() {
        return Tgroup18.getSelectedToggle().getUserData().toString();
    }

    public String getCholesterole() {
        return Tgroup19.getSelectedToggle().getUserData().toString();
    }

    public String getTriglycerides() {
        return Tgroup20.getSelectedToggle().getUserData().toString();
    }

    public String getHVC() {
        return Tgroup21.getSelectedToggle().getUserData().toString();
    }

    public String getChargeViraleHvc() {
        return Tgroup34.getSelectedToggle().getUserData().toString();
    }

    public String getGenotypeHvc() {
        return Tgroup35.getSelectedToggle().getUserData().toString();
    }

    public String getAgHBs() {
        return Tgroup22.getSelectedToggle().getUserData().toString();
    }

    public String getAgHBe() {
        return Tgroup23.getSelectedToggle().getUserData().toString();
    }

    public String getAcHBe() {
        return Tgroup24.getSelectedToggle().getUserData().toString();
    }

    public String getAcHBs() {
        return Tgroup25.getSelectedToggle().getUserData().toString();
    }

    public String getAcHBc() {
        return Tgroup26.getSelectedToggle().getUserData().toString();
    }

    public String getChargeVirale() {
        return Tgroup27.getSelectedToggle().getUserData().toString();
    }

    public String getGenotype() {
        return Tgroup29.getSelectedToggle().getUserData().toString();
    }

    public String getHDV() {
        return Tgroup30.getSelectedToggle().getUserData().toString();
    }

    public String getHIV() {
        return Tgroup31.getSelectedToggle().getUserData().toString();
    }

    public String getAFP() {
        return Tgroup32.getSelectedToggle().getUserData().toString();
    }

    public String getACE() {
        return Tgroup33.getSelectedToggle().getUserData().toString();
    }

    public String getCA() {
        return Tgroup36.getSelectedToggle().getUserData().toString();
    }
              
    public LocalDate getDateB() {
        return DateB.getValue();
    }
    public int  InsertionSGBD(String NumDossier) throws SQLException{
        System.out.println(this.getGroupage()+ "  "+this.getH()+"\n"+this.gethp()+"\n"+this.getGB()+"\n"+
                this.getPlaq()+"\n"+this.getTP()+"\n"+this.getFacteurV()+"\n"+this.getSGOT()+"  "+this.getSGPT()+"\n"+
                this.getBT()+"\n"+this.getBD()+"\n"+this.getGGT()+"  " +this.getPal()+"\n"+this.getVS()+"\n"+this.getUREE()+"\n"+
                this.getCreatinine()+"\n"+this.getAlbuminemie()+ "\n"+this.getCalcemie()+"\n"+this.getCholesterole()+"\n"+
                this.getTriglycerides()+"\n"+this.getHVC()+"\n"+this.getChargeViraleHvc()+"\n"+this.getGenotypeHvc()+"\n"+
                this.getAgHBs()+"\n"+this.getAgHBe()+"\n"+this.getAcHBe()+"\n"+this.getAcHBs()+"\n"+this.getAcHBc()+"\n"+
                this.getChargeVirale()+"\n"+this.getGenotype()+"\n"+this.getHDV()+"\n"+this.getHIV()+"\n"+this.getAFP()+"\n"+
                this.getACE()+"\n"+this.getCA()+"\n");
        
        MiseAjour   bddInsert   =  new MiseAjour();
        int i = bddInsert.AddElement("insert into bilanbiologique values (0,'"+this.getGroupage()+ "','"+this.getH()+"','"+this.gethp()+"','"+this.getGB()+"','"+
                this.getPlaq()+"','"+this.getTP()+"','"+this.getFacteurV()+"','"+this.getSGOT()+"','"+this.getSGPT()+"','"+
                this.getBT()+"','"+this.getBD()+"','"+this.getGGT()+"','" +this.getPal()+"','"+this.getVS()+"','"+this.getUREE()+"','"+
                this.getCreatinine()+"','"+this.getAlbuminemie()+ "','"+this.getCalcemie()+"','"+this.getCholesterole()+"','"+
                this.getTriglycerides()+"','"+this.getHVC()+"','"+this.getChargeViraleHvc()+"','"+this.getGenotypeHvc()+"','"+
                this.getAgHBs()+"','"+this.getAgHBe()+"','"+this.getAcHBe()+"','"+this.getAcHBs()+"','"+this.getAcHBc()+"','"+
                this.getChargeVirale()+"','"+this.getGenotype()+"','"+this.getHDV()+"','"+this.getHIV()+"','"+this.getAFP()+"','"+
                this.getACE()+"','"+this.getCA()+"','"+NumDossier+"','"+this.getDateB()+"')");
         
        return i ;
        }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////LA PARTIE Consultation *********************************///////////////////////////////////////////////
    public void setDateBilanBiologique(String a) {
        TDateBilanBiologique.setText(a);
    }

    public void setGroupSang(String b) {
        TGroupSang.setText(b);
    }

    public void setTypeH(String c) {
        TTypeH.setText(c);
    }

    public void setHb(String d) {
        THb.setText(d);
    }

    public void setGB(String e) {
        TGB.setText(e);
    }

    public void setPlaq(String f) {
        TPlaq.setText(f);
    }

    public void setTP(String g) {
        TTP.setText(g);
    }

    public void setFacteurV(String h) {
        TFacteurV.setText(h);
    }

    public void setSGOT(String i) {
        TSGOT.setText(i);
    }

    public void setSGPT(String j) {
        TSGPT.setText(j);
    }

    public void setBT(String k) {
        TBT.setText(k);
    }

    public void setBD(String l) {
        TBD.setText(l);
    }

    public void setGGT(String m) {
        TGGT.setText(m);
    }

    public void setPAL(String n) {
        TPAL.setText(n);
    }

    public void setVS(String o) {
        TVS.setText(o);    }

    public void setUree(String p) {
        TUree.setText(p);
    }

    public void setCreatinine(String q) {
        TCreatinine.setText(q);
    }

    public void setAlbuminémie(String r) {
        TAlbuminémie.setText(r);
    }

    public void setCalcemie(String s) {
        TCalcemie.setText(s);
    }

    public void setCholesterol(String t) {
        TCholesterol.setText(t);
    }

    public void setTryglycérides(String u) {
        TTryglycérides.setText(u);
    }

    public void setHVC(String a) {
        THVC.setText(a);
    }

    public void setHVCChargeVirale(String a) {
        THVCChargeVirale.setText(a);
    }

    public void setHVCGenotype(String a) {
        THVCGenotype.setText(a);
    }

    public void setAgHBs(String a) {
        TAgHBs.setText(a);
    }

    public void setAgHBe(String a) {
        TAgHBe.setText(a);
    }

    public void setAcHBe(String a) {
        TAcHBe.setText(a);
    }

    public void setAcHBs(String a) {
        TAcHBs.setText(a);
    }

    public void setAcHBc(String a) {
        TAcHBc.setText(a);
    }

    public void setHBChargeVirale(String a) {
        THBChargeVirale.setText(a);
    }

    public void setHBGenotype(String a) {
        THBGenotype.setText(a);
    }

    public void setHVD(String a) {
        THVD.setText(a);
    }

    public void setHIV(String a) {
        THIV.setText(a);
    }

    public void setAFP(String a) {
        TAFP.setText(a);
    }

    public void setACE(String a) {
        TACE.setText(a);
    }

    public void setCA(String a) {
        TCA.setText(a);
    }
    
    public void ConsultationE(String NumDossier) throws SQLException{
        
        BilanBiologiqueClasse  Bilan         = null;
        Consultation bddCons     = new Consultation();
        ResultSet res = bddCons.ExtElement("select * from bilanbiologique where NumDossier = '"+NumDossier+"'"
                                           +"and DateBilanBiologique = '"+DateInsBilan+"'");
    while(res.next())
    Bilan   =  new BilanBiologiqueClasse( res.getDate(38),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
    res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),
    res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),res.getString(18),res.getString(19),
    res.getString(20),res.getString(21),res.getString(22),res.getString(23),res.getString(24),res.getString(25),res.getString(26),
    res.getString(27),res.getString(28),res.getString(29),res.getString(30),res.getString(31),res.getString(32),res.getString(33),
    res.getString(34),res.getString(35),res.getString(36)); 
     
    bddCons.CloseConnex();
    
    try{
        this.setDateBilanBiologique(Bilan.getDateBilanBiologique().toString());
        this.setGroupSang(Bilan.getGroupSang());
        this.setTypeH(Bilan.getTypeH());
        this.setHb(Bilan.getHb());
        this.setGB(Bilan.getGB());
        this.setPlaq(Bilan.getPlaq());
        this.setTP(Bilan.getTP());
        this.setFacteurV(Bilan.getFacteurV());
        this.setSGOT(Bilan.getSGOT());
        this.setSGPT(Bilan.getSGPT());
        this.setBT(Bilan.getBT());
        this.setBD(Bilan.getBD());
        this.setGGT(Bilan.getGGT());
        this.setPAL(Bilan.getPAL());
        this.setVS(Bilan.getVS());
        this.setUree(Bilan.getUree());
        this.setCreatinine(Bilan.getCreatinine());
        this.setAlbuminémie(Bilan.getAlbuminémie());
        this.setCalcemie(Bilan.getCalcemie());
        this.setCholesterol(Bilan.getCholesterol());
        this.setTryglycérides(Bilan.getTryglycérides());
        this.setHVC(Bilan.getHVC());
        this.setHVCChargeVirale(Bilan.getHVCChargeVirale());
        this.setHVCGenotype(Bilan.getHVCGenotype());
        this.setAgHBs(Bilan.getAgHBs());
        this.setAgHBe(Bilan.getAgHBe());
        this.setAcHBe(Bilan.getAcHBe());
        this.setAcHBc(Bilan.getAcHBc());
        this.setAcHBs(Bilan.getAcHBs());
        this.setHBChargeVirale(Bilan.getHBChargeVirale());
        this.setHBGenotype(Bilan.getHBGenotype());
        this.setHVD(Bilan.getHVD());
        this.setHIV(Bilan.getHIV());
        this.setAFP(Bilan.getAFP());
        this.setACE(Bilan.getACE());
        this.setCA(Bilan.getCA());
        
        
    }catch(Exception e){
        this.setDateBilanBiologique("---------");
        this.setGroupSang("---------");
        this.setTypeH("---------");
        this.setHb("---------");
        this.setGB("---------");
        this.setPlaq("---------");
        this.setTP("---------");
        this.setFacteurV("---------");
        this.setSGOT("---------");
        this.setSGPT("---------");
        this.setBT("---------");
        this.setBD("---------");
        this.setGGT("---------");
        this.setPAL("---------");
        this.setVS("---------");
        this.setUree("---------");
        this.setCreatinine("---------");
        this.setAlbuminémie("---------");
        this.setCalcemie("---------");
        this.setCholesterol("---------");
        this.setTryglycérides("---------");
        this.setHVC("---------");
        this.setHVCChargeVirale("---------");
        this.setHVCGenotype("---------");
        this.setAgHBs("---------");
        this.setAgHBe("---------");
        this.setAcHBe("---------");
        this.setAcHBc("---------");
        this.setAcHBs("---------");
        this.setHBChargeVirale("---------");
        this.setHBGenotype("---------");
        this.setHVD("---------");
        this.setHIV("---------");
        this.setAFP("---------");
        this.setACE("---------");
        this.setCA("---------");
    }
    
    }
  public int  DeleteSGBD(String NumDossier) throws SQLException{
            MiseAjour bddDelete   = new MiseAjour();
        
            int j = bddDelete.AddElement("delete from BilanBiologique where NumDossier ='"+NumDossier+"' and dateBilanBiologique ='"+DateInsBilan+"'" );
            
            return j;
        }
    ///////////////********************************************************///////////////////////////////////////////
}
   
