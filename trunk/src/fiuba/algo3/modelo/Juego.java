package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.modelo.vehiculos.*;


public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private int puntaje;
	private Nivel nivelActual;
	private Usuario usuarioActual;
	private ArrayList<Nivel> niveles; 
	private int puntajeFinalConductor;
	private boolean conductorLlego;
	
	public Juego (){
		conductorLlego=false;
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("Samus Aran"));
		
		this.puntaje = 0;
		


		this.nivelActual = new NivelFacil(new Moto(),this);		

	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void agregarUsuario(Usuario unUsuario){
		//Falta verificar que no exista un usuario con el mismo nombre previamente
		this.usuarios.add(unUsuario);
	}

	public void setNivelActual(Nivel unNivel){
		this.nivelActual = unNivel;
	}
	
	public Nivel getNivelActual(){
		return this.nivelActual;
	}
	
	public Usuario getUsuarioActual(){
		return this.usuarioActual;
	}
	
	public void setUsuarioActual(Usuario unUsuario){
		this.usuarioActual = unUsuario;
	}
	
	public void vehiculoTerminoConPuntaje(int puntaje){
		this.puntajeFinalConductor=puntaje;
		conductorLlego=true;
		
		
	}
	public boolean conductorLlego(){
		return conductorLlego;
	}
	public int getPuntajeDelConductor(){
		return puntajeFinalConductor;
	}
}

