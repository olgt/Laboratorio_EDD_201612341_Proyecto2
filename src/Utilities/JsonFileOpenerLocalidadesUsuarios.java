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
public class JsonFileOpenerLocalidadesUsuarios {
    private JSONObject jsonFile;
    int size;

    public JSONObject getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(JSONObject jsonFile) {
        this.jsonFile = jsonFile;
    }
    
    /*
    {
  "localidades": [
    {
      "id_usuario": 1,
      "id_lugar": 25
    },
    {
      "id_usuario": 2,
      "id_lugar": 24
    },
    */
    
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
    
    public long getIdUsuario(int index){
        long idUsuario;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("localidades");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        idUsuario = (long) jsonArray2.get("id_usuario");
        
        return idUsuario;
    }
    
    public long getIdLugar(int index){
        long lugarId;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("localidades");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarId = (long) jsonArray2.get("id_lugar");
        
        return lugarId;
    }
}
