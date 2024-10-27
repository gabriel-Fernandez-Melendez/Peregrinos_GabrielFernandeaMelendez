package controlador;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import entidades.CredencialesUsuario;
import entidades.Parada;
import entidades.Peregrino;
import entidades.Usuarios;

public class Controlador_Parada {
	 
	public static void ExportarParadas(Parada parada) {
		ArrayList<Parada> paradas=  ListaDeParadas();
        paradas.add(parada);
        FileOutputStream fos;
        try {
            //importante , esta linea ha de tener siempre al final un true para que pueda escribir mas objetos en su interior
            fos = new FileOutputStream("FicherosPeregrino/paradas.dat");
            ObjectOutputStream objeto = new ObjectOutputStream(fos);
            objeto.writeObject(paradas);
            System.out.println("se ha guardado la parada!");
            objeto.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Parada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
	
    @SuppressWarnings("unchecked")
	public static ArrayList<Parada> ListaDeParadas(){
    	ArrayList<Parada> paradas= new ArrayList<Parada>();
		FileInputStream fi;		
		try {
			fi= new FileInputStream("FicherosPeregrino/paradas.dat");			
			if(fi.available()>0) {
				ObjectInputStream buff = new ObjectInputStream(fi);
				paradas =(ArrayList<Parada>) buff.readObject();
			}	
			else {
				System.out.println("lista vacia");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	return paradas;   	
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
	public static boolean NuevaParada() {
		boolean val= false;
		Parada parada =new Parada();
		CredencialesUsuario responsable = new CredencialesUsuario();
		Scanner scan =new Scanner(System.in);
		String nombre_parada;
		String nombre_responsable;
		String cantraseña_responsable=" ";
		char region=' ';
		do {	
		System.out.println("Usted esta creando una  nueva parada");		
		System.out.println("inserte el nombre de la parada");
		nombre_parada = scan.nextLine();		
		System.out.println("ahora introduzca las credenciales del que sera responsable de la parada");
		System.out.println("introduzca el nombre: ");
		nombre_responsable = scan.nextLine();
		responsable.setNombre(nombre_responsable);
		if(nombre_responsable!=null) {
		System.out.println("introduzca la contraseña: ");
		 cantraseña_responsable = scan.nextLine();
		 responsable.setClave(cantraseña_responsable);
		}
		System.out.println("inserte el caracter de la region donde esta la parada");
		region = scan.next().charAt(0);
		//validamos el usuario
			
		//sobre escribimos el objeto ahora con los campos que faltaban
		responsable= Controlador_CredencialesUsuario.UsuarioValido_AdminParada(responsable);
		//conprieba que sea superior a 0 el id
		if(responsable.getId()<=0) {
			val=false;
			System.out.println("el if es" + responsable.getId());
		}
		else {
			val = true;
			System.out.println("el if es" + responsable.getId());
		}
		} while (!val);
		//validamos la parada
		parada.setNombre(nombre_parada);
		parada.setRegion(region);
		parada=ValidadorParadas(parada);
		parada.setResponsable_parada(nombre_responsable);
		//lo esporto a los ficheros desde el propio metodo
		ExportarParadas(parada);
		Controlador_CredencialesUsuario.EscribirCredenciales(responsable);
		//siempre sera true por que mientras no lo sea se vuelve al bucle
		return val;		
	}
	
	public static Parada ValidadorParadas(Parada p) {
		long id;
		ArrayList<Parada> paradas= new ArrayList<Parada>();
		paradas= ListaDeParadas();
		for(Parada par:paradas) {
			if(par.getNombre().equalsIgnoreCase(p.getNombre())&&par.getRegion()==p.getRegion()) {
				System.out.println("los datos de esta parada ya estan registrados");
				break;
			}
			}
		//asi calculamos el id
				System.out.println("los datos son correctos, se incluira la parada: "+p.getNombre());
				id =(long) ((paradas.size())+1);
				p.setId(id);

			
	
		return p;
	}
}
