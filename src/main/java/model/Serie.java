package model;

public class Serie extends Actividad {
    private String tipo;
    private int temporadas;
    private int capitulos;
    private int temporadaActual;
    private int capituloActual;

    public Serie(String titulo, int temporadas, int capitulos, int temporadaActual, int capituloActual, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Serie";
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.temporadaActual = temporadaActual;
        this.capituloActual = capituloActual;
    }

    public Serie() {} // Constructor vacio para poder crear los objetos desde el Json

    // Getter y Setter

    @Override
    public String getTipo() {
        return "Serie";
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getTemporadaActual() {
        return temporadaActual;
    }

    public void setTemporadaActual(int temporadaActual) {
        this.temporadaActual = temporadaActual;
    }

    public int getCapituloActual() {
        return capituloActual;
    }

    public void setCapituloActual(int capituloActual) {
        this.capituloActual = capituloActual;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + tipo +
                ", Temporadas totales: " + temporadas +
                ", Capítulos totales: " + capitulos +
                ", Temporada actual: " + temporadaActual +
                ", Capítulo actual: " + capituloActual;
    }
}