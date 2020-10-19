/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.ParseException;
import Estructura_Arbol_B.*;

/**
 *
 * @author Oscar
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String apiKey = "AIzaSyAQIa8L5-4XCFJbFkKwlHoPu-7psnrEdJo";
        String apiKeyPrestada = "AIzaSyAR-xSrf5bYghVZDdfQ1F0Yk3nWpyViyig";
        
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
        
        
        JsonFileOpener nuevo = new JsonFileOpener();
        try {
            nuevo.abrir("C:\\Users\\Oscar\\Dropbox\\EDD_2020_2do_Semestre\\Proyecto 2\\filesTest\\Lugares.json");
        } catch (JSONException ex) {
            Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArbolB<Integer, Integer> arbol = new ArbolB<>(5);
        for(int i = 0; i< 10; i++){
            arbol.insertar(i, i);
        }
        
        /*
        MapViewOptions opciones = new MapViewOptions();
        opciones.importPlaces();
        opciones.setApiKey(apiKey);
        
        Mapa mapa = new Mapa(opciones);
        
        LatLng[] path = new LatLng[2];
        String coordenada = "14.589315,-90.551978|14.588744,-90.553809";
        String ruta = "https://roads.googleapis.com/v1/snapToRoads?path="+coordenada+"&interpolate=true&key=AIzaSyAR-xSrf5bYghVZDdfQ1F0Yk3nWpyViyig";
        
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
                System.out.println(arreglo.get(i));
                
                JSONObject lugar = (JSONObject) arreglo.get(i);
                JSONObject location = (JSONObject) lugar.get("location");
                
                System.out.println(location.toString());
                
                double lat = Double.parseDouble(location.get("latitude").toString());
                double lng = Double.parseDouble(location.get("longitude").toString());
                
                System.out.println("("+lat+","+lng+")");
                path[i] = new LatLng(lat,lng);
            }
            
            
        } catch(Exception ex){
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE,null,ex);
        }
        mapa.agregarGrafo(path, true);

        
        JFrame frame = new JFrame("Mapa");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(1000, 800);
        frame.add(mapa, BorderLayout.CENTER);
        frame.setVisible(true);
        */
        
        
        
        
    }
    
    
}
