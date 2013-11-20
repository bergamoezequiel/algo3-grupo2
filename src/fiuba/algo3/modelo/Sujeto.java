package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.vista.Observador;

public class Sujeto {
	
	private ArrayList<Observador> observadores;
	
	public void agregar (Observador unObservador){
		this.observadores.add(unObservador);
	}
	
	public void eliminar (Observador unObservador){
		this.observadores.remove(unObservador);
	}
	
	protected void notificar(){
		Iterator<Observador> i = observadores.iterator();
		
		while ( i.hasNext() ){
			i.next().actualizar();
		};
			
	}

}
