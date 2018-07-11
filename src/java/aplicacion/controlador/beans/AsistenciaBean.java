/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.AsistenciaDAO;
import aplicacion.datos.hibernate.dao.imp.AsistenciaDAOImp;
import aplicacion.modelo.dominio.Asistencias;
import aplicacion.modelo.dominio.DocenteMateria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class AsistenciaBean implements Serializable {
    private Asistencias asistencia;
    private AsistenciaDAO asistenciaDao;

    
    public AsistenciaBean() {
    }
    
    @PostConstruct
    public void init() {
        asistencia = new Asistencias();
        asistenciaDao = new AsistenciaDAOImp();
    }
    
     public Asistencias getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencias asistencia) {
        this.asistencia = asistencia;
    }

    public AsistenciaDAO getAsistenciaDao() {
        return asistenciaDao;
    }

    public void setAsistenciaDao(AsistenciaDAO asistenciaDao) {
        this.asistenciaDao = asistenciaDao;
    }
      
    
    public void modificarAsistencia() {
        
        asistenciaDao.modificar(asistencia);
    }
     
    public Asistencias validarAsistencia() {
        
        return asistenciaDao.validarAsistencia(asistencia);
    }
    public List<Asistencias> obtenerAsistencia() {
        
        return asistenciaDao.obtenerAsistencia();
    }
    
    public void agregarAsistencia() {
        
        asistenciaDao.agregar(asistencia);
    }
}
