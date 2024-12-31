package model;

public class Juego extends Actividad {
    private String tipo;
    private int fecha;
    private int dlc;

    public Juego(String titulo, int fecha, int dlc, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Juego";
        this.fecha = fecha;
        this.dlc = dlc;
    }

    public Juego() {} // Constructor vacio para poder crear los objetos desde el Json

    //Getter y Setter

    @Override
    public String getTipo() {
        return "Juego";
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

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + tipo +
                ", Año: " + fecha +
                ", DLC's: " + dlc;
    }
}