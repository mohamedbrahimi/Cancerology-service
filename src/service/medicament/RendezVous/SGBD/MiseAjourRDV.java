
package service.medicament.RendezVous.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiseAjourRDV {
       private   Connection connexion;
       private   Statement  instruction;
       protected ResultSet  résultat;
       private   String     Data  = "hopital1";
       
       
       int res;
    public int  AddElement(String requeteSql) throws SQLException{
       
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         
         connexion   = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction = connexion.createStatement();
         res = instruction.executeUpdate(requeteSql);
          
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
        
        public int  removeElement(String requeteSql) throws SQLException{
       
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         
         connexion       = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction     = connexion.createStatement();
         res             = instruction.executeUpdate(requeteSql);
          
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
}

