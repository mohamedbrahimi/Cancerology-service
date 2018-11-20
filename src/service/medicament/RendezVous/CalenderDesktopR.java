
package service.medicament.RendezVous;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class CalenderDesktopR extends Parent{
    
    final     TitledPane                titledpane      =  new TitledPane(); 
    final     Label                     caption         =  new Label("Aujourd'hui ");
    final     TableColumn               TimeHRCol       =  new TableColumn("Heure");
    final     TableColumn               rdvCol          =  new TableColumn("Rendez Vous");
    ObservableList<JourClasse> data;
            
    public CalenderDesktopR() throws SQLException{
        this.data = new WeekClasse("","","","","","","","").getJourRDV();
    final     DatePicker       date      = new DatePicker();   
    final     Group            root      =  new Group();
    final     VBox             vbox      =  new VBox();
    final     TableView        table     =  new TableView();
    vbox.setPadding(new Insets(10,10,10,10));
    vbox.setSpacing(5);
    table.setEditable(true);
    table.setPrefHeight(390);
    Callback<TableColumn, TableCell> cellFactory =
        new Callback<TableColumn, TableCell>() {
        public TableCell call(TableColumn p) {
        return new EditingCell(); 
        } 
        };
    TimeHRCol.setPrefWidth(100);
    TimeHRCol.setCellValueFactory(
    new PropertyValueFactory<>("HeurRdv"));
    rdvCol.setPrefWidth(260);
    rdvCol.setCellValueFactory(
    new PropertyValueFactory<>("ContenuRdv"));
    
    rdvCol.setCellFactory(cellFactory);
    rdvCol.setOnEditCommit( new EventHandler<TableColumn.CellEditEvent<CalenderClass,String>>(){

            @Override
            public void handle(TableColumn.CellEditEvent<CalenderClass, String> event) {           
                
            System.out.println(event.getTableView().getItems().get(event.getTablePosition().getRow()).getHeurRDV());
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setHeureRDV(event.getNewValue());
            
            }
          
      });
   // TimeHRCol.setCellFactory(cellFactory);
    TimeHRCol.setOnEditCommit( new EventHandler<TableColumn.CellEditEvent<CalenderClass,String>>(){

            @Override
            public void handle(TableColumn.CellEditEvent<CalenderClass, String> event) {           
                
            System.out.println(event.getTableView().getItems().get(event.getTablePosition().getRow()).getSujet());
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setsujetRDV(event.getNewValue());
            
            }
          
      });
           
    String gh ="\n\n";
    System.out.println("length"+gh.trim().length());
    date.setValue(LocalDate.now());
    caption.setText(caption.getText() + date.getValue());
    
    
    String  ts     = " -fx-font-size         : 12pt;\n" +
"    -fx-font-family       : \"Georgia\";\n" +
"    -fx-background-color  : rgb(170,140,140); \n" +
"    -fx-padding           : 5px 10px 10px 10px;\n" +
"    -fx-background-radius : 5;";
    String  tp     = " -fx-font-size         : 12pt;\n" +
"    -fx-font-family       : \"Georgia\";\n" +
"    -fx-background-color  : rgb(157,157,255); \n" +
"    -fx-padding           : 5px 10px 10px 10px;\n" +
"    -fx-background-radius : 5;"; 
    String tg      = " -fx-font-size         : 12pt;\n" +
"    -fx-font-family       : \"Georgia\";\n" +
"    -fx-background-color  : white; \n" +
"    -fx-padding           : 5px 10px 10px 10px;\n" +
"    -fx-background-radius : 5;";
 
    
    caption.setStyle(ts);
    
    caption.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {

                try {
                    caption.setStyle(tg);
                    data = new WeekClasse("","","","","","","","").getJourRDV();
                    table.setItems(data);
                } catch (SQLException ex) {
                    Logger.getLogger(CalenderDesktopR.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

    });
   
    caption.setOnMouseEntered( new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
            caption.setStyle(tp);
            }
        
    });
    caption.setOnMouseExited(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
            caption.setStyle(ts);
                    
            }
        
    });
    
    table.setItems(data);/*
    table.setStyle("-fx-border-style: solid;"
                +  "-fx-border-width: 1;"
                + "-fx-border-color: #ADDFFF;"
                + "-fx-accent: #ADDFFF;"
                
                + "-fx-base:  rgb(86,169,186);"
                + "-fx-background: white;"
                + "-fx-control-inner-background: white;"
                + "-fx-focus-color: #ADDFFF;"
                + "-fx-dark-text-color: deepskyblue;"
                + "-fx-mid-text-color: black;"
                + "-fx-light-text-color: blue;");*/
    table.getColumns().addAll(TimeHRCol,rdvCol);
    
    titledpane.setStyle("    \n" +
"    -fx-font-family  : \"Georgia\";\n" +
"    -fx-base         : rgb(200, 70, 253);\n" +
"    -fx-background   : rgb(225, 228, 203);\n" +
"    \n" +
"    -fx-font-size   : 11pt;\n" +
"    \n" +
"    -fx-text-fill   : white;\n" +
"    -fx-alignment   : center-left;\n" +
"    -fx-opacity     : 1;\n" +
"    -fx-base        : #1d1d1d;\n" +
"    //-fx-control-inner-background : #1d1d1d;\n" +
"    -fx-background-color         : #1d1d1d;");
    
 
            
            
    titledpane.setContent(table);
    titledpane.setText("Rendez Vous");
    titledpane.setAnimated(true);
    titledpane.setExpanded(true);
    
    vbox.getChildren().addAll(caption,titledpane);
    
    getChildren().add(vbox);
    
    
    this.setOpacity(0.7);
    this.setTranslateX(900);
    this.setTranslateY(110);
    
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
       if((item.trim().length() != 0)){
         setStyle("    -fx-font-size         : 12pt;\n" +
"    -fx-font-family       : \"Georgia\";\n" +
"    -fx-background-color  : rgb(157,157,255); \n" +
"    -fx-padding           : 5px 10px 10px 10px;\n" +
"    -fx-background-radius : 5;");
    
          
      }else if(item.matches("[a-zA-Z]+")){
          setStyle(" -fx-background-color : blue;");
      
      }
      }
     } 
     
     
      }    

private String getString() {
return getItem() == null ? "" : getItem().toString();
}
    }
}
      
