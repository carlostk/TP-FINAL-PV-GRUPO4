/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DocenteMateriaBean;
import aplicacion.modelo.dominio.DocenteMateria;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class DocenteMateriaFormBean implements Serializable{
@ManagedProperty(value = "#{docenteMateriaBean}")
  private DocenteMateriaBean docenteMateriaBean;
  private String estado="";
    public DocenteMateriaFormBean() {
    }
    public void modificar(DocenteMateria docente)
    {
      if(docente.getAnio()>0 && docente.getAnio()<9999)
      {
           if(estado.equals("h"))
         {
       
            docente.setHabilitado(true);
         }
         if(estado.equals("d"))
          {
            docente.setHabilitado(false);
          }
         docenteMateriaBean.getDocenteMateriaDao().modificarDocenteMateria(docente);
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificado","Modificado");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, mensaje);
        RequestContext.getCurrentInstance().update("form:mensajes");
         estado="";
         }else
         {
           FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Año:valor incorrecto","Año:valor incorrecto");
           FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, mensaje);
           RequestContext.getCurrentInstance().update("form:mensajes");
           
         }
      
    
    }
    public void agregar()
    {
      if(docenteMateriaBean.getDocenteMateria().getAnio()>0 && docenteMateriaBean.getDocenteMateria().getAnio()<9999)
      {
        docenteMateriaBean.registrarDocenteMateria();
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Agregado correctamente","Agregado correctamente");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, mensaje);
      }else
          {
           FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Año:valor incorrecto","Año:valor incorrecto");
           FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, mensaje);
          }
    }
    
    public void eliminar(DocenteMateria docente)
    {
      docenteMateriaBean.eliminarDocenteMateria(docente);
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminado","Eliminado");
      FacesContext facesContext = FacesContext.getCurrentInstance();
      facesContext.addMessage(null, mensaje);
    }

    public DocenteMateriaBean getDocenteMateriaBean() {
        return docenteMateriaBean;
    }

    public void setDocenteMateriaBean(DocenteMateriaBean docenteMateriaBean) {
        this.docenteMateriaBean = docenteMateriaBean;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

     public DocenteMateriaFormBean(DocenteMateriaBean docenteMateriaBean) {
        this.docenteMateriaBean = docenteMateriaBean;
    }
    
    
    
}
