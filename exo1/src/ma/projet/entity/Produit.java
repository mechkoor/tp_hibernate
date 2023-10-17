/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;


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
@Entity()
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String reference;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    private String designation;

    
    public Produit(){
        
    }
    
    public Produit(String m,String r,Date d,Double p,String de){
        this.marque=m;
        this.reference=r;
        this.dateAchat=d;
        this.prix=p;
        this.designation=de;
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
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the refernce
     */
    public String getRefernce() {
        return reference;
    }

    /**
     * @param refernce the refernce to set
     */
    public void setRefernce(String refernce) {
        this.reference = refernce;
    }

    /**
     * @return the dateAchat
     */
    public Date getDateAchat() {
        return dateAchat;
    }

    /**
     * @param dateAchat the dateAchat to set
     */
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    
    
    
    
}
