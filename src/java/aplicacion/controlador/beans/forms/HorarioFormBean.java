
package aplicacion.controlador.beans.forms;


import aplicacion.controlador.beans.AulasMateriasBean;
import aplicacion.controlador.beans.InscripcionAlumnoBean;
import aplicacion.datos.hibernate.dao.AulasMateriasDAO;
import aplicacion.datos.hibernate.dao.imp.AulasMateriasDAOImp;
import aplicacion.modelo.dominio.Alumno;
import aplicacion.modelo.dominio.AulasMaterias;
import aplicacion.modelo.dominio.InscripcionAlumno;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;




@ManagedBean
@ViewScoped
public class HorarioFormBean implements Serializable {

    @ManagedProperty(value = "#{inscripcionAlumnoBean}")
    private InscripcionAlumnoBean inscripcionAlumnoBean;

    @ManagedProperty(value = "#{aulaMateriaBean}")
    private AulasMateriasBean aulaMateriaBean;

    private List<AulasMaterias> tablahorarios;

   
    
    public HorarioFormBean() {
        tablahorarios = new ArrayList<>();
        
    }
//agrega un horario a la tabla de horarios.
      public void agregarHorario(AulasMaterias aulaMateria) {
        if (verificarHorario(aulaMateria)) {
            tablahorarios.add(aulaMateria);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Horario Agregado en la tabla", null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "horario ya existe en la tabla", null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
 //obtiene los horarios de las materias del alumno.
  public List<AulasMaterias> obtenerHorarios() {
        List<AulasMaterias> aulaMaterias = new ArrayList<>();
        AulasMateriasDAO aulaMateriaDAO = new AulasMateriasDAOImp();
        for (InscripcionAlumno ia : obtenerMaterias()) {
             
            for (AulasMaterias am : aulaMateriaDAO.obtenerTodoAulasMaterias()) {
                
                if (ia.getDocenteMateria().getMateria().getCodigo() == am.getDocentesMaterias().getMateria().getCodigo()) {
                    aulaMaterias.add(am);
                }
            }
        }
        return aulaMaterias;
    }
  //elimina el horario de la tabla de horarios.  
    public void eliminarHorario(AulasMaterias aulaMateria) {
        if (!verificarHorario(aulaMateria)) {
            tablahorarios.remove(aulaMateria);        
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Horario Eliminado ", null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);       
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Horario no existe en la tabla", null);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        if (tablahorarios.isEmpty()) {
            
        }
    }

 //verifica si el horario esta en la tabla o no.   
    public boolean verificarHorario(AulasMaterias aulaMateria) {
        boolean encontrado = true;
        if (tablahorarios.isEmpty()) {           
            return encontrado;
        } else {
            for (AulasMaterias a : tablahorarios) {
                if (a.getAmCodigo() == aulaMateria.getAmCodigo()) {
                    encontrado = false;
                    break;
                }
            }
        }
        return encontrado;
    }
//obtiene las materia del alumno
      public List<InscripcionAlumno> obtenerMaterias() {
        List<InscripcionAlumno> inscripcionAlumnos = new ArrayList<>();
        Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
       for(Alumno d : inscripcionAlumnoBean.getAlumnoDaoImp().obtenerAlumnos())
        {
           
           if(d.getPerfil().getUsuario().getNombreUsuario().equals(usuario1.getNombreUsuario()))
           {
               for (InscripcionAlumno a : inscripcionAlumnoBean.getInscripcionAlumnoDao().obtenerTodoInscripcion()) {
                    if (a.getAlumno().getCodigo() == d.getCodigo()) {
                      inscripcionAlumnos.add(a);
                  }
                 }
           }
        }  
        return inscripcionAlumnos;
    }


   

   
    public InscripcionAlumnoBean getInscripcionAlumnoBean() {
        return inscripcionAlumnoBean;
    }

    
    public void setInscripcionAlumnoBean(InscripcionAlumnoBean inscripcionAlumnoBean) {
        this.inscripcionAlumnoBean = inscripcionAlumnoBean;
    }

    public AulasMateriasBean getAulaMateriaBean() {
        return aulaMateriaBean;
    }

    public void setAulaMateriaBean(AulasMateriasBean aulaMateriaBean) {
        this.aulaMateriaBean = aulaMateriaBean;
    }

    public List<AulasMaterias> getTablahorarios() {
        return tablahorarios;
    }

    public void setTablahorarios(List<AulasMaterias> tablahorarios) {
        this.tablahorarios = tablahorarios;
    }

   
    
   

}
