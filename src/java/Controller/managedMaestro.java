/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MaestroFacadeLocal;
import Entity.Maestro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class managedMaestro implements Serializable{
    
    @EJB
    private MaestroFacadeLocal maestroFacade;
    private List<Maestro> listaMaestro;
    private Maestro maestro;
    private String msj;

    public List<Maestro> getListaMaestro() {
        this.listaMaestro = this.maestroFacade.findAll();
        return listaMaestro;
    }

    public void setListaMaestro(List<Maestro> listaMaestro) {
        this.listaMaestro = listaMaestro;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }
    
    @PostConstruct
    public void init(){
        this.maestro = new Maestro();
    }
    public void guardar() {
        try {
            this.maestroFacade.create(maestro);
            this.msj = "Registro Creado Correctamente";
            this.maestro = new Maestro();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void actualizar() {
        try {
            this.maestroFacade.edit(maestro);
            this.msj = "Registro Actualizado Correctamente";
            this.maestro = new Maestro();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Maestro meli) {
        try {
            this.maestroFacade.remove(meli);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Maestro me) {
        this.maestro = me;
    }

    public void limpiar() {
        this.maestro = new Maestro();
    }
}
