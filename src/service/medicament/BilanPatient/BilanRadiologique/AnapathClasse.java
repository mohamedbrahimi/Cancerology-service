
package service.medicament.BilanPatient.BilanRadiologique;

import java.util.Date;

public class AnapathClasse {
    private  Date TDateAnapath       ;
    private  String TAnapath           ;
    private  String TPEchoGuide        ;
    private  String TPBiopsieTumeur    ;
    private  String TPBiopsieFAdjacent ;
    private  String TPieceOperatoire   ;
    private  String TResultas          ;
    private  String TLame              ;
    private  String TService           ;
    private  String TAutreService      ;
    private  String TImmunom           ;
    private  String TClassifGrade      ;
    private  String TDifference        ;
    private  String TEFoieNTumoral     ; 
    private  String TActivite          ;
    private  String TFibrose           ; 

    public AnapathClasse(Date TDateAnapath, String TAnapath, String TPEchoGuide, String TPBiopsieTumeur, String TPBiopsieFAdjacent, String TPieceOperatoire, String TResultas, String TLame, String TService, String TAutreService, String TImmunom, String TClassifGrade, String TDifference, String TEFoieNTumoral, String TActivite, String TFibrose) {
        this.TDateAnapath = TDateAnapath;
        this.TAnapath = TAnapath;
        this.TPEchoGuide = TPEchoGuide;
        this.TPBiopsieTumeur = TPBiopsieTumeur;
        this.TPBiopsieFAdjacent = TPBiopsieFAdjacent;
        this.TPieceOperatoire = TPieceOperatoire;
        this.TResultas = TResultas;
        this.TLame = TLame;
        this.TService = TService;
        this.TAutreService = TAutreService;
        this.TImmunom = TImmunom;
        this.TClassifGrade = TClassifGrade;
        this.TDifference = TDifference;
        this.TEFoieNTumoral = TEFoieNTumoral;
        this.TActivite = TActivite;
        this.TFibrose = TFibrose;
    }

    public Date getTDateAnapath() {
        return TDateAnapath;
    }

    public void setTDateAnapath(Date TDateAnapath) {
        this.TDateAnapath = TDateAnapath;
    }

    public String getTAnapath() {
        return TAnapath;
    }

    public void setTAnapath(String TAnapath) {
        this.TAnapath = TAnapath;
    }

    public String getTPEchoGuide() {
        return TPEchoGuide;
    }

    public void setTPEchoGuide(String TPEchoGuide) {
        this.TPEchoGuide = TPEchoGuide;
    }

    public String getTPBiopsieTumeur() {
        return TPBiopsieTumeur;
    }

    public void setTPBiopsieTumeur(String TPBiopsieTumeur) {
        this.TPBiopsieTumeur = TPBiopsieTumeur;
    }

    public String getTPBiopsieFAdjacent() {
        return TPBiopsieFAdjacent;
    }

    public void setTPBiopsieFAdjacent(String TPBiopsieFAdjacent) {
        this.TPBiopsieFAdjacent = TPBiopsieFAdjacent;
    }

    public String getTPieceOperatoire() {
        return TPieceOperatoire;
    }

    public void setTPieceOperatoire(String TPieceOperatoire) {
        this.TPieceOperatoire = TPieceOperatoire;
    }

    public String getTResultas() {
        return TResultas;
    }

    public void setTResultas(String TResultas) {
        this.TResultas = TResultas;
    }

    public String getTLame() {
        return TLame;
    }

    public void setTLame(String TLame) {
        this.TLame = TLame;
    }

    public String getTService() {
        return TService;
    }

    public void setTService(String TService) {
        this.TService = TService;
    }

    public String getTAutreService() {
        return TAutreService;
    }

    public void setTAutreService(String TAutreService) {
        this.TAutreService = TAutreService;
    }

    public String getTImmunom() {
        return TImmunom;
    }

    public void setTImmunom(String TImmunom) {
        this.TImmunom = TImmunom;
    }

    public String getTClassifGrade() {
        return TClassifGrade;
    }

    public void setTClassifGrade(String TClassifGrade) {
        this.TClassifGrade = TClassifGrade;
    }

    public String getTDifference() {
        return TDifference;
    }

    public void setTDifference(String TDifference) {
        this.TDifference = TDifference;
    }

    public String getTEFoieNTumoral() {
        return TEFoieNTumoral;
    }

    public void setTEFoieNTumoral(String TEFoieNTumoral) {
        this.TEFoieNTumoral = TEFoieNTumoral;
    }

    public String getTActivite() {
        return TActivite;
    }

    public void setTActivite(String TActivite) {
        this.TActivite = TActivite;
    }

    public String getTFibrose() {
        return TFibrose;
    }

    public void setTFibrose(String TFibrose) {
        this.TFibrose = TFibrose;
    }
    
}
