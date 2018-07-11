/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.modelo.dominio.Perfil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Oscar
 */
public class PerfilDAOImp implements PerfilDAO, Serializable{

    @Override
    public void agregar(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(perfil);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(perfil);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Perfil obtenerPerfil(String nombreUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Perfil.class);
        criteria.createAlias("usuario", "us");
        criteria.add(Restrictions.like("us.nombreUsuario", nombreUsuario));
        //criteria.add(Restrictions.like("usuario.nombreUsuario", nombreUsuario));
        Perfil perfil = null;
        if (!criteria.list().isEmpty()) {
            perfil = (Perfil) criteria.list().get(0);
        }
        session.getTransaction().commit();
        session.close();
        return perfil;
    }

    @Override
    public List<Perfil> obtenerPerfiles(boolean estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Perfil.class);
        criteria.createAlias("usuario", "us");
        criteria.add(Restrictions.like("us.estado", estado));
        List<Perfil> perfiles = null;

        if (!criteria.list().isEmpty()) {
            perfiles = criteria.list();
        }
        session.getTransaction().commit();
        session.close();
        return perfiles;
    }
}
