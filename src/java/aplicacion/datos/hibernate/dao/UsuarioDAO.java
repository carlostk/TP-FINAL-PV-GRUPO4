/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author pc1
 */
public interface UsuarioDAO {
    boolean validar(String nombreUsuario,String contraseña,String tipo);
    void crear(Usuario usuario);
    void modificar(Usuario usuario);
    Usuario obtenerUsuario(String nombre) ;
}
