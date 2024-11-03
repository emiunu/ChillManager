package Principal;

public class Libro {

	private int isbn;
	private String titulo;
	private String autor;
	private int anno;
	private String status;
	private int rating;
	private String comentario;

	public Libro(int isbn, String titulo, String autor, int anno, String status, int rating, String comentario) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anno = anno;
		this.status = status;
		this.rating = rating;
		this.comentario = comentario;
	}

	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnno() {
		return this.anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String toString() {
		return "『 Isbn: " + this.isbn +" | "+ "Titulo: " + this.titulo +" | "+ "Autor: " + this.autor +" | "+ "Año: " + this.anno  +" | "+ "Status: "+ this.status +" | " + "Rating: " + this.rating + " | " + "Comentario: " + this.comentario + "』";
	}

}