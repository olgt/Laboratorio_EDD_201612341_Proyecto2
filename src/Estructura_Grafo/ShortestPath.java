/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Grafo;

// A Java program for Dijkstra's single source shortest path algorithm. 
// The program is for adjacency matrix representation of the graph 
import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPath {

    // A utility function to find the vertex with minimum distance value, 
    // from the set of vertices not yet included in shortest path tree 
    int V;
    ListaEnlazadaVertices listaVertices;

    public ShortestPath(int dimension) {
        this.V = dimension;
    }

    double minDistance(double dist[], Boolean sptSet[]) {
        // Initialize min value
        double min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // A utility function to print the constructed distance array 
    void printSolution(double dist[], int idVertice) {
        System.out.println("Vertex   Distance/Cost from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " tt " + dist[i]);
        }
    }

    public double getCostFromVertex(double cost[], int idVertice) {
        return cost[idVertice];
    }

    // Function that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented using adjacency matrix 
    // representation 
    public void dijkstra(NodoArista graph[][], int src) {
        double dist[] = new double[V+1]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 

        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0 
        dist[src] = 0;

        // Find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = (int) minDistance(dist, sptSet);

            // Mark the picked vertex as processed 
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) // Update dist[v] only if is not in sptSet, there is an 
            // edge from u to v, and total weight of path from src to 
            // v through u is smaller than current value of dist[v] 
            {
                if (!sptSet[v] && graph[u][v].getPeso() != -1
                        && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v].getPeso() < dist[v]) {
                    dist[v] = dist[u] + graph[u][v].getPeso();
                }
            }
        }

        // print the constructed distance array 
        printSolution(dist, V);
    }

    public double dijkstraCosto(NodoArista graph[][], int src, int idVertice) {
        double costo[] = new double[V+1]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 
        
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) {
            costo[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0 
        costo[src] = 0;

        // Find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = (int) minDistance(costo, sptSet);

            // Mark the picked vertex as processed 
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) // Update dist[v] only if is not in sptSet, there is an 
            // edge from u to v, and total weight of path from src to 
            // v through u is smaller than current value of dist[v] 
            {
                if (!sptSet[v] && graph[u][v].getPeso() != -1
                        && costo[u] != Integer.MAX_VALUE && costo[u] + graph[u][v].getPeso() < costo[v]) {
                    costo[v] = costo[u] + graph[u][v].getPrecio();
                }
            }
        }

        // print the constructed distance array 
        printSolution(costo, V);
        return getCostFromVertex(costo, idVertice);
    }
    
    
    public ListaEnlazadaArista dijkstraArreglo(NodoArista graph[][], int src, int idVertice) {
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

            for (int v = 0; v < V; v++) 
            {
                if (!sptSet[v] && graph[u][v].getPeso() != -1 && costo[u] != Integer.MAX_VALUE && costo[u] + graph[u][v].getPeso() < costo[v]) {
                    costo[v] = costo[u] + graph[u][v].getPrecio();
                    NodoArista nodoNuevaLista = new NodoArista(graph[u][v].getId(), graph[u][v].getVerticeA(), graph[u][v].getVerticeB(), graph[u][v].getPrecio(), graph[u][v].getPeso(),
                            graph[u][v].getMoneda(), graph[u][v].getUnidad());
                            listaArista.add(nodoNuevaLista);
                }
            }
        }

        return listaArista;
    }
} 
