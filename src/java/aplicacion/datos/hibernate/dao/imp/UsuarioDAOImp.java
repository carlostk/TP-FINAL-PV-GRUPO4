/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.modelo.dominio.Usuario;


import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc1
 */
public class UsuarioDAOImp implements UsuarioDAO,Serializable{

    @Override
    public boolean validar(String nombreUsuario,String contraseña,String tipo) {
         
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         Criteria criteria = session.createCriteria(Usuario.class);
         criteria.add(Restrictions.like("usuNombreUsuario", nombreUsuario));
         criteria.add(Restrictions.like("usuPassword", contraseña));
         criteria.add(Restrictions.like("usuTipoUsuario", tipo));
         boolean esValido = true;
         if(criteria.list().isEmpty())
         {
           esValido = false;
         }
        session.close();
        return esValido;
    }
    
}
