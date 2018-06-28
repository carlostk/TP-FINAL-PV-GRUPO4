/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.MateriaDAO;
import aplicacion.modelo.dominio.Materia;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc1
 */
public class MateriaDaoImp implements MateriaDAO, Serializable{

    @Override
    public void agregarMateria(Materia materia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(materia) ;
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarMateria(Materia materia) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(materia);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarMateria(Materia materia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(materia);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Materia buscarMateria(String nombre) {
      List<Materia>materias;
        Materia materia;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Materia.class);
        criteria.add(Restrictions.like("nombreCarrera", nombre));
        System.out.println("tamaño"+criteria.list().size());
        materias=(List<Materia>) criteria.list();
        
        materia=materias.get(0);
        
        session.close();
        return materia;
    }

    @Override
    public List<Materia> obtenerTodoMateria() {
        List<Materia>materias;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Materia.class);
        materias=(List<Materia>) criteria.list();
        for(Materia m : materias)
        {
            Hibernate.initialize(m.getCarrera());
        }
        session.close();
        return  materias;
    }
    
}
