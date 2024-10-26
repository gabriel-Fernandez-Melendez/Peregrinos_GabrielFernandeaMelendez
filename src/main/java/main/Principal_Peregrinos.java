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
		
		  Parada p=new Parada(1L,"humanes",'o',"fernando");
		  Parada p1=new Parada(2L,"efg",'U',"fernando");
		  Parada p2=new Parada(3L,"humanes",'U',"fernando"); Parada p3=new
		  Parada(4L,"humaadsfvdnes",'k',"fernando"); Parada p4=new
		  Parada(5L,"huvasdfvdmanes",'U',"fernaetyhndo"); Parada p5=new
		  Parada(6L,"humafvvaanes",'U',"fernando");
		  Controlador_Parada.ExportarParadas(p);
		  Controlador_Parada.ExportarParadas(p1);
		  Controlador_Parada.ExportarParadas(p2);
		  Controlador_Parada.ExportarParadas(p3);
		  Controlador_Parada.ExportarParadas(p4);
		  Controlador_Parada.ExportarParadas(p5);
		 
		

			ArrayList<Parada> parada = new ArrayList<Parada>();
			try {
				parada=Controlador_Parada.LectoresParadas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Parada par : parada){
				par.toString();
			
	
	}

	}
	}
