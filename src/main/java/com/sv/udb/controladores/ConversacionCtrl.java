/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Conversacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Luis
 */
public class ConversacionCtrl {
    public boolean guar(Conversacion obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    

    
    public Conversacion cons(Integer codiTipo)
    {
        Conversacion resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(Conversacion.class, codiTipo);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Conversacion> cons()
    {
        List<Conversacion> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Tipos.findAll", Conversacion.class).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    
    public boolean edit(Conversacion obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.merge(obje);
            //em.flush();
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public boolean dele(Conversacion obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.remove(em.merge(obje));
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
}
