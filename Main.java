/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioproject;
import java.util.Scanner;
/**
 *
 * @author PC
 */

public class Main {
    
    static Scanner input = new Scanner(System.in);
    /**
     *
     * @param args
     */
    public static void main(String[] args){
//        new Connexion().connecter();
//        Connexion cn = new Connexion();
//        cn.connecter();
        ajoutEtu();
    }
    
    static int idEt;
    static String nomEt,prenEt,sexe,fact,niveau,email,phone,adresse;
    
    public static void ajoutEtu(){
        System.out.println("--AJOUTER UN ADHERANT--\n");
        System.out.println("Entrer l'identifiant de l'eutdiant");
        idEt = input.nextInt();
        input.nextLine();
        
        System.out.println("Entrer le nom et prenom de l'etudiant.");
        nomEt = input.nextLine();
        
        System.out.println(idEt+"\n"+nomEt);
        
    }
}
