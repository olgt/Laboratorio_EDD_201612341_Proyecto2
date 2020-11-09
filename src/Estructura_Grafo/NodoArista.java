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


public class NodoArista {


    public void setPrecio(double precio) {
        this.precio = precio;
    }
    private int id;
    private String verticeOrigen, verticeDestino;
    private NodoArista siguiente, anterior;
    private int peso;
    private String unidad;
    private String moneda;
    private double precio;
    
    public NodoArista(int id, String verticeOrigen, String verticeDestino, double precio, int peso, String moneda, String unidad){
        this.id = id;
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.moneda = moneda;
        this.precio = precio;
        this.unidad = unidad;
        this.peso = peso;
        this.siguiente = null;
        this.anterior = null;
    }
    

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getVerticeA(){
        return this.verticeOrigen;
    }

    public String getVerticeB(){
        return this.verticeDestino;
    }
    
    public void setVerticeA(String nuevoVertice){
        this.verticeOrigen = nuevoVertice;
    }
    
    public void setVerticeB(String nuevoVertice){
        this.verticeDestino = nuevoVertice;
    }
    
    public NodoArista getSiguiente(){
        return this.siguiente;
    }
    public NodoArista getAnterior(){
        return this.anterior;
    }
    public void setSiguiente(NodoArista nuevo){
        this.siguiente = nuevo;
    }
    
    public void setAnterior(NodoArista nuevo){
        this.anterior = nuevo;
    }
    
    
}
