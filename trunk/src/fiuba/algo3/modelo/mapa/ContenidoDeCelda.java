package fiuba.algo3.modelo.mapa;

import java.util.Observable;

public abstract class ContenidoDeCelda extends Observable {
	
	protected Celda celda;
	
	public Celda getCelda(){
		return this.celda;
	}
	
	public abstract void setCelda(Celda unaCelda);
	
	public void setCeldaNull(){
		this.celda = null;
	}
}
