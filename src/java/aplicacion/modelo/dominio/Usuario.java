package aplicacion.modelo.dominio;
// Generated 18/06/2018 06:49:42 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer codigo;
     private String nombreUsuario;
     private String password;
     private String tipoUsuario;
     private boolean estado;
     

    public Usuario() {
    }

	
    public Usuario(String usuNombreUsuario, String usuPassword, String usuTipoUsuario, boolean usuEstado) {
        this.nombreUsuario = usuNombreUsuario;
        this.password = usuPassword;
        this.tipoUsuario = usuTipoUsuario;
        this.estado = usuEstado;
    }
     @Override
    public String toString(){
        return String.format("Usuario[%d,%s]", codigo, nombreUsuario,password,tipoUsuario,estado);
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    



}


