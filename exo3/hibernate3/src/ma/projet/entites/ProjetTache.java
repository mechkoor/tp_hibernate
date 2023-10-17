/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import java.util.Date;

/**
 *
 * @author hp
 */
public class ProjetTache {
    private Integer id;
    private String nom;
    private Date dateDebutReelle;
    private Date dateFinReelle;

    public ProjetTache() {
    }

    public ProjetTache(Integer id, String nom, Date dateDebutReelle, Date dateFinReelle) {
        this.id = id;
        this.nom = nom;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    @Override
    public String toString() {
        return "ProjetTache{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateDebutReelle=" + dateDebutReelle +
                ", dateFinReelle=" + dateFinReelle +
                '}';
    }
}