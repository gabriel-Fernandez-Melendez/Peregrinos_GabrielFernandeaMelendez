package controlador;

import java.util.Scanner;

import entidades.Parada;
import entidades.Peregrino;
import entidades.Usuarios;

public class Controlador_Parada {
	//direccion donde guardar el archivo de fichero
//C:\Users\gabo\eclipse-workspace\gabo
	
	public void validar_usuario(Peregrino p) {
		if(p.getCargo()!=Usuarios.Administrador_General) {
			System.out.println("usted no cuenta con los permisos para poder acceder a este campo ");
						
		}
		else {
			
		}
	}
	public Parada NuevaParada(Peregrino p) {
		Parada parada =new Parada();
		if(p.getCargo()!=Usuarios.Administrador_General) {
		System.out.println("Usted esta creando una  nueva parada");
		Scanner scan =new Scanner(System.in);
		System.out.println("inserte el nombre de la parada");
		String nombre = scan.nextLine();
		parada.setNombre(nombre);
		System.out.println("inserte el caracter de la region donde esta la parada");
		char region = scan.next().charAt(0);
		parada.setRegion(region);
		
		//este metodo continuara cuando tengamos el metodo de incluir datos en credencias
		scan.close();
		}
		
		
		return parada;
		
	}
}
