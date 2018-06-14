/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Alumno;

/**
 *
 * @author pc1
 */
public interface AlumnoDAO {
    Alumno buscarAlumno(int codigoAlum);
    
}
