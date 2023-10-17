/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author ayoub mechkour
 */
@Entity
@NamedQuery(name="prix.findAll",query="select p from Produit p where p.prix> :montant")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private float prix;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
     @OneToMany(mappedBy = "produit")
     private List<LigneCommandeProduit> commandeProduits;

    public Produit() {

    }

    public Produit(String reference, float prix,Category c) {
        this.reference = reference;
        this.prix = prix;
        this.category=c;
    }
    
    
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the commandeProduits
     */
    public List<LigneCommandeProduit> getCommandeProduits() {
        return commandeProduits;
    }

    /**
     * @param commandeProduits the commandeProduits to set
     */
    public void setCommandeProduits(List<LigneCommandeProduit> commandeProduits) {
        this.commandeProduits = commandeProduits;
    }

}
