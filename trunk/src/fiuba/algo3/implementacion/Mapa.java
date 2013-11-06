package fiuba.algo3.implementacion;

import java.util.ArrayList;

public class Mapa {
	
	
	private ArrayList<ArrayList<Celda>> celdas;
	private int filas;
	private int columnas;
	
	/*
	 *   Lo cambie a Filas x Columnas ( mas natural) (era Columnas x Filas antes)
	 * 
	 */
	public Mapa(int filas, int columnas) {
		this.celdas = new ArrayList<ArrayList<Celda>>();
		for (int i =0; i<filas ; i++){
			ArrayList<Celda> fila = new ArrayList<Celda>();
			for (int j = 0; j < columnas; j++){
				fila.add(new Celda());
			}
			this.celdas.add(fila);
			
			this.columnas = columnas;
			this.filas = filas;		
		}
		
	}

	public Celda getCeldaEnPos(int fila, int columna) {
		ArrayList<Celda> col = this.celdas.get(fila);
		return col.get(columna);
	}
		
	
	public int getCantidadDeFilas() {
		return this.filas;
	}
	
	public int getCantidadDeColumnas() {
		return this.columnas;
	}
	
	public void setVehiculoEnPosicion(Vehiculo unVehiculo, int fila, int columna){
		this.getCeldaEnPos(fila, columna).setVehiculo(unVehiculo);
	}
	
	public Vehiculo getVehiculoEnPosicion (int fila, int columna){
		return ( this.getCeldaEnPos(fila, columna).getVehiculo() );
	}
	
}
