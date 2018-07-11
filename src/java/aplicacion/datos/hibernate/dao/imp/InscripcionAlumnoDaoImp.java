/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.InscripcionAlumnoDAO;
import aplicacion.modelo.dominio.InscripcionAlumno;
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
public class InscripcionAlumnoDaoImp implements InscripcionAlumnoDAO, Serializable {

    @Override
    public void agregarInscripcion(InscripcionAlumno inscripcion) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(inscripcion) ;
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarInscripcion(InscripcionAlumno inscripcion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(inscripcion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarInscripcion(InscripcionAlumno inscripcion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(inscripcion);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public InscripcionAlumno buscarInscripcion(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InscripcionAlumno> obtenerTodoInscripcion() {
       List<InscripcionAlumno>inscripciones;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(InscripcionAlumno.class);
        criteria.add(Restrictions.like("estado", true));
        inscripciones=(List<InscripcionAlumno>) criteria.list();
        for (InscripcionAlumno dm : inscripciones) {
            Hibernate.initialize(dm.getDocenteMateria());
            Hibernate.initialize(dm.getAlumno());
        }
        session.close();
        return  inscripciones;
    }

    @Override
    public List<InscripcionAlumno> obtenerInscripcionesNombre(String legajo) {
         List<InscripcionAlumno>inscripciones;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(InscripcionAlumno.class);
        criteria.createAlias("docenteMateria.docente", "us");
        criteria.add(Restrictions.like("us.legajo", legajo));
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPERR"+criteria.list().isEmpty());
        inscripciones=(List<InscripcionAlumno>) criteria.list();
        for (InscripcionAlumno dm : inscripciones) {
            Hibernate.initialize(dm.getDocenteMateria());
            Hibernate.initialize(dm.getAlumno());
        }
        session.close();
        return  inscripciones;
    }
    
}
