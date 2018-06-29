/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AlumnoBean;
import aplicacion.datos.hibernate.dao.CarreraDAO;
import aplicacion.datos.hibernate.dao.imp.CarreraDaoImp;
import aplicacion.modelo.dominio.Carrera;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oscar
 */
@ManagedBean
@RequestScoped
public class AlumnoFormBean implements Serializable{
@ManagedProperty(value = "#{alumnoBean}")

    private AlumnoBean alumnoBean ;
    private List<Carrera> carreras;
    /**
     * Creates a new instance of AlumnoFormBean
     */
    public AlumnoFormBean() {
        carreras = new ArrayList<>() ;
        cargarListaCarrera();
    }

    /**
     * @return the alumnoBean
     */
    public AlumnoBean getAlumnoBean() {
        return alumnoBean;
    }

    /**
     * @param alumnoBean the alumnoBean to set
     */
    public void setAlumnoBean(AlumnoBean alumnoBean) {
        this.alumnoBean = alumnoBean;
    }

    /**
     * @return the carreras
     */
    public List<Carrera> getCarreras() {
        return carreras;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    public void cargarListaCarrera(){
        CarreraDAO carreraDAO = new CarreraDaoImp() ;
        this.setCarreras(carreraDAO.obtenerTodoCarreras());
    }
}
