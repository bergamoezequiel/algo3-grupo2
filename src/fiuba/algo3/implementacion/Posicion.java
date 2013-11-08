package fiuba.algo3.implementacion;

public class Posicion {
	
	private int fila;
	private int columna;
	
	public Posicion(int unaFila, int unaColumna){
		this.fila = unaFila;
		this.columna = unaColumna;	
	}
	
	public int getFila(){
		return this.fila;
	}
	
	public int getColumna(){
		return this.columna;
	}

	public boolean equals (Object unObjeto) {
		boolean boEquals = false;
		if (unObjeto instanceof Posicion) {
			Posicion unaPosicion = (Posicion) unObjeto;
			if ( this.getFila() == unaPosicion.getFila() && this.getColumna() == unaPosicion.getColumna() ) {
				boEquals = true;
			}
		}
		return boEquals;
	}
}
