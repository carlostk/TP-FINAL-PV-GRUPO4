/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.AulasMateriasDAO;
import aplicacion.modelo.dominio.AulasMaterias;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pc-Yo
 */

public class AulasMateriasDAOImp implements Serializable, AulasMateriasDAO{

    @Override
    public void agregarAulasMaterias(AulasMaterias aulasMaterias) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(aulasMaterias);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarAulasMaterias(AulasMaterias aulasMaterias) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(aulasMaterias);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarAulasMaterias(AulasMaterias aulasMaterias) {
                Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(aulasMaterias);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<AulasMaterias> obtenerTodoAulasMaterias() {
         List<AulasMaterias> aulasMaterias;
        List<AulasMaterias> aux= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AulasMaterias.class);
        aulasMaterias =(List<AulasMaterias>) criteria.list();
        
        session.close();
                                                                                                                                                            
        return  aulasMaterias;
    }

    @Override
    public AulasMaterias buscarAulasMaterias(String nombre) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(AulasMaterias.class) ;
        criteria.add(Restrictions.like("nombre", nombre)) ;
        AulasMaterias aulasMaterias = null ;
        if(!criteria.list().isEmpty()){
            aulasMaterias = (AulasMaterias)criteria.list().get(0) ;
        }
        session.getTransaction().commit();
        session.close();
        return aulasMaterias ;
    }

    
    
}
