
package service.medicament.TraitementProposer;

import java.util.Date;

public class ChirurgieClasse {
    private Date TDateTrait              ;
    private String TChirurgie              ;
    private String TResection              ;
    private String TSegmetectomie          ;
    private String THepatectomie           ;
    private String TTumorectomie           ;
    private String TAutresRes              ;
    private String TDateRes                ;
    private String THopital                ;
    private String TPreciseAutresHopital   ;
    private String TTransplantation        ;
    private String TVieDonneur             ;
    private String TDateTransplantation    ;
    private String THopitalTransplantation ;
    private String TAutreHopitalTransp     ;

    public ChirurgieClasse(Date TDateTrait, String TChirurgie, String TResection, String TSegmetectomie, String THepatectomie, String TTumorectomie, String TAutresRes, String TDateRes, String THopital, String TPreciseAutresHopital, String TTransplantation, String TVieDonneur, String TDateTransplantation, String THopitalTransplantation, String TAutreHopitalTransp) {
        this.TDateTrait = TDateTrait;
        this.TChirurgie = TChirurgie;
        this.TResection = TResection;
        this.TSegmetectomie = TSegmetectomie;
        this.THepatectomie = THepatectomie;
        this.TTumorectomie = TTumorectomie;
        this.TAutresRes = TAutresRes;
        this.TDateRes = TDateRes;
        this.THopital = THopital;
        this.TPreciseAutresHopital = TPreciseAutresHopital;
        this.TTransplantation = TTransplantation;
        this.TVieDonneur = TVieDonneur;
        this.TDateTransplantation = TDateTransplantation;
        this.THopitalTransplantation = THopitalTransplantation;
        this.TAutreHopitalTransp = TAutreHopitalTransp;
    }

    public Date getTDateTrait() {
        return TDateTrait;
    }

    public void setTDateTrait(Date TDateTrait) {
        this.TDateTrait = TDateTrait;
    }

    public String getTChirurgie() {
        return TChirurgie;
    }

    public void setTChirurgie(String TChirurgie) {
        this.TChirurgie = TChirurgie;
    }

    public String getTResection() {
        return TResection;
    }

    public void setTResection(String TResection) {
        this.TResection = TResection;
    }

    public String getTSegmetectomie() {
        return TSegmetectomie;
    }

    public void setTSegmetectomie(String TSegmetectomie) {
        this.TSegmetectomie = TSegmetectomie;
    }

    public String getTHepatectomie() {
        return THepatectomie;
    }

    public void setTHepatectomie(String THepatectomie) {
        this.THepatectomie = THepatectomie;
    }

    public String getTTumorectomie() {
        return TTumorectomie;
    }

    public void setTTumorectomie(String TTumorectomie) {
        this.TTumorectomie = TTumorectomie;
    }

    public String getTAutresRes() {
        return TAutresRes;
    }

    public void setTAutresRes(String TAutresRes) {
        this.TAutresRes = TAutresRes;
    }

    public String getTDateRes() {
        return TDateRes;
    }

    public void setTDateRes(String TDateRes) {
        this.TDateRes = TDateRes;
    }

    public String getTHopital() {
        return THopital;
    }

    public void setTHopital(String THopital) {
        this.THopital = THopital;
    }

    public String getTPreciseAutresHopital() {
        return TPreciseAutresHopital;
    }

    public void setTPreciseAutresHopital(String TPreciseAutresHopital) {
        this.TPreciseAutresHopital = TPreciseAutresHopital;
    }

    public String getTTransplantation() {
        return TTransplantation;
    }

    public void setTTransplantation(String TTransplantation) {
        this.TTransplantation = TTransplantation;
    }

    public String getTVieDonneur() {
        return TVieDonneur;
    }

    public void setTVieDonneur(String TVieDonneur) {
        this.TVieDonneur = TVieDonneur;
    }

    public String getTDateTransplantation() {
        return TDateTransplantation;
    }

    public void setTDateTransplantation(String TDateTransplantation) {
        this.TDateTransplantation = TDateTransplantation;
    }

    public String getTHopitalTransplantation() {
        return THopitalTransplantation;
    }

    public void setTHopitalTransplantation(String THopitalTransplantation) {
        this.THopitalTransplantation = THopitalTransplantation;
    }

    public String getTAutreHopitalTransp() {
        return TAutreHopitalTransp;
    }

    public void setTAutreHopitalTransp(String TAutreHopitalTransp) {
        this.TAutreHopitalTransp = TAutreHopitalTransp;
    }
    
    
}
