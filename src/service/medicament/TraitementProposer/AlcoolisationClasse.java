
package service.medicament.TraitementProposer;

import java.util.Date;

public class AlcoolisationClasse {
    
     private Date TDateTrait        ;
     private String TAlcoolisation    ;
     private String TDateAlcool       ;
     private String TDateDebAlcoolTrt ;
     private String TAlcoolIncidents  ; 

    public AlcoolisationClasse(Date TDateTrait, String TAlcoolisation, String TDateAlcool, String TDateDebAlcoolTrt, String TAlcoolIncidents) {
        this.TDateTrait = TDateTrait;
        this.TAlcoolisation = TAlcoolisation;
        this.TDateAlcool = TDateAlcool;
        this.TDateDebAlcoolTrt = TDateDebAlcoolTrt;
        this.TAlcoolIncidents = TAlcoolIncidents;
    }

    public Date getTDateTrait() {
        return TDateTrait;
    }

    public void setTDateTrait(Date TDateTrait) {
        this.TDateTrait = TDateTrait;
    }

    public String getTAlcoolisation() {
        return TAlcoolisation;
    }

    public void setTAlcoolisation(String TAlcoolisation) {
        this.TAlcoolisation = TAlcoolisation;
    }

    public String getTDateAlcool() {
        return TDateAlcool;
    }

    public void setTDateAlcool(String TDateAlcool) {
        this.TDateAlcool = TDateAlcool;
    }

    public String getTDateDebAlcoolTrt() {
        return TDateDebAlcoolTrt;
    }

    public void setTDateDebAlcoolTrt(String TDateDebAlcoolTrt) {
        this.TDateDebAlcoolTrt = TDateDebAlcoolTrt;
    }

    public String getTAlcoolIncidents() {
        return TAlcoolIncidents;
    }

    public void setTAlcoolIncidents(String TAlcoolIncidents) {
        this.TAlcoolIncidents = TAlcoolIncidents;
    }
     
     
}
