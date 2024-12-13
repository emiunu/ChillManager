package model;

public class Pelicula extends Actividad {
    private String tipo;
    private int anno;
    private int duracion;

    public Pelicula(String titulo, int anno, int duracion, String status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Pelicula";
        this.anno = anno;
        this.duracion = duracion;
    }

    public Pelicula() {} // Constructor vacio para poder crear los objetos desde el Json

    //Getter y Setter

    @Override
    public String getTipo() {
        return "Peicula";
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

}