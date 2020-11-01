/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Estructura_Arbol_B.*;
import Estructura_Grafo.Grafo;
import Estructura_Grafo.ListaEnlazadaArista;
import Estructura_Grafo.ListaEnlazadaVertices;
import Estructura_Grafo.NodoArista;
import Estructura_Grafo.Vertice;
import Estructura_Tabla_Hash.NodeLugar;
import Estructura_Tabla_Hash.Table;
import GoogleMap.Mapa;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.MapViewOptions;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public class Metodos {

    public int ascii(String nombre) {
        int valorAscii = 0;

        char[] letters = nombre.toCharArray();
        for (char ch : letters) {
            valorAscii = +(byte) ch;
        }
        System.out.println(valorAscii);
        return valorAscii;
    }

    public void mostrarMapaRuta(Grafo grafo, ListaEnlazadaArista listaAristas, int idLugarInicio, Table tablaHash) {
        String apiKey = "AIzaSyAQIa8L5-4XCFJbFkKwlHoPu-7psnrEdJo";
        String apiKeyPrestada = "AIzaSyAR-xSrf5bYghVZDdfQ1F0Yk3nWpyViyig";

        MapViewOptions opciones = new MapViewOptions();
        opciones.importPlaces();
        opciones.setApiKey(apiKey);

        Mapa mapa = new Mapa(opciones);
        mapa.esperar();

        NodoArista actual = listaAristas.getHead();

        String arregloVertices[] = new String[listaAristas.getSize() + 1];
        LatLng arregloLongitudes[] = new LatLng[arregloVertices.length];
        int indice = 0;
        arregloVertices[indice] = actual.getVerticeA();
        indice++;

        while (actual != null) {
            arregloVertices[indice] = actual.getVerticeB();
            indice++;
            actual = actual.getSiguiente();
        }

        for (int i = 0; i < arregloVertices.length; i++) {
            if (arregloVertices[i] != null) {
                String nombreLugar = arregloVertices[i];
                NodeLugar nodoLugar = tablaHash.buscar(ascii(nombreLugar), nombreLugar);

                double lat = nodoLugar.getLat();
                double lon = nodoLugar.getLon();
                LatLng latlong1 = new LatLng(lat, lon);

                mapa.centrarEnUsuario(latlong1);
                mapa.agregarMarcador(latlong1);
            }
        }

        for (int i = 0; i < listaAristas.getSize(); i++) {
            ListaEnlazadaArista listaA = listaAristas;
            NodoArista actualA = listaAristas.getHead();

            while (actualA != null) {
                String idInicio = actualA.getVerticeA();
                String idFinal = actualA.getVerticeB();

                Vertice verticeInicio = grafo.existe(idInicio);
                Vertice verticeFinal = grafo.existe(idFinal);

                LatLng latlong1 = new LatLng(verticeInicio.getLatitud(), verticeInicio.getLongitud());
                LatLng latlong2 = new LatLng(verticeFinal.getLatitud(), verticeFinal.getLongitud());

                mapa.agregarLinea(latlong1, latlong2, true);
                actualA = actualA.getSiguiente();
            }

        }

        mapa.setVisible(true);

        JFrame frame = new JFrame("Mapa");
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(1000, 800);
        frame.add(mapa, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
