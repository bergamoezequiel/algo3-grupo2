package fiuba.algo3.implementacion;

import java.util.ArrayList;

public class Mapa {
	
	
	private ArrayList<ArrayList<Celda>> celdas;
	private int columnas;
	private int filas;
	
	/*
	 * OJO:  COLUMNAS x CELDAS son las dimensiones.
	 * ¿No serian COLUMNAS X FILAS? (PIPPO)
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
	
	public void setVehiculoEnPosicion(Vehiculo unVehiculo, int columna, int fila){
		this.getCeldaEnPos(columna, fila).setVehiculo(unVehiculo);
	}
	
	public Vehiculo getVehiculoEnPosicion (int columna, int fila){
		return ( this.getCeldaEnPos(columna, fila).getVehiculo() );
	}
	
}