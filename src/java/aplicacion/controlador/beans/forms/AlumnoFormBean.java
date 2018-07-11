/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AlumnoBean;
import aplicacion.datos.hibernate.dao.AlumnoDAO;
import aplicacion.datos.hibernate.dao.CarreraDAO;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.AlumnoDAOImp;
import aplicacion.datos.hibernate.dao.imp.CarreraDaoImp;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Alumno;
import aplicacion.modelo.dominio.Carrera;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class AlumnoFormBean implements Serializable {

    @ManagedProperty(value = "#{alumnoBean}")

    private AlumnoBean alumnoBean;
    private List<Carrera> carreras;

    /**
     * Creates a new instance of AlumnoFormBean
     */
    public AlumnoFormBean() {
        carreras = new ArrayList<>();
        cargarListaCarrera();
        //obtenerDatosAlumno();
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

    /**
     * Se obtiene una lista con la carreras disponibles.
     */
    public void cargarListaCarrera() {
        CarreraDAO carreraDAO = new CarreraDaoImp();
        this.setCarreras(carreraDAO.obtenerTodoCarreras());
    }

    /**
     * Se encarga de obtener los datos del alumno logueado en session. Si no lo
     * encuentra lo crea.
     */
    /*
    public void obtenerDatosAlumno() {
        //Primero obtiene el nombre de usuario de la session
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        String nombreUsuario = usuario.getNombreUsuario();
        //Consulta si hay un alumno con ese nombre de usuario y perfil.
        AlumnoDAO alumnoDAO = new AlumnoDAOImp();
        Alumno unAlumno = alumnoDAO.buscarAlumno(nombreUsuario);
        System.out.println("Llega aqui");
        
        if (unAlumno != null) { //Si el alumno no es nulo quiere decir que lo encontro y recupero.
            this.alumnoBean.setAlumno(unAlumno); //Lo asigna.
            this.alumnoBean.setEncontrado(true); //Cambia a verdadero el encontrado
            System.out.println("Entrada 1");
        } else {//Sino lo encontro
            System.out.println("Entrada 2");
            PerfilDAO perfilDAO = new PerfilDAOImp();
            Perfil unPerfil = perfilDAO.obtenerPerfil(nombreUsuario); //Recupera el perfil del usuario logueado.
            System.out.println("Nombre: " + unPerfil.getNombres() );
            System.out.println("Apellido: " + unPerfil.getApellidos() );
            alumnoBean.getAlumno().setPerfil(unPerfil); //Entonces lo asigna al alumno que se creara.
        }
        
        
    }*/

}
