/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.DocenteDAO;
import aplicacion.modelo.dominio.Docente;
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
public class DocenteDaoImp implements DocenteDAO, Serializable {

    @Override
    public void agregarDocente(Docente docente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(docente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarDocente(Docente docente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(docente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarDocente(Docente docente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(docente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Docente buscarDocente(String nombre) {
        List<Docente> docentes;
        Docente docente;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Docente.class);
        criteria.add(Restrictions.like("perfil.nombres", nombre));
        System.out.println("tamaño" + criteria.list().size());
        docentes = (List<Docente>) criteria.list();

        docente = docentes.get(0);
        System.out.println("tamañooo" + docente.getCargo());
        session.close();
        return docente;
    }

    @Override
    public List<Docente> obtenerTodoDocente() {
        List<Docente> docentes;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Docente.class);
        docentes = (List<Docente>) criteria.list();
        for (Docente m : docentes) {
            Hibernate.initialize(m.getPerfil());
        }
        session.close();
        return docentes;
    }

    @Override
    public Docente buscarDocentePorNombreDeUsuario(String nombreUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Docente.class);
        criteria.createAlias("perfil.usuario", "per_us");
        criteria.add(Restrictions.like("per_us.nombreUsuario", nombreUsuario));
        Docente docente = null;
        if (!criteria.list().isEmpty()) {
            docente = (Docente) criteria.list().get(0);
        }
        session.getTransaction().commit();
        session.close();
        return docente;
    }

}
