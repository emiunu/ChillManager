package Principal;

public class Pelicula {

	private String titulo;
	private int anno;
	private String genero;
	private int duracion;
	private String status;
	private int rating;
	private String comentario;

	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnno() {
		return this.anno;
	}

	/**
	 * 
	 * @param anno
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getGenero() {
		return this.genero;
	}

	/**
	 * 
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return this.duracion;
	}

	/**
	 * 
	 * @param duracion
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public int getRating() {
		return this.rating;
	}

	/**
	 * 
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComentario() {
		return this.comentario;
	}

	/**
	 * 
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pelicula(String titulo, int anno, String genero, int duracion, String status, int rating, String comentario) {
		this.titulo = titulo;
		this.anno = anno;
		this.genero = genero;
		this.duracion = duracion;
		this.status = status;
		this.rating = rating;
		this.comentario = comentario;
	}
}