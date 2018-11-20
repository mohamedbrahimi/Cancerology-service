
package service.medicament.Paramétres;

public class UserClasse {
    
    private String User;
    private String Pass;

    public UserClasse(String User, String Pass) {
        this.User = User;
        this.Pass = Pass;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
    
}
