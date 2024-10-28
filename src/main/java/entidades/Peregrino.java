package entidades;

import java.util.List;

public class Peregrino {
	//campos de la clase con las especificaciones del esquema
	private Long id;
	private String nombre;
	private String nacionalidad;	
	//campo de conexion con el objeto carnet
	private Carnet carnet_peregrino;
	
	//campo de conexion con el objeto Estancia(por medio de una coleccion)
	private List<Estancia> estancias;
	
	//campo de conexion con el objeto Paradas(por medio de una coleccion)
	private List<Parada> paradas;
	
	//para que el peregrino funcione como un usuario hasta que se incluya la base de datos metere un campo de enum que se encargara de diferenciar a donde tiene acceso el peregrino
	private Usuarios tipo_usuario;
		
	//constructor por defecto
	public Peregrino() {		
	}

	//constructor usando todos los argumentos
	public Peregrino(Long id, String nombre, String nacionalidad,Carnet carnet_peregrino,List<Estancia> estancias,Usuarios cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.carnet_peregrino= carnet_peregrino;
		this.estancias= estancias;
		this.tipo_usuario=cargo;
	}
	
	public Peregrino(Long id, String nombre, String nacionalidad, Carnet carnet_peregrino, List<Estancia> estancias,
			List<Parada> paradas, Usuarios tipo_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.carnet_peregrino = carnet_peregrino;
		this.estancias = estancias;
		this.paradas = paradas;
		this.tipo_usuario = tipo_usuario;
	}

	//getter y setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}	
	//getters y setters de la conexion con el carnet
	public Carnet getCarnet_peregrino() {
		return carnet_peregrino;
	}
	public void setCarnet_peregrino(Carnet carnet_peregrino) {
		this.carnet_peregrino = carnet_peregrino;
	}
	//getters y setters de la conexion con el estancias
	public List<Estancia> getEstancias() {
		return estancias;
	}
	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}
	
	//getter de la enum
	public Usuarios getCargo() {
		return tipo_usuario;
	}
	public void setCargo(Usuarios cargo) {
		this.tipo_usuario = cargo;
	}
	
	//getters y setters de la coleccion
	public List<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}
	
	//metodo to string(por defecto aun sin ser modificado)
	@Override
	public String toString() {
		return "Peregrino [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
}
