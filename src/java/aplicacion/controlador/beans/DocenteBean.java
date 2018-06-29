/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.DocenteDAO;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.DocenteDaoImp;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Docente;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
@ManagedBean
@RequestScoped
public class DocenteBean implements Serializable {

    private Docente profesor;
    private boolean encontrado;

    /**
     * Creates a new instance of DocenteBean
     */
    public DocenteBean() {
        profesor = new Docente();
        encontrado = false;

        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        String nombreUsuario = usuario.getNombreUsuario();
        DocenteDAO docenteDAO = new DocenteDaoImp();
        Docente unProfesor = docenteDAO.buscarDocentePorNombreDeUsuario(nombreUsuario);

        if (unProfesor != null) {
            this.setProfesor(unProfesor);
            encontrado = true;
        } else {
            PerfilDAO perfilDAO = new PerfilDAOImp();
            Perfil unPerfil = perfilDAO.obtenerPerfil(nombreUsuario);
            this.profesor.setPerfil(unPerfil);
            this.profesor.setEstado(false); //Se lo deja así para que pueda ser activado despues
        }

    }

    public DocenteBean(Docente profesor, boolean encontrado) {
        this.profesor = profesor;
        this.encontrado = encontrado;
    }

    /**
     * @return the profesor
     */
    public Docente getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Docente profesor) {
        this.profesor = profesor;
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

    public void guardarProfesor() {
        DocenteDAO docenteDAO = new DocenteDaoImp();
        docenteDAO.agregarDocente(profesor);
    }

    public void actualizarProfesor() {
        DocenteDAO docenteDAO = new DocenteDaoImp();
        docenteDAO.modificarDocente(profesor);
    }

    public void realizarCambios() {
        if (encontrado == true) {
            actualizarProfesor();
        } else {
            guardarProfesor();
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambios Aplicados", "Cambios Aplicados"));
    }

    public void consultarEstadoDeActivasion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if ( this.profesor.isEstado() ) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Docente/Profesor habilitado", "Docente/Profesor habilitado"));
            System.out.println("Estado activado");
        } else {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Docente/Profesor NO habilitado", "Docente/Profesor NO habilitado"));
            System.out.println("Estado Desactivado");
        }
        System.out.println("Final.");
    }    

}
