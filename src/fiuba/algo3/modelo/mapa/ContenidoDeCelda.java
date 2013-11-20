package fiuba.algo3.modelo.mapa;

public abstract class ContenidoDeCelda {
	
	protected Celda celda;
	
	public Celda getCelda(){
		return this.celda;
	}
	
	public abstract void setCelda(Celda unaCelda);
	
	public void setCeldaNull(){
		this.celda = null;
	}
}
