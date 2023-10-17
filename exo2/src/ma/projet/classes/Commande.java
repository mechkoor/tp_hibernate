/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author ayoub mechkour
 */
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Temporal(javax.persistence.TemporalType.DATE)
     private Date date;
     @OneToMany(mappedBy = "commande",fetch = FetchType.EAGER)
     private List<LigneCommandeProduit> commandeProduits;
     
     
     public Commande(){
         
     }
     
     public Commande(Date d){
         this.date=d;
         
         
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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
