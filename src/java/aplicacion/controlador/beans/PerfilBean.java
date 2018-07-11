/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.Date;
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
public class PerfilBean implements Serializable {

    private Perfil perfil;

    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
        perfil = new Perfil();
        Usuario usuario1 = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuario1 != null) {
            obtenerDatosPerfil();
        }
        //}
    }

    public PerfilBean(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void registrarPerfil() {
        perfil.getUsuario().setEstado(true);
        PerfilDAO perfilDAO = new PerfilDAOImp();
        perfilDAO.agregar(perfil);

    }

    public void obtenerDatosPerfil() {
        System.out.println("Entro");
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");

        PerfilDAO perfilDAO = new PerfilDAOImp();
        String nombreUsuario = usuario.getNombreUsuario();
        System.out.println("Nombre de Usuario: " + nombreUsuario);

        Perfil perfilObtenido = perfilDAO.obtenerPerfil(nombreUsuario);
        this.setPerfil(perfilObtenido);
    }

    /**
     * Se encargade actualizar el perfil
     */
    public void actualizarPerfil() {
        PerfilDAO perfilDAO = new PerfilDAOImp();
        perfilDAO.modificar(perfil);

        //Falta cambiar el nombre de usuario en la session
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario/Perfil actualizado exitosamente", "Usuario/Perfil actualizado exitosamente"));

    }

    /**
     * Se encarga de recuperar los datos del Perfil
     */
    public void recuperarDatosPerfil() {
        try {
            Usuario usuario1 = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
            if (usuario1 != null) {
                obtenerDatosPerfil();
            }
        } catch (Exception e) {
        }

    }

}
