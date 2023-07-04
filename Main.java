/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioproject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author PC
 */

public class Main {
    static boolean val;
    static Scanner input = new Scanner(System.in);
    
    /**
     *
     * @param args
     */
    
//    Fonction principal
    public static void main(String[] args){
        
        String reponse;
        do{
            System.out.println("""
                               Appuyer sur un des nombres ci-dessous pour: 
                               
                               1- Ajouter un etudiant
                               2- Ajouter un livre
                               3- Ajouter un pret
                               4- afficher les etudiants
                               5- afficher les livres
                               6- afficher les prets
                               7- Supprimer etudiant
                               8- Modifier etudiant
                               9- Supprimer un livre
                               10- Modifier un livre
                               11- Afficher un etudiant
                               12- Afficher un livre
                               13- Suprimer un pret
                               """);
            String choix = input.nextLine();
            switch(choix){
                case "1" -> ajoutEtu();
                case "2" -> ajoutLivre();
                case "3" -> ajoutPret();
                case "4" -> affichageEtudiant();
                case "5" -> affichageLivre();
                case "6" -> affichagePret();
                case "7" -> {
                    System.out.println("Entrer l'id de l'etudiant a supprimer :");
                    int id = input.nextInt();
                    input.nextLine();
                    delEtudiant(id);
                }
                case "8" -> {
                    System.out.println("Entrer l'id de l'etudiant a modifier :\n");
                    modifierEt(input.nextInt());
                }
                case "9" -> {
                    System.out.println("Entrer le numero du livre a supprimer :");
                    int num = input.nextInt();
                    input.nextLine();
                    supprimerLivre(num);
                }
                case "10" -> {
                    System.out.println("Entrer le numero du livre a modifier : ");
                    modifierL(input.nextInt());
                }
                case "11" -> {
                    try{
                        afficherUnEtudiant();
                    }catch(Exception e){
                        System.out.println("L'id est invalide");
                    }
                }
                case "12" -> afficherUnLivre();
                case "13" -> {
                    System.out.println("Entrer le numero du pret a supprimer : ");
                    int numPret = input.nextInt();
                    input.nextLine();
                    supprimerP(numPret);
                }
                default -> System.out.println("Vous n'avez pas fait un choix valide!");
            }
            
            System.out.println("""
                               
                               Appuyer sur <<Y>> pour continuer le programme et
                               retourner au menu principal.
                               ou
                               Appuyer sur n'importe quelle autre touche
                               sauf(power) pour quitter le programme.
                               """);
            
            reponse = input.nextLine();
        }while("Y".equals(reponse.toUpperCase()));
        
    }
    
//    variable passer en parametre a l'objet etudiant
    static int idEt;
    static String nomEt,sexe,fact,niveau,email,phone,adresse;
//    instanciation de l'objet etudiant et de sa liste
    static Adherant Ad;
    static ArrayList<Adherant> LAdherant = new ArrayList<>();
    
    public static void ajoutEtu(){
        System.out.println("--AJOUTER UN ADHERANT--\n");
        System.out.println("Entrer l'identifiant de l'etudiant");
        idEt = input.nextInt();
        if(!LAdherant.isEmpty()){
            while(verifE(idEt)){
                System.out.println("""
                                                   Cet(te) etudiant(e) est deja enregistrer.
                                                   Entrer un autre identifiant svp""");
                idEt = input.nextInt();
            }
        }
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
        
        
        Ad = new Adherant(idEt, nomEt, sexe, fact, niveau, email, phone, adresse);
//        ajout d'un objet etudiant dans la liste
        LAdherant.add(Ad);
//        Ad.printObj();
        
    }
    
    //    Fonction affichage liste etudiant
    public static void affichagePret(){
        System.out.println("\nAffichage pret\n");
        for(PretLivre pl : pretL){
            pl.printObjP();
            System.out.println("\n-----------------\n");
        } 
    }
  
 //    fonction permettant de verifier l'unicite d'un etudiant
    public static boolean verifE(int num){
//        boucle parcourant la liste des etudiants
        for(Adherant a : LAdherant){
            if(a.getIdEtu() == num){
//                val prend la valeur true
                val = a.getIdEtu() == num;
//                si on trouve un etudiant on arrete la boucle
                break;
            }
            else{
                val = false;
            }
        }
//        la valeur retourner est soit vrai soit faux
        return val;
    }
    
    
    
//    instanciation et creation de l'objet liste de livre
    static Livre livre;
    static ArrayList<Livre> livreL = new ArrayList<>();
//    variable passer en parametre a l'objet livre
    static int numLivre;
    static String titre, auteur, annee;
    
    
//    fonction permettant d'ajouter un livre
    public static void ajoutLivre(){
        System.out.println("--AJOUTER UN LIVRE--\n");
        System.out.println("Entrer le numero du livre");
        numLivre = input.nextInt();
        if(!LAdherant.isEmpty()){
            while(verifL(numLivre)){
                System.out.println("""
                                                   Ce livre est deja enregistrer !
                                                   Veuillez entrer un autre numero !""");
                numLivre = input.nextInt();
            }
        }
        input.nextLine();
        
        System.out.println("Entrer le titre du livre :");
        titre = input.nextLine();
        
        System.out.println("Entrer le nom de l'auteur :");
        auteur = input.nextLine();
        
        System.out.println("Entrer l'annee du livre :");
        annee = input.nextLine();
        
//        instanciation de l'objet livre
        livre = new Livre(numLivre, titre, auteur, annee);
//        ajout du livre dans la liste
        livreL.add(livre);
    }
    
    
//    fonction permettant de verifier l'unicite d'un livre
    
    public static boolean verifL(int num){
//        boucle parcourant la liste des livres
        for(Livre l : livreL){
            if(l.getNumLivre() == num){
//                val prend la valeur vraie
                val = l.getNumLivre() == num;
//                si on trouve un livre on arrete la boucle
                break;
            }
            else{
                val = false;
            }
        }
//        la valeur retourner est soit vrai soit faux
        return val;
    }
    
        //    Fonction affichage liste livre
    public static void affichageLivre(){
        System.out.println("\nAffichage livre\n");
        for(Livre lv : livreL){
            lv.printObjL();
            System.out.println("\n-----------------\n");
        }
    }
    
    
    
//    instanciation de l'objet pret et de sa liste
    static PretLivre pLivre;
    static ArrayList<PretLivre> pretL = new ArrayList<>();
//    declaration des variables globale passe en parametre a l'objet pret
    static int idPret, idEtu, numL;
    static String datePret, dateLimit;
    
    
//    fonction permettant de faire des pret
    public static void ajoutPret(){
        System.out.println("--AJOUTER UN PRET--\n");
        System.out.println("Entrer le numero de pret");
        idPret = input.nextInt();
//        verification de l'unicite du pret
        if(!pretL.isEmpty()){
            while(verifP(idPret)){
                System.out.println("""
                                                   Ce livre est deja preter !
                                                   Veuillez entrer un autre numero !""");
                idPret = input.nextInt();
            }
        }
        input.nextLine();
        
        System.out.println("Entrer le numero de l'etudiant :");
        idEtu = input.nextInt();
        
        while(!verifE(idEtu)){
            System.out.println("""
                               cet etudiant n'existe pas.
                               Entrer un autre identifiant :""");
            idEtu = input.nextInt();
        }
        
        do{
            System.out.println("Entrer le numero du livre :");
            numL = input.nextInt();
            if(!verifL(numL)){
                System.out.println("""
                                   ce livre n'existe pas.
                                   Entrer un autre numero :""");
            }
        }while(!verifL(numL));
        input.nextLine();
        
        System.out.println("Entrer la date du pret :");
        datePret = input.nextLine();
        
        System.out.println("Entrer la date limite du pret :");
        dateLimit = input.nextLine();
        
//        instanciatipn
        pLivre = new PretLivre(idPret, idEtu, numL, datePret, dateLimit);
//        ajout de l'objet dans la liste
        pretL.add(pLivre);
    }
    
    
//    fonction permettant de verifier l'unicite d'un pret
    public static boolean verifP(int num){
//        boucle parcourant la liste des pret
        for(PretLivre p : pretL){
            if(p.getIdP() == num){
//                val prend la valeur true
                val = p.getIdP() == num;
//                si on trouve un pret on arrete la boucle
                break;
            }
            else{
                val = false;
            }
        }
//        la valeur retourner est soit vrai soit faux
        return val;
    }
    
        //    Fonction affichage liste etudiant
    public static void affichageEtudiant(){
        System.out.println("\nAffichage etudiant\n");
        for( Adherant Adr : LAdherant){
            Adr.printObj();
            System.out.println("\n-----------------\n");
        }
    }
    
//    fonction supprimer etudiant
    public static void delEtudiant(int id){
        Iterator<Adherant> it = LAdherant.iterator();
        Adherant i;
//        on verifie l'exitence de l'etudiant dans la liste avec la fonction
        if(verifE(id)){
            while(it.hasNext()){
                i = it.next();
                if(i.getIdEtu() == id){
                    it.remove();
                }
            }
        }
        else{
            System.out.println("Cet etudiant n'est pas encore enregistrer.");
        }
    }
    
//    Fonction modifier etudiant
    public static void modifierEt(int id){
        if(verifE(id)){
            System.out.println("Entrer les nouvelles informations de l'etudiant.");
            for(Adherant mEt : LAdherant){
                if(mEt.getIdEtu() == id){
                    System.out.println("Entrer l'identifiant :");
                    mEt.setIdEtu(input.nextInt());
                    input.nextLine();
                    
                    System.out.println("Entrer le nom et prenom :");
                    mEt.setNomEtu(input.nextLine());
                    
                    System.out.println("Entrer le sexe :");
                    mEt.setSexe(input.nextLine());
                    
                    System.out.println("Entrer faculte :");
                    mEt.setFaculte(input.nextLine());
                    
                    System.out.println("entrer le niveau :");
                    mEt.setNiveau(input.nextLine());
                    
                    System.out.println("Entrer l'email :");
                    mEt.setMail(input.nextLine());
                    
                    System.out.println("Entrer le numero telephone :");
                    mEt.setPhone(input.nextLine());
                    
                    System.out.println("Entrer l'adresse :");
                    mEt.setAdresse(input.nextLine());
                }
            }
        }
        else{
            System.out.println("Cet etudiant n'est pas encore enregistrer.");
        }
    }
    
    //fonction suppression de livre
    static void supprimerLivre(int num){
        Iterator<Livre> it = livreL.iterator();
        Livre i;
//        on verifie l'exitence de l'etudiant dans la liste avec la fonction
        if(verifE(num)){
            while(it.hasNext()){
                i = it.next();
                if(i.getNumLivre() == num){
                    it.remove();
                }
            }
        }
        else{
            System.out.println("Ce livre n'est pas encore enregistrer.");
        }
    }
    
    //fonction modifier livre
    public static void modifierL(int num){
        if(verifE(num)){
            System.out.println("Entrer les nouvelles informations du livre.");
            for(Livre lv : livreL){
                if(lv.getNumLivre() == num){
                    System.out.println("Entrer le numero du livre :");
                    lv.setNum(input.nextInt());
                    input.nextLine();
                    
                    System.out.println("Entrer le titre :");
                    lv.setTitre(input.nextLine());
                    
                    System.out.println("Entrer l'auteur :");
                    lv.setAuteur(input.nextLine());
                    
                    System.out.println("Entrer l'annee :");
                    lv.setAnnee(input.nextLine());
                }
            }
        }
        else{
            System.out.println("Cet etudiant n'est pas encore enregistrer.");
        }
    }
    
    //fonction permettant de supprimer un pret
    public static void supprimerP(int idP){
        Iterator<PretLivre> it = pretL.iterator();
        PretLivre i;
//        on verifie l'exitence de l'etudiant dans la liste avec la fonction
        if(verifE(idP)){
            while(it.hasNext()){
                i = it.next();
                if(i.getIdP() == idP){
                    it.remove();
                }
            }
        }
        else{
            System.out.println("Ce livre n'est pas encore enregistrer.");
        }

    }
    
//    fonction permettant d'afficher un etudiant
    public static void afficherUnEtudiant(){
        System.out.println("\nEntrer l'id de l'etudiant a afficher :\n");
        int id = input.nextInt();
        input.nextLine();
        if(verifE(id)){
            System.out.println("\nEtudiant\n");
            for( Adherant Adr : LAdherant){
                if(Adr.getIdEtu() == id){
                    Adr.printObj();
                }
            }
        }
        
    }
    
//    fonction pour afficher un livre
    static void afficherUnLivre(){
        System.out.println("Entrer le numero du livre a afficher :");
        int num = input.nextInt();
        input.nextLine();
        Iterator<Livre> it = livreL.iterator();
        Livre i;
//        on verifie l'exitence de l'etudiant dans la liste avec la fonction
        if(verifE(num)){
            while(it.hasNext()){
                i = it.next();
                if(i.getNumLivre() == num){
                    i.printObjL();
                }
            }
        }
        else{
            System.out.println("Ce livre n'est pas encore enregistrer.");
        }
    }
    
}
