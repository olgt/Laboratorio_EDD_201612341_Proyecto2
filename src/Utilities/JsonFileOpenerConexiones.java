/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

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
{
  "Grafo":[
    { "inicio":1,
      "final":2,
      "peso":3,
      "unidad":"KM",
      "precio": 35,
      "moneda":"Quetzales"
    },
    { "inicio":1,
      "final":3,
      "peso":10,
      "unidad":"KM",
      "precio": 110,
      "moneda":"Quetzales"
    },
    { "inicio":2,
      "final":3,
      "peso":5,
      "unidad":"KM",
      "precio": 50,
      "moneda":"Quetzales"
    }
  ]
}

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
    
    public int getNoItems(){
        return this.size;
    }
    
    public JSONObject abrir(String resourceName){
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
    
    public long getInicio(int index){
        long inicio;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        inicio = (long) jsonArray2.get("inicio");
        
        return inicio;
    }
    
    public long getFinal(int index){
        long idDestinoFinal;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        idDestinoFinal = (long) jsonArray2.get("final");
        
        return idDestinoFinal;
    }

    public long getPeso(int index){
        long peso;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        peso = (long) jsonArray2.get("peso");
        
        return peso;
    }
    
    public long getPrecio(int index){
        long precio;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        precio = (long) jsonArray2.get("precio");
        
        return precio;
    }
    
    
    public String getUnidad(int index){
        String unidad;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        unidad = (String) jsonArray2.get("unidad");
        
        return unidad;
    }
    
    public String getMoneda(int index){
        String moneda;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("Grafo");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        moneda = (String) jsonArray2.get("moneda");
        
        return moneda;
    }
}
