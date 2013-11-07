package fiuba.algo3.implementacion;

public class Posicion {
	
	private int fila;
	private int columna;
	
	public Posicion(int unaFila, int unaColumna){
		this.fila = unaFila;
		this.columna = unaColumna;	
	}
	
	
	public void setFila(int unaFila){
		this.fila = unaFila;
	}
	
	public void setColumna(int unaColumna){
		this.columna = unaColumna;
	}
	
	public void setPosicion(int unaFila, int unaColumna){
		this.setFila(unaFila);
		this.setColumna(unaColumna);
	}
	
	public int getFila(){
		return this.fila;
	}
	
	public int getColumna(){
		return this.columna;
	}

}
