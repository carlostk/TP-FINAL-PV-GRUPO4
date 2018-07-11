/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.InscripcionAlumno;
import java.util.List;

/**
 *
 * @author pc1
 */
public interface InscripcionAlumnoDAO {
    void agregarInscripcion(InscripcionAlumno inscripcion) ;
    void eliminarInscripcion(InscripcionAlumno inscripcion) ;
    void modificarInscripcion(InscripcionAlumno inscripcion) ;
    InscripcionAlumno buscarInscripcion(String nombre) ;
    List<InscripcionAlumno> obtenerTodoInscripcion();
    List<InscripcionAlumno> obtenerInscripcionesNombre(String nombreUsuario);
}
