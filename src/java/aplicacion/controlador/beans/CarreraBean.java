/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.CarreraDAO;
import aplicacion.datos.hibernate.dao.imp.CarreraDaoImp;
import aplicacion.modelo.dominio.Carrera;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author pc1
 */
@ManagedBean
@RequestScoped
public class CarreraBean implements Serializable{

    private Carrera carrera;
    private CarreraDAO carreraDao;
    private List<Carrera> carreras;
    private String estado;
    public CarreraBean() {
        carrera=new Carrera();
        carreraDao=new CarreraDaoImp();
        carreras=carreraDao.obtenerTodoCarreras();
    }

    public CarreraBean(Carrera carrera) {
        this.carrera = carrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public CarreraDAO getCarreraDao() {
        return carreraDao;
    }

    public void setCarreraDao(CarreraDAO carreraDao) {
        this.carreraDao = carreraDao;
    }


   

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    public void registrarCarrera()
    {
       if(estado.equals("h"))
      {
       
        carrera.setEstado(true);
      }else
          {
            carrera.setEstado(false);
          }
      carreraDao.agregarCarrera(carrera);
      carreras=carreraDao.obtenerTodoCarreras();
    }
    
    public boolean buscarCarrera(String buscado)
    {
        boolean encontrado=false;
        if(carreraDao.buscarCarrera(buscado)!=null)
        {
         carreras.clear();
         carreras.add(0, carreraDao.buscarCarrera(buscado));
         encontrado=true;
        }
        return encontrado;
    }
    public void eliminarCarrera(Carrera carrera)
    {
      carreraDao.eliminarCarrera(carrera);
      carreras=carreraDao.obtenerTodoCarreras();
    }
    
    
}
