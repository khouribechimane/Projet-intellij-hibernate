//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package services;
import dao.IDao;
import entities.Salle;

import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
public class SalleService implements IDao<Salle> {
    public SalleService() {
    }
    public boolean create(Salle o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
        } catch (HibernateException var9) {
            HibernateException e = var9;
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }
    public boolean delete(Salle o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException var9) {
            HibernateException e = var9;
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return etat;
    }

    public boolean update(Salle o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
        } catch (HibernateException var9) {
            HibernateException e = var9;
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return etat;
    }

    public Salle findById(int id) {
        Session session = null;
        Transaction tx = null;
        Salle salle = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle = (Salle)session.get(Salle.class, id);
            tx.commit();
        } catch (HibernateException var9) {
            HibernateException e = var9;
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return salle;
    }

    @Override
    public List<Salle> findALL() {
        return Collections.emptyList();
    }

    public List<Salle> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Salle> salles = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles = session.createQuery("from Salle", Salle.class).list();
            tx.commit();
        } catch (HibernateException var8) {
            HibernateException e = var8;
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return salles;
    }
}
