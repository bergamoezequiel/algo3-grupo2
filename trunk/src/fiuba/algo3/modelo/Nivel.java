package fiuba.algo3.modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Observable;
import java.util.Observer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;

public abstract class Nivel implements Observer {
	/*
	 * PRECONDICION:
	 * Debe existir un mapa.
	 * Debe existir un conductor en el mapa.
	 * Debe existir una llegada en el mapa.
	 */
	protected String nombre;
	protected Mapa mapa;
	protected Conductor conductor;
	protected int movimientosLimites;
	protected Juego juegoActual;
	protected int puntajePorMovimientoSobrante; 
	
	public Mapa getMapa(){
		return this.mapa;
	}
	
	public Conductor getConductor(){
		return this.conductor;
	}
	
	public int getMovimientosLimites(){
		return this.movimientosLimites;
	}
	
	public int getMovimientosRestantes(){
		return this.movimientosLimites - this.conductor.getMovimientos();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntaje(){
		return (getMovimientosRestantes() * puntajePorMovimientoSobrante);
	}
	
	public Juego getJuegoActual(){
		return juegoActual;
	}
	
	public int getPuntajePorMovimientosSobrantes(){
		return this.puntajePorMovimientoSobrante;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (getMovimientosRestantes() <= 0){
			this.juegoActual.perdio();
		}
		
		else if (this.conductor.getEncontroLlegada()){
			this.juegoActual.conductorAlcanzoLaLlegadaDelNivelActual();
		}
	}
	public Element serializar(){
		Element nodoNivel= new Element("nivel");
		nodoNivel.setAttribute("Nombre", this.getNombre());
		nodoNivel.setAttribute("MovimientosLimites", Integer.toString(this.movimientosLimites));
		nodoNivel.setAttribute("PuntajePorMovimientoSobrante", Integer.toString(this.puntajePorMovimientoSobrante));
		nodoNivel.addContent(this.mapa.serializar());
		return nodoNivel;
		
	}
	

	public void guardar(){
		try{
		Document docMapa =new Document();
		System.out.println("Se creo el doc");
		Element nivel = this.serializar();
		
		docMapa.setRootElement(nivel);
		System.out.println("se agrego el mapa al documento");	
		XMLOutputter xmlOutput =new XMLOutputter(Format.getPrettyFormat());
		xmlOutput.output(docMapa,new FileOutputStream(new File("./src/archivos/nivelFacil.xml")));
		System.out.println("Se escribio el archivo");
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
}
	
}
