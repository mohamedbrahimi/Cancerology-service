
package service.medicament.BilanPatient;

import java.util.Date;


public class BilanBiologiqueClasse {
    private Date    DateBilanBiologique ;
    private String  GroupSang;
    private String  TypeH;
    private String  Hb;
    private String  GB;
    private String  Plaq;
    private String  TP;
    private String  FacteurV ;
    private String  SGOT ;
    private String  SGPT ;
    private String  BT ;
    private String  BD ;
    private String  GGT ;
    private String  PAL ;
    private String  VS ;
    private String  Uree ;
    private String  Creatinine ;
    private String  Albuminémie ;
    private String  Calcemie ;
    private String  Cholesterol ;
    private String  Tryglycérides ;
    private String  HVC ;
    private String  HVCChargeVirale ;
    private String  HVCGenotype ;
    private String  AgHBs ;
    private String  AgHBe ;
    private String  AcHBe ;
    private String  AcHBs ;
    private String  AcHBc ;
    private String  HBChargeVirale ;
    private String  HBGenotype ;
    private String  HVD ;
    private String  HIV ;
    private String  AFP ;
    private String  ACE ;
    private String  CA ;    

    public BilanBiologiqueClasse(Date    DateBilanBiologique , String  GroupSang,String  TypeH,String  Hb, 
    String  GB, String  Plaq, String  TP, String  FacteurV , String  SGOT , String  SGPT , String  BT , String  BD ,
    String  GGT , String  PAL , String  VS , String  Uree  ,String  Creatinine ,
    String  Albuminémie , String  Calcemie , String  Cholesterol , String  Tryglycérides ,
    String  HVC , String  HVCChargeVirale , String  HVCGenotype , String  AgHBs , String  AgHBe , String  AcHBe ,
    String  AcHBs , String  AcHBc , String  HBChargeVirale , String  HBGenotype ,
    String  HVD , String  HIV , String  AFP , String  ACE , String  CA  ){
      
    this.DateBilanBiologique = DateBilanBiologique;        this.GroupSang           = GroupSang;
    this.TypeH               = TypeH;                      this.Hb                  = Hb;                      
    this.GB                  = GB;                         this.Plaq                = Plaq;
    this.TP                  = TP;                         this.FacteurV            = FacteurV ;
    this.SGOT                = SGOT ;                      this.SGPT                = SGPT ;
    this.BT                  = BT ;                        this.BD                  = BD ;                        
    this.GGT                 = GGT;                        this.PAL                 = PAL ;
    this.VS                  = VS ;                        this.Uree                = Uree ;                    
    this.Creatinine          = Creatinine ;                this.Albuminémie         = Albuminémie ; 
    this.Calcemie            = Calcemie ;                  this.Cholesterol         = Cholesterol ;
    this.Tryglycérides       = Tryglycérides;              this.HVC                 = HVC ;
    this.HVCChargeVirale     = HVCChargeVirale ;           this.HVCGenotype         = HVCGenotype;
    this.AgHBs               = AgHBs ;                     this.AgHBe               = AgHBe ;
    this.AcHBe               = AcHBe ;                     this.AcHBs               = AcHBs;
    this.AcHBc               = AcHBc;                      this.HBChargeVirale      = HBChargeVirale;
    this.HBGenotype          = HBGenotype;                 this.HVD                 = HVD;
    this.HIV                 = HIV;
    this.AFP                 = AFP ;
    this.ACE                 = ACE ;
    this.CA                  = CA; 
    }
    
    public Date getDateBilanBiologique() {
        return DateBilanBiologique;
    }

    public void setDateBilanBiologique(Date DateBilanBiologique) {
        this.DateBilanBiologique = DateBilanBiologique;
    }

    public String getGroupSang() {
        return GroupSang;
    }

    public void setGroupSang(String GroupSang) {
        this.GroupSang = GroupSang;
    }

    public String getTypeH() {
        return TypeH;
    }

    public void setTypeH(String TypeH) {
        this.TypeH = TypeH;
    }

    public String getHb() {
        return Hb;
    }

    public void setHb(String Hb) {
        this.Hb = Hb;
    }

    public String getGB() {
        return GB;
    }

    public void setGB(String GB) {
        this.GB = GB;
    }

    public String getPlaq() {
        return Plaq;
    }

    public void setPlaq(String Plaq) {
        this.Plaq = Plaq;
    }

    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }

    public String getFacteurV() {
        return FacteurV;
    }

    public void setFacteurV(String FacteurV) {
        this.FacteurV = FacteurV;
    }

    public String getSGOT() {
        return SGOT;
    }

    public void setSGOT(String SGOT) {
        this.SGOT = SGOT;
    }

    public String getSGPT() {
        return SGPT;
    }

    public void setSGPT(String SGPT) {
        this.SGPT = SGPT;
    }

    public String getBT() {
        return BT;
    }

    public void setBT(String BT) {
        this.BT = BT;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getGGT() {
        return GGT;
    }

    public void setGGT(String GGT) {
        this.GGT = GGT;
    }

    public String getPAL() {
        return PAL;
    }

    public void setPAL(String PAL) {
        this.PAL = PAL;
    }

    public String getVS() {
        return VS;
    }

    public void setVS(String VS) {
        this.VS = VS;
    }

    public String getUree() {
        return Uree;
    }

    public void setUree(String Uree) {
        this.Uree = Uree;
    }

    public String getCreatinine() {
        return Creatinine;
    }

    public void setCreatinine(String Creatinine) {
        this.Creatinine = Creatinine;
    }

    public String getAlbuminémie() {
        return Albuminémie;
    }

    public void setAlbuminémie(String Albuminémie) {
        this.Albuminémie = Albuminémie;
    }

    public String getCalcemie() {
        return Calcemie;
    }

    public void setCalcemie(String Calcemie) {
        this.Calcemie = Calcemie;
    }

    public String getCholesterol() {
        return Cholesterol;
    }

    public void setCholesterol(String Cholesterol) {
        this.Cholesterol = Cholesterol;
    }

    public String getTryglycérides() {
        return Tryglycérides;
    }

    public void setTryglycérides(String Tryglycérides) {
        this.Tryglycérides = Tryglycérides;
    }

    public String getHVC() {
        return HVC;
    }

    public void setHVC(String HVC) {
        this.HVC = HVC;
    }

    public String getHVCChargeVirale() {
        return HVCChargeVirale;
    }

    public void setHVCChargeVirale(String HVCChargeVirale) {
        this.HVCChargeVirale = HVCChargeVirale;
    }

    public String getHVCGenotype() {
        return HVCGenotype;
    }

    public void setHVCGenotype(String HVCGenotype) {
        this.HVCGenotype = HVCGenotype;
    }

    public String getAgHBs() {
        return AgHBs;
    }

    public void setAgHBs(String AgHBs) {
        this.AgHBs = AgHBs;
    }

    public String getAgHBe() {
        return AgHBe;
    }

    public void setAgHBe(String AgHBe) {
        this.AgHBe = AgHBe;
    }

    public String getAcHBe() {
        return AcHBe;
    }

    public void setAcHBe(String AcHBe) {
        this.AcHBe = AcHBe;
    }

    public String getAcHBs() {
        return AcHBs;
    }

    public void setAcHBs(String AcHBs) {
        this.AcHBs = AcHBs;
    }

    public String getAcHBc() {
        return AcHBc;
    }

    public void setAcHBc(String AcHBc) {
        this.AcHBc = AcHBc;
    }

    public String getHBChargeVirale() {
        return HBChargeVirale;
    }

    public void setHBChargeVirale(String HBChargeVirale) {
        this.HBChargeVirale = HBChargeVirale;
    }

    public String getHBGenotype() {
        return HBGenotype;
    }

    public void setHBGenotype(String HBGenotype) {
        this.HBGenotype = HBGenotype;
    }

    public String getHVD() {
        return HVD;
    }

    public void setHVD(String HVD) {
        this.HVD = HVD;
    }

    public String getHIV() {
        return HIV;
    }

    public void setHIV(String HIV) {
        this.HIV = HIV;
    }

    public String getAFP() {
        return AFP;
    }

    public void setAFP(String AFP) {
        this.AFP = AFP;
    }

    public String getACE() {
        return ACE;
    }

    public void setACE(String ACE) {
        this.ACE = ACE;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }
}
