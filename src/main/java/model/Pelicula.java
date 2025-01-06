package model;
/**
 * Clase Pelicula que hereda de Actividad
 */

public class Pelicula extends Actividad {
    private String tipo;
    private int anno;
    private int duracion;

    /**
     * Constructor de la clase Pelicula
     * @param titulo El título de la película
     * @param anno El año de salida de la película
     * @param duracion La duración de la película (minutos)
     * @param status El status de la película, que está definido en la clase Estado
     * @param rating El rating de la película, que va del 1 al 10
     * @param comentario El comentario de la película
     */

    public Pelicula(String titulo, int anno, int duracion, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Pelicula";
        this.anno = anno;
        this.duracion = duracion;
    }

    /**
     * Constructor vacío para poder crear los objetos desde el Json.
     */
    public Pelicula() {}

    //Getter y Setter

    /**
     * Método que entrega el tipo de la actividad, en este caso "pelicula"
     * @return El tipo de actividad
     */

    @Override
    public String getTipo() {
        return "Pelicula";
    }

    /**
     * Método que entrega el año de salida de la película
     * @return El año de salida de la película
     */

    public int getAnno() {
        return anno;
    }

    /**
     * Método que modifica el año de salida de la película
     * @param anno El nuevo año de salida de la película
     */

    public void setAnno(int anno) {
        this.anno = anno;
    }

    /**
     * Método que entrega la duración de la película
     * @return La duración de la película
     */

    public int getDuracion() {
        return duracion;
    }

    /**
     * Método que modifica la duración de la película
     * @param duracion La nueva duración de la película
     */

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Método que entrega la información de la película
     * @return La información de la película
     */

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + tipo +
                ", Año: " + anno +
                ", Duracion:" + duracion;
    }
}