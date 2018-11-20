
package service.medicament.RendezVous;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public final class TraitementDesRendezVousSpace extends Parent{
    
    final String       styleButton     =     " -fx-font: 20 arial;"
                                           + " -fx-base: #fffff;"
                                           + " -fx-alignment:CENTER_LEFT;"
                                           + " -fx-background-color: black;"
                                           + " -fx-text-fill: white;"
                                           + " -fx-border-radius: 5;";
    
     
     final DatePicker           DateH             = new DatePicker();    
     final String[]             NamesColumn       = {"Temp","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
     final TableColumn[]        ColumnTab         = new TableColumn[NamesColumn.length];
     final DatePicker           date              = new DatePicker(); 
     final Label                labelCurrentDate  = new Label("Aujourd'huit " + LocalDate.now());
      
     int DayeIndique = 7;
     int TauxRecul   = 0;
     
     int NumWeek     = 0;
     final Label   DateMonthB             = new Label();

    public TraitementDesRendezVousSpace() throws SQLException{
        final     ObservableList<WeekClasse> data        =  new WeekClasse("","","","","","","","").getWeeKRDV(NumWeek);
        
        final VBox                 vbox              = new VBox(30);   vbox.setPadding(new Insets(10,10,10,10));
        final TableView            tabel             = new TableView(); 
        final VBox                 toolHeure         = new VBox(5);
        final String[]             toolStr           = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00" };
        for(int i = 0 ; i<8;i++){
         final Label             toolLabel           = new Label(toolStr[i]);
         toolLabel.getStyleClass().add("styleButton");
         toolHeure.getChildren().add(toolLabel);
        }
        
        //toolHeure.getStyleClass().add("StyleLabelH");
        toolHeure.setVisible(false);
        
        /////////////////////////////////////////////////////////////////////////////////////
            Callback<TableColumn, TableCell> cellFactory =
        new Callback<TableColumn, TableCell>() {
        public TableCell call(TableColumn p) {
        return new EditingCell(); 
        } 
        };
        
        /////////////////////////////////////////////////////////////////////////////////////
        final VBox                 vboxTab            = new VBox(2);
        vboxTab.setPrefHeight(300);
        //vboxTab.getChildren().add(tabel);
        final ScrollPane           sc                 = new ScrollPane(tabel);
        sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tabel.setOnMouseEntered(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {

            toolHeure.setVisible(true);
            toolHeure.setTranslateX(-85);
            toolHeure.setTranslateY(100);
            }
            
        });
        tabel.setOnMouseExited(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
             toolHeure.setVisible(false);
             toolHeure.setTranslateX(0);
             toolHeure.setTranslateY(0);
            }
            
        });
       
        
        date.setValue(LocalDate.now());
        System.out.println(date.getValue().getDayOfWeek().getValue());
        tabel.setEditable(true);
        for(int i = 0 ; i < ColumnTab.length ; i++){
            

            TableColumn         tc          =  ColumnTab[i]    = new TableColumn(NamesColumn[i]);
            tc.setPrefWidth(230);
            
            tabel.getColumns().add(tc);
            if(i==0){tc.setCellValueFactory(new PropertyValueFactory<>("Heure"));
            tc.setPrefWidth(100);
            }else {
                tc.setCellValueFactory(new PropertyValueFactory<>(NamesColumn[i]));
                tc.setCellFactory(cellFactory);
                specifDay(i,tc);}
        }
        System.out.println((Integer) LocalDate.now().getDayOfWeek().getValue());
        labelCurrentDate.getStyleClass().add("StyleLabelH");
        labelCurrentDate.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               for(int i =1;i<8 ;i++){
                  
                  TableColumn  tc  =  ColumnTab[i] ;
                  tc.setText(NamesColumn[i]+" ");
                  specifDay(i, tc);
                  try {
                NumWeek     = 0;
                DayeIndique = 7;
                TauxRecul   = 0;
               
                final     ObservableList<WeekClasse> data1        =  new WeekClasse("","","","","","","","").getWeeKRDV(NumWeek);
                tabel.setItems(data1);
                
                } catch (SQLException ex) {
                Logger.getLogger(TraitementDesRendezVousSpace.class.getName()).log(Level.SEVERE, null, ex);
            }
               }
            }
            
        });
        vbox.setMaxWidth(1000);
        vbox.prefHeight(1000);
        tabel.setPrefHeight(500);
        vbox.getChildren().addAll(labelCurrentDate,tabel);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        final HBox    hbDateCurrent          = new HBox(5);
        final Button  AvanceDateB            = new Button();  final ImageView AvanceImg     = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png"))); AvanceImg.setFitHeight(20);AvanceImg.setFitWidth(25);
        AvanceDateB.setGraphic(AvanceImg);
        AvanceDateB.getStyleClass().add("styleButton1");
        
        final Button  RevenirDateB           = new Button(); final ImageView ReculImg      = new ImageView(new Image(getClass().getResourceAsStream("Images/4.png"))); ReculImg.setFitHeight(20); ReculImg.setFitWidth(25); ReculImg.setRotate(180);
        RevenirDateB.setGraphic(ReculImg);
        RevenirDateB.getStyleClass().add("styleButton1");
        
        DateMonthB.setText(LocalDate.now().getMonth()+ " " + LocalDate.now().getYear());
        DateMonthB.getStyleClass().add("StyleLabelH");
        DateMonthB.setTranslateY(-5);
        DateMonthB.setPrefWidth(200);
        
        hbDateCurrent.getChildren().addAll(RevenirDateB,DateMonthB,AvanceDateB);
        hbDateCurrent.setTranslateX(570);
        hbDateCurrent.setTranslateY(-590);
        
        ///////////////////////////////////
       // final int DayeIndique = 8;
        AvanceDateB.setOnAction((ActionEvent)-> {
            try {
                AvacneClaneder(1);
                System.out.println("NumWeek = " +NumWeek );
                final     ObservableList<WeekClasse> data1        =  new WeekClasse("","","","","","","","").getWeeKRDV(NumWeek);
                tabel.setItems(data1);
            } catch (SQLException ex) {
                Logger.getLogger(TraitementDesRendezVousSpace.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println(ex.getLocalizedMessage());
            }
           
           
        });
        RevenirDateB.setOnAction((ActionEvent)->{
            try {
                AvacneClaneder(0);
                System.out.println("NumWeek = " +NumWeek );
                if(NumWeek >= 0){
                final     ObservableList<WeekClasse> data1        =  new WeekClasse("","","","","","","","").getWeeKRDV(NumWeek);
                
                tabel.setItems(data1);
                }
                } catch (SQLException ex) {
                Logger.getLogger(TraitementDesRendezVousSpace.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getLocalizedMessage());
            }
           
           
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        vbox.getChildren().add(hbDateCurrent);
        getChildren().add(vbox);
        getChildren().add(toolHeure);
        tabel.setItems(data);
        date.getValue().getDayOfWeek();
        this.setTranslateX(250);
        this.setTranslateY(0);
    }
    
    public void specifDay(int i,TableColumn tc){
        if(LocalDate.now().getDayOfWeek().getValue() == i){
            tc.setText(tc.getText() +" " + LocalDate.now() );
        }else if(LocalDate.now().getDayOfWeek().getValue() < i){
            tc.setText(tc.getText() +" " + LocalDate.now().plusDays(i-LocalDate.now().getDayOfWeek().getValue()) );
        }else {
            tc.setText(tc.getText() +" " + LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue()-i) );
        }
        
    }
    
    public String LabelDaySpecf(){
        
        return "";
    }
    public void AvacneClaneder(int Dest){
        
        int NumDay  = LocalDate.now().getDayOfWeek().getValue();
        if(Dest == 1){
           NumWeek++;
        for(int i = 1; i<8;i++){
            TableColumn         tc          =  ColumnTab[i] ;
            if(NumDay == i){
             
             tc.setText(NamesColumn[i]+" "+LocalDate.now().plusDays(DayeIndique ));
            }else if(NumDay < i){
             tc.setText(NamesColumn[i]+" "+LocalDate.now().plusDays(i-NumDay).plusDays(DayeIndique )); 
            }else
             tc.setText(NamesColumn[i]+" "+LocalDate.now().minusDays(NumDay-i).plusDays(DayeIndique ));
                }
        setDateMonthB(LocalDate.now().plusDays(DayeIndique).getMonth()+" "+LocalDate.now().plusDays(DayeIndique ).getYear());
         this.DayeIndique = this.DayeIndique + 7 ;
          
         
        }
        else if(DayeIndique > 7){
            this.DayeIndique = this.DayeIndique - 7;
            for(int i =1 ; i<8;i++){
             TableColumn         tc          =  ColumnTab[i] ;  
             if(NumDay == i){
             
             tc.setText(NamesColumn[i]+" "+LocalDate.now().plusDays(DayeIndique).minusDays(7));
            }else if(NumDay < i){
             tc.setText(NamesColumn[i]+" "+LocalDate.now().plusDays(i-NumDay).plusDays(DayeIndique).minusDays(7)); 
            }else
             tc.setText(NamesColumn[i]+" "+LocalDate.now().minusDays(NumDay-i).plusDays(DayeIndique).minusDays(7));
                }
            this.setDateMonthB(LocalDate.now().plusDays(DayeIndique).minusDays(7).getMonth()+" "+LocalDate.now().plusDays(DayeIndique).minusDays(7).getYear());
            
            if(NumWeek > 0)NumWeek--;
           }else if(DayeIndique == 7){
             for(int i =1 ; i<8;i++){
             TableColumn         tc          =  ColumnTab[i] ;  
             if(NumDay == i){
             
             tc.setText(NamesColumn[i]+" "+LocalDate.now().plusDays(DayeIndique).minusDays(7));
            }else if(NumDay < i){
             tc.setText(NamesColumn[i]+" "+LocalDate.now().plusDays(i-NumDay).plusDays(DayeIndique).minusDays(7)); 
            }else
             tc.setText(NamesColumn[i]+" "+LocalDate.now().minusDays(NumDay-i).plusDays(DayeIndique).minusDays(7));
                }
            this.setDateMonthB(LocalDate.now().plusDays(DayeIndique).minusDays(7).getMonth()+" "+LocalDate.now().plusDays(DayeIndique).minusDays(7).getYear());
            
            if(NumWeek > 0)NumWeek--;
           }
    }
    
    public void setDateMonthB(String DateInd) {
        DateMonthB.setText(DateInd);
    }
    
        private static class EditingCell extends TableCell<CalenderClass,String> {
       
       private TextField textField;
       public EditingCell() {
      }
     
   
      public void updateItem(String item, boolean empty) {
      super.updateItem(item, empty);
      if (empty) {
      setText(null);
       setGraphic(null);
      
      } 
      
      else {
      if (!isEditing()) {
      setText(getString());
      setGraphic(null);
       if(!(item == null || item.equals(""))){
          getStyleClass().add("StyleLabelAffichage");
      }else {
          getStyleClass().remove("StyleLabelAffichage");
      
      }
      }
     } 
     
     
      }    

private String getString() {
return getItem() == null ? "" : getItem().toString();
}
    }
}
