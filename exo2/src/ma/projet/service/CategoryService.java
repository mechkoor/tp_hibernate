/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Category;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ayoub mechkour
 */
public class CategoryService implements IDao<Category> {
    
    @Override
    public boolean create(Category o) {
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
    public List<Category> findAll(Category o) {
        List<Category> categorys = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorys = session.createQuery("from Category").list();
            tx.commit();
            return categorys;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return categorys;
        } finally {
            if(session != null)
                session.close();
        }
    }

    
    @Override
    public Category findById(int id) {
        Category category = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            category = (Category) session.get(Category.class, id);
            tx.commit();
            return category;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return category;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    
}

    
