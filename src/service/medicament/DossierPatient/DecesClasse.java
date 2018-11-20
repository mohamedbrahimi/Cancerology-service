
package service.medicament.DossierPatient;

import java.util.Date;


public class DecesClasse {
    
    private Date   DateDeces ;
    private String Rvo ;
    private String Encephalopathie;
    private String ProgressionTumorale;
    private String AutreCause;

    public DecesClasse(Date DateDeces, String Rvo, String Encephalopathie, String ProgressionTumorale, String AutreCause) {
        this.DateDeces = DateDeces;
        this.Rvo = Rvo;
        this.Encephalopathie = Encephalopathie;
        this.ProgressionTumorale = ProgressionTumorale;
        this.AutreCause = AutreCause;
    }

    public Date getDateDeces() {
        return DateDeces;
    }

    public void setDateDeces(Date DateDeces) {
        this.DateDeces = DateDeces;
    }

    public String getRvo() {
        return Rvo;
    }

    public void setRvo(String Rvo) {
        this.Rvo = Rvo;
    }

    public String getEncephalopathie() {
        return Encephalopathie;
    }

    public void setEncephalopathie(String Encephalopathie) {
        this.Encephalopathie = Encephalopathie;
    }

    public String getProgressionTumorale() {
        return ProgressionTumorale;
    }

    public void setProgressionTumorale(String ProgressionTumorale) {
        this.ProgressionTumorale = ProgressionTumorale;
    }

    public String getAutreCause() {
        return AutreCause;
    }

    public void setAutreCause(String AutreCause) {
        this.AutreCause = AutreCause;
    }
    
    
}
