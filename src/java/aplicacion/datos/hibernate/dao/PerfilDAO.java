/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;

/**
 *
 * @author Oscar
 */
public interface PerfilDAO {
    void agregar(Perfil perfil);
    void modificar(Perfil perfil);
    Perfil obtenerPerfil();
}