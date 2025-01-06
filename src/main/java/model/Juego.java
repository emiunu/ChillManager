package model;

/**
 * Clase Juego que hereda de Actividad
 */
public class Juego extends Actividad {
    private String tipo;
    private int fecha;
    private int dlc;

    /**
     * Constructor de la clase Juego
     * @param titulo El título del juego
     * @param fecha La fecha de salida del juego (año)
     * @param dlc La cantidad de DLC's que tiene el juego
     * @param status El status del juego, que está definido en la clase Estado
     * @param rating El rating del juego, que va del 1 al 10
     * @param comentario El comentario del juego
     */

    public Juego(String titulo, int fecha, int dlc, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Juego";
        this.fecha = fecha;
        this.dlc = dlc;
    }

    /**
     * Constructor vacío para poder crear los objetos desde el Json.
     */
    public Juego() {}

    //Getter y Setter

    /**
     * Método que entrega el tipo de la actividad, en este caso "juego"
     * @return El tipo de actividad
     */
    @Override
    public String getTipo() {
        return "Juego";
    }

    /**
     * Método que entrega la fecha de salida del juego
     * @return La fecha de salida del juego
     */
    public int getFecha() {
        return fecha;
    }

    /**
     * Método que modifica la fecha de salida del juego
     * @param fecha La nueva fecha de salida del juego
     */

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    /**
     * Método que entrega la cantidad de DLC's que tiene el juego
     * @return La cantidad de DLC's que tiene el juego
     */

    public int getDlc() {
        return dlc;
    }

    /**
     * Método que modifica la cantidad de DLC's que tiene el juego
     * @param dlc La nueva cantidad de DLC's que tiene el juego
     */

    public void setDlc(int dlc) {
        this.dlc = dlc;
    }

    /**
     * Método que entrega la información del juego
     * @return La información del juego
     */

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + this.getTipo() +
                ", Año: " + fecha +
                ", DLC's: " + dlc;
    }
}