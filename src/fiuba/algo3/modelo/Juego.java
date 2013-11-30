package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.modelo.vehiculos.*;

public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private Nivel nivelActual;
	private Usuario usuarioActual;
	private ArrayList<Nivel> niveles; 
	//private int puntajeFinalConductor;
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
		Usuario unUsuario =  new Usuario("Samus Aran");
		this.usuarios.add(unUsuario);
		this.setUsuarioActual(unUsuario);
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

	public void pasarDeNivel(){
		Nivel nivelSiguiente = this.niveles.get(this.niveles.indexOf(this.nivelActual)+1);
		this.nivelActual = nivelSiguiente;
		
		this.setChanged();
		this.notifyObservers("Juego Pasa De Nivel");
	}
	
	public void gano(){		
		int puntaje = 0;
		for (int i = 0; i <= this.niveles.indexOf(this.nivelActual); i++){
			puntaje += niveles.get(i).getPuntaje();
		}
		nivelActual = null;
		
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), puntaje));
		System.out.println("Gano, su puntaje es: " + puntaje);
	}
	
	public void perdio() {
		int puntaje = 0;
		for (int i = 0; i < this.niveles.indexOf(this.nivelActual); i++){
			puntaje += niveles.get(i).getPuntaje();
		}
		nivelActual = null;
		
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), puntaje));
		System.out.println("Perdio, su puntaje es: " + puntaje);
	}
	
	public void conductorAlcanzoLaLlegadaDelNivelActual() {
		this.nivelActual.getConductor().deleteObservers();
		
		if (this.niveles.indexOf(this.nivelActual)+1 == this.niveles.size()){
			this.gano();
		}
		else{
			this.pasarDeNivel();
		}

	}
}

