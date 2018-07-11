/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AulaBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
}
