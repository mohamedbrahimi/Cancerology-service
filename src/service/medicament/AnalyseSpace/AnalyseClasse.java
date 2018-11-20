
package service.medicament.AnalyseSpace;

import java.sql.ResultSet;
import java.sql.SQLException;
import service.medicament.SGBD.Consultation;

public class AnalyseClasse {
    
    private int HepathieSousJacentOui; 
    private int HepathieSousJacentNon;
    /**/
    private int HChronique; 
    private int ChviraleB;
    private int ChViraleC;
    private int ChNASH ;
    private int ChAUTOIMMUNE ;
    private int ChAutre ;
    /**/
    private int CiHCirrhose;
    private int CiviraleB;
    private int CiViraleC;
    private int CiNASH ;
    private int CiAUTOIMMUNE ;
    private int CiAutre;
    /**/
    /** Contage Virale B et C*/
    private int ContTransSang ;
    private int ContExtrDenTrad ;
    private int ContSacrification ;
    private int ContTatouage ;
    private int Contchirurgie ;
    private int ContAutre;
    /**/
    /*Simple Constat*/
    private int AutreCafe ;
    private int AutreCannabis ;
    private int AutreMaladieAutoImmune ;
    private int AutreContreOrale ;
    private int AutreNeoplasmeConnu;
    private int AutreDiabete;
    private int AutreHTA;
    /**/
    /**Type de Diabete*/
    private int TDiabete ;
    private int TType1 ;
    private int TType2;
    /**/
    /**Hepato viral dans la famille*/
    private int TotalPF ; 
    private int HepatoviralPF ;
    private int NplsmPF;
    
    /* les CirConstances De Decouvert */
    private int OuiHepat ;
    private int NonHepat ;
    private int OuiFort ;
    private int NonFort ;
    private int OuiDEC ;
    private int NonDEC ;
    private int Echohraph ;
    private int DosAFP;
    private int Amaigre;
    private int Fievre;
    private int Ictere;
    private int DouleurHD;
    private int HemoragieDes ;
    private int Ascite ;
    private int Splenomegalie;
    private int Autre ;
    private int TypeS1;
    private int TypeS2;
    private int TypeS3;
    private int TypeS4;
    
    
    private int Stade0;
    private int Stade1;
    private int Stade2;
    private int Stade3;
    private int Stade4;
    private int bmi0 ;
    private int bmi1 ;
    private int bmi2 ;
    private int bmi3;
    private int cvcOui;
    private int cvcNon;
    private int hpmOui;
    private int hpmNon;
    private int FH;
    private int ConsistFerme;
    private int ConsistDure;
    private int SurfReg;
    private int SurfIreg;
    private int OmiOui;
    private int OmiNon;
    private int AutreSignesPH;
    private int SynfdromPOui;
    private int SynfdromPNon;

    public int getHepathieSousJacentOui() {
        return HepathieSousJacentOui;
    }

    public void setHepathieSousJacentOui(int HepathieSousJacentOui) {
        this.HepathieSousJacentOui = HepathieSousJacentOui;
    }

    public int getHepathieSousJacentNon() {
        return HepathieSousJacentNon;
    }

    public void setHepathieSousJacentNon(int HepathieSousJacentNon) {
        this.HepathieSousJacentNon = HepathieSousJacentNon;
    }

    public int getHChronique() {
        return HChronique;
    }

    public void setHChronique(int HChronique) {
        this.HChronique = HChronique;
    }

    public int getChviraleB() {
        return ChviraleB;
    }

    public void setChviraleB(int ChviraleB) {
        this.ChviraleB = ChviraleB;
    }

    public int getChViraleC() {
        return ChViraleC;
    }

    public void setChViraleC(int ChViraleC) {
        this.ChViraleC = ChViraleC;
    }

    public int getChNASH() {
        return ChNASH;
    }

    public void setChNASH(int ChNASH) {
        this.ChNASH = ChNASH;
    }

    public int getChAUTOIMMUNE() {
        return ChAUTOIMMUNE;
    }

    public void setChAUTOIMMUNE(int ChAUTOIMMUNE) {
        this.ChAUTOIMMUNE = ChAUTOIMMUNE;
    }

    public int getChAutre() {
        return ChAutre;
    }

    public void setChAutre(int ChAutre) {
        this.ChAutre = ChAutre;
    }

    public int getCiHCirrhose() {
        return CiHCirrhose;
    }

    public void setCiHCirrhose(int CiHCirrhose) {
        this.CiHCirrhose = CiHCirrhose;
    }

    public int getCiviraleB() {
        return CiviraleB;
    }

    public void setCiviraleB(int CiviraleB) {
        this.CiviraleB = CiviraleB;
    }

    public int getCiViraleC() {
        return CiViraleC;
    }

    public void setCiViraleC(int CiViraleC) {
        this.CiViraleC = CiViraleC;
    }

    public int getCiNASH() {
        return CiNASH;
    }

    public void setCiNASH(int CiNASH) {
        this.CiNASH = CiNASH;
    }

    public int getCiAUTOIMMUNE() {
        return CiAUTOIMMUNE;
    }

    public void setCiAUTOIMMUNE(int CiAUTOIMMUNE) {
        this.CiAUTOIMMUNE = CiAUTOIMMUNE;
    }

    public int getCiAutre() {
        return CiAutre;
    }

    public void setCiAutre(int CiAutre) {
        this.CiAutre = CiAutre;
    }

    public int getContTransSang() {
        return ContTransSang;
    }

    public void setContTransSang(int ContTransSang) {
        this.ContTransSang = ContTransSang;
    }

    public int getContExtrDenTrad() {
        return ContExtrDenTrad;
    }

    public void setContExtrDenTrad(int ContExtrDenTrad) {
        this.ContExtrDenTrad = ContExtrDenTrad;
    }

    public int getContSacrification() {
        return ContSacrification;
    }

    public void setContSacrification(int ContSacrification) {
        this.ContSacrification = ContSacrification;
    }

    public int getContTatouage() {
        return ContTatouage;
    }

    public void setContTatouage(int ContTatouage) {
        this.ContTatouage = ContTatouage;
    }

    public int getContchirurgie() {
        return Contchirurgie;
    }

    public void setContchirurgie(int Contchirurgie) {
        this.Contchirurgie = Contchirurgie;
    }

    public int getContAutre() {
        return ContAutre;
    }

    public void setContAutre(int ContAutre) {
        this.ContAutre = ContAutre;
    }

    public int getAutreCafe() {
        return AutreCafe;
    }

    public void setAutreCafe(int AutreCafe) {
        this.AutreCafe = AutreCafe;
    }

    public int getAutreCannabis() {
        return AutreCannabis;
    }

    public void setAutreCannabis(int AutreCannabis) {
        this.AutreCannabis = AutreCannabis;
    }

    public int getAutreMaladieAutoImmune() {
        return AutreMaladieAutoImmune;
    }

    public void setAutreMaladieAutoImmune(int AutreMaladieAutoImmune) {
        this.AutreMaladieAutoImmune = AutreMaladieAutoImmune;
    }

    public int getAutreContreOrale() {
        return AutreContreOrale;
    }

    public void setAutreContreOrale(int AutreContreOrale) {
        this.AutreContreOrale = AutreContreOrale;
    }

    public int getAutreNeoplasmeConnu() {
        return AutreNeoplasmeConnu;
    }

    public void setAutreNeoplasmeConnu(int AutreNeoplasmeConnu) {
        this.AutreNeoplasmeConnu = AutreNeoplasmeConnu;
    }

    public int getAutreDiabete() {
        return AutreDiabete;
    }

    public void setAutreDiabete(int AutreDiabete) {
        this.AutreDiabete = AutreDiabete;
    }

    public int getAutreHTA() {
        return AutreHTA;
    }

    public void setAutreHTA(int AutreHTA) {
        this.AutreHTA = AutreHTA;
    }

    public int getTDiabete() {
        return TDiabete;
    }

    public void setTDiabete(int TDiabete) {
        this.TDiabete = TDiabete;
    }

    public int getTType1() {
        return TType1;
    }

    public void setTType1(int TType1) {
        this.TType1 = TType1;
    }

    public int getTType2() {
        return TType2;
    }

    public void setTType2(int TType2) {
        this.TType2 = TType2;
    }

    public int getTotalPF() {
        return TotalPF;
    }

    public void setTotalPF(int TotalPF) {
        this.TotalPF = TotalPF;
    }

    public int getHepatoviralPF() {   
        return HepatoviralPF;
    }

    public void setHepatoviralPF(int HepatoviralPF) {
        this.HepatoviralPF = HepatoviralPF;
    }

    public int getNplsmPF() {
        return NplsmPF;
    }

    public void setNplsmPF(int NplsmPF) {
        this.NplsmPF = NplsmPF;
    }
    
    
    
    
    
    
    /**
     * @return 
     * @throws java.sql.SQLException**/
    
    public AnalyseClasse AnalysHepathieSJacent() throws SQLException{
        Consultation    bddConsAnal       = new Consultation();
        ResultSet res  = bddConsAnal.ExtElement("select HSJacentOui ,HSJacentNon ,HChronique, ChviraleB,ChViraleC,ChNASH ,ChAUTOIMMUNE ,ChAutre,\n" +
"                                 HCirrhose, CiviraleB,CiViraleC,CiNASH ,CiAUTOIMMUNE ,CiAutre ,\n" +
"                                 ContTransSang , ContExtrDenTrad , ContSacrification , ContTatouage , Contchirurgie , ContAutre ,\n" +
"                                 AutreCafe , AutreCannabis , AutreMaladieAutoImmune , AutreContreOrale ,AutreNeoplasmeConnu,AutreDiabete,AutreHTA \n" +
"                                 Diabete , Type1 , Type2,\n" +
"                                 Total , Hepatoviral ,Nplsm\n" +
"                                 from \n" +
"(select count(*) as HSJacentOui  from  atcdspersonnel where HepSouJac = 'Oui') as Tab1 ,\n" +
"(select count(*) as HSJacentNon  from  atcdspersonnel where HepSouJac = 'Non')as Tab2,\n" +
"(select count(*) as HChronique   from atcdspersonnel where Precise = 'hépathie chronique')                         as ATCDS1,\n" +
"(select count(*) as ChviraleB    from atcdspersonnel where Cause   =  'viral B'   AND Precise = 'hépathie chronique')as ATCDS2,\n" +
"(select count(*) as ChviraleC    from atcdspersonnel where Cause   =  'viral C'   AND Precise = 'hépathie chronique')as ATCDS3,\n" +
"(select count(*) as ChNASH       from atcdspersonnel where Cause   =  'NASH'      AND Precise = 'hépathie chronique')as ATCDS4,\n" +
"(select count(*) as ChAUTOIMMUNE from atcdspersonnel where Cause   =  'AUOIMMUNE' AND Precise = 'hépathie chronique')as ATCDS5,\n" +
"(select count(*) as ChAutre      from atcdspersonnel where Cause   <> ''          AND Precise = 'hépathie chronique')as ATCDS6,\n" +
"(select count(*) as HCirrhose  from atcdspersonnel where Precise =  'cirrhose')                            as ATCDS11,\n" +
"(select count(*) as CiviraleB    from atcdspersonnel where Cause   =  'viral B'   AND Precise = 'cirrhose')as ATCDS22,\n" +
"(select count(*) as CiviraleC    from atcdspersonnel where Cause   =  'viral C'   AND Precise = 'cirrhose')as ATCDS33,\n" +
"(select count(*) as CiNASH       from atcdspersonnel where Cause   =  'NASH'      AND Precise = 'cirrhose')as ATCDS44,\n" +
"(select count(*) as CiAUTOIMMUNE from atcdspersonnel where Cause   =  'AUOIMMUNE' AND Precise = 'cirrhose')as ATCDS55,\n" +
"(select count(*) as CiAutre      from atcdspersonnel where Cause   <> ''          AND Precise = 'cirrhose')as ATCDS66,\n" +
"(select count(*) as ContTransSang      from  atcdspersonnel where TransSang     = 'Oui') as Contage1,\n" +
"(select count(*) as ContExtrDenTrad    from  atcdspersonnel where ExtrDenTrad   = 'Oui') as Contage2,\n" +
"(select count(*) as ContSacrification  from  atcdspersonnel where Sacrification = 'Oui') as Contage3,\n" +
"(select count(*) as ContTatouage       from  atcdspersonnel where Tatouage      = 'Oui') as Contage4,\n" +
"(select count(*) as Contchirurgie      from  atcdspersonnel where chirurgie     = 'Oui') as Contage5,\n" +
"(select count(*) as ContAutre          from  atcdspersonnel where Autre         <>'')    as Contage6,\n" +
"(select count(*) as AutreCafe                 from   atcdspersonnel where Cafe              = 'Oui') as SimpleConstat1,\n" +
"(select count(*) as AutreCannabis             from   atcdspersonnel where Cannabis          = 'Oui') as SimpleConstat2,\n" +
"(select count(*) as AutreMaladieAutoImmune    from   atcdspersonnel where MaladieAutoImmune <> '')   as SimpleConstat3,\n" +
"(select count(*) as AutreContreOrale          from   atcdspersonnel where ContreOrale       = 'Oui') as SimpleConstat4,\n" +
"(select count(*) as AutreNeoplasmeConnu       from   atcdspersonnel where NeoplasmeConnu    = 'Oui') as SimpleConstat5,\n" +
"(select count(*) as AutreDiabete              from   atcdspersonnel where Diabete           = 'Oui') as SimpleConstat6,\n" +
"(select count(*) as AutreHTA                  from   atcdspersonnel where HTA               = 'Oui') as SimpleConstat7,\n" +
"(select count(*) as Diabete            from atcdspersonnel where Diabete     = 'Oui')   as Type12,\n" +
"(select count(*) as Type1              from atcdspersonnel where TypeDiabete = 'type1') as Type1,\n" +
"(select count(*) as Type2              from atcdspersonnel where TypeDiabete = 'type2') as Type2,\n" +
"(select count(*) as Total       from Atcdsfamiliale                           ) atcdf1,\n" +
"(select count(*) as Hepatoviral from Atcdsfamiliale where Hepatovirale = 'Oui') atcdf2,\n" +
"(select count(*) as Nplsm       from Atcdsfamiliale where Nplsm        = 'Oui') atcdf3; ");
       
        
        AnalyseClasse     Anal       = new AnalyseClasse();
        while(res.next()){
            Anal.setHepathieSousJacentOui(res.getInt(1));
            Anal.setHepathieSousJacentNon(res.getInt(2));
            
            Anal.setHChronique(res.getInt(3));
            Anal.setChviraleB(res.getInt(4));
            Anal.setChViraleC(res.getInt(5));
            Anal.setChNASH(res.getInt(6));
            Anal.setChAUTOIMMUNE(res.getInt(7));
            Anal.setChAutre(res.getInt(8));
                    
            Anal.setCiHCirrhose(res.getInt(9));
            Anal.setCiviraleB(res.getInt(10));
            Anal.setCiViraleC(res.getInt(11));
            Anal.setCiNASH(res.getInt(12));
            Anal.setCiAUTOIMMUNE(res.getInt(13));
            Anal.setCiAutre(res.getInt(14));
            
            Anal.setContTransSang(res.getInt(15));
            Anal.setContExtrDenTrad(res.getInt(16));
            Anal.setContSacrification(res.getInt(17));
            Anal.setContTatouage(res.getInt(18));
           
            Anal.setContAutre(res.getInt(19));
            
            Anal.setAutreCafe(res.getInt(20));
            Anal.setAutreCannabis(res.getInt(21));
            Anal.setAutreMaladieAutoImmune(res.getInt(22));
            Anal.setAutreContreOrale(res.getInt(23));
            Anal.setAutreNeoplasmeConnu(res.getInt(24));
            Anal.setAutreDiabete(res.getInt(25));
            Anal.setAutreHTA(res.getInt(26));
            
            Anal.setTDiabete(res.getInt(27));
            Anal.setTType1(res.getInt(28));
            Anal.setTType2(res.getInt(29));
            
            Anal.setTotalPF(res.getInt(30));      
            Anal.setHepatoviralPF(res.getInt(31)); 
            Anal.setNplsmPF(res.getInt(32));
           
        }
        bddConsAnal.CloseConnex();
        return Anal;
    }

    public int getOuiHepat() {
        return OuiHepat;
    }

    public void setOuiHepat(int OuiHepat) {
        this.OuiHepat = OuiHepat;
    }

    public int getNonHepat() {
        return NonHepat;
    }

    public void setNonHepat(int NonHepat) {
        this.NonHepat = NonHepat;
    }

    public int getOuiFort() {
        return OuiFort;
    }

    public void setOuiFort(int OuiFort) {
        this.OuiFort = OuiFort;
    }

    public int getNonFort() {
        return NonFort;
    }

    public void setNonFort(int NonFort) {
        this.NonFort = NonFort;
    }

    public int getOuiDEC() {
        return OuiDEC;
    }

    public void setOuiDEC(int OuiDEC) {
        this.OuiDEC = OuiDEC;
    }

    public int getNonDEC() {
        return NonDEC;
    }

    public void setNonDEC(int NonDEC) {
        this.NonDEC = NonDEC;
    }

    public int getEchohraph() {
        return Echohraph;
    }

    public void setEchohraph(int Echohraph) {
        this.Echohraph = Echohraph;
    }

    public int getDosAFP() {
        return DosAFP;
    }

    public void setDosAFP(int DosAFP) {
        this.DosAFP = DosAFP;
    }

    public int getAmaigre() {
        return Amaigre;
    }

    public void setAmaigre(int Amaigre) {
        this.Amaigre = Amaigre;
    }

    public int getFievre() {
        return Fievre;
    }

    public void setFievre(int Fievre) {
        this.Fievre = Fievre;
    }

    public int getIctere() {
        return Ictere;
    }

    public void setIctere(int Ictere) {
        this.Ictere = Ictere;
    }

    public int getDouleurHD() {
        return DouleurHD;
    }

    public void setDouleurHD(int DouleurHD) {
        this.DouleurHD = DouleurHD;
    }

    public int getHemoragieDes() {
        return HemoragieDes;
    }

    public void setHemoragieDes(int HemoragieDes) {
        this.HemoragieDes = HemoragieDes;
    }

    public int getAscite() {
        return Ascite;
    }

    public void setAscite(int Ascite) {
        this.Ascite = Ascite;
    }

    public int getSplenomegalie() {
        return Splenomegalie;
    }

    public void setSplenomegalie(int Splenomegalie) {
        this.Splenomegalie = Splenomegalie;
    }

    public int getAutre() {
        return Autre;
    }

    public void setAutre(int Autre) {
        this.Autre = Autre;
    }

    public int getTypeS1() {
        return TypeS1;
    }

    public void setTypeS1(int TypeS1) {
        this.TypeS1 = TypeS1;
    }

    public int getTypeS2() {
        return TypeS2;
    }

    public void setTypeS2(int TypeS2) {
        this.TypeS2 = TypeS2;
    }

    public int getTypeS3() {
        return TypeS3;
    }

    public void setTypeS3(int TypeS3) {
        this.TypeS3 = TypeS3;
    }

    public int getTypeS4() {
        return TypeS4;
    }

    public void setTypeS4(int TypeS4) {
        this.TypeS4 = TypeS4;
    }

    public int getStade0() {
        return Stade0;
    }

    public void setStade0(int Stade0) {
        this.Stade0 = Stade0;
    }

    public int getStade1() {
        return Stade1;
    }

    public void setStade1(int Stade1) {
        this.Stade1 = Stade1;
    }

    public int getStade2() {
        return Stade2;
    }

    public void setStade2(int Stade2) {
        this.Stade2 = Stade2;
    }

    public int getStade3() {
        return Stade3;
    }

    public void setStade3(int Stade3) {
        this.Stade3 = Stade3;
    }

    public int getStade4() {
        return Stade4;
    }

    public void setStade4(int Stade4) {
        this.Stade4 = Stade4;
    }

    public int getBmi0() {
        return bmi0;
    }

    public void setBmi0(int bmi0) {
        this.bmi0 = bmi0;
    }

    public int getBmi1() {
        return bmi1;
    }

    public void setBmi1(int bmi1) {
        this.bmi1 = bmi1;
    }

    public int getBmi2() {
        return bmi2;
    }

    public void setBmi2(int bmi2) {
        this.bmi2 = bmi2;
    }

    public int getBmi3() {
        return bmi3;
    }

    public void setBmi3(int bmi3) {
        this.bmi3 = bmi3;
    }

    public int getCvcOui() {
        return cvcOui;
    }

    public void setCvcOui(int cvcOui) {
        this.cvcOui = cvcOui;
    }

    public int getCvcNon() {
        return cvcNon;
    }

    public void setCvcNon(int cvcNon) {
        this.cvcNon = cvcNon;
    }

    public int getHpmOui() {
        return hpmOui;
    }

    public void setHpmOui(int hpmOui) {
        this.hpmOui = hpmOui;
    }

    public int getHpmNon() {
        return hpmNon;
    }

    public void setHpmNon(int hpmNon) {
        this.hpmNon = hpmNon;
    }

    public int getFH() {
        return FH;
    }

    public void setFH(int FH) {
        this.FH = FH;
    }

    public int getConsistFerme() {
        return ConsistFerme;
    }

    public void setConsistFerme(int ConsistFerme) {
        this.ConsistFerme = ConsistFerme;
    }

    public int getConsistDure() {
        return ConsistDure;
    }

    public void setConsistDure(int ConsistDure) {
        this.ConsistDure = ConsistDure;
    }

    public int getSurfReg() {
        return SurfReg;
    }

    public void setSurfReg(int SurfReg) {
        this.SurfReg = SurfReg;
    }

    public int getSurfIreg() {
        return SurfIreg;
    }

    public void setSurfIreg(int SurfIreg) {
        this.SurfIreg = SurfIreg;
    }

    public int getOmiOui() {
        return OmiOui;
    }

    public void setOmiOui(int OmiOui) {
        this.OmiOui = OmiOui;
    }

    public int getOmiNon() {
        return OmiNon;
    }

    public void setOmiNon(int OmiNon) {
        this.OmiNon = OmiNon;
    }

    public int getAutreSignesPH() {
        return AutreSignesPH;
    }

    public void setAutreSignesPH(int AutreSignesPH) {
        this.AutreSignesPH = AutreSignesPH;
    }

    public int getSynfdromPOui() {
        return SynfdromPOui;
    }

    public void setSynfdromPOui(int SynfdromPOui) {
        this.SynfdromPOui = SynfdromPOui;
    }

    public int getSynfdromPNon() {
        return SynfdromPNon;
    }

    public void setSynfdromPNon(int SynfdromPNon) {
        this.SynfdromPNon = SynfdromPNon;
    }
 
  
    
    
    public AnalyseClasse AnalStatCirDecouvert() throws SQLException{
        
        Consultation         bddCons            = new Consultation();
        ResultSet   res      = bddCons.ExtElement("select OuiHepat ,NonHepat ,OuiFort ,NonFort ,OuiDEC ,NonDEC ,Echohraph , DosAFP,\n" +
"       Amaigre,Fievre,Ictere,DouleurHD,\n" +
"       HemoragieDes , Ascite ,Splenomegalie,Autre ,\n" +
"       TypeS1,TypeS2,TypeS3,TypeS4,\n" +
"       Stade0,Stade1,Stade2,Stade3,Stade4,\n" +
"       bmi0 ,bmi1 ,bmi2 ,bmi3,\n" +
"       cvcOui,cvcNon,\n" +
"       hpmOui,hpmNon,\n" +
"       FH,ConsistFerme,ConsistDure,SurfReg,SurfIreg,\n" +
"       OmiOui,OmiNon,\n" +
"       AutreSignesPH,\n" +
"       SynfdromPOui,SynfdromPNon\n" +
" from\n" +
"(select count(*) as OuiHepat   from  circonstancedec where  EMTHepato     = 'Oui') as H1,\n" +
"(select count(*) as NonHepat   from  circonstancedec where  EMTHepato     = 'Non') as H2,\n" +
"(select count(*) as OuiFort    from  circonstancedec where  Fortuit       = 'Oui') as F1,\n" +
"(select count(*) as NonFort    from  circonstancedec where  Fortuit       = 'Non') as F2,\n" +
"(select count(*) as OuiDEC     from  circonstancedec where  DECSyrrhose   = 'Oui') as D1,\n" +
"(select count(*) as NonDEC     from  circonstancedec where  DECSyrrhose   = 'Non') as D2,\n" +
"(select count(*) as Echohraph  from  circonstancedec where  Echographie   = 'Oui') as D3,\n" +
"(select count(*) as DosAFP     from  circonstancedec where  DosAFP        = 'Oui') as D4,\n" +
"\n" +
"(select count(*) as Amaigre     from  circonstancedec where  Amaigre      = 'Oui') as g1,\n" +
"(select count(*) as Fievre      from  circonstancedec where  Fievre       = 'Oui') as g2,\n" +
"(select count(*) as Ictere      from  circonstancedec where  Ictere       = 'Oui') as g3,\n" +
"(select count(*) as DouleurHD   from  circonstancedec where  DouleurHD    = 'Oui') as g4,\n" +
"\n" +
"(select count(*) as HemoragieDes     from  circonstancedec where  HemoragieDes      = 'Oui') as hy1, \n" +
"(select count(*) as Ascite           from  circonstancedec where  Ascite            = 'Oui') as hy2,\n" +
"(select count(*) as Splenomegalie    from  circonstancedec where  Splenomegalie     = 'Oui') as hy3,\n" +
"(select count(*) as Autre            from  circonstancedec where  Autre             <> '') as hy4, \n" +
"\n" +
"(select count(*) as TypeS1    from  circonstancedec where  TypeSpleno    = '1') as Type1, \n" +
"(select count(*) as TypeS2    from  circonstancedec where  TypeSpleno    = '2') as Type2,\n" +
"(select count(*) as TypeS3    from  circonstancedec where  TypeSpleno    = '3') as Type3,\n" +
"(select count(*) as TypeS4    from  circonstancedec where  TypeSpleno    = '4') as Type4,\n" +
"\n" +
"(select count(*) as Stade0    from  circonstancedec where  ETGSOms    = '0') as S1,\n" +
"(select count(*) as Stade1    from  circonstancedec where  ETGSOms    = '1') as S2,\n" +
"(select count(*) as Stade2    from  circonstancedec where  ETGSOms    = '2') as S3,\n" +
"(select count(*) as Stade3    from  circonstancedec where  ETGSOms    = '3') as S4,\n" +
"(select count(*) as Stade4    from  circonstancedec where  ETGSOms    = '3') as S5,\n" +
"\n" +
"\n" +
"(select count(*) as bmi0    from  circonstancedec where  BMI    = '<18')    as BMI1,\n" +
"(select count(*) as bmi1    from  circonstancedec where  BMI    = '18-25')  as BMI2,\n" +
"(select count(*) as bmi2    from  circonstancedec where  BMI    = '25-30')  as BMI3,\n" +
"(select count(*) as bmi3    from  circonstancedec where  BMI    = '30<')    as BMI4,\n" +
"\n" +
"(select count(*) as cvcOui    from  circonstancedec where  CVC    = 'Oui')    as CVC1,\n" +
"(select count(*) as cvcNon    from  circonstancedec where  CVC    = 'Non')    as CVC2,\n" +
"\n" +
"(select count(*) as hpmOui    from  circonstancedec where  HPM    = 'Oui')    as hpm1,\n" +
"(select count(*) as hpmNon    from  circonstancedec where  HPM    = 'Non')    as hpm2,\n" +
"\n" +
"(select count(*) as FH              from  circonstancedec where  hpmFH             = 'Oui')          as Soui0,\n" +
"(select count(*) as ConsistFerme    from  circonstancedec where  hpmConsistance    = 'ferme')        as Soui1,\n" +
"(select count(*) as ConsistDure     from  circonstancedec where  hpmConsistance    = 'dure')         as Soui2,\n" +
"(select count(*) as surfReg         from  circonstancedec where  hpmSurface        = 'reguliere')    as Soui3,\n" +
"(select count(*) as surfIreg        from  circonstancedec where  hpmSurface        = 'irreguliere')  as Soui4,\n" +
"\n" +
"(select count(*) as OmiOui    from  circonstancedec where  OMI  = 'Oui')   as omi0,\n" +
"(select count(*) as OmiNon    from  circonstancedec where  OMI  = 'Non')   as omi1,\n" +
"\n" +
"\n" +
"(select count(*) as AutreSignesPH    from  circonstancedec where  AutreS  <> '')   as AutreSignes,\n" +
"\n" +
"\n" +
" (select count(*) as SynfdromPOui       from  circonstancedec where  SyndrParaneo  = 'Oui')   as Syndrom0,\n" +
" (select count(*) as SynfdromPNon       from  circonstancedec where  SyndrParaneo  = 'Non')   as Syndrom1;");
    
    AnalyseClasse    Anal      = new AnalyseClasse();    
        while(res.next()){
        Anal.setOuiHepat(res.getInt(1));
        Anal.setNonHepat(res.getInt(2));
        Anal.setOuiFort(res.getInt(3));
        Anal.setNonFort(res.getInt(4));
        Anal.setOuiDEC(res.getInt(5));
        Anal.setNonDEC(res.getInt(6));
        Anal.setEchohraph(res.getInt(7));
        Anal.setDosAFP(res.getInt(8));
        Anal.setAmaigre(res.getInt(9));
        Anal.setFievre(res.getInt(10));
        Anal.setIctere(res.getInt(11));
        Anal.setDouleurHD(res.getInt(12));
        Anal.setHemoragieDes(res.getInt(13));
        Anal.setAscite(res.getInt(14));
        Anal.setSplenomegalie(res.getInt(15));
        Anal.setAutre(res.getInt(16));
        Anal.setTypeS1(res.getInt(17));
        Anal.setTypeS2(res.getInt(18));
        Anal.setTypeS3(res.getInt(19));
        Anal.setTypeS4(res.getInt(20));
        
        
        Anal.setStade0(res.getInt(21));
        Anal.setStade1(res.getInt(22));
        Anal.setStade2(res.getInt(23));
        Anal.setStade3(res.getInt(24));
        Anal.setStade4(res.getInt(25));
        
        Anal.setBmi0(res.getInt(26));
        Anal.setBmi1(res.getInt(27));
        Anal.setBmi2(res.getInt(28));
        Anal.setBmi3(res.getInt(29));
        
        Anal.setCvcOui(res.getInt(30));
        Anal.setCvcNon(res.getInt(31));
        
        Anal.setHpmOui(res.getInt(32));
        Anal.setHpmNon(res.getInt(33));
        
        Anal.setFH(res.getInt(34));
        
        Anal.setConsistFerme(res.getInt(35));
        Anal.setConsistDure(res.getInt(36));

        Anal.setSurfReg(res.getInt(37));
        Anal.setSurfIreg(res.getInt(38));
        
        Anal.setOmiOui(res.getInt(39));
        Anal.setOmiNon(res.getInt(40));
        
        Anal.setAutreSignesPH(res.getInt(41));
        Anal.setSynfdromPOui(res.getInt(42));
        Anal.setSynfdromPNon(res.getInt(43));
        }
     
    bddCons.CloseConnex();
    return Anal;
    }
    
}
