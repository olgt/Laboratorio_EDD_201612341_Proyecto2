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
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

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

    public void mostrarMapaRuta(Grafo grafo, ListaEnlazadaArista listaAristas, String idLugarInicio, Table tablaHash) {
        String apiKey = "AIzaSyAQIa8L5-4XCFJbFkKwlHoPu-7psnrEdJo";
        String apiKeyPrestada = "AIzaSyAR-xSrf5bYghVZDdfQ1F0Yk3nWpyViyig";

        MapViewOptions opciones = new MapViewOptions();
        opciones.importPlaces();
        opciones.setApiKey(apiKey);

        Mapa mapa = new Mapa(opciones);
        mapa.esperar();

        ListaEnlazadaArista listaVacia = null;
//        ListaEnlazadaArista listaCompleta, ListaEnlazadaArista listaVacia, NodoArista cabeza, String idDestino, String idComienzo, boolean encontrado, NodoArista parent)

        Foo testBooleano = new Foo();
        NodoArista actual = listaAristas.getHead();
        //NodoArista actual = getCamino(listaAristas, listaVacia, null, idLugarInicio, idLugarInicio, testBooleano, null).getHead();

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

    public void mostrarMapaRutaDjikstra(Grafo grafo, NodeLugar[] arrayLugares) {
        String apiKey = "AIzaSyAQIa8L5-4XCFJbFkKwlHoPu-7psnrEdJo";
        String apiKeyPrestada = "AIzaSyAR-xSrf5bYghVZDdfQ1F0Yk3nWpyViyig";

        MapViewOptions opciones = new MapViewOptions();
        opciones.importPlaces();
        opciones.setApiKey(apiKey);

        Mapa mapa = new Mapa(opciones);
        mapa.esperar();

        ListaEnlazadaArista listaVacia = null;
        int numeroDeVeces = 0;
        for (int i = 0; i < arrayLugares.length; i++) {
            if (arrayLugares[i] != null) {

                double lat = arrayLugares[i].getLat();
                double lon = arrayLugares[i].getLon();
                LatLng latlong1 = new LatLng(lat, lon);

                if (numeroDeVeces < 1) {
                    mapa.agregarMarcadorAzul(latlong1);
                    mapa.centrarEnUsuario(latlong1);
                    numeroDeVeces++;
                } else {
                    mapa.agregarMarcador(latlong1);
                }

            }
        }

        for (int i = 0; i < arrayLugares.length - 1; i++) {

            LatLng latlong1 = new LatLng(arrayLugares[i].getLat(), arrayLugares[i].getLon());
            LatLng latlong2 = new LatLng(arrayLugares[i + 1].getLat(), arrayLugares[i + 1].getLon());

            mapa.agregarLinea(latlong1, latlong2, true);
        }

        mapa.setVisible(true);
        JFrame frame = new JFrame("Mapa");
        frame.setLocationRelativeTo(null);
        frame.setSize(1000, 800);
        frame.add(mapa, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public ListaEnlazadaArista getCamino(ListaEnlazadaArista listaCompleta, ListaEnlazadaArista listaVacia, NodoArista cabeza,
            String idDestino, String idComienzo, Foo encontrado, NodoArista parent) {
        Vertice vertice = null;

        NodoArista actual = listaCompleta.getHead();

        while (actual != null) {

            if (actual.getVerticeA().equals(idComienzo) && actual != parent) {
                if (actual.getVerticeB().equals(idDestino)) {
                    listaVacia.add(actual, vertice);
                    encontrado.is = true;
                    return listaVacia;
                } else {
                    getCamino(listaCompleta, listaVacia, actual, idDestino, actual.getVerticeA(), encontrado, actual);
                }
            }
            getCamino(listaCompleta, listaVacia, actual, idDestino, actual.getVerticeB(), encontrado, actual);

            if (encontrado.is == false) {
                actual = actual.getSiguiente();
            } else {
                listaVacia.add(actual, vertice);
            }
        }

        return listaVacia;
    }

    public TableModel llenarJTable(ModeloTabla modelo, Page pagina, int k, Contador contador) {

        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();
        Viaje viajeActual;

        Key llaveActual = llaves[0];

        if (llaveActual != null) {
            viajeActual = (Viaje) llaveActual.getValor();
            int idViaje = viajeActual.getId();
            LocalDate fechaViaje = viajeActual.getFecha();

            if (llaveActual.getIzquierda() != null) {
                llenarJTable(modelo, llaveActual.getIzquierda(), k, contador);
            }

        }

        for (int i = 0; i < k; i++) {
            llaveActual = llaves[i];

            if (llaveActual != null) {
                viajeActual = (Viaje) llaveActual.getValor();
                int idViaje = viajeActual.getId();
                LocalDate fechaViaje = viajeActual.getFecha();

                modelo.getModel().setValueAt(idViaje, contador.getI(), 0);
                modelo.getModel().setValueAt(fechaViaje, contador.getI(), 1);
                contador.agregar();

                if (llaveActual.getDerecha() != null) {
                    llenarJTable(modelo, llaveActual.getDerecha(), k, contador);
                }
            }
        }
        return modelo.getModel();
    }

    public void graficarArbolBViajesFacturas(Page pagina, int k) {

        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();
        Usuario usuarioActual;

        Key llaveActual = llaves[0];

        if (llaveActual != null) {
            if (llaveActual.getIzquierda() != null) {
                graficarArbolBViajesFacturas(llaveActual.getIzquierda(), k);
            }
        }

        for (int i = 0; i < k; i++) {
            llaveActual = llaves[i];

            if (llaveActual != null) {
                usuarioActual = (Usuario) llaveActual.getValor();

                ArbolB viajeActual = usuarioActual.getViajes();
                ArbolB facturaActual = usuarioActual.getFacturas();

                if (viajeActual != null) {
                    viajeActual.graficarArbol("Viajes" + usuarioActual.getUsuario());
                }
                if (facturaActual != null) {
                    facturaActual.graficarArbol("Facturas" + usuarioActual.getUsuario());
                }

                if (llaveActual.getDerecha() != null) {
                    graficarArbolBViajesFacturas(llaveActual.getDerecha(), k);
                }
            }
        }
    }

    public int encontrarIndexDeNodo(NodoArista[][] graph, String lugarUsuario) {
        int i = 0;
        boolean encontrado = false;
        for (int j = 0; j < graph[0].length; j++) {
            i = j;
            for (int k = 0; k < graph[0].length; k++) {
                NodoArista nodo = graph[j][k];
                if (nodo.getVerticeA().equals(lugarUsuario)) {
                    encontrado = true;
                    break;
                }
            }
            if(encontrado == true){
                break;
            }
        }
        return i;
    }

    
}
