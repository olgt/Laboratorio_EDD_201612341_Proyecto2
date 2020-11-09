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
public class ListaEnlazadaArista {
    private NodoArista head;
    private NodoArista tail;
    private int size;
    
    public ListaEnlazadaArista(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(NodoArista nuevo, Vertice origen){
        this.size = ++size;
        NodoArista encontrado = searchNode(nuevo.getVerticeA(), nuevo.getVerticeB());

        nuevo.setId(size);
        
        if(this.head == null){
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            if(encontrado == null){
                this.tail.setSiguiente(nuevo);
                this.tail.getSiguiente().setAnterior(this.tail);
                this.tail = nuevo;
                this.tail.setSiguiente(null);
            } else {
                System.out.println("Enlace Ya existe");
            }
        }
    }
    
    public void delete(String origen, String destino){
        NodoArista actual = searchNode(origen, destino);
        
        if(actual != null){
            if(actual.getSiguiente() != null){
                actual.getSiguiente().setAnterior(actual.getAnterior());
            }
            if(actual.getAnterior() != null){
                actual.getAnterior().setSiguiente(actual.getSiguiente());                
            }
            actual = null;
        }
    }
    
    public NodoArista searchNode(String origen, String destino){
        NodoArista actual = this.head;
        
        if(this.head == null){
            return null;
        }
        else while(actual != null){
            if((origen.equals(actual.getVerticeA()) && destino.equals(actual.getVerticeB())) || 
                    (origen.equals(actual.getVerticeB()) && destino.equals(actual.getVerticeA()))){
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    public void recorrerLista(){
        NodoArista actual = this.head;
        
        while(actual != null){
            System.out.print("(" + actual.getVerticeA() + "-" + actual.getVerticeB() + ") - ");
            
            actual = actual.getSiguiente();
        }
    }
    
    public NodoArista getHead(){
        return this.head;
    }
    
    public NodoArista getTail(){
        return this.tail;
    }
    
    public int getSize(){
        return this.size;
    }
}
