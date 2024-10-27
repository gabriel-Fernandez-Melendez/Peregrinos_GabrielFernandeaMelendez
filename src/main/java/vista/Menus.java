package vista;

import java.util.Scanner;

import controlador.Controlador_CredencialesUsuario;
import controlador.Controlador_Peregrino;
import entidades.CredencialesUsuario;
import entidades.Usuarios;

public class Menus {

	
	public static void MenuPrincipalInvitado() {
		boolean val =true;
		int elecc = -1;
		do {
					
		do {
			System.out.println("Bienvenido invitado, que desea hacer en el sistema: ");
			System.out.println("1 - registrarse como peregrino");
			System.out.println("2 - Logearse");
			System.out.println("0 - salir del programa");
			System.out.println("-------------------------");			
			Scanner scan =new Scanner(System.in);
			elecc=scan.nextInt();
			if(elecc<0 || elecc>2) {
				System.out.println("el numero no es valido, introduzca un numero valido");
				val=false;
			}	
			else {
				val=true;
			}
		} while (!val);
		//dudas de si esta linea puede romper el programa
		val=false;
		switch (elecc) {
		case 1:
			Controlador_Peregrino.NuevoPeregrino();
			break;
		case 2:
			CredencialesUsuario cred;
			cred=Controlador_CredencialesUsuario.login();
			//menu de la enum
			break;
		case 0:
			System.out.println("seguro que quiere salir del programa?");
			//meter el validador booleano

		default:
			System.out.println("algo a salido mal , intentelo de nuevo");
			break;
		}
		
		
		
		
		
				} while (val);
	}
	
	
	public static void MenuLogin(CredencialesUsuario cred) {
			Usuarios usu = cred.getTipo_usuario();
			switch (usu) {
			case Invitado:
				//por aqui nunca pasa , solo pasa por aqui antes de crear un  perfil pero por orden de codig lo incluyo
				break;
			case Responsable_Parada:
				break;
			case Peregrino:
				break;
			case Administrador_General:
				break;

			default:
				break;
			}
		}
	
	
}
