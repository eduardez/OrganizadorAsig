package dominio;

import java.util.Date;

public class Tarea {

	private Date fecha;
	private long idTiempo;
	private String texto;
	private boolean anual;

	public Tarea() {
	}

	public Tarea(Date fecha, String texto, boolean anual) {
		this.fecha = fecha;
		this.idTiempo = generarIdTiempo(fecha);
		this.texto = texto;
		this.anual=anual;
	}

	public long generarIdTiempo(Date fecha) {
		int al=(int) ((Math.random() * 91));
		return al*fecha.getTime();
	}

	public Date getFecha() {
		
		return fecha;
	}

	public void setFecha(Date param) {
		this.fecha = param;
	}

	public long getIdTiempo() {
		return idTiempo;
	}

	public void setIdTiempo(long l) {
		this.idTiempo = l;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isAnual() {
		return anual;
	}

	public void setAnual(boolean anual) {
		this.anual = anual;
	}

	@Override
	public String toString() {
		return "Tarea [fecha=" + fecha + ", idTiempo=" + idTiempo + ", texto=" + texto + "]";
	}

}
