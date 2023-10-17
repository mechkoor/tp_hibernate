/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entites.Employe;
import ma.projet.entites.EmployeTache;
import ma.projet.entites.Projet;
import ma.projet.entites.ProjetTache;
import ma.projet.entites.Tache;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Projet o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Projet> findAll(Projet o) {
        List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            tx.commit();
            return projets;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return projets;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Projet findById(int id) {
        Projet projet = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
            return projet;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return projet;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public List<Tache> findTAchesByProjet(int id){
        Projet pr = null;
        Session session = null;
        Transaction tx = null;
        List <Tache> t=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pr = (Projet) session.get(Projet.class, id);
            t=pr.getTache();
            return t;
          
            
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                
            }
            return t ;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
    } 
    
    public void findProjet(int id){
       Projet pr = null;
        Session session = null;
        Transaction tx = null;
        List <Tache> t=null;
        List<EmployeTache> et =null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pr = (Projet) session.get(Projet.class, id);
            t=pr.getTache();
            System.out.println("Projet :"+id+"       Nom:"+pr.getNom()+"    DAte de "
                    + "début :"+pr.getDateDebut());
            System.out.println("Num       Nom        Date Début Réelle          Date Fin Réelle ");
            for(int i=0 ;i<t.size();i++){
                et=t.get(i).getEmployetache();
                if(!et.isEmpty()){
                    System.out.println(et.get(i).getTache().getId()+"      "+et.get(i).getTache().getNom()+"      "+et.get(i).getDateDebutReelle()+"            "
                        + "     "+et.get(i).getDateFinRelle());
              }
                else{
                    System.out.print("Aucun projet affecter");
                }
            }
            
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
                
            }
           
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
    }
  
   public List<ProjetTache> findProjetR(int id) {
    List<ProjetTache> pt = new ArrayList<>();
    Session session = null;
    Transaction tx = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Query query = session.createQuery("select t.id, t.nom, et.dateDebutReelle, et.dateFinRelle from Tache t, EmployeTache et, Projet p where t.id = et.tache and t.projet = p.id and p.id = :id");
        query.setParameter("id", id);

        List<Object[]> results = query.list();
        for (Object[] row : results) {
            Integer taskId = (Integer) row[0];
            String taskName = (String) row[1];
            Date startDate = (Date) row[2];
            Date endDate = (Date) row[3];

            ProjetTache projetTache = new ProjetTache(taskId, taskName, startDate, endDate);
            pt.add(projetTache);
        }

        tx.commit();
        return pt;
    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
        ex.printStackTrace();
        return pt;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}



    
    
    


}
