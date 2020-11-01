/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Estructura_Grafo.Grafo;
import Estructura_Grafo.ShortestPath;
import Estructura_Tabla_Hash.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Oscar
 */

/*
 */
public class JsonFileOpenerConexiones {

    private JSONObject jsonFile;
    int size;

    public JSONObject getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(JSONObject jsonFile) {
        this.jsonFile = jsonFile;
    }

    public int getNoItems() {
        return this.size;
    }

    public JSONObject abrir(String resourceName) {
        JSONParser parser = new JSONParser();
        int noItems = 0;

        try (Reader reader = new FileReader(resourceName)) {

            setJsonFile((JSONObject) parser.parse(reader));
            System.out.println(getJsonFile());

        } catch (IOException | ParseException e) {
        }
        JSONArray array = (JSONArray) this.jsonFile.get("Grafo");

        this.size = array.size();

        return getJsonFile();
    }

    public String getInicio(int index) {
        String inicio;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        inicio = (String) jsonArray2.get("inicio");

        return inicio;
    }

    public String getFinal(int index) {
        String idDestinoFinal;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        idDestinoFinal = (String) jsonArray2.get("final");

        return idDestinoFinal;
    }

    public long getPeso(int index) {
        long peso;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        peso = (long) jsonArray2.get("peso");

        return peso;
    }

    public long getPrecio(int index) {
        long precio;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        precio = (long) jsonArray2.get("precio");

        return precio;
    }

    public String getUnidad(int index) {
        String unidad;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        unidad = (String) jsonArray2.get("unidad");

        return unidad;
    }

    public String getMoneda(int index) {
        String moneda;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        moneda = (String) jsonArray2.get("moneda");

        return moneda;
    }

    public int getAscii(String nombre) {
        int valorAscii = 0;

        char[] letters = nombre.toCharArray();
        for (char ch : letters) {
            valorAscii = +(byte) ch;
        }
        System.out.println(valorAscii);
        return valorAscii;

    }

    public void armarConexiones(Table tablasHash, Grafo grafo) {

        for (int i = 0; i < this.size; i++) {
            int ascii1 = getAscii(getInicio(i));
            int ascii2 = getAscii(getFinal(i));
            
            //(int i, String categoria, String nombre, int latitud, int longitud
            NodeLugar lugar1 = tablasHash.buscar(ascii1, getInicio(i));
            NodeLugar lugar2 = tablasHash.buscar(ascii2, getFinal(i));
            
            grafo.enlazar(i, lugar1.getNombre(), lugar2.getNombre(), (double) getPrecio(i), (int) getPeso(i), getMoneda(i), getUnidad(i));
        }
        grafo.crearMatrizAdyecencia(tablasHash);
    }
}
