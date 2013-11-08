package fiuba.algo3.implementacion;

import java.util.ArrayList;


public class Mapa {
        
	private ArrayList<ArrayList<Celda>> celdas;
	private int filas;
	private int columnas;


	public Mapa(int filas, int columnas) {
    	this.celdas = new ArrayList<ArrayList<Celda>>();
    	for (int i =0; i<filas ; i++){
    		ArrayList<Celda> fila = new ArrayList<Celda>();
    		for (int j = 0; j < columnas; j++){
    			fila.add(new Celda(new Posicion(i, j)));
    		}
    		this.celdas.add(fila);
    		this.columnas = columnas;
    		this.filas = filas;             
    	}
            
    }           
    
	public int getCantidadDeFilas() {
		return this.filas;
	}
    
	public int getCantidadDeColumnas() {
    	return this.columnas;
	}
   
	public Celda getCeldaEnPosicion(Posicion unaPosicion) {
		ArrayList<Celda> col = this.celdas.get(unaPosicion.getFila());
		return col.get(unaPosicion.getColumna());
	}
    
}		