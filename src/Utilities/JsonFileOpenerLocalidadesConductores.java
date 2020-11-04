/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
{
  "localidades": [
    {
      "id_conductor": 1,
      "id_lugar": 25,
      "disponibilidad": true
    },
    {
      "id_conductor": 2,
      "id_lugar": 24,
      "disponibilidad": false
    }
  ]
}
*/
package Utilities;

import Estructura_Arbol_B.ArbolB;
import Estructura_Arbol_B.Usuario;
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
public class JsonFileOpenerLocalidadesConductores {
    private JSONObject jsonFile;
    int size;

    public JSONObject getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(JSONObject jsonFile) {
        this.jsonFile = jsonFile;
    }
    
    public JSONObject abrir(String resourceName){
        JSONParser parser = new JSONParser();
        
        try (Reader reader = new FileReader(resourceName)) {

            setJsonFile((JSONObject) parser.parse(reader));
            System.out.println(getJsonFile());
            
        } catch (IOException | ParseException e) {
        }        
        
        JSONArray array = (JSONArray) this.jsonFile.get("localidades");
        this.size = array.size();
        
        return getJsonFile();
    }
    
    public long getIdConductor(int index){
        long idConductor;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("localidades");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        idConductor = (long) jsonArray2.get("id_conductor");
        
        return idConductor;
    }
    
    public String getNombreLugar(int index){
        String lugarNombre;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("localidades");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarNombre = (String) jsonArray2.get("id_lugar");
        
        return lugarNombre;
    }

    public boolean getDisponibilidad(int index){
        boolean disponibilidad;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("localidades");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        disponibilidad = (boolean) jsonArray2.get("disponibilidad");
        
        return disponibilidad;
    }
    
    public void asignarLocalidadesConductores(ArbolB arbolConductores){
        
        
        for (int i = 0; i < this.size; i++) {
            int id = (int) getIdConductor(i);
            String nombreLugar = getNombreLugar(i);
            Boolean disponibilidad = getDisponibilidad(i);
            System.out.println(id);
            
            Foo encontrado = new Foo();
            Usuario nuevo = arbolConductores.encontrarUsuarioPorId(id, arbolConductores.getRaiz(), encontrado);
            
            if(nuevo != null){
                nuevo.setLugarActual(nombreLugar);
                System.out.println("Localidad Agregada");
                nuevo.setDisponible(disponibilidad);
                System.out.println("Disponiblidad agregada");
            }
        }
        
    }
}
