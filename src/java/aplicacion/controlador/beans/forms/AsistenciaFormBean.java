/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.AsistenciaBean;
import aplicacion.controlador.beans.AulasMateriasBean;
import aplicacion.controlador.beans.InscripcionAlumnoBean;
import aplicacion.controlador.beans.MateriaBean;
import aplicacion.datos.hibernate.dao.AsistenciaDAO;
import aplicacion.datos.hibernate.dao.AulasMateriasDAO;
import aplicacion.datos.hibernate.dao.imp.AsistenciaDAOImp;
import aplicacion.datos.hibernate.dao.imp.AulasMateriasDAOImp;
import aplicacion.modelo.dominio.Asistencias;
import aplicacion.modelo.dominio.AulasMaterias;
import aplicacion.modelo.dominio.Docente;
import aplicacion.modelo.dominio.DocenteMateria;
import aplicacion.modelo.dominio.InscripcionAlumno;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * 
 */
@ManagedBean
@ViewScoped
public class AsistenciaFormBean implements Serializable {
    private DocenteMateria docenteMateria;
    private List<InscripcionAlumno> inscripcionAlumnos;
    private List<Asistencias> asistenciaMaterias;
    private List<AulasMaterias> aulaMaterias;
    
    @ManagedProperty(value = "#{asistenciaBean}")
    private AsistenciaBean asistenciaBean;
    
    @ManagedProperty(value = "#{materiaBean}")
    private MateriaBean materiaBean;
    
    @ManagedProperty(value = "#{aulaMateriaBean}")
    private AulasMateriasBean aulaMateriaBean;
    
    @ManagedProperty(value = "#{inscripcionAlumnoBean}")
    private InscripcionAlumnoBean inscripcionAlumnoBean;    
    /**
     * Creates a new instance of AsistenciaFormBean
     */
    public AsistenciaFormBean() {
        /*docenteMateria = obtenerDocenteMateria();*/
        
        inscripcionAlumnos = new ArrayList<>();
        asistenciaMaterias = new ArrayList<>();
        aulaMaterias = new ArrayList<>();
       
    }
    //registra la asistencia atravez del profesor.   
    public void registrarAsistenciaPorElProfesor() {
        
        asistenciaBean.getAsistencia().setAsiEstado(true);
        if (validarAsistencia() == true) {
            asistenciaBean.agregarAsistencia();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Asistencia Registrada","Asistencia Registrada");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage(null, mensaje);
            asistenciaBean.getAsistencia().setInscripcionesAlumnos(new InscripcionAlumno());
            asistenciaBean.getAsistencia().setAulasMaterias(new AulasMaterias());
            asistenciaBean.setAsistencia(new Asistencias());
            
        } else {
        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Su asistencia ya esta registrada","Su asistencia ya esta registrada");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, mensaje);
        }
    }
      
    
   //valida la aistencia en la base de datos de acuerdo a su fecha.
    public boolean validarAsistencia() {
        return asistenciaBean.validarAsistencia() == null;
    }
    
    
    public void modificarAsistencia() {
        
        asistenciaBean.modificarAsistencia();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"modificado", null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        asistenciaBean.setAsistencia(new Asistencias());
    }
    
   
    
    public void obtenerAulaMateriaPorDocenteMateria() {
        aulaMaterias = new ArrayList<>();
        AulasMateriasDAO aulaMateriaDAO = new AulasMateriasDAOImp();
        Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        for(Docente d : inscripcionAlumnoBean.getDocenteDao().obtenerTodoDocente())
        {
           
           if(d.getPerfil().getUsuario().getNombreUsuario().equals(usuario1.getNombreUsuario()))
           {
             for (AulasMaterias am: aulaMateriaDAO.obtenerTodoAulasMaterias()) {
                System.out.println("DocenteMateria: " + am.getDocentesMaterias().getCodigo());
                if (am.getDocentesMaterias().getCodigo() == docenteMateria.getCodigo()) {
                System.out.println("Aula agregado");
                aulaMaterias.add(am);
                
                }
              }
           }
        }
    }
    //obtine todos las inscripciones de la materia.
    public void obtenerAlumnosPorMateria() {
        inscripcionAlumnos = new ArrayList<>();
        
        System.out.println("DocenteMateria Seleccionado: " + docenteMateria.getCodigo());
        for (InscripcionAlumno i : inscripcionAlumnoBean.getInscripcionAlumnoDao().obtenerTodoInscripcion()) {
            System.out.println("DocenteMateria: " + i.getDocenteMateria());
            if (i.getDocenteMateria().getMateria().getCodigo() == docenteMateria.getMateria().getCodigo()) {
                System.out.println("Inscripcion agregado");
                inscripcionAlumnos.add(i);
            }
        }
    }
    
   
    //obtiene los docentematerias que tengan aulas asignadas y donde esta inscripto el ususario.
    public List<DocenteMateria> obtenerdocenteMaterias()
    {
        AulasMateriasDAO aulaMateriaDAO = new AulasMateriasDAOImp();
        List<DocenteMateria>docentem= new ArrayList<>();
      for(InscripcionAlumno i:inscripcionAlumnoBean.obtenerInscripcionesAlumno())
      {
        for(AulasMaterias a:aulaMateriaDAO.obtenerTodoAulasMaterias())
        {
          if(a.getDocentesMaterias().getCodigo()==i.getDocenteMateria().getCodigo())
          {
            docentem.add(a.getDocentesMaterias());
          }
        }
      }
    return docentem;
    }
    
  public void registrarAsistenciaporAlumno()
  {
   AulasMateriasDAO aulaMateriaDAO = new AulasMateriasDAOImp(); 
    for(InscripcionAlumno i:inscripcionAlumnoBean.obtenerInscripcionesAlumno())
      {
          if(i.getDocenteMateria().getCodigo()==docenteMateria.getCodigo())
          {
            asistenciaBean.getAsistencia().setInscripcionesAlumnos(i);
          }
      }
    for(AulasMaterias a:aulaMateriaDAO.obtenerTodoAulasMaterias())
    {
       if(a.getDocentesMaterias().getCodigo()== docenteMateria.getCodigo())
       {
         System.out.println("sdddddddddddddddddddssssssssssssssssssssssssssds");
         asistenciaBean.getAsistencia().setAulasMaterias(a);
       }
       
       
    }
     registrarAsistenciaPorElProfesor(); 
  
  }
   
    public void obtenerAsistenciaAlumnosPorDocenteMateria() {
        asistenciaMaterias = new ArrayList<>();
        AsistenciaDAO asistenciaDAO = new AsistenciaDAOImp();
        for (Asistencias a: asistenciaDAO.obtenerAsistencia()) {
            System.out.println("Agregado");
            if (a.getInscripcionesAlumnos().getDocenteMateria().getMateria().getCodigo() == docenteMateria.getMateria().getCodigo()) {
                System.out.println("Agregado");
                asistenciaMaterias.add(a);
            }
        }
      
    }
    
   
 
    public AsistenciaBean getAsistenciaBean() {
        return asistenciaBean;
    }

    /**
     *
     * @param asistenciaBean
     */
    public void setAsistenciaBean(AsistenciaBean asistenciaBean) {
        this.asistenciaBean = asistenciaBean;
    }

    /**
     *
     * @return
     */
    public MateriaBean getMateriaBean() {
        return materiaBean;
    }

    /**
     *
     * @param materiaBean
     */
    public void setMateriaBean(MateriaBean materiaBean) {
        this.materiaBean = materiaBean;
    }

    /**
     *
     * @return
  

    /**
     *
     * @return
     */
    public DocenteMateria getDocenteMateria() {
        return docenteMateria;
    }

    /**
     *
     * @param docenteMateria
     */
    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

    /**
     *
     * @return
     */
    public List<InscripcionAlumno> getInscripcionAlumnos() {
        return inscripcionAlumnos;
    }

    /**
     *
     * @param inscripcionAlumnos
     */
    public void setInscripcionAlumnos(List<InscripcionAlumno> inscripcionAlumnos) {
        this.inscripcionAlumnos = inscripcionAlumnos;
    }

   
   

    public List<Asistencias> getAsistenciaMaterias() {
        return asistenciaMaterias;
    }

    public void setAsistenciaMaterias(List<Asistencias> asistenciaMaterias) {
        this.asistenciaMaterias = asistenciaMaterias;
    }

    public List<AulasMaterias> getAulaMaterias() {
        return aulaMaterias;
    }

    public void setAulaMaterias(List<AulasMaterias> aulaMaterias) {
        this.aulaMaterias = aulaMaterias;
    }

    public AulasMateriasBean getAulaMateriaBean() {
        return aulaMateriaBean;
    }

    public void setAulaMateriaBean(AulasMateriasBean aulaMateriaBean) {
        this.aulaMateriaBean = aulaMateriaBean;
    }

    public InscripcionAlumnoBean getInscripcionAlumnoBean() {
        return inscripcionAlumnoBean;
    }

    public void setInscripcionAlumnoBean(InscripcionAlumnoBean inscripcionAlumnoBean) {
        this.inscripcionAlumnoBean = inscripcionAlumnoBean;
    }
    
}
