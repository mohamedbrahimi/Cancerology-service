
package service.medicament.AnalyseSpace;

import java.sql.SQLException;
import java.util.Arrays;
import javafx.animation.TranslateTransitionBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import service.medicament.Statistiques.StatistiqueClasse;

public class DescriptionAnalyseSpace {

     final AnalyseClasse   Anal;
     final AnalyseClasse   Anal1;
     final StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
     final StatistiqueClasse     stat2         = new StatistiqueClasse().getInfoStatWilaya();
    public DescriptionAnalyseSpace() throws SQLException {
        this.Anal  = new AnalyseClasse().AnalysHepathieSJacent();
        this.Anal1 = new AnalyseClasse().AnalStatCirDecouvert();
    }
    public Node[][] DescriptionStat() throws SQLException{
        //Diabete HepatopathieVF  NeoplasmeF
        final Node[][]          Component      = 
{{new AgeStat(),new FemmeHommeStat(),new CondSocioEcoStat(),new SituatFamilial(),new getOrigineStat(),new getCauseDeces()},{new HepathieSousJacent(),new hepatiteChroniqueCirrhose(),new ContageViraleBC(),new AutreATCDS(),new Diabete()},
 {new HepatopathieVF(),new NeoplasmeF()},
 {new EMTHepathiCirDec(), new AnalStatFourtuit(),new DepEnCasCirConnu(), new SigneGF(), new SigneHypertension() , new SignesPhysique(), new Syndrom()}};
        
        return Component;
    }
    
    
   public class HepathieSousJacent extends Parent{
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();

        public HepathieSousJacent() {
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("Hepatopathies sous jacentes ");
        xAxis.setLabel(" Oui/Non ");
        yAxis.setLabel(" Patients");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("ATCDs Personnels ");
        
        series1.getData().add(new XYChart.Data("Oui", Anal.getHepathieSousJacentOui()));
        series1.getData().add(new XYChart.Data("Non", Anal.getHepathieSousJacentNon()));
    
        barChart.getData().addAll(series1);
        //barChart.setBarGap(3);
        barChart.setCategoryGap(50);
          
        getChildren().add(barChart);
            
        
        }
        
   }
   
   public class hepatiteChroniqueCirrhose extends Parent {
 
    final static String austria = "hépatite chronique ";
    final static String brazil  = "hépatite cirrhose  ";
   

        public hepatiteChroniqueCirrhose() {
      
         final CategoryAxis      xAxis               = new CategoryAxis();
         final NumberAxis        yAxis               = new NumberAxis();
        
        final BarChart<String , Number> barChart     = new BarChart<>(xAxis ,yAxis);
        
        barChart.setTitle(" Hépatite ");
        xAxis.setLabel   (" Type  d'hépatite  et Causes ");
        yAxis.setLabel   (" patient ");
        
        
        
        XYChart.Series           series1            = new XYChart.Series<>();
        series1.setName("hépatite");        

        series1.getData().add(new XYChart.Data( austria , Anal.getHChronique()));
        series1.getData().add(new XYChart.Data( brazil  , Anal.getCiHCirrhose()));
     

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Virale B");
        series2.getData().add(new XYChart.Data( austria , Anal.getChviraleB()));
        series2.getData().add(new XYChart.Data( brazil  , Anal.getCiviraleB()));
      

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Virale C");
        series3.getData().add(new XYChart.Data( austria , Anal.getChViraleC()));
        series3.getData().add(new XYChart.Data( brazil  , Anal.getCiViraleC()));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("NASH");
        series4.getData().add(new XYChart.Data( austria , Anal.getChNASH()));
        series4.getData().add(new XYChart.Data( brazil  , Anal.getCiNASH()));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("AUTOIMMUNE");
        series5.getData().add(new XYChart.Data(austria  , Anal.getChAUTOIMMUNE()));
        series5.getData().add(new XYChart.Data(brazil   , Anal.getCiAUTOIMMUNE()));
        
        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Autres");
        series6.getData().add(new XYChart.Data(austria  , Anal.getChAutre()));
        series6.getData().add(new XYChart.Data(brazil   , Anal.getCiAutre()));


        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2);
        shadow.setColor(Color.GREY);
        barChart.setEffect(shadow);
        
        //xAxis.setTickLabelRotation(90);
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.DARKBLUE);
        
        barChart.getData().addAll(series1,series2,series3,series4,series5,series6);
       
        barChart.setCategoryGap(100);
        barChart.setPrefSize(700, 500);
       
        Reflection r = new Reflection();
//on applique un effet de réflection
        r.setFraction(0.25);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        
        
       
        setEffect(r);
        
        getChildren().add(barChart);
        
        }
       
       
   } 
   
   
   public class ContageViraleBC extends Parent {

        public ContageViraleBC() {
                  
         final CategoryAxis      xAxis               = new CategoryAxis();
         final NumberAxis        yAxis               = new NumberAxis();
        
        final BarChart<String , Number> barChart     = new BarChart<>(xAxis ,yAxis);
        
        barChart.setTitle(" Contage Virale B et C");
        xAxis.setLabel   (" Contages");
        yAxis.setLabel   (" patient ");
        
        XYChart.Series           series1            = new XYChart.Series<>();
        series1.setName("transfusion sanguine");        
        series1.getData().add(new XYChart.Data("" , Anal.getContTransSang()));   
        
        XYChart.Series           series2            = new XYChart.Series<>();
        series2.setName("extraction dentaire traditionnelle ");        
        series2.getData().add(new XYChart.Data("" , Anal.getContExtrDenTrad()));
        
        XYChart.Series           series3            = new XYChart.Series<>();
        series3.setName("scarification");        
        series3.getData().add(new XYChart.Data("" , Anal.getContSacrification())); 
        
        XYChart.Series           series4            = new XYChart.Series<>();
        series4.setName("tatouage");        
        series4.getData().add(new XYChart.Data("" , Anal.getContTatouage())); 
        
        XYChart.Series           series5            = new XYChart.Series<>();
        series5.setName(" chirurgie ");        
        series5.getData().add(new XYChart.Data("" , Anal.getContchirurgie())); 
        
        XYChart.Series           series6            = new XYChart.Series<>();
        series6.setName(" autres ");        
        series6.getData().add(new XYChart.Data("" , Anal.getContAutre())); 
        
        
        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2);
        shadow.setColor(Color.GREY);
        barChart.setEffect(shadow);
        
        //xAxis.setTickLabelRotation(90);
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.DARKBLUE);
        
        barChart.getData().addAll(series1,series2,series3,series4,series5,series6);
       
        barChart.setCategoryGap(100);
        barChart.setPrefSize(700, 500);
       
        Reflection r = new Reflection();
//on applique un effet de réflection
        r.setFraction(0.25);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        
        
       
        setEffect(r);
        
        getChildren().add(barChart);
        
        
        }
       
   }
   
   public class AutreATCDS extends Parent {
    
        
        /***/ 
     
     ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList(
        
                new PieChart.Data("Prise de cafe "        ,Anal.getAutreCafe()), 
                new PieChart.Data("Prise de Cannabis"     ,Anal.getAutreCannabis()),
                new PieChart.Data("Contraception orale "  ,Anal.getAutreContreOrale()),
                new PieChart.Data("Diabète"               ,Anal.getAutreDiabete()),
                new PieChart.Data("HTA"                   ,Anal.getAutreHTA()),
                new PieChart.Data("Néoplasme connu "      ,Anal.getAutreNeoplasmeConnu()),
                new PieChart.Data("Maladie auto-immune "  ,Anal.getAutreMaladieAutoImmune())
               
        );
        final   PieChart       chart      =   new PieChart(piechartData);  

        final   int           total       = Anal.getAutreCafe() + Anal.getAutreCannabis() + Anal.getAutreContreOrale()+
        Anal.getAutreDiabete() + Anal.getAutreHTA() + Anal.getAutreNeoplasmeConnu() +  Anal.getAutreMaladieAutoImmune();
        public AutreATCDS() {
        chart.setLabelLineLength(20);
        chart.setLegendSide(Side.RIGHT); 
        chart.setClockwise(false);
        chart.setStartAngle(90);
        chart.setTitle("Analyse les autre ATCDs Personnels ");
        
      ///  chart.setStyle("-fx-border-color     : black;"
         //            + "");
        
        final Label caption = new Label("");caption.setPrefSize(400, 30);
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;"); caption.setTranslateX(0);
                                                 caption.setTranslateY(350);
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        //caption.setTranslateX(e.getSceneX());
                        //caption.setTranslateY(e.getSceneY());
                        
                        caption.setText(String.valueOf(data.getName() +" : "+((int) (data.getPieValue()* 100/total) + "%")));
                        
                        caption.setVisible(true);
                     }
                });}
            
       
        chart.setOpacity(0.8);
        
        
        getChildren().addAll(chart,caption);
        }
        
   }
   
   public class Diabete extends Parent {
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();

       
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);

        public Diabete() {
        
        
        barChart.setTitle("gestion des  diabétiques par type ");
        xAxis.setLabel(" Type ");
        yAxis.setLabel(" Patients");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Analyse sur les Diabétiques ");
        
        series1.getData().add(new XYChart.Data("Total ", Anal.getTDiabete()));
        series1.getData().add(new XYChart.Data("Type 1", Anal.getTType1()));
        series1.getData().add(new XYChart.Data("Type 2", Anal.getTType2()));
    
        barChart.getData().addAll(series1);
        
        barChart.setId("Diabet");
        //barChart.setBarGap(3);
        barChart.setCategoryGap(50);
          
        getChildren().add(barChart);
              
   }
   
   }
   public class HepatopathieVF extends Parent {
      
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();

       
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);

        public HepatopathieVF() {
        
        
        barChart.setTitle("Hépatopathie virale dans la famille ");
        xAxis.setLabel(" Oui / Non ");
        yAxis.setLabel(" Patients");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Analyse sur les ATCDs Familiaux ");
        
       
        series1.getData().add(new XYChart.Data("Oui", Anal.getHepatoviralPF()));
        series1.getData().add(new XYChart.Data("Non", Anal.getTotalPF()-Anal.getHepatoviralPF()));
        System.out.println(Anal.getTotalPF() +" :  "+Anal.getHepatoviralPF());
        barChart.getData().addAll(series1);
        
   
        barChart.setCategoryGap(50);
          
        getChildren().add(barChart);
   }
   }
   public class NeoplasmeF extends Parent {
              final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();

       
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);

        public NeoplasmeF() {
        
        
        barChart.setTitle("Néoplasme dans la famille ");
        xAxis.setLabel(" Oui / Non ");
        yAxis.setLabel(" Patients");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Analyse sur les ATCDs Familiaux ");
        
       
        series1.getData().add(new XYChart.Data("Oui", Anal.getNplsmPF()));
        series1.getData().add(new XYChart.Data("Non", Anal.getTotalPF()-Anal.getNplsmPF()));
    
        barChart.getData().addAll(series1);
        
       // barChart.setId("Diabet");
        //barChart.setBarGap(3);
        barChart.setCategoryGap(50);
          
        getChildren().add(barChart);
   } 
   }
    public class AgeStat extends Parent{
         
         public AgeStat() throws SQLException{
             
       // StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
        /***/ 
                ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList(
        
                new PieChart.Data("01-15"  ,stat.getAge1()), 
                new PieChart.Data("15-30"  ,stat.getAge3()),
                new PieChart.Data("30-60"  ,stat.getAge2()),
                new PieChart.Data(" >60 "  ,stat.getAge4())     
               
        );
        final   PieChart       chart      =   new PieChart(piechartData);  
        chart.setLabelLineLength(20);
      
        chart.setLegendSide(Side.RIGHT); 
        chart.setClockwise(false);
        chart.setStartAngle(90);
        chart.setTitle("Statistique Par Age ");
        
      ///  chart.setStyle("-fx-border-color     : black;"
         //            + "");
        chart.setOpacity(0.8);
        getChildren().add(chart);
         }
     }
     /*****Femme/Homme Statistique ***/
     public class FemmeHommeStat extends Parent{
       
        final Label      StatHomme           = new Label(); 
        final ImageView  ImageFH             = new ImageView(new Image(getClass().getResourceAsStream("Images/images.jpg")));
        final Label      StatFemme           = new Label();
        
        final HBox       ContenuSfh           = new HBox();
        final Label      Caption              = new Label("Statistiques Selon le Sexe ");
        final VBox       vb                   = new VBox(5);
        public FemmeHommeStat() throws SQLException{
      //  StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
        
        StatHomme.setText((Integer)stat.getHomme()*100/(stat.getHomme()+stat.getFemme())+" %");   StatHomme.setId("StatLabel");
        StatFemme.setText((Integer)stat.getFemme()*100/(stat.getHomme()+stat.getFemme())+" %");   StatFemme.setId("StatLabel");
        ContenuSfh.getChildren().addAll(StatHomme,ImageFH,StatFemme);                             Caption.setId("StatLabel");
         
        vb.getChildren().addAll(Caption,ContenuSfh);
        getChildren().add(vb);
        }
     }
        /***********Statistique Condition Socio/Eco*********/
        public class CondSocioEcoStat extends Parent{
        final NumberAxis         xAxis              = new NumberAxis();
        final CategoryAxis       yAxis              = new CategoryAxis();
        
        
        final StackedBarChart<Number , String> barChart      = new StackedBarChart<>(xAxis ,yAxis);
            public CondSocioEcoStat() throws SQLException{
   //     StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat(); 
        xAxis.setLabel("  Patient ");
        
        XYChart.Series           series1            = new XYChart.Series<>();
        series1.setName("Conditions Socio Echonomiques");        

        series1.getData().add(new XYChart.Data(stat.getCondMau(), "Mauvaise"));
        series1.getData().add(new XYChart.Data(stat.getCondMoy(), "Moyenne"));
        series1.getData().add(new XYChart.Data(stat.getCondBon(), "Bonne"));
        
        xAxis.setTickLabelRotation(90);
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.DARKBLUE);
        
        barChart.getData().addAll(series1);
        
        getChildren().add(barChart);
            
        }
        }
        
    /***************************************************/
     
    /*******Situation familiale *************************/
        
        public class SituatFamilial extends Parent{
        
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();

            public SituatFamilial() throws SQLException{
    //     StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
          xAxis.setCategories(FXCollections.<String>observableArrayList(
        Arrays.asList("Marie","Célibataire")));
        final StackedBarChart<String , Number> barChart    = new StackedBarChart<>(xAxis,yAxis);
        
        barChart.setTitle("Situation Familiale");
        xAxis.setLabel(" Situation ");
        yAxis.setLabel(" Patients");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Situation Familaile");
        
        series1.getData().add(new XYChart.Data("Marie", stat.getSituat1()));
        series1.getData().add(new XYChart.Data("Célibataire", stat.getSituat2()));
    
        barChart.getData().addAll(series1);
        //barChart.setBarGap(3);
        barChart.setCategoryGap(50);
          
        getChildren().add(barChart);
            }
        }
        
        /************************************************************************************/
        /***L'origine***/
       public class getOrigineStat extends Parent{
           
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();
        final String[]            TabW                = {"Adrar","Chlef","Tamanrasset","Illizi","Ouargla","Béchar","Tindouf","Ghardaïa",
                                   "Bayadh","Djelfa","Oued","Naâma","Laghouat","Biskra","Tiaret","Msila","Tébessa",
                                   "Batna","Khenchela","Sidi Bel Abbès","Tlemcen","Médéa","Oum El Bouaghi","Saïda",
                                   "Sétif","Mascara","Aïn Defla","Relizane","Souk Ahras"," Bouira","Bordj Bou Arreridj",
                                   "Guelma","Skikda","Tizi Ouzou"," Mila","El Tarf","Béjaïa","Tissemsilt","Jijel",
                                   "Aïn Témouchent","Constantine","Mostaganem","Tipaza","Oran","Boumerdès","Blida","Annaba",
                                   "Alger"};
           public getOrigineStat() throws SQLException{
      //  StatistiqueClasse     stat2         = new StatistiqueClasse().getInfoStatWilaya();
          /*xAxis.setCategories(FXCollections.<String>observableArrayList(
        Arrays.asList("Adrar","Chlef","Tamanrasset","Illizi","Ouargla","Béchar","Tindouf","Ghardaïa",
                                   "Bayadh","Djelfa","Oued","Naâma","Laghouat","Biskra","Tiaret","Msila","Tébessa",
                                   "Batna","Khenchela","Sidi Bel Abbès","Tlemcen","Médéa","Oum El Bouaghi","Saïda",
                                   "Sétif","Mascara","Aïn Defla","Relizane","Souk Ahras"," Bouira","Bordj Bou Arreridj",
                                   "Guelma","Skikda","Tizi Ouzou"," Mila","El Tarf","Béjaïa","Tissemsilt","Jijel",
                                   "Aïn Témouchent","Constantine","Mostaganem","Tipaza","Oran","Boumerdès","Blida","Annaba",
                                   "Alger")));*/
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("Statistiques selon la Wilaya");
        xAxis.setLabel(" Wilaya ");     
        yAxis.setLabel(" Patients");
        xAxis.setTickLabelRotation(80);
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Wilaya");
        
        series1.getData().add(new XYChart.Data(TabW[0], stat2.getAdrar()));                   /**/ series1.getData().add(new XYChart.Data(TabW[1], stat2.getChlef()));
        series1.getData().add(new XYChart.Data(TabW[2], stat2.getTamanrasset()));             /**/ series1.getData().add(new XYChart.Data(TabW[3], stat2.getIllizi()));
        series1.getData().add(new XYChart.Data(TabW[4], stat2.getOuargla()));                 /**/ series1.getData().add(new XYChart.Data(TabW[5], stat2.getBechar()));
        series1.getData().add(new XYChart.Data(TabW[6], stat2.getTindouf()));                 /**/ series1.getData().add(new XYChart.Data(TabW[7], stat2.getGhardaïa()));
        series1.getData().add(new XYChart.Data(TabW[8], stat2.getBayadh()));                  /**/ series1.getData().add(new XYChart.Data(TabW[9], stat2.getDjelfa()));
        series1.getData().add(new XYChart.Data(TabW[10],stat2.getOued()));                    /**/ series1.getData().add(new XYChart.Data(TabW[11],stat2.getNaâma()));
        series1.getData().add(new XYChart.Data(TabW[12],stat2.getLaghouat()));                /**/ series1.getData().add(new XYChart.Data(TabW[13],stat2.getBiskra()));
        series1.getData().add(new XYChart.Data(TabW[14],stat2.getTiaret()));                  series1.getData().add(new XYChart.Data(TabW[15],stat2.getMsila()));
        series1.getData().add(new XYChart.Data(TabW[16],stat2.getTébessa()));                   series1.getData().add(new XYChart.Data(TabW[17],stat2.getBatna()));
        series1.getData().add(new XYChart.Data(TabW[18],stat2.getKhenchela()));                 series1.getData().add(new XYChart.Data(TabW[19],stat2.getSidiBelAbbès()));
        series1.getData().add(new XYChart.Data(TabW[20],stat2.getTlemcen()));                   series1.getData().add(new XYChart.Data(TabW[21],stat2.getMédéa()));
        series1.getData().add(new XYChart.Data(TabW[22],stat2.getOumElBouaghi()));              series1.getData().add(new XYChart.Data(TabW[23],stat2.getSaïda()));
        series1.getData().add(new XYChart.Data(TabW[24],stat2.getSétif()));                     series1.getData().add(new XYChart.Data(TabW[25],stat2.getMascara()));
        series1.getData().add(new XYChart.Data(TabW[26],stat2.getAïnDefla()));                  series1.getData().add(new XYChart.Data(TabW[27],stat2.getRelizane()));
        series1.getData().add(new XYChart.Data(TabW[28],stat2.getSoukAhras()));                 series1.getData().add(new XYChart.Data(TabW[29],stat2.getBouira()));
        series1.getData().add(new XYChart.Data(TabW[30],stat2.getBordjBouArreridj()));          series1.getData().add(new XYChart.Data(TabW[31],stat2.getGuelma()));
        series1.getData().add(new XYChart.Data(TabW[32],stat2.getSkikda()));                    series1.getData().add(new XYChart.Data(TabW[33],stat2.getTiziOuzou()));
        series1.getData().add(new XYChart.Data(TabW[34],stat2.getMila()));                      series1.getData().add(new XYChart.Data(TabW[35],stat2.getElTarf()));
        series1.getData().add(new XYChart.Data(TabW[36],stat2.getBéjaïa()));                    series1.getData().add(new XYChart.Data(TabW[37],stat2.getTissemsilt()));
        series1.getData().add(new XYChart.Data(TabW[38],stat2.getJijel()));                     series1.getData().add(new XYChart.Data(TabW[39],stat2.getAïnTémouchent()));
        series1.getData().add(new XYChart.Data(TabW[40],stat2.getConstantine()));               series1.getData().add(new XYChart.Data(TabW[41],stat2.getMostaganem()));
        series1.getData().add(new XYChart.Data(TabW[42],stat2.getTipaza()));                    series1.getData().add(new XYChart.Data(TabW[43],stat2.getOran()));
        series1.getData().add(new XYChart.Data(TabW[44],stat2.getBoumerdès()));                 series1.getData().add(new XYChart.Data(TabW[45],stat2.getBlida()));
        series1.getData().add(new XYChart.Data(TabW[46],stat2.getAnnaba()));                    series1.getData().add(new XYChart.Data(TabW[47],stat2.getAlger()));
        
        
        barChart.getData().addAll(series1);series1.getChart().setMinSize(900,500);
       
        barChart.setId("Originechart");
        yAxis.setTickUnit(1);
     
       ;
        getChildren().add(barChart);  
               
           }
       }
       
       public class getCauseDeces extends Parent{
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();
           public getCauseDeces() throws SQLException{
    
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("Statistiques selon les Causes de déces ");
        xAxis.setLabel(" Causes ");     
        yAxis.setLabel(" Patients");
    
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Causes");
        
        series1.getData().add(new XYChart.Data("Total des Déces", stat.getTotalDeD())); 
        series1.getData().add(new XYChart.Data("Rvo", stat.getCauseD1()));        
        series1.getData().add(new XYChart.Data("Encephalopathie", stat.getCauseD2()));
        series1.getData().add(new XYChart.Data("Progression Tumorale", stat.getCauseD3()));  
        series1.getData().add(new XYChart.Data("autres", stat.getCauseD4()));
        barChart.getData().addAll(series1);
        series1.getChart().setPrefSize(900, 500);
        barChart.setId("DecesBar");
          barChart.setCategoryGap(100);      
        getChildren().add(barChart);
           }
       }
       
       public class EMTHepathiCirDec extends Parent{
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();
         
           public EMTHepathiCirDec() throws SQLException{
   
         final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("CIRCONSTANCES DE DECOUVERTE  ");
        xAxis.setLabel(" Oui / Non  ");     
        yAxis.setLabel(" Patients");
    
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("En même temps que l’hepatopathie sous jacente ");
        
        series1.getData().add(new XYChart.Data("Oui", Anal1.getOuiHepat())); 
        series1.getData().add(new XYChart.Data("Non", Anal1.getNonHepat()));        
        
        barChart.getData().addAll(series1);
   
        barChart.setCategoryGap(50);      
        getChildren().add(barChart);
        
        this.setTranslateY(30);
       }
           
       }
       public class AnalStatFourtuit extends Parent {
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();
         
           public AnalStatFourtuit() throws SQLException{
   
         final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("CIRCONSTANCES DE DECOUVERTE  ");
        xAxis.setLabel(" Oui / Non  ");     
        yAxis.setLabel(" Patients");
    
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Fourtuit ");
        
        series1.getData().add(new XYChart.Data("Oui", Anal1.getOuiFort())); 
        series1.getData().add(new XYChart.Data("Non", Anal1.getNonFort()));        
        
        barChart.getData().addAll(series1);
   
        barChart.setCategoryGap(50);      
        getChildren().add(barChart);
        
        this.setTranslateY(30);  
           
       }
       }
       
    public class DepEnCasCirConnu extends Parent{
        
        
        public DepEnCasCirConnu() {
                  
         final CategoryAxis      xAxis               = new CategoryAxis();
         final NumberAxis        yAxis               = new NumberAxis();
        
        final BarChart<String , Number> barChart     = new BarChart<>(xAxis ,yAxis);
        
        barChart.setTitle("CIRCONSTANCES DE DECOUVERTE ");
        xAxis.setLabel   (" Dépistage");
        yAxis.setLabel   (" patients ");
        
          XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Dépistage en cas de cirrhose connue ");
        
        series1.getData().add(new XYChart.Data("", Anal1.getOuiDEC())); 
        
       XYChart.Series             series2             = new XYChart.Series<>();
        series2.setName("Echographie ");
        series2.getData().add(new XYChart.Data("", Anal1.getEchohraph())); 
        
        XYChart.Series             series3             = new XYChart.Series<>();
        series3.setName("Dosage des AFP ");
        series3.getData().add(new XYChart.Data("", Anal1.getDosAFP())); 
        
        
        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2);
        shadow.setColor(Color.GREY);
        barChart.setEffect(shadow);
        
        //xAxis.setTickLabelRotation(90);
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.DARKBLUE);
        
        barChart.getData().addAll(series1,series2,series3);
       
        barChart.setCategoryGap(100);
        barChart.setPrefSize(700, 500);
      
        
        this.setTranslateY(30);
        getChildren().add(barChart);
        
        
        }
    }
    
    public class SigneGF extends Parent {

        public SigneGF() {
     
                          
         final CategoryAxis      xAxis               = new CategoryAxis();
         final NumberAxis        yAxis               = new NumberAxis();
        
        final BarChart<String , Number> barChart     = new BarChart<>(xAxis ,yAxis);
        
        barChart.setTitle("CIRCONSTANCES DE DECOUVERTE ");
        xAxis.setLabel   ("Signes généraux et fonctionnels ");
        yAxis.setLabel   (" patients ");
        
          XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Amaigrissement ");
        
        series1.getData().add(new XYChart.Data("", Anal1.getAmaigre())); 
        
       XYChart.Series             series2             = new XYChart.Series<>();
        series2.setName("Fièvre ");
        series2.getData().add(new XYChart.Data("", Anal1.getFievre())); 
        
        XYChart.Series             series3             = new XYChart.Series<>();
        series3.setName("Ictère ");
        series3.getData().add(new XYChart.Data("", Anal1.getIctere())); 
        
        XYChart.Series             series4             = new XYChart.Series<>();
        series4.setName("Douleur de l’hypochondre droit");
        series4.getData().add(new XYChart.Data("", Anal1.getDouleurHD()));
        
        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2);
        shadow.setColor(Color.GREY);
        barChart.setEffect(shadow);
        
        //xAxis.setTickLabelRotation(90);
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.DARKBLUE);
        
        barChart.getData().addAll(series1,series2,series3,series4);
       
        barChart.setCategoryGap(100);
        barChart.setPrefSize(700, 500);
      
        
        this.setTranslateY(30);
        getChildren().add(barChart);
        
        
        }
     
    }
    
    public class SigneHypertension extends Parent {

        public SigneHypertension() {
        
        
         final CategoryAxis      xAxis               = new CategoryAxis();
         final NumberAxis        yAxis               = new NumberAxis();
        
        final BarChart<String , Number> barChart     = new BarChart<>(xAxis ,yAxis);
        
        barChart.setTitle("CIRCONSTANCES DE DECOUVERTE ");
        xAxis.setLabel   (" Signes d’hypertension portale ");
        yAxis.setLabel   (" patients ");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Hémorragies digestives  ");
        
        series1.getData().add(new XYChart.Data("1", Anal1.getHemoragieDes())); 
        
        XYChart.Series             series2             = new XYChart.Series<>();
        series2.setName(" Ascite ");
        series2.getData().add(new XYChart.Data("2", Anal1.getAscite())); 
        
        XYChart.Series             series3             = new XYChart.Series<>();
        series3.setName("Splénomégalie ");
        series3.getData().add(new XYChart.Data("3", Anal1.getSplenomegalie())); 
        
        XYChart.Series             series5             = new XYChart.Series<>();
        series5.setName("Splénomégalie Type1 ");
        series5.getData().add(new XYChart.Data("3", Anal1.getTypeS1())); 
        
        XYChart.Series             series6             = new XYChart.Series<>();
        series6.setName("Splénomégalie Type2 ");
        series6.getData().add(new XYChart.Data("3", Anal1.getTypeS2())); 
        
        XYChart.Series             series7             = new XYChart.Series<>();
        series7.setName("Splénomégalie Type3 ");
        series7.getData().add(new XYChart.Data("3", Anal1.getTypeS3())); 
        
        XYChart.Series             series8             = new XYChart.Series<>();
        series8.setName("Splénomégalie Type4 ");
        series8.getData().add(new XYChart.Data("3", Anal1.getTypeS4())); 
        
        
        XYChart.Series             series4             = new XYChart.Series<>();
        series4.setName("Autres ");
        series4.getData().add(new XYChart.Data("4", Anal1.getAutre()));
        
        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2);
        shadow.setColor(Color.GREY);
        barChart.setEffect(shadow);
        
        //xAxis.setTickLabelRotation(90);
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.DARKBLUE);
        
        barChart.getData().addAll(series1,series2,series3,series4
                                 ,series5,series6,series7,series8);
       
       // barChart.setCategoryGap(100);
        barChart.setPrefSize(700, 500);
      
        
        this.setTranslateY(30);
        getChildren().add(barChart);
        
        }
        
        
    }
    
    public class SignesPhysique extends Parent {
        final String             styleSep       = "-fx-background-color : black ;"
                                                + "-fx-border-width: 3;"
                                                ;
        
        final GridPane           grid           = new GridPane();
        final Label[]            LabStade       = new Label[5];
        final Label[]            LabEtatS       = new Label[5];
        final int[]              LabContEtat    = {
       Anal1.getStade0(),Anal1.getStade1(),Anal1.getStade2(),Anal1.getStade3(),Anal1.getStade4()}; 
        
        final Label[]            LabBMI         = new Label[4];
        final Label[]            LabBMICont     = new Label[4];
        final String[]           BMIName        = {"<18","18-25",">25-30",">30"};
        final int[]              LabContBMI    = {
        Anal1.getBmi0(),Anal1.getBmi1(),Anal1.getBmi2(),Anal1.getBmi3()
        };
        
        final Separator          Sep1           = new Separator();
        final Separator          Sep2           = new Separator();
        final Separator          Sep3           = new Separator();
        
        
        
        public SignesPhysique() {
         
            grid.setVgap(5); 
            grid.setHgap(5);
        final Label         EtatGeneralOms          = new Label("ETAT GENERAL   STADE   OMS");  
        grid.add(EtatGeneralOms, 0,0,4,1);
        int Percent[]     =  
        {Anal1.getStade0()+Anal1.getStade1()+Anal1.getStade2()+Anal1.getStade3()+Anal1.getStade4()
        ,Anal1.getBmi0()+Anal1.getBmi1()+Anal1.getBmi2()+Anal1.getBmi3()};
        EtatGeneralOms.setId("LabelStatCaption");
         
        
        for(int i = 0 ; i< 5; i++){
            final  Label l   =  LabStade[i]  = new Label("Stade "+i);                grid.add(l, i, 1);
            final  Label li  =  LabEtatS[i]  = new Label((int)((LabContEtat[i]*100)/Percent[0])+"%");         grid.add(li, i, 2);
           
            l.setId("LabelStat");  l.setPrefWidth(100);
            li.setId("LabelStat"); li.setPrefWidth(100);
                    
        }
        
        Sep1.setOrientation(Orientation.HORIZONTAL);
        //Sep1.setTranslateY(10);
        Sep1.setStyle(styleSep);
        grid.add(Sep1,0,3,5,1);
        /***************************************/
        final   Label LabelBMI          = new Label("BMI"); LabelBMI.setId("LabelStatCaption");
        grid.add(LabelBMI, 0,5);
        for(int i = 0 ; i < 4 ; i++){
            final Label l   =  LabBMI[i]     = new Label(BMIName[i]);                                grid.add(l,  i, 6); l.setId("LabelStat");
            final Label li  =  LabBMICont[i] = new Label((int)((LabContBMI[i]*100)/Percent[1])+"%"); grid.add(li, i, 7); li.setId("LabetStat");
       
             l.setId("LabelStat");  l.setPrefWidth(100);
            li.setId("LabelStat"); li.setPrefWidth(100);
        }
        
        Sep2.setOrientation(Orientation.HORIZONTAL);
        //Sep2.setTranslateY(5);
        Sep2.setStyle(styleSep);
        grid.add(Sep2,0,8,5,1);
        
        final Label         LabelCVC      = new Label("CVC");   LabelCVC.setId("LabelStatCaption");
        final Label         LabelOMI      = new Label("OMI");   LabelOMI.setId("LabelStatCaption");
        final Label         LabelAutre    = new Label("Autre"); LabelAutre.setId("LabelStatCaption");
        grid.add(LabelCVC, 1,9);
        grid.add(LabelOMI, 2,9);
        grid.add(LabelAutre,3,9);
        final Label         Oui        = new Label("Oui");   Oui.setId("LabelStatCaption"); grid.add(Oui,0,10);
        final Label         OuiCVC     = new Label((int)(Anal1.getCvcOui() * 100 / (Anal1.getCvcOui() + Anal1.getCvcNon()))+"%");     grid.add(OuiCVC, 1,10);   OuiCVC.setId("LabelStat");
        final Label         OuiOMI     = new Label((int)(Anal1.getOmiOui() * 100 / (Anal1.getOmiOui() + Anal1.getOmiNon()))+"%");     grid.add(OuiOMI, 2,10);   OuiOMI.setId("LabelStat");
        final Label         Autre      = new Label((int)(Anal1.getAutreSignesPH() * 100 / (Anal1.getCvcOui() + Anal1.getCvcNon()))+"%");     grid.add(Autre,  3,10);   Autre.setId("LabelStat");
        
      
        Sep3.setOrientation(Orientation.HORIZONTAL);
        //Sep2.setTranslateY(5);
        Sep3.setStyle(styleSep);
        grid.add(Sep3,0,11,5,1);
        
        
        final Label         HPM             = new Label("HPM");    HPM.setId("LabelStatCaption"); 
        grid.add(HPM, 0,12,2,1);     HPM.setPrefWidth(120);
        final Label         Thpm            = new Label((int)((Anal1.getHpmOui()* 100)/(Anal1.getHpmOui()+Anal1.getHpmNon()))+"%");
        grid.add(Thpm,1,12);  Thpm.setId("LabelStat");
                
        final Label         FH              = new Label("FH");     FH.setId("LabelStatCaption");
        grid.add(FH,0,13,2,1);  FH.setPrefWidth(120);
        final Label         Tfh             = new Label((int)((Anal1.getFH()* 100)/(Anal1.getHpmOui()+Anal1.getHpmNon()))+"%");
        grid.add(Tfh,1,13); Tfh.setId("LabelStat");
        
        final Label         Consistance     = new Label("Consistance");   grid.add(Consistance, 0,14,2,1);
        Consistance.setId("LabelStatCaption");
        Consistance.setPrefWidth(120);
        final Label         Ferme           = new Label("Ferme");         grid.add(Ferme,1,14); Ferme.setId("LabelStat");
        final Label         Tferme          = new Label((int)((Anal1.getConsistFerme()*100/(Anal1.getConsistDure()+Anal1.getConsistFerme())))+"%");
        grid.add(Tferme, 1,15); Tferme.setId("LabelStat");
        final Label         Dure            = new Label("Dure");          grid.add(Dure, 2,14); Dure.setId("LabelStat");
        final Label         Tdure           = new Label((int)((Anal1.getConsistDure()*100/(Anal1.getConsistDure()+Anal1.getConsistFerme())))+"%");
        grid.add(Tdure, 2,15);Tdure.setId("LabelStat");
        final Label         Surface         = new Label("Surface");        grid.add(Surface, 3,14); Surface.setId("LabelStatCaption");
        final Label         Reg             = new Label("régulière");      grid.add(Reg, 4,14);     Reg.setId("LabelStat");
        final Label         Treg            = new Label((int)((Anal1.getSurfReg()*100)/(Anal1.getSurfIreg() + Anal1.getSurfReg()))+"%");
        Treg.setId("LabelStat");   grid.add(Treg, 4,15);  
        final Label         Ireg            = new Label(" irrégulière");   grid.add(Ireg,5,14);     Ireg.setId("LabelStat");
        final Label         Tireg           = new Label((int)((Anal1.getSurfIreg()*100)/(Anal1.getSurfIreg() + Anal1.getSurfReg()))+"%");
        Tireg.setId("LabelStat");   grid.add(Tireg, 5,15); 
        this.setTranslateY(30);
        getChildren().add(grid);
        }
        
        
    }
    
    public class Syndrom extends Parent 
    {
     
        public Syndrom(){
         final CategoryAxis      xAxis               = new CategoryAxis();
         final NumberAxis        yAxis               = new NumberAxis();

        
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("CIRCONSTANCES DE DECOUVERTE");
        xAxis.setLabel(" Oui/Non ");
        yAxis.setLabel(" Patients");
        
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Syndrome paranéoplasique");
        
        series1.getData().add(new XYChart.Data("Oui", Anal1.getSynfdromPOui()));
        series1.getData().add(new XYChart.Data("Non", Anal1.getSynfdromPNon()));
    
        barChart.getData().addAll(series1);
        //barChart.setBarGap(3);
        barChart.setCategoryGap(100);
          
        getChildren().add(barChart); 
        this.setTranslateY(30);
        }
    }

}