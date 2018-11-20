
package service.medicament.BilanPatient.BilanRadiologique;

import java.util.Date;

public class TDMClasse {
    private  Date   DateTDM ;
    private  String TDM            ;
    private  String TDMFoieReg     ;
    private  String TDMFoieHom     ;
    private  String TDMTaille      ;
    private  String TDMNbr         ;
    private  String TDMSiege       ;
    private  String TDMVasc        ;
    private  String SiOuiTypeEnvah  ;
    private  String AutreTypeEnvah  ;
    private  String TDMGanglionnaire ;
    private  String TDMType;
    private  String TDMAutre;

    public TDMClasse(Date DateTDM, String TDM, String TDMFoieReg, String TDMFoieHom, String TDMTaille, String TDMNbr, String TDMSiege, String TDMVasc, String SiOuiTypeEnvah, String AutreTypeEnvah, String TDMGanglionnaire, String TDMType, String TDMAutre) {
        this.DateTDM = DateTDM;
        this.TDM = TDM;
        this.TDMFoieReg = TDMFoieReg;
        this.TDMFoieHom = TDMFoieHom;
        this.TDMTaille = TDMTaille;
        this.TDMNbr = TDMNbr;
        this.TDMSiege = TDMSiege;
        this.TDMVasc = TDMVasc;
        this.SiOuiTypeEnvah = SiOuiTypeEnvah;
        this.AutreTypeEnvah = AutreTypeEnvah;
        this.TDMGanglionnaire = TDMGanglionnaire;
        this.TDMType = TDMType;
        this.TDMAutre = TDMAutre;
    }

    public Date getDateTDM() {
        return DateTDM;
    }

    public void setDateTDM(Date DateTDM) {
        this.DateTDM = DateTDM;
    }

    public String getTDM() {
        return TDM;
    }

    public void setTDM(String TDM) {
        this.TDM = TDM;
    }

    public String getTDMFoieReg() {
        return TDMFoieReg;
    }

    public void setTDMFoieReg(String TDMFoieReg) {
        this.TDMFoieReg = TDMFoieReg;
    }

    public String getTDMFoieHom() {
        return TDMFoieHom;
    }

    public void setTDMFoieHom(String TDMFoieHom) {
        this.TDMFoieHom = TDMFoieHom;
    }

    public String getTDMTaille() {
        return TDMTaille;
    }

    public void setTDMTaille(String TDMTaille) {
        this.TDMTaille = TDMTaille;
    }

    public String getTDMNbr() {
        return TDMNbr;
    }

    public void setTDMNbr(String TDMNbr) {
        this.TDMNbr = TDMNbr;
    }

    public String getTDMSiege() {
        return TDMSiege;
    }

    public void setTDMSiege(String TDMSiege) {
        this.TDMSiege = TDMSiege;
    }

    public String getTDMVasc() {
        return TDMVasc;
    }

    public void setTDMVasc(String TDMVasc) {
        this.TDMVasc = TDMVasc;
    }

    public String getSiOuiTypeEnvah() {
        return SiOuiTypeEnvah;
    }

    public void setSiOuiTypeEnvah(String SiOuiTypeEnvah) {
        this.SiOuiTypeEnvah = SiOuiTypeEnvah;
    }

    public String getAutreTypeEnvah() {
        return AutreTypeEnvah;
    }

    public void setAutreTypeEnvah(String AutreTypeEnvah) {
        this.AutreTypeEnvah = AutreTypeEnvah;
    }

    public String getTDMGanglionnaire() {
        return TDMGanglionnaire;
    }

    public void setTDMGanglionnaire(String TDMGanglionnaire) {
        this.TDMGanglionnaire = TDMGanglionnaire;
    }

    public String getTDMType() {
        return TDMType;
    }

    public void setTDMType(String TDMType) {
        this.TDMType = TDMType;
    }

    public String getTDMAutre() {
        return TDMAutre;
    }

    public void setTDMAutre(String TDMAutre) {
        this.TDMAutre = TDMAutre;
    }
    
    
    
}
