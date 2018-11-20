
package service.medicament.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiseAjour {
       private   Connection connexion;
       private   Statement  instruction;
       protected ResultSet  résultat;
       private   String     Data    = "hopital1";
       
       private   String     NumDossier;
       int res;
    public int  AddElement(String requeteSql) throws SQLException{
       
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         connexion = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction = connexion.createStatement();
           res =instruction.executeUpdate(requeteSql);
          
         instruction.close();
         connexion.close();
      } 
      catch (ClassNotFoundException ex) {
         System.err.println("Problème de pilote");
      }catch (SQLException ex) {
         System.err.println("Base de données non trouvée ou requête incorrecte");
         System.err.println(ex.getLocalizedMessage());
      }
        return res;
        
  }

    /**
     //
     **/
    public String getNumDossier() {
        return NumDossier;
    }

    public void setNumDossier(String NumDossier) {
        this.NumDossier = NumDossier;
    }
    
    
                
}
