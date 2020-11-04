/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public String getLugar(int index){
        String lugarNombre;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("localidades");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);
        
        lugarNombre = (String) jsonArray2.get("id_lugar");
        
        return lugarNombre;
    }
    
    public void asignarLocalidadesUsuarios(ArbolB arbolUsuarios){
        
        
        for (int i = 0; i < this.size; i++) {
            int id = (int) getIdUsuario(i);
            String nombreLugar = getLugar(i);
            System.out.println(id);
            
            Foo encontrado = new Foo();
            Usuario nuevo = arbolUsuarios.encontrarUsuarioPorId(id, arbolUsuarios.getRaiz(), encontrado);
            
            if(nuevo != null){
                nuevo.setLugarActual(nombreLugar);
                System.out.println("Localidad Agregada");
            }
        }
        
    }
}
