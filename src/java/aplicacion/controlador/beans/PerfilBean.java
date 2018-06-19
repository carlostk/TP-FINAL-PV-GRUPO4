/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oscar
 */
@ManagedBean
@RequestScoped
public class PerfilBean implements Serializable {
    private Perfil perfil ;
    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
        perfil = new Perfil() ;
    }

    public PerfilBean(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public void registrarPerfil(){
        perfil.setDni("1");
        perfil.setCelular("0");
        perfil.setFechaNac(new Date());
        
        PerfilDAO perfilDAO = new PerfilDAOImp();
        perfilDAO.agregar(perfil);
        
    }
    
}
