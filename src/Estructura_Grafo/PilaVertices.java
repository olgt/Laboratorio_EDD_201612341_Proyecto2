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
public class PilaVertices {

    private int size;
    private Vertice head, tail;
    private Vertice siguiente;

    public void agregar(Vertice arista) {
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
        Vertice actual = this.head;
        Vertice temp = this.head;

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
    public Vertice getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Vertice head) {
        this.head = head;
    }

    /**
     * @return the siguiente
     */
    public Vertice getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Vertice siguiente) {
        this.siguiente = siguiente;

    }
}
