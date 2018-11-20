
package service.medicament.BilanPatient;

import java.util.Date;

public class BilanImmunologiqueClasse {
private Date   DateBilanImmunologique ;
private String AcAntiNucleaires ;
private String AcAntimuscles ;
private String AcAntimitochondries ;
private String AcAntiLMK1 ;
private String Autres ;

    public BilanImmunologiqueClasse(Date DateBilanImmunologique, String AcAntiNucleaires, String AcAntimuscles, String AcAntimitochondries, String AcAntiLMK1, String Autres) {
        this.DateBilanImmunologique = DateBilanImmunologique;
        this.AcAntiNucleaires = AcAntiNucleaires;
        this.AcAntimuscles = AcAntimuscles;
        this.AcAntimitochondries = AcAntimitochondries;
        this.AcAntiLMK1 = AcAntiLMK1;
        this.Autres = Autres;
    }

    public Date getDateBilanImmunologique() {
        return DateBilanImmunologique;
    }

    public void setDateBilanImmunologique(Date DateBilanImmunologique) {
        this.DateBilanImmunologique = DateBilanImmunologique;
    }

    public String getAcAntiNucleaires() {
        return AcAntiNucleaires;
    }

    public void setAcAntiNucleaires(String AcAntiNucleaires) {
        this.AcAntiNucleaires = AcAntiNucleaires;
    }

    public String getAcAntimuscles() {
        return AcAntimuscles;
    }

    public void setAcAntimuscles(String AcAntimuscles) {
        this.AcAntimuscles = AcAntimuscles;
    }

    public String getAcAntimitochondries() {
        return AcAntimitochondries;
    }

    public void setAcAntimitochondries(String AcAntimitochondries) {
        this.AcAntimitochondries = AcAntimitochondries;
    }

    public String getAcAntiLMK1() {
        return AcAntiLMK1;
    }

    public void setAcAntiLMK1(String AcAntiLMK1) {
        this.AcAntiLMK1 = AcAntiLMK1;
    }

    public String getAutres() {
        return Autres;
    }

    public void setAutres(String Autres) {
        this.Autres = Autres;
    }
    
}
