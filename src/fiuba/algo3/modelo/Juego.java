package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;

import fiuba.algo3.modelo.vehiculos.*;

public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private Nivel nivelActual;
	private Usuario usuarioActual;
	private Hashtable<Integer, String> indiceNiveles;

	private int nroNivelActual;
	private TablaDePuntuaciones tablaDePuntuaciones;
	private int puntajeAcumulado;
	
	public Juego (){
		this.indiceNiveles = new Hashtable<Integer, String>();
		this.tablaDePuntuaciones = new TablaDePuntuaciones();
		this.usuarios = new ArrayList<Usuario>();
		this.tablaDePuntuaciones = TablaDePuntuaciones.leerXml();
		
	}
	
	public void iniciarPartida(Usuario unUsuario, Vehiculo tipoDeVehiculo){
		this.usuarioActual = unUsuario;
		this.puntajeAcumulado = 0;
		
		this.nroNivelActual = 1;
		String ruta="./src/archivos/nivelVacio.xml";
		this.indiceNiveles.put(1, ruta);//falta hacerle llegar el juego al nivel
		ruta="./src/archivos/nivelFacil.xml";
		this.indiceNiveles.put(2, ruta);
		ruta="./src/archivos/nivelModerado.xml";
		this.indiceNiveles.put(3, ruta);
		ruta="./src/archivos/nivelDificil.xml";
		this.indiceNiveles.put(4, ruta);
		ruta="./src/archivos/nivelMuyDificil.xml";
		this.indiceNiveles.put(5, ruta);
		
		this.setNivelActual(Nivel.CargarNivelXml(this.indiceNiveles.get(this.nroNivelActual)));
		this.nivelActual.setJuego(this);
		nivelActual.getConductor().cambiarDeVehiculo(tipoDeVehiculo);
	}
	
	public void agregarUsuario(Usuario unUsuario){
		if(!this.usuarios.contains(unUsuario)){
			this.usuarios.add(unUsuario);
		}
	}

	public void setNivelActual(Nivel unNivel){
		this.nivelActual = unNivel;
	}
	
	public Nivel getNivelActual(){
		return this.nivelActual;
	}
	
	public int getNroNivelActual(){
		return this.nroNivelActual;
	}
	
	public Usuario getUsuarioActual(){
		return this.usuarioActual;
	}
	
	public void setUsuarioActual(Usuario unUsuario){
		this.usuarioActual = unUsuario;
	}

	public void pasarDeNivel(){
		this.puntajeAcumulado += this.nivelActual.getPuntaje();
		this.nroNivelActual += 1;
		Nivel nivelSiguiente =Nivel.CargarNivelXml(this.indiceNiveles.get(this.nroNivelActual));
		this.nivelActual = nivelSiguiente;
		this.nivelActual.setJuego(this);
		
		this.setChanged();
		this.notifyObservers("Juego Pasa De Nivel");
	}
	
	public void gano(){		
		this.nroNivelActual = 0;
		nivelActual = null;
		
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), this.puntajeAcumulado));
		System.out.println("Ganaste, tu puntuacion es " + this.puntajeAcumulado);
		this.tablaDePuntuaciones.guardar();
		
		this.setChanged();
		this.notifyObservers("Gano");
	}
	
	public int getPuntajeAcumulado(){
		return this.puntajeAcumulado;
	}
	
	
	public Element serializar(){
		Element nodoJuego= new Element("juego");
		nodoJuego.setAttribute("nroNivelActual", Integer.toString(this.getNroNivelActual()));
		nodoJuego.setAttribute("puntajeAcumulado", Integer.toString(this.getPuntajeAcumulado()));
		return nodoJuego;
	}
	
	public void guardar(){
		  try{
		  Document docjuego =new Document();
		  System.out.println("Se creo el doc");
		  Element juego = this.serializar();
		  
		  docjuego.setRootElement(juego); 
		  XMLOutputter xmlOutput =new XMLOutputter(Format.getPrettyFormat());
		  xmlOutput.output(docjuego,new FileOutputStream(new File("./src/archivos/partida.xml")));
		  System.out.println("Se escribio el archivo");
		  
		  }
		  catch(Exception ex){
		   ex.printStackTrace();
		  }
	}
	
	public void perdio() {
		this.nroNivelActual = 0;
		nivelActual = null;
		
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), this.puntajeAcumulado));
		System.out.println("Perdiste, tu puntuacion es " + this.puntajeAcumulado);
		this.tablaDePuntuaciones.guardar();
		
		this.setChanged();
		this.notifyObservers("Perdio");
	}
	
	public int getCantidadDeUsuarios(){
		return this.usuarios.size();
	}
	
	public void conductorAlcanzoLaLlegadaDelNivelActual() {
		this.nivelActual.getConductor().deleteObservers();
		
		if (this.nroNivelActual == this.indiceNiveles.size()){
			this.gano();
		}
		else{
			this.pasarDeNivel();
		}

	}
}

