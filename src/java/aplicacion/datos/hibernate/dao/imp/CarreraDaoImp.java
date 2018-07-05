/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.CarreraDAO;
import aplicacion.modelo.dominio.Carrera;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc1
 */
public class CarreraDaoImp implements CarreraDAO, Serializable {

    @Override
    public void agregarCarrera(Carrera carrera) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(carrera) ;
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarCarrera(Carrera carrera) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(carrera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarCarrera(Carrera carrera) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(carrera);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Carrera buscarCarrera(String nombre) {
        List<Carrera>carreras;
        Carrera carrera;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Carrera.class);
        criteria.add(Restrictions.like("nombreCarrera", nombre));
        System.out.println("tamaño"+criteria.list().size());
        if(!criteria.list().isEmpty())
        {
          carreras=(List<Carrera>) criteria.list();
          carrera=carreras.get(0);
        }else{
              carrera=null;
             }
        
       
        session.close();
        return carrera;
    }

    @Override
    public List<Carrera> obtenerTodoCarreras() {
        List<Carrera>carreras;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Carrera.class);
        carreras=(List<Carrera>) criteria.list();
        session.close();
        return  carreras;
    }
    
}
