/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.AulasMateriasDAO;
import aplicacion.datos.hibernate.dao.imp.AulasMateriasDAOImp;

import aplicacion.modelo.dominio.AulasMaterias;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pc-Yo
 */
@ManagedBean
@ViewScoped
public class AulasMateriasBean {

    private AulasMaterias aulasMaterias;
    private AulasMateriasDAO aulasMateriasDAO;
    private String buscado;
    private List<AulasMaterias> aulasMateriasList;
    private String estado;
    private String horario[][] = new String[5][13];

    public AulasMateriasBean() {
        aulasMaterias = new AulasMaterias();
        aulasMateriasDAO = new AulasMateriasDAOImp();
        aulasMateriasList = aulasMateriasDAO.obtenerTodoAulasMaterias();
    }

    public String getEstado() {
        return estado;
    }

    public String[][] getHorario() {
        return horario;
    }

    public void setHorario(String[][] horario) {
        this.horario = horario;
    }

        
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public AulasMaterias getAulasMaterias() {
        return aulasMaterias;
    }

    public void setAulasMaterias(AulasMaterias aulasMaterias) {
        this.aulasMaterias = aulasMaterias;
    }

    public AulasMateriasDAO getAulasMateriasDAO() {
        return aulasMateriasDAO;
    }

    public void setAulasMateriasDAO(AulasMateriasDAO aulasMateriasDAO) {
        this.aulasMateriasDAO = aulasMateriasDAO;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    public List<AulasMaterias> getAulasMateriasList() {
        return aulasMateriasList;
    }

    public void setAulasMateriasList(List<AulasMaterias> aulasMateriasList) {
        this.aulasMateriasList = aulasMateriasList;
    }

    public void registrarAulasMaterias() {

        if (validarAulaDocente()) {
            aulasMaterias.setAmEstado(false);

            aulasMateriasDAO.agregarAulasMaterias(aulasMaterias);

            aulasMaterias = new AulasMaterias();

            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Guardado", "Guardado EXITO: "));
        }

    }

    public void eliminarAulasMaterias(AulasMaterias aulasMaterias) {
        aulasMateriasDAO.eliminarAulasMaterias(aulasMaterias);
        aulasMateriasList = aulasMateriasDAO.obtenerTodoAulasMaterias();
    }

    public void buscarAulasMaterias() {
        if (aulasMateriasDAO.buscarAulasMaterias(buscado) != null) {
            aulasMateriasList.clear();;
            aulasMateriasList.add(0, aulasMateriasDAO.buscarAulasMaterias(buscado));
        }
    }

    public boolean validarAulaDocente() {
        boolean aux = true;
        String mensaje = null;
        if (Integer.parseInt(aulasMaterias.getAmHorarioDesde()) != Integer.parseInt(aulasMaterias.getAmHorarioHasta())) {
            for (AulasMaterias aulasMat : aulasMateriasList) {
                if (aulasMat.getAulas().getAulCodigo() == aulasMaterias.getAulas().getAulCodigo()) {
                    if (aulasMat.getAmDia().equals(aulasMaterias.getAmDia())) {
                        if (Integer.parseInt(aulasMat.getAmHorarioDesde()) < Integer.parseInt(aulasMaterias.getAmHorarioHasta())
                                && Integer.parseInt(aulasMat.getAmHorarioHasta()) > Integer.parseInt(aulasMaterias.getAmHorarioDesde())) {
                            aux = false;
                            mensaje = "Horario No Valido";
                        }
                    }
                }
            }
            for (AulasMaterias aulasMat : aulasMateriasList) {
                if (aulasMat.getDocentesMaterias().getDocente().getCodigo() == aulasMaterias.getDocentesMaterias().getDocente().getCodigo()) {
                    if (aulasMat.getAmDia().equals(aulasMaterias.getAmDia())) {
                        if (Integer.parseInt(aulasMat.getAmHorarioDesde()) < Integer.parseInt(aulasMaterias.getAmHorarioHasta())
                                && Integer.parseInt(aulasMat.getAmHorarioHasta()) > Integer.parseInt(aulasMaterias.getAmHorarioDesde())) {
                            aux = false;
                            mensaje = "Docente Ocupado";
                        }
                    }
                }
            }
        } else {
            aux = false;
            mensaje = "Horario No Valido";
        }
        if (!aux) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(mensaje, mensaje));
        }
        return aux;
    }


}
