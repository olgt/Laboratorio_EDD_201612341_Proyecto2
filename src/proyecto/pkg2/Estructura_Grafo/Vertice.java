/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2.Estructura_Grafo;

/**
 *
 * @author Oscar
 */
public class Vertice {
    private int numero;
    private ListaEnlazadaArista listaAristas;
    private Vertice siguiente, anterior;
    private String nombre, categoria;
    private int latitud, longitud;
    
    public Vertice(int numero, String categoria, String nombre, int latitud, int longitud){
        this.numero = numero;
        this.listaAristas = new ListaEnlazadaArista();
        this.nombre = nombre;
        this.categoria = categoria;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
    public String getName(){
        return this.nombre;
    }
    
    public int getLongitud(){
        return this.longitud;
    }
    
    public int getLatitud(){
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
