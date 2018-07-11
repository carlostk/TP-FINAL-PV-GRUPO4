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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class DocenteBean implements Serializable {

    private Docente profesor;
    private boolean encontrado;

    /**
     * Creates a new instance of DocenteBean
     */
    public DocenteBean() {
        profesor = new Docente();
        encontrado = false;
        
        //Aqui comienza la recuperacion de datos
        try {
            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
            if(usuario.getTipoUsuario().compareTo("profesor") == 0 ){ //Se pregunta si es igual a profesor.
                this.recuperarDatosDocente(); //Si es verdad recupera sus datos
            }
        } catch (Exception e) {
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

    public String consultarEstadoDeActivasion() {
        if (this.profesor.isEstado()) {
            return "Estado activado";
        } else {
            return "Estado Desactivado";
        }
    }

    /**
     * Se encarga de recuperar los datos.
     */
    public void recuperarDatosDocente() {
        try {
            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
            String nombreUsuario = usuario.getNombreUsuario();
            System.out.println(nombreUsuario);

            DocenteDAO docenteDAO = new DocenteDaoImp();
            Docente unProfesor = docenteDAO.buscarDocentePorNombreDeUsuario(nombreUsuario);

            if (unProfesor != null) {
                this.setProfesor(unProfesor);
                encontrado = true;
            } else {
                PerfilDAO perfilDAO = new PerfilDAOImp();
                Perfil unPerfil = perfilDAO.obtenerPerfil(nombreUsuario);
                this.profesor.setPerfil(unPerfil);
                this.profesor.setEstado(false); //Se lo deja así para que pueda ser activado despues.
            }
        } catch (Exception e) {
        }
    }
}
