
package service.medicament.DossierPatient;

public class EvolutionClasse {
    
    private String Mois;
    private String EtatEvol;
    private String Clinique;
    private String Radiologique;
    private String AFP;

    public EvolutionClasse(String Mois, String EtatEvol, String Clinique, String Radiologique, String AFP) {
        this.Mois = Mois;
        this.EtatEvol = EtatEvol;
        this.Clinique = Clinique;
        this.Radiologique = Radiologique;
        this.AFP = AFP;
    }

    public String getMois() {
        return Mois;
    }

    public void setMois(String Mois) {
        this.Mois = Mois;
    }

    public String getEtatEvol() {
        return EtatEvol;
    }

    public void setEtatEvol(String EtatEvol) {
        this.EtatEvol = EtatEvol;
    }

    public String getClinique() {
        return Clinique;
    }

    public void setClinique(String Clinique) {
        this.Clinique = Clinique;
    }

    public String getRadiologique() {
        return Radiologique;
    }

    public void setRadiologique(String Radiologique) {
        this.Radiologique = Radiologique;
    }

    public String getAFP() {
        return AFP;
    }

    public void setAFP(String AFP) {
        this.AFP = AFP;
    }
    
    
}
