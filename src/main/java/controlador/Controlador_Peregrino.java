package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import Utilidades.Utilidades;
import entidades.*;
import vista.Menus;


public class Controlador_Peregrino {

	//incluire aqui el metodo cuando tenga las credenciales
	public static Peregrino NuevoPeregrino() {
		boolean val =false;
		Scanner scan = new Scanner(System.in);
		Peregrino p = new Peregrino();
		CredencialesUsuario cred=new CredencialesUsuario();
		do {		
		System.out.println("ingrese su nombre para almecenarla en el sistema");
		String nombre =scan.nextLine();
		System.out.println("ingrese su contraseña para almecenarla en el sistema");
		String contraseña =scan.nextLine();
		
		cred.setNombre(nombre);
		cred.setClave(contraseña);
		cred.setTipo_usuario(Usuarios.Peregrino);
		cred=Controlador_CredencialesUsuario.Credenciales_Nuevas(cred);
		if(cred.getId()==0) {
			val=false;
		}
		else {
			val=true;
		}
		if(val) {
		System.out.println("las credenciales son validas");	
		p.setNombre(nombre);
		p.setId(cred.getId());
		}
		else {
			System.out.println("introduzca unas credenciales validas");
			val=false;
		}	
		} while (!val);
		val=true;//cambiar esto a false una vez terminado
		do {HashMap<String, String> paises = new HashMap<String, String>();
			ArrayList<String> claves = new ArrayList<String>();
			paises=SeleccionDePais();
			claves=Ordenarlista(paises);
			int i =1;
			for(String pais:claves) {
				//de esta forma esta ordenado de manera alfabetica y no se ve la clave si no solo el nombre del pais
				System.out.println(i+" - "+paises.get(pais));
				i++;
			}
			System.out.println("ingrese el numero del pais al que pertenece: ");
			int pais_num=scan.nextInt();
			//le quitamos 1 para pillar el que metio por pantalla el usuario
			String valor_pais =claves.get((pais_num)-1);
			System.out.println("es su pais el "+paises.get(valor_pais));
			val=Utilidades.leerBoolean();
			if(val) {
				p.setNacionalidad(valor_pais);
			}
			else {
				val=false;
			}
			} while (!val);
		val=false;
		do {		
			ArrayList<Parada> paradas = new ArrayList<Parada>();
			paradas=Controlador_Parada.ListaDeParadas();
			int z=1;
			for(Parada par:paradas) {
				System.out.println(z+" -"+par.toString());
			}
			System.out.println("ingrese el numero de la parada en la que es: ");
			int parada_num=scan.nextInt();
			Parada valor_parada=paradas.get((parada_num)-1);
			System.out.println("es su parada la: "+valor_parada.toString());
			val=Utilidades.leerBoolean();
			if(val) {
				ArrayList<Parada> paradas_ = new ArrayList<Parada>();
				paradas_.add(valor_parada);
				p.setParadas(paradas_);
			}
			else {
				val=false;
			}
		} while (!val);
		Carnet carnet=new Carnet();
		carnet=Controlador_Carnet.NuevoCarnet(p);
		p.setCarnet_peregrino(carnet);
		//CREAMOS UNA INSTANCIA DE MOMENTO QUE NO HAY UNA BASE DE DATOS PARA QUE LA INTRODUZCA EN EL XML
		Parada parada=new Parada(1L,"tineo",'T',"fernando");
		Estancia estanciaprueba = new Estancia(2l,LocalDate.now(),true,null,parada);
		ArrayList<Estancia> estancias =new ArrayList<Estancia>();
		estancias.add(estanciaprueba);
		p.setEstancias(estancias);
		System.out.println("se a añadido al peregrino con: "+p.getId()+" "+p.getNombre()+" "+p.getNacionalidad()+" "+carnet.getFecha_creacion()+" "+p.getParadas().get(0).getNombre()+" "+p.getParadas().get(0).getRegion());
		Menus.MenuLogin(cred,p);//tengo que crear aun el carnet
		return p;
	}
	
	//tengo que caviarlo a que me devuelva algo (seguramente un  string)
	public static HashMap<String, String> SeleccionDePais() {
		HashMap<String, String> paises = new HashMap<String, String>();
		System.out.println("Escoja su pais de la siguiente lista: ");
		try {
			DocumentBuilder builder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document documento = builder.parse(new File("FicherosPeregrino/paises.xml"));
			documento.getDocumentElement().normalize();
			NodeList empleados = documento.getElementsByTagName("pais");
			for (int i = 0; i < empleados.getLength(); i++) {
				 Node emple = empleados.item(i);
				 if(emple.getNodeType() == Node.ELEMENT_NODE){
					 Element elemento = (Element) emple;//Obtenemos los elementos del nodo
					 if(emple.getNodeType() == Node.ELEMENT_NODE){
						 //System.out.print("id: "+extraer_datos_pais("id",elemento));
						 //System.out.println("pais: "+extraer_datos_pais("nombre", elemento));
						 paises.put(extraer_datos_pais("id",elemento),extraer_datos_pais("nombre", elemento));
					 //System.out.println("----------------------------------");
					 }
				 }
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paises;
	}	
	private static String extraer_datos_pais(String etiqueta, Element elem){
		 NodeList nodo =
		elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		 Node valorNodo = (Node) nodo.item(0);
		 return valorNodo.getNodeValue();
		 }
	
	public static ArrayList<String> Ordenarlista(HashMap<String, String> pa){
		ArrayList<String> clave = new ArrayList<String>(pa.keySet());
		//Set set=pa.keySet();
		//Iterator it =set.iterator();
		Collections.sort(clave);
		return clave;
	}
	
	public static void ExportarXml(Peregrino p) {
		 
		try {
			DocumentBuilderFactory fabricaConstructorDocumento = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructorDocumento = fabricaConstructorDocumento.newDocumentBuilder();
			DOMImplementation implementacion = constructorDocumento.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "carnet", null);
            Element carnet = documento.getDocumentElement();
            //creamos los elementos
            Element id, fechaexp, expedidoen,peregrino,nombre,nacionalidad,hoy,distanciatotal,paradas,parada,orden,nombre_parada,region,estancias,estancia,id_estancia,fecha_estancia,parada_estancia,vip;
            //y el contenido de los elementos(misma cantidad de texto que elementos, aunque lo mas probable no los use todos)
            Text id_val, fechaexp_val, expedidoen_val,peregrino_val,nombre_val,nacionalidad_val,hoy_val,distanciatotal_val,paradas_val,parada_val,orden_val,nombre_val_val,region_val,estancias_val,estancia_val,id_estancia_val,fecha_estancia_val,parada_estancia_val,vip_val;
            //creamos los elementos en el orden del ejemplo de la tarea
            //elemento id
            id =documento.createElement("id");
            carnet.appendChild(id);
            id_val = documento.createTextNode(p.getId().toString());
            id.appendChild(id_val);
            
            
            expedidoen=documento.createElement("fechaexp");
            carnet.appendChild(expedidoen);
            fechaexp_val=documento.createTextNode(p.getCarnet_peregrino().getFecha_creacion().toString());
            expedidoen.appendChild(fechaexp_val);
            
            peregrino=documento.createElement("peregrino");
            carnet.appendChild(peregrino);
            nombre=documento.createElement("nombre");
            peregrino.appendChild(nombre);
            nombre_val = documento.createTextNode(p.getNombre().toString());
            nombre.appendChild(nombre_val);
            nacionalidad=documento.createElement("nacionalidad");
            peregrino.appendChild(nacionalidad);
            nacionalidad_val = documento.createTextNode(p.getNacionalidad());
            nacionalidad.appendChild(nacionalidad_val);
            
            hoy=documento.createElement("hoy");
            carnet.appendChild(hoy);
            hoy_val=documento.createTextNode(LocalDate.now().toString());
            hoy.appendChild(hoy_val);
            
            distanciatotal=documento.createElement("distanciatotal");
            carnet.appendChild(distanciatotal);
            distanciatotal_val=documento.createTextNode(p.getCarnet_peregrino().getDistancia().toString());
            distanciatotal.appendChild(distanciatotal_val);
            
            
            paradas=documento.createElement("paradas");
            carnet.appendChild(paradas);
            parada=documento.createElement("parada");
            paradas.appendChild(parada);
            orden=documento.createElement("orden");
            parada.appendChild(orden);
            //de momento no hace falta pero para el futuro habria que hacer un  bucle for que recorra y haga varios nodos parada en funcion de las paradas dentro de la lista(se implementara mas adelante)
            orden_val=documento.createTextNode(p.getParadas().get(0).getId().toString());
            orden.appendChild(orden_val);
            nombre_parada=documento.createElement("nombre");
            parada.appendChild(nombre_parada);
            nombre_val_val=documento.createTextNode(p.getParadas().get(0).getNombre());
            nombre_parada.appendChild(nombre_val_val);
            region=documento.createElement("region");
            parada.appendChild(region);
            region_val=documento.createTextNode(String.valueOf(p.getParadas().get(0).getRegion())); //casteo de un  char a string
            region.appendChild(region_val);
            
            estancias=documento.createElement("estancias");
            carnet.appendChild(estancias);
            //aqui hariamos lo mismo que se implementara en el futuro para que pueda haber mas estancias,se recorrera la lista de peregrino con un  bucle for (aun por implementar)
            estancia=documento.createElement("estancia");
            estancias.appendChild(estancia);
            id_estancia=documento.createElement("id");
            estancia.appendChild(id_estancia);
            id_estancia_val=documento.createTextNode(p.getEstancias().get(0).getId().toString());
            id_estancia.appendChild(id_estancia_val);
            fecha_estancia=documento.createElement("fecha");
            estancia.appendChild(fecha_estancia);
            fecha_estancia_val=documento.createTextNode(p.getEstancias().get(0).getFecha().toString());
            fecha_estancia.appendChild(fecha_estancia_val);
            //para el vip hay que hacer un if para confirmar si el booleano esta como true(no hace falta poner el "==")
            if(p.getEstancias().get(0).isVip()) {
            	vip=documento.createElement("vip");
            	estancia.appendChild(vip);
            }
            
            Source fuente = new DOMSource(documento);
            File fichero = new File("FicherosPeregrino/"+p.getNombre()+".xml");
            Result resultado = new StreamResult(fichero);
            TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fabricaTransformador.newTransformer();
            transformador.transform(fuente, resultado);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         

	}
	
}
