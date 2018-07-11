/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;


import aplicacion.modelo.dominio.Asistencias;
import aplicacion.modelo.dominio.DocenteMateria;
import java.util.List;

/**
 *
 * 
 */
public interface AsistenciaDAO {
    public void agregar(Asistencias asistencia);
    public void modificar(Asistencias asistencia);
    //public void eliminar(Asistencia asistencia);
    public List<Asistencias> obtenerAsistencia();
    public Asistencias validarAsistencia(Asistencias asistencia);
    
}
