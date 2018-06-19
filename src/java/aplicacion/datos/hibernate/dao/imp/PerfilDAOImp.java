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
import org.hibernate.Session;

/**
 *
 * @author Oscar
 */
public class PerfilDAOImp implements PerfilDAO, Serializable{

    @Override
    public void agregar(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(perfil) ;
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
    public Perfil obtenerPerfil() {
        Perfil perfil = null ;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
