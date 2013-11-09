package fiuba.algo3.implementacion;

import java.util.ArrayList;



public class Mapa {
    
	private ArrayList<ArrayList<Celda>> celdas;
	private int filas;
	private int columnas;

	public Mapa(Coordenada unaDimension) {
		this.celdas = new ArrayList<ArrayList<Celda>>();
		this.filas = unaDimension.getY();
		this.columnas = unaDimension.getX();
		for (int x = 0; x<this.columnas ; x++){
			ArrayList<Celda> columna = new ArrayList<Celda>();
			for (int y = 0; y < this.filas; y++){
				columna.add(new Celda(this, new Coordenada(x, y)));
			}
			this.celdas.add(columna);            
    	}
	}

	public int getCantidadDeFilas() {
		return this.filas;
	}

	public int getCantidadDeColumnas() {
		return this.columnas;
	}

	public Celda getCeldaEn(Coordenada unaCoordenada) {
		ArrayList<Celda> fila = this.celdas.get(unaCoordenada.getX());
		return fila.get(unaCoordenada.getY());
	}
	
	public boolean coordenadaValida(Coordenada unaCoordenada) {
		return (unaCoordenada.getX() < this.getCantidadDeFilas() && unaCoordenada.getX() >= 0) &&
			(unaCoordenada.getY() < this.getCantidadDeColumnas() && unaCoordenada.getY() >= 0);
		}
}	