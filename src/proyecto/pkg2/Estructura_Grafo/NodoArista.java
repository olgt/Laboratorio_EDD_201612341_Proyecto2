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
public class NodoArista {
    private int id, verticeOrigen, verticeDestino;
    private NodoArista siguiente, anterior;
    
    public NodoArista(int id, int verticeOrigen, int verticeDestino){
        this.id = id;
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
    }
    
    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getVerticeA(){
        return this.verticeOrigen;
    }

    public int getVerticeB(){
        return this.verticeDestino;
    }
    
    public void setVerticeA(int nuevoVertice){
        this.verticeOrigen = nuevoVertice;
    }
    
    public void setVerticeB(int nuevoVertice){
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
