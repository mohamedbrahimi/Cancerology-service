
package service.medicament.RendezVous;

public class JourClasse {
    String HeurRdv;
    String ContenuRdv;
    
    public JourClasse(String HeurRdv,String ContenuRdv){
        this.HeurRdv    = HeurRdv;
        this.ContenuRdv = ContenuRdv;
    }

    public String getContenuRdv() {
        return ContenuRdv;
    }

    public void setContenuRdv(String ContenuRdv) {
        this.ContenuRdv = ContenuRdv;
    }

    public String getHeurRdv() {
        return HeurRdv;
    }

    public void setHeurRdv(String HeurRdv) {
        this.HeurRdv = HeurRdv;
    }
    
    
    
}
