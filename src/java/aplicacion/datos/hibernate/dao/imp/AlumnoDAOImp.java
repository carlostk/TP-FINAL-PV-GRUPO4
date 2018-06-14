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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc1
 */
public class AlumnoDAOImp implements AlumnoDAO ,Serializable{

    @Override
    public Alumno buscarAlumno(int codigoAlum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    @Override
    public Alumno buscarAlumno(int codigoAlum) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         Criteria criteria = session.createCriteria(Alumno.class);
         
    }
    */
    
}
