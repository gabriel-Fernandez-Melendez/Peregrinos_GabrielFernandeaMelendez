package entidades;

import java.time.LocalDate;

public class Estancia {
	//campos de la clase con las especificaciones del esquema
	private Long id;
	private LocalDate fecha;
	private boolean vip;
	//constructor por defecto
	public Estancia() {
		
	}
	//constructor usando todos los argumentos
	public Estancia(Long id, LocalDate fecha, boolean vip) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.vip = vip;
	}
	//getter y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	//metodo to string(por defecto aun sin ser modificado)
	@Override
	public String toString() {
		return "Estancia [id=" + id + ", fecha=" + fecha + ", vip=" + vip + "]";
	}
	
	
}
