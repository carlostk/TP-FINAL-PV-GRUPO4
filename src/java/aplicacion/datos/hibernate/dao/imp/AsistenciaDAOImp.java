/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.AsistenciaDAO;
import aplicacion.modelo.dominio.Asistencias;
import aplicacion.modelo.dominio.DocenteMateria;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * 
 */
public class AsistenciaDAOImp implements AsistenciaDAO,Serializable {

    @Override
    public void agregar(Asistencias asistencia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(asistencia);
        session.getTransaction().commit();
        session.close();
    }
   
    @Override
    public Asistencias validarAsistencia(Asistencias asistencia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Asistencias.class);
        criteria.add(Restrictions.eq("asiEstado", true));
        criteria.createAlias("inscripcionesAlumnos", "us");
        criteria.add(Restrictions.like("us.codigo", asistencia.getInscripcionesAlumnos().getCodigo()));
        criteria.add(Restrictions.eq("asiFecha", asistencia.getAsiFecha()));
        Asistencias objasistencia = null;
        if (!criteria.list().isEmpty()) {
            objasistencia = (Asistencias) criteria.list().get(0);
        }
        session.close();
        return objasistencia;
    }
    @Override
    public void modificar(Asistencias asistencia) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(asistencia);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Asistencias> obtenerAsistencia() {
        List<Asistencias>asistencias;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Asistencias.class);
        criteria.add(Restrictions.eq("asiEstado", true));
        criteria.addOrder(Order.asc("asiFecha"));
        asistencias = criteria.list();
        for (Asistencias a : asistencias) {
            Hibernate.initialize(a.getInscripcionesAlumnos());
            Hibernate.initialize(a.getInscripcionesAlumnos().getDocenteMateria());
            Hibernate.initialize(a.getInscripcionesAlumnos().getDocenteMateria().getMateria());
            Hibernate.initialize(a.getInscripcionesAlumnos().getAlumno());
        }
        session.close();
        return asistencias;
    }

}
