
package service.medicament.BilanPatient.BilanRadiologique;

import java.util.Date;


public class AutreExamenClasse {
    
    private Date TDateAutreExamen ; 
    private String Thoracique        ;
    private String TMetastase        ;
    private String TScintOss         ;
    private String TScintMetastase   ;
    private String TExpAutres        ;
    private String TExpPrecise       ;

    public AutreExamenClasse(Date TDateAutreExamen, String Thoracique, String TMetastase, String TScintOss, String TScintMetastase, String TExpAutres, String TExpPrecise) {
        this.TDateAutreExamen = TDateAutreExamen;
        this.Thoracique = Thoracique;
        this.TMetastase = TMetastase;
        this.TScintOss = TScintOss;
        this.TScintMetastase = TScintMetastase;
        this.TExpAutres = TExpAutres;
        this.TExpPrecise = TExpPrecise;
    }

    public Date getTDateAutreExamen() {
        return TDateAutreExamen;
    }

    public void setTDateAutreExamen(Date TDateAutreExamen) {
        this.TDateAutreExamen = TDateAutreExamen;
    }

    public String getThoracique() {
        return Thoracique;
    }

    public void setThoracique(String Thoracique) {
        this.Thoracique = Thoracique;
    }

    public String getTMetastase() {
        return TMetastase;
    }

    public void setTMetastase(String TMetastase) {
        this.TMetastase = TMetastase;
    }

    public String getTScintOss() {
        return TScintOss;
    }

    public void setTScintOss(String TScintOss) {
        this.TScintOss = TScintOss;
    }

    public String getTScintMetastase() {
        return TScintMetastase;
    }

    public void setTScintMetastase(String TScintMetastase) {
        this.TScintMetastase = TScintMetastase;
    }

    public String getTExpAutres() {
        return TExpAutres;
    }

    public void setTExpAutres(String TExpAutres) {
        this.TExpAutres = TExpAutres;
    }

    public String getTExpPrecise() {
        return TExpPrecise;
    }

    public void setTExpPrecise(String TExpPrecise) {
        this.TExpPrecise = TExpPrecise;
    }
    
}
