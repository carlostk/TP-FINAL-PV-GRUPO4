package aplicacion.datos.hibernate.mapeos;
// Generated 11/06/2018 16:25:57 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Asistencias generated by hbm2java
 */
public class Asistencias  implements java.io.Serializable {


     private Integer asiCodigo;
     private Date asiFecha;
     private String asiValor;
     private boolean asiEstado;
     private int asiAulaMateria;
     private int asiAlumnoInscripto;

    public Asistencias() {
    }

    public Asistencias(Date asiFecha, String asiValor, boolean asiEstado, int asiAulaMateria, int asiAlumnoInscripto) {
       this.asiFecha = asiFecha;
       this.asiValor = asiValor;
       this.asiEstado = asiEstado;
       this.asiAulaMateria = asiAulaMateria;
       this.asiAlumnoInscripto = asiAlumnoInscripto;
    }
   
    public Integer getAsiCodigo() {
        return this.asiCodigo;
    }
    
    public void setAsiCodigo(Integer asiCodigo) {
        this.asiCodigo = asiCodigo;
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
    public int getAsiAulaMateria() {
        return this.asiAulaMateria;
    }
    
    public void setAsiAulaMateria(int asiAulaMateria) {
        this.asiAulaMateria = asiAulaMateria;
    }
    public int getAsiAlumnoInscripto() {
        return this.asiAlumnoInscripto;
    }
    
    public void setAsiAlumnoInscripto(int asiAlumnoInscripto) {
        this.asiAlumnoInscripto = asiAlumnoInscripto;
    }




}


