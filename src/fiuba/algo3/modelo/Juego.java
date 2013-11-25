package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.vista.Ventana;


public class Juego extends Observable {

	private Mapa mapa;
	private ArrayList<Usuario> usuarios;
	private Conductor conductor;    
	private int puntaje;
	private Pozo pozo;
	private Piquete piquete;
	private CambioDeVehiculo cambioDeVehiculo;
	
	public Juego (){
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("Samus Aran"));
		
		this.puntaje = 0;
		this.mapa = new Mapa (8, 8);
		this.conductor = new Conductor(new Auto());     
		this.pozo = new Pozo();
		this.piquete= new Piquete();
		this.pozo = new Pozo();
		this.piquete= new Piquete();
		this.cambioDeVehiculo = new CambioDeVehiculo();
		
		this.mapa.getCeldaEn(new Coordenada(8,8)).agregarContenido(this.conductor);
		this.mapa.getCeldaEn(new Coordenada(8,9)).agregarContenido(this.pozo);
		this.mapa.getCeldaEn(new Coordenada(1,2)).agregarContenido(this.piquete);
		this.mapa.getCeldaEn(new Coordenada(2,3)).agregarContenido(this.cambioDeVehiculo);
		
	}

	public Mapa getMapa(){
		return this.mapa;
	}
	
	public Conductor getConductor(){
		return this.conductor;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void agregarUsuario(Usuario unUsuario){
		this.usuarios.add(unUsuario);
	}

}

