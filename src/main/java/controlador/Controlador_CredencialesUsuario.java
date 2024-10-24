package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import entidades.CredencialesUsuario;
import entidades.Peregrino;

public class Controlador_CredencialesUsuario {

	
	public static void EscribirCredenciales(CredencialesUsuario credenciales) {
		//puede dar problemas el p
		String path = "FicherosPeregrino/credenciales.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;		
		try {
			escritor = new FileWriter(fichero,true);			
			buffer = new PrintWriter(escritor);
			buffer.print(credenciales.toString());
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
