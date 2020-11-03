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
public class ListaEnlazadaVertices {
    Vertice head, tail;
    private int size;
    
    public ListaEnlazadaVertices(){
        this.head = null;
        this.tail = null;
    }
    
    public void add(Vertice nuevo){
        if(this.head == null){
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            this.tail.setSiguiente(nuevo);
            this.tail.getSiguiente().setAnterior(this.tail);
            this.tail = nuevo;
        }
        this.size = ++size;
    }
    
    public void recorrerLista(){
        Vertice actual = this.head;
        
        while(actual != null){
            
            System.out.print("Vertice" + actual.getName());

            actual.getAdyacentes().recorrerLista();
            
            System.out.println();
            
            actual = actual.getSiguiente();
        }
    }
    
    
    public void delete(String id){
        Vertice actual = getVertice(id);
        
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
    
    public Vertice getVertice(String id){
        Vertice actual = this.head;
        
        if(this.head == null){
            return null;
        }
        else while(actual != null){
            if(id.equals(actual.getName())){
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public Vertice getHead(){
        return this.head;
    }
    
    public Vertice getTail(){
        return this.tail;
    }

    public int getSize(){
        return this.size;
    }

}
    