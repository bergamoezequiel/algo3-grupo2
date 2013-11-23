package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;


public class Sujeto {
	
	static ArrayList<Observer> observadores;
	
	public void agregar (Observer unObservador){
		observadores.add(unObservador);
	}
	
	public void eliminar (Observer unObservador){
		observadores.remove(unObservador);
	}
	
	protected void notificar(){
		Iterator<Observer> i = observadores.iterator();
		
		while ( i.hasNext() ){
			i.next().update(null, i);
		};
			
	}

}

