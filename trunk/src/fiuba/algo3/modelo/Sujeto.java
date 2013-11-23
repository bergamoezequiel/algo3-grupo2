package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;


public class Sujeto {
	
	private ArrayList<Observer> observadores;
	
	public void agregar (Observer unObservador){
		this.observadores.add(unObservador);
	}
	
	public void eliminar (Observer unObservador){
		this.observadores.remove(unObservador);
	}
	
	protected void notificar(){
		Iterator<Observer> i = observadores.iterator();
		
		while ( i.hasNext() ){
			i.next().update(null, i);
		};
			
	}

}

