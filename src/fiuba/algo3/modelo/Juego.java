package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.modelo.vehiculos.*;


public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private int puntaje;
	private Nivel nivelActual;
	private ArrayList<Nivel> niveles; 
	
	public Juego (){
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("Samus Aran"));
		
		this.puntaje = 0;
		
		this.nivelActual = new NivelMedio(new Moto());		
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void agregarUsuario(Usuario unUsuario){
		//Falta verificar que no exista un usuario con el mismo nombre previamente
		this.usuarios.add(unUsuario);
	}
	
	public Nivel getNivelActual(){
		return this.nivelActual;
	}

}

