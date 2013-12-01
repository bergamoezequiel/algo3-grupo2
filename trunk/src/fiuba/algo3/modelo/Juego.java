package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Observable;

import fiuba.algo3.modelo.vehiculos.*;

public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private Nivel nivelActual;
	private Usuario usuarioActual;
	private ArrayList<Nivel> niveles; 
	private int nroNivelActual;
	private TablaDePuntuaciones tablaDePuntuaciones;
	private int puntajeAcumulado;
	
	public Juego (){
		this.tablaDePuntuaciones = new TablaDePuntuaciones();
		this.usuarios = new ArrayList<Usuario>();
		this.niveles = new ArrayList<Nivel>();
		this.niveles.add(new NivelVacio(Moto.getInstancia(), this));
		this.niveles.add(new NivelFacil(Moto.getInstancia(), this));
		this.niveles.add(new NivelModerado(Moto.getInstancia(), this));
		this.niveles.add(new NivelDificil(Moto.getInstancia(), this));
		this.niveles.add(new NivelMuyDificil(Moto.getInstancia(), this));
		this.setNivelActual(niveles.get(0));
		this.nroNivelActual = 0;
		this.puntajeAcumulado = 0;
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
		this.puntajeAcumulado += niveles.get(this.nroNivelActual).getPuntaje();
		this.nroNivelActual += 1;
		Nivel nivelSiguiente = this.niveles.get(this.nroNivelActual);
		this.nivelActual = nivelSiguiente;
		
		this.setChanged();
		this.notifyObservers("Juego Pasa De Nivel");
	}
	
	public void gano(){		
		this.nroNivelActual = 0;
		nivelActual = null;
		
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), this.puntajeAcumulado));
		System.out.println("Ganaste, tu puntuacion es " + this.puntajeAcumulado);
	}
	
	public void perdio() {
		this.nroNivelActual = 0;
		nivelActual = null;
		
		this.tablaDePuntuaciones.agregar(new ElementoTablaDePuntuacion(this.getUsuarioActual(), this.puntajeAcumulado));
		System.out.println("Perdiste, tu puntuacion es " + this.puntajeAcumulado);
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

