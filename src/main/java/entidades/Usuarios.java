package entidades;

public enum Usuarios {
	//posibles perfiles que puede tomar el usuario
Invitado("invitado"),Responsable_Parada("Responsable_parada"),Peregrino("Responsable_parada"),Administrador_General("Administrador_general");
	private String cargo;
	//constructor de la enum
	private Usuarios(String s) {
		
	}
	//getter del cargo, un setter no hace falta ya que siempre vamos a sacar los mismos 4 posible cargos plasmados en la enum
	public String getCargo() {
		return cargo;
	}
	
	
}
