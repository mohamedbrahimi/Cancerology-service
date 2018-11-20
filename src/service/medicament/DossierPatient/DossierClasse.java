
package service.medicament.DossierPatient;

import java.util.Date;

public class DossierClasse {
    
    private String NumDossier; 
    private Date DateHospitalisation;
    
    public DossierClasse(String NumDossier ,Date DateHospitalisation ){
        this.NumDossier             = NumDossier; 
        this.DateHospitalisation    = DateHospitalisation;
    }

    public String getNumDossier() {
        return NumDossier;
    }

    public void setNumDossier(String NumDossier) {
        this.NumDossier = NumDossier;
    }

    public Date getDateHospitalisation() {
        return DateHospitalisation;
    }

    public void setDateHospitalisation(Date DateHospitalisation) {
        this.DateHospitalisation = DateHospitalisation;
    }
    
}
