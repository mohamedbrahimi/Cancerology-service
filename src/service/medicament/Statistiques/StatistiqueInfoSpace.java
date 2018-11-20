
package service.medicament.Statistiques;

import java.awt.Transparency;
import java.sql.SQLException;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import service.medicament.Patient.PatientClasse;


public class StatistiqueInfoSpace extends Parent{
    
    final   TableView         table    = new TableView();
    final   TableColumn       TypeCol  = new TableColumn();
    final   AgeStat           AgeStati = new AgeStat(); 
    final   FemmeHommeStat    FHStat   = new FemmeHommeStat();
    final   CondSocioEcoStat  CondSoc  = new CondSocioEcoStat();
    final   SituatFamilial    StauatF  = new SituatFamilial();
    final   getOrigineStat    Origine  = new getOrigineStat();
    final   getCauseDeces     CauseD   = new getCauseDeces();
    
    
    final   VBox            ContenuS = new VBox(); 
    public StatistiqueInfoSpace() throws SQLException{
        ContenuS.setPrefSize(500, 400);
        ContenuS.setTranslateX(400); ContenuS .setTranslateY(20);
        ObservableList<simpleTypeStat>   data   = new simpleTypeStat("").getDataTable();
        
        TypeCol.setText("Type De Statistique ");
        TypeCol.setPrefWidth(350);
        TypeCol.setCellValueFactory(
        new PropertyValueFactory<>("Type"));
        
        table.getColumns().add(TypeCol);
        table.setItems(data);
        table.setMaxHeight(300);
        
        /**/
         table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
      try{
            simpleTypeStat Type = (simpleTypeStat)table.getSelectionModel().getSelectedItem();
            if(Type.getType().equals("Age")){
               ContenuS.getChildren().clear();
               ContenuS.getChildren().add(AgeStati);
            }else if(Type.getType().equals("Femme/Homme")){
               ContenuS.getChildren().clear(); 
               ContenuS.getChildren().add(FHStat);
            }else if(Type.getType().equals("Condition Socio/Echonomique")){
                ContenuS.getChildren().clear();
                ContenuS.getChildren().add(CondSoc);
            }else if(Type.getType().equals("Situation familiale")){
                ContenuS.getChildren().clear();
                ContenuS.getChildren().add(StauatF);
            }else if(Type.getType().equals("Origine")){
                ContenuS.getChildren().clear();
                ContenuS.getChildren().add(Origine);
            }else if(Type.getType().equals("Causes de Decés")){
                ContenuS.getChildren().clear();
                ContenuS.getChildren().add(CauseD);
            }
      }catch(Exception e){ 
      }
    });
        getChildren().addAll(table,ContenuS );
    }
    /************************************************************************/
    /***************************************************************************/
     public class simpleTypeStat{
         
         private String Type;
         public simpleTypeStat(String Type){
             
             this.Type = Type;
         }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }
         /**/
        public ObservableList<simpleTypeStat> getDataTable(){
            ObservableList<simpleTypeStat>   data          = FXCollections.observableArrayList(
             new simpleTypeStat("Age"),new simpleTypeStat("Femme/Homme"),new simpleTypeStat("Condition Socio/Echonomique"),
             new simpleTypeStat("Situation familiale"),new simpleTypeStat("Origine")
            ,new simpleTypeStat("Causes de Decés"));
        
        return data;
        }
         
     }
     /*********************************************/
     /***Age Statistique ****/
     
     public class AgeStat extends Parent{
         
         public AgeStat() throws SQLException{
             
        StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
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
        StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
        
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
        StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat(); 
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
         StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
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
           StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStatWilaya();
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
        
        series1.getData().add(new XYChart.Data(TabW[0], stat.getAdrar()));                   /**/ series1.getData().add(new XYChart.Data(TabW[1], stat.getChlef()));
        series1.getData().add(new XYChart.Data(TabW[2], stat.getTamanrasset()));             /**/ series1.getData().add(new XYChart.Data(TabW[3], stat.getIllizi()));
        series1.getData().add(new XYChart.Data(TabW[4], stat.getOuargla()));                 /**/ series1.getData().add(new XYChart.Data(TabW[5], stat.getBechar()));
        series1.getData().add(new XYChart.Data(TabW[6], stat.getTindouf()));                 /**/ series1.getData().add(new XYChart.Data(TabW[7], stat.getGhardaïa()));
        series1.getData().add(new XYChart.Data(TabW[8], stat.getBayadh()));                  /**/ series1.getData().add(new XYChart.Data(TabW[9], stat.getDjelfa()));
        series1.getData().add(new XYChart.Data(TabW[10],stat.getOued()));                    /**/ series1.getData().add(new XYChart.Data(TabW[11],stat.getNaâma()));
        series1.getData().add(new XYChart.Data(TabW[12],stat.getLaghouat()));                /**/ series1.getData().add(new XYChart.Data(TabW[13],stat.getBiskra()));
        series1.getData().add(new XYChart.Data(TabW[14],stat.getTiaret()));                  series1.getData().add(new XYChart.Data(TabW[15],stat.getMsila()));
        series1.getData().add(new XYChart.Data(TabW[16],stat.getTébessa()));                   series1.getData().add(new XYChart.Data(TabW[17],stat.getBatna()));
        series1.getData().add(new XYChart.Data(TabW[18],stat.getKhenchela()));                 series1.getData().add(new XYChart.Data(TabW[19],stat.getSidiBelAbbès()));
        series1.getData().add(new XYChart.Data(TabW[20],stat.getTlemcen()));                   series1.getData().add(new XYChart.Data(TabW[21],stat.getMédéa()));
        series1.getData().add(new XYChart.Data(TabW[22],stat.getOumElBouaghi()));              series1.getData().add(new XYChart.Data(TabW[23],stat.getSaïda()));
        series1.getData().add(new XYChart.Data(TabW[24],stat.getSétif()));                     series1.getData().add(new XYChart.Data(TabW[25],stat.getMascara()));
        series1.getData().add(new XYChart.Data(TabW[26],stat.getAïnDefla()));                  series1.getData().add(new XYChart.Data(TabW[27],stat.getRelizane()));
        series1.getData().add(new XYChart.Data(TabW[28],stat.getSoukAhras()));                 series1.getData().add(new XYChart.Data(TabW[29],stat.getBouira()));
        series1.getData().add(new XYChart.Data(TabW[30],stat.getBordjBouArreridj()));          series1.getData().add(new XYChart.Data(TabW[31],stat.getGuelma()));
        series1.getData().add(new XYChart.Data(TabW[32],stat.getSkikda()));                    series1.getData().add(new XYChart.Data(TabW[33],stat.getTiziOuzou()));
        series1.getData().add(new XYChart.Data(TabW[34],stat.getMila()));                      series1.getData().add(new XYChart.Data(TabW[35],stat.getElTarf()));
        series1.getData().add(new XYChart.Data(TabW[36],stat.getBéjaïa()));                    series1.getData().add(new XYChart.Data(TabW[37],stat.getTissemsilt()));
        series1.getData().add(new XYChart.Data(TabW[38],stat.getJijel()));                     series1.getData().add(new XYChart.Data(TabW[39],stat.getAïnTémouchent()));
        series1.getData().add(new XYChart.Data(TabW[40],stat.getConstantine()));               series1.getData().add(new XYChart.Data(TabW[41],stat.getMostaganem()));
        series1.getData().add(new XYChart.Data(TabW[42],stat.getTipaza()));                    series1.getData().add(new XYChart.Data(TabW[43],stat.getOran()));
        series1.getData().add(new XYChart.Data(TabW[44],stat.getBoumerdès()));                 series1.getData().add(new XYChart.Data(TabW[45],stat.getBlida()));
        series1.getData().add(new XYChart.Data(TabW[46],stat.getAnnaba()));                    series1.getData().add(new XYChart.Data(TabW[47],stat.getAlger()));
        
        
        barChart.getData().addAll(series1);series1.getChart().setMinSize(900,500);
       
        yAxis.setTickUnit(1);
     
       ;
        getChildren().add(barChart);  
               
           }
       }
       
       public class getCauseDeces extends Parent{
        final CategoryAxis      xAxis               = new CategoryAxis();
        final NumberAxis        yAxis               = new NumberAxis();
           public getCauseDeces() throws SQLException{
        StatistiqueClasse     stat         = new StatistiqueClasse().getInfoStat();
        final BarChart<String , Number> barChart    = new BarChart<>(xAxis,yAxis);
        
        barChart.setTitle("Statistiques selon les Causes de déces ");
        xAxis.setLabel(" Causes ");     
        yAxis.setLabel(" Patients");
        //xAxis.setTickLabelRotation(80);
        XYChart.Series          series1             = new XYChart.Series<>();
        series1.setName("Causes");
        
        series1.getData().add(new XYChart.Data("Total des Déces", stat.getTotalDeD())); 
        series1.getData().add(new XYChart.Data("Rvo", stat.getCauseD1()));        
        series1.getData().add(new XYChart.Data("Encephalopathie", stat.getCauseD2()));
        series1.getData().add(new XYChart.Data("Progression Tumorale", stat.getCauseD3()));  
        series1.getData().add(new XYChart.Data("autres", stat.getCauseD4()));
        barChart.getData().addAll(series1);
        series1.getChart().setPrefSize(600, 400);
        barChart.setId("DecesBar");
                
        getChildren().add(barChart);
           }
       }
        /*******************************************************************************/
    
}
