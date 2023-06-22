/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioproject;
import java.util.ArrayList;
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
    static String nomEt,sexe,fact,niveau,email,phone,adresse;
    
    static Adherant Ad;
    static ArrayList<Adherant> LAdherant = new ArrayList<>();
    
    public static void ajoutEtu(){
        System.out.println("--AJOUTER UN ADHERANT--\n");
        System.out.println("Entrer l'identifiant de l'etudiant");
        idEt = input.nextInt();
        input.nextLine();
        
        System.out.println("Entrer le nom et prenom de l'etudiant.");
        nomEt = input.nextLine();
        
        System.out.println("Entrer le sexe :");
        sexe = input.nextLine();
        
        System.out.println("Entrer la faculte :");
        fact = input.nextLine();
        
        System.out.println("Entrer le niveau :");
        niveau = input.nextLine();
        
        System.out.println("Entrer l'email :");
        email = input.nextLine();
        
        System.out.println("Entrer le numero de telephone :");
        phone = input.nextLine();
        
        System.out.println("Entrer l'adresse :");
        adresse = input.nextLine();
        
//        System.out.println("ID: "+idEt+"\n NOM: "+nomEt+"\n SEXE: "+sexe+"\n FACULTE: "+fact+
//                "\n NIVEAU: "+niveau+"\n EMAIL: "+email+"\n PHONE: "+phone+"\n ADRESSE: "+adresse);
        
        Ad = new Adherant(idEt, nomEt, sexe, fact, niveau, email, phone, adresse);
        
        LAdherant.add(Ad);
//        Ad.printObj();
        
    }
}
