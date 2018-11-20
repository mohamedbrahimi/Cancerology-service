/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.medicament.RendezVous.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author BRAHIMI
 */
public class ConsultationRDV {
    
       private   Connection connexion;
       private   Statement instruction;
       protected ResultSet résultat,res;
       private   String    Data  = "hopital1"; 
       
       
    public ResultSet  ExtRDV(int i) throws SQLException{
      
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         connexion   = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction = connexion.createStatement();
         int PosDay  = LocalDate.now().getDayOfWeek().getValue();
         résultat    = instruction.executeQuery("select * from RendezVous Where DateRendezVous >'"+LocalDate.now().minusDays(PosDay).plusDays(i*7)+
                                                "' and DateRendezVous <= '"+LocalDate.now().minusDays(PosDay).plusDays(i*7+7)+"' Order by DateRendezVous,HeureRendezVous");
        
      
      } 
      catch (ClassNotFoundException ex) {
         System.err.println("Problème de pilote");
      }catch (SQLException ex) {
         System.err.println("Base de données non trouvée ou requête incorrecte");
         System.err.println(ex.getLocalizedMessage());
      }
        
        return résultat;
        
    }
    public ResultSet  ExtRDVjour() throws SQLException{
      
        try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connection Etablie");
         connexion   = DriverManager.getConnection("jdbc:mysql://localhost/"+Data, "root", "brahimi");
         instruction = connexion.createStatement();
         int PosDay  = LocalDate.now().getDayOfWeek().getValue();
         résultat    = instruction.executeQuery("select * from RendezVous Where DateRendezVous ='"+LocalDate.now()+"' ORDER BY HeureRendezVous");
        
      
      } 
      catch (ClassNotFoundException ex) {
         System.err.println("Problème de pilote");
      }catch (SQLException ex) {
         System.err.println("Base de données non trouvée ou requête incorrecte");
         System.err.println(ex.getLocalizedMessage());
      }
        
        return résultat;
        
    }
    
    
        public void CloseConnex() throws SQLException{
        instruction.close();
        connexion.close();  
    }
        

    
}
