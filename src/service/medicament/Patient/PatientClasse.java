
package service.medicament.Patient;

public class PatientClasse {
    private String Nom ;
    private String Prenom;
    private String Age;
    private String Sexe;
    private String Wilaya;
    private String Profession;
    private String Adresse;
    private String Tel1;
    private String Tel2; 
    private String SituationFamiliale;
    private String CondSocioEco;
    
    private String NumDossier; 
    private String DateHospital;
    
    /**/
    private String BilanBiologique;
    private String BilanImmnologique;
    private String BilanFOGD;
    
    private String Echographie;
    private String EchographieDoppler;
    private String TDM;
    private String IRM;
    private String Anapath;
    
    
    /***/
    private String Chirurgie;
    private String Alcoolisation;
    private String RadioFrequence;
    private String ChimieOembolisation;
    private String TherapiesCibles;
    private String TraitemenAntiViral;
    
    private int EtatEvolution;
     
    /**/
    
    public PatientClasse(String Nom,String Prenom,String Age,String Sexe,String Wilaya,String Profession,
            String Adresse,String Tel1,String Tel2,String SituationFamiliale,String CondSocioEco){
        this.Nom         = Nom; 
        this.Prenom      = Prenom; 
        this.Age         = Age; 
        this.Adresse     = Adresse;
        this.Sexe        = Sexe  ;  
        this.Tel1        = Tel1; 
        this.Tel2        = Tel2;  
        this.Profession  = Profession; 
        this.SituationFamiliale   = SituationFamiliale;
        this.CondSocioEco         = CondSocioEco;
        this.Wilaya               = Wilaya ;
        
     
    }

   

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public void setWilaya(String Wilaya) {
        this.Wilaya = Wilaya;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setTel1(String Tel1) {
        this.Tel1 = Tel1;
    }

    public void setTel2(String Tel2) {
        this.Tel2 = Tel2;
    }

    public void setSituationFamiliale(String SituationFamiliale) {
        this.SituationFamiliale = SituationFamiliale;
    }

    public void setCondSocioEco(String CondSocioEco) {
        this.CondSocioEco = CondSocioEco;
    }
    

    public void setNumDossier(String NumDossier) {
        this.NumDossier = NumDossier;
    }
    
     public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAge() {
        return Age;
    }

    public String getSexe() {
        return Sexe;
    }

    public String getWilaya() {
        return Wilaya;
    }

    public String getProfession() {
        return Profession;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getTel1() {
        return Tel1;
    }

    public String getTel2() {
        return Tel2;
    }

    public String getSituationFamiliale() {
        return SituationFamiliale;
    }

    public String getCondSocioEco() {
        return CondSocioEco;
    }
    
    public String getNumDossier() {
        return NumDossier;
    }

    public String getDateHospital() {
        return DateHospital;
    }

    public void setDateHospital(String DateHospital) {
        this.DateHospital = DateHospital;
    }

    public String getBilanBiologique() {
        return BilanBiologique;
    }

    public void setBilanBiologique(String BilanBiologique) {
        this.BilanBiologique = BilanBiologique;
    }

    public String getBilanImmnologique() {
        return BilanImmnologique;
    }

    public void setBilanImmnologique(String BilanImmnologique) {
        this.BilanImmnologique = BilanImmnologique;
    }

    public String getBilanFOGD() {
        return BilanFOGD;
    }

    public void setBilanFOGD(String BilanFOGD) {
        this.BilanFOGD = BilanFOGD;
    }

    public String getEchographie() {
        return Echographie;
    }

    public void setEchographie(String Echographie) {
        this.Echographie = Echographie;
    }

    public String getEchographieDoppler() {
        return EchographieDoppler;
    }

    public void setEchographieDoppler(String EchographieDoppler) {
        this.EchographieDoppler = EchographieDoppler;
    }

    public String getTDM() {
        return TDM;
    }

    public void setTDM(String TDM) {
        this.TDM = TDM;
    }

    public String getIRM() {
        return IRM;
    }

    public void setIRM(String IRM) {
        this.IRM = IRM;
    }

    public String getChirurgie() {
        return Chirurgie;
    }

    public void setChirurgie(String Chirurgie) {
        this.Chirurgie = Chirurgie;
    }

    public String getAlcoolisation() {
        return Alcoolisation;
    }

    public void setAlcoolisation(String Alcoolisation) {
        this.Alcoolisation = Alcoolisation;
    }

    public String getRadioFrequence() {
        return RadioFrequence;
    }

    public void setRadioFrequence(String RadioFrequence) {
        this.RadioFrequence = RadioFrequence;
    }

    public String getChimieOembolisation() {
        return ChimieOembolisation;
    }

    public void setChimieOembolisation(String ChimieOembolisation) {
        this.ChimieOembolisation = ChimieOembolisation;
    }

    public String getTherapiesCibles() {
        return TherapiesCibles;
    }

    public void setTherapiesCibles(String TherapiesCibles) {
        this.TherapiesCibles = TherapiesCibles;
    }

    public String getTraitemenAntiViral() {
        return TraitemenAntiViral;
    }

    public void setTraitemenAntiViral(String TraitemenAntiViral) {
        this.TraitemenAntiViral = TraitemenAntiViral;
    }

    public String getAnapath() {
        return Anapath;
    }

    public void setAnapath(String Anapath) {
        this.Anapath = Anapath;
    }

    public int getEtatEvolution() {
        return EtatEvolution;
    }

    public void setEtatEvolution(int EtatEvolution) {
        this.EtatEvolution = EtatEvolution;
    }
 
    
      
}
