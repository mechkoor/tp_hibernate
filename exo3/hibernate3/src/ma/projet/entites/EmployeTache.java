/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author hp
 */
@Entity
@Table(name="EmployeTache")
public class EmployeTache {
    @EmbeddedId
    private EmployeTacheKey id =new EmployeTacheKey();
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutReelle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinRelle ;
    @ManyToOne
    @MapsId("employe_id")
    private Employe employe;
    @ManyToOne
    @MapsId("tache_id")
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinRelle, Employe employe, Tache tache) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinRelle = dateFinRelle;
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTacheKey getId() {
        return id;
    }

    public void setId(EmployeTacheKey id) {
        this.id = id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinRelle() {
        return dateFinRelle;
    }

    public void setDateFinRelle(Date dateFinRelle) {
        this.dateFinRelle = dateFinRelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "id=" + id + ", dateDebutReelle=" + dateDebutReelle + ", dateFinRelle=" + dateFinRelle + ", employe=" + employe + ", tache=" + tache + '}';
    }

   
   
    
}
