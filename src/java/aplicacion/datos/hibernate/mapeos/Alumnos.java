package aplicacion.datos.hibernate.mapeos;
// Generated 11/06/2018 16:25:57 by Hibernate Tools 4.3.1



/**
 * Alumnos generated by hbm2java
 */
public class Alumnos  implements java.io.Serializable {


     private Integer aluCodigo;
     private String aluLibretaUniversitaria;
     private int aluCarrera;
     private int aluPerfil;

    public Alumnos() {
    }

    public Alumnos(String aluLibretaUniversitaria, int aluCarrera, int aluPerfil) {
       this.aluLibretaUniversitaria = aluLibretaUniversitaria;
       this.aluCarrera = aluCarrera;
       this.aluPerfil = aluPerfil;
    }
   
    public Integer getAluCodigo() {
        return this.aluCodigo;
    }
    
    public void setAluCodigo(Integer aluCodigo) {
        this.aluCodigo = aluCodigo;
    }
    public String getAluLibretaUniversitaria() {
        return this.aluLibretaUniversitaria;
    }
    
    public void setAluLibretaUniversitaria(String aluLibretaUniversitaria) {
        this.aluLibretaUniversitaria = aluLibretaUniversitaria;
    }
    public int getAluCarrera() {
        return this.aluCarrera;
    }
    
    public void setAluCarrera(int aluCarrera) {
        this.aluCarrera = aluCarrera;
    }
    public int getAluPerfil() {
        return this.aluPerfil;
    }
    
    public void setAluPerfil(int aluPerfil) {
        this.aluPerfil = aluPerfil;
    }




}


