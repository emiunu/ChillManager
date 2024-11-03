package Principal;

public class Serie {

	private String titulo;
	private int temporadas;
	private int capitulos;
	private int temporadaActual;
	private int capituloActual;
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

	public int getTemporadas() {
		return this.temporadas;
	}

	/**
	 * 
	 * @param temporadas
	 */
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getCapitulos() {
		return this.capitulos;
	}

	/**
	 * 
	 * @param capitulos
	 */
	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}

	public int getTemporadaActual() {
		return this.temporadaActual;
	}

	/**
	 * 
	 * @param temporadaActual
	 */
	public void setTemporadaActual(int temporadaActual) {
		this.temporadaActual = temporadaActual;
	}

	public int getCapituloActual() {
		return this.capituloActual;
	}

	/**
	 * 
	 * @param capituloActual
	 */
	public void setCapituloActual(int capituloActual) {
		this.capituloActual = capituloActual;
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