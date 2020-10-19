/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleMap;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Oscar
 */
        
 /*
        {
  "Lugares": [
    {
      "id": 1,
      "Categoria": "USAC",
      "Nombre": "T-3",
      "Lat": 14.5877,
      "Lon": -90.5536
    },
    {
      "id": 2,
      "Categoria": "Plaza",
      "Nombre": "Plaza Villa nueva",
      "Lat": 14.533,
      "Lon": -90.5852
    },
    {
      "id": 3,
      "Categoria": "Gasolinera",
      "Nombre": "Gasolinera puma quetzal",
      "Lat": 14.536,
      "Lon": -90.5868
    }
  ]
}
        
        
        */

public class JsonFileOpener {
    JSONObject jsonFile;
    
    
    
    
    public JSONObject abrir(String resourceName) throws JSONException, ParseException{
        JSONParser parser = new JSONParser();
        
        try (Reader reader = new FileReader(resourceName)) {

            jsonFile = (JSONObject) parser.parse(reader);
            System.out.println(jsonFile);
            
        } catch (IOException | ParseException e) {
        }        
        return jsonFile;
    }
}
