package Principal;

public class Juego {

	private String nombre;
	private int fecha;
	private int dlc;
	private String status;
	private int rating;
	private String comentario;

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getDlc() {
		return this.dlc;
	}

	/**
	 * 
	 * @param dlc
	 */
	public void setDlc(int dlc) {
		this.dlc = dlc;
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