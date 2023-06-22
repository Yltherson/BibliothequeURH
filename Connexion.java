/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioproject;
import java.sql.*;
/**
 *
 * @author Yltherson
 */
public class Connexion {
    
    public static void connecter(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Ok!");
            
            String url = "jdbc:mysql://localhost:3306/biblio";
        
            String user = "root";
        
            String password = "";
            
            try (Connection con = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connexion reussi !");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
//            System.out.println("echec de la connection");
        }
    }
}
