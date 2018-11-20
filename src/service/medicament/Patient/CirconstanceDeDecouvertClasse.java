
package service.medicament.Patient;

import java.util.Date;

public class CirconstanceDeDecouvertClasse {
    
    private String   EMTHepato  ;
    private Date     DDebSympto ;
    private String   Fortuit;
    private String   DECSyrrhose ;
    private String   Echographie ;
    private String   DosAFP ;
    private String   Amaigre ;
    private String   Fièvre ;
    private String   Ictère ;
    private String   DouleurHD ;
    private String   HemoragieDes ;
    private String   Ascite ;
    private String   Splénomegalie ;
    private String   TypeSpleno ;
    private String   Autres ;
    private String   ETGSOms ;
    private String   BMI ;
    private String   CVC ;
    private String   HPM ;
    private String   OMI ;
    private String   AutreS ;
    private String   SyndrParaneo ;
    private String   SyndrPrecise ;
    private String   hpmFH ;
    private String   hpmConsistance ;
    private String   hmpSurface ;

    public CirconstanceDeDecouvertClasse (String   EMTHepato ,Date DDebSympto ,String Fortuit ,String DECSyrrhose ,
            String   Echographie ,String DosAFP ,String  Amaigre ,String   Fièvre,String Ictère ,String DouleurHD ,
            String   HemoragieDes,String Ascite ,String  Splénomegalie,String TypeSpleno,String  Autres,String ETGSOms,
            String   BMI , String CVC ,String HPM ,String OMI ,String AutreS ,String SyndrParaneo ,String SyndrPrecise, 
            String   hpmFH , String   hpmConsistance ,String   hmpSurface ){
        
    this.EMTHepato      = EMTHepato;            this.DDebSympto     = DDebSympto;
    this.Fortuit        = Fortuit;              this.DECSyrrhose    = DECSyrrhose;
    this.Echographie    = Echographie;          this.DosAFP         = DosAFP ;
    this.Amaigre        = Amaigre ;             this.Fièvre         = Fièvre ;
    this.Ictère         = Ictère ;              this.DouleurHD      = DouleurHD ;
    this.HemoragieDes   = HemoragieDes ;        this.Ascite         = Ascite;
    this.Splénomegalie  = Splénomegalie ;       this.TypeSpleno     = TypeSpleno;
    this.Autres         = Autres ;              this.ETGSOms        = ETGSOms;
    this.BMI            = BMI ;                 this.CVC            = CVC;
    this.HPM            = HPM;                  this.OMI            = OMI;
    this.AutreS         = AutreS;               this.SyndrParaneo   = SyndrParaneo;
    this.SyndrPrecise   = SyndrPrecise;         this.hpmFH          = hpmFH;
    this.hpmConsistance = hpmConsistance ;      this.hmpSurface     = hmpSurface ;
    
    }

    public String getEMTHepato() {
        return EMTHepato;
    }

    public void setEMTHepato(String EMTHepato) {
        this.EMTHepato = EMTHepato;
    }

    public Date getDDebSympto() {
        return DDebSympto;
    }

    public void setDDebSympto(Date DDebSympto) {
        this.DDebSympto = DDebSympto;
    }

    public String getFortuit() {
        return Fortuit;
    }

    public void setFortuit(String Fortuit) {
        this.Fortuit = Fortuit;
    }

    public String getDECSyrrhose() {
        return DECSyrrhose;
    }

    public void setDECSyrrhose(String DECSyrrhose) {
        this.DECSyrrhose = DECSyrrhose;
    }

    public String getEchographie() {
        return Echographie;
    }

    public void setEchographie(String Echographie) {
        this.Echographie = Echographie;
    }

    public String getDosAFP() {
        return DosAFP;
    }

    public void setDosAFP(String DosAFP) {
        this.DosAFP = DosAFP;
    }

    public String getAmaigre() {
        return Amaigre;
    }

    public void setAmaigre(String Amaigre) {
        this.Amaigre = Amaigre;
    }

    public String getFièvre() {
        return Fièvre;
    }

    public void setFièvre(String Fièvre) {
        this.Fièvre = Fièvre;
    }

    public String getIctère() {
        return Ictère;
    }

    public void setIctère(String Ictère) {
        this.Ictère = Ictère;
    }

    public String getDouleurHD() {
        return DouleurHD;
    }

    public void setDouleurHD(String DouleurHD) {
        this.DouleurHD = DouleurHD;
    }

    public String getHemoragieDes() {
        return HemoragieDes;
    }

    public void setHemoragieDes(String HemoragieDes) {
        this.HemoragieDes = HemoragieDes;
    }

    public String getAscite() {
        return Ascite;
    }

    public void setAscite(String Ascite) {
        this.Ascite = Ascite;
    }

    public String getSplénomegalie() {
        return Splénomegalie;
    }

    public void setSplénomegalie(String Splénomegalie) {
        this.Splénomegalie = Splénomegalie;
    }

    public String getTypeSpleno() {
        return TypeSpleno;
    }

    public void setTypeSpleno(String TypeSpleno) {
        this.TypeSpleno = TypeSpleno;
    }

    public String getAutres() {
        return Autres;
    }

    public void setAutres(String Autres) {
        this.Autres = Autres;
    }

    public String getETGSOms() {
        return ETGSOms;
    }

    public void setETGSOms(String ETGSOms) {
        this.ETGSOms = ETGSOms;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getHPM() {
        return HPM;
    }

    public void setHPM(String HPM) {
        this.HPM = HPM;
    }

    public String getOMI() {
        return OMI;
    }

    public void setOMI(String OMI) {
        this.OMI = OMI;
    }

    public String getAutreS() {
        return AutreS;
    }

    public void setAutreS(String AutreS) {
        this.AutreS = AutreS;
    }

    public String getSyndrParaneo() {
        return SyndrParaneo;
    }

    public void setSyndrParaneo(String SyndrParaneo) {
        this.SyndrParaneo = SyndrParaneo;
    }

    public String getSyndrPrecise() {
        return SyndrPrecise;
    }

    public void setSyndrPrecise(String SyndrPrecise) {
        this.SyndrPrecise = SyndrPrecise;
    }

    public String getHpmFH() {
        return hpmFH;
    }

    public void setHpmFH(String hpmFH) {
        this.hpmFH = hpmFH;
    }

    public String getHpmConsistance() {
        return hpmConsistance;
    }

    public void setHpmConsistance(String hpmConsistance) {
        this.hpmConsistance = hpmConsistance;
    }

    public String getHmpSurface() {
        return hmpSurface;
    }

    public void setHmpSurface(String hmpSurface) {
        this.hmpSurface = hmpSurface;
    }
    
    
}
