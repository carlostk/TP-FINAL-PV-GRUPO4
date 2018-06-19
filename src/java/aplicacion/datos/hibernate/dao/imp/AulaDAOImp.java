/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.AulaDAO;
import aplicacion.modelo.dominio.Aula;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Oscar
 */
public class AulaDAOImp implements Serializable, AulaDAO{

    @Override
    public void agregarAula(Aula aula) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(aula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarAula(Aula aula) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(aula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarAula(Aula aula) {
        aula.setAulEstado(false);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(aula);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Aula> obtenerTodoAula() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Aula.class);
        //criteria.addOrder(Order.asc(nombre)) ;
        //List aulas =
        return null;
    }

    @Override
    public Aula buscarAula(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Aula.class) ;
        criteria.add(Restrictions.like("nombre", nombre)) ;
        Aula aula = null ;
        if(!criteria.list().isEmpty()){
            aula = (Aula)criteria.list().get(0) ;
        }
        session.getTransaction().commit();
        session.close();
        return aula ;
    }
    
}
