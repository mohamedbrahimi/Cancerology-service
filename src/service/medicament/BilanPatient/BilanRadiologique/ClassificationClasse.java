
package service.medicament.BilanPatient.BilanRadiologique;

public class ClassificationClasse {
        private String TClassifChildPugh    ;
        private String TClassifBCLC         ;
        private String TClassifOkuda        ;
        private String TClassifClip         ;
        private String TClassificationTnm   ;

    public ClassificationClasse(String TClassifChildPugh, String TClassifBCLC, String TClassifOkuda, String TClassifClip, String TClassificationTnm) {
        this.TClassifChildPugh = TClassifChildPugh;
        this.TClassifBCLC = TClassifBCLC;
        this.TClassifOkuda = TClassifOkuda;
        this.TClassifClip = TClassifClip;
        this.TClassificationTnm = TClassificationTnm;
    }

    public String getTClassifChildPugh() {
        return TClassifChildPugh;
    }

    public void setTClassifChildPugh(String TClassifChildPugh) {
        this.TClassifChildPugh = TClassifChildPugh;
    }

    public String getTClassifBCLC() {
        return TClassifBCLC;
    }

    public void setTClassifBCLC(String TClassifBCLC) {
        this.TClassifBCLC = TClassifBCLC;
    }

    public String getTClassifOkuda() {
        return TClassifOkuda;
    }

    public void setTClassifOkuda(String TClassifOkuda) {
        this.TClassifOkuda = TClassifOkuda;
    }

    public String getTClassifClip() {
        return TClassifClip;
    }

    public void setTClassifClip(String TClassifClip) {
        this.TClassifClip = TClassifClip;
    }

    public String getTClassificationTnm() {
        return TClassificationTnm;
    }

    public void setTClassificationTnm(String TClassificationTnm) {
        this.TClassificationTnm = TClassificationTnm;
    }
        
        
}
