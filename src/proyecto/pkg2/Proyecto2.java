/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import Utilities.JsonFileOpenerLugares;
import com.teamdev.jxmaps.*;
import GoogleMap.*;
import java.awt.BorderLayout;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.json.simple.parser.ParseException;
import Estructura_Arbol_B.*;
import Estructura_Tabla_Hash.*;
import Utilities.*;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import Screens.*;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * @author Oscar
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PrincipalFrame principal = new PrincipalFrame();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setVisible(true);

        /*
        Table t = new Table(20);
        
        t.insertar(1, "Cat", "Nombre1ddd", 1, 2, 4);
        t.insertar(2, "Cat", "Nomb312resss", 1, 2, 2);
        t.insertar(3, "Cat", "Nombre123aaa1", 1, 2, 436);
        t.insertar(4, "Cat", "Nombre321fas", 1, 2, 412);
        t.insertar(5, "Cat", "Nombregfasdg412", 1, 2, 4198);
        t.insertar(6, "Cat", "Nombre412", 1, 2, 4135);
        t.insertar(7, "Cat", "jijiiji", 1, 2, 4235);
        t.insertar(8, "Cat", "Nomagsbre412", 1, 2, 45235);
        t.insertar(9, "Cat", "Nombrgasdge4a12", 1, 2, 4155);
        t.insertar(10, "Cat", "Nombre4fa12", 1, 2, 53235);
        t.insertar(11, "Cat", "Nombre41fs2", 1, 2, 23515);
        t.insertar(12, "Cat", "Nombrfase412", 1, 2, 9);
        t.insertar(13, "Cat", "Nombgasre412", 1, 2, 52845);
        t.insertar(14, "Cat", "Nombgasdrssde412", 1, 2, 8648);
        t.insertar(15, "Cat", "Nombgasdre41ss2", 1, 2, 888648);
        t.insertar(16, "Cat", "Nombre41fas2", 1, 2, 8648);

        NodeLugar hola;
        hola = t.buscar(4235, "jijiiji");
        if (hola != null) {
            System.out.println("Aqui " + hola.getNombre());
        } else{
            System.out.println("Nada");
        }

        for (int i = 0; i < 500; i++) {
            t.insertar(i, "Cat", "Nombre" + i, i, i, i);
        }
        t.graficar("test");
         */
 /*
        UbicacionesMapa nuevasUbicaciones = new UbicacionesMapa();
        nuevasUbicaciones.cargarUbicaciones(
                "C:\\Users\\Oscar\\Dropbox\\EDD_2020_2do_Semestre\\Proyecto 2\\filesTest\\Lugares.json",
                "C:\\Users\\Oscar\\Dropbox\\EDD_2020_2do_Semestre\\Proyecto 2\\filesTest\\Grafo.json"
        );
         */
 /*
        Grafo grafoActual = new Grafo();
        
        grafoActual.addVertice(1, "gas", "Vertice1", 1, 1);
        grafoActual.addVertice(2, "gas", "Vertice2", 2, 2);
        grafoActual.addVertice(3, "gas", "Vertice3", 3, 3);
        grafoActual.addVertice(4, "gas", "Vertice4", 4, 4);
        
        grafoActual.enlazar(1, 2);
        grafoActual.enlazar(2, 1);
        grafoActual.enlazar(1, 3);
        grafoActual.enlazar(4, 1);
        grafoActual.enlazar(2, 3);
        grafoActual.enlazar(5, 3);
        grafoActual.enlazar(4, 3);
        System.out.println(grafoActual.getListaVertices().getVertice(2).getLatitud());
        System.out.println(grafoActual.getListaVertices().getVertice(2).getLongitud());
        grafoActual.getListaVertices().recorrerLista();
         */
 /*
        *Se Utilizo la libreria de Google, Guava, y se procedio agregar el
        *archivo .jar. La cual nos facilita la creacion de un codigo Hash. 
         */
        //String sha256hex = Hashing.sha256().hashString("hola", StandardCharsets.UTF_8).toString();
        //System.out.println(sha256hex);
        //Resultado de Metodo =                       b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79
        //Resultado de calculadora de SHA256 Online = b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79

        /*
        nuevo2.abrir("C:\\Users\\Oscar\\Dropbox\\EDD_2020_2do_Semestre\\Proyecto 2\\filesTest\\Grafo.json");
        
        System.out.println("Conexiones:");
        System.out.println(nuevo2.getInicio(0));
        System.out.println(nuevo2.getFinal(0));
        System.out.println(nuevo2.getMoneda(0));
        System.out.println(nuevo2.getPeso(0));
        System.out.println(nuevo2.getUnidad(0));
        System.out.println(nuevo2.getPrecio(0));
        System.out.println(nuevo2.getNoItems());
         */
 /*
        try{
            URL rutaUrl = new URL(ruta);
            URLConnection conexion = rutaUrl.openConnection();
            conexion.setDoOutput(true);

            JSONTokener tokener = new JSONTokener(rutaUrl.openStream());
            JSONObject objeto = new JSONObject(tokener);
            JSONArray arreglo = (JSONArray) objeto.get("snappedPoints");
            path = new LatLng[arreglo.length()]; 
            
            for(int i = 0; i< arreglo.length(); i++){
                System.out.println("Coordenada " + (i +1));
                //System.out.println(arreglo.get(i));
                
                JSONObject lugar = (JSONObject) arreglo.get(i);
                JSONObject location = (JSONObject) lugar.get("location");
                
                //System.out.println(location.toString());
                
                double lat = Double.parseDouble(location.get("latitude").toString());
                double lng = Double.parseDouble(location.get("longitude").toString());
                
                System.out.println("("+lat+","+lng+")");
                path[i] = new LatLng(lat,lng);
            }
            
            
        } catch(Exception ex){
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE,null,ex);
        }
        mapa.agregarGrafo(path, true);
         */
        ArbolB<Integer, Integer> arbol = new ArbolB<>(5);
        /*9,24,25,1 y 2.
        arbol.insertar(9, 9);
        arbol.insertar(24, 24);
        arbol.insertar(25, 25);
        arbol.insertar(1, 1);
        arbol.insertar(2, 2);
        arbol.graficarArbol("test");
*/
        /*
        for (int i = 0; i <= 8; i++) {
            Usuario nuevo = new Usuario(i, "as", "f", "fd", "ontraseña", "telefono", "rol");
            arbol.insertar(i, nuevo);
        }

        System.out.println(arbol.getLastIndex(arbol.getRaiz()));
         */
        //arbol.graficarArbol("test");
        //arbol.imprimirArbol(arbol.getRaiz(), 1);
    }

}
