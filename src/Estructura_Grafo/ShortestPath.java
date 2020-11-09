/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Grafo;

import Estructura_Tabla_Hash.NodeLugar;
import Estructura_Tabla_Hash.Table;
import Utilities.Foo;
import Utilities.Metodos;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPath {

    int V;
    ListaEnlazadaVertices listaVertices;

    public ShortestPath(int dimension) {
        this.V = dimension;
    }

    double minDistance(double dist[], Boolean sptSet[]) {
        double min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void printSolution(double dist[], String nombreLugar, Table hash) {
        System.out.println("Vertex   Distance/Cost from Source");
        for (int i = 0; i < V; i++) {
            Metodos metodo = new Metodos();
            NodeLugar nodo = hash.buscar(metodo.ascii(nombreLugar), nombreLugar);
            System.out.println(nodo.getNombre() + " tt " + dist[i]);
        }
    }

    public double getCostFromVertex(double cost[], int idVertice) {
        return cost[idVertice];
    }

    public void dijkstra(NodoArista graph[][], int src, Table hash, String lugar) {
        double dist[] = new double[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = (int) minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v].getPeso() != -1
                        && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v].getPeso() < dist[v]) {
                    dist[v] = dist[u] + graph[u][v].getPeso();
                }
            }
        }

        printSolution(dist, lugar, hash);
    }

    public double dijkstraCosto(NodoArista graph[][], int src, int idVertice, Table hash, String lugar) {
        double costo[] = new double[V + 1];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            costo[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        costo[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = (int) minDistance(costo, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v].getPeso() != -1
                        && costo[u] != Integer.MAX_VALUE && costo[u] + graph[u][v].getPeso() < costo[v]) {
                    costo[v] = costo[u] + graph[u][v].getPrecio();
                }
            }
        }

        printSolution(costo, lugar, hash);
        return getCostFromVertex(costo, idVertice);
    }

    public ListaEnlazadaArista dijkstraArreglo(NodoArista graph[][], int src, String idVertice) {
        double costo[] = new double[V];
        Boolean sptSet[] = new Boolean[V];
        ListaEnlazadaArista listaArista = new ListaEnlazadaArista();

        for (int i = 0; i < V; i++) {
            costo[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        costo[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = (int) minDistance(costo, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v].getPeso() != -1 && costo[u] != Integer.MAX_VALUE && costo[u] + graph[u][v].getPrecio() < costo[v]) {
                    Vertice verticeprueba = null; //NO sirve para nada, eliminar

                    int id = graph[u][v].getId();
                    String verticeInicio = graph[u][v].getVerticeA();
                    String verticeFinal = graph[u][v].getVerticeB();
                    double precio = graph[u][v].getPrecio();
                    double peso = graph[u][v].getPeso();
                    String moneda = graph[u][v].getMoneda();
                    String unidad = graph[u][v].getUnidad();

                    costo[v] = costo[u] + graph[u][v].getPrecio();

                    NodoArista nodoNuevaLista = new NodoArista(id, verticeInicio, verticeFinal, precio, (int) peso, moneda, unidad);
                    listaArista.add(nodoNuevaLista, verticeprueba);

                }
            }
        }

        PilaAristas pila = new PilaAristas();
        Foo encontrado = new Foo();
        Camino(pila, listaArista.getHead(), idVertice, encontrado);

        return listaArista;
    }

    public PilaAristas CaminoMasCorto(NodoArista graph[][], int src, String idVertice, String lugarUsuario) {
        double costo[] = new double[V];
        Boolean sptSet[] = new Boolean[V];
        ListaEnlazadaArista listaArista = new ListaEnlazadaArista();

        for (int i = 0; i < V; i++) {
            costo[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        costo[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = (int) minDistance(costo, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v].getPeso() != -1 && costo[u] != Integer.MAX_VALUE && costo[u] + graph[u][v].getPrecio() < costo[v]) {
                    Vertice verticeprueba = null; //NO sirve para nada, eliminar

                    int id = graph[u][v].getId();
                    String verticeInicio = graph[u][v].getVerticeA();
                    String verticeFinal = graph[u][v].getVerticeB();
                    double precio = graph[u][v].getPrecio();
                    double peso = graph[u][v].getPeso();
                    String moneda = graph[u][v].getMoneda();
                    String unidad = graph[u][v].getUnidad();

                    costo[v] = costo[u] + graph[u][v].getPrecio();

                    NodoArista nodoNuevaLista = new NodoArista(id, verticeInicio, verticeFinal, precio, (int) peso, moneda, unidad);
                    listaArista.add(nodoNuevaLista, verticeprueba);

                }
            }
        }

        PilaAristas pila = new PilaAristas();
        Foo encontrado = new Foo();

        NodoArista temp = listaArista.getHead();
        while (temp != null) {
            if (temp.getVerticeA().equals(lugarUsuario)) {
                break;
            }
            temp = temp.getSiguiente();
        }

        Camino(pila, temp, idVertice, encontrado);

        return pila;
    }

    public PilaAristas Camino(PilaAristas pila, NodoArista arista, String VerticeEncontrar, Foo encontrado) {
        NodoArista aristaActual = arista;
        NodoArista aristaTemp = aristaActual;
        String verticePrev = arista.getVerticeA();

        pila.agregar(aristaActual);
        aristaActual = aristaActual.getSiguiente();

        if (aristaTemp.getVerticeB().equals(VerticeEncontrar)) {
            encontrado.is = true;
        }

        while (aristaActual != null) {
            if (verticePrev.equals(aristaActual.getVerticeB()) && encontrado.is == false) {
                Camino(pila, aristaActual, VerticeEncontrar, encontrado);
                if (encontrado.is != true) {
                    pila.pop();
                } else {
                    return pila;
                }
            } else {
                aristaActual = aristaActual.getSiguiente();
            }
        }
        return null;
    }

}
