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
	//private boolean conductorLlego;
	private TablaDePuntuaciones tablaDePuntuaciones;
	
	public Juego (){
		this.tablaDePuntuaciones = new TablaDePuntuaciones();
		
		this.niveles = new ArrayList<Nivel>();
		this.niveles.add(new NivelVacio(new Moto(), this));
		this.niveles.add(new NivelFacil(new Moto(), this));
		this.niveles.add(new NivelModerado(new Moto(), this));
		this.niveles.add(new NivelDificil(new Moto(), this));
		this.niveles.add(new NivelMuyDificil(new Moto(), this));
		this.setNivelActual(niveles.get(0));
		
		//conductorLlego = false;
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("Samus Aran"));
		
		this.puntaje = 0;
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
	
	/*public void vehiculoTerminoConPuntaje(int unPuntaje){
		this.puntajeFinalConductor = unPuntaje;
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), unPuntaje));	
	}*/

	public void perdio() {
		nivelActual = null;
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), this.getPuntaje()));
	}
	
	public void pasoDeNivel() {
		Nivel nivelAnterior = this.nivelActual;
		this.nivelActual = this.niveles.get(1/*this.niveles.indexOf(nivelAnterior)*/);
		System.out.println("pasoDeNivel");
		//this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), this.getPuntaje()));
	}
}

