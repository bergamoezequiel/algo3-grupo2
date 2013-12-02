package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;

import fiuba.algo3.modelo.vehiculos.*;

public class Juego extends Observable {

	private ArrayList<Usuario> usuarios;  
	private Nivel nivelActual;
	private Usuario usuarioActual;
	private Hashtable<Integer, Nivel> indiceNiveles;

	private int nroNivelActual;
	private TablaDePuntuaciones tablaDePuntuaciones;
	private int puntajeAcumulado;
	
	public Juego (){
		this.indiceNiveles = new Hashtable<Integer, Nivel>();
		this.tablaDePuntuaciones = new TablaDePuntuaciones();
		this.usuarios = new ArrayList<Usuario>();

	}
	
	public void iniciarPartida(Usuario unUsuario, Vehiculo tipoDeVehiculo){
		this.usuarioActual = unUsuario;
		this.puntajeAcumulado = 0;
		
		this.nroNivelActual = 1;
		
		this.indiceNiveles.put(1, new NivelVacio(tipoDeVehiculo, this));
		this.indiceNiveles.put(2, new NivelFacil(tipoDeVehiculo, this));
		this.indiceNiveles.put(3, new NivelModerado(tipoDeVehiculo, this));
		this.indiceNiveles.put(4, new NivelDificil(tipoDeVehiculo, this));
		this.indiceNiveles.put(5, new NivelMuyDificil(tipoDeVehiculo, this));
		
		this.setNivelActual(this.indiceNiveles.get(this.nroNivelActual));
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
		this.puntajeAcumulado += this.nivelActual.getPuntaje();
		this.nroNivelActual += 1;
		Nivel nivelSiguiente = this.indiceNiveles.get(this.nroNivelActual);
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
		
		if (this.nroNivelActual == this.indiceNiveles.size()){
			this.gano();
		}
		else{
			this.pasarDeNivel();
		}

	}
}

