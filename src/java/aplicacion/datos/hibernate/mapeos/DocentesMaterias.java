package aplicacion.datos.hibernate.mapeos;
// Generated 11/06/2018 16:25:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DocentesMaterias generated by hbm2java
 */
public class DocentesMaterias  implements java.io.Serializable {


     private Integer dmCodigo;
     private Materias materias;
     private int dmAnio;
     private boolean dmHabilitado;
     private boolean dmEstado;
     private int dmDocente;
     private Set inscripcionesAlumnoses = new HashSet(0);

    public DocentesMaterias() {
    }

	
    public DocentesMaterias(Materias materias, int dmAnio, boolean dmHabilitado, boolean dmEstado, int dmDocente) {
        this.materias = materias;
        this.dmAnio = dmAnio;
        this.dmHabilitado = dmHabilitado;
        this.dmEstado = dmEstado;
        this.dmDocente = dmDocente;
    }
    public DocentesMaterias(Materias materias, int dmAnio, boolean dmHabilitado, boolean dmEstado, int dmDocente, Set inscripcionesAlumnoses) {
       this.materias = materias;
       this.dmAnio = dmAnio;
       this.dmHabilitado = dmHabilitado;
       this.dmEstado = dmEstado;
       this.dmDocente = dmDocente;
       this.inscripcionesAlumnoses = inscripcionesAlumnoses;
    }
   
    public Integer getDmCodigo() {
        return this.dmCodigo;
    }
    
    public void setDmCodigo(Integer dmCodigo) {
        this.dmCodigo = dmCodigo;
    }
    public Materias getMaterias() {
        return this.materias;
    }
    
    public void setMaterias(Materias materias) {
        this.materias = materias;
    }
    public int getDmAnio() {
        return this.dmAnio;
    }
    
    public void setDmAnio(int dmAnio) {
        this.dmAnio = dmAnio;
    }
    public boolean isDmHabilitado() {
        return this.dmHabilitado;
    }
    
    public void setDmHabilitado(boolean dmHabilitado) {
        this.dmHabilitado = dmHabilitado;
    }
    public boolean isDmEstado() {
        return this.dmEstado;
    }
    
    public void setDmEstado(boolean dmEstado) {
        this.dmEstado = dmEstado;
    }
    public int getDmDocente() {
        return this.dmDocente;
    }
    
    public void setDmDocente(int dmDocente) {
        this.dmDocente = dmDocente;
    }
    public Set getInscripcionesAlumnoses() {
        return this.inscripcionesAlumnoses;
    }
    
    public void setInscripcionesAlumnoses(Set inscripcionesAlumnoses) {
        this.inscripcionesAlumnoses = inscripcionesAlumnoses;
    }




}


