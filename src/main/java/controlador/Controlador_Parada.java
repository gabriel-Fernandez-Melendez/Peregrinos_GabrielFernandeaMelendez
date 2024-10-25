package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import entidades.CredencialesUsuario;
import entidades.Parada;
import entidades.Peregrino;
import entidades.Usuarios;

public class Controlador_Parada {
	//direccion donde guardar el archivo de fichero
	//C:\Users\gabo\eclipse-workspace\gabo
	
	public static void ExportarParadas(Parada parada) {
		String path = "FicherosPeregrino/paradas.dat";
		File f = new File(path);
		FileOutputStream exp_bin;
		ObjectOutputStream exp_obj;		
		try {
			exp_bin = new FileOutputStream(f);
			exp_obj = new ObjectOutputStream(exp_bin);
			exp_obj.writeObject((Parada)parada);
			exp_obj.flush();
			System.out.println("se guardo la parada con exito!");
			exp_bin.close();
			exp_obj.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean validar_usuario_Administrador(CredencialesUsuario cred) {
		boolean val =true;
		if(cred.getTipo_usuario()==Usuarios.Administrador_General) {
			System.out.println("es usted el administrador: "+cred.getNombre());
				val=true;		
		}
		else {
			System.out.println("usted no es un administrador de parada ,ingrese las credenciales de un administrador");
			val=false;
		}
		return val;
	}
	//crear primero el metodo de importar exportar paradas.dat
	public Parada NuevaParada(CredencialesUsuario cred) {
		Parada parada =new Parada();
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
	
		
		
		return parada;
		
	}
}
