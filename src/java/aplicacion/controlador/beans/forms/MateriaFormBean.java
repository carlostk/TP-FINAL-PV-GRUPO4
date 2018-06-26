/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.MateriaBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class MateriaFormBean implements Serializable{
@ManagedProperty(value = "#{materiaBean}")
    
private MateriaBean materiaBean;
    public MateriaFormBean() {
    }

    public MateriaBean getMateriaBean() {
        return materiaBean;
    }

    public void setMateriaBean(MateriaBean materiaBean) {
        this.materiaBean = materiaBean;
    }
    
    
}
