
package service.medicament.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import service.medicament.Patient.PatientClasse;

public class Consultation {
       private   Connection connexion;
       private   Statement instruction;
       protected ResultSet résultat,res;
       private   String    Data   = "hopital1"; 
       
       private   String    NumDossier;
       
       
    public ResultSet  ExtElement(String requeteSql) throws SQLException{
      
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         connexion = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction = connexion.createStatement();
         résultat =instruction.executeQuery(requeteSql);
         
      
      } 
      catch (ClassNotFoundException ex) {
         System.err.println("Problème de pilote");
      }catch (SQLException ex) {
         System.err.println("Base de données non trouvée ou requête incorrecte");
         System.err.println(ex.getLocalizedMessage());
      }
        
        return résultat;
        
    }
    
    
     public boolean  VerifElement(String requeteSql) throws SQLException{
         boolean existe = false;
         String  NumDossier = null;
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         connexion   = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction = connexion.createStatement();
         résultat    = instruction.executeQuery(requeteSql);
         
         while(résultat.next())NumDossier = résultat.getString(1);
         
         try{
         if(NumDossier.equals(""))existe = false;
         else existe = true;
         }catch(Exception e){
             existe = false;
         }
       CloseConnex();
      } 
      catch (ClassNotFoundException ex) {
         System.err.println("Problème de pilote");
      }catch (SQLException ex) {
         System.err.println("Base de données non trouvée ou requête incorrecte");
         System.err.println(ex.getLocalizedMessage());
      }
        return existe;
     }
     
    public void CloseConnex() throws SQLException{
        instruction.close();      
        connexion.close();        
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
