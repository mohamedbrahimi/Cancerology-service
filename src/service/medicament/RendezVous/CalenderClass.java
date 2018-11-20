
package service.medicament.RendezVous;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;


public class CalenderClass {
    private LocalDate   dateRDV ;
    private final SimpleStringProperty heurRDV;
    private final SimpleStringProperty avec;
    private final SimpleStringProperty sujetRDV;
    
    
    
    
    public CalenderClass(LocalDate dateRDV,String heurRDV,String avec,String sujet){
        this.dateRDV    = dateRDV;
        this.heurRDV    = new SimpleStringProperty(heurRDV);
        this.avec       = new SimpleStringProperty(avec);
        this.sujetRDV   = new SimpleStringProperty(sujet);
        
        
    }
    
     public LocalDate getDateRDV() {
        return dateRDV;
    }

    public String getHeurRDV() {
        return heurRDV.get();
    }
     public String getAvec() {
        return avec.get();
    }

    public String getSujet() {
        return sujetRDV.get();
    }
    
    public void setDateRDV(LocalDate date){
        dateRDV = date;
    }
    public void setHeureRDV(String Heure){
        heurRDV.set(Heure);
    }
    public void setavec(String av){
        avec.set(av);
    }
    public void setsujetRDV(String sujet){
        sujetRDV.set(sujet);
    }
    
}
