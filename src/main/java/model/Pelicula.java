package model;

public class Pelicula extends Actividad {
    private String tipo;
    private int anno;
    private int duracion;

    public Pelicula(String titulo, int anno, int duracion, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Pelicula";
        this.anno = anno;
        this.duracion = duracion;
    }

    public Pelicula() {} // Constructor vacio para poder crear los objetos desde el Json

    //Getter y Setter

    @Override
    public String getTipo() {
        return "Pelicula";
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + tipo +
                ", Año: " + anno +
                ", Duracion:" + duracion;
    }
}