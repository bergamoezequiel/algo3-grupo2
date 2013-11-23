package fiuba.algo3;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.vista.MainClass;
import fiuba.algo3.vista.Ventana;

public class Main {
	public static void main(String args[]){
		Juego unJuego = new Juego(); //Observado
		Ventana unaVentana = new Ventana(unJuego); //Observador
		//MainClass otraVentana = new MainClass();
		
		unJuego.addObserver(unaVentana);
		/*observado.cambiarMensaje("Cambio 1");
		observado.cambiarMensaje("Cambio 2");
		observado.cambiarMensaje("Cambio 3");*/
	}
}
