package model;

public class Juego extends Actividad {
    private String tipo;
    private int fecha;
    private int dlc;

    public Juego(String titulo, int fecha, int dlc, String status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Juego";
        this.fecha = fecha;
        this.dlc = dlc;
    }

    public Juego() {} // Constructor vacio para poder crear los objetos desde el Json

    //Getter y Setter

    public String getTipo() {
        return tipo;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getDlc() {
        return dlc;
    }

    public void setDlc(int dlc) {
        this.dlc = dlc;
    }

}