/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Category;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategoryService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeProduitService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ayoub mechkour
 */
public class Test {
    private static Date parseDate(String dateStr, SimpleDateFormat sdf) {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ProduitService p=new ProduitService();
        CategoryService cs=new CategoryService();
        CommandeService co=new CommandeService();
        LigneCommandeProduitService lcp=new LigneCommandeProduitService();
        
        //creer 4 category
        /*cs.create(new Category("aa1","iphone"));
        cs.create(new Category("bb2","samsung"));
        cs.create(new Category("cc3","xiomi"));
        cs.create(new Category("dd4","hwaiwi"));*/
        
        
        
        //creer 10 produit
        /*p.create(new Produit("iphone4",150.f,cs.findById(1)));
        p.create(new Produit("iphone10",110.f,cs.findById(1)));
        p.create(new Produit("iphone15",50.f,cs.findById(1)));
        p.create(new Produit("note5",15.f,cs.findById(2)));
        p.create(new Produit("s22",10.f,cs.findById(2)));
        p.create(new Produit("j30",190.f,cs.findById(2)));
        p.create(new Produit("redmi5",160.f,cs.findById(3)));
        p.create(new Produit("redmi note10",100.f,cs.findById(3)));
        p.create(new Produit("redmi+",120.f,cs.findById(3)));
        p.create(new Produit("y9",90.f,cs.findById(4)));
        p.create(new Produit("y10 pro",80.f,cs.findById(4)));
        p.create(new Produit("y2+",130.f,cs.findById(4)));*/
        
        
        
        //creer 3 commande
        /*co.create(new Commande(parseDate("1/09/2023", sdf)));
        co.create(new Commande(parseDate("12/09/2023", sdf)));
        co.create(new Commande(parseDate("17/09/2023", sdf)));
        co.create(new Commande(parseDate("21/09/2023", sdf)));
        co.create(new Commande(parseDate("25/09/2023", sdf)));
        co.create(new Commande(parseDate("30/09/2023", sdf)));*/
        
        
        
        //p.produitsParCategory(cs);
        
        //p.produitParCategory(cs.findById(2));
        
        
        
        //ligne commande produit
        /*lcp.create(new LigneCommandeProduit(co.findById(1),p.findById(1),40));
        lcp.create(new LigneCommandeProduit(co.findById(1),p.findById(2),25));
        
        lcp.create(new LigneCommandeProduit(co.findById(2),p.findById(3),20));
        lcp.create(new LigneCommandeProduit(co.findById(2),p.findById(4),15));
        
        lcp.create(new LigneCommandeProduit(co.findById(3),p.findById(5),5));
        lcp.create(new LigneCommandeProduit(co.findById(3),p.findById(6),12));
        
        lcp.create(new LigneCommandeProduit(co.findById(4),p.findById(7),7));
        lcp.create(new LigneCommandeProduit(co.findById(4),p.findById(8),14));
        
        lcp.create(new LigneCommandeProduit(co.findById(5),p.findById(9),78));
        lcp.create(new LigneCommandeProduit(co.findById(5),p.findById(10),14));
        
        lcp.create(new LigneCommandeProduit(co.findById(6),p.findById(11),18));
        lcp.create(new LigneCommandeProduit(co.findById(6),p.findById(12),2));*/
        
        
        //p.produitsEntre2Date(co);
        
        
       p.produitDuneComande(co.findById(1));
        
        
        
       /* p.produitSupDe100();
        
        for(Produit pe:p.findAllPrix()){
           System.out.println(pe.getReference());
            
        }*/
        
        
        
        
    }
    
}
 