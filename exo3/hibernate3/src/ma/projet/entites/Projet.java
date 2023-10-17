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
import javax.persistence.FetchType;
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
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datefin;
    @OneToMany(mappedBy="projet",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Tache> tache;
    
    @ManyToOne
    private Employe employe;
    public Projet() {
    }

    public Projet(String nom, Date dateDebut, Date datefin, Employe employe) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.datefin = datefin;
        this.employe = employe;
    }

    public Projet(String nom, Date dateDebut, Date datefin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.datefin = datefin;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public List<Tache> getTache() {
        return tache;
    }

    public void setTache(List<Tache> tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return  "nom=" + nom + ", dateDebut=" + dateDebut + ", datefin=" + datefin ;
    }
    
    
    
}
