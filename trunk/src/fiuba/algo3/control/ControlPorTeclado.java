package fiuba.algo3.control;

import java.awt.event.*;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.vehiculos.Conductor;

public class ControlPorTeclado {

	private Conductor conductor;

	public ControlPorTeclado(Conductor unConductor) {
		this.conductor = unConductor;
	}
	
	public KeyListener getKeyListener(){
		return new KeyListener() {
			public void keyPressed(KeyEvent e) {  	    
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int location = e.getKeyCode();

				switch(location){
					case KeyEvent.VK_DOWN:
						conductor.avanzarEnDireccion(new Abajo());

					case KeyEvent.VK_UP:
						conductor.avanzarEnDireccion(new Arriba());

					case KeyEvent.VK_LEFT:
						conductor.avanzarEnDireccion(new Izquierda());

					case KeyEvent.VK_RIGHT:
						conductor.avanzarEnDireccion(new Derecha());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {				
			}	
		};
	}
}
