package Principal;

public class Juego {

	private String nombre;
	private int fecha;
	private int dlc;
	private String status;
	private int rating;
	private String comentario;

	public Juego(String nombre, int fecha, int dlc, String status, int rating, String comentario) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.dlc = dlc;
		this.status = status;
		this.rating = rating;
		this.comentario = comentario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFecha() {
		return this.fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getDlc() {
		return this.dlc;
	}

	public void setDlc(int dlc) {
		this.dlc = dlc;
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
		return "『 Nombre: " + this.nombre +" | "+ "Fecha de lanzamiento: " + this.fecha +" | "+ "DLC: " + this.dlc +" | "+ "Estado: " + this.status + " | " + "Rating: " + this.rating + " | " + "Comentario: " + this.comentario + "』";
	}

}