/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;
import Utilities.JsonFileOpenerLugares;
import proyecto.pkg2.Estructura_Grafo.*;
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
    public static void main(String[] args){      
        
        
        PrincipalFrame principal = new PrincipalFrame();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setVisible(true);
        
        
        /*UbicacionesMapa nuevasUbicaciones = new UbicacionesMapa();
        nuevasUbicaciones.cargarUbicaciones(
                "C:\\Users\\Oscar\\Dropbox\\EDD_2020_2do_Semestre\\Proyecto 2\\filesTest\\Lugares.json",
                "C:\\Users\\Oscar\\Dropbox\\EDD_2020_2do_Semestre\\Proyecto 2\\filesTest\\Grafo.json"
        );
        LoginScreen newLogin = new LoginScreen();
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
        
        //ArbolB<Integer, Integer> arbol = new ArbolB<>(5);
        //arbol.insertar(10,10);
        //arbol.insertar(11,11);
        //arbol.insertar(12,12);
        //arbol.insertar(14,14);
        //arbol.insertar(20,20);
        //arbol.insertar(16,16);
        
        //for(int i = 0; i<= 5; i++){
          //  arbol.insertar(i, i);
        //}
        
        
        //arbol.graficarArbol("test");
        //arbol.imprimirArbol(arbol.getRaiz(), 1);
    }   
           
}
