/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entites;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author hp
 */
@Embeddable
public class EmployeTacheKey implements Serializable {
    private int employe_id;
    private int tache_id;
    
    
}
