/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
@ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String nombre;
    private String password;
    private String tipo="";
    
    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }
    //
    public String validar(){
        
        String resultado = null;
        usuarioBean.getUsuario().setNombreUsuario(nombre);
        usuarioBean.getUsuario().setPassword(password);
        usuarioBean.getUsuario().setTipoUsuario(tipo);
        
        boolean esValido = usuarioBean.validar();
        if(esValido==true){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Es valido"));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuarioBean.getUsuario());
            resultado = "menu?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Es invalido"));
        }
        return resultado;
    }

    public String getNombreUsuarioValidado(){
        Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario1.getNombreUsuario();
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión Cerrada", "Sesión Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        
        String resultado = "/index?faces-redirect=true";
        return resultado;
    }
    
    public boolean verificarSesion(){
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado")!=null){
            sesionValida=true;
        }
        return sesionValida;
    }
    
    public boolean verificarAlumno(){
     Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
     boolean sesionAlumno=false;
     if(usuario1!=null &&
             usuario1.getTipoUsuario().equals("alumno"))
     {
       sesionAlumno=true;
     }
     return sesionAlumno;
    }
    
    public boolean verificarProfesor(){
     boolean sesionProfesor=false;
     Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
     
     if(usuario1!=null&&
        usuario1.getTipoUsuario().equals("profesor"))
     {
       sesionProfesor=true;
     }
     return sesionProfesor;
    }
    
     public boolean verificarSupervisor(){
     boolean sesionSupervisor=false;
     Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
     if(usuario1!= null &&
             usuario1.getTipoUsuario().equals("supervisor"))
     {
       sesionSupervisor=true;
     }
     return sesionSupervisor;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    
}
