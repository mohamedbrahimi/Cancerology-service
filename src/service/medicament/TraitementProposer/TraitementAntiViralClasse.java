
package service.medicament.TraitementProposer;

import java.util.Date;

public class TraitementAntiViralClasse {
 
     private Date   TDateTrait            ;
     private String TTraitemAntiVirale    ;
     private String TTADateDeb            ;
     private String TChargeViraleInitail  ;
     private String TTADrogue             ;
     private String TTAEntecavir          ;
     private String TTABitherapie         ;
     private String TTATritherapie        ;
     private String TTALamvidine          ;
     private String TTAAutres             ;

    public TraitementAntiViralClasse(Date TDateTrait, String TTraitemAntiVirale, String TTADateDeb, String TChargeViraleInitail, String TTADrogue, String TTAEntecavir, String TTABitherapie, String TTATritherapie, String TTALamvidine, String TTAAutres) {
        this.TDateTrait = TDateTrait;
        this.TTraitemAntiVirale = TTraitemAntiVirale;
        this.TTADateDeb = TTADateDeb;
        this.TChargeViraleInitail = TChargeViraleInitail;
        this.TTADrogue = TTADrogue;
        this.TTAEntecavir = TTAEntecavir;
        this.TTABitherapie = TTABitherapie;
        this.TTATritherapie = TTATritherapie;
        this.TTALamvidine = TTALamvidine;
        this.TTAAutres = TTAAutres;
    }

    public Date getTDateTrait() {
        return TDateTrait;
    }

    public void setTDateTrait(Date TDateTrait) {
        this.TDateTrait = TDateTrait;
    }

    public String getTTraitemAntiVirale() {
        return TTraitemAntiVirale;
    }

    public void setTTraitemAntiVirale(String TTraitemAntiVirale) {
        this.TTraitemAntiVirale = TTraitemAntiVirale;
    }

    public String getTTADateDeb() {
        return TTADateDeb;
    }

    public void setTTADateDeb(String TTADateDeb) {
        this.TTADateDeb = TTADateDeb;
    }

    public String getTChargeViraleInitail() {
        return TChargeViraleInitail;
    }

    public void setTChargeViraleInitail(String TChargeViraleInitail) {
        this.TChargeViraleInitail = TChargeViraleInitail;
    }

    public String getTTADrogue() {
        return TTADrogue;
    }

    public void setTTADrogue(String TTADrogue) {
        this.TTADrogue = TTADrogue;
    }

    public String getTTAEntecavir() {
        return TTAEntecavir;
    }

    public void setTTAEntecavir(String TTAEntecavir) {
        this.TTAEntecavir = TTAEntecavir;
    }

    public String getTTABitherapie() {
        return TTABitherapie;
    }

    public void setTTABitherapie(String TTABitherapie) {
        this.TTABitherapie = TTABitherapie;
    }

    public String getTTATritherapie() {
        return TTATritherapie;
    }

    public void setTTATritherapie(String TTATritherapie) {
        this.TTATritherapie = TTATritherapie;
    }

    public String getTTALamvidine() {
        return TTALamvidine;
    }

    public void setTTALamvidine(String TTALamvidine) {
        this.TTALamvidine = TTALamvidine;
    }

    public String getTTAAutres() {
        return TTAAutres;
    }

    public void setTTAAutres(String TTAAutres) {
        this.TTAAutres = TTAAutres;
    }
     
     
}
