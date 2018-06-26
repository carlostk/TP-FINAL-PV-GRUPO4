/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Carrera;
import java.util.List;

/**
 *
 * @author Oscar
 */
public interface CarreraDAO {
    void agregarCarrera(Carrera carrera);
    void eliminarCarrera(Carrera carrera);
    void modificarCarrera(Carrera carrera);
    List<Carrera> buscarCarrera(String nombre) ;
    List<Carrera> obtenerTodoCarreras();
}
