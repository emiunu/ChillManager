package data;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GestorDatos {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> ArrayList<T> leerJson(String ubicacionArchivo, Class<T> clase) {
        ArrayList<T> lista = new ArrayList<T>();
        try { // Lee el archivo y aplica el constructor determinado por el parametro tipo en el Json.
            lista = mapper.readValue(new File(ubicacionArchivo), mapper.getTypeFactory().constructCollectionType(ArrayList.class, clase));
        } catch (Exception e) { // Si no se puede leer el archivo, se muestra un mensaje de error.
            System.err.println("Error al leer el archivo en la ubicacion " + ubicacionArchivo + ": " + e.getMessage());
        }
        return lista;
    }

    public static <T> void grabarJson(ArrayList<T> listaAGuardar, String ubicacionArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(ubicacionArchivo), listaAGuardar);
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo en la ubicacion " + ubicacionArchivo + ": " + e.getMessage());
        }
    }

}