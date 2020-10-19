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
public class Grafo {
        private ListaEnlazadaVertices vertices;
        
        public Grafo(){
            vertices = new ListaEnlazadaVertices();
        }

        public void addVertice(int i, String categoria, String nombre, int latitud, int longitud ){        
            Vertice actual = existe(i);
            if(actual != null){
                System.out.println("Ya Existe");
                return;
            }
            Vertice nuevo = new Vertice(i, categoria, nombre, latitud, longitud);
            this.vertices.add(nuevo);
            System.out.println("Agregado");
        }
        
        public void enlazar(int a, int b){
            Vertice origen, destino;
            
            origen = existe(a);
            destino = existe(b);
            
            if(origen == null || destino == null){
                System.out.println("No se puede enlazar");
                return;
            }
            NodoArista nuevoDestino = new NodoArista(1, origen.getNumero(), destino.getNumero());
            NodoArista nuevoOrigen = new NodoArista(1, destino.getNumero(), origen.getNumero());
            
            origen.getAdyacentes().add(nuevoDestino);
            destino.getAdyacentes().add(nuevoOrigen);
        }
        
        public Vertice existe(int i){
            
            Vertice actual = this.vertices.getVertice(i);
            return actual;

        }
        
        public ListaEnlazadaVertices getListaVertices(){
            return this.vertices;
        }
        
        public void BFS(){
            
        }
        
        public void DFS(){
            
        }
        
        public void crearGrafica(){
            
        }
}
