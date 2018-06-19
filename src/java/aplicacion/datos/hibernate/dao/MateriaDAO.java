/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Materia;
import java.util.List;

/**
 *
 * @author Oscar
 */
public interface MateriaDAO {
    void agregarMateria(Materia materia) ;
    void eliminarMateria(Materia materia) ;
    void modificarMateria(Materia materia) ;
    Materia buscarMateria(String nombre) ;
    List<Materia> obtenerTodoMateria();
}
