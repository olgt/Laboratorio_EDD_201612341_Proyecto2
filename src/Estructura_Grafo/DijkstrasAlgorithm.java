/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Grafo;

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
    public static ListaEnlazada dijkstra(NodoArista[][] adjacencyMatrix, int startVertex, int nodoBuscado, ListaEnlazada lista) {
        int nVertices = adjacencyMatrix[0].length;
        // shortestDistances[i] will hold the shortest distance from src to i
        int[] shortestDistances = new int[nVertices];
        // added[i] will true if vertex i is included / in shortest path tree or shortest distance from src to i is finalized 
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        // Distance of source vertex from itself is always 0 
        shortestDistances[startVertex] = 0;
        // Parent array to store shortest path tree 
        int[] parents = new int[nVertices];
        // The starting vertex does not have a parent 
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all  vertices 
        for (int i = 1; i < nVertices; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed. nearestVertex is always equal to startNode in  first iteration. 
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as processed 
            added[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex].getPeso();
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        int nuevo[] = printSolutionPara(startVertex, shortestDistances, parents,nodoBuscado-1, lista);
        for(int i = 0; i< nuevo.length; i++){
            NodoTemp temp = new NodoTemp(nuevo[nodoBuscado-1]+1);
            lista.add(temp);
        }
        
        return lista;
    }

    // A utility function to print  
    // the constructed distances 
    // array and shortest paths 
    private static void printSolution(int startVertex, int[] distances, int[] parents) {
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
    private static void printPath(int currentVertex, int[] parents) {
        // Base case : Source node has been processed 
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    //MEtodos extras
    private static int[] printSolutionPara(int startVertex, int[] distances, int[] parents, int idBuscado, ListaEnlazada lista) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);

                if (vertexIndex == idBuscado) {
                    return parents;
                }
            }
        }
        return parents;
    }

    private static void printPathPara(int currentVertex, int[] parents, ListaEnlazada lista) {
        // Base case : Source node has been processed 
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

}
