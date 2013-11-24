package fiuba.algo3;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.vista.PantallaDelNivel;
import fiuba.algo3.vista.Ventana;

public class Main {
	public static void main(String args[]){
		Juego unJuego = new Juego(); //Observado
		Ventana unaVentana = new Ventana(unJuego); //Observador
		unJuego.addObserver(unaVentana);
	}
}
