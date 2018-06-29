/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Docente;
import java.util.List;

/**
 *
 * @author pc1
 */
public interface DocenteDAO {
    void agregarDocente(Docente docente) ;
    void eliminarDocente(Docente docente) ;
    void modificarDocente(Docente docente) ;
    Docente buscarDocente(String nombre) ;
    List<Docente> obtenerTodoDocente();
    Docente buscarDocentePorNombreDeUsuario(String nombreUsuario);
}
