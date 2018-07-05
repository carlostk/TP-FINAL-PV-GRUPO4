/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AulasMateriasBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Pc-Yo
 */
@ManagedBean
@RequestScoped
public class AulasMateriasFormBean {

    @ManagedProperty(value = "#{aulasMateriasBean}")
    private AulasMateriasBean aulasMateriasBean;
    /**
     * Creates a new instance of AulasMateriasFormBean
     */
    public AulasMateriasFormBean() {
        
    }

    public AulasMateriasFormBean(AulasMateriasBean aulasMateriasBean) {
        this.aulasMateriasBean = aulasMateriasBean;
    }
    
    public AulasMateriasBean getAulasMateriasBean() {
        return aulasMateriasBean;
    }

    public void setAulasMateriasBean(AulasMateriasBean aulasMateriasBean) {
        this.aulasMateriasBean = aulasMateriasBean;
    }
    
    
}
