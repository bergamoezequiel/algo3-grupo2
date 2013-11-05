package fiuba.algo3.implementacion;

import java.util.ArrayList;

public class Mapa {
	
	
	private ArrayList<ArrayList<Celda>> celdas;
	private int filas;
	private int columnas;
	
	/*
	 * OJO:  COLUMNAS x CELDAS son las dimensiones.
	 * 
	 */
	public Mapa(int columnas, int filas) {
		this.celdas = new ArrayList<ArrayList<Celda>>();
		for (int i =0; i<columnas ; i++){
			ArrayList<Celda> fila = new ArrayList<Celda>();
			for (int j = 0; j < filas; j++){
				fila.add(new Celda());
			}
			this.celdas.add(fila);
			
			this.columnas = columnas;
			this.filas = filas;		
		}
		
	}

	public Celda getCeldaEnPos(int columna, int fila) {
		ArrayList<Celda> col = this.celdas.get(columna);
		return col.get(fila);
	}
		
	
	public int getCantidadDeFilas() {
		return this.filas;
	}
	
	public int getCantidadDeColumnas() {
		return this.columnas;
	}
	
}