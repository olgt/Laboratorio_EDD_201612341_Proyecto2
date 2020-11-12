/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Grafo;

import Estructura_Tabla_Hash.Table;
import Utilities.ListaEnlazada;
import Utilities.NodoTemp;

/**
 *
 * @author Oscar
 */
public class DijkstrasAlgorithm {

    private static final int NO_PARENT = -1;

    public DijkstrasAlgorithm() {

    }

    // Function that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented  using adjacency matrix representation 
    public double dijkstra(NodoArista[][] adjacencyMatrix, int startVertex, int nodoBuscado, ListaEnlazada lista) {
        int nVertices = adjacencyMatrix[0].length;
        // shortestDistances[i] will hold the shortest distance from src to i
        double[] shortestDistances = new double[nVertices];
        double[] precios = new double[nVertices];
        // added[i] will true if vertex i is included / in shortest path tree or shortest distance from src to i is finalized 
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            precios[vertexIndex] =  Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        // Distance of source vertex from itself is always 0 
        shortestDistances[startVertex] = 0;
        precios[startVertex] = 0;
        // Parent array to store shortest path tree 
        int[] parents = new int[nVertices];
        // The starting vertex does not have a parent 
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all  vertices 
        for (int i = 1; i < nVertices; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed. nearestVertex is always equal to startNode in  first iteration. 
            int nearestVertex = -1;
            double shortestDistance = Integer.MAX_VALUE;
            double precio = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                    precio = precios[vertexIndex];
                }
            }

            // Mark the picked vertex as processed 
            added[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex].getPeso();
                double precioActual = adjacencyMatrix[nearestVertex][vertexIndex].getPrecio();
                double edgePrice = adjacencyMatrix[nearestVertex][vertexIndex].getPrecio();
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    precios[vertexIndex] = precio + precioActual;
                }
                if (edgePrice > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    precios[vertexIndex] = precio + precioActual;
                }
            }
        }
        printSolution(startVertex, shortestDistances, parents);
        printSolutionPara(startVertex, shortestDistances, parents, nodoBuscado, lista);

        return precios[nodoBuscado];
    }

    // A utility function to print  
    // the constructed distances 
    // array and shortest paths 
    private void printSolution(int startVertex, double[] distances, int[] parents) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }

    // Function to print shortest path from source to currentVertex using parents array 
    private void printPath(int currentVertex, int[] parents) {
        // Base case : Source node has been processed 
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    //Metodos extras
    private int[] printSolutionPara(int startVertex, double[] distances, int[] parents, int idBuscado, ListaEnlazada lista) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                //printPath(vertexIndex, parents);

                if (vertexIndex == idBuscado) {
                    printPathPara(vertexIndex, parents, lista);
                }
            }
        }
        return parents;
    }

    private void printPathPara(int currentVertex, int[] parents, ListaEnlazada lista) {
        // Base case : Source node has been processed 
        if (currentVertex == NO_PARENT) {
            return;
        }
        
        printPathPara(parents[currentVertex], parents, lista);
        NodoTemp temp = new NodoTemp(currentVertex);
        lista.add(temp);

        System.out.print(currentVertex + " ");
    }
    
    public double dijkstra2(NodoArista[][] adjacencyMatrix, int startVertex, int nodoBuscado, ListaEnlazada lista, Table tabla) {
        int nVertices = adjacencyMatrix[0].length;
        // shortestDistances[i] will hold the shortest distance from src to i
        double[] shortestDistances = new double[nVertices];
        ListaEnlazada[] lista2 = new ListaEnlazada[nVertices];
        double[] precios = new double[nVertices];
        // added[i] will true if vertex i is included / in shortest path tree or shortest distance from src to i is finalized 
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            precios[vertexIndex] =  Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        // Distance of source vertex from itself is always 0 
        shortestDistances[startVertex] = 0;
        precios[startVertex] = 0;
        
        NodoTemp nuevoNodo = new NodoTemp(startVertex);
        lista2[startVertex].add(nuevoNodo);
        
        // Parent array to store shortest path tree 
        int[] parents = new int[nVertices];
        // The starting vertex does not have a parent 
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all  vertices 
        for (int i = 1; i < nVertices; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed. nearestVertex is always equal to startNode in  first iteration. 
            int nearestVertex = -1;
            double shortestDistance = Integer.MAX_VALUE;
            double precio = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                    precio = precios[vertexIndex];
                    
                }
            }

            // Mark the picked vertex as processed 
            added[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex].getPeso();
                double precioActual = adjacencyMatrix[nearestVertex][vertexIndex].getPrecio();
                double edgePrice = adjacencyMatrix[nearestVertex][vertexIndex].getPrecio();
                
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    precios[vertexIndex] = precio + precioActual;
                }
                if (edgePrice > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    precios[vertexIndex] = precio + precioActual;
                }
            }
        }
        printSolution(startVertex, shortestDistances, parents);
        printSolutionPara(startVertex, shortestDistances, parents, nodoBuscado, lista);

        return precios[nodoBuscado];
    }

    public double dijkstraPeso(NodoArista[][] adjacencyMatrix, int startVertex, int nodoBuscado, ListaEnlazada lista) {
        if(startVertex == nodoBuscado){
            return 0.0;
        }
        
        int nVertices = adjacencyMatrix[0].length;
        // shortestDistances[i] will hold the shortest distance from src to i
        double[] shortestDistances = new double[nVertices];
        double[] precios = new double[nVertices];
        // added[i] will true if vertex i is included / in shortest path tree or shortest distance from src to i is finalized 
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            precios[vertexIndex] =  Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        // Distance of source vertex from itself is always 0 
        shortestDistances[startVertex] = 0;
        precios[startVertex] = 0;
        // Parent array to store shortest path tree 
        int[] parents = new int[nVertices];
        // The starting vertex does not have a parent 
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all  vertices 
        for (int i = 1; i < nVertices; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed. nearestVertex is always equal to startNode in  first iteration. 
            int nearestVertex = -1;
            double shortestDistance = Integer.MAX_VALUE;
            double precio = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                    precio = precios[vertexIndex];
                }
            }

            // Mark the picked vertex as processed 
            added[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex].getPeso();
                double precioActual = adjacencyMatrix[nearestVertex][vertexIndex].getPrecio();
                double edgePrice = adjacencyMatrix[nearestVertex][vertexIndex].getPrecio();
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    precios[vertexIndex] = precio + precioActual;
                }
                if (edgePrice > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    precios[vertexIndex] = precio + precioActual;
                }
            }
        }
        printSolution(startVertex, shortestDistances, parents);
        printSolutionPara(startVertex, shortestDistances, parents, nodoBuscado, lista);

        return shortestDistances[nodoBuscado];
    }

    
    
}
