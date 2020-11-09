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
public class PilaAristas {

    private int size;
    private NodoArista head, tail;
    private NodoArista siguiente;

    public void agregar(NodoArista arista) {
        if (this.head == null) {
            this.head = arista;
            this.tail = arista;
        } else {
            if (this.head == this.tail) {
                this.tail = arista;
            } else {
                this.tail.setSiguiente(arista);
            }
        }
    }

    public void pop() {
        NodoArista actual = this.head;
        NodoArista temp = this.head;

        if (this.head == null) {
            return;
        } else if (actual.getSiguiente() == null) {
            this.head = null;
            return;
        } else {
            while (actual != null) {
                actual = actual.getSiguiente();
                if (actual != temp.getSiguiente()) {
                    temp = temp.getSiguiente();
                }
            }
        }
        if (actual == null) {
            temp = null;
        }

    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the head
     */
    public NodoArista getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(NodoArista head) {
        this.head = head;
    }

    /**
     * @return the siguiente
     */
    public NodoArista getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoArista siguiente) {
        this.siguiente = siguiente;

    }
    
    public void recorrer(){
        NodoArista nodoActual = this.getHead();
        
        while(nodoActual != null){
            System.out.println("Nodo A: " + nodoActual.getVerticeA() + " -> " + nodoActual.getVerticeB());
        }
    }
}
