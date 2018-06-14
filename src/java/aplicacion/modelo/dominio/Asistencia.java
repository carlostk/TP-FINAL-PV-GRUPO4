package aplicacion.modelo.dominio;
// Generated 07/06/2018 13:36:05 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Asistencias generated by hbm2java
 */
public class Asistencia  implements java.io.Serializable {


     private Integer asiCodigo;
     private AulaMateria aulasMaterias;
     private InscripcionAlumno inscripcionesAlumnos;
     private Date asiFecha;
     private String asiValor;
     private boolean asiEstado;

    public Asistencia() {
    }

    public Asistencia(AulaMateria aulasMaterias, InscripcionAlumno inscripcionesAlumnos, Date asiFecha, String asiValor, boolean asiEstado) {
       this.aulasMaterias = aulasMaterias;
       this.inscripcionesAlumnos = inscripcionesAlumnos;
       this.asiFecha = asiFecha;
       this.asiValor = asiValor;
       this.asiEstado = asiEstado;
    }
   
    public Integer getAsiCodigo() {
        return this.asiCodigo;
    }
    
    public void setAsiCodigo(Integer asiCodigo) {
        this.asiCodigo = asiCodigo;
    }
    public AulaMateria getAulasMaterias() {
        return this.aulasMaterias;
    }
    
    public void setAulasMaterias(AulaMateria aulasMaterias) {
        this.aulasMaterias = aulasMaterias;
    }
    public InscripcionAlumno getInscripcionesAlumnos() {
        return this.inscripcionesAlumnos;
    }
    
    public void setInscripcionesAlumnos(InscripcionAlumno inscripcionesAlumnos) {
        this.inscripcionesAlumnos = inscripcionesAlumnos;
    }
    public Date getAsiFecha() {
        return this.asiFecha;
    }
    
    public void setAsiFecha(Date asiFecha) {
        this.asiFecha = asiFecha;
    }
    public String getAsiValor() {
        return this.asiValor;
    }
    
    public void setAsiValor(String asiValor) {
        this.asiValor = asiValor;
    }
    public boolean isAsiEstado() {
        return this.asiEstado;
    }
    
    public void setAsiEstado(boolean asiEstado) {
        this.asiEstado = asiEstado;
    }




}


