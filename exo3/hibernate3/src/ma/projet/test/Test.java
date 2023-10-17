/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entites.Employe;
import ma.projet.entites.EmployeTache;
import ma.projet.entites.Projet;
import ma.projet.entites.ProjetTache;
import ma.projet.entites.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;

/**
 *
 * @author hp
 */
public class Test {

    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
         Scanner sc = new Scanner(System.in);

       /* // afficher la liste tâches réalisées par un employé
       
        System.out.println("Enter id de la employe :");
        int id = sc.nextInt();

        es.findTachesByEmploye(id);*/

        // la liste projets gérées par un employé
        /*  System.out.println("Enter id de la employe :");
         int id1 =sc.nextInt();
         Employe e=es.findById(id1);
         List<Projet> p=es.findProjetbyEmploye(id1);
         System.out.println("la liste projets gérées par  Mr."+e.getNom());
         for(int i=0;i<p.size();i++){
         System.out.println(p.get(i));
              
         }*/
         //la liste des tâches planifiées pour projet
       /* System.out.println("Enter id de projet :");
        int idp = sc.nextInt();
        Projet p = ps.findById(idp);
        List<Tache> t = ps.findTAchesByProjet(idp);
        System.out.println("la liste projets gérées par  Le PROJET : " + p.getNom());
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t.get(i));
           
        }*/
         //la liste des tâches réalisées dans un projet
            System.out.println("Enter id de projet :");
            int idp1 = sc.nextInt();
            Projet p1 = ps.findById(idp1);

            List<ProjetTache> resultList = ps.findProjetR(idp1);
            System.out.println("Projet :" + p1.getId() + "   Nom :" + p1.getNom() + "   " + p1.getDateDebut() + "\n"
                    + "List des Taches :"
                    +"\n     Num      Nom         Date Début Réelle   Date Fin Réelle");

            for (ProjetTache result : resultList) {
                System.out.println("     "+result.getId()+"      "+result.getNom()+"         "+result.getDateDebutReelle()+"           "+ result.getDateFinReelle());

            }

    }}
