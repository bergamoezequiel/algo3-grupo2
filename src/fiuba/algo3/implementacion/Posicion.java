package fiuba.algo3.implementacion;


public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion(int unaFila, int unaColumna){
		this.x = unaFila;
		this.y = unaColumna;	
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}

	public boolean equals (Object unObjeto) {
		boolean boEquals = false;
		if (unObjeto instanceof Posicion) {
			Posicion unaPosicion = (Posicion) unObjeto;
			if ( this.getX() == unaPosicion.getX() && this.getY() == unaPosicion.getY() ) {
				boEquals = true;
			}
		}
		return boEquals;
	}
}
