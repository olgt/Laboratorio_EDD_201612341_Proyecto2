/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;
import Estructura_Arbol_B.Usuario;
import Estructura_Grafo.Grafo;
import Estructura_Tabla_Hash.NodeLugar;
import Estructura_Tabla_Hash.Table;
import com.google.common.hash.Hashing;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonFileOpenerLugares {

    private JSONObject jsonFile;
    int size;

    public JSONObject getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(JSONObject jsonFile) {
        this.jsonFile = jsonFile;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public JSONObject abrir(String resourceName){
        JSONParser parser = new JSONParser();
        
        try (Reader reader = new FileReader(resourceName)) {

            setJsonFile((JSONObject) parser.parse(reader));
            System.out.println(getJsonFile());
            
        } catch (IOException | ParseException e) {
        }        
        
        
        JSONArray array = (JSONArray) this.jsonFile.get("Lugares");
        this.size = array.size();
        
        return getJsonFile();
    }
    
    public long lugarGetId(int index){
        long lugarId;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Lugares");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarId = (long) jsonArray2.get("id");
        
        return lugarId;
    }
    
    public String lugarGetNombre(int index){
        String lugarNombre;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Lugares");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarNombre = (String) jsonArray2.get("Nombre");
        
        return lugarNombre;
    }
    
    public String lugarGetCategoria(int index){
        String lugarCategoria;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Lugares");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarCategoria = (String) jsonArray2.get("Categoria");
        
        return lugarCategoria;
    }
    
    
    public double lugarGetLatitud(int index){
        double lugarLat;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Lugares");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarLat = (double) jsonArray2.get("Lat");
        
        return lugarLat;
    }
        
    public double lugarGetLongitud(int index){
        double lugarLon;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Lugares");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarLon = (double) jsonArray2.get("Lon");
        
        return lugarLon;
    }
            
    public void agregarHashTable(Table tabla, Grafo grafo){
        for (int i = 0; i < this.size; i++) {

            //(int id, String categoria, String nombre, double lat, double lon)
                    
            NodeLugar actual = new NodeLugar((int) lugarGetId(i), lugarGetCategoria(i), lugarGetNombre(i), lugarGetLatitud(i), lugarGetLongitud(i));
            grafo.addVertice((int) lugarGetId(i), lugarGetCategoria(i), lugarGetNombre(i), lugarGetLatitud(i), lugarGetLongitud(i));
            
            tabla.insertar((int) lugarGetId(i), lugarGetCategoria(i), lugarGetNombre(i), lugarGetLatitud(i), lugarGetLongitud(i), actual.getAscii());
        }
    }
    
}