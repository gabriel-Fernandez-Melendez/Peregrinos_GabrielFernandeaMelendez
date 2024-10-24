package main;

import entidades.Peregrino;
import entidades.Usuarios;
import controlador.*;

public class Principal_Peregrinos {

	public static void main(String[] args) {
		
		Peregrino p = new Peregrino();
		p.setCargo(Usuarios.Peregrino);
		p.setNombre("gabo");
		p.setContraseña("gabo");
		p.setId(Long.valueOf(1));
		Controlador_Peregrino.EscribirCredenciales(p);
	}

}
