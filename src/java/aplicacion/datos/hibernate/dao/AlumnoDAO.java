/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Alumno;
import java.util.List;

/**
 *
 * @author pc1
 */
public interface AlumnoDAO {
    Alumno buscarAlumno(String nombreUsuario);
    void agregar(Alumno alumno) ;
    void eliminar(Alumno alumno) ;
    void modificarEstado(Alumno alumno);
    List<Alumno> obtenerAlumnos() ;
    
}
