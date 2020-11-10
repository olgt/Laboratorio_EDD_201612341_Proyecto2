/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Oscar
 */
public class ListaEnlazada {

    private NodoTemp head;
    private NodoTemp tail;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(NodoTemp nuevo) {
        this.size = ++size;

        
        if (this.head == null) {
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            this.tail.setSiguiente(nuevo);
            this.tail.getSiguiente().setAnterior(this.tail);
            this.tail = nuevo;
            this.tail.setSiguiente(null);
        }
    }

    public NodoTemp searchNode(int id) {
        NodoTemp actual = this.head;

        if (this.head == null) {
            return null;
        } else {
            while (actual != null) {
                if (actual.getId() == id) {
                    return actual;
                }
                actual = actual.getSiguiente();
            }
        }
        return null;
    }

    public void recorrerLista() {
        NodoTemp actual = this.head;

        while (actual != null) {
            System.out.print("(" + actual.getId());

            actual = actual.getSiguiente();
        }
    }

    public NodoTemp getHead() {
        return this.head;
    }

    public NodoTemp getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }
}
