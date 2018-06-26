/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.CarreraBean;
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
public class CarreraFormBean implements Serializable{

@ManagedProperty(value = "#{carreraBean}")
private CarreraBean carreraBean;
    public CarreraFormBean() {
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
 
}
