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
	//direccion donde guardar el archivo de fichero
	//C:\Users\gabo\eclipse-workspace\gabo
	
	/*
	 * public static void ExportarParadas(Parada parada) { String path =
	 * "FicherosPeregrino/paradas.dat"; File f = new File(path); FileOutputStream
	 * exp_bin;
	 * 
	 * try { exp_bin = new FileOutputStream(f,true); ObjectOutputStream exp_obj =
	 * new ObjectOutputStream(exp_bin); exp_obj.writeObject(parada);
	 * exp_obj.reset(); System.out.println("se guardo la parada con exito!");
	 * 
	 * boolean val = false; while (!val) { exp_bin.close(); exp_obj.close(); val =
	 * true; } } catch (FileNotFoundException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 */
	public static void ExportarParadas(Parada parada) {
        FileOutputStream fos;
        try {
            //importante , esta linea ha de tener siempre al final un true para que pueda escribir mas objetos en su interior
            fos = new FileOutputStream("paradas.dat", true);
            ObjectOutputStream objeto = new ObjectOutputStream(fos);
            objeto.writeObject(parada);
            System.out.println("llega aqui");
            objeto.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Parada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
	
	 public static ArrayList<Parada> LectoresParadas() throws IOException {
	        ArrayList<Parada> paradas = new ArrayList<Parada>();
	        FileInputStream fis = null;
	        DataInputStream entrada = null;
	        String aux;
	        try {
	            fis = new FileInputStream("paradas.dat");
	            entrada = new DataInputStream(fis);
	            while (entrada.read() > -1) {
	                long id = entrada.readLong();  //se lee  un entero del fichero    
	                String nom =entrada.readUTF();
	                char e  =entrada.readChar();
	                String per =entrada.readUTF();
	                System.out.println(id + nom + e + per);  //se muestra en pantalla
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        } catch (EOFException e) {
	            System.out.println("Fin de fichero");
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (fis != null) {
	                    fis.close();
	                }
	                if (entrada != null) {
	                    entrada.close();
	                }
	            } catch (IOException e) {
	                System.out.println(e.getMessage());
	            }
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
