/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.DocenteMateriaDAO;

import aplicacion.modelo.dominio.DocenteMateria;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author pc1
 */
public class DocenteMateriaDAOImp implements DocenteMateriaDAO, Serializable{

    @Override
    public void agregarDocenteMateria(DocenteMateria docentemateria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(docentemateria) ;
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarDocenteMateria(DocenteMateria docentemateria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(docentemateria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarDocenteMateria(DocenteMateria docentemateria) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(docentemateria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public DocenteMateria buscarDocenteMateria(String nombre) {
       throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
   public List<DocenteMateria> obtenerTodoDocenteMateria() {
         List<DocenteMateria>docenteMaterias;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DocenteMateria.class);
        docenteMaterias=(List<DocenteMateria>) criteria.list();
        for (DocenteMateria dm : docenteMaterias) {
            Hibernate.initialize(dm.getDocente());
            Hibernate.initialize(dm.getMateria());
            Hibernate.initialize(dm.getMateria().getCarrera());
        }
        session.close();
        return  docenteMaterias;
    }

   
    
}
