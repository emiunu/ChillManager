package model;

/**
 * Clase Serie que hereda de Actividad
 */
public class Serie extends Actividad {
    private String tipo;
    private int temporadas;
    private int capitulos;
    private int temporadaActual;
    private int capituloActual;

    /**
     * Constructor de la clase Serie
     * @param titulo El título de la serie
     * @param temporadas La cantidad de temporadas de la serie
     * @param capitulos La cantidad de capítulos de la serie
     * @param temporadaActual La temporada actual de la serie
     * @param capituloActual El capítulo actual de la serie
     * @param status El status de la serie, que está definido en la clase Estado
     * @param rating El rating de la serie, que va del 1 al 10
     * @param comentario El comentario de la serie
     */

    public Serie(String titulo, int temporadas, int capitulos, int temporadaActual, int capituloActual, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Serie";
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.temporadaActual = temporadaActual;
        this.capituloActual = capituloActual;
    }

    /**
     * Constructor vacío para poder crear los objetos desde el Json.
     */

    public Serie() {}

    // Getter y Setter

    /**
     * Método que entrega el tipo de la actividad, en este caso "serie"
     * @return El tipo de actividad
     */

    @Override
    public String getTipo() {
        return "Serie";
    }

    /**
     * Método que entrega la cantidad de temporadas de la serie
     * @return La cantidad de temporadas de la serie
     */

    public int getTemporadas() {
        return temporadas;
    }

    /**
     * Método que modifica la cantidad de temporadas de la serie
     * @param temporadas La nueva cantidad de temporadas de la serie
     */

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    /**
     * Método que entrega la cantidad de capítulos de la serie
     * @return La cantidad de capítulos de la serie
     */

    public int getCapitulos() {
        return capitulos;
    }

    /**
     * Método que modifica la cantidad de capítulos de la serie
     * @param capitulos La nueva cantidad de capítulos de la serie
     */

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    /**
     * Método que entrega la temporada actual de la serie
     * @return La temporada actual de la serie
     */

    public int getTemporadaActual() {
        return temporadaActual;
    }

    /**
     * Método que modifica la temporada actual de la serie
     * @param temporadaActual La nueva temporada actual de la serie
     */

    public void setTemporadaActual(int temporadaActual) {
        this.temporadaActual = temporadaActual;
    }

    /**
     * Método que entrega el capítulo actual de la serie
     * @return El capítulo actual de la serie
     */

    public int getCapituloActual() {
        return capituloActual;
    }

    /**
     * Método que modifica el capítulo actual de la serie
     * @param capituloActual El nuevo capítulo actual de la serie
     */

    public void setCapituloActual(int capituloActual) {
        this.capituloActual = capituloActual;
    }

    /**
     * Método que entrega la información de la serie
     * @return La información de la serie
     */

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + this.getTipo() +
                ", Temporadas totales: " + temporadas +
                ", Capítulos totales: " + capitulos +
                ", Temporada actual: " + temporadaActual +
                ", Capítulo actual: " + capituloActual;
    }
}