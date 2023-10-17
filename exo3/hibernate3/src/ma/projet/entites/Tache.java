/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin ;
    private double prix;
    @ManyToOne
    private Projet projet;
    @OneToMany(mappedBy="tache")
    private List<EmployeTache> employetache;

    public Tache() {
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<EmployeTache> getEmployetache() {
        return employetache;
    }

    public void setEmployetache(List<EmployeTache> employetache) {
        this.employetache = employetache;
    }

    public Tache(String nom, Date dateDebut, Date dateFin, double prix) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public Tache(String nom, Date dateDebut, Date dateFin, double prix, Projet projet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.projet = projet;
    }

    public Tache(String nom, Date dateDebut, Date dateFin, Projet projet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.projet = projet;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", prix=" + prix ;
    }
    
    
}
