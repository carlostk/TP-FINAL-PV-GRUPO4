package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PerfilBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class DatosFormBean implements Serializable {

    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;

    /**
     * Creates a new instance of DatosFormBean
     */
    public DatosFormBean() {
    }

    public DatosFormBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    
}
