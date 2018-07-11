/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.beans.DocenteBean;
import aplicacion.datos.hibernate.dao.DocenteDAO;
import aplicacion.datos.hibernate.dao.imp.DocenteDaoImp;
import aplicacion.modelo.dominio.Docente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Oscar
 */
@ManagedBean
@ViewScoped
public class ListaDocentesActivosFormBean implements Serializable {
    @ManagedProperty(value = "#{docenteBean}")
    private DocenteBean docenteBean;
    private List<Docente> docentesActivos ;
    private Docente copiaDeDocente ;
    /**
     * Creates a new instance of ListaDocentesActivosFormBean
     */
    public ListaDocentesActivosFormBean() {
        cargarListaDocentes();//Al iniciar carga con los docentes activados.
    }

    public ListaDocentesActivosFormBean(DocenteBean docenteBean, List<Docente> docentesactivos) {
        this.docenteBean = docenteBean;
        this.docentesActivos = docentesactivos;
    }

    public ListaDocentesActivosFormBean(DocenteBean docenteBean, List<Docente> docentesactivos, Docente copiaDeDocente) {
        this.docenteBean = docenteBean;
        this.docentesActivos = docentesactivos;
        this.copiaDeDocente = copiaDeDocente;
    }
    
    

    /**
     * @return the docenteBean
     */
    public DocenteBean getDocenteBean() {
        return docenteBean;
    }

    /**
     * @param docenteBean the docenteBean to set
     */
    public void setDocenteBean(DocenteBean docenteBean) {
        this.docenteBean = docenteBean;
    }

    /**
     * @return the docentesActivos
     */
    public List<Docente> getDocentesActivos() {
        return docentesActivos;
    }

    /**
     * @param docentesActivos the docentesActivos to set
     */
    public void setDocentesActivos(List<Docente> docentesActivos) {
        this.docentesActivos = docentesActivos;
    }

    /**
     * @return the copiaDeDocente
     */
    public Docente getCopiaDeDocente() {
        return copiaDeDocente;
    }

    /**
     * @param copiaDeDocente the copiaDeDocente to set
     */
    public void setCopiaDeDocente(Docente copiaDeDocente) {
        this.copiaDeDocente = copiaDeDocente;
    }

    /**
     * Se encarga de cargar la lista de docentes. En este caso los activos
     */
    public void cargarListaDocentes(){
        docentesActivos = new ArrayList<>();
        DocenteDAO docenteDAO = new DocenteDaoImp();
        docentesActivos = docenteDAO.obtenerDocentesPorEstado(true); //Con esto se obtiene la lista de docente activados
    }
    
    /**
     * Cambia el estado del docente selecciona a falso.
     * Entonces la tabla y la lista se actaulizan.
     * @param codigo 
     */
    public void desactivarDocente(String codigo){
        DocenteDAO docenteDAO = new DocenteDaoImp();
        Docente unDocente = docenteDAO.buscarDocentePorPorCodigo(codigo);
        unDocente.setEstado(false);
        docenteDAO.modificarDocente(unDocente);
        cargarListaDocentes(); //Vuelve a cargar la lista.
    }
    
}
