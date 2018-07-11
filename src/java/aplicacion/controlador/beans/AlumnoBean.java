/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.AlumnoDAO;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.AlumnoDAOImp;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Alumno;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class AlumnoBean implements Serializable {

    private Alumno alumno;
    private boolean encontrado;

    public AlumnoBean() {
        alumno = new Alumno();
        encontrado = false;

        //Aqui comienza la recuperacion de datos
        try {
            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
            if (usuario.getTipoUsuario().compareTo("alumno") == 0) { //Se pregunta si es igual a alumno.
                this.recuperarDatosAlumno(); //Si es verdad recupera sus datos
            }
        } catch (Exception e) {
        }

    }

    public AlumnoBean(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the alumno
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the encontrado
     */
    public boolean isEncontrado() {
        return encontrado;
    }

    /**
     * @param encontrado the encontrado to set
     */
    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    /**
     * Se encarga de guardar el alumno.
     */
    public void guardarAlumno() {
        AlumnoDAO alumnoDAO = new AlumnoDAOImp();
        alumnoDAO.agregar(alumno);
    }

    /**
     * Se encarga de actualizar los datos del alumno.
     */
    public void actualizarAlumno() {
        AlumnoDAO alumnoDAO = new AlumnoDAOImp();
        alumnoDAO.modificarEstado(alumno);
    }

    /**
     * Dependiendo el valor de encontrado crea o actualiza el alumno.
     */
    public void realizarCambios() {
        if (encontrado == true) {
            actualizarAlumno();
        } else {
            guardarAlumno();
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambios Aplicados", "Cambios Aplicados"));
    }

    /**
     * Se encarga de recuperar los datos del alumno.
     */
    public void recuperarDatosAlumno() {
        try {
            //Obtener el nombre del usuario
            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
            String nombreUsuario = usuario.getNombreUsuario();
            //Consultamos si hay un alumno con ese nombre de usuario
            AlumnoDAO alumnoDAO = new AlumnoDAOImp();
            Alumno unAlumno = alumnoDAO.buscarAlumno(nombreUsuario); // Aqui realiza la busqueda.

            if (unAlumno != null) {
                //Si lo encontro lo setea
                this.setAlumno(unAlumno);
                encontrado = true;
            } else {
                //Si no lo encontro guarda el perfil del usuario logueado en alumno
                PerfilDAO perfilDAO = new PerfilDAOImp();
                Perfil unPerfil = perfilDAO.obtenerPerfil(nombreUsuario);
                this.alumno.setPerfil(unPerfil);
            }
        } catch (Exception e) {
        }
    }

}
