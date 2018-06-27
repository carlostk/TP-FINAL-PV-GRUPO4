/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.DocenteMateriaDAO;
import aplicacion.datos.hibernate.dao.MateriaDAO;
import aplicacion.datos.hibernate.dao.imp.DocenteMateriaDAOImp;
import aplicacion.datos.hibernate.dao.imp.MateriaDaoImp;
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
    
}
