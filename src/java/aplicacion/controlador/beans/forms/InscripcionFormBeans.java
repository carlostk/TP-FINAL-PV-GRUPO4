/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CarreraBean;
import aplicacion.controlador.beans.InscripcionAlumnoBean;
import aplicacion.modelo.dominio.DocenteMateria;
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
@ViewScoped
public class InscripcionFormBeans {

    @ManagedProperty(value = "#{inscripcionAlumnoBean}")
    private InscripcionAlumnoBean inscripcionAlumnoBean;
    @ManagedProperty(value = "#{carreraBean}")
    private CarreraBean carreraBean;
    private String buscado="";
    public InscripcionFormBeans() {
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    public InscripcionAlumnoBean getInscripcionAlumnoBean() {
        return inscripcionAlumnoBean;
    }

    public void setInscripcionAlumnoBean(InscripcionAlumnoBean inscripcionAlumnoBean) {
        this.inscripcionAlumnoBean = inscripcionAlumnoBean;
    }

    public CarreraBean getCarreraBean() {
        return carreraBean;
    }

    public void setCarreraBean(CarreraBean carreraBean) {
        this.carreraBean = carreraBean;
    }
    public void inscribirse(DocenteMateria docentemateria)
    {
      if(inscripcionAlumnoBean.Buscar(docentemateria))
      {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Materia ya inscripta","Materia ya inscripta");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, mensaje);
      }
      else
      {
       inscripcionAlumnoBean.getInscripcionAlumno().setDocenteMateria(docentemateria);
       inscripcionAlumnoBean.agregar();
       FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Inscripcion Realizada","Inscripcion Realizada");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, mensaje);
      }
    
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
        if(inscripcionAlumnoBean.buscarInscripcionAlumno(buscado)==false)
        {
           FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"No Existe","No Existe");
           FacesContext facesContext = FacesContext.getCurrentInstance();
           facesContext.addMessage(null, mensaje);
        }
      }
    }
    
}
