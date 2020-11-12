/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Grafo;

import Estructura_Tabla_Hash.NodeLugar;
import Estructura_Tabla_Hash.Table;

/**
 *
 * @author Oscar
 */
public class Grafo {

    private NodoArista[][] matrizAdyecencia;
    private ListaEnlazadaVertices vertices;

    public Grafo() {
        vertices = new ListaEnlazadaVertices();
    }

    public void addVertice(int i, String categoria, String nombre, double latitud, double longitud) {
        Vertice actual = existe(nombre);
        if (actual != null) {
            System.out.println("Ya Existe");
            return;
        }
        Vertice nuevo = new Vertice(i, categoria, nombre, latitud, longitud);
        this.vertices.add(nuevo);
        System.out.println("Agregado");
    }

    //(int id, int verticeOrigen, int verticeDestino, double precio, int peso, String moneda, String unidad)
    public void enlazar(int id, String a, String b, double precio, double peso, String moneda, String unidad) {
        Vertice origen, destino;
        origen = existe(a);
        destino = existe(b);
        if (origen == null || destino == null) {
            System.out.println("No se puede enlazar");
            return;
        } else {
            System.out.println("Agregando " + origen.getName() + "->" + destino.getName() + " a nodo " + origen.getName() + " y " + destino.getName());
        }
        NodoArista arista1 = new NodoArista(id, a, b, precio, peso, moneda, unidad);
        NodoArista arista2 = new NodoArista(id, b, a, precio, peso, moneda, unidad);
        origen.getAdyacentes().add(arista1, origen);
       
        destino.getAdyacentes().add(arista2, destino);
        String Destino = destino.getName();
        
        
        
    }

    public Vertice existe(String i) {
        Vertice actual = this.vertices.getVertice(i);
        return actual;
    }

    public ListaEnlazadaVertices getListaVertices() {
        return this.vertices;
    }

    public void djistra() {

    }

    public void BFS() {

    }

    public void DFS() {

    }

    public NodoArista[][] crearMatrizAdyecencia(Table tablaLugares) {
        int dimension = tablaLugares.getCarga();
        NodeLugar nuevoArreglo[] = llenarArreglo(tablaLugares);

        NodoArista graph[][] = new NodoArista[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            NodeLugar lugarActualX = nuevoArreglo[i];
            for (int j = 0; j < dimension; j++) {
                NodoArista encontrado = null;
                NodeLugar lugarActualY = nuevoArreglo[j];

                Vertice vertice1 = this.vertices.getVertice(lugarActualX.getNombre());
                Vertice vertice2 = this.vertices.getVertice(lugarActualY.getNombre());

                if (vertice1 != null && vertice2 != null) {
                    encontrado = vertice1.getAdyacentes().searchNode(vertice1.getName(), vertice2.getName());
                }
                if (encontrado != null) {
                    //poner peso de encontrado en tabla de adyecencia;

                    NodoArista nuevo = new NodoArista(encontrado.getId(), encontrado.getVerticeA(), encontrado.getVerticeB(), encontrado.getPrecio(),
                            encontrado.getPeso(), encontrado.getMoneda(), encontrado.getUnidad());
                    graph[i][j] = nuevo;
                } else {
                    NodoArista nuevo = new NodoArista(-1, "Nada", "Nada", -1, -1, "Nada", "Nada");
                    graph[i][j] = nuevo;
                }
            }
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(graph[i][j].getPeso() + " ");
            }
            System.out.println("");
        }

        this.matrizAdyecencia = graph;
        return graph;
    }

    public NodeLugar[] llenarArreglo(Table tablaLugares) {
        int j = 0;

        NodeLugar arreglo[] = tablaLugares.getArreglo();
        NodeLugar nuevoArreglo[] = new NodeLugar[arreglo.length];

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                nuevoArreglo[j] = arreglo[i];
                j++;
            }
        }

        return nuevoArreglo;
    }

    public void recorrer(Vertice verticeInicio, Vertice verticeB) {

    }

    public NodoArista[][] getMatriz() {
        return this.matrizAdyecencia;
    }



}
