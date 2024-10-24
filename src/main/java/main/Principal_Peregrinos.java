package main;

import entidades.CredencialesUsuario;
import entidades.Peregrino;
import entidades.Usuarios;
import controlador.*;

public class Principal_Peregrinos {

	public static void main(String[] args) {
		
		CredencialesUsuario cred = new CredencialesUsuario("gabo","gabo",Usuarios.Peregrino,1);
		Controlador_CredencialesUsuario.EscribirCredenciales(cred);
		System.out.println("funciona");
	}

}
