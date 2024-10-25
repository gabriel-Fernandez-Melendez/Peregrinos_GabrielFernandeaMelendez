package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.CredencialesUsuario;
import entidades.Usuarios;

public class Controlador_CredencialesUsuario {

	//guarda las credenciales del usuario
	public static void EscribirCredenciales(CredencialesUsuario credenciales) {
		//puede dar problemas el p
		String direc = "FicherosPeregrino/credenciales.txt";
		File fichero = new File(direc);
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
	//almacena en una coleccion la lista de credenciales del fichero
	public static ArrayList<CredencialesUsuario> ListaDeCredenciales(){
		ArrayList<CredencialesUsuario> usuarios = new ArrayList<CredencialesUsuario>();
		String direc = "FicherosPeregrino/credenciales.txt";
		File fichero = new File(direc);
		FileReader lector = null;		
		BufferedReader buffer = null;
		
		try {
			lector= new FileReader(fichero);
			buffer= new BufferedReader(lector);
			String info;
			while((info = buffer.readLine()) != null){
				String[] credenciales = info.split("\\s+");
				String nombre = String.valueOf(credenciales[0]);
				String clave = String.valueOf(credenciales[1]);
				String tipo_de_usuario = String.valueOf(credenciales[2]);
				Usuarios usur= TipoDeUsuario(tipo_de_usuario);
				Long idPersona = Long.valueOf(credenciales[3]);
				CredencialesUsuario cred = new CredencialesUsuario(nombre,clave,usur,idPersona);
				usuarios.add(cred);			
			}
			 buffer.close();
		     lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	//metodo para diferenciar el tipo de credenciales del usuario del fichero 
	public static Usuarios TipoDeUsuario(String s){
		Usuarios tipo_usuario=null;
		for(Usuarios u: Usuarios.values()){
			if(u.getTipoDeUsuario().equalsIgnoreCase(s)) {
				tipo_usuario=u;
			}
		}
		return tipo_usuario;
	}
	//buscar una forma de validar un  usuario
	public static boolean Credenciales_Nuevas(CredencialesUsuario usur) {
		boolean val = false;
		ArrayList<CredencialesUsuario> usuarios = new ArrayList<CredencialesUsuario>();
		usuarios=ListaDeCredenciales();
		for(CredencialesUsuario cred : usuarios) {
			if(usur.getNombre().equalsIgnoreCase(cred.getNombre()) && usur.getClave().equalsIgnoreCase(cred.getClave())) {
				System.out.println("estas credenciales ya estan en el sistema, introduzca unas diferentes");
				val =false;
				break;
			}
			else {
				val=true;
			}
		}
		if(val) {
			System.out.println("las credenciales son validas, se le registrara en el sistema"+usur.getNombre());
			EscribirCredenciales(usur);
		}		
		return val;
	}
	public static boolean ValidarLogin() {
		boolean val = false;
		//aun  no se si este sera necesario 
		
		return val;
	}
	//crear un metodo que haga lo contrario a credenciales nuevas y valide el usuario
	public static CredencialesUsuario login() {
		boolean val =false;
		CredencialesUsuario log=null;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("introduzca su nombre de usuario");
		String nombre=scan.nextLine();
		System.out.println("introduzca su clave de usuario");
		String clave=scan.nextLine();
		ArrayList<CredencialesUsuario> usuarios = new ArrayList<CredencialesUsuario>();
		usuarios=ListaDeCredenciales();
		for(CredencialesUsuario cred : usuarios) {
			if(nombre.equalsIgnoreCase(cred.getNombre()) && clave.equalsIgnoreCase(cred.getClave())) {
				System.out.println("bienvenido usuario: "+cred.getNombre());
				log = new CredencialesUsuario(cred.getNombre(),cred.getClave(),cred.getTipo_usuario(),cred.getId());
				val=true;
				break;
			}
			
		}
		if(!val) {
		System.out.println("el usuario no existe, porfavor introduzca un usuario valido");
			val=false;
			}
		}while(!val);

		scan.close();
		return log;
	}
	
	
	
}
