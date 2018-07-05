/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.AulaDAO;
import aplicacion.datos.hibernate.dao.imp.AulaDAOImp;
import aplicacion.modelo.dominio.Aula;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pc-Yo
 */
@ManagedBean
@RequestScoped
public class AulaBean {

    private Aula aula;

    private AulaDAO aulaDAO;
    private String buscado;
    private List<Aula> aulas;

    public AulaBean() {
        aula = new Aula();
     
        aulaDAO = new AulaDAOImp();
        aulas = aulaDAO.obtenerTodoAula();
    }

    public AulaBean(Aula aula) {
        this.aula = aula;
    }


    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public AulaDAO getAulaDAO() {
        return aulaDAO;
    }

    public void setAulaDAO(AulaDAO aulaDAO) {
        this.aulaDAO = aulaDAO;
    }

    
    
    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

     public void registrarAula(){
       
      aulaDAO.agregarAula(aula);
      aulas=aulaDAO.obtenerTodoAula();
    }

    public void eliminarAula(Aula aula){
      aulaDAO.eliminarAula(aula);
      aulas=aulaDAO.obtenerTodoAula();
    }

     public void buscarAula()
    {
        if (aulaDAO.buscarAula(buscado) != null) {
            aulas.clear();
            aulas.add(0, aulaDAO.buscarAula(buscado));
        }
    }
     
}
