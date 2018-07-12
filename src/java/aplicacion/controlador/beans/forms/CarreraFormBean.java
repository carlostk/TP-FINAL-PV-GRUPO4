/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CarreraBean;
import aplicacion.modelo.dominio.Carrera;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author pc1
 */
@ManagedBean
@ViewScoped
public class CarreraFormBean implements Serializable{

@ManagedProperty(value = "#{carreraBean}")
private CarreraBean carreraBean;
private String estado="";
private String buscado="";
    public CarreraFormBean() {
    }
    public void agregar()
    {
      carreraBean.registrarCarrera();
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Agregado correctamente","Agregado correctamente");
      FacesContext facesContext = FacesContext.getCurrentInstance();
      facesContext.addMessage(null, mensaje);
    
    }
    public void modificar(Carrera carrera)
    { 
     if(carrera.getNombreCarrera().equals("") || carrera.getPlan().equals(""))
     {
       FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ingrese un valor","ingrese un valor");
       FacesContext facesContext = FacesContext.getCurrentInstance();
       facesContext.addMessage(null, mensaje);
       RequestContext.getCurrentInstance().update("form:mensajes");
     
     }
     else
     {
          carreraBean.getCarreraDao().modificarCarrera(carrera);
          FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificado","Modificado");
          FacesContext facesContext = FacesContext.getCurrentInstance();
          facesContext.addMessage(null, mensaje);
          RequestContext.getCurrentInstance().update("form:mensajes");
     }
    }
    public void eliminar(Carrera carrera)
    {
      carreraBean.eliminarCarrera(carrera);
      FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminado","Eliminado");
      FacesContext facesContext = FacesContext.getCurrentInstance();
      facesContext.addMessage(null, mensaje);
      RequestContext.getCurrentInstance().update("form:mensajes");
    }
    public void buscar()
    {
      if(buscado.equals(""))
      {
       FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ingrese un valor","ingrese un valor");
       FacesContext facesContext = FacesContext.getCurrentInstance();
       facesContext.addMessage(null, mensaje);
      }
      else
      {
        if(carreraBean.buscarCarrera(buscado)==false)
        {
           FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"No Existe","No Existe");
           FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, mensaje);
        }
      }
    }
    public CarreraFormBean(CarreraBean carreraBean) {
        this.carreraBean = carreraBean;
    }

    public CarreraBean getCarreraBean() {
        return carreraBean;
    }

    public void setCarreraBean(CarreraBean carreraBean) {
        this.carreraBean = carreraBean;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }
   
}
