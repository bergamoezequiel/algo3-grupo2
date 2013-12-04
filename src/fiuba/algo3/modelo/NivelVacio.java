package fiuba.algo3.modelo;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.Llegada;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Vehiculo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
public class NivelVacio extends Nivel{		
	
	public NivelVacio (Vehiculo unVehiculo, Juego juego){	
		this.nombre = "Nivel Vacio";
		this.movimientosLimites = 1000;
		this.puntajePorMovimientoSobrante = 0;
		this.juegoActual = juego;
		this.mapa = new Mapa (4, 4);
		this.conductor = new Conductor(unVehiculo, new Derecha(), 6);
		this.getConductor().addObserver(this);

		mapa.getCeldaEn(new Coordenada(7,6)).agregarContenido(new Llegada());
		mapa.getCeldaEn(new Coordenada(0,0)).agregarContenido(this.conductor);
	}
	

}