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
public class ListaEnlazadaArista {
    private NodoArista head;
    private NodoArista tail;
    private int size;
    
    ListaEnlazadaArista(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(NodoArista nuevo){
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
            } else {
                System.out.println("Enlace Ya existe");
            }
        }
    }
    
    public void delete(int origen, int destino){
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
    
    public NodoArista searchNode(int origen, int destino){
        NodoArista actual = this.head;
        
        if(this.head == null){
            return null;
        }
        else while(actual != null){
            if((origen == actual.getVerticeA() && destino == actual.getVerticeB()) || (origen == actual.getVerticeB() && destino == actual.getVerticeA())){
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
