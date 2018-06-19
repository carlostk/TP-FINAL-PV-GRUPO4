/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Aula;
import java.util.List;

/**
 *
 * @author Oscar
 */
public interface AulaDAO {
    void agregarAula(Aula aula) ;
    void modificarAula(Aula aula) ;
    void eliminarAula(Aula aula) ;
    List<Aula> obtenerTodoAula() ;
    Aula buscarAula(String nombre);
}
