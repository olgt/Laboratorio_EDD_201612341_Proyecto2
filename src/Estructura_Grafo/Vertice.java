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
public class Vertice {
    private int numero;
    private ListaEnlazadaArista listaAristas;
    private Vertice siguiente, anterior;
    private String nombre, categoria;
    private double latitud, longitud;
    private boolean visitado;
    
    public Vertice(int numero, String categoria, String nombre, double latitud, double longitud){
        this.numero = numero;
        this.listaAristas = new ListaEnlazadaArista();
        this.nombre = nombre;
        this.categoria = categoria;
        this.latitud = latitud;
        this.longitud = longitud;
        this.visitado = false;
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
    
    
    public Vertice getSiguiente(){
        return this.siguiente;
    }
    
    public void setSiguiente(Vertice nuevo){
        this.siguiente = nuevo;
    }
    
    public Vertice getAnterior(){
        return this.anterior;
    }
    
    public void setAnterior(Vertice nuevo){
        this.anterior = nuevo;
    }
    
    public ListaEnlazadaArista getAdyacentes(){
        return this.listaAristas;
    }

    public void sobreEscribir(String nombre, int latitud, int longitud){
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
