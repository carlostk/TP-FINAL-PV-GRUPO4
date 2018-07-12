/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AulaBean;
import aplicacion.modelo.dominio.Aula;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pc-Yo
 */
@ManagedBean
@ViewScoped
public class AulaFormBean {

    @ManagedProperty(value = "#{aulaBean}")
    private AulaBean aulaBean;

    public AulaFormBean() {
    }

    public AulaFormBean(AulaBean aulaBean) {
        this.aulaBean = aulaBean;
    }
    

    public AulaBean getAulaBean() {
        return aulaBean;
    }

    public void setAulaBean(AulaBean aulaBean) {
        this.aulaBean = aulaBean;
    }
     public void agregar()
    {
      aulaBean.registrarAula();
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Agregado correctamente","Agregado correctamente");
      FacesContext facesContext = FacesContext.getCurrentInstance();
      facesContext.addMessage(null, mensaje);
    
    }
      public void eliminar(Aula aula)
    {
      aulaBean.eliminarAula(aula);
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminado","Eliminado");
      FacesContext facesContext = FacesContext.getCurrentInstance();
      facesContext.addMessage(null, mensaje);
      RequestContext.getCurrentInstance().update("form:mensajes1");
    }
}
