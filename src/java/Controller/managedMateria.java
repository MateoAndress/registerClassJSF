/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MateriaFacadeLocal;
import Entity.Materia;
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
public class managedMateria implements Serializable{
    
   @EJB
   private MateriaFacadeLocal materiaFacade;
   private List<Materia> listaMateria;
   private Materia materia;
   private String msj;

    public List<Materia> getListaMateria() {
        this.listaMateria = this.materiaFacade.findAll();
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
   
   @PostConstruct
   public void init(){
       this.materia = new Materia();
   }
   public void guardar() {
        try {
            this.materiaFacade.create(materia);
            this.msj = "Registro Creado Correctamente";
            this.materia = new Materia();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void actualizar() {
        try {
            this.materiaFacade.edit(materia);
            this.msj = "Registro Actualizado Correctamente";
            this.materia = new Materia();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Materia mate) {
        try {
            this.materiaFacade.remove(mate);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Materia ma) {
        this.materia = ma;
    }

    public void limpiar() {
        this.materia = new Materia();
    }
}