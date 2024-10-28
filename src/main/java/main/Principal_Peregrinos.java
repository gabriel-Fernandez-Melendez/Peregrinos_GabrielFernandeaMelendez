package main;

import entidades.Carnet;
import entidades.CredencialesUsuario;
import entidades.Estancia;
import entidades.Parada;
import entidades.Peregrino;
import entidades.Usuarios;
import vista.Menus;

import java.awt.Menu;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controlador.*;

public class Principal_Peregrinos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
			Menus.MenuPrincipalInvitado();
	}
	}

//CODIGO DE PRUEBAS DE FUNCIONALIDADES,lo dejo para facilitarme el retocar puntos especificos del codigo en el futuro de ser necesario

//CredencialesUsuario cred = new CredencialesUsuario("gabo","gabo",Usuarios.Peregrino,1);
//Controlador_CredencialesUsuario.EscribirCredenciales(cred);
//System.out.println("funciona");
//ArrayList<CredencialesUsuario> usuarios = new ArrayList<CredencialesUsuario>();
//usuarios=Controlador_CredencialesUsuario.ListaDeCredenciales();
//for(CredencialesUsuario cred :usuarios ) {
//	System.out.println(cred.toString());
//}
//Controlador_CredencialesUsuario.login();


 //Parada parada=new Parada(1L,"tineo",'T',"fernando");
 /*Parada p1=new
  Parada(2L,"ACDC_Street",'A',"lemmy"); Parada p2=new
  Parada(3L,"iron maiden",'I',"alejandro"); Parada p3=new
  Parada(4L,"picos de europa",'P',"juana"); Parada p4=new
  Parada(5L,"santiago",'U',"santiago"); Parada p5=new
  Parada(6L,"posada tineo",'U',"maria"); Controlador_Parada.ExportarParadas(p);
  Controlador_Parada.ExportarParadas(p1);
  Controlador_Parada.ExportarParadas(p2);
  Controlador_Parada.ExportarParadas(p3);
  Controlador_Parada.ExportarParadas(p4);
  Controlador_Parada.ExportarParadas(p5);*/
 		//Controlador_Peregrino.NuevoPeregrino();
//  Carnet c=new Carnet();
//  
//  Estancia e = new Estancia(2l,LocalDate.now(),true,null,parada);
//  List<Estancia> estancias=new ArrayList<Estancia>();
//  estancias.add(e);
//  List<Parada> paradas= new ArrayList<Parada>();
//  paradas.add(parada);
//Peregrino p =new Peregrino(1L,"nombre","londres",c,estancias,paradas,Usuarios.Peregrino);
//c=Controlador_Carnet.NuevoCarnet(p);
//p.setCarnet_peregrino(c);
//Controlador_Peregrino.ExportarXml(p);
//System.out.println("se ejecuto");
 //Menus.Menu_AdminGeneral();

