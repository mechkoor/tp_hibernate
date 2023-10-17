/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author ayoub mechkour
 */
@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private LigneCommandeProduitId lcp=new LigneCommandeProduitId();
    
    @ManyToOne
    @MapsId("commandeId")
    private Commande commande;
    @ManyToOne
    @MapsId("produitId")
    private Produit produit;
    
    private int qunatite;

    public LigneCommandeProduit() {
    }
    

    public LigneCommandeProduit(Commande commande, Produit produit, int qunatite) {
        this.commande = commande;
        this.produit = produit;
        this.qunatite = qunatite;
    }
    
    
    
    
    

    public LigneCommandeProduitId getLcp() {
        return lcp;
    }

    public void setLcp(LigneCommandeProduitId lcp) {
        this.lcp = lcp;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit Produit) {
        this.produit = Produit;
    }

    public int getQunatite() {
        return qunatite;
    }

    public void setQunatite(int qunatite) {
        this.qunatite = qunatite;
    }
    
    
}
