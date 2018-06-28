/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.DocenteDAO;
import aplicacion.datos.hibernate.dao.DocenteMateriaDAO;
import aplicacion.datos.hibernate.dao.MateriaDAO;
import aplicacion.datos.hibernate.dao.imp.DocenteDaoImp;
import aplicacion.datos.hibernate.dao.imp.DocenteMateriaDAOImp;
import aplicacion.datos.hibernate.dao.imp.MateriaDaoImp;
import aplicacion.modelo.dominio.Docente;
import aplicacion.modelo.dominio.DocenteMateria;
import aplicacion.modelo.dominio.Materia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class DocenteMateriaBean implements Serializable {

    private DocenteMateria docenteMateria;
    private List<DocenteMateria> docentesMaterias;
    private DocenteMateriaDAO docenteMateriaDao;
    private Materia materia;
    private List<Materia> materias;
    private MateriaDAO materiaDao;
    private List<Docente> docentes;
    private DocenteDAO docenteDao;
    private String estado;
    public DocenteMateriaBean() {
    }
     @PostConstruct
    public void init(){
        materia = new Materia();
        docenteMateria = new DocenteMateria();
        materiaDao= new MateriaDaoImp();
        docenteMateriaDao= new DocenteMateriaDAOImp();
        materias=materiaDao.obtenerTodoMateria();
        docentesMaterias=docenteMateriaDao.obtenerTodoDocenteMateria();
        docenteDao=new DocenteDaoImp();
        docentes=docenteDao.obtenerTodoDocente();
        
    }

    public DocenteMateria getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

    public List<DocenteMateria> getDocentesMaterias() {
        return docentesMaterias;
    }

    public void setDocentesMaterias(List<DocenteMateria> docentesMaterias) {
        this.docentesMaterias = docentesMaterias;
    }

    public DocenteMateriaDAO getDocenteMateriaDao() {
        return docenteMateriaDao;
    }

    public void setDocenteMateriaDao(DocenteMateriaDAO docenteMateriaDao) {
        this.docenteMateriaDao = docenteMateriaDao;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public MateriaDAO getMateriaDao() {
        return materiaDao;
    }

    public void setMateriaDao(MateriaDAO materiaDao) {
        this.materiaDao = materiaDao;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public DocenteDAO getDocenteDao() {
        return docenteDao;
    }

    public void setDocenteDao(DocenteDAO docenteDao) {
        this.docenteDao = docenteDao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void registrarDocenteMateria()
    {
       if(estado.equals("h"))
      {
       
        docenteMateria.setHabilitado(true);
      }else
          {
            docenteMateria.setHabilitado(false);
          }
      docenteMateria.setEstado(false);
      docenteMateriaDao.agregarDocenteMateria(docenteMateria);
    }
    public void probar()
    {
      System.out.println("VALORR: "+docentes.get(0).getPerfil());
    }
}
