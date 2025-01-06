package data;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase estática que se encarga de leer y guardar archivos Json de Arraylist de objetos de tipo Actividad.
 * Diferenciando los constructores de las clases por medio del parámetro tipo.
 */
public class GestorDatos {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Lee un archivo JSON y lo convierte en una lista de objetos de la clase determinada por el parámetro clase.
     *
     * @param ubicacionArchivo La ubicación del archivo JSON.
     * @param clase La clase de los objetos que se van a leer.
     * @param <T> El tipo de los objetos que se van a leer.
     * @return Una lista de objetos de la clase determinada por el parámetro clase.
     */

    public static <T> ArrayList<T> leerJson(String ubicacionArchivo, Class<T> clase) {
        ArrayList<T> lista = new ArrayList<T>();
        try { // Lee el archivo y aplica el constructor determinado por el parametro tipo en el Json.
            lista = mapper.readValue(new File(ubicacionArchivo), mapper.getTypeFactory().constructCollectionType(ArrayList.class, clase));
        } catch (Exception e) { // Si no se puede leer el archivo, se muestra un mensaje de error.
            System.err.println("Error al leer el archivo en la ubicacion " + ubicacionArchivo + ": " + e.getMessage());
        }
        return lista;
    }

    /**
     * Guarda una lista de objetos en un archivo Json.
     *
     * @param listaAGuardar Lista de tipo ArrayList de objetos que se van a guardar.
     * @param ubicacionArchivo La ubicación del archivo Json.
     * @param <T> El tipo de los objetos que se van a guardar.
     */

    public static <T> void grabarJson(ArrayList<T> listaAGuardar, String ubicacionArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(ubicacionArchivo), listaAGuardar);
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo en la ubicacion " + ubicacionArchivo + ": " + e.getMessage());
        }
    }

}