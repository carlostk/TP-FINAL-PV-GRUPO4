/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.UsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable{

    /**
     * Creates a new instance of UsuarioBean
     */
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;
    public UsuarioBean() {
    }
    
     @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuarioDAO = new UsuarioDAOImp();
    }
    
    public boolean validar(){
        return usuarioDAO.validar(usuario.getUsuNombreUsuario(),usuario.getUsuPassword(),usuario.getUsuTipoUsuario());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
}
