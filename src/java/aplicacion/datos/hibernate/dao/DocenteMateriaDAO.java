/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.DocenteMateria;
import java.util.List;

/**
 *
 * @author pc1
 */
public interface DocenteMateriaDAO {
    void agregarDocenteMateria(DocenteMateria docentemateria) ;
    void eliminarDocenteMateria(DocenteMateria docentemateria) ;
    void modificarDocenteMateria(DocenteMateria docentemateria) ;
    DocenteMateria buscarDocenteMateria(String nombre) ;
    List<DocenteMateria> obtenerTodoDocenteMateria();
}
