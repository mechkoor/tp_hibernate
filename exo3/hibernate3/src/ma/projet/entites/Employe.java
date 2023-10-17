/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hp
 */
@Entity
public class Employe {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nom;
    private String prenom;
    private String telephone;
    @OneToMany(mappedBy="employe",fetch = FetchType.EAGER)
    private List<Projet> projet;
    
    @OneToMany(mappedBy="employe")
    private List<EmployeTache> employetache;

    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }
    

    public Employe() {
    }

    public List<EmployeTache> getEmployetache() {
        return employetache;
    }

    public void setEmployetache(List<EmployeTache> employetache) {
        this.employetache = employetache;
    }

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + '}';
    }
    
    
}
