/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import ma.projet.classes.Category;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ayoub mechkour
 */
public class ProduitService implements IDao<Produit> {

    private Date parseDate(String dateStr, SimpleDateFormat sdf) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Produit> findAll(Produit o) {
        List<Produit> categorys = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorys = session.createQuery("from Produit").list();
            tx.commit();
            return categorys;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return categorys;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    
     
    public List<Produit> findAllPrix() {
        List<Produit> categorys = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorys = session.getNamedQuery("prix.findAll").setParameter("montant", 100.f).list();
            tx.commit();
            return categorys;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return categorys;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
            return produit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    
     public void produitsParCategory(CategoryService c) {
        List<Category> list = c.findAll(null);
        for (Category ca : list) {
            System.out.println("les produits de la categorie " + ca.getLibelle() + " sont :\n");
            for (Produit p : ca.getProduits()) {
                System.out.println(p.getReference() + "\n");
            }

        }

    }
     
     
     public void produitParCategory(Category c) {
        System.out.println("les produits de la categorie " + c.getLibelle() + " sont :\n");
        for (Produit p : c.getProduits()) {
            System.out.println(p.getReference() + "\n");
        }

    }
     
     
     
     public void produitsEntre2Date(CommandeService c) {
        HashSet<Produit> arry = new HashSet<Produit>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Entrez la date de début (dd/MM/yyyy) : ");
        Date dateDebut = parseDate(scanner.nextLine(), sdf);

        System.out.print("Entrez la date de fin (dd/MM/yyyy) : ");
        Date dateFin = parseDate(scanner.nextLine(), sdf);

        List<Commande> l = c.findAll(null);
       
        for (Commande co : l) {
            
            if (co.getDate().compareTo(dateDebut) >= 0 && co.getDate().compareTo(dateFin) <= 0) {
                for (LigneCommandeProduit pro : co.getCommandeProduits()) {
                   
                    arry.add(pro.getProduit());

                }
            }
        }

        System.out.println("les produits commandées entre " + dateDebut + " et " + dateFin + " sont : \n");
        for (Produit prod : arry) {
            System.out.println(prod.getReference() + "\n");

        }

    }
     
     public void produitDuneComande(Commande c){
        List<LigneCommandeProduit> l=new ArrayList<LigneCommandeProduit>();
        l=c.getCommandeProduits();
        System.out.println("commande : "+c.getId()+"                                "+c.getDate()+"\n");
        System.out.println("Réference"+"                             "+"prix"+"                     "+"Quantite\n");
        for(LigneCommandeProduit lcp:l){
        System.out.println(lcp.getProduit().getReference()+"                               "+lcp.getProduit().getPrix()+"                      "+lcp.getQunatite()+"\n");
        }
    }
     
     public void produitSupDe100(){
        List<Produit> l=this.findAll(null);
        System.out.println("les produits dont le prix est superieur à 100 dh sont :");
        for(Produit p:l){
            if(p.getPrix()>100){
                System.out.println(p.getReference()+"\n");
            }
        }
        
      
    }
    

    

    
}
