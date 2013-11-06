package fiuba.algo3.implementacion;

public class Posicion {
	
	private int fila;
	private int columna;
	
	public Posicion(){
		this.fila= 0;
		this.columna= 0;
		
	}
	
	public void setFila(int fila){
		this.fila= fila;
	}
	
	public void setColumna (int columna){
		this.columna = columna;
	}
	
	public int getFila (){
		return this.fila;
	}
	
	public int getColumna (){
		return this.columna;
	}

}
