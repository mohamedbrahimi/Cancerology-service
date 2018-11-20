
package service.medicament.RendezVous;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.medicament.RendezVous.SGBD.ConsultationRDV;


public class WeekClasse {
    private String Lundi;
    private String Mardi;
    private String Mercredi;
    private String Jeudi;
    private String Vendredi;
    private String Samedi;
    private String Dimanche;
    private String Heure;

    public WeekClasse(String Heure, String Lundi, String Mardi, String Mercredi, String Jeudi, String Vendredi, String Samedi, String Dimanche) {
       
        this.Heure    = Heure;
        this.Lundi    = Lundi;
        this.Mardi    = Mardi;
        this.Mercredi = Mercredi;
        this.Jeudi    = Jeudi;
        this.Vendredi = Vendredi;
        this.Samedi   = Samedi;
        this.Dimanche = Dimanche;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String Heure) {
        this.Heure = Heure;
    }
    
    public String getLundi() {
        return Lundi;
    }

    public void setLundi(String Lundi) {
        this.Lundi = Lundi;
    }

    public String getMardi() {
        return Mardi;
    }

    public void setMardi(String Mardi) {
        this.Mardi = Mardi;
    }

    public String getMercredi() {
        return Mercredi;
    }

    public void setMercredi(String Mercredi) {
        this.Mercredi = Mercredi;
    }

    public String getJeudi() {
        return Jeudi;
    }

    public void setJeudi(String Jeudi) {
        this.Jeudi = Jeudi;
    }

    public String getVendredi() {
        return Vendredi;
    }

    public void setVendredi(String Vendredi) {
        this.Vendredi = Vendredi;
    }

    public String getSamedi() {
        return Samedi;
    }

    public void setSamedi(String Samedi) {
        this.Samedi = Samedi;
    }

    public String getDimanche() {
        return Dimanche;
    }

    public void setDimanche(String Dimanche) {
        this.Dimanche = Dimanche;
    }
    
    public ObservableList<WeekClasse>  getWeeKRDV(int i) throws SQLException{
        
        CalenderClass              Calender      = null;
       ObservableList<WeekClasse>    Week          = FXCollections.observableArrayList(
                               new WeekClasse("09:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),new WeekClasse("10:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),
                               new WeekClasse("11:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),new WeekClasse("12:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),
                               new WeekClasse("13:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),new WeekClasse("14:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),
                               new WeekClasse("15:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"),new WeekClasse("16:00","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n","\n\n"));
        
        
        ConsultationRDV   RDVCons    = new ConsultationRDV();
        ResultSet         res        = RDVCons.ExtRDV(i);
        try{
       
        
            while(res.next()){
        Calender      =  new CalenderClass(ConvertDateToLocalDate(res.getDate(2)),res.getString(3),res.getString(4),res.getString(5)); 
        System.out.println(Calender.getDateRDV() + "  " +Calender.getHeurRDV() +"  "+Calender.getAvec()+"  "+Calender.getSujet());
            if(this.SpecifRDVDayCol(Calender) == 1){
        Week.get(SpecifRDVDayRow(Calender)).setLundi(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        if(this.SpecifRDVDayCol(Calender) == 2){
        Week.get(SpecifRDVDayRow(Calender)).setMardi(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        if(this.SpecifRDVDayCol(Calender) == 3){
        Week.get(SpecifRDVDayRow(Calender)).setMercredi(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        if(this.SpecifRDVDayCol(Calender) == 4){
        Week.get(SpecifRDVDayRow(Calender)).setJeudi(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        if(this.SpecifRDVDayCol(Calender) == 5){
        Week.get(SpecifRDVDayRow(Calender)).setVendredi(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        if(this.SpecifRDVDayCol(Calender) == 6){
        Week.get(SpecifRDVDayRow(Calender)).setSamedi(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        if(this.SpecifRDVDayCol(Calender) == 7){
        Week.get(SpecifRDVDayRow(Calender)).setDimanche(Calender.getAvec()+"\n"+Calender.getSujet());
        }
        }
        
        RDVCons.CloseConnex();
        }catch(Exception e){
            
        }
        
        
        
        return Week;
      
    }
    
    public  int SpecifRDVDayCol(CalenderClass Element){
       
        int Col  = (Element.getDateRDV().getDayOfWeek().getValue());
        
        return Col;
    }
     public  int SpecifRDVDayRow(CalenderClass Element){
        int Row  = (Integer.parseInt(Element.getHeurRDV().substring(0, 2))- 9);
        
        return Row;
    }
     
     public  LocalDate ConvertDateToLocalDate(Date id){
                 Instant instant = Instant.ofEpochMilli(id.getTime());
                 LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
                 return localDate;
     }
     
     public ObservableList<JourClasse> getJourRDV() throws SQLException{
         ObservableList<JourClasse>    Jour          = FXCollections.observableArrayList(new JourClasse("09:00","\n\n"),new JourClasse("10:00","\n\n"),new JourClasse("11:00","\n\n"),
                                                                                         new JourClasse("12:00","\n\n"),new JourClasse("13:00","\n\n"),new JourClasse("14:00","\n\n"),
                                                                                         new JourClasse("15:00","\n\n"),new JourClasse("16:00","\n\n"));
         ConsultationRDV  RDVjour      = new ConsultationRDV();
         ResultSet        res          = RDVjour.ExtRDVjour();
         
         while(res.next()){
         CalenderClass Calender      =  new CalenderClass(ConvertDateToLocalDate(res.getDate(2)),res.getString(3),res.getString(4),res.getString(5));    
         Jour.get(SpecifRDVDayRow(Calender)).setContenuRdv(Calender.getAvec()+"\n"+Calender.getSujet());
         }
         
         RDVjour.CloseConnex();
         
         
         return Jour;
     }
  
}
