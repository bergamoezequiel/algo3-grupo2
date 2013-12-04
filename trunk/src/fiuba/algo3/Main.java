package fiuba.algo3;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.vista.Ventana;
import fiuba.algo3.vista.VentanaInicial;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.*;

public class Main {
	public static void main(String args[]){

		
		TablaDePuntuaciones.leerXml();
		String ruta = "./src/archivos/NivelVacio.xml";
		Nivel.CargarNivelXml(ruta);
	/*	CODIGO PARA GENERAR UN EJEMPLO DE LA TABLA
	    TablaDePuntuaciones tabla =new TablaDePuntuaciones();
		Usuario usuario1 = new Usuario("juancito");
		ElementoTablaDePuntuacion elemento1 = new ElementoTablaDePuntuacion(usuario1, 18);
		tabla.agregar(elemento1);
		Usuario usuario2= new Usuario("pepito");
		ElementoTablaDePuntuacion elemento2 = new ElementoTablaDePuntuacion(usuario2, 25);
		tabla.agregar(elemento2);
		Usuario usuario3= new Usuario("lolita");
		ElementoTablaDePuntuacion elemento3 = new ElementoTablaDePuntuacion(usuario3, 35);
		tabla.agregar(elemento3);
		tabla.guardar();
		*/
	
		// CODIGO PARA GENERAR LOS ARCHIVOS DE LOS NIVELES  http://www.youtube.com/watch?v=HWoVxBcvy1s
		 //Nivel nivel = new NivelMuyDificil(Moto.getInstancia(), new Juego());
		 //nivel.guardar();
		
		Juego unJuego = new Juego(); //Observado
		new VentanaInicial(unJuego);
		
	}
}