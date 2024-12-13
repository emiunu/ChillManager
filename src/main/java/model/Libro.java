package model;

public class Libro extends Actividad {
    private String tipo;
    private int isbn;
    private String autor;
    private int anno;

    public Libro(int isbn, String titulo, String autor, int anno, String status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Libro";
        this.isbn = isbn;
        this.autor = autor;
        this.anno = anno;
    }

    public Libro() {} // Constructor vacio para poder crear los objetos desde el Json

    //Getter y Setter

    @Override
    public String getTipo() {
        return "Libro";
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

}