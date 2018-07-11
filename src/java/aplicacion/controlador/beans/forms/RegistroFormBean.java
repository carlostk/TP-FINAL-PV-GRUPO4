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
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
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
public class RegistroFormBean implements Serializable {
@ManagedProperty(value = "#{perfilBean}")
private PerfilBean perfilBean;

    /**
     * Creates a new instance of RegistroFormBean
     */
    public RegistroFormBean() {
    }

    public RegistroFormBean( PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
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
    
    
    public void registrar() throws IOException{
        //usuarioBean.registrarUsuario();
        perfilBean.registrarPerfil();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null,
                new FacesMessage( FacesMessage.SEVERITY_INFO, "Usuario creado exitosamente","Usuario creado exitosamente"));
        facesContext.getExternalContext().redirect("/tp-final/faces/index.xhtml"); //Para redigir la pagina al login si usar un action
    } 
                    
}
