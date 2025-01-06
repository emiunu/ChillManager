package model;

/**
 * Clase Libro que hereda de Actividad
 */
public class Libro extends Actividad {
    private String tipo;
    private int isbn;
    private String autor;
    private int anno;

    /**
     * Constructor de la clase Libro
     * @param isbn El isbn del libro
     * @param titulo El título del libro
     * @param autor El autor del libri
     * @param anno El año de salida del libro
     * @param status El status del libro, que está definido en la clase Estado
     * @param rating El rating del libro, que va del 1 al 10
     * @param comentario El comentario del libro
     */
    public Libro(int isbn, String titulo, String autor, int anno, Estado status, int rating, String comentario) {
        super(titulo, status, rating, comentario);
        this.tipo = "Libro";
        this.isbn = isbn;
        this.autor = autor;
        this.anno = anno;
    }

    /**
     * Constructor vacío para poder crear los objetos desde el Json.
     */
    public Libro() {}

    //Getter y Setter

    /**
     * Método que entrega el tipo de la actividad, en este caso "libro"
     * @return El tipo de actividad
     */

    @Override
    public String getTipo() {
        return "Libro";
    }

    /**
     * Método que entrega el isbn del libro
     * @return El isbn del libro
     */

    public int getIsbn() {
        return isbn;
    }

    /**
     * Método que modifica el isbn del libro
     * @param isbn El nuevo isbn del libro
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Método que entrega el autor del libro
     * @return El autor del libro
     */

    public String getAutor() {
        return autor;
    }

    /**
     * Método que modifica el autor del libro
     * @param autor El nuevo autor del libro
     */

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Método que entrega el año de salida del libro
     * @return El año de salida del libro
     */

    public int getAnno() {
        return anno;
    }

    /**
     * Método que modifica el año de salida del libro
     * @param anno El nuevo año de salida del libro
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }

    /**
     * Método que entrega la información del libro
     * @return La información del libro
     */

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: " + this.getTipo() +
                ", ISBN: " + isbn +
                ", Autor/a: " + autor +
                ", Año:" + anno;
    }
}