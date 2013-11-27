package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

import fiuba.algo3.modelo.mapa.Celda;

public class TablaDePuntuaciones {
	
	private ArrayList<ElementoTablaDePuntuacion> elementosTablaDePuntuacion;
	
	public TablaDePuntuaciones(){
		this.elementosTablaDePuntuacion = new ArrayList<ElementoTablaDePuntuacion>();
	}
	
	public void agregar(ElementoTablaDePuntuacion unElementoTablaDePuntuacion){
		this.elementosTablaDePuntuacion.add(unElementoTablaDePuntuacion);
		Collections.sort(this.elementosTablaDePuntuacion);
		Collections.reverse(this.elementosTablaDePuntuacion);
	}
	
	public int size(){
		return this.elementosTablaDePuntuacion.size();
	}
	
	public ElementoTablaDePuntuacion elementoEn(int unaPosicion){
		return this.elementosTablaDePuntuacion.get(unaPosicion);
	}
	
}
