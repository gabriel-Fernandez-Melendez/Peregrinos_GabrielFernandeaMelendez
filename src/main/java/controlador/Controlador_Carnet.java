package controlador;
import java.time.LocalDate;

import entidades.*;

public class Controlador_Carnet {

	public static Carnet NuevoCarnet(Peregrino p) {
		Carnet carnet = new Carnet();
		//mismo id para conseguir ambos objetos con la misma clave
		carnet.setId(p.getId());
		carnet.setFecha_creacion(LocalDate.now());
		//esto para probar que escribe en el xml
		carnet.setDistancia(0.5f);
		carnet.setN_vips(0);
		System.out.println("el peregrino de nombre: "+p.getNombre()+" ya tiene el carnet con id: "+carnet.getId());
		return carnet;
		
	}
}
