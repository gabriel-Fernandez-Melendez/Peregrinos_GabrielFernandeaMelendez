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
