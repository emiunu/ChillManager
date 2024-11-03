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

	public Serie(String titulo, int temporadas, int capitulos, int temporadaActual, int capituloActual, String status, int rating, String comentario){
		this.titulo = titulo;
		this.temporadas = temporadas;
		this.capitulos = capitulos;
		this.temporadaActual = temporadaActual;
		this.capituloActual = capituloActual;
		this.status = status;
		this.rating = rating;
		this.comentario = comentario;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTemporadas() {
		return this.temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getCapitulos() {
		return this.capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}

	public int getTemporadaActual() {
		return this.temporadaActual;
	}

	public void setTemporadaActual(int temporadaActual) {
		this.temporadaActual = temporadaActual;
	}

	public int getCapituloActual() {
		return this.capituloActual;
	}

	public void setCapituloActual(int capituloActual) {
		this.capituloActual = capituloActual;
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

	public String mostrarSerie() {
		return "『 Título: "+ this.titulo +" | Temporadas: "+ this.temporadas +" | Capítulos: "+ this.capitulos +" | Temporada Actual: "+ this.temporadaActual +" | Capítulo Actual (de temporada): "+ this.capituloActual +" | Estado: "+ this.status +" | Rating: "+ this.rating +" | Comentarios: "+ this.comentario +" 』";
	}

}