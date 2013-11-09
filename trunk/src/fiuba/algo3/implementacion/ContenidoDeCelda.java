package fiuba.algo3.implementacion;

public abstract class ContenidoDeCelda {
	
	private Celda celda;
	
	public Celda getCelda(){
		return this.celda;
	}
	
	public void setCelda(Celda unaCelda){
		this.celda = unaCelda;
	}
}
