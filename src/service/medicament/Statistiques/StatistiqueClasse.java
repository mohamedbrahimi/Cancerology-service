
package service.medicament.Statistiques;

import java.sql.ResultSet;
import java.sql.SQLException;
import service.medicament.SGBD.Consultation;


public class StatistiqueClasse {
   
       
    private int Age1;  
    private int Age2;
    private int Age3;
    private int Age4;
    
   
    private int Femme;
    private int Homme;

    private int CondBon;
    private int CondMoy;
    private int CondMau;
    
    private int Situat1;
    private int Situat2;
    
    private int CauseD1;
    private int CauseD2;
    private int CauseD3;
    private int CauseD4;
    private int TotalDeD;
    /***/
    private int          Adrar;
    private int          Chlef;
    private int          Tamanrasset;
    private int          Illizi;
    private int          Ouargla;
    private int          Bechar;
    private int          Tindouf;
    private int          Ghardaïa;
    private int          Bayadh;
    private int          Djelfa;
    private int          Oued;
    private int          Naâma;
    private int          Laghouat;
    private int          Biskra;
    private int          Tiaret;
    private int          Msila;
    private int          Tébessa;
    private int          Batna;
    private int          Khenchela;
    private int          SidiBelAbbès;
    private int          Tlemcen;
    private int          Médéa;
    private int          OumElBouaghi;
    private int          Saïda;
    private int          Sétif;
    private int          Mascara;
    private int          AïnDefla;
    private int          Relizane;
    private int          SoukAhras;
    private int          Bouira;
    private int          BordjBouArreridj;
    private int          Guelma;
    private int          Skikda;
    private int          TiziOuzou;
    private int          Mila,ElTarf;
    private int          Béjaïa;
    private int          Tissemsilt;
    private int          Jijel;
    private int          AïnTémouchent;
    private int          Constantine;
    private int          Mostaganem;
    private int          Tipaza;
    private int          Oran;
    private int          Boumerdès;
    private int          Blida;
    private int          Annaba;
    private int          Alger;
    
    public StatistiqueClasse() {
    }

    public int getAge1() {
        return Age1;
    }

    public void setAge1(int Age1) {
        this.Age1 = Age1;
    }

    public int getAge2() {
        return Age2;
    }

    public void setAge2(int Age2) {
        this.Age2 = Age2;
    }

    public int getAge3() {
        return Age3;
    }

    public void setAge3(int Age3) {
        this.Age3 = Age3;
    }

    public int getAge4() {
        return Age4;
    }

    public void setAge4(int Age4) {
        this.Age4 = Age4;
    }

    public int getFemme() {
        return Femme;
    }

    public void setFemme(int Femme) {
        this.Femme = Femme;
    }

    public int getHomme() {
        return Homme;
    }

    public void setHomme(int Homme) {
        this.Homme = Homme;
    }

    public int getCondBon() {
        return CondBon;
    }

    public void setCondBon(int CondBon) {
        this.CondBon = CondBon;
    }

    public int getCondMoy() {
        return CondMoy;
    }

    public void setCondMoy(int CondMoy) {
        this.CondMoy = CondMoy;
    }

    public int getCondMau() {
        return CondMau;
    }

    public void setCondMau(int CondMau) {
        this.CondMau = CondMau;
    }

    public int getSituat1() {
        return Situat1;
    }

    public void setSituat1(int Situat1) {
        this.Situat1 = Situat1;
    }

    public int getSituat2() {
        return Situat2;
    }

    public void setSituat2(int Situat2) {
        this.Situat2 = Situat2;
    }

    public int getCauseD1(){
        
        return CauseD1;
    }

    public void setCauseD1(int CauseD1) {
        this.CauseD1 = CauseD1;
    }

    public int getCauseD2() {
        return CauseD2;
    }

    public void setCauseD2(int CauseD2) {
        this.CauseD2 = CauseD2;
    }

    public int getCauseD3() {
        return CauseD3;
    }

    public void setCauseD3(int CauseD3) {
        this.CauseD3 = CauseD3;
    }

    public int getCauseD4() {
        return CauseD4;
    }

    
    public void setCauseD4(int CauseD4) {    
        this.CauseD4 = CauseD4;
    }

    public int getTotalDeD() {
        return TotalDeD;
    }

    public void setTotalDeD(int TotalDeD) {
        this.TotalDeD = TotalDeD;
    }

    
    /**/
    /*******************************/
    public int getAdrar() {
        return Adrar;
    }

    public void setAdrar(int Adrar) {
        this.Adrar = Adrar;
    }

    public int getChlef() {
        return Chlef;
    }

    public void setChlef(int Chlef) {
        this.Chlef = Chlef;
    }

    public int getTamanrasset() {
        return Tamanrasset;
    }

    public void setTamanrasset(int Tamanrasset) {
        this.Tamanrasset = Tamanrasset;
    }

    public int getIllizi() {
        return Illizi;
    }

    public void setIllizi(int Illizi) {
        this.Illizi = Illizi;
    }

    public int getOuargla() {
        return Ouargla;
    }

    public void setOuargla(int Ouargla) {
        this.Ouargla = Ouargla;
    }

    public int getBechar() {
        return Bechar;
    }

    public void setBechar(int Bechar) {
        this.Bechar = Bechar;
    }

    public int getTindouf() {
        return Tindouf;
    }

    public void setTindouf(int Tindouf) {
        this.Tindouf = Tindouf;
    }

    public int getGhardaïa() {
        return Ghardaïa;
    }

    public void setGhardaïa(int Ghardaïa) {
        this.Ghardaïa = Ghardaïa;
    }

    public int getBayadh() {
        return Bayadh;
    }

    public void setBayadh(int Bayadh) {
        this.Bayadh = Bayadh;
    }

    public int getDjelfa() {
        return Djelfa;
    }

    public void setDjelfa(int Djelfa) {
        this.Djelfa = Djelfa;
    }

    public int getOued() {
        return Oued;
    }

    public void setOued(int Oued) {
        this.Oued = Oued;
    }

    public int getNaâma() {
        return Naâma;
    }

    public void setNaâma(int Naâma) {
        this.Naâma = Naâma;
    }

    public int getLaghouat() {
        return Laghouat;
    }

    public void setLaghouat(int Laghouat) {
        this.Laghouat = Laghouat;
    }

    public int getBiskra() {
        return Biskra;
    }

    public void setBiskra(int Biskra) {
        this.Biskra = Biskra;
    }

    public int getTiaret() {
        return Tiaret;
    }

    public void setTiaret(int Tiaret) {
        this.Tiaret = Tiaret;
    }

    public int getMsila() {
        return Msila;
    }

    public void setMsila(int Msila) {
        this.Msila = Msila;
    }

    public int getTébessa() {
        return Tébessa;
    }

    public void setTébessa(int Tébessa) {
        this.Tébessa = Tébessa;
    }

    public int getBatna() {
        return Batna;
    }

    public void setBatna(int Batna) {
        this.Batna = Batna;
    }

    public int getKhenchela() {
        return Khenchela;
    }

    public void setKhenchela(int Khenchela) {
        this.Khenchela = Khenchela;
    }

    public int getSidiBelAbbès() {
        return SidiBelAbbès;
    }

    public void setSidiBelAbbès(int SidiBelAbbès) {
        this.SidiBelAbbès = SidiBelAbbès;
    }

    public int getTlemcen() {
        return Tlemcen;
    }

    public void setTlemcen(int Tlemcen) {
        this.Tlemcen = Tlemcen;
    }

    public int getMédéa() {
        return Médéa;
    }

    public void setMédéa(int Médéa) {
        this.Médéa = Médéa;
    }

    public int getOumElBouaghi() {
        return OumElBouaghi;
    }

    public void setOumElBouaghi(int OumElBouaghi) {
        this.OumElBouaghi = OumElBouaghi;
    }

    public int getSaïda() {
        return Saïda;
    }

    public void setSaïda(int Saïda) {
        this.Saïda = Saïda;
    }

    public int getSétif() {
        return Sétif;
    }

    public void setSétif(int Sétif) {
        this.Sétif = Sétif;
    }

    public int getMascara() {
        return Mascara;
    }

    public void setMascara(int Mascara) {
        this.Mascara = Mascara;
    }

    public int getAïnDefla() {
        return AïnDefla;
    }

    public void setAïnDefla(int AïnDefla) {
        this.AïnDefla = AïnDefla;
    }

    public int getRelizane() {
        return Relizane;
    }

    public void setRelizane(int Relizane) {
        this.Relizane = Relizane;
    }

    public int getSoukAhras() {
        return SoukAhras;
    }

    public void setSoukAhras(int SoukAhras) {
        this.SoukAhras = SoukAhras;
    }

    public int getBouira() {
        return Bouira;
    }

    public void setBouira(int Bouira) {
        this.Bouira = Bouira;
    }

    public int getBordjBouArreridj() {
        return BordjBouArreridj;
    }

    public void setBordjBouArreridj(int BordjBouArreridj) {
        this.BordjBouArreridj = BordjBouArreridj;
    }

    public int getGuelma() {
        return Guelma;
    }

    public void setGuelma(int Guelma) {
        this.Guelma = Guelma;
    }

    public int getSkikda() {
        return Skikda;
    }

    public void setSkikda(int Skikda) {
        this.Skikda = Skikda;
    }

    public int getTiziOuzou() {
        return TiziOuzou;
    }

    public void setTiziOuzou(int TiziOuzou) {
        this.TiziOuzou = TiziOuzou;
    }

    public int getMila() {
        return Mila;
    }

    public void setMila(int Mila) {
        this.Mila = Mila;
    }

    public int getElTarf() {
        return ElTarf;
    }

    public void setElTarf(int ElTarf) {
        this.ElTarf = ElTarf;
    }

    public int getBéjaïa() {
        return Béjaïa;
    }

    public void setBéjaïa(int Béjaïa) {
        this.Béjaïa = Béjaïa;
    }

    public int getTissemsilt() {
        return Tissemsilt;
    }

    public void setTissemsilt(int Tissemsilt) {
        this.Tissemsilt = Tissemsilt;
    }

    public int getJijel() {
        return Jijel;
    }

    public void setJijel(int Jijel) {
        this.Jijel = Jijel;
    }

    public int getAïnTémouchent() {
        return AïnTémouchent;
    }

    public void setAïnTémouchent(int AïnTémouchent) {
        this.AïnTémouchent = AïnTémouchent;
    }

    public int getConstantine() {
        return Constantine;
    }

    public void setConstantine(int Constantine) {
        this.Constantine = Constantine;
    }

    public int getMostaganem() {
        return Mostaganem;
    }

    public void setMostaganem(int Mostaganem) {
        this.Mostaganem = Mostaganem;
    }

    public int getTipaza() {
        return Tipaza;
    }

    public void setTipaza(int Tipaza) {
        this.Tipaza = Tipaza;
    }

    public int getOran() {
        return Oran;
    }

    public void setOran(int Oran) {
        this.Oran = Oran;
    }

    public int getBoumerdès() {
        return Boumerdès;
    }

    public void setBoumerdès(int Boumerdès) {
        this.Boumerdès = Boumerdès;
    }

    public int getBlida() {
        return Blida;
    }

    public void setBlida(int Blida) {
        this.Blida = Blida;
    }

    public int getAnnaba() {
        return Annaba;
    }

    public void setAnnaba(int Annaba) {
        this.Annaba = Annaba;
    }

    public int getAlger() {
        return Alger;
    }

    /****/
    public void setAlger(int Alger) {    
        this.Alger = Alger;
    }

    /****/
    public StatistiqueClasse getInfoStat() throws SQLException {
        Consultation StatCons       = new Consultation();
        ResultSet res = StatCons.ExtElement("select Age1 ,Age2 ,Age3 ,Age4 ,Homme,Femme ,Cond1 ,Cond2 ,Cond3,situat1,situat2, \n" +
"        Rvo,Encephalopathie,ProgressionT,Autre,TotalD From \n" +
"                                  (select count(*) as Age1    from Patient where Age < 15 )              as PAge1,\n" +
"                                  (select count(*) as Age2    from Patient where Age >= 15 and Age < 30) as PAge2,\n" +
"                                  (select count(*) as Age3    from Patient where Age >= 30 and Age < 60) as PAge3,\n" +
"                                  (select count(*) as Age4    from Patient where Age >= 60 )as PAge4,\n" +
"                                  (select count(*) as Homme   from Patient where Sexe ='Masculin') as PHomme,\n" +
"                                  (select count(*) as Femme   from Patient where Sexe ='Féminin')  as PFemme,\n" +
"                                  (select count(*) as Cond1   from Patient where CondSocioEco like '%mauvaise') as PCond1,\n" +
"                                  (select count(*) as Cond2   from Patient where CondSocioEco like '%moyenne')  as PCond2,\n" +
"				   (select count(*) as Cond3   from Patient where CondSocioEco like '%bonne')    as PCond3,\n" +
"                                  (select count(*) as situat1 from Patient where SituationFamiliale = 'Marie')       as PSituat1, \n" +
"                                  (select count(*) as situat2 from Patient where SituationFamiliale = 'Célibataire') as PSituat2,\n" +
"                                  (select count(*) as Rvo             from Deces where RVO             ='Oui')as PD1,\n" +
"                                  (select count(*) as Encephalopathie from Deces where Encephalopathie ='Oui')as PD2,\n" +
"                                  (select count(*) as ProgressionT    from Deces where ProgressionT    ='Oui')as PD3,\n" +
"                                  (select count(*) as Autre           from Deces where Autre           <>''  )as PD4,\n" +
"                                  (select count(*) as TotalD          from Deces )as PTD;  ");
        StatistiqueClasse   stat = new StatistiqueClasse() ;
        while(res.next()){
            stat.setAge1(res.getInt(1));
            stat.setAge2(res.getInt(2));
            stat.setAge3(res.getInt(3));
            stat.setAge4(res.getInt(4));
            
            stat.setHomme(res.getInt(5));
            stat.setFemme(res.getInt(6));
            
            stat.setCondBon(res.getInt(9));
            stat.setCondMoy(res.getInt(8));
            stat.setCondMau(res.getInt(7));
            
            stat.setSituat1(res.getInt(10));
            stat.setSituat2(res.getInt(11));
            
            stat.setCauseD1(res.getInt(12));
            stat.setCauseD2(res.getInt(13));
            stat.setCauseD3(res.getInt(14));
            stat.setCauseD4(res.getInt(15));
            stat.setTotalDeD(res.getInt(16));
                    }
        
        StatCons.CloseConnex();
        
        return stat;
    }
    
    public StatistiqueClasse getInfoStatWilaya() throws SQLException{
      Consultation StatCons       = new Consultation();
      ResultSet    res    = StatCons.ExtElement(" Select Adrar,Chlef,Tamanrasset,Illizi,Ouargla,Bechar,Tindouf,Ghardaïa,\n" +
"                                   Bayadh,Djelfa,Oued,Naâma,Laghouat,Biskra,Tiaret,Msila,Tébessa,\n" +
"                                   Batna,Khenchela,SidiBelAbbès,Tlemcen,Médéa,OumElBouaghi,Saïda,\n" +
"								   Sétif,Mascara,AïnDefla,Relizane,SoukAhras,Bouira,BordjBouArreridj,\n" +
"                                   Guelma,Skikda,TiziOuzou,Mila,ElTarf,Béjaïa,Tissemsilt,Jijel,\n" +
"                                   AïnTémouchent,Constantine,Mostaganem,Tipaza,Oran,Boumerdès,Blida,Annaba,\n" +
"                                   Alger from \n" +
"(select count(*) as Adrar        from Patient Where Wilaya = 'Adrar')       as W1,\n" +
"(select count(*) as Chlef        from Patient Where Wilaya = 'Chlef')       as W2,\n" +
"(select count(*) as Tamanrasset  from Patient Where Wilaya = 'Tamanrasset') as W3,\n" +
"(select count(*) as Illizi       from Patient Where Wilaya = 'Illizi')   as W4,\n" +
"(select count(*) as Ouargla      from Patient Where Wilaya = 'Ouargla')  as W5,\n" +
"(select count(*) as Bechar       from Patient Where Wilaya = 'Béchar')   as W6,\n" +
"(select count(*) as Tindouf      from Patient Where Wilaya = 'Tindouf')  as W7,\n" +
"(select count(*) as Ghardaïa     from Patient Where Wilaya = 'Ghardaïa') as W8,\n" +
"(select count(*) as Bayadh       from Patient Where Wilaya = 'Bayadh')   as W9,\n" +
"(select count(*) as Djelfa       from Patient Where Wilaya = 'Djelfa')   as W10,\n" +
"(select count(*) as Oued         from Patient Where Wilaya = 'Oued')     as W11,\n" +
"(select count(*) as Naâma        from Patient Where Wilaya = 'Naâma')    as W12,\n" +
"(select count(*) as Laghouat     from Patient Where Wilaya = 'Laghouat') as W13,\n" +
"(select count(*) as Biskra       from Patient Where Wilaya = 'Biskra')   as W14,\n" +
"(select count(*) as Tiaret       from Patient Where Wilaya = 'Tiaret')   as W15,\n" +
"(select count(*) as Msila        from Patient Where Wilaya = 'Msila')    as W16,\n" +
"(select count(*) as Tébessa      from Patient Where Wilaya = 'Tébessa')  as W17,\n" +
"(select count(*) as Batna        from Patient Where Wilaya = 'Batna')    as W18,\n" +
"(select count(*) as Khenchela    from Patient Where Wilaya = 'Khenchela') as W19,\n" +
"(select count(*) as SidiBelAbbès from Patient Where Wilaya = 'Sidi Bel Abbès') as W20,\n" +
"(select count(*) as Tlemcen      from Patient Where Wilaya = 'Tlemcen')        as W21,\n" +
"(select count(*) as Médéa        from Patient Where Wilaya = 'Médéa')          as W22,\n" +
"(select count(*) as OumElBouaghi from Patient Where Wilaya = 'Oum El Bouaghi') as W23,\n" +
"(select count(*) as Saïda        from Patient Where Wilaya = 'Saïda')          as W24,\n" +
"(select count(*) as Sétif        from Patient Where Wilaya = 'Sétif')          as W25,\n" +
"(select count(*) as Mascara      from Patient Where Wilaya = 'Mascara')        as W26,\n" +
"(select count(*) as AïnDefla     from Patient Where Wilaya = 'Aïn Defla')  as W27,\n" +
"(select count(*) as Relizane     from Patient Where Wilaya = 'Relizane')   as W28,\n" +
"(select count(*) as SoukAhras    from Patient Where Wilaya = 'Souk Ahras') as W29,\n" +
"(select count(*) as Bouira       from Patient Where Wilaya = 'Bouira')     as W30,\n" +
"(select count(*) as BordjBouArreridj  from Patient Where Wilaya = 'Bordj Bou Arreridj') as W31,\n" +
"(select count(*) as Guelma       from Patient Where Wilaya = 'Guelma')     as W32,\n" +
"(select count(*) as Skikda       from Patient Where Wilaya = 'Skikda')     as W33,\n" +
"(select count(*) as TiziOuzou    from Patient Where Wilaya = 'Tizi Ouzou') as W34,\n" +
"(select count(*) as Mila         from Patient Where Wilaya = 'Mila')       as W35,\n" +
"(select count(*) as ElTarf       from Patient Where Wilaya = 'El Tarf')    as W36,\n" +
"(select count(*) as Béjaïa       from Patient Where Wilaya = 'Béjaïa')     as W37,\n" +
"(select count(*) as Tissemsilt   from Patient Where Wilaya = 'Tissemsilt') as W38,\n" +
"(select count(*) as Jijel        from Patient Where Wilaya = 'Jijel')      as W39,\n" +
"(select count(*) as AïnTémouchent from Patient Where Wilaya = 'Aïn Témouchent')   as W40,\n" +
"(select count(*) as Constantine   from Patient Where Wilaya = 'Constantine')      as W41,\n" +
"(select count(*) as Mostaganem    from Patient Where Wilaya = 'Mostaganem')       as W42,\n" +
"(select count(*) as Tipaza        from Patient Where Wilaya = 'Tipaza')           as W43,\n" +
"(select count(*) as Oran          from Patient Where Wilaya = 'Oran')             as W44,\n" +
"(select count(*) as Boumerdès     from Patient Where Wilaya = 'Boumerdès')        as W45,\n" +
"(select count(*) as Blida         from Patient Where Wilaya = 'Blida')            as W46,\n" +
"(select count(*) as Annaba        from Patient Where Wilaya = 'Annaba')           as W47,\n" +
"(select count(*) as Alger         from Patient Where Wilaya = 'Alger')            as W48;");
  
      StatistiqueClasse   stat = new StatistiqueClasse() ;
      
while(res.next()){/*Mostaganem,Tipaza,Oran,Boumerdès,Blida,Annaba,
                                   Alger*/
 stat.setAdrar(res.getInt(1));             stat.setChlef(res.getInt(2));           stat.setTamanrasset(res.getInt(3));
 stat.setIllizi(res.getInt(4));            stat.setOuargla(res.getInt(5));         stat.setBechar(res.getInt(6));
 stat.setTindouf(res.getInt(7));           stat.setGhardaïa(res.getInt(8));        stat.setDjelfa(res.getInt(10));
 stat.setBayadh(res.getInt(9));            stat.setOued(res.getInt(11));           stat.setNaâma(res.getInt(12));
 stat.setLaghouat(res.getInt(13));         stat.setBiskra(res.getInt(14));         stat.setTiaret(res.getInt(15));
 stat.setMsila(res.getInt(16));            stat.setTébessa(res.getInt(17));        stat.setBatna(res.getInt(18));
 stat.setKhenchela(res.getInt(19));        stat.setSidiBelAbbès(res.getInt(20));   stat.setTlemcen(res.getInt(21));
 stat.setMédéa(res.getInt(22));            stat.setOumElBouaghi(res.getInt(23));   stat.setSaïda(res.getInt(24));
 stat.setSétif(res.getInt(25));            stat.setMascara(res.getInt(26));        stat.setAïnDefla(res.getInt(27));
 stat.setRelizane(res.getInt(28));         stat.setSoukAhras(res.getInt(29));      stat.setBouira(res.getInt(30));
 stat.setBordjBouArreridj(res.getInt(31)); stat.setGuelma(res.getInt(32));         stat.setSkikda(res.getInt(33));
 stat.setTiziOuzou(res.getInt(34));        stat.setMila(res.getInt(35));           stat.setElTarf(res.getInt(36));
 stat.setBéjaïa(res.getInt(37));           stat.setTissemsilt(res.getInt(38));     stat.setJijel(res.getInt(39));
 stat.setAïnTémouchent(res.getInt(40));    stat.setConstantine(res.getInt(41));    stat.setMostaganem(res.getInt(42));
 stat.setTipaza(res.getInt(43));           stat.setOran(res.getInt(44));           stat.setBoumerdès(res.getInt(45));
 stat.setBlida(res.getInt(46));            stat.setAnnaba(res.getInt(47));         stat.setAlger(res.getInt(48));
}
   StatCons.CloseConnex();
    return stat;
    }
    
    
}
