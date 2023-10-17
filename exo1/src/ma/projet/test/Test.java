/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author ayoub mechkour
 */
public class Test {

    private static int i = 1;

    private static Date parseDate(String dateStr, SimpleDateFormat sdf) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ProduitService pr1 = new ProduitService();

        //5 produit
        /*pr1.create(new Produit("samsung","aa1",parseDate("1/09/2023", sdf),145.d,"A51"));
         pr1.create(new Produit("iphone","bb2",parseDate("15/09/2023", sdf),90.d,"11 PRO MAX"));
         pr1.create(new Produit("xiomi","cc3",parseDate("25/09/2023", sdf),190.d,"REDMI S9"));
         pr1.create(new Produit("inflix","dd4",parseDate("30/09/2023", sdf),75.d,"NOTE 10"));
         pr1.create(new Produit("huwai","ee5",parseDate("19/09/2023", sdf),100.d," Y9"));*/
        //affichage de la liste
        for(Produit p:pr1.findAll(null)){
         System.out.println("le produit numéro "+ i++ +" est :\n");
         System.out.println("name : "+p.getMarque());
         System.out.println("\n reference : "+p.getRefernce());
         System.out.println("\n date d'achat : "+p.getDateAchat());
         System.out.println("\n prix : "+p.getPrix());
         System.out.println("\n designation : "+p.getDesignation());
         System.out.println("********************************\n");  
         }
        //supprission de produit 3
        /*pr1.delete(pr1.findById(3));*/
        //modification de produit 1
        /*Produit p2=pr1.findById(1);
         p2.setMarque("nokia");
         p2.setPrix(180.d);
        
         pr1.update(p2);*/
        //affichage des produits plus de 100dh
        /*for(Produit p:pr1.findAll(null)){
         if(p.getPrix()>=100.d){
         System.out.println("le produit numéro "+ i++ +" est :\n");
         System.out.println("name : "+p.getMarque());
         System.out.println("\n reference : "+p.getRefernce());
         System.out.println("\n date d'achat : "+p.getDateAchat());
         System.out.println("\n prix : "+p.getPrix());
         System.out.println("\n designation : "+p.getDesignation());
         System.out.println("********************************\n");
         }
         }*/
        
        //la date
        
        /*Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la date de début (dd/MM/yyyy) : ");
        Date dateDebut = parseDate(scanner.nextLine(), sdf);

        System.out.print("Entrez la date de fin (dd/MM/yyyy) : ");
        Date dateFin = parseDate(scanner.nextLine(), sdf);

        for (Produit p : pr1.findAll(null)) {
            if (p.getDateAchat().compareTo(dateDebut) >= 0 && p.getDateAchat().compareTo(dateFin) <= 0) {
                System.out.println("le produit numéro " + i++ + " est :\n");
                System.out.println("name : " + p.getMarque());
                System.out.println("\n reference : " + p.getRefernce());
                System.out.println("\n date d'achat : " + p.getDateAchat());
                System.out.println("\n prix : " + p.getPrix());
                System.out.println("\n designation : " + p.getDesignation());
                System.out.println("********************************\n");
            }
        }*/

    }
}
