package Principal;

public class Libro {

	private int isbn;
	private String titulo;
	private String autor;
	private int anno;
	private String status;
	private int rating;
	private String comentario;

	public int getIsbn() {
		return this.isbn;
	}

	/**
	 * 
	 * @param isbn
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

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

	public String getAutor() {
		return this.autor;
	}

	/**
	 * 
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
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

}