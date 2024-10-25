package main;

import entidades.CredencialesUsuario;
import entidades.Parada;
import entidades.Peregrino;
import entidades.Usuarios;

import java.util.ArrayList;

import controlador.*;

public class Principal_Peregrinos {

	public static void main(String[] args) {
		
		//CredencialesUsuario cred = new CredencialesUsuario("gabo","gabo",Usuarios.Peregrino,1);
		//Controlador_CredencialesUsuario.EscribirCredenciales(cred);
		//System.out.println("funciona");
		//ArrayList<CredencialesUsuario> usuarios = new ArrayList<CredencialesUsuario>();
		//usuarios=Controlador_CredencialesUsuario.ListaDeCredenciales();
		//for(CredencialesUsuario cred :usuarios ) {
		//	System.out.println(cred.toString());
		//}
		//Controlador_CredencialesUsuario.login();
		Parada p=new Parada(1L,"humanes",'U',"fernando");
		Controlador_Parada.ExportarParadas(null);
	}

}
