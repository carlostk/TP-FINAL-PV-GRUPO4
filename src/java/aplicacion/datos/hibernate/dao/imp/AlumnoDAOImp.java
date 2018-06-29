/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.AlumnoDAO;
import aplicacion.modelo.dominio.Alumno;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc1
 */
public class AlumnoDAOImp implements AlumnoDAO ,Serializable{

    @Override
    public Alumno buscarAlumno(String nombreUsuario) {
        System.out.println("Entra al metodo de busqueda"); //
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.createAlias("perfil.usuario", "per_us");
        System.out.println("Realiza"); //
        //criteria.add(Restrictions.like("perfil.usuario.nombreUsuario", nombreUsuario)) ;
        criteria.add(Restrictions.like("per_us.nombreUsuario", nombreUsuario)) ;
        Alumno alumno = null ;
        System.out.println("Termino la busqueda");// Llega hasta aqui
        if( !criteria.list().isEmpty() ){
            System.out.println("Entra a la asignacion");
            alumno = (Alumno) criteria.list().get(0) ;
            //Encontro un alumno
        }
        session.getTransaction().commit();
        session.close() ;
        System.out.println("Retorno"); //
        return alumno;
    }

    @Override
    public void agregar(Alumno alumno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(alumno);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarEstado(Alumno alumno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(alumno);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Alumno> obtenerAlumnos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Alumno.class);
        criteria.addOrder(Order.asc("codigo"));
        List alumnos = criteria.list();
        return alumnos;
    }
    
}
