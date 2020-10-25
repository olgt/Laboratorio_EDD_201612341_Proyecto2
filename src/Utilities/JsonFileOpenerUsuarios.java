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
import Estructura_Arbol_B.*;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Oscar
 */

/*
{
	"usuarios":[
  {
	 "id":25,
	 "nombre":"Michael Schumacher",
	 "usuario":"mschumacher",
	 "correo":"mschumacher@gmail.com",
	 "pass":"schumacher",
	 "telefono":"20201921",
	 "rol":"conductor"
  },
 */
public class JsonFileOpenerUsuarios {

    private JSONObject jsonFile;
    int size;

    public JSONObject getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(JSONObject jsonFile) {
        this.jsonFile = jsonFile;
    }

    public JSONObject abrir(String resourceName) {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(resourceName)) {

            setJsonFile((JSONObject) parser.parse(reader));
            System.out.println(getJsonFile());

        } catch (IOException | ParseException e) {
        }

        JSONArray array = (JSONArray) this.jsonFile.get("usuarios");
        this.size = array.size();

        return getJsonFile();
    }

    public long getId(int index) {
        long usuarioId;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        usuarioId = (long) jsonArray2.get("id");

        return usuarioId;
    }

    public String getNombre(int index) {
        String nombreUsuario;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        nombreUsuario = (String) jsonArray2.get("nombre");

        return nombreUsuario;
    }

    public String getNombreUsuario(int index) {
        String nombreUsuario;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        nombreUsuario = (String) jsonArray2.get("usuario");

        return nombreUsuario;
    }

    public String getCorreo(int index) {
        String correo;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        correo = (String) jsonArray2.get("correo");

        return correo;
    }

    public String getPass(int index) {
        String pass;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        pass = (String) jsonArray2.get("pass");

        return pass;
    }

    public String getTelefono(int index) {
        String telefono;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        telefono = (String) jsonArray2.get("telefono");

        return telefono;
    }

    public String getRol(int index) {
        String rol;
        JSONArray jsonArray1 = (JSONArray) this.jsonFile.get("usuarios");
        JSONObject jsonArray2 = (JSONObject) jsonArray1.get(index);

        rol = (String) jsonArray2.get("rol");

        return rol;
    }

    public void agregarArbolUsuarios(ArbolB arbolU, ArbolB arbolC) {

        for (int i = 0; i < this.size; i++) {
            String passwordEncrypted = Hashing.sha256().hashString(getPass(i), StandardCharsets.UTF_8).toString();

            Usuario actual = new Usuario((int) getId(i), getNombre(i), getNombreUsuario(i), getCorreo(i), passwordEncrypted, getTelefono(i), getRol(i));

            if (getRol(i).equals("conductor")) {
                arbolC.insertar((int) getId(i), actual);
            } else {
                arbolU.insertar((int) getId(i), actual);
            }
        }
    }

}
