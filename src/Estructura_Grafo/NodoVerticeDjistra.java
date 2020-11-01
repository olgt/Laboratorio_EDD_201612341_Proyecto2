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
public class NodoVerticeDjistra {
     private int numero;
    private NodoVerticeDjistra siguiente, anterior;
    private String nombre, categoria;
    private double latitud, longitud;
    private boolean visitado;
    
    
    public NodoVerticeDjistra(int numero, String categoria, String nombre, double latitud, double longitud){
        this.numero = numero;
        this.nombre = nombre;
        this.categoria = categoria;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
    public boolean isVisitado(){
        return this.visitado;
    }
    
    public void setVisitado(boolean isVisitado){
        this.visitado = isVisitado;
    }
    
    public String getName(){
        return this.nombre;
    }
    
    public double getLongitud(){
        return this.longitud;
    }
    
    public double getLatitud(){
        return this.latitud;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    
    public NodoVerticeDjistra getSiguiente(){
        return this.siguiente;
    }
    
    public void setSiguiente(NodoVerticeDjistra nuevo){
        this.siguiente = nuevo;
    }
    
    public NodoVerticeDjistra getAnterior(){
        return this.anterior;
    }
    
    public void setAnterior(NodoVerticeDjistra nuevo){
        this.anterior = nuevo;
    }
    
    
    public void sobreEscribir(String nombre, int latitud, int longitud){
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }   
}
