package fiuba.algo3.implementacion;


public class Celda{
	
	private Coordenada coordenada;
	private ContenidoDeCelda contenido;
	private Mapa mapa;
	
	public Celda(Mapa unMapa, Coordenada unaCoordenada){
		this.coordenada = unaCoordenada;
		this.contenido = null;
		this.mapa = unMapa;
	}
	
	public ContenidoDeCelda getContenido () {
		return this.contenido;
	}

	public Coordenada getCoordenada () {
		return this.coordenada;
	}
	
	public void agregarContenido(ContenidoDeCelda unContenido) {
		this.contenido = unContenido;
		this.contenido.setCelda(this);
	}

	public void quitarContenido() {
		this.contenido.setCelda(null);
		this.contenido = null;
	}

	public Celda getVecino(Direccion unaDireccion) {
		Coordenada coordenadaVecina = this.getCoordenada().sumar(unaDireccion.getDireccionComoCoordenada());
		Celda celdaVecina = this.mapa.getCeldaEn(coordenadaVecina);
		return celdaVecina;
	}
}