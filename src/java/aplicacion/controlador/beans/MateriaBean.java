/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;


import aplicacion.datos.hibernate.dao.CarreraDAO;
import aplicacion.datos.hibernate.dao.MateriaDAO;
import aplicacion.datos.hibernate.dao.imp.CarreraDaoImp;

import aplicacion.datos.hibernate.dao.imp.MateriaDaoImp;
import aplicacion.modelo.dominio.Carrera;

import aplicacion.modelo.dominio.Materia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class MateriaBean implements Serializable{

    private Materia materia;
    private MateriaDAO materiaDao;
    private String estado;
    private Carrera carrera;
    private List<Carrera> carreras;
    private CarreraDAO carreraDao;
    private List<Materia> materias;
  
   /* public MateriaBean() {
        materia = new Materia();
        materiaDao= new MateriaDaoImp();
        carreraDao=new CarreraDaoImp();
        carreras=carreraDao.obtenerTodoCarreras();
        carrera=new Carrera();
        materias=materiaDao.obtenerTodoMateria();
    }*/
    @PostConstruct
    public void init(){
       materia = new Materia();
       materiaDao= new MateriaDaoImp();
       carreraDao=new CarreraDaoImp();
       carrera=new Carrera();
       materias=materiaDao.obtenerTodoMateria();
       carreras=carreraDao.obtenerTodoCarreras();
       HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
       session.setAttribute("carreras", carreras);
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public MateriaDAO getMateriaDao() {
        return materiaDao;
    }

    public void setMateriaDao(MateriaDAO materiaDao) {
        this.materiaDao = materiaDao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public CarreraDAO getCarreraDao() {
        return carreraDao;
    }

    public void setCarreraDao(CarreraDAO carreraDao) {
        this.carreraDao = carreraDao;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
  
     public void registrarMateria()
   {
     
     if(estado.equals("h"))
      {
       
        materia.setEstado(true);
      }else
          {
            materia.setEstado(false);
          }
     materiaDao.agregarMateria(materia);
     materias=materiaDao.obtenerTodoMateria();
   }
    public void eliminarMateria(Materia materia)
    {
      materiaDao.eliminarMateria(materia);
      materias=materiaDao.obtenerTodoMateria();
    }
    
}
