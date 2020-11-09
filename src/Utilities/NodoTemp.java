/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Oscar
 */
public class NodoTemp {
    private int id;
    private NodoTemp siguiente;
    private NodoTemp anterior;

    public NodoTemp(int id){
        this.id = id;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the siguiente
     */
    public NodoTemp getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoTemp siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoTemp getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoTemp anterior) {
        this.anterior = anterior;
    }
    
    
}
