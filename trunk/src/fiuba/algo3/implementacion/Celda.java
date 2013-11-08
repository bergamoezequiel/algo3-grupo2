package fiuba.algo3.implementacion;

public class Celda{
	
	private Posicion posicion;
	private ContenidoDeCelda contenido;
	
	public Celda(Posicion unaPosicion){
		this.posicion = unaPosicion;
		this.contenido = null;
	}
	
	public ContenidoDeCelda getContenido () {
		return this.contenido;
	}

	public Object getPosicion () {
		return this.posicion;
	}
	
	public void setObjeto(ContenidoDeCelda unObjeto) {
		this.contenido = unObjeto;
	}

	public void desligarseDeSuObjeto() {
		this.contenido = null;
	}
}