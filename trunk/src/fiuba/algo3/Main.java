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

		
		Juego unJuego = new Juego(); //Observado
		/* CODIGO PARA GENERAR LOS ARCHIVOS DE LOS NIVELES  http://www.youtube.com/watch?v=HWoVxBcvy1s
		 NivelFacil nivel = new NivelFacil(Moto.getInstancia(), juego);
		nivel.guardar();*/
	ControlPorTeclado unControl = new ControlPorTeclado(unJuego);
		
		Ventana unaVentana = new Ventana(unJuego, unControl); //Observador
		unJuego.addObserver(unaVentana);
		
	    new VentanaInicial(unJuego);
	}
}