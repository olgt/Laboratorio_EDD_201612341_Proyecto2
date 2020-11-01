/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Grafo;

/**
 *
 * @author Oscar
 */
public class NodoAdyecencia {

    
    private int idLugar;
    private double peso;
    private double costo;

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    public NodoAdyecencia(int id, double peso) {
        this.idLugar = id;
        this.peso = peso;
    }

    /**
     * @return the idLugar
     */
    public int getId() {
        return idLugar;
    }

    /**
     * @param id the idLugar to set
     */
    public void setId(int id) {
        this.idLugar = id;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

}
