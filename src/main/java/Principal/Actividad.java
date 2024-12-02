package Principal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Por medio del parámetro tipo se determina qué constructor utilizar.

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Juego.class, name = "Juego"),
        @JsonSubTypes.Type(value = Libro.class, name = "Libro"),
        @JsonSubTypes.Type(value = Pelicula.class, name = "Pelicula"),
        @JsonSubTypes.Type(value = Serie.class, name = "Serie")
})

public abstract class Actividad { // Sus parámetros son los elementos comunes entre las clases
    private String titulo;
    private String status;
    private int rating;
    private String comentario;

    public Actividad(String titulo, String status, int rating, String comentario) {
        this.titulo = titulo;
        this.status = status;
        this.rating = rating;
        this.comentario = comentario;
    }

    public Actividad(){} // Constructor vacío para poder crear los objetos desde el Json

    // Getter y Setter

    public abstract String getTipo();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
