package fiuba.algo3;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.vista.Ventana;
import fiuba.algo3.vista.VentanaInicial;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;
public class Main {
	public static void main(String args[]){
/* CODIGO UTILIZADO PARA GUARDAR MAPAS EN ARCHIVOS XML
		Mapa mapa = new Mapa (4, 4);
		Conductor conductor = new Conductor(Moto.getInstancia(), new Derecha(), 6);
		mapa.getCeldaEn(new Coordenada(7,6)).agregarContenido(new Llegada());
		
		
		
		mapa.getCeldaEn(new Coordenada(0,8)).agregarContenido(conductor);
		//Snorlaxs
				mapa.getCeldaEn(new Coordenada(0,1)).agregarContenido(new Snorlax());
				mapa.getCeldaEn(new Coordenada(1,4)).agregarContenido(new Snorlax());
				mapa.getCeldaEn(new Coordenada(6,1)).agregarContenido(new Snorlax());
				mapa.getCeldaEn(new Coordenada(6,3)).agregarContenido(new Snorlax());

				//Piquete
				mapa.getCeldaEn(new Coordenada(5,0)).agregarContenido(new Piquete());
			
				//Cambios de Vehiculo
				mapa.getCeldaEn(new Coordenada(3,0)).agregarContenido(new CambioDeVehiculo());
				mapa.getCeldaEn(new Coordenada(0,5)).agregarContenido(new CambioDeVehiculo());
				
				//Controles Policiales
				mapa.getCeldaEn(new Coordenada(3,2)).agregarContenido(new ControlPolicial());
			
				//Pozos
				mapa.getCeldaEn(new Coordenada(1,8)).agregarContenido(new Pozo());
				
				//Sorpresas Desfavorables
				mapa.getCeldaEn(new Coordenada(7,8)).agregarContenido(new SorpresaDesfavorable());
				mapa.getCeldaEn(new Coordenada(5,6)).agregarContenido(new SorpresaDesfavorable());

				//Sorpresa Favorables
				mapa.getCeldaEn(new Coordenada(3,6)).agregarContenido(new SorpresaFavorable());
		mapa.guardar();
		*/
		
		Juego unJuego = new Juego(); //Observado
		ControlPorTeclado unControl = new ControlPorTeclado(unJuego);
		
		Ventana unaVentana = new Ventana(unJuego, unControl); //Observador
		unJuego.addObserver(unaVentana);
		
	    new VentanaInicial(unJuego);
	}
}