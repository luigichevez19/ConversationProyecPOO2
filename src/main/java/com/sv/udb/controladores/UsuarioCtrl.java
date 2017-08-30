/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Luis
 */
public class UsuarioCtrl {
     public boolean guar(Usuario obje)
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
    

    
    public Usuario cons(Integer codiTipo)
    {
        Usuario resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(Usuario.class, codiTipo);
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
    
    public List<Usuario> cons()
    {
        List<Usuario> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProPu");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Tipos.findAll", Usuario.class).getResultList();
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
    
    
    public boolean edit(Usuario obje)
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
    
    public boolean dele(Usuario obje)
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
