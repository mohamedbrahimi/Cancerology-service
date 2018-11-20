
package service.medicament.DossierPatient;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.medicament.SGBD.Consultation;

public class ActionClasse {
  
    
    private String NumDossier;
    private String Nom;
    private String Action;
    private String Timer;

    public ActionClasse(String NumDossier, String Nom, String Action, String Timer) {
        
        this.NumDossier = NumDossier;
        this.Nom        = Nom;
        this.Action     = Action;
        this.Timer      = Timer;
    }

    public String getNumDossier() {
        return NumDossier;
    }

    public void setNumDossier(String NumDossier) {
        this.NumDossier = NumDossier;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    public String getTimer() {
        return Timer;
    }

    public void setTimer(String Timer) {
        this.Timer = Timer;
    }
    
    
    
    public ObservableList<ActionClasse> RemplissageTab() throws SQLException{
        
        ObservableList<ActionClasse> AC       = FXCollections.observableArrayList();
        Consultation     bddCons      = new Consultation();
        ResultSet   res   = bddCons.ExtElement("select * from DossierTrait order by now desc limit 15");
        
        while(res.next()){
            ActionClasse    a   = new ActionClasse(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
        
        AC.add(a);
        }
        bddCons.CloseConnex();
        return AC;
    }
}
