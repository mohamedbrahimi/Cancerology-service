
package service.medicament.TraitementProposer;

import java.util.Date;
import javafx.scene.control.Label;

public class RadioFrequenceClasse {
    
    private Date   TDateDeTrait            ;
    private String TRadioFrequence         ;
    private String TRadioFreqPercutannee   ;
    private String TDateRadioFreq          ;
    private String TFreqDateDebTrt         ;
    private String TFreqDoulHepat          ;
    private String TFreqNausee             ;
    private String TFreqVomissement        ;
    private String TFreqFievre             ;
    private String TFreqAutres             ;
    private String TFreqNbrCure            ;

    public RadioFrequenceClasse(Date TDateDeTrait, String TRadioFrequence, String TRadioFreqPercutannee, String TDateRadioFreq, String TFreqDateDebTrt, String TFreqDoulHepat, String TFreqNausee, String TFreqVomissement, String TFreqFievre, String TFreqAutres, String TFreqNbrCure) {
        this.TDateDeTrait = TDateDeTrait;
        this.TRadioFrequence = TRadioFrequence;
        this.TRadioFreqPercutannee = TRadioFreqPercutannee;
        this.TDateRadioFreq = TDateRadioFreq;
        this.TFreqDateDebTrt = TFreqDateDebTrt;
        this.TFreqDoulHepat = TFreqDoulHepat;
        this.TFreqNausee = TFreqNausee;
        this.TFreqVomissement = TFreqVomissement;
        this.TFreqFievre = TFreqFievre;
        this.TFreqAutres = TFreqAutres;
        this.TFreqNbrCure = TFreqNbrCure;
    }

    public Date getTDateDeTrait() {
        return TDateDeTrait;
    }

    public void setTDateDeTrait(Date TDateDeTrait) {
        this.TDateDeTrait = TDateDeTrait;
    }

    public String getTRadioFrequence() {
        return TRadioFrequence;
    }

    public void setTRadioFrequence(String TRadioFrequence) {
        this.TRadioFrequence = TRadioFrequence;
    }

    public String getTRadioFreqPercutannee() {
        return TRadioFreqPercutannee;
    }

    public void setTRadioFreqPercutannee(String TRadioFreqPercutannee) {
        this.TRadioFreqPercutannee = TRadioFreqPercutannee;
    }

    public String getTDateRadioFreq() {
        return TDateRadioFreq;
    }

    public void setTDateRadioFreq(String TDateRadioFreq) {
        this.TDateRadioFreq = TDateRadioFreq;
    }

    public String getTFreqDateDebTrt() {
        return TFreqDateDebTrt;
    }

    public void setTFreqDateDebTrt(String TFreqDateDebTrt) {
        this.TFreqDateDebTrt = TFreqDateDebTrt;
    }

    public String getTFreqDoulHepat() {
        return TFreqDoulHepat;
    }

    public void setTFreqDoulHepat(String TFreqDoulHepat) {
        this.TFreqDoulHepat = TFreqDoulHepat;
    }

    public String getTFreqNausee() {
        return TFreqNausee;
    }

    public void setTFreqNausee(String TFreqNausee) {
        this.TFreqNausee = TFreqNausee;
    }

    public String getTFreqVomissement() {
        return TFreqVomissement;
    }

    public void setTFreqVomissement(String TFreqVomissement) {
        this.TFreqVomissement = TFreqVomissement;
    }

    public String getTFreqFievre() {
        return TFreqFievre;
    }

    public void setTFreqFievre(String TFreqFievre) {
        this.TFreqFievre = TFreqFievre;
    }

    public String getTFreqAutres() {
        return TFreqAutres;
    }

    public void setTFreqAutres(String TFreqAutres) {
        this.TFreqAutres = TFreqAutres;
    }

    public String getTFreqNbrCure() {
        return TFreqNbrCure;
    }

    public void setTFreqNbrCure(String TFreqNbrCure) {
        this.TFreqNbrCure = TFreqNbrCure;
    }
    
    
}
