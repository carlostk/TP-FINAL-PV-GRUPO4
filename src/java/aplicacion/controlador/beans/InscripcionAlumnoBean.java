/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.AlumnoDAO;
import aplicacion.datos.hibernate.dao.DocenteDAO;
import aplicacion.datos.hibernate.dao.DocenteMateriaDAO;
import aplicacion.datos.hibernate.dao.InscripcionAlumnoDAO;
import aplicacion.datos.hibernate.dao.imp.AlumnoDAOImp;
import aplicacion.datos.hibernate.dao.imp.DocenteDaoImp;
import aplicacion.datos.hibernate.dao.imp.DocenteMateriaDAOImp;
import aplicacion.datos.hibernate.dao.imp.InscripcionAlumnoDaoImp;
import aplicacion.modelo.dominio.Alumno;
import aplicacion.modelo.dominio.Docente;
import aplicacion.modelo.dominio.DocenteMateria;
import aplicacion.modelo.dominio.InscripcionAlumno;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author pc1
 */
@ManagedBean
@ViewScoped
public class InscripcionAlumnoBean implements Serializable{

    private InscripcionAlumno inscripcionAlumno;
    private InscripcionAlumnoDAO inscripcionAlumnoDao;
    private List<InscripcionAlumno> inscripciones;
    private List<Alumno> alumnos;
    private DocenteDAO docenteDao;
    private DocenteMateriaDAO docenteMateriaDao;
    private AlumnoDAO alumnoDaoImp;
    
    public InscripcionAlumnoBean() {
        inscripcionAlumno= new InscripcionAlumno();
        inscripcionAlumnoDao=new InscripcionAlumnoDaoImp();
        inscripciones=inscripcionAlumnoDao.obtenerTodoInscripcion();
        alumnoDaoImp=new AlumnoDAOImp();
        alumnos=alumnoDaoImp.obtenerAlumnos();
        docenteMateriaDao=new DocenteMateriaDAOImp();
        docenteDao=new DocenteDaoImp();
    }

    public InscripcionAlumno getInscripcionAlumno() {
        return inscripcionAlumno;
    }

    public void setInscripcionAlumno(InscripcionAlumno inscripcionAlumno) {
        this.inscripcionAlumno = inscripcionAlumno;
    }

    public InscripcionAlumnoDAO getInscripcionAlumnoDao() {
        return inscripcionAlumnoDao;
    }

    public void setInscripcionAlumnoDao(InscripcionAlumnoDAO inscripcionAlumnoDao) {
        this.inscripcionAlumnoDao = inscripcionAlumnoDao;
    }

    public List<InscripcionAlumno> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionAlumno> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public AlumnoDAO getAlumnoDaoImp() {
        return alumnoDaoImp;
    }

    public void setAlumnoDaoImp(AlumnoDAO alumnoDaoImp) {
        this.alumnoDaoImp = alumnoDaoImp;
    }

    public DocenteMateriaDAO getDocenteMateriaDao() {
        return docenteMateriaDao;
    }

    public void setDocenteMateriaDao(DocenteMateriaDAO docenteMateriaDao) {
        this.docenteMateriaDao = docenteMateriaDao;
    }

    public DocenteDAO getDocenteDao() {
        return docenteDao;
    }

    public void setDocenteDao(DocenteDAO docenteDao) {
        this.docenteDao = docenteDao;
    }
    
    public void agregar()
    {
     Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
      for(Alumno a:alumnos)
      {
        if(a.getPerfil().getUsuario().getNombreUsuario().equals(usuario.getNombreUsuario()))
        {
          inscripcionAlumno.setAlumno(a);
          inscripcionAlumno.setEstado(true);
          inscripcionAlumnoDao.agregarInscripcion(inscripcionAlumno);
          inscripciones=inscripcionAlumnoDao.obtenerTodoInscripcion();
        }
      }
      
    }
    public void eliminar(InscripcionAlumno inscripcion){
      inscripcion.setEstado(false);
      inscripcionAlumnoDao.modificarInscripcion(inscripcion);
      inscripciones=inscripcionAlumnoDao.obtenerTodoInscripcion();
    }
    public List<InscripcionAlumno> obtenerInscripcionesProfesor() {
        List<InscripcionAlumno>inscrip= new ArrayList<>();
         System.out.println("HOLAAAAAAAAAA");
        Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        System.out.println("codigo"+usuario1.getNombreUsuario());
        for(Docente d : docenteDao.obtenerTodoDocente())
        {
           
           if(d.getPerfil().getUsuario().getNombreUsuario().equals(usuario1.getNombreUsuario()))
           {
              
              for(InscripcionAlumno i : inscripciones)
              {
                 if(i.getDocenteMateria().getDocente().getLegajo().equals(d.getLegajo()))
                 {
                   
                   inscrip.add(i);
                   
                 }
              }
           }
        }
        return inscrip;
    }
    public List<InscripcionAlumno> obtenerInscripcionesAlumno()
    {
      List<InscripcionAlumno>inscrip= new ArrayList<>();
      Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
       for(Alumno d : alumnoDaoImp.obtenerAlumnos())
        {
           
           if(d.getPerfil().getUsuario().getNombreUsuario().equals(usuario1.getNombreUsuario()))
           {
              
              for(InscripcionAlumno i : inscripciones)
              {
                  
                 if(i.getAlumno().getLibretaUniversitaria().equals(d.getLibretaUniversitaria()))
                 {
                   
                   inscrip.add(i);
                   
                 }
              }
           }
        }
       return inscrip;
    }
    public List<DocenteMateria> obtenerMateriasAlumno()
    {
      List<DocenteMateria>materias= new ArrayList<>();
      Usuario usuario1 = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
      for(Alumno d : alumnoDaoImp.obtenerAlumnos())
        {
           
           if(d.getPerfil().getUsuario().getNombreUsuario().equals(usuario1.getNombreUsuario()))
           {
              
              for(DocenteMateria i : docenteMateriaDao.obtenerTodoDocenteMateria())
              {
                 System.out.println("llegueeeeeeeeeeeee"+i.getMateria().getCarrera().getNombreCarrera());
                 if(i.getMateria().getCarrera().getNombreCarrera().equals(d.getCarrera().getNombreCarrera()))
                 {
                   
                   materias.add(i);
                   
                 }
              }
           }
        }
      return materias;
    }
    public boolean Buscar(DocenteMateria docenteMateria)
    {
      boolean buscado=false;
      for(InscripcionAlumno i:obtenerInscripcionesAlumno())
      {
        if(docenteMateria.getMateria().getCodigo()==i.getDocenteMateria().getMateria().getCodigo())
        {
          buscado=true;
        }
      }
      return buscado;
    }
}