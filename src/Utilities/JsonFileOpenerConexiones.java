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

    public Double getPeso(int index) {
        double peso = 0;
        double peso2 = 0;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        if (jsonArray2.get("peso") instanceof Long) {
            peso2 = ((Long) jsonArray2.get("peso")).doubleValue();
        } else if (jsonArray2.get("peso") instanceof Double) {
            peso2 = (Double) jsonArray2.get("peso");
        }
        
        return peso2;
    }

    public double getPrecio(int index) {
        double precio2 = 0;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        if (jsonArray2.get("precio") instanceof Long) {
            precio2 = ((Long) jsonArray2.get("precio")).doubleValue();
        } else if (jsonArray2.get("precio") instanceof Double) {
            precio2 = (Double) jsonArray2.get("precio");
        }
        
        return precio2;
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

        return valorAscii;

    }

    public void armarConexiones(Table tablasHash, Grafo grafo) {

        for (int i = 0; i < this.size; i++) {
            int ascii1 = getAscii(getInicio(i));
            int ascii2 = getAscii(getFinal(i));

            //(int i, String categoria, String nombre, int latitud, int longitud
            NodeLugar lugar1 = tablasHash.buscar(ascii1, getInicio(i));
            NodeLugar lugar2 = tablasHash.buscar(ascii2, getFinal(i));

            grafo.enlazar(i, lugar1.getNombre(), lugar2.getNombre(), (double) getPrecio(i), (double) getPeso(i), getMoneda(i), getUnidad(i));

        }
        grafo.crearMatrizAdyecencia(tablasHash);
    }
}
