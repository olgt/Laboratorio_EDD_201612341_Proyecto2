/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Tabla_Hash;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Oscar
 */
public class Table {

    private NodeLugar arreglo[];
    private int size; //tamanio
    private int carga; //elementos ingresados

    public Table(int size) {
        this.size = size;
        arreglo = new NodeLugar[size];
        this.carga = 0;
        for (int i = 0; i < size; i++) {
            arreglo[i] = null;
        }
    }

    public void insertar(int id, String categoria, String nombre, double lat, double lon, int ascii) {
        NodeLugar nuevoNodo = new NodeLugar(id, categoria, nombre, lat, lon);

        int pos = posicion(ascii, nombre);
        this.arreglo[pos] = nuevoNodo;
        this.carga++;

        if (((carga * 100) / this.size) > 75) {
            int sizeNuevo = size;

            do {
                sizeNuevo++;
            } while (((carga * 100 / sizeNuevo)) > 30);

            sizeNuevo = (sizeNuevo % 2) == 0 ? sizeNuevo + 1 : sizeNuevo;

            NodeLugar nuevoArray[] = new NodeLugar[sizeNuevo];
            NodeLugar antiguo[] = arreglo;
            this.arreglo = nuevoArray;

            this.size = sizeNuevo;

            int aux = 0;

            for (NodeLugar n : antiguo) {
                if (n != null) {
                    aux = posicion(n.getAscii(), n.getNombre());
                    nuevoArray[aux] = n;
                }
            }

        }

    }

    private int posicion(int clave, String nombre) {
        int i = 0, p = 0;

        p = (int) (clave % this.size);

        while (arreglo[p] != null && !arreglo[p].getNombre().equals(nombre)) {
            i++;
            p = (int) (clave % this.size);
            p = p + i;
            p = (p >= size) ? p - size : p;
        }
        return p;
    }

    public NodeLugar buscar(int ascii, String nombre) {
        NodeLugar buscado = null;

        int pos = posicionBuscada(ascii, nombre);
        System.out.println("Posicion " + pos);
        if (pos != -1) {
            buscado = this.arreglo[pos];
        }

        return buscado;
    }

    public int posicionBuscada(int ascii, String nombre) {
        int i = 0, p, vueltas = 0;

        p = (int) (ascii % this.size);

        for (i = p; i < this.size; i++) {
            if (arreglo[i] != null && arreglo[i].getNombre().equals(nombre)) {
                return i;
            } else if (vueltas > 1) {
                return -1;
            } else {
                if (i == this.size - 1 && vueltas < 1) {
                    i = 0;
                    vueltas++;
                }
            }
        }
        return i;
    }

    public void graficar(String nombre) {

        try {
            FileWriter myWriter = new FileWriter("graficas\\HashTable" + nombre + ".gv");
            myWriter.write("digraph g {" + "\n");
            myWriter.write("node [shape = record,height=.1]; \n");

            int a = 1, n = 0, contador = 0;
            boolean termino = false;

            myWriter.write("node" + n + "[label=\"");

            for (NodeLugar t : this.arreglo) {
                if (a == 10) {
                    String text = t != null ? Integer.toString(t.getId()) : "";
                    text = text + "\"];\n";
                    myWriter.write(text);
                    a = 1;
                    n++;
                    if (contador == size - 1) {
                        termino = true;
                        break;
                    }
                    myWriter.write("node" + n + "[label=\"");
                    continue;
                } else {
                    String text = t != null ? Integer.toString(t.getId()) : "";
                    text = text + "|";
                    myWriter.write(text);
                }
                a++;
                contador++;
            }

            if (!termino) {
                String text = "carga: " + carga + " size: " + size + "\"]\n";
                myWriter.write(text);

            }

            for (int i = 0; i < n; i++) {
                String text = "node" + i + "->node" + (i + 1) + "[style=\"invis\"]" + "\n";
                myWriter.write(text);
            }

            myWriter.write("}" + "\n");
            myWriter.close();

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "dot -Tpdf graficas\\HashTable" + nombre + ".gv -o graficas\\HashTable" + nombre + ".pdf");
            ProcessBuilder builder2 = new ProcessBuilder("cmd.exe", "/c", "graficas\\HashTable" + nombre + ".pdf");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            Process open = builder2.start();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
