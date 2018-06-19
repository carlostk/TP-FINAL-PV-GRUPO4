/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
@ManagedBean
@RequestScoped
public class RegistroFormBean implements Serializable {
@ManagedProperty(value = "#{usuarioBean}")
private UsuarioBean usuarioBean;
@ManagedProperty(value = "#{perfilBean}")
private PerfilBean perfilBean;

    /**
     * Creates a new instance of RegistroFormBean
     */
    public RegistroFormBean() {
    }

    public RegistroFormBean(UsuarioBean usuarioBean, PerfilBean perfilBean) {
        this.usuarioBean = usuarioBean;
        this.perfilBean = perfilBean;
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }
    
    
    public void registrar(){
        //usuarioBean.registrarUsuario();
        perfilBean.registrarPerfil();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage( FacesMessage.SEVERITY_INFO, "Usuario creado exitosamente","Usuario creado exitosamente"));
    } 
            
}
