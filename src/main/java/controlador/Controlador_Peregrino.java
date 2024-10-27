package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import entidades.*;


public class Controlador_Peregrino {

	//incluire aqui el metodo cuando tenga las credenciales
	public static Peregrino NuevoPeregrino() {
		boolean val =false;
		Peregrino p = new Peregrino();
		do {
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese su nombre para almecenarla en el sistema");
		String nombre =scan.nextLine();
		System.out.println("ingrese su contraseña para almecenarla en el sistema");
		String contraseña =scan.nextLine();
		CredencialesUsuario cred=new CredencialesUsuario();
		cred.setNombre(nombre);
		cred.setClave(contraseña);
		cred.setTipo_usuario(Usuarios.Peregrino);
		val=Controlador_CredencialesUsuario.Credenciales_Nuevas(cred);
		if(val) {
		System.out.println("se introdujo el nuevo peregrino,ya puede acceder con su nuevo perfil!");	
		}
		
		} while (!val);
		return p;
	}
	
	//metodo obsoleto con la inclusion de credencialesusuario
	public static ArrayList<Peregrino> LeerCredenciales() {
		ArrayList<Peregrino> usuarios = new ArrayList<Peregrino>();
		String path = "credenciales.txt";
		FileReader lec = null;
		File fich = new File(path);
		BufferedReader buffer = null;
		
		try {
			lec = new FileReader(fich);
			buffer = new BufferedReader(lec);
			String lectura;
			while((lectura = buffer.readLine()) != null) {
				String[] campos_usuario =lectura.split("\\s+");
				String nombre = String.valueOf(campos_usuario[0]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//esta linea de momento no hace nasa pero  no se disparan los errores
		return usuarios;
	}
}
