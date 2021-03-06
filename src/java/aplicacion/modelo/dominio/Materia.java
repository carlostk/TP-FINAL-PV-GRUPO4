package aplicacion.modelo.dominio;
// Generated 18/06/2018 06:49:42 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Materia generated by hbm2java
 */
public class Materia  implements java.io.Serializable {


     private Integer codigo;
     private Carrera carrera;
     private String nombre;
     private boolean estado;
    

    public Materia() {
        carrera=new Carrera();
    }

    public Materia(Integer codigo, Carrera carrera, String nombre, boolean estado) {
        this.codigo = codigo;
        this.carrera = carrera;
        this.nombre = nombre;
        this.estado = estado;
    }
@Override
    public String toString(){
        return String.format("Materia[%d,%s]", codigo, carrera,nombre,estado);
    }
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
	
   




}


