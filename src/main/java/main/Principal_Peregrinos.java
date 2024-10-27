package main;

import entidades.CredencialesUsuario;
import entidades.Parada;
import entidades.Peregrino;
import entidades.Usuarios;

import java.io.IOException;
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
		
		/*
		 * Parada p=new Parada(1L,"tineo",'T',"fernando"); Parada p1=new
		 * Parada(2L,"ACDC_Street",'A',"lemmy"); Parada p2=new
		 * Parada(3L,"iron maiden",'I',"alejandro"); Parada p3=new
		 * Parada(4L,"picos de europa",'P',"juana"); Parada p4=new
		 * Parada(5L,"santiago",'U',"santiago"); Parada p5=new
		 * Parada(6L,"posada tineo",'U',"maria"); Controlador_Parada.ExportarParadas(p);
		 * Controlador_Parada.ExportarParadas(p1);
		 * Controlador_Parada.ExportarParadas(p2);
		 * Controlador_Parada.ExportarParadas(p3);
		 * Controlador_Parada.ExportarParadas(p4);
		 * Controlador_Parada.ExportarParadas(p5);
		 */
		  ArrayList<Parada> paradas= new ArrayList<Parada>();
		  paradas=Controlador_Parada.ListaDeParadas();
		  System.out.println("paradas tamaño "+paradas.size());
		  for(Parada per : paradas) {
			  System.out.println("nombre de parada"+ per.getNombre());
		  }
			

	}
	}
