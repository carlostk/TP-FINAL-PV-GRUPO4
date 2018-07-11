package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class DatosFormBean implements Serializable {

    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    private String contraseña;

    /**
     * Creates a new instance of DatosFormBean
     */
    public DatosFormBean() {
        //perfilBean.recuperarDatosPerfil();
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

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void actualizarPerfil() throws IOException {
        if (contraseña.compareTo(this.perfilBean.getPerfil().getUsuario().getPassword()) == 0) {
            PerfilDAO perfilDAO = new PerfilDAOImp();
            perfilDAO.modificar(this.perfilBean.getPerfil());

            //Falta cambiar el nombre de usuario en la session
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario/Perfil actualizado exitosamente", "Usuario/Perfil actualizado exitosamente"));
            //Cerrado de session y redirrecion a la pagina de inicio
            facesContext.getExternalContext().redirect("/tp-final/faces/index.xhtml"); //Para redigir la pagina al login si usar un action
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Las contraseñas deben coincidir"));
        }

    }
}
