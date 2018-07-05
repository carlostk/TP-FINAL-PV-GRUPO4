/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;


import aplicacion.modelo.dominio.AulasMaterias;
import java.util.List;

/**
 *
 * @author Pc-Yo
 */
public interface AulasMateriasDAO {
    void agregarAulasMaterias(AulasMaterias aulasMaterias) ;
    void modificarAulasMaterias(AulasMaterias aulasMaterias) ;
    void eliminarAulasMaterias(AulasMaterias aulasMaterias) ;
    List<AulasMaterias> obtenerTodoAulasMaterias() ;
    AulasMaterias buscarAulasMaterias(String nombre);
}
