
package service.medicament.BilanPatient.BilanRadiologique;

import java.util.Date;

public class EchographieDopplerClasse {
    private  Date   DateEchographie ;
    private  String Echo            ;
    private  String EchoFoieReg     ;
    private  String EchoFoieHom     ;
    private  String EchoTaille      ;
    private  String EchoNbr         ;
    private  String EchoSiege       ;
    private  String EchoVasc        ;
    private  String SiOuiTypeEnvah  ;
    private  String AutreTypeEnvah  ;

    public EchographieDopplerClasse(Date DateEchographie, String Echo, String EchoFoieReg, String EchoFoieHom, String EchoTaille, String EchoNbr, String EchoSiege, String EchoVasc, String SiOuiTypeEnvah, String AutreTypeEnvah) {
        this.DateEchographie = DateEchographie;
        this.Echo = Echo;
        this.EchoFoieReg = EchoFoieReg;
        this.EchoFoieHom = EchoFoieHom;
        this.EchoTaille = EchoTaille;
        this.EchoNbr = EchoNbr;
        this.EchoSiege = EchoSiege;
        this.EchoVasc = EchoVasc;
        this.SiOuiTypeEnvah = SiOuiTypeEnvah;
        this.AutreTypeEnvah = AutreTypeEnvah;
    }

    public Date getDateEchographie() {
        return DateEchographie;
    }

    public void setDateEchographie(Date DateEchographie) {
        this.DateEchographie = DateEchographie;
    }

    public String getEcho() {
        return Echo;
    }

    public void setEcho(String Echo) {
        this.Echo = Echo;
    }

    public String getEchoFoieReg() {
        return EchoFoieReg;
    }

    public void setEchoFoieReg(String EchoFoieReg) {
        this.EchoFoieReg = EchoFoieReg;
    }

    public String getEchoFoieHom() {
        return EchoFoieHom;
    }

    public void setEchoFoieHom(String EchoFoieHom) {
        this.EchoFoieHom = EchoFoieHom;
    }

    public String getEchoTaille() {
        return EchoTaille;
    }

    public void setEchoTaille(String EchoTaille) {
        this.EchoTaille = EchoTaille;
    }

    public String getEchoNbr() {
        return EchoNbr;
    }

    public void setEchoNbr(String EchoNbr) {
        this.EchoNbr = EchoNbr;
    }

    public String getEchoSiege() {
        return EchoSiege;
    }

    public void setEchoSiege(String EchoSiege) {
        this.EchoSiege = EchoSiege;
    }

    public String getEchoVasc() {
        return EchoVasc;
    }

    public void setEchoVasc(String EchoVasc) {
        this.EchoVasc = EchoVasc;
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
    
}
