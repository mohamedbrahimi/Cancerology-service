
package service.medicament.DossierPatient;

public class ANTCDfamiliauxClasse {
   
    private String Hepatovirale;
    private String TypeHepato;
    private String Nplsm;
    private String Neoplasme;
    private String AutreAtcd;

    public ANTCDfamiliauxClasse(String Hepatovirale, String TypeHepato, String Nplsm, String Neoplasme, String AutreAtcd) {
        this.Hepatovirale = Hepatovirale;
        this.TypeHepato   = TypeHepato;
        this.Nplsm        = Nplsm;
        this.Neoplasme    = Neoplasme;
        this.AutreAtcd    = AutreAtcd;
    }

    public String getHepatovirale() {
        return Hepatovirale;
    }

    public void setHepatovirale(String Hepatovirale) {
        this.Hepatovirale = Hepatovirale;
    }

    public String getTypeHepato() {
        return TypeHepato;
    }

    public void setTypeHepato(String TypeHepato) {
        this.TypeHepato = TypeHepato;
    }

    public String getNplsm() {
        return Nplsm;
    }

    public void setNplsm(String Nplsm) {
        this.Nplsm = Nplsm;
    }

    public String getNeoplasme() {
        return Neoplasme;
    }

    public void setNeoplasme(String Neoplasme) {
        this.Neoplasme = Neoplasme;
    }

    public String getAutreAtcd() {
        return AutreAtcd;
    }

    public void setAutreAtcd(String AutreAtcd) {
        this.AutreAtcd = AutreAtcd;
    }
    
    
     
}