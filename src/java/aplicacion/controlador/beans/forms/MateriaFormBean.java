/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.MateriaBean;
import aplicacion.modelo.dominio.Materia;
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
public class MateriaFormBean implements Serializable{
@ManagedProperty(value = "#{materiaBean}")
    
private MateriaBean materiaBean;

    public MateriaFormBean() {
    }
public void agregar()
{
  materiaBean.registrarMateria();
  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Agregado correctamente","Agregado correctamente");
  FacesContext facesContext = FacesContext.getCurrentInstance();
  facesContext.addMessage(null, mensaje);
}
public void modificar(Materia materia)
{
  if(materia.getNombre().equals(""))
  {
    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ingrese un valor","ingrese un valor");
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.addMessage(null, mensaje);
    RequestContext.getCurrentInstance().update("form:mensajes");
  }
  else
  {
    
          materiaBean.getMateriaDao().modificarMateria(materia);
          FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificado","Modificado");
          FacesContext facesContext = FacesContext.getCurrentInstance();
          facesContext.addMessage(null, mensaje);
          RequestContext.getCurrentInstance().update("form:mensajes");
  
  }

}
public void eliminar(Materia materia)
{
  materiaBean.eliminarMateria(materia);
  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminado","Eliminado");
  FacesContext facesContext = FacesContext.getCurrentInstance();
  facesContext.addMessage(null, mensaje);
  
}
    public MateriaBean getMateriaBean() {
        return materiaBean;
    }

    public void setMateriaBean(MateriaBean materiaBean) {
        this.materiaBean = materiaBean;
    }

    
    
    
}
