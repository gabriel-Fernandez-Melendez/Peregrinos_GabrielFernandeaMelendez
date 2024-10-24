package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

import entidades.*;


public class Controlador_Peregrino {

	//incluire aqui el metodo 
	public Peregrino NuevoPeregrino() {
		Peregrino p = new Peregrino();
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese su nombre para almecenarla en el sistema");
		String nombre =scan.nextLine();
		System.out.println("ingrese su contraseña para almecenarla en el sistema");
		String contraseña =scan.nextLine();
		return p;
		
	}
	
	public static void EscribirCredenciales(Peregrino p) {
		//puede dar problemas el pegar contenido y que traiga mas de un separador entre ellas
		String path = "FicherosPeregrino/responsables.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;		
		try {
			escritor = new FileWriter(fichero,true);			
			buffer = new PrintWriter(escritor);
			buffer.print(p.getNombre()+" "+p.getContraseña()+" "+p.getCargo().getTipoDeUsuario()+" "+p.getId()+" \n");
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
