
package service.medicament.BilanPatient;

import java.util.Date;

public class BilanFOGDClasse {
    private Date   DateBilanFOGS;
    private String FOGD;
    private String VARICES;
    private String FOGDSignesRouge;
    private String AndoscopAutres;

    public BilanFOGDClasse(Date DateBilanFOGS, String FOGD, String VARICES, String FOGDSignesRouge, String AndoscopAutres) {
        this.DateBilanFOGS = DateBilanFOGS;
        this.FOGD = FOGD;
        this.VARICES = VARICES;
        this.FOGDSignesRouge = FOGDSignesRouge;
        this.AndoscopAutres = AndoscopAutres;
    }

    public Date getDateBilanFOGS() {
        return DateBilanFOGS;
    }

    public void setDateBilanFOGS(Date DateBilanFOGS) {
        this.DateBilanFOGS = DateBilanFOGS;
    }

    public String getFOGD() {
        return FOGD;
    }

    public void setFOGD(String FOGD) {
        this.FOGD = FOGD;
    }

    public String getVARICES() {
        return VARICES;
    }

    public void setVARICES(String VARICES) {
        this.VARICES = VARICES;
    }

    public String getFOGDSignesRouge() {
        return FOGDSignesRouge;
    }

    public void setFOGDSignesRouge(String FOGDSignesRouge) {
        this.FOGDSignesRouge = FOGDSignesRouge;
    }

    public String getAndoscopAutres() {
        return AndoscopAutres;
    }

    public void setAndoscopAutres(String AndoscopAutres) {
        this.AndoscopAutres = AndoscopAutres;
    }
    
    
    
    
}
