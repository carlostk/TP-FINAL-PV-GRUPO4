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
import javax.faces.bean.ViewScoped;


/**
 *
 * @author pc1
 */
@ManagedBean
@ViewScoped
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
        return usuarioDAO.validar(usuario.getNombreUsuario(),usuario.getPassword(),usuario.getTipoUsuario());
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

    public void registrarUsuario(){
        /*
        if (usuario.getUsuTipoUsuario() == "profesor"){
            usuario.setUsuEstado(false);
        }else{
            usuario.setUsuEstado(true);
        }
        
             private Integer usuCodigo;
     private String usuNombreUsuario;
     private String usuPassword;
     private String usuTipoUsuario;
     private boolean usuEstado;
        */
        Usuario unUsuario = new Usuario("oscarugarte","oscar","alumno",true);
        UsuarioDAO usuarioDAO2 = new UsuarioDAOImp();
        usuarioDAO2.crear(unUsuario);
    }    
}
