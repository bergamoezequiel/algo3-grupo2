package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.vista.Ventana;


public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private int puntaje;
	private Nivel nivelActual;
	private ArrayList<Nivel> niveles; 
	
	public Juego (){
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("Samus Aran"));
		
		this.puntaje = 0;
		
		this.nivelActual = new Nivel(0, new Auto());		
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void agregarUsuario(Usuario unUsuario){
		this.usuarios.add(unUsuario);
	}
	
	public Nivel getNivelActual(){
		return this.nivelActual;
	}

}

