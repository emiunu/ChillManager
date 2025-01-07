package model;

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

/**
  Clase abstracta que contiene los atributos comunes de las clases Juego, Libro, Pelicula y Serie.

 */
public abstract class Actividad { // Sus parámetros son los elementos comunes entre las clases
	private String titulo;
	private Estado status;
	private int rating;
	private String comentario;

	/**
	 * Constructor de la clase Actividad.
	 * @param titulo El título de la actividad
	 * @param status El status de la actividad, que está definido en la clase Estado
	 * @param rating El rating de la actividad, que va del 1 al 10
	 * @param comentario El comentario de la actividad
	 */
	public Actividad(String titulo, Estado status, int rating, String comentario) {
		this.titulo = titulo;
		this.status = status;
		this.rating = rating;
		this.comentario = comentario;
	}

	/**
	 * Constructor vacío para poder crear los objetos desde el Json.
	 */

	public Actividad(){}

	// Getter y Setter

	/**
	 * Método que entrega el tipo de la actividad.
	 * @return El tipo de actividad
	 */

	public abstract String getTipo();

	/**
	 * Método que entrega el título de la actividad.
	 * @return El título de la actividad
	 */

	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método que modifica el título de la actividad.
	 * @param titulo El nuevo título de la actividad
	 */

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Método que entrega el status de la actividad.
	 * @return El status de la actividad
	 */

	public Estado getStatus() {
		return status;
	}

	/**
	 * Método que modifica el status de la actividad.
	 * @param status El nuevo status de la actividad
	 */

	public void setStatus(Estado status) {
		this.status = status;
	}

	/**
	 * Método que entrega el rating de la actividad.
	 * @return El rating de la actividad
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Método que modifica el rating de la actividad.
	 * @param rating El nuevo rating de la actividad
	 */

	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Método que entrega el comentario de la actividad.
	 * @return El comentario de la actividad
	 */

	public String getComentario() {
		return comentario;
	}

	/**
	 * Método que modifica el comentario de la actividad.
	 * @param comentario El nuevo comentario de la actividad
	 */

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Método que entrega la información de la actividad.
	 * @return La información de la actividad
	 */

	@Override
	public String toString() {
		return "Actividad:\n" +
				"Título: " + titulo +
				", Estado: " + status +
				", Calificación: " + rating +
				", Comentario: " + comentario;
	}
}
