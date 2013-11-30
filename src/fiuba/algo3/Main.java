package fiuba.algo3;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.vista.Ventana;

public class Main {
	public static void main(String args[]){
		Juego unJuego = new Juego(); //Observado
		ControlPorTeclado unControl = new ControlPorTeclado(unJuego);
		
		Ventana unaVentana = new Ventana(unJuego, unControl); //Observador
		unJuego.addObserver(unaVentana);
	}
}